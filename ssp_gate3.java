import java.io.*;
import java.util.*;

public class ssp_gate3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subDirList("./INFILE");
	}

	public static void subDirList(String source) {
		File dir = new File(source);
		File[] fileList = dir.listFiles();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		try {
			for(int i=0; i<fileList.length; i++) {
				File file = fileList[i];
				if(file.isFile()) {
					System.out.println("\t파일 이름 = "+file.getName());
					if(file.getName().substring(0,5).equals("00300")) {
						int dir_len = file.getCanonicalPath().toString().length() - file.getName().length();
						String orgfile_path = file.getCanonicalPath().toString().substring(0,dir_len);
						list.add(orgfile_path);
						System.out.println("\t리스트추가:"+orgfile_path);
						String super_path = file.getCanonicalPath().toString().substring(0,dir_len-6);
						File orgfile = new File(super_path+"ORGGATE.TXT");
						if(orgfile.exists()) {
//							System.out.println("\t"+file.getAbsolutePath().toString());
							System.out.println("\t"+file.getCanonicalPath().toString());
							FileReader fr = new FileReader(orgfile);
							BufferedReader br = new BufferedReader(fr);
							String str = br.readLine();
							String gate_from = str.split("-")[0];
							String gate_to = str.split("-")[1];
							System.out.println("상위폴더:"+gate_from+", "+gate_to);
							list2.add(gate_from+", "+gate_to);
						}
					}
	
				} else if(file.isDirectory()) {
					System.out.println("디렉토리 이름 = "+file.getName());
					System.out.println("디렉토리 이름 = "+file.getCanonicalPath().toString());
					subDirList(file.getCanonicalPath().toString());
				}
			}
		} catch(IOException e) {
			
		}
		for(int i=0; i<list.size(); i++) {
			subDirList2(list.get(i));
		}
	}
	public static void subDirList2(String source) {
		File dir = new File(source);
		File[] fileList = dir.listFiles();
		ArrayList<String> list = new ArrayList<String>();
		try {
			for(int i=0; i<fileList.length; i++) {
				File file = fileList[i];
				if(file.isFile()) {
					System.out.println("\tORG파일 이름 = "+file.getName());
					if(file.getName().equals("ORGGATE.TXT")) {
						FileReader fr = new FileReader(file.getCanonicalPath().toString());
						BufferedReader br = new BufferedReader(fr);
						String str = br.readLine();
						String gate_from = str.split("-")[0];
						String gate_to = str.split("-")[1];
						System.out.println(gate_from+", "+gate_to);	
						list.add(gate_from+", "+gate_to);
					}
	
				} else if(file.isDirectory()) {
					System.out.println("ORG디렉토리 이름 = "+file.getName());
					System.out.println("ORG디렉토리 이름 = "+file.getCanonicalPath().toString());
					subDirList2(file.getCanonicalPath().toString());
				}
			}
		} catch(IOException e) {
			
		}
	}
}
