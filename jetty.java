[Server] 

1. MyServer.java

import org.eclipse.jetty.server.*;

import org.eclipse.jetty.servlet.ServletHandler;

​

public class MyServer {

    public static void main(String[] args) throws Exception {

        new MyServer().start();

    }

​

    public void start() throws Exception {

        Server server = new Server();

        ServerConnector http = new ServerConnector(server);

        http.setHost("127.0.0.1");

        http.setPort(8080);

        server.addConnector(http);

​

        ServletHandler servletHandler = new ServletHandler();

        servletHandler.addServletWithMapping(MyServlet.class, "/*");

        server.setHandler(servletHandler);

​

        server.start();

        server.join();

    }

}

​

2. MyServlet.java

import java.io.BufferedReader;

import java.io.ByteArrayOutputStream;

import java.io.File;

import java.io.FileWriter;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.ObjectOutputStream;

import java.io.PrintWriter;

import java.nio.file.Files;

import java.time.LocalTime;

import java.util.Date;

import java.util.LinkedHashMap;

​

import javax.servlet.ServletException;

import javax.servlet.ServletOutputStream;

import javax.servlet.http.*;

​

public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("Request : "+ req.getRequestURL());

        // 날짜 요청에 대한 응답

        if (req.getRequestURI().equals("/requestDate")) {

            res.setStatus(200);

            res.getWriter().write(new Date().toString());

        }

        // 파일 전송 (byte array로 전송)

        else if (req.getRequestURI().equals("/requestFile")) {

            File file = new File("C:\\temp\\LENA.jpg");

            byte[] fileContent = Files.readAllBytes(file.toPath());

​

            res.setStatus(200); 

            ServletOutputStream stream = res.getOutputStream(); 

            stream.flush();

            stream.write(fileContent);

            stream.flush();

            stream.close();

        }

        // MAP의 Value에 binary를 담았는데, 그냥 전송할 수 없어서 serialize하여 전송

        else if (req.getRequestURI().equals("/requestFile2")) {

            File file = new File("C:\\temp\\LENA.jpg");

            byte[] fileContent = Files.readAllBytes(file.toPath());

​

            LinkedHashMap<String, byte[]> content = new LinkedHashMap<String, byte[]>();

            content.put("file", fileContent);

​

            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();

            ObjectOutputStream out = new ObjectOutputStream(byteOut);

            out.writeObject(content);

​

            res.setStatus(200); 

            ServletOutputStream stream = res.getOutputStream(); 

            stream.flush();

            stream.write(byteOut.toByteArray());   // byte array로 변경하여 전송

            stream.flush();

            stream.close();

        }

    }

​

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("Request : "+ req.getRequestURL());

     

        // Client로부터 전달된 json data 저장

        if (req.getRequestURI().equals("/fileList")) {

            File destFolder = new File("./OUTPUT");

            if(!destFolder.exists()) {

                destFolder.mkdirs(); 

            }

​

            LocalTime currentTime = LocalTime.now();

            String fname = String.format("./OUTPUT/%02d%02d%02d.json", currentTime.getHour(),

                                                                                          currentTime.getMinute(), currentTime.getSecond());

            PrintWriter printWriter = new PrintWriter(new FileWriter(new File(fname)));

            BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));

            String buffer;

            while ((buffer = input.readLine()) != null) {

                printWriter.print(buffer);

            } 

            input.close(); 

            printWriter.close();

​

            res.setStatus(200);

            res.getWriter().write(fname + " saved!");

        }

    }

    // Key는 파일이름으로 사용, Value는 json파일로 저장

    else if (req.getRequestURI().equals("/fileList2")) {

        Gson gson = new Gson();

        System.out.println("Request : "+ req.getRequestURL());

        ////////////////////////////////////////////////

        File destFolder = new File("./SERVER");

        if(!destFolder.exists()) {

            destFolder.mkdirs(); 

        }

​

        BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));

        String buffer;

        StringBuilder sb = new StringBuilder();

        while ((buffer = input.readLine()) != null) {

            sb.append(buffer + "\n");

        }

        String strBody = sb.toString();

        input.close(); 

        JsonObject jObj = gson.fromJson(strBody, JsonObject.class);

        String fileName = jObj.get("FileName").getAsString();

        String fileContent = jObj.get("FileContent").getAsString();

