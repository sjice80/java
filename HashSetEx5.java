import java.io.*;
import java.util.*;
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.text.*;

public class HashSetEx5 {
	static int totalFiles = 0;
	static int totalDirs = 0;
	static int found = 0;
	static int deletedFiles = 0;
	static String[] argArr; // 입력한 매개변수를 담기위한 문자열배열
	static File curDir; // 현재 디렉토리
	static {
		try {
			curDir = new File(System.getProperty("user.dir"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		ListIterator it2 = list.listIterator();
		while(it2.hasNext()) {
			System.out.print(it2.next());
		}
		System.out.println();
		while(it2.hasPrevious()) {
			System.out.print(it2.previous());
		}
		System.out.println();
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHab = new HashSet();
		HashSet setKyo = new HashSet();
		HashSet setCha = new HashSet();
		
		setA.add("1");	setA.add("2");	setA.add("3");	setA.add("4");	setA.add("5");
		System.out.println("A = "+setA);
		
		setB.add("4");	setB.add("5");	setB.add("6");	setB.add("7");	setB.add("8");
		System.out.println("B = "+setB);
		
		Iterator it = setB.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(setA.contains(tmp)) {
				setKyo.add(tmp);
			}
		}
		it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!setB.contains(tmp)) {
				setCha.add(tmp);
			}
		}
		it = setA.iterator();
		while(it.hasNext()) {
			setHab.add(it.next());
		}
		it = setB.iterator();
		while(it.hasNext()) {
			setHab.add(it.next());
		}
		System.out.println("A 교집합 B = "+setKyo);
		System.out.println("A 합집합 B = "+setHab);
		System.out.println("A 차집합 B = "+setCha);
		pathIterator();
		//wordCount();
		Exercise15_6();
	}
	public static void Exercise15_6() {
		Scanner s = new Scanner(System.in);
		while(true) {
			try {
				String prompt = curDir.getCanonicalPath() + ">>"; 
				System.out.print(prompt);
				// 화면으로부터 라인단위로 입력받는다. 
				String input = s.nextLine();
				input = input.trim(); // 입력받은 값에서 불필요한 앞뒤 공백을 제거한다. 
				argArr = input.split(" +");
				String command = argArr[0].trim(); 
				if("".equals(command)) continue;
				command = command.toLowerCase(); // 명령어를 소문자로 바꾼다.
				if(command.equals("q")) { 
					// q 또는 Q를 입력하면 실행종료한다. 
					System.exit(0);
				} else if(command.equals("cd")) { 
					cd();
				} else {
					for(int i=0; i < argArr.length;i++) {
						System.out.println(argArr[i]);
					}
					
				}
			} catch(Exception e) {
				e.printStackTrace(); 
				System.out.println("입력오류입니다.");
			}

		} // while(true)
	}
	public static void cd() {
		if(argArr.length==1) { 
			System.out.println(curDir); 
			return;
		} else if(argArr.length > 2) { 
			System.out.println("USAGE : cd directory");
			return;
		}
		
		String subDir = argArr[1];

		//1. 입력된 디렉토리(subDir)가 ".."이면, 
		if("..".equals(subDir)) { // 부모 디렉토리
			//1.1 현재 디렉토리의 조상 디렉토리를 얻어서 현재 디렉토리로 지정한다. 
			File newDir = curDir.getParentFile();
			if(newDir==null) {
				System.out.println("유효하지 않은 디렉토리입니다.");
			} else {
				curDir = newDir; // 조상 디렉토리를 현재 디렉토리로 지정한다.
			}			
		} 	
		//2. 입력된 디렉토리(subDir)가 "."이면, 단순히 현재 디렉토리의 경로를 화면에 출력한다. 
		else if(".".equals(subDir)) { // 현재 디렉토리
			System.out.println(curDir); 
		} else {
			//3. 1 또는 2의 경우가 아니면,
			//3.1 입력된 디렉토리(subDir)가 현재 디렉토리의 하위디렉토리인지 확인한다.
			File newDir = new File(curDir, subDir); 
			if(newDir.exists() && newDir.isDirectory()) {
			//3.2 확인결과가 true이면, 현재 디렉토리(curDir)을 입력된 디렉토리(subDir)로 변경한다.
				curDir = newDir; 
			} else {
			//3.3 확인결과가 f
				System.out.println("유효하지 않은 디렉토리입니다.");
			}
		}
	}
	public static void Exercise15_5() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("test.txt"));
			HtmlTagFilterWriter bw = new HtmlTagFilterWriter(new FileWriter("result.txt"));
			int ch = 0;
			while((ch=br.read())!=-1) {
				bw.write(ch);
			}
			br.close();
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void delete(File dir, String ext) {
		File[] files = dir.listFiles();
		for(int i=0; i<files.length; i++) {
			if(files[i].isDirectory()) {
				delete(files[i], ext);
			} else {
				String filename = files[i].getAbsolutePath();
				if(filename.endsWith(ext)) {
					System.out.println(filename);
					if(files[i].delete()) {
						System.out.println(" - 삭제 성공");
						deletedFiles++;
					} else {
						System.out.println(" - 삭제 실패");
					}
				}
			}
		}
	}
	public static void fileEx7() throws IOException {
		String currDir = System.getProperty("user.dir");
		File dir = new File(currDir);
		String pattern = "class";
		String[] files = dir.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.indexOf(pattern) != -1;
			}
		});
		for(int i=0; i<files.length; i++) {
			System.out.println(files[i]);
		}
	}
	public static void fileEx5(char opt) {
		String currDir = System.getProperty("user.dir");
		File dir = new File(currDir);
		File[] files = dir.listFiles();
		Comparator comp = new Comparator() {
			public int compare(Object o1, Object o2) {
				long time1 = ((File)o1).lastModified();
				long time2 = ((File)o2).lastModified();
				
				long length1 = ((File)o1).length();
				long length2 = ((File)o2).length();
				
				String name1 = ((File)o1).getName().toLowerCase();
				String name2 = ((File)o2).getName().toLowerCase();
				
				int result = 0;
				switch(opt) {
					case 't':
						if(time1-time2>0) result = 1;
						else if(time1-time2==0) result = 0;
						else if(time1-time2<0) result = -1;
						break;
					case 'T':
						if(time1-time2>0) result = -1;
						else if(time1-time2==0) result = 0;
						else if(time1-time2<0) result = 1;
						break;
					case 'l':
						if(length1-length2>0) result = 1;
						else if(length1-length2==0) result = 0;
						else if(length1-length2<0) result = -1;
						break;
					case 'L':
						if(length1-length2>0) result = -1;
						else if(length1-length2==0) result = 0;
						else if(length1-length2<0) result = 1;
						break;	
					case 'n':
						result = name1.compareTo(name2);
						break;
					case 'N':
						result = name2.compareTo(name1);
						break;
				}
				
				return result;
			}
			
		};
		Arrays.sort(files, comp);
    	for(int i=0; i<files.length; i++) {
    		File f = files[i];
    		String name = f.getName();
    		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");
    		String attribute = "";
    		String size = "";
    		if(files[i].isDirectory()) {
    			attribute = "DIR";
    		} else {
    			size = f.length() + "";
    			attribute = f.canRead()? "R":" ";
    			attribute = f.canWrite()? "W":" ";
    			attribute = f.isHidden()? "H":" ";
    		}
    		System.out.printf("%s %3s %6s %s\n", df.format(new Date(f.lastModified())), attribute, size, name);
    	}
	}
	public static void fileEx6() {
		File dir = new File(".");
		String keyword = "System.out.println";
		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		try {
			findInFiles(dir, keyword);
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("총 "+found+"개의 라인에서 '"+keyword+"'을 발견하였습니다.");
	}
	public static void findInFiles(File dir, String keyword) throws IOException {
		File[] files = dir.listFiles();
		for(int i=0; i<files.length; i++) {
			if(files[i].isDirectory()) {
				findInFiles(files[i], keyword);
			} else {
				String filename = files[i].getName();
				String extension = filename.substring(filename.lastIndexOf(".")+1);
				extension = "," + extension + ",";
				if(",java,txt,bak,".lastIndexOf(extension)==-1) continue;
				FileReader fr = new FileReader(files[i]);
				BufferedReader br = new BufferedReader(fr);
				String data = "";
				int lineNum = 0;
				while((data=br.readLine())!=null) {
					lineNum++;
					if(data.indexOf(keyword)!=-1) {
						found++;
						System.out.println("["+filename+"("+lineNum+")"+"]"+data);
					}
				}
				br.close();
			}
		}
	}
    public static void pathIterator() 
    { 
  
        // create object of Path 
        Path path 
            = Paths.get("D:\\Workspace"
                        + "\\nEclipseWork"
                        + "\\GFG\\bin\\defaultpackage"); 
  
        System.out.println("Original Path:"
                           + path); 
  
        // Creating an iterator 
        Iterator<Path> elements 
            = path.iterator(); 
  
        // Displaying the values 
        System.out.println("The iterator values are: "); 
        while (elements.hasNext()) { 
            System.out.println(elements.next()); 
        } 
    } 
    public static void fileEx1() throws IOException {
    	File f = new File("./");//HashSetEx5.java");
    	printFileList(f);
    	/*
    	if(!f.exists() || !f.isDirectory()) {
    		System.out.println("유효하지 않은 디렉토리입니다.");
    		System.exit(0);
    	}
    	File[] files = f.listFiles();
    	for(int i=0; i<files.length; i++) {
    		String fileName = files[i].getName();
    		System.out.println(files[i].isDirectory()?"["+fileName+"]":fileName);
    	}
    	String fileName = f.getName();
    	int pos = fileName.lastIndexOf(".");
    	*/
    	/*
    	System.out.println("경로를 제외한 파일이름 - " + fileName);
    	System.out.println("확장자를 제외한 파일이름 - " + fileName.substring(0, pos));
    	System.out.println("확장자 - " + fileName.substring(pos+1));
    	System.out.println("경로를 포함한 파일이름 - " + f.getPath());
    	System.out.println("파일의 절대경로 - " + f.getAbsolutePath());
    	System.out.println("파일의 정규경로 - " + f.getCanonicalPath());
    	System.out.println("File.pathSeparator - " + File.pathSeparator);
    	*/
    }
    public static void fileEx4() {
    	String currDir = System.getProperty("user.dir");
    	File dir = new File(currDir);
    	File[] files = dir.listFiles();
    	for(int i=0; i<files.length; i++) {
    		File f = files[i];
    		String name = f.getName();
    		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");
    		String attribute = "";
    		String size = "";
    		if(files[i].isDirectory()) {
    			attribute = "DIR";
    		} else {
    			size = f.length() + "";
    			attribute = f.canRead()? "R":" ";
    			attribute = f.canWrite()? "W":" ";
    			attribute = f.isHidden()? "H":" ";
    		}
    		System.out.printf("%s %3s %6s %s\n", df.format(new Date(f.lastModified())), attribute, size, name);
    	}
    }
    public static void printFileList(File dir) {
    	System.out.println(dir.getAbsolutePath()+" 디렉토리");
    	File[] files = dir.listFiles();
    	ArrayList subDir = new ArrayList();
    	for(int i=0; i<files.length; i++) {
    		String filename = files[i].getName();
    		if(files[i].isDirectory()) {
    			filename = "["+filename+"]";
    			subDir.add(i+"");
    			System.out.println(filename);
    		}
    	}
    	int dirNum = subDir.size();
    	int fileNum = files.length - dirNum;
    	totalFiles += fileNum;
    	totalDirs += dirNum;
    	System.out.println(fileNum+"개의 파일, "+dirNum+"개의 디렉토리");
    	System.out.println();
    	for(int i=0; i<subDir.size(); i++) {
    		int index = Integer.parseInt((String)subDir.get(i));
    		printFileList(files[index]);
    	}
    }
    public static void wordCount() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String[] str = br.readLine().trim().split(" ");
    	int cnt=0;
    	for(int i=0; i<str.length; i++) {
    		if(!str[i].equals(" ")) {
    			cnt++;
    		}
    	}
    	bw.write(cnt+"\n");
    	bw.flush();
    	bw.close();
    }
}
class HtmlTagFilterWriter extends FilterWriter {
	StringWriter tmp = new StringWriter();
	boolean inTag = false;
	HtmlTagFilterWriter(Writer out) {
		super(out);
	}
	public void write(int c) throws IOException {
		if(c=='<') {
//			System.out.print((char)c);
			inTag = true;
		} else if(c=='>' && inTag) {
//			System.out.print("-"+(char)c);
			inTag = false;
			tmp = new StringWriter();
			return;
		} else {
//			System.out.print((char)c+","+inTag);
		}
		if(inTag) {
//			System.out.print((char)c);
			tmp.write(c);
		} else {
			System.out.print((char)c);
			out.write(c);
		}
	}
	public void close() throws IOException {
		out.write(tmp.toString());
		super.close();
	}
}
class Descending implements Comparator {
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c1.compareTo(c2) * -1;
		}
		return -1;
	}
}
