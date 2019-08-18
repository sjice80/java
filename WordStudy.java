import java.io.*;
import java.util.*;

public class WordStudy {

	static ArrayList<String> wordList = new ArrayList<>();
	static String WORD_FILE = "word_data.txt";
	static String CR_LF = System.getProperty("line.seperator");
	
	public static void loadFile(String filename) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(WORD_FILE));
			String line = "";
			while((line=br.readLine())!=null) {
				line = line.toLowerCase();
				//System.out.println(temp);
				wordList.add(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) {
					br.close();
				}
			} catch(IOException e) {
				
			}
		}
	}
	public static void displayNSave(int pos) {
		String tmp = (String)wordList.get(pos);
		StringBuffer sb = new StringBuffer(tmp.length());
		StringTokenizer st = new StringTokenizer(tmp, "|");
		//String[] str = tmp.split("\\|");
		String fileName = "";
		FileWriter fw;
		BufferedWriter bw = null;
		int cnt=0;
		/*
		for(String word:str) {			
			sb.append(word).append("\r\n");
//			System.out.println(sb.toString());
		}
		*/
		
		while(st.hasMoreTokens()) {
			String word = st.nextToken();
			sb.append(word).append("\r\n");
			cnt++;
			if(cnt==1) {
				fileName = word+".txt";
			}
		}
		
		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write(sb.toString());
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw!=null) {
					bw.close();
				}
			} catch(IOException e) {
				
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadFile("word_data.txt");
		for(int i=0;i<wordList.size();i++) {
			displayNSave(i);
		}
		Collections.sort(wordList);
		System.out.println(wordList);
	}

}
