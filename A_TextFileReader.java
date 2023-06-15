import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

public class TextFileReader {
	public List<String> readFile(String fileName) {
		BufferedReader br = null;
		List<String> strArray = new ArrayList<String>();
		String line = "";
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				line = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}	
			if(line == null) {
				break;
			}
			strArray.add(line);
		}
		try {
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}	
		return strArray;
	}
}
