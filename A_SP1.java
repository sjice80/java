import java.io.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import com.google.gson.JsonParser;
import com.google.gson.*;

class Score implements Comparable<Score> {
	private String name;
	private int kor;
	private int eng;
	private int math;
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public int compareTo(Score p) {
		if(!this.name.equals(p.getName())) {
			return this.name.compareTo(p.getName());
		}
//		if(this.age>p.getAge())
//			return 1;
//		else if(this.age<p.getAge())
//			return -1;
		 
		return this.name.compareTo(p.getName());
	}
	public void toString(Score p) {
		System.out.println(p.getName());
	}
}

class Grade
{
    private String strName;
    private int Korean;
    private int English;
    private int Math;

    public Grade(String str, int k, int e, int m)
    {
        strName = str;
        Korean = k;
        English = e;
        Math = m;
    }

    public String getName()
    {
        return strName;
    }
    public void setName(String strName)
    {
        this.strName = strName;
    }
    public int getKorean()
    {
        return Korean;
    }
    public void setProjectA(int n)
    {
        Korean = n;
    }
    public int getEnglish()
    {
        return English;
    }
    public void setProjectB(int n)
    {
        English = n;
    }
    public int getMath()
    {
        return Math;
    }
    public void setMath(int n)
    {
        Math = n;
    }
}

class sortByMath implements Comparator<Grade>{
    public int compare(Grade x, Grade y) {
        if (y.getMath() - x.getMath() == 0)
        {
            return x.getName().compareTo(y.getName());
        }
        else
        {
            return y.getMath() - x.getMath();
        }
    }
}

class ThreadClass extends Thread { 
	static ReentrantLock lock = new ReentrantLock();
    String thread_name; 
    public ThreadClass(String name) { 
        this.thread_name = name; 
    } 	
	public void run(){ 
		lock.lock();
		try {
			printNum(thread_name); 
		}
		finally {
			lock.unlock();
		}
	}  
    public static void printNum(String str) {
    	System.out.println(str);
    	for(int i=1; i<=30; i++) {
    		System.out.print(i+" ");
    	}
    	System.out.println();
    }
}

class ProcessThread extends Thread { // 'Thread' Class를 상속받는다 
	int num1;
	int num2;
    public ProcessThread(int n1, int n2) { 
    	num1 = n1;
    	num2 = n2;
    } 


    public void run() {
		String output;
		try {
			output = getProcessOutput(Arrays.asList("add_2sec.exe",Integer.toString(num1),Integer.toString(num2)));
			System.out.println(num1 + " + " + num2 + " = " + output);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				    	
    } 
    
	public String getProcessOutput(List<String> cmdList) throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder(cmdList);		
		Process process = builder.start();
		InputStream psout = process.getInputStream();
		byte[] buffer = new byte[1024];
		int len = psout.read(buffer);
		return (new String(buffer, 0, len));
	}    
} 

public class SP1 {