​

        PrintWriter printWriter = new PrintWriter(new FileWriter(new File("./SERVER/"+fileName)));

        printWriter.print(fileContent);

        printWriter.close();

        /////////////////////////////////////////////////

​

        res.setStatus(200);

        res.getWriter().write(fileName + " saved!"); 

    }     

}

​

[Client]

1. DateClient.java (GET, 날짜 요청)

import org.eclipse.jetty.client.HttpClient;

import org.eclipse.jetty.client.api.ContentResponse;

import org.eclipse.jetty.http.HttpMethod;

​

public class DateClient {

    public static void main(String[] args) throws Exception {

        HttpClient httpClient = new HttpClient();

        httpClient.start();

        ContentResponse contentRes = 

                httpClient.newRequest("http://127.0.0.1:8080/requestDate").method(HttpMethod.GET).send();

        System.out.println(contentRes.getContentAsString());

        httpClient.stop();

    }

}

​

2. FileClient.java (POST, 파일목록을 json파일로 전송)

import java.io.File;

import org.eclipse.jetty.client.HttpClient;

import org.eclipse.jetty.client.api.ContentResponse;

import org.eclipse.jetty.client.api.Request;

import org.eclipse.jetty.client.util.StringContentProvider;

import org.eclipse.jetty.http.HttpHeader;

import org.eclipse.jetty.http.HttpMethod;

import com.google.gson.Gson;

import com.google.gson.JsonArray;

import com.google.gson.JsonObject;

​

public class FileClient {

    public static void main(String[] args) throws Exception {

        String strFileList = getFileList();

​

        HttpClient httpClient = new HttpClient();

        httpClient.start();

        Request request = httpClient.newRequest("http://127.0.0.1:8080/fileList").method(HttpMethod.POST);

        request.header(HttpHeader.CONTENT_TYPE, "application/json");

        request.content(new StringContentProvider(strFileList,"utf-8"));

        ContentResponse contentRes = request.send();

        System.out.println(contentRes.getContentAsString());

        httpClient.stop();

    }

​

    private static String getFileList() {

        Gson gson = new Gson();

        JsonObject jo = new JsonObject();

        File directory = new File("./Input");

        jo.addProperty("Folder", "Input");

        JsonArray jarr = new JsonArray();

        File[] fList = directory.listFiles();

        for (File file : fList) {

            jarr.add(file.getName());

        } 

        jo.add("FILES", jarr);

​

        String res = jo.toString();

        return res; 

    }

}

​

3. BinaryFile1.java (GET, 바이너리 파일 전송 요청)

import java.io.ByteArrayInputStream;

import java.io.FileOutputStream;

import java.io.ObjectInputStream;

import java.util.Map;

​

import org.eclipse.jetty.client.HttpClient;

import org.eclipse.jetty.client.api.ContentResponse;

import org.eclipse.jetty.http.HttpMethod;

​

public class BinaryFile {

    public static void main(String[] args) throws Exception {

        HttpClient httpClient = new HttpClient();

        httpClient.start();

        ContentResponse contentRes = 

                httpClient.newRequest("http://127.0.0.1:8080/requestFile").method(HttpMethod.GET).send();

        byte [] myByteArray = contentRes.getContent();

​

        try (FileOutputStream fos = new FileOutputStream("C:\\temp\\test.jpg")) {

            fos.write(myByteArray);

        }

        httpClient.stop();

    }

}

​

4. BinaryFile2.java (GET, Serialize된 MAP을 받아 Key는 파일이름, Value는 파일내용으로 처리하여 저장)

public class BinaryFile2 {

    public static void main(String[] args) throws Exception {

        HttpClient httpClient = new HttpClient();

        httpClient.start();

        ContentResponse contentRes = 

            httpClient.newRequest("http://127.0.0.1:8080/requestFile2").method(HttpMethod.GET).send();

        byte [] myByteArray = contentRes.getContent();

​

        ByteArrayInputStream byteIn = new ByteArrayInputStream(myByteArray);

        ObjectInputStream in = new ObjectInputStream(byteIn);

        Map<String, byte[]> data2 = (Map<String, byte[]>) in.readObject();

​

        try (FileOutputStream fos = new FileOutputStream("C:\\temp\\test.jpg")) {

            fos.write(data2.get("file"));

        }

        httpClient.stop();

    }

}
[출처] [JAVA] Jetty를 이용한 Http 통신 (Server, Client)|작성자 뚝이파파
