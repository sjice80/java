import java.io.*;
import java.util.*;
import java.net.*;

public class SocketTest {

	public static final String SERVER = "dict.org";
	public static final int PORT = 2628;
	public static final int TIMEOUT = 15000;
	
	public static void main(String[] args) {
		String[] param = new String[] {"gold", "platinum", "silver", "copper"};
		Socket socket = null;
		try{
			socket = new Socket(SERVER , PORT);
			socket.setSoTimeout(TIMEOUT);
			OutputStream out = socket.getOutputStream();
			Writer writer = new OutputStreamWriter(out, "UTF-8");
			writer = new BufferedWriter(writer);
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			
			for(String word: param){
				define(word, writer, reader);
			}
			
			writer.write("quit\r\n");
			writer.flush();
		}catch(IOException ex){
			System.err.println(ex);
		}finally{//리소스해제(dispose)
			if(socket != null){
				try{
					socket.close();
				}catch(IOException ex){//무시한다}
				}
			}
		}
	}
	static void define(String word, Writer writer, BufferedReader reader) throws IOException{
		writer.write("DEFINE fd-eng-lat "+ word + "\r\n");
		writer.flush();
		
		for(String line = reader.readLine(); line != null; line = reader.readLine()){
			if(line.startsWith("250 ")){//OK			
				return;
			}else if(line.startsWith("552 ")){//일치하지 않음
				System.out.println("No definition found for " + word);
				return;
			}
			else if(line.matches("\\d\\d\\d .*")) continue;
			else if(line.trim().equals(".")) continue;
			else System.out.println(line);
		}
	}
}