	static String rootPath = ".\\INPUT";
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//FileSearchAll(rootPath);
//		ListTest();
//		QueueTest();
		
/*
		byte[] buffer = new byte[1024];
		ServerSocket listener = new ServerSocket(9090);
		try {
			Socket s = listener.accept();
			DataInputStream is = new DataInputStream(s.getInputStream());
			try {
				String fileName = null;
				// 파일이름 수신
				while ((fileName = is.readUTF()) != null) {
					// 파일크기 수신
					int fileSize = is.readInt();
					FileOutputStream fw = new FileOutputStream("./ServerFiles/" + fileName);
					int length;
					while (fileSize > 0) {
						// 파일내용 수신
						length = is.read(buffer, 0, Math.min(fileSize, buffer.length));
						fileSize -= length;
						fw.write(buffer, 0, length);
					} 
					fw.close();
					System.out.println(fileName+" is received.");
				}
			} finally {
				s.close();
			}
		} finally {
			listener.close();	
		}
        ThreadClass tc1 = new ThreadClass("[Thread1] ");
        ThreadClass tc2 = new ThreadClass("[Thread2] ");
        tc1.start(); 
        tc2.start();

        ThreadClass.lock.lock();
    	try {        
    		ThreadClass.printNum("[Main]");
    	}
    	finally
    	{
    		ThreadClass.lock.unlock();
    	}
        
        tc1.join();
        tc2.join();
        
		BufferedReader in = new BufferedReader(new FileReader("./NUM.TXT"));
        String str;
        List<ProcessThread> thList = new ArrayList<ProcessThread>();
        
        while ((str = in.readLine()) != null) {
            String words[] = str.split(" ");
            int num1 = Integer.parseInt(words[0]);
            int num2 = Integer.parseInt(words[1]);
            
            ProcessThread th = new ProcessThread(num1, num2);
            th.start();
            thList.add(th);
        }
        in.close();		
        
        for (ProcessThread th : thList)
        {
        	th.join();
        }
		System.out.println("End - " + new Date().toString()); // 현재시각출력
*/	
//		String output = getProcessOutput(Arrays.asList("add_2sec.exe","2","3"));
//		System.out.println(output);
	}

	public static void receiveFile() {
		
	}
	public static String getProcessOutput(List<String> cmdList) throws IOException, InterruptedException {
			ProcessBuilder builder = new ProcessBuilder(cmdList);
			Process process = builder.start();
			InputStream psout = process.getInputStream();
			byte[] buffer = new byte[1024];
			psout.read(buffer);
			return (new String(buffer));
		}


	public static void QueueTest() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String strInput = br.readLine();
           
            switch(strInput.split(" ")[0]) {
            case "CREATE": // 큐 생성
            	Queue<String> numberQ = new LinkedList<>();
            	numberQ.add(strInput.split(" ")[1]);
                break;
            }
        }
	}
	public static void ListTest() throws IOException {
		ArrayList<Grade> al = new ArrayList<>();
		
		try {
            ////////////////////////////////////////////////////////////////
            BufferedReader in = new BufferedReader(new FileReader("./INPUT/List_Sample.txt"));
            String str;

            while ((str = in.readLine()) != null) {
                String words[] = str.split("\t");
                Grade g = new Grade(words[0],Integer.parseInt(words[1]),Integer.parseInt(words[2]),Integer.parseInt(words[3]));
                al.add(g);
            }
            in.close();
            ////////////////////////////////////////////////////////////////
        } catch (IOException e) {
            System.err.println(e); // 에러가 있다면 메시지 출력
            System.exit(1);
        }
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String strInput = br.readLine();
           
            switch(strInput) {
            case "PRINT": // 이름 순 출력
                Collections.sort(al, (g1, g2) -> g1.getName().compareTo(g2.getName()));
                break;
            case "KOREAN": // 국어 성적 순 출력
                // Lambda식
                Collections.sort(al, (g1, g2) -> (g2.getKorean() - g1.getKorean()) == 0 ? g1.getName().compareTo(g2.getName()) : g2.getKorean() - g1.getKorean());                
                break;
            case "ENGLISH": // 영어 성적 순 출력
                // Comparator
                Collections.sort(al, new Comparator<Grade>() {

                    @Override
                    public int compare(Grade x, Grade y) {
                        if (y.getEnglish() - x.getEnglish() == 0)
                        {
                            return x.getName().compareTo(y.getName());
                        }
                        else
                        {
                            return y.getEnglish() - x.getEnglish();
                        }
                    }
                   
                });                
                break;
            case "MATH":
                // Comparator
                Collections.sort(al, new sortByMath());                
                break;
            case "QUIT":
                return;
               default:
                break;
            }
           
            for (Grade val : al)
            {
                System.out.println(String.format("%s\t%d\t%d\t%d",val.getName(), val.getKorean(), val.getEnglish(), val.getMath()));
            }                
        }  
	}
	public static void FileSearchAll(String path)
	{
		File directory = new File(path);
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isDirectory()) {
				FileSearchAll(file.getPath());
			} 
			else { 
				String partPath = path.substring(rootPath.length());
				System.out.println("." + partPath + "\\" + file.getName());
				if(file.length() > 3*1024)
				{
					System.out.println("." + partPath + "\\" + file.getName());
					CopyFile(partPath, file.getName());
				}
			}
		}
	}

	public static void CopyFile(String partPath, String filename) 
	{
		final int BUFFER_SIZE = 512;
		int readLen;
		try {
    		File destFolder = new File(".\\OUTPUT" + partPath);
    		if(!destFolder.exists()) {
    			destFolder.mkdirs(); 
    		}  
			InputStream inputStream = new FileInputStream(".\\INPUT"+partPath+"\\"+filename);
			OutputStream outputStream = new FileOutputStream(".\\OUTPUT"+partPath+"\\"+filename);
			byte[] buffer = new byte[BUFFER_SIZE];
			while ((readLen = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, readLen);
		}
		inputStream.close();
		outputStream.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
