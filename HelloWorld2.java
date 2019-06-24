package com.lgcns.first;


import java.util.*;
//import java.util.Set;
//import java.util.HashSet;
import java.io.*;
import java.text.SimpleDateFormat;
import java.security.NoSuchAlgorithmException;
import java.net.Socket;
import java.net.ServerSocket;

class ReportVo {
	private String insId;
	private int checkCard;
	private int failCard;
	public ReportVo() {
		
	}
	public ReportVo(String line) {
		insId = line.split(" ")[0];
		checkCard = Integer.parseInt(line.split(" ")[1]);
		failCard = Integer.parseInt(line.split(" ")[2]);
	}
}
class Grade {
	private String strName;
	private int Korean;
	private int English;
	private int Math;
	public Grade(String n, int k, int e, int m) {
		strName = n;
		Korean = k;
		English = e;
		Math = m;
	}
	public String getName() {
		return strName;
	}
	public void setName(String n) {
		this.strName = n;
	}
	public int getKorean() {
		return Korean;
	}
	public void setKorean(int k) {
		this.Korean = k;
	}
	public int getEnglish() {
		return English;
	}
	public void setEnglish(int e) {
		this.English = e;
	}
	public int getMath() {
		return Math;
	}
	public void setMath(int m) {
		this.Math = m;
	}
}
class ValidatorReport {
	private static String LINE_BREAK = System.getProperty("line.seperator");
	public boolean reportValidator() throws IOException {
		HashMap<String, ReportVo> map = new HashMap<String, ReportVo>();
		final String strToday = "20190614";
		File directory = new File("..//SERVER");
		File[] list = directory.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isFile() && file.getName().length() == 27
						&& file.getName().substring(9,17).equals(strToday);
			}
		});
		for(File file:list) {
//			analysisData(map, file.getPath());
		}
//		saveReportFile(map, strToday);
		return true;
	}
	/*
	private void analysisData(HashMap<String, ReportVo> map, String path) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			while((line=br.readLine())!=null) {
				ReportVo userReport = new ReportVo();
				String key = line.substring(0, 8);
				if(map.get(key)==null) {
//					userReport.setInsId(line.substring(0,8));
					
				}
			}
		}
	}
	*/
}
class CardServer implements Runnable {
	public static final int BUF_SIZE = 4096;
	private ServerSocket serverSocket;
	private boolean isStop;
	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	public void run() {
		serverSocket = null;
		try {
			serverSocket = new ServerSocket(27015);
			byte[] buffer = new byte[BUF_SIZE];
			int length=0;
			while(!isStop) {
				Socket socket = null;
				DataInputStream is = null;
				try {
					socket = serverSocket.accept();
					is = new DataInputStream(socket.getInputStream());
					while(true) {
						String fileName = is.readUTF();
						int fileSize = is.readInt();
						while(fileSize>0) {
							length = is.read(buffer, 0, Math.min(fileSize, buffer.length));
							fileSize -= length;
							writeFile(fileName, buffer, 0, length);
						}
					}
				} catch(EOFException e) {
					
				} catch(IOException e) {
					e.printStackTrace();
				} finally {
					if(socket!=null) {
						socket.close();
					}
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket!=null) {
					serverSocket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void writeFile(String fileName, byte[] buffer, int offset, int length) throws IOException {
		FileOutputStream fw = null;
		try {
			fw = new FileOutputStream("..//SERVER//"+fileName, true);
			fw.write(buffer, offset, length);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(fw!=null) {
				fw.close();
			}
		}
	}
}
class TerminalInfo {
	private String name;
	private String name2;
	private int firstHour;
	private int firstMinute;
	private int interval;
	private int lastHour;
	private int lastMinute;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public int getFirstHour() {
		return firstHour;
	}
	public void setFirstHour(int firstHour) {
		this.firstHour = firstHour;
	}
	public int getFirstMinute() {
		return firstMinute;
	}
	public void setFirstMinute(int firstMinute) {
		this.firstMinute = firstMinute;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public int getLastHour() {
		return lastHour;
	}
	public void setLastHour(int lastHour) {
		this.lastHour = lastHour;
	}
	public int getLastMinute() {
		return lastMinute;
	}
	public void setLastMinute(int lastMinute) {
		this.lastMinute = lastMinute;
	}
	public TerminalInfo(String name, int firstHour, int firstMinute, int interval, int lastHour, int lastMinute) {
		super();
		this.name = name;
		this.firstHour = firstHour;
		this.firstMinute = firstMinute;
		this.interval = interval;
		this.lastHour = lastHour;
		this.lastMinute = lastMinute;
	}
	public TerminalInfo(String name, String name2, int firstHour, int firstMinute) {
		super();
		this.name = name;
		this.name2 = name2;
		this.firstHour = firstHour;
		this.firstMinute = firstMinute;
	}
	public TerminalInfo() {
		
	}
}
class Magam {
	String time;
	String yn;
	
	public Magam(String time, String yn) {
		this.time = time;
		this.yn = yn;
	}
}

class Set implements Comparable<Set> {
	int x;
	int y;
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int compareTo(Set set) {
		if(this.x > set.x)
			return 1;
		else if(this.x < set.x)
			return -1;
		else
			return this.y - set.y;
	}
}

public class HelloWorld {
	static int sourceCount = 0;
	static int patternCount = 0;
	static int lineCount = 0;
	static int pFileCount = 0;
	static int saleNumber = 0;
	static String[] saleKind;
	static String[] products = {"coffee", "gimbap", "water", "ramen", "kimchi", "rice", "cigarettes",
								"milk", "popcorn", "chocolate", "paper", "soju", "beer"};
	static int caseCnt=0;
	static String insId = "";
	static String onBusTime = "";
	static String onBusId = "";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    String lineOfCurrencies = "USD JPY AUD SGD HKD CAD CHF GBP EURO INR";

	    // Now, we will split this string and convert it into an array of String
	    // we use regex " ", which will match just one whitespace
	    String[] currencies = lineOfCurrencies.split(" ");

	    System.out.println("input string words separated by whitespace: "
	        + lineOfCurrencies);
	    System.out.println("output string: " + Arrays.toString(currencies));

	    // above regular expression will not work as expected if you have multiple
	    // space between two words in string, because it could pick extra
	    // whitespace as another word. To solve this problem, we will use
	    // a proper greedy regular expression to match any number of whitespace
	    // they are actually separated with two tabs here

	    String lineOfPhonesWithMultipleWhiteSpace = "iPhone Galaxy Lumia";
	    String[] phones = lineOfPhonesWithMultipleWhiteSpace.split("\\s+");

	    System.out.println("input string separted by tabs: "
	        + lineOfPhonesWithMultipleWhiteSpace);
	    System.out.println("output string: " + Arrays.toString(phones));

	    // above regular expression will not able to handle leading
	    // and trailing whitespace, as it will count empty String
	    // as another word, as shown below

	    String linewithLeadingAndTrallingWhiteSpace = " Java C++ ";
	    String[] languages = linewithLeadingAndTrallingWhiteSpace.split("\\s+");

	    System.out.println("input string with leading and traling space: "
	        + linewithLeadingAndTrallingWhiteSpace);
	    System.out.println("output string: " + Arrays.toString(languages));

	    // You can solve above problem by trimming the string before
	    // splitting it i.e. call trim() before split() as shown below
	    languages = linewithLeadingAndTrallingWhiteSpace.trim().split("\\s+");
	    System.out.println("input string: " + linewithLeadingAndTrallingWhiteSpace);
	    System.out.println("output string afte trim() and split: "
	        + Arrays.toString(languages));
	    //String a = null;
	    for(int i=0; i<10; i++) {
	    	System.out.print(String.valueOf((char)('a'+i)).concat(String.valueOf(i))+" ");
	    }
		int[][] input = {
				{10210, 80},
				{10211, 77},
				{10212, 55},
				{10213, 66},
				{10214, 77},
				{10215, 99},
				{10216, 30},
				{10217, 10}
		};
		rank(input);
		countWord("I LOVE LG LG CNS^^", "LG");
		int arr[] = {1, 232, 54545, 999991};
		int maxLength = 0, maxNum=0;
		//Output: 54545

		//Input: arr[] = {1, 2, 3, 4, 5, 50};
		//Output: 5 

		for(int i=0; i<arr.length; i++) {
			if(isPalindromeInt(arr[i]) == 1) {
				if(maxLength < String.valueOf(arr[i]).length())
				{
					maxLength = String.valueOf(arr[i]).length();
					maxNum = arr[i];
				}
			}
		}
		System.out.println(maxNum);
		
		String str1 = "abc";
		String str2 = "deff";
		String str3 = new String("def");
		String str4 = new String("abc");
		
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		System.out.println(str3==str4);
		System.out.println(str3.equals(str4));
		str1 = str1+str3;
		//str3 = str3+str3;
		System.out.println(str1);
		/*
		String test1 = "level";
		String test2 = "work";
		String test3 = "java_advanced";
		palindrome(test1);
		palindrome(test2);
		palindrome(test3);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Java Programming", 100000);
		map.put("Python Basic", 120000);
		map.put("C Languate", 95000);
		for(String lang : map.keySet()) {
			int price = map.get(lang);
			System.out.println(lang +":"+price);
		}
		if(map.containsKey("Java Programming")) {
			System.out.println("자바 포함");
		} else {
			System.out.println("자바 불포함");
		}
		*/
		/*int[][] input = {{1,2,3,4}, 
						   {5,6,7,8}, 
						   {9,10,11,12},
						   {13,14,15,16}};
		rotatedArray(input);
		System.out.println();
		rotatedRightArray(input);
		*/
		//Input: arr[] = {1, 232, 54545, 999991};
		//Output: 54545

		//Input: arr[] = {1, 2, 3, 4, 5, 50};
		//Output: 5 

		//int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
    	//int A2[] = {2, 1, 8, 3};
		// Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
		/*
		String str = "fguecbdavwyxzhijklmnopqrst";
		String	strArr[] = {"geeksforgeeks", "is", "the", "best", "place", "for", "learning"};
		//Output: for geeksforgeeks best is learning place the

		String str1 = "avdfghiwyxzjkecbmnopqrstul";
		String strArr1[] = {"rainbow", "consists", "of", "colours"};
		//Output: consists colours of rainbow
		
		compareStr(str, strArr);
		System.out.println();
		compareStr(str1, strArr1);
		*/
/*
		List<Integer> list = new ArrayList<>();
		list.add(22);
		list.add(44);
		list.add(55);
		list.add(11);
		list.add(25);
		System.out.println("Min: "+findMin(list));
		System.out.println("Max: "+findMax(list));
*/		
	    // Creating a hash set of strings 
		
	    java.util.Set<String> s = new HashSet<String>(); 
	    s.add("Geeks"); 
	    s.add("for"); 
	  
	    int n = s.size(); 
	    List<String> aList = new ArrayList<String>(n); 
	    for (String x : s) 
	      aList.add(x); 
	  
	    System.out.println("Created ArrayList is"); 
	    for (String x : aList) 
	      System.out.println(x); 
	  

		analyze("D:\\Study\\java\\ApiExplorer\\src", "//System.out.println(rd.readLine().toString());");
		System.out.println("sourceCount: "+sourceCount);
		System.out.println("patternCount: "+patternCount);
		System.out.println("lineCount: "+lineCount);
		System.out.println("pFileCount: "+pFileCount);
		
		/*
		String strFirst = "AGTCATG";
		String strSecond = "GTTAG";
		int i=0, k=0, same_cnt=0, overlap=1, max=0, add=0, start=0;
		char[] chFirst = strFirst.toCharArray();
		char[] chSecond = strSecond.toCharArray();
		while(start >=0 && start<strFirst.length()) {
			same_cnt=0;
			for(i=0; i<overlap; i++) {
				System.out.println("1:"+(strSecond.length()-1-i));
				System.out.println("2:"+(overlap-1-i+add));
				if(chSecond[strSecond.length()-1-i] == chFirst[overlap-1-i+add]) {
					same_cnt++;
					System.out.println("3:"+(chSecond[strSecond.length()-1-i])+chFirst[overlap-1-i+add]+same_cnt);
				}
			}
			
			if(overlap == strSecond.length()) {
				overlap = strSecond.length();
				add++;
			} else {
				overlap++;
			}
			if(same_cnt > max) {
				max = same_cnt;
			}
			start++;
		}
		System.out.println(max);
		*/
		/*
		List<Set> set = setting();
		Collections.sort(set);
		
		for(int i=0; i<set.size(); i++) {
			System.out.println(set.get(i).getX()+" "+set.get(i).getY());
		}
		*/
		
		StringBuilder sb = new StringBuilder();
		sb.append(true);
		System.out.println(sb);
		sb.append('a');
		System.out.println(sb);
		char[] chars = new char[] {'d', 'e', 'f'};
		sb.append(chars);
		System.out.println(sb);	
		sb.insert(2, false);
		System.out.println(sb);	
		int i = 105;
		sb.append(i);
		System.out.println(sb);
		sb.append(24).append("A");
		System.out.println(sb);
		
		System.out.println(GCF(6,8)+" "+LCM(6,8));
		String inputMAC1 = "01:23:45:67:89:ab";
		printResult(inputMAC1);
		String inputMAC2 = "0123.AbcD.Ef99";
		printResult(inputMAC2);
		String inputMAC3 = "78-90-AB-CD-EF-GH";
		printResult(inputMAC3);
		/*
		String line = "";
		File file = new File(".\\magam.txt");
		Scanner sc = new Scanner(file);
		ArrayList<String> oldList = new ArrayList<String>();
		ArrayList<String> newList = new ArrayList<String>();
		Magam[] mg = new Magam[100];
		int mg_cnt = 0, daily_cnt=0, i=0, k=0, offset=0, six_set=0;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			oldList.add(line);
			String[] strArr = line.split("#");
			mg[mg_cnt] = new Magam(strArr[0], strArr[1]);
			mg_cnt++;
		}
		sc.close();
		System.out.println(mg_cnt);
		daily_cnt = 1;

		for(i=0; i<mg_cnt; i++) {
//			System.out.println("시간:"+mg[i].time+", 마감여부:"+mg[i].yn);
			for(k=offset; k<mg_cnt-1; k++) {
				if(mg[offset].time.equals(mg[k+1].time) == true) {
					daily_cnt++;
				}
				else {
					break;
				}
			}
			if(offset == mg_cnt) {
				System.out.println("종료");
//				System.out.println("시간:"+mg[offset-daily_cnt].time+", 마감여부:"+mg[offset-daily_cnt].yn);	
				break;
			}
			

			for(int m=six_set*6; m<six_set*6+6; m++) {
					newList.add(m, oldList.get(offset));
			}
			six_set++;
			
			System.out.println("갯수:"+daily_cnt);
			System.out.println("시간:"+mg[offset].time+", 마감여부:"+mg[offset].yn);
			offset = offset + daily_cnt;
			daily_cnt = 1;
		}
		System.out.println("변경전:"+oldList.size());
		for(int m=0; m<oldList.size(); m++) {
			System.out.println(oldList.get(m));
		}
		System.out.println("변경후:"+newList.size());
		for(int m=0; m<newList.size(); m++) {
			System.out.println(newList.get(m));
		}
		FileWriter fw = new FileWriter(".\\NEW_MAGAM.TXT");
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(int m=0; m<newList.size(); m++) {
			bw.write(newList.get(m));
			bw.newLine();
		}
		bw.close();
		*/
//		int[] numbers = {6, 10, 2, 5};
//		solution(numbers);
		List<String> input2 = Arrays.asList("2234", "123", "5678", "456", "8978", "3321", "12", "345", "689");
		getMaxNum(getSequenceList(input2));
		List<String> input3 = Arrays.asList(
				"KIM,CUST02,CREAM02,25,35000",
				"KIM,CUST01,CREAM02,23,35000",
				"LEE,CUST04,CREAM02,12,35000",
				"LEE,CUST04,LOTION01,28,17000",
				"LEE,CUST04,SKIN01,19,15000",
				"LEE,CUST03,CREAM01,14,30000",
				"KIM,CUST01,SKIN02,31,24000",
				"LEE,CUST04,CREAM02,4,35000",
				"KIM,CUST01,SKIN01,29,15000",
				"KIM,CUST04,CREAM02,15,35000"
				);
		String name = "CUST04";
		String term = "10-20";
		getCosmeticsList(input3, name, term);
		String sellerId = "KIM";
		String periodOfSale = "20-25";
		getPrice(input3, sellerId, periodOfSale);
		
		int[][] input4 = {{-1,0,7,9},
							{-6,2,-3,5},
							{3,-6,0,-5},
							{7,8,-7,2}
		};
		getNumberOfSubArrays(input4.length);
		getMaximumNumber(input4);
		int[][] input5 = {{1,-3,0,2,5},
							{-3,0,8,-3,7},
							{9,-1,-2,6,0},
							{-2,-5,9,7,6},
							{3,2,4,7,-5}
		};
		getNumberOfSubArrays(input5.length);
		getMaximumNumber(input5);
		
		String[][] input6 = {
				{"M", "B"},
				{"M", "C"},
				{"M", "K"},
				{"B", "E"},
				{"C", "F"},
				{"C", "G"},
				{"C", "H"},
				{"K", "I"},
				{"K", "J"},
				{"E", "D"},
				{"F", "L"},
				{"F", "A"},
				{"H", "N"},
				{"H", "O"},
				{"J", "P"},
				{"J", "Q"}	
		};
		List<String> categories = Arrays.asList("F", "N");
		getTopCategory(input6, categories);
		String categoryStr = "J";
		getNumberOfSubcategories(input6, categoryStr);
		
		int[][] input7 = {{1099, 18, 0, 19, 15, 1},
				{1077, 19, 30, 0, 0, 0},
				{1044, 18, 45,21, 11, 0},
				{1088, 19, 30, 20, 28, 0},
				{1044, 18, 15, 19, 19, 1},
				{1044, 18, 0, 0, 0, 1}};
		countEmployeeNumber(sortTableByEmpno(input7, input7.length), input7.length);
		makeTotalTable(sortTableByEmpno(input7, input7.length), input7.length);
		
		String data[] = {"coffee", "eeFFCo", "amenr", "Ra Men", "CO FFE E",
				"coFfee", "c#off$ee", "cOe f%%&f*e", "bapgim", "rice", "RiCE", "*Ri&c@e",
				"gim $bap", "BAP@gim", "*G*imba p", "water", "FFCOEE", "WATER", "TERAW", "*tW$a ER#" };
//		makeNormalData(data, data.length);
//		correctLetterOrder(makeNormalData(data, data.length), data.length, products);
		makeDistinctedData(correctLetterOrder(makeNormalData(data, data.length), data.length, products), data.length);
		
		int[][] input8 = {
				{1,2,2,5,4},
				{3,1,3,3,2},
				{5,2,3,4,4},
				{2,4,4,5,1},
				{4,1,5,3,5}
		};
		setUpArray(rotateArray(input8));
		int[][] input9 = {
				{77,78,12,30},
				{33,78,9,7},
				{5,71,84,25},
				{9,37,0,27}
		};
		int[][] input10 = {
				{11,32,57,65,34},
				{53,16,3,93,22},
				{35,22,73,64,14},
				{12,24,34,45,91},
				{9,51,35,28,75}
		};
		getArrSum(getSortedArray(input9));
		getArrSum(getSortedArray(input10));
		
		int[][] input11 = {{1099, 18, 0, 20, 15, 1},
							  {1077, 19, 30, 10, 0, 0},
							  {1044, 18, 45,15, 11, 0},
							  {1088, 19, 40, 20, 28, 0},
							  {1055, 18, 15, 19, 19, 1},
							  {1011, 18, 0, 30, 0, 1}};
		jugiTable(input11);
		
		String input12 = "we1re3hewo34ddre67com21rue";
		String backup = "1ware4hewor5dd8eamcome3rue";
		String[] network = {"wear","ethe","worl","ddre","amco","metr","ue  "};
		getSecondRecovery(getFirstRecovery(input12, backup), network);
		
		List<List<Integer>> input13 = new ArrayList<List<Integer>>();
		int j=0, cnt=0;
		for(int t=0; t<10; t++) {
			List<Integer> list = new ArrayList<>();
			for(j=5*cnt; j<5*cnt+5; j++) {
//				Random rand = new Random();
//				System.out.println("1:"+rand.nextInt());
//				list.add(rand.nextInt());
				list.add(j);
			}
			cnt++;
			input13.add(list);
			System.out.println(list);
			System.out.println(input13);
		}
		System.out.println();
		int[][] convertArr = new int[input13.size()][input13.get(0).size()];
		for(i=0; i<input13.size(); i++) {
			for(j=0; j<input13.get(0).size(); j++) {
				convertArr[i][j] = input13.get(i).get(j);
				System.out.print(convertArr[i][j]+" ");
			}
			System.out.println();
		}
		List<String> input14 = Arrays.asList(
				"EE#20170503210008#MESSAGE02",
				"WW#20160303100009#MESSAGE04",
				"SS#20170403120807#MESSAGE03",
				"WW#20160708121400#MESSAGE04",
				"SS#20170606110000#MESSAGE04",
				"SS#20170505220008#MESSAGE02",
				"SS#20170405130007#MESSAGE03");
		countType(input14);
		compress1(new File(".\\ABCE.txt"));
		System.out.println();
		compress2(new File(".\\ABCE.txt"));
		sumThree(1);
		coolNumbers(1000);
		int[] input15 = {7,13,13,5,4,8,7,4,20,8};
		removeSame(input15);
		System.out.println();
		String input16 = "AAAABBBCDDEEEXXY";
		moveStr(input16);
		System.out.println();
		String input17 = "66#56#66#68#70#72#73#74#82#77";
		getMaxNumber(input17);
		/*
		int[][] input18 = {{1,2,3},
							  {4,5,6},
							  {7,8,9}};
		
//		printMatrix(input18);
		blindPhoneNumber("010-1234-5668");
		checkSame(52);
//		int[] input19 = {1,1,1,1,1,10,10,10,-1,-1};
//		perm(input19, 0);
//		System.out.println("caseCnt:"+caseCnt);
		int[] input20 = {2,3,4,7};
		lcm(input20);
		int[] input21 = {1,5,1,23,1,44,2,19,2,86,2,102,3,8,3,26,3,51,3,66};
		int[] input22 = {1,6,1,46,1,54,2,57,2,87,3,13,3,25,3,48,3,71};
		searchWord(input21, input22);
//		getWeekday(input18);
		int[] input23 = {7,8,12};
		divisor(input23);
		case_step(4);
		String input24 = "09:10~18:30#09:30~17:30#18:00~09:00#08:50~19:10#09:00~19:00#08:00~12:00";
		getWorkday(input24);
		getWorktime(input24);
		String input25 = "4aaA23d67e78ap!@#$889asd#77@76678#9333!@#367882";
		getSettingNumber(getInitialization(input25));
		List<TerminalInfo> input26 = Arrays.asList(
				new TerminalInfo("A", 6, 0, 15, 23, 30),
				new TerminalInfo("B", 5, 45, 30, 23, 45),
				new TerminalInfo("C", 7, 0, 15, 23, 45),
				new TerminalInfo("D", 5, 40, 20, 23, 40),
				new TerminalInfo("E", 6, 20, 10, 23, 50),
				new TerminalInfo("F", 6, 30, 30, 23, 30),
				new TerminalInfo("G", 7, 5, 15, 23, 35),
				new TerminalInfo("H", 6, 35, 15, 23, 50),
				new TerminalInfo("I", 6, 55, 25, 23, 35),
				new TerminalInfo("J", 6, 15, 35, 23, 45)				
				);
		TerminalInfo busInfo = new TerminalInfo("A", "D", 07, 10);
		getStartTime(input26, busInfo);
		getNumberOfPlatform(input26);
		parseAddress("./INFILE/INPUT_EMAIL.txt");
		parseAddressHashMap("./INFILE/INPUT_EMAIL.txt");
		getJarkad("FRANCE", "french");
		getJarkad("handshake", "shake hands");
		getJarkad("aa1+aa2", "AAAA12");
		getJarkad("E=M*C^2", "e=m*c^2");
		//sabunSearch("./INFILE/input_gate.txt");
		//ex1874();
		/*
		Scanner sc = new Scanner(System.in);
		String strInput, strId, strPassword;
		while(true) {
			strInput = sc.nextLine();
			if(strInput.length()<10) {
				System.out.println("Wrong ID Password");
				continue;
			}
			strId = strInput.substring(0, 8);
			strPassword = strInput.substring(9);
			if(login(strId, strPassword)) {
				System.out.println("LOGIN SUCCESS");
			} else {
				System.out.println("LOGIN FAIL");
			}
			
		}
		//sc.close();
		 
		 */
		//String input16 = "AAAABBBCDDEEEXXY";
		countChar(input16);
		String input18="89 90 50 87 89 66 89 77 89 50";
		guessWhat(input18);
	}
	public static void guessWhat(String input) {
		int max=0, max_cnt=0;
		String[] str = input.split(" "); 
		int[] arr = new int[str.length];
		for(int i=0; i<str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
		for(int i=0; i<str.length; i++) {
			if(data.containsKey(arr[i])) {
				data.put(arr[i], data.get(arr[i])+1);
			} else {
				data.put(arr[i], 1);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>(data.keySet());
		Collections.sort(list);
		System.out.println(list);
		for(int key:list) {
			System.out.println("key:"+key+", value:"+data.get(key));
			if(data.get(key) >= max_cnt) {
				max = key;
				max_cnt = data.get(key);
			}
		}
		System.out.println("max value:"+max+", max cnt:"+max_cnt);
	}
	public static String countChar(String input) {
		String result="", str="";
		for(int i=0; i<input.length(); i++) {
			str += input.charAt(i);
			if(i>=input.length()-1) {
				result += input.charAt(i)+""+str.length();
				break;
			}
			if(input.charAt(i)!=input.charAt(i+1)) {
				result += input.charAt(i)+""+str.length();
				str="";
			}
		}
		System.out.println("countChar result:"+result);
		return result;
	}
	public static List<List<Integer>> checkValue(List<List<Integer>> sample) {
		List<List<Integer>> check = new ArrayList<List<Integer>>();
		for(List<Integer> list:sample) {
			List<Integer> tmp = new ArrayList<>(list);
			check.add(tmp);
		}
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		for(int i=0; i<sample.size(); i++) {
			for(int j=0; j<sample.get(i).size(); j++) {
				for(int d=0; d<4; d++) {
					int x = i+di[d];
					int y = j+dj[d];
					if(x>=0 && x<sample.size() && y>=0 && y<sample.get(i).size()) {
						if(sample.get(i).get(j)==sample.get(x).get(y)) {
							check.get(i).set(j, 0);
							break;
						}
					}
				}
			}
		}
		return check;
	}
	public static void gradeSorting() throws IOException {
		ArrayList<Grade> al = new ArrayList<Grade>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("DS_sample.txt"));
			String str="";
			while((str = br.readLine())!=null) {
				String[] words = str.split(" ");
				Grade g = new Grade(words[0], Integer.parseInt(words[1]), Integer.parseInt(words[2]), Integer.parseInt(words[3]));
				al.add(g);
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void sendToServer() throws IOException {
		Socket socket = null;
		DataOutputStream os = null;
		try {
			socket = new Socket("127.0.0.1", 27015);
			os = new DataOutputStream(socket.getOutputStream());
			byte[] buffer = new byte[4096];
			int length=0;
			File directory = new File("..//"+insId);
			File[] fList = directory.listFiles();
			for(File file:fList) {
				if(file.isFile()) {
					os.writeUTF(file.getName());
					os.writeInt((int)file.length());
					FileInputStream is = null;
					try {
						is = new FileInputStream(file.getPath());
						while((length = is.read(buffer))!=-1) {
							os.write(buffer, 0, length);
						}
					} finally {
						if(is!=null) {
							is.close();
						}
					}
					moveFileToBackup(file.getPath(), file.getName());
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(socket!=null) {
				socket.close();
			}
			if(os!=null) {
				os.close();
			}
		}
	}
	public static void moveFileToBackup(String path, String name) {
		File fileFrom = new File(path);
		File fileTo = new File("..//BACKUP//"+name);
		fileTo.delete();
		fileFrom.renameTo(fileTo);
	}
	public static void saveToFile(String cardInfo, String validateCode, String inspectTime) throws IOException {
		File destFolder = new File("..//"+insId);
		if(!destFolder.exists()) {
			destFolder.mkdirs();
		}
		String strFilename = destFolder + "//" + insId + "_" + onBusTime + ".TXT";
		FileWriter fw = null;
		try {
			fw = new FileWriter(strFilename, true);
			fw.write(insId+"#"+onBusId+"#"+cardInfo+"#"+validateCode+"#"+inspectTime+"\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw!=null) {
				fw.close();
			}
		}
	}
	public static boolean login(String id, String psw) throws /*NoSuchAlgorithmException,*/ IOException {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("..//CLIENT//INSPECTION.TXT"));
			String line = in.readLine();
			//String encPsw = passwordEncryption(psw);
			if(line!=null) {
				String fileId = line.substring(0, 8);
				String filePwd = line.substring(9);
				if(id.equals(fileId) && psw.equals(filePwd)) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				in.close();
			}
		}
		return false;
	}
	public static void ex1874() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] stack = new int[n];
		int top=0, i=0, max=0;
		while(n-->0) {
			int temp = Integer.parseInt(br.readLine());
			if(temp>max) {
				for(i=max+1; i<=temp; i++) {
					stack[top++] = i;
					sb.append("+\n");
				} 
				max = temp;
			} else 	if(stack[top-1]!=temp) {
					System.out.println("NO");
					return;
			}
			top--;
			sb.append("-\n");
		}
		System.out.println(sb);
	}
	public static void ex9012() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int i=0;
		while(n-->0) {
			boolean isVPS = true;
			String input = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			for(i=0; i<input.length(); i++) {
				char ch = input.charAt(i);
				if(ch=='(') {
					stack.push(ch);
				}
			}
		}
	}
	public static void sabunSearch(String input) throws IOException {
		String line = "";
		String[] gate = new String[100];
		String[] gate_new = new String[100];
		int gate_cnt=0, i=0, new_cnt=0, j=0, same_flag=0;
		while(true) {
			Scanner sc = new Scanner(System.in);
				while(sc.hasNextInt()) {
					int sabun = sc.nextInt();
					FileReader f = new FileReader("./INFILE/input_gate.txt");
					BufferedReader br = new BufferedReader(f);
					FileWriter fw = new FileWriter("./OUTFILE/output_gate.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					gate = new String[100];
					gate_new = new String[100];
					gate_cnt=0; 
					new_cnt=0;
					while(true) {
						line = br.readLine();
						if(line!=null) {
							String[] str = line.split("#");
							if(Integer.parseInt(str[0])==sabun) {
								for(i=0; i<gate_cnt; i++) {								
									if(str[1].equals(gate[i])==false) {
										System.out.println("2:"+sabun+","+str[1]+","+gate[i]);
										gate[gate_cnt] = str[1];
										gate_cnt++;
										break;
									} else {
										continue;
									}
								}
								if(i==gate_cnt) {
									gate[gate_cnt] = str[1];
									gate_cnt++;		
									System.out.println("1:"+sabun+","+gate[i]);
								}
							}
						} else {
							break;
						}
					}
					System.out.println("4:"+gate_cnt);
		
					for(i=0; i<gate_cnt; i++) {
						same_flag = 0;
						for(j=0; j<gate_cnt; j++) {
							if(gate[i].equals(gate_new[j]) == true) {
								same_flag = 1;
								break;
							}
						}
						if(same_flag == 0) {
							gate_new[new_cnt] = gate[i];
							new_cnt++;					
						}
					}
					/*
					if(same_flag == 0) {
						gate_new[new_cnt] = gate[i];
						new_cnt++;					
					}
					*/
					for(i=0; i<new_cnt; i++) {
						System.out.println("3:"+gate_new[i]);
					}
					System.out.println("5:"+new_cnt);
					bw.write(String.valueOf(sabun)+",");
					for(i=0; i<new_cnt-1; i++) {
//						System.out.println("3:"+gate_new[i]);
						bw.write(gate_new[i]+",");
					}
					bw.write(gate_new[new_cnt-1]);
					bw.newLine();
					br.close();
					bw.close();
				}
				sc.close();
		}
	}
	public static int getJarkad(String str1, String str2) {
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		String temp = "";
		for(int i=0; i<str1.length()-1; i++) {
			temp = str1.substring(i, i+2).toUpperCase();
			if(temp.matches("^[A-Z]+$")) {
				list1.add(temp);
			}
		}
		for(int i=0; i<str2.length()-1; i++) {
			temp = str2.substring(i, i+2).toUpperCase();
			if(temp.matches("^[A-Z]+$")) {
				list2.add(temp);
			}
		}
		ArrayList<String> unionList = getUnionList(list1, list2);
		System.out.println("unionList:"+unionList);
		ArrayList<String> intersectionList = getIntersectionList(list1, list2);
		System.out.println("intersectionList:"+intersectionList);
		if(intersectionList.size()==0) {
			System.out.println(65536);
			return 65536;
		}
		else {
			System.out.println(intersectionList.size()+", "+unionList.size());
			return (intersectionList.size()/unionList.size())*65536;
		}
	}
	public static ArrayList<String> getUnionList(ArrayList<String> list1, ArrayList<String> list2) {
		ArrayList<String> unionList = new ArrayList<>();
		list1 = (ArrayList<String>)list1.clone();
		System.out.println("list1:"+list1);
		list2 = (ArrayList<String>)list2.clone();
		System.out.println("list2:"+list2);
		for(String str:list1) {
			if(list2.contains(str)) {
				list2.remove(str);
			}
			unionList.add(str);
		}
		System.out.println("list22:"+list2);
		unionList.addAll(list2);
		return unionList;
	}
	public static ArrayList<String> getIntersectionList(ArrayList<String> list1, ArrayList<String> list2) {
		ArrayList<String> intersectionList = new ArrayList<>();
		list1 = (ArrayList<String>)list1.clone();
		System.out.println("list111:"+list2);
		list2 = (ArrayList<String>)list2.clone();
		System.out.println("list222:"+list2);
		for(String str:list1) {
			if(list2.contains(str)) {
				intersectionList.add(str);
				list2.remove(str);
			}
		}
		System.out.println("list2222:"+list2);
		return intersectionList;
	}
	public static List<String> sortByValue(Map map) {
		List<String> result = new ArrayList<>();
		result.addAll(map.keySet());
		Collections.sort(result, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				return ((Comparable)v1).compareTo(v2);
			}
		});
		return result;
	}
	public static void parseAddressHashMap(String input) throws IOException {
		FileReader ff = new FileReader("./INFILE/INPUT_EMAIL.txt");
		BufferedReader br = new BufferedReader(ff);
		String line = "";
		Map<String,String> map = new HashMap<String,String>();
		while(true) {
			line = br.readLine();
			if(line!=null) {
				String[] str = line.split("#");
				if(str[1].contains("010")) {
					map.put(str[0], str[1]);
				}
			} else {
				break;
			}
		}
		Iterator itr = map.keySet().iterator();
		while(itr.hasNext()) {
			String key = (String)itr.next();
			System.out.println("정렬전:"+key+", "+map.get(key));
		}
		Iterator it = sortByValue(map).iterator();
		while(it.hasNext()) {
			String key = (String)it.next();
			System.out.println("정렬후:"+key+", "+map.get(key));
		}
		br.close();
	}
	public static void parseAddress(String input) throws IOException {
		FileReader ff = new FileReader("./INFILE/INPUT_EMAIL.txt");
		BufferedReader br = new BufferedReader(ff);
		String phone = "";
		int line_cnt=0, min=0, j=0;
		String[] phone_list = new String[10];
		String[] name_list = new String[10];
		String[] email_list = new String[10];
		while(true) {
			String line = br.readLine();
			phone = "";
			if(line!=null) {
				String[] strArr = line.split("#");
				name_list[line_cnt] = strArr[0];
				for(int i=0; i<strArr.length; i++) {
					if(strArr[i].contains("010")) {
						phone += strArr[i] + "#";
					}
				}
				email_list[line_cnt] = strArr[strArr.length-1];
				phone_list[line_cnt] = phone;
				System.out.println(name_list[line_cnt]+", "+phone_list[line_cnt]+", "+email_list[line_cnt]);
				line_cnt++;
			} else {
				break;
			}
		}
		for(int i=0; i<phone_list.length; i++) {
//			phone_list[i] = phone_list[i].substring(0, phone_list[i].length()-1);
			if(phone_list[i] != null ) {
				String[] strPhone = phone_list[i].split("#");
				
//				System.out.println(strPhone.length);
				for(j=0; j<strPhone.length-1; j++) {
					min = j;
//					System.out.println("1:"+mid);
					for(int k=j+1; k<strPhone.length; k++) {
						String[] phone_number = strPhone[min].split("-");
						int mid = Integer.parseInt(phone_number[1]);
						String[] phone_number2 = strPhone[k].split("-");
						int mid2 = Integer.parseInt(phone_number2[1]);
//						System.out.println("2:"+mid2);
						if(mid > mid2) {
//							System.out.println("정렬전:"+mid+","+mid2);
							min = k;
						}
					}
					String temp = strPhone[j];
					strPhone[j] = strPhone[min];
					strPhone[min] = temp;
				}

				for(j=0; j<strPhone.length; j++) {
					System.out.println("정렬후:"+strPhone[j]+",");
				}
			}
			System.out.println();
		}
		File[] f_list = new File("./").listFiles();
		for(int i=0; i<f_list.length; i++) {
			System.out.println(f_list[i]);
		}
		br.close();
		
	}
	public static String format(int number) {
		String f = "0"+number;
		return f.substring(f.length()-2);
	}
	public static List<Integer> getSchedules(TerminalInfo info) {
		int beginHour = info.getFirstHour();
		int beginMinute = info.getFirstMinute();
		int endHour = info.getLastHour();
		int endMinute = info.getLastMinute();
		int interval = info.getInterval();
		List<Integer> timetable = new ArrayList<>();
		System.out.println("승차 시작 시간:"+beginHour+", "+beginMinute+", "+endHour+", "+endMinute+", "+interval);
		for(int i=(beginHour*60)+beginMinute; i<=(endHour*60)+endMinute; i+=interval) {
			System.out.println("승차시간:"+i);
			timetable.add(i);
		}
		return timetable;
	}
	public static String getStartTime(List<TerminalInfo> input, TerminalInfo businfo) {
		String startTime = null;
		TerminalInfo infoA = null;
		TerminalInfo infoB = null;
		for(TerminalInfo info:input) {
			if(info.getName().equals(businfo.getName())) {
				System.out.println("1:::");
				infoA = info;
			}
			if(info.getName().equals(businfo.getName2())) {
				System.out.println("2:::");
				infoB = info;
			}
		}
		List<Integer> scheduleA = null;
		List<Integer> scheduleB = null;
		scheduleA = getSchedules(infoA);
		System.out.println("3:::");
		scheduleB = getSchedules(infoB);
		System.out.println("4:::");
		int beginMins = businfo.getFirstHour() * 60 + businfo.getFirstMinute();
		System.out.println("5:::"+beginMins);
		int i=0, j=0;
		for(i=0; i<scheduleA.size(); i++) {
			if(scheduleA.get(i) >= beginMins) {
				System.out.println("최초 A 승차시간:"+scheduleA.get(j));
				break;
			}
		}
		for(j=0; j<scheduleB.size(); j++) {
			if(scheduleB.get(j) >= beginMins) {
				System.out.println("최초 B 승차시간:"+scheduleB.get(j));
				break;
			}
		}
		for( ; i<scheduleA.size(); i++) {
			for(int k=j; k<scheduleB.size(); k++) {
				if(scheduleA.get(i) == scheduleB.get(k)) {
					startTime = format(scheduleB.get(k)/60) + ":" + format(scheduleB.get(k)%60);
					System.out.println("최초 시작 승차시간:"+startTime);
				}
			}
		}
		return startTime;
	}
	public static int getNumberOfPlatform(List<TerminalInfo> input) {
		int numberOfPlatform = 0;
		Map<Integer, Integer> timetable = new HashMap<>();
		List<Integer> schedule = null;
		for(TerminalInfo info:input) {
			schedule = getSchedules(info);
			for(Integer time:schedule) {
				if(timetable.containsKey(time)) {
					timetable.put(time, timetable.get(time)+1);
				} else {
					timetable.put(time, 1);
				}
			}
		}
		for(Integer key:timetable.keySet()) {
			if(numberOfPlatform < timetable.get(key)) {
				System.out.println(key+":"+timetable.get(key));
				numberOfPlatform = timetable.get(key);
			}
		}
		System.out.println(numberOfPlatform);
		return numberOfPlatform;
	}
	public static List<List<Integer>> getSettingNumber(List<List<Integer>> initialization) {
		List<List<Integer>> result = null;
		result = new ArrayList<>();
		int N = initialization.size();
		int[][] board = new int[N][N];
		boolean[][] bool1 = new boolean[N][N];
		boolean[][] bool2 = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j] = initialization.get(i).get(j);
				bool1[i][j] = false;
				bool2[i][j] = false;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(bool1[i][j] == true) {
					if(j<N-1 && board[i][j]==board[i][j+1]) {
						bool1[i][j+1] = true;
					} 
				}
				else {
					if(j<N-2 && board[i][j]==board[i][j+1] && board[i][j+1]==board[i][j+2]) {			
						bool1[i][j] = true;
						bool1[i][j+1] = true;
						bool1[i][j+2] = true;
					}
				}
				if(bool2[i][j] == true) {
					if(i<N-1 && board[i][j]==board[i+1][j]) {
						bool2[i+1][j] = true;
					} 
				}
				else {
					if(i<N-2 && board[i][j]==board[i+1][j] && board[i+1][j]==board[i+2][j]) {			
						bool2[i][j] = true;
						bool2[i+1][j] = true;
						bool2[i+2][j] = true;
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			List<Integer> list = new ArrayList<>();
			for(int j=0; j<N; j++) {
				if(bool1[i][j]==true || bool2[i][j]==true) {
					list.add(0);
				} else {
					list.add(board[i][j]);
				}
			}
			System.out.println(list);
			result.add(list);
		}
		return result;
	}
	public static List<List<Integer>> getInitialization(String input) {
		List<List<Integer>> result = null;
		result = new ArrayList<>();
		String temp = "";
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i)>='1' && input.charAt(i)<='9') {
				temp += input.charAt(i);
			}
		}
		System.out.println("temp:"+temp);
		int N = (int)Math.sqrt(temp.length());
		for(int i=0; i<N; i++) {
			List<Integer> list = new ArrayList<>();
			for(int k=0; k<N; k++) {
//				String tmpStr = "";
//				tmpStr += temp.charAt(N*i+k);
//				System.out.print(Integer.parseInt(tmpStr));
//				list.add(Integer.parseInt(tmpStr));
				System.out.print(Integer.parseInt(String.valueOf(temp.charAt(N*i+k)))+" ");
				list.add(Integer.parseInt(String.valueOf(temp.charAt(N*i+k))));
			}
			System.out.println();
			result.add(list);
		}
		return result;
	}
	public static List<Integer> getWorktime(String input) {
		List<Integer> result = null;
		result = new ArrayList<>();
		result.add(0);
		result.add(0);
		String[] worktime = input.split("#");
		for(int i=0; i<worktime.length; i++) {
			String[] starttime = worktime[i].split("~");
			String[] start = starttime[0].split(":");
			String[] end = starttime[1].split(":");
			int starthour = Integer.parseInt(start[0]);
			int endhour = Integer.parseInt(end[0]);
			int startm = Integer.parseInt(start[1]);
			int endm = Integer.parseInt(end[1]);
			if(endhour == 12) {
				endm = 0;
				System.out.println("1. starthour:"+starthour+", endhour:"+endhour);	
			} 
			if(starthour == 12) {
				System.out.println("2. starthour:"+starthour+", endhour:"+endhour);
				starthour = 13;
				startm = 0;
			}
			if(endhour > 12) {
				endhour -= 1;
				System.out.println("3. starthour:"+starthour+", endhour:"+endhour);	
			} 
			if(starthour > 12) {
				System.out.println("4. starthour:"+starthour+", endhour:"+endhour);
				starthour -= 1;
			}
			int hour = endhour - starthour;
			int min = endm - startm;
		
			if(hour>0) {
				if(min < 0) {
					int input_h = result.get(0) + hour-1;
					int input_m = result.get(1) + min + 60;
					result.set(0, input_h);
					result.set(1, input_m);
				} else {
					int input_h = result.get(0) + hour;
					int input_m = result.get(1) + min;
					result.set(0, input_h);
					result.set(1, input_m);					
				}
			} else if(hour == 0) {
				if(min > 0) {
					int input_m = result.get(1) + min;
					result.set(1, input_m);
				}
			}
		}
		if(result.get(1) > 60) {
			result.set(0, result.get(0)+result.get(1)/60);
			result.set(1, result.get(1)%60);
		}
		System.out.println("result:"+result);
		return result;
	}
	
	public static int getWorkday(String input) {
		int result = 0;
		String[] worktime = input.split("#");
		for(int i=0; i<worktime.length; i++) {
			String[] starttime = worktime[i].split("~");
			String[] start = starttime[0].split(":");
			String[] end = starttime[1].split(":");
			int starthour = Integer.parseInt(start[0]);
			int endhour = Integer.parseInt(end[0]);
			if(starthour < endhour) {
				System.out.println("starthour:"+starthour+", endhour:"+endhour);
				result++;
			} else if(starthour == endhour) {
				int startm = Integer.parseInt(start[1]);
				int endm = Integer.parseInt(end[1]);
				if(startm < endm) {
					System.out.println("startm:"+startm+", endm:"+endm);
					result++;					
				}
			}
		}
		System.out.println("result:"+result);
		return result;
	}
	public static int case_step(int n) {
		if(n==1 || n==0) {
			System.out.println("n=1||n=0:"+n);
			return 1;
		}
		else if(n==2) {
			System.out.println("n=2:"+n);
			return 2;
		}
		else {
			int sum = 0;
			for(int i=3; i>=1; i--) {
				sum += case_step(n-i);
				System.out.println("n=3?"+n+", sum:"+sum);
			}
			System.out.println("sum:"+sum);
			return sum;
		}
	}
	public static List<Integer> divisor(int[] input) {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<input.length; i++) {
			for(int k=1; k<=input[i]; k++) {
				if(input[i] % k == 0) {
					if(!list.contains(k)) {
						list.add(k);
					}
				}
			}
		}
		Collections.sort(list);
		System.out.println(list);
		return list;
	}
	public static void getWeekday(int[][] arr) {
		Scanner sc = new Scanner(System.in);
		System.out.println("x월? : ");
		int x = sc.nextInt();
		System.out.println("y일? : ");
		int y = sc.nextInt();
		Calendar time = Calendar.getInstance();
		SimpleDateFormat sd = new SimpleDateFormat("E요일");
		time.set(2018, x-1, y, 0, 0, 0);
		System.out.println(sd.format(time.getTime()));
	}
	public static List<Integer> searchWord(int[] idx1, int[] idx2) {
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		int len1 = idx1.length;
		int len2 = idx2.length;
		for(int i=0; i<len1; i++) {
			list = new ArrayList<>();
			for(int k=0; k<len2; k++) {
				if(i%2==0 && k%2==0) {
					if(idx1[i] == idx2[k]) {
						if(idx1[i+1]+1 == idx2[k+1]) {
							list.add(idx1[i]);
							list.add(idx1[i+1]);
							list.add(idx1[i+1]+1);
							System.out.println(list);
						}
					}
					result.add(list);
				}
			}
		}
		return list;
	}
	public static int lcm(int[] arr) {
		int maxNum = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > maxNum) {
				maxNum = arr[i];
			}
		}
		int answer = maxNum;
		
		while(true) {
			boolean isLcm = true;
			for(int e:arr) {
				if(answer % e != 0) {
					isLcm = false;
				}
			}
			if(isLcm) {
				System.out.println("answer:"+answer);
				break;
			} else {
				System.out.println("1. answer:"+answer);
				answer++;
			}
		}
		return answer;
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void perm(int[] arr, int pivot) {
		//int[] arr_int = {1,1,1,1,1,10,10,10,-1,-1};
		System.out.println("pivot:"+pivot+", arr.length:"+arr.length);
		if(pivot == arr.length) {
			boolean isT = true;
			for(int i=0; i<arr.length-1; i++) {
				System.out.print(arr[i] + "   " + arr[i+1] + "  ");
				if(((arr[i] + arr[i+1]) == 20) ||
						((arr[i] + arr[i+1]) == -2)) {
					System.out.println();
					System.out.println("arr[i] + arr[i+1]:"+(arr[i] + arr[i+1]));
					isT = false;
//					break;
				}
			}	
			if(isT) {
				caseCnt++;
				System.out.println();
				System.out.println("caseCnt:"+caseCnt);
			}
			
			return;
		}
		for(int i=pivot; i<arr.length; i++) {
			swap(arr, i, pivot);
			perm(arr, pivot+1);
			swap(arr, i, pivot);
		}

	}
	public static int checkSame(int input) {
		int cnt=0, sum=0;
		input++;
		while(true) {
			char[] ch = Integer.toString(input).toCharArray();
			boolean isSame = false;
			for(int i=0; i<ch.length-1; i++) {
				for(int j=i+1; j<ch.length; j++) {
					if(ch[i] == ch[j]) {
						isSame = true;
						System.out.println("isSame true:"+isSame);
						break;
					} else {
						isSame = false;
					}
				}
			}
			if(isSame == false) {
				sum += input;
				cnt++;
				System.out.println("input:"+input+", sum:"+sum);
				if(cnt==5) {
					System.out.println("sum:"+sum);
					return sum;
				}
			}
			input++;
		}

	}
	public static String blindPhoneNumber(String str) {
		String[] temp = str.split("-");
		String mid = temp[1].substring(0, 2) + "**";
		String end = "**" + temp[2].substring(2);
		String result = temp[0] + "-" + mid + "-" + end;
		System.out.println(result);
		return result;
	}
	public static int[][] printMatrix(int[][] input) {
		int[][] arr = new int[3][3];
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		while(cnt < 3) {
			String in = sc.nextLine();
			String[] str = in.split(" ");
			for(int i=0; i<str.length; i++) {
				arr[cnt][i] = Integer.parseInt(str[i]);
			}
			cnt++;
		}
		sc.close();
//		for(int i=0; i<arr.length; i++) {
		for(int j=0; j<arr[0].length; j++) {
			System.out.print(arr[2][j]+" ");
//				System.out.print(arr[0][j]+" ");
//				System.out.print(arr[1][j]+" ");
		}
		System.out.println();
		
		for(int j=0; j<arr[0].length; j++) {
			System.out.print(arr[0][j]+" ");
//			System.out.print(arr[0][j]+" ");
//			System.out.print(arr[1][j]+" ");
		}
		System.out.println();
		
		for(int j=0; j<arr[0].length; j++) {
			System.out.print(arr[1][j]+" ");
//			System.out.print(arr[0][j]+" ");
//			System.out.print(arr[1][j]+" ");
		}
		System.out.println();
//		}
		return arr;
	}
	public static int getMaxNumber(String input) {
		int result = 0, cnt=0, max=0;
		String prev = "";
		String[] str = input.split("#");
		Arrays.sort(str);
		for(int i=0; i<str.length; i++) {
			String one = str[i].substring(0, 1);
			if(prev.equals(one) == true) {
				cnt++;
			} else {
				if(cnt > max) {
					max = cnt;
					result = Integer.parseInt(prev);
				}
				cnt=1;
				prev = one;
			}
		}
		if(cnt > max) {
			max = cnt;
			result = Integer.parseInt(prev);
		}
		System.out.println("result:"+result+", max:"+max);
		return result;
	}
	public static String moveStr(String input) {
		String result = "";
		String result1 = "";	// 짝수+홀수
		String result2 = "";	// 짝수만 꺼꾸로
		int cnt=0, i=0;
		char prev = ' ';
		for(i=0; i<input.length(); i++) {	
			if(input.charAt(i) != prev) {
				if(cnt%2 == 0) {
					for(int k=0; k<cnt/2; k++) {
						result1 = result1 + prev;
						result2 = prev + result2;
					}
				} else {
					for(int k=0; k<cnt; k++) {
						result1 = result1 + prev;
					}
				}
				cnt = 1;
			} else {
				cnt++;
			}
			prev = input.charAt(i);
		}
//		System.out.println("1."+result1 + result2);
		if(cnt%2 == 0) {
			for(int k=0; k<cnt/2; k++) {
				result1 = result1 + prev;
				result2 = prev + result2;
			}
		} else {
			for(int k=0; k<cnt; k++) {
				result1 = result1 + prev;
			}
		}
		result = result1 + result2;
		System.out.println(result);
		return result;
	}
	public static List<Integer> removeSame(int[] input) {
		List<Integer> result = new ArrayList<>();
		List<Integer> result2 = new ArrayList<>();
		int[] arr = {7,13,13,5,4,8,7,4,20,8};
		HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
		List<Integer> temp = new ArrayList<>();
		for(int i:arr) {
			temp.add(i);
		}
		for(int i=0; i<temp.size(); i++) {
			if(set.containsKey(temp.get(i)) == false) {
				set.put(temp.get(i), 1);
			} else {
				set.replace(temp.get(i), set.get(temp.get(i))+1);
			}
		}
		
		for(int i:set.keySet()) {
			int value = set.get(i);
			if(value == 1) {
				result2.add(i);
			}
			System.out.println(i + ", " + value);
		}
		System.out.println(result2);
		for(int i=0; i<temp.size(); i++) {
			if(result.contains(temp.get(i)) == false) {
				result.add(temp.get(i));
			}
		}
		Collections.sort(result);
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i)+" ");
		}
		
		
		return result; 
	}
	public static int coolNumbers(int input) {
		int cnt=0;
		for(int k=100; k<input; k++) {
			String str = Integer.toString(k);
			char[] ch = str.toCharArray();
			int diff = ch[1] - ch[0];
			for(int i=str.length()-1; i>0; i--) {
				if(ch[i]-ch[i-1] != diff) break;
				if(i==1) cnt++;
			}
		}
		System.out.println("멋진수:"+cnt);
		return cnt;
	}
	public static int sumThree(int input) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();
		String str = "34 15 2 64 194 7";
		str = str.replace(" ", "");
		int sum = 0, len=0, n=0, num=0, cnt=0;
		len = str.length();
		while(n<=len) {
			if(cnt == len/3) {
				num = Integer.parseInt(str.substring(n));
				sum = sum+ num;
				System.out.println("2. num:"+num+", sum:"+sum);
				break;
			}
			num = Integer.parseInt(str.substring(n, n+3));
			n = n+3;
			cnt++;
			sum = sum+ num;
			System.out.println("1. num:"+num+", sum:"+sum);
		}
//		sc.close();
		System.out.println("sum:"+sum);
		return sum;
	}
	public static String compress2(File file) {
		File file2 = new File("ABCE.txt");
		String line = "";
		String temp="";
		int same_cnt=1, i=0;
		try {
			Scanner sc = new Scanner(file2);
			
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				char[] ch = line.toCharArray();
				same_cnt=1;
				for(i=0; i<ch.length; i++) {
					if(i==ch.length-1) {
						if(same_cnt==1) {
							temp += String.valueOf(ch[i]);
						} else if(same_cnt==2) {
							temp += String.valueOf(ch[i]) + String.valueOf(ch[i]);
						} else {
							temp += String.valueOf(same_cnt) + String.valueOf(ch[i]);
						}
						break;
					} else {
						if(ch[i] != ch[i+1]) {
							if(same_cnt==1) {
								temp += String.valueOf(ch[i]);
							} else if(same_cnt==2) {
								temp += String.valueOf(ch[i]) + String.valueOf(ch[i]);
							} else {
								temp += String.valueOf(same_cnt) + String.valueOf(ch[i]);
							}
							same_cnt=1;
						} else {
							same_cnt++;
						}
					}
				}
				temp += "\n\r";
				System.out.println(temp);
			}
			sc.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return temp;
	}
	public static String compress1(File file){
		File file2 = new File("ABCE.txt");
		StringBuilder sb = new StringBuilder();
		String temp="";
		int same_cnt=0;
		if(file2!=null) {
			try {
				Scanner sc = new Scanner(file2);
				while(sc.hasNextLine()) {
					String str = sc.nextLine();
//					System.out.println(str);
					if(str!=null) {
						if(str.equals(temp) == false) {
							if(same_cnt>0) {
								
								str = String.valueOf(same_cnt+1)+"#"+temp;
								sb.append(str);
								sb.append("\n");
								temp = str.substring(2);
//								System.out.println("1:"+sb.toString());
							} else {
								temp = str;
								sb.append(temp);
								sb.append("\n");		
//								System.out.println("2:"+sb.toString());
							}
							
							same_cnt=0;
						} else {
							same_cnt++;
						}
					}
					
				}
				sc.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	public static HashMap<String, Integer> countType(List<String> input) {
		int i=0, j=0, type_cnt=0, same_cnt=0;
		String temp="";
		//int[][] result = new int[input.size()][2];
		HashMap<String, Integer> result = new HashMap<>();
		for(i=0; i<input.size(); i++) {
			String[] strArr = input.get(i).split("#");
//			if(temp.equals(strArr[0]) == false) {
				if(result.containsKey(strArr[0])) {
					result.replace(strArr[0], result.get(strArr[0])+1);
					same_cnt++;
				} else {
					same_cnt=0;
					temp = strArr[0];
					result.put(temp, 1);
					type_cnt++;
				}
//			} else {
//				result.replace(temp, result.get(temp)+1);
//				same_cnt++;			
//			}
		}
		for(String key:result.keySet()) {
			int value = result.get(key);
			System.out.println(key+" "+value);
		}
		return result;
	}
	/*
	public static int[][] convertToArr(List<List<Integer>> input) {
		List<List<Integer>> input2 = new ArrayList<>();
		int i=0, j=0;
		for(i=0; i<10; i++) {
			List<Integer> list = new ArrayList<>();
			for(j=0; j<5; j++) {
				Random rand = new Random();
				list.add(rand.nextInt());
			}
			input2.add(list);
			System.out.println(list);
		}
		return input2;
	}
	*/
	public static String getSecondRecovery(String first, String[] network) {
		char[] chInput = first.toCharArray();
		String str = "";
		for(int i=0; i<network.length; i++) {
			str += network[i].trim();
		}
		System.out.println("network:"+str);
		char[] chNetwork = str.toCharArray();
		for(int j=0; j<first.length(); j++) {
			if((first.charAt(j) >= '0' && first.charAt(j) <= '9') && (str.charAt(j) >= 'a' && str.charAt(j) <= 'z')) {
				chInput[j] = chNetwork[j];
			}
		}
		String result = String.valueOf(chInput);
		System.out.println("second result:"+result);
		return result;		
	}
	public static String getFirstRecovery(String input, String backup) {
		char[] chInput = input.toCharArray();
		char[] chBack = backup.toCharArray();
		for(int i=0; i<input.length(); i++) {
			if((input.charAt(i) >= '0' && input.charAt(i) <= '9') && (backup.charAt(i) >= 'a' && backup.charAt(i) <= 'z')) {
				chInput[i] = chBack[i];
			}
		}
		String result = String.valueOf(chInput);
		System.out.println("result:"+result);
		return result;
	}
	public static int[][] jugiTable(int[][] otTable) {
		int size = otTable.length;
		int[] start_hh = new int[size];
		int[] start_mm = new int[size];
		int[] jugi_mm = new int[size];
		int[][] result = new int[size][5];
		int max = 0, time=0, cnt=0, max_idx=0, first=0, min=100;
		
		for(int i=0; i<size; i++) {
			result[i][0] = otTable[i][0];
			result[i][1] = otTable[i][1] * 60 + otTable[i][2] + otTable[i][3];
			time = result[i][1];
			System.out.println("time:"+time);
			if(time>max) {
				max = time;
				max_idx = i;
				System.out.println("max time:"+time);
			}
		}
		System.out.println("start max:"+max+", max_idx:"+max_idx+", size"+size);
		for(int i=0; i<size; i++) {
//			first = 0;
			cnt=0;
			for(int j=0; j<=cnt; j++) {
				if((otTable[i][1] * 60 + otTable[i][2] + otTable[i][3]*cnt) == max) {
					System.out.println("1. start max:"+max+", i:"+i+", "+cnt+", "+(otTable[i][1] * 60 + otTable[i][2] + otTable[i][3]*cnt));				
				} else {
					cnt++;
				}
				if((otTable[i][1] * 60 + otTable[i][2] + otTable[i][3]*cnt) > max) {
					cnt = 0;
				} 
				result[i][2] = cnt;
				
			}
			System.out.println(Arrays.toString(result[i]));
		}
		for(int i=0; i<size; i++) {
			if(i != max_idx && result[i][2] !=0 ) {
				if(result[i][2] < min) {
					min = result[i][2];
				}
			}
		}
		System.out.println("min:"+min);
		return result;
	}
	public static int[][] getSortedArray(int[][] input) {
		int[][] sortedArray = null;
		int size = input.length;
		sortedArray = new int[size][size];
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				sortedArray[i][j] = input[i][j]%10;
			}
			System.out.println(Arrays.toString(sortedArray[i]));
		}
		System.out.println();
		for(int i=0; i<size; i++) {
			Arrays.sort(sortedArray[i]);
			System.out.println(Arrays.toString(sortedArray[i]));
		}
		System.out.println();
		for(int i=0; i<size; i++) {
			int[] num = new int[size];
			for(int j=0; j<size; j++) {
				num[j] = sortedArray[j][i];
			}
			Arrays.sort(num);
			for(int j=0; j<size; j++) {
				sortedArray[j][i] = num[j];
			}
		}
		System.out.println();
		for(int i=0; i<size; i++) {
			System.out.println(Arrays.toString(sortedArray[i]));
		}
		System.out.println();
		return sortedArray;
	}
	
	public static int[][] getArrSum(int[][] input) {
		int[][] result = null;
		int size = input.length;
		result = new int[size][size];
		int sum=0;
		for(int i=0; i<size; i++) {
			System.arraycopy(input[i], 0, result[i], 0, input.length);
			System.out.println(Arrays.toString(result[i]));
		}
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(j != size-1) {
					if(input[i][j] == input[i][j+1]) {
						result[i][j] = 0;
						result[i][j+1] = 0;
					}
				} 
				if(i != size-1) {
					if(input[i][j] == input[i+1][j]) {
						result[i][j] = 0;
						result[i+1][j] = 0;
					}
				} 
				if(i == size-1) {
					if(input[i][j] == input[i-1][j]) {
						result[i][j] = 0;
						result[i-1][j] = 0;
					}
				} 
				if(j == size-1) {
					if(input[i][j] == input[i][j-1]) {
						result[i][j] = 0;
						result[i][j-1] = 0;
					}
				}
			}
		}
		System.out.println();	
		for(int i=0; i<size; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				sum += result[i][j];
			}
		}
		System.out.println("sum:"+sum);
		return result;
	}
	public static int[][] rotateArray(int[][] input) {
		int[][] rotatedArray = new int[input.length][input[0].length];
		for(int i=0; i<input.length; i++) {
			System.arraycopy(input[i], 0, rotatedArray[i], 0, input.length);
		}
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input[0].length; j++) {
				if(i==0 || i==input.length-1 || j==0 || j==input[0].length-1) {
					rotatedArray[j][input.length-1-i] = input[i][j];
				}
			}
		}
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input[0].length; j++) {
				System.out.print(rotatedArray[i][j]+" ");
			}
			System.out.println();
		}
		return rotatedArray;
	}
	
	public static int[][] setUpArray(int[][] rotated) {
		int[][] setArr = new int[rotated.length][rotated[0].length];
		for(int i=0; i<rotated.length; i++) {
			System.arraycopy(rotated[i], 0, setArr[i], 0, rotated.length);
		}
		for(int i=1; i<rotated.length-1; i++) {
			for(int j=1; j<rotated[0].length-1; j++) {
				if(i==1) {
					if(setArr[i][j] == setArr[i-1][j]) {
						setArr[i][j] = 0;
					}
				}
				if(i==rotated.length-2) {
					if(setArr[i][j] == setArr[rotated.length-1][j]) {
						setArr[i][j] = 0;
					}
				}
				if(j==1) {
					if(setArr[i][j] == setArr[i][j-1]) {
						setArr[i][j] = 0;
					}
				}
				if(j==rotated[0].length-2) {
					if(setArr[i][j] == setArr[i][rotated[0].length-1]) {
						setArr[i][j] = 0;
					}
				}
			}
		}
		for(int i=0; i<rotated.length; i++) {
			for(int j=0; j<rotated[0].length; j++) {
				System.out.print(setArr[i][j]+" ");
			}
			System.out.println();
		}
		return setArr;
	}
	public static String[] makeNormalData(String[] data, int saleNumber) {
		String[] result = new String[saleNumber];
		int i=0, k=0;
		//System.out.println("1. data.length:"+data.length);
		for(i=0; i<saleNumber; i++) {
			String item = data[i];
			String newStr = "";
			//System.out.println("2. item:"+item);
			char[] chStr = item.toCharArray();
			for(k=0; k<chStr.length; k++) {
				if( (chStr[k] >= 'A' && chStr[k] <= 'Z') || (chStr[k] >= 'a' && chStr[k] <= 'z') ) {
					//System.out.println(chStr[k]);
					newStr = newStr + String.valueOf(chStr[k]);
					//System.out.println("3. item:"+item);
				}
			}
			newStr = newStr.toLowerCase();
			result[i] = newStr;
			System.out.println(result[i]);
		}
		return result;
	}
//	static String[] saleKind;
//	static String[] products = {"coffee", "gimbap", "water", "ramen", "kimchi", "rice", "cigarettes",
//								"milk", "popcorn", "chocolate", "paper", "soju", "beer"};	
	public static String[] correctLetterOrder(String[] saleKind, int saleNumber, String[] products) {
		String[] retData = new String[saleKind.length];
		String[] sortedProducts = new String[13];
		int i=0, n=0, k=0, t=0, cnt=0;
		char chTemp;
		
		for(i=0; i<products.length; i++) {
			sortedProducts[i] = new String(products[i]);
			char[] chPro = sortedProducts[i].toCharArray();
			for(n=0; n<sortedProducts[i].length()-1; n++) {
				for(k=n+1; k<sortedProducts[i].length(); k++) {
					if(chPro[n] > chPro[k]) {
						chTemp = chPro[n];
						chPro[n] = chPro[k];
						chPro[k] = chTemp;
					}
				}
			}
			sortedProducts[i] = new String(chPro, 0, chPro.length);
			System.out.println("1: sortedProducts[i]:"+sortedProducts[i]);
		}
		
		for(i=0; i<saleKind.length; i++) {
			char[] chPro = saleKind[i].toCharArray();
			for(n=0; n<saleKind[i].length()-1; n++) {
				for(k=n+1; k<saleKind[i].length(); k++) {
					if(chPro[n] > chPro[k]) {
						chTemp = chPro[n];
						chPro[n] = chPro[k];
						chPro[k] = chTemp;
					}
				}
			}
			String proImsi = new String(chPro, 0, chPro.length);
			for(t=0; t<sortedProducts.length; t++) {
				if(sortedProducts[t].equals(proImsi)) {
					retData[i] = products[t];
					System.out.println("2: retData[cnt]:"+retData[i]);
					break;
				}
			}
			
		}
		return retData;
	}
	
	public static String[] makeDistinctedData(String[] saleKind, int saleNumber) {
		String[] retData = new String[saleNumber];
		char found = 'N';
		int i=0, j=0, index=0, sw=0;
		char chFirst, chSecond;
//		System.out.println("5: saleKind.length:"+saleKind.length+", saleNumber:"+saleNumber);
		for(i=0; i<saleNumber; i++) {
			found = 'N';
			for(j=0; j<index; j++) {
//				System.out.println("4: retData[j]:"+retData[j]+", saleKind[i]:"+saleKind[i]);
				if(saleKind[i].equals(retData[j]) == true) {
					found = 'Y';
					break;
				}
			}
			if(found=='N') {
				retData[index] = saleKind[i];
				System.out.println("3: retData[index]:"+retData[index]);
				index++;
			}
		}
		String temp = "";
		for(i=0; i<index-1; i++) {
			for(j=i+1; j<index; j++) {
				chFirst = retData[i].charAt(1);
				chSecond = retData[j].charAt(1);
				if(chFirst > chSecond) {
					temp = retData[i];
					retData[i] = retData[j];
					retData[j] = temp;
				} else if(chFirst == chSecond) {
					chFirst = retData[i].charAt(0);
					chSecond = retData[j].charAt(0);
					if(chFirst > chSecond) {
						temp = retData[i];
						retData[i] = retData[j];
						retData[j] = temp;
					}
				}
			}
		}
		for(i=0; i<index; i++) {
			System.out.println("4: retData[i]:"+retData[i]);
		}
		return retData;
	}
	public static int[][] sortTableByEmpno(int[][] otTable, int row) {
		int[][] result = new int[row][otTable[0].length];
		int time1=0, time2=0;
		int[] temp = new int[row];
		for(int i=0; i<otTable.length-1; i++) {
			for(int j=i+1; j<otTable[0].length; j++) {
				if(otTable[i][0] > otTable[j][0]) {
					temp = otTable[i];
					otTable[i] = otTable[j];
					otTable[j] = temp;
				} else if(otTable[i][0] == otTable[j][0]) {
					time1 = otTable[i][1]*60 + otTable[i][2];
					time2 = otTable[j][1]*60 + otTable[j][2];
					if(time1 > time2) {
						temp = otTable[i];
						otTable[i] = otTable[j];
						otTable[j] = temp;						
					}
				}
			}
		}
		for(int i=0; i<otTable.length; i++) {
			System.out.println(Arrays.toString(otTable[i]));
		}		
		result = otTable;
		return result;
	}
	public static int countEmployeeNumber(int[][] otTable, int row) {
		int empNumber = 0;
		int time = 0;
		int[] empList = new int[row];
		int index = 0, i=0, j=0, cnt=0;
		int[] empSet = new int[row];
		
		for(i=0; i<otTable.length; i++) {
			time = otTable[i][3] * 60 + otTable[i][4];
			if(time != 0) {
				empList[index] = otTable[i][0]; 
				index++;
			}
		}
		empSet[cnt] = empList[0];
//		for(i=0; i<otTable.length; i++) {
			for(j=1; j<index; j++) {
				if(empSet[cnt] != empList[j]) {
					cnt++;
					empSet[cnt] = empList[j];
					System.out.println("1. cnt:"+cnt+", empSet[cnt]:"+empSet[cnt]);
				} else {
					System.out.println("2. cnt:"+cnt+", empSet[cnt]:"+empSet[cnt]);
				}
			}
//		}
		empNumber = cnt+1;
		System.out.println("empNumber:"+empNumber);
		return empNumber;
	}
	
	public static int[][] makeTotalTable(int[][] otTable, int row) {
		int retTable[][] = new int[row][2];
		int stime, etime, tripYN=0;
		int i, j, newRowNum=0, cnt=0;
		int newOtTable[][] = new int[row][6];
		int tmpTotalTable[][] = new int[row][4];
	
		for(i=0; i<otTable.length; i++) {
			etime = otTable[i][3] * 60 + otTable[i][4];
			if(etime != 0) {
				newOtTable[newRowNum] = otTable[i]; 
				newRowNum++;
			}
		}
		stime = newOtTable[0][1]*60 + newOtTable[0][2];
		etime = newOtTable[0][3]*60 + newOtTable[0][4];
		
		tmpTotalTable[0][0] = newOtTable[0][0];
		tmpTotalTable[0][1] = stime;
		tmpTotalTable[0][2] = etime;
		tmpTotalTable[0][3] = newOtTable[0][5];
		
		for(i=1; i<newRowNum; i++) {
			if(tmpTotalTable[cnt][0] != newOtTable[i][0]) {
				cnt++;
				tmpTotalTable[cnt][0] = newOtTable[i][0];
				stime = newOtTable[i][1]*60 + newOtTable[i][2];
				etime = newOtTable[i][3]*60 + newOtTable[i][4];		
				tmpTotalTable[cnt][1] = stime;
				tmpTotalTable[cnt][2] = etime;
				tmpTotalTable[cnt][3] = newOtTable[i][5];
			} else if(tmpTotalTable[cnt][0] == newOtTable[i][0]) {
				stime = newOtTable[i][1]*60 + newOtTable[i][2];
				etime = newOtTable[i][3]*60 + newOtTable[i][4];	
				tripYN = newOtTable[i][5];
				if(stime < tmpTotalTable[cnt][1]) {
					tmpTotalTable[cnt][1] = stime;
				}
				if(etime > tmpTotalTable[cnt][2]) {
					tmpTotalTable[cnt][2] = etime;
				}
				if(tripYN > tmpTotalTable[cnt][3]) {
					tmpTotalTable[cnt][3] = newOtTable[i][5];
				}
			}
			//System.out.println(Arrays.toString(newOtTable[i]));
		}
		cnt++;
		for(i=0; i<cnt; i++) {
			retTable[i][0] = tmpTotalTable[i][0];
			retTable[i][1] = tmpTotalTable[i][2] - tmpTotalTable[i][1];
			if(tmpTotalTable[i][3] == 1) {
				retTable[i][1] = (int)(retTable[i][1]*1.5);
			}
			System.out.println(Arrays.toString(retTable[i]));
		}
		return retTable;
	}
	public static String getTopCategory(String[][] input, List<String> categories) {
		String topCategory = "";
		Map<String, List<String>> tMap = new LinkedHashMap<String, List<String>>();
		for(int i=0; i<input.length; i++) {
			String parent = input[i][0];
			String child = input[i][1];
			if(tMap.containsKey(parent)) {
				List<String> childs = tMap.get(parent);
//				System.out.println("1. "+childs);
				childs.add(child);
//				System.out.println("1-1. "+childs);
				tMap.put(parent, childs);
			} else {
				List<String> childs = new ArrayList<String>();
//				System.out.println("2. "+childs);
				childs.add(child);
//				System.out.println("2-1. "+childs);
				tMap.put(parent, childs);
			}
		}
		List<String> hierarchy = new ArrayList<String>();
		boolean bFirst = false;
		int index = -1;
		for(String inputCategory:categories) {
			if(bFirst != true) {
				for(String key:tMap.keySet()) {
					List<String> values = tMap.get(key);
					if(values.contains(inputCategory)) {
						hierarchy.add(key);
						
						String parent = getParent(tMap, key);
						while(!parent.isEmpty()) {
							hierarchy.add(0, parent);
							parent = getParent(tMap, parent);
						}
						break;
					}
				}
				bFirst = true;
			} else {
				for(String key:tMap.keySet()) {
					List<String> values = tMap.get(key);
					if(values.contains(inputCategory)) {
						List<String> tHierarchy = new ArrayList<String>();
						tHierarchy.add(key);
						
						String parent = getParent(tMap, key);
						while(!parent.isEmpty()) {
							tHierarchy.add(0, parent);
							parent = getParent(tMap, parent);
						}
						for(String tParent:tHierarchy) {
							for(int i=0; i<hierarchy.size(); i++) {
								String oParent = hierarchy.get(i);
								if(oParent.equals(tParent)) {
									if(index < i) {
										index = i;
									}
									break;
								}
							}
						}
					}
				}				
			}
		}
		if(index > -1) {
			topCategory = hierarchy.get(index);
			System.out.println("topCategory:"+topCategory);
		}
		return topCategory;
	}
	
	public static int getNumberOfSubcategories(String[][] input, String categoryStr) {
		int numberOfCategories = 0;
		Map<String, List<String>> tMap = new LinkedHashMap<String, List<String>>();
		for(int i=0; i<input.length; i++) {
			String parent = input[i][0];
			String child = input[i][1];
			if(tMap.containsKey(parent)) {
				List<String> childs = tMap.get(parent);
//				System.out.println("1. "+childs);
				childs.add(child);
//				System.out.println("1-1. "+childs);
				tMap.put(parent, childs);
			} else {
				List<String> childs = new ArrayList<String>();
//				System.out.println("2. "+childs);
				childs.add(child);
//				System.out.println("2-1. "+childs);
				tMap.put(parent, childs);
			}
		}	
		for(String key:tMap.keySet()) {
			List<String> values = tMap.get(key);
			if(values.contains(categoryStr)) {
				String parent = getParent(tMap, categoryStr);
				List<String> children = new ArrayList<String>();
				getChildren(tMap, parent, children);
				numberOfCategories = children.size();
				System.out.println("3. "+children+", numberOfCategories: "+numberOfCategories);
				break;
			}
		}
		return numberOfCategories;
	}
	public static List<String> getChilds(Map<String, List<String>> tMap, String parent) {
		List<String> childs = new ArrayList<String>();
		for(int i=0; i<tMap.size(); i++) {
			if(tMap.containsKey(parent)) {
				childs = tMap.get(parent);
			}
		}
		return childs;
	}
	
	public static void getChildren(Map<String, List<String>> tMap, String parent, List<String> children) {
		List<String> tChildren = getChilds(tMap, parent);
		if(tChildren.size() >0) {
			children.addAll(tChildren);
		}
		for(String tChildParents:tChildren) {
			getChildren(tMap, tChildParents, children);
		}
	}
	public static String getParent(Map<String, List<String>> tMap, String child) {
		String parent = "";
		for(String key:tMap.keySet()) {
			List<String> values = tMap.get(key);
			if(values.contains(child)) {
				parent = key;
				break;
			}
		}
		return parent;
	}
	public static int getMaximumNumber(int[][] input) {
		int max=0, i=0, j=0, len=1, k=0, sum=0, t=0;
		while(len <= input.length) {
			for(i=0; i<=input.length-len; i++) {
				for(j=0; j<=input.length-len; j++) {
					sum = 0;
					for(k=i; k<i+len; k++) {
						for(t=j; t<j+len; t++) {
							sum = sum + input[k][t];
							System.out.println("k:"+k+", t:"+t+", sum:"+sum);
						}				
					}
					if(sum > max) {
						max = sum;
						System.out.println("i:"+i+", j:"+j+", max:"+max+", len:"+len);
					}	
				}

			}
			len++;
		}
		System.out.println(max);
		return max;
	}
	public static int getNumberOfSubArrays(int arraySize) {
		int sum=0;
		int i=0, j=0, len=1;
		while(len<=arraySize) {
			sum = sum+(len*len);
			len++;
		}
		System.out.println(sum);
		return sum;
	}
	public static int getPrice(List<String> input, String sellerId, String periodOfSale) {
		int i=0, j=0, start=0, end=0, price=0, sum=0;
		start = Integer.parseInt(periodOfSale.split("-")[0]);
		end = Integer.parseInt(periodOfSale.split("-")[1]);
		for(i=0; i<input.size(); i++) {
			String[] str = input.get(i).split(",");
			if(sellerId.equals(str[0])==true) {
				int date = Integer.parseInt(str[3]);
				if(date>=start && date<=end) {
						price = Integer.parseInt(str[4]);
						sum += price;
						System.out.println("price: "+price+", sum: "+sum);
					
				}
			}
		}
		System.out.println(sum);
		return sum;
	}
	public static List<String> getCosmeticsList(List<String> input, String name, String term) {
		List<String> result = new ArrayList<>();
		int i=0, j=0, start=0, end=0;
		start = Integer.parseInt(term.split("-")[0]);
		end = Integer.parseInt(term.split("-")[1]);
		for(i=0; i<input.size(); i++) {
			String[] str = input.get(i).split(",");
			if(name.equals(str[1])==true) {
				int date = Integer.parseInt(str[3]);
				if(date>=start && date<=end) {
					if(!result.contains(str[2])) {
						result.add(str[2]);
						System.out.println(str[2]);
					}
				}
			}
		}
		return result;
	}
	// List<String> input = Arrays.asList("2234", "123", "5678", "456", "8978", "3321", "12", "345", "689");
	public static int getMaxNum(List<String> input) {
		int i=0, max=0, min=1000;
		for(i=0; i<input.size(); i++) {
			if(Integer.parseInt(input.get(i)) > max) {
				max = Integer.parseInt(input.get(i));
			}
			if(Integer.parseInt(input.get(i)) < min) {
				min = Integer.parseInt(input.get(i));
			}
		}
		System.out.println("최대값:"+max+", 최소값:"+min);
		StringBuilder sb = new StringBuilder();
		sb.append(max);
		sb.append(min);
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append(max);
		sb2.append(min);
		if(Integer.parseInt(sb.toString()) > Integer.parseInt(sb2.toString())) {
			System.out.println("최종1 :"+Integer.parseInt(sb.toString()));
			return Integer.parseInt(sb.toString());
		} else {
			System.out.println("최종2 :"+Integer.parseInt(sb2.toString()));
			return Integer.parseInt(sb2.toString());
		}
		
	}
	public static List<String> getSequenceList(List<String> input) {
		List<String> result = new ArrayList<>();
		int i=0, j=0, sequence=0;
		for(i=0; i<input.size(); i++) {
			sequence=0;
			for(j=0; j<input.get(i).length()-1; j++) {
				if(Integer.parseInt(input.get(i).substring(j, j+1))+1 == Integer.parseInt(input.get(i).substring(j+1, j+2))) {
					sequence=1;
					continue;
				} else {
					sequence=0;
					break;
				}
			}
			if(sequence == 1) {
				result.add(input.get(i));
			}
		}
		System.out.println(result);
		return result;
	}
	public static int countWord(String message, String searchWord) {
		String[] word = message.split(" ");
		int cnt=0;
		for(int i=0; i<word.length; i++) {
			if(word[i].equals(searchWord)==true) {
				cnt++;
			}
		}
		System.out.println("cnt:"+cnt);
		return cnt;
	}
	public static int[][] rank(int[][] input) {
		int[][] result = new int[input.length][3];
		int[] temp = {0, 0};
		int num=1, i=0;

		for(i=0; i<input.length-1; i++) {
			for(int j=i+1; j<input.length; j++) {
				if(input[i][1] < input[j][1]) {
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}

		for(i=0; i<input.length-1; i++) {
			result[i][0] = input[i][0];
			result[i][1] = input[i][1];
			result[i][2] = num;
			if(input[i][1] != input[i+1][1])
			{
				num++;
			}
//			System.out.println(result[i][0]+" "+result[i][1]+" "+result[i][2]);
		}
		result[i][0] = input[i][0];
		result[i][1] = input[i][1];
		result[i][2] = num;
		for(i=0; i<input.length; i++) {
			System.out.println(result[i][0]+" "+result[i][1]+" "+result[i][2]);
		}
		return result;
	}
	// String inputMAC = "01:23:45:67:89:ab";
	public static String validateMacAddress(String inputMAC) {
		int cnt1=0, cnt2=0, cnt3=0;
		for(int i=0; i<inputMAC.length(); i++) {
			if(inputMAC.charAt(i) == ':') cnt1++;
			if(inputMAC.charAt(i) == '-') cnt2++;
			if(inputMAC.charAt(i) == '.') cnt3++;
		}
		if(cnt1>0) {
			if(cnt2>0 || cnt3>0)
				return null;
		}
		if(cnt2>0) {
			if(cnt1>0 || cnt3>0)
				return null;
		}
		if(cnt3>0) {
			if(cnt1>0 || cnt2>0)
				return null;
		}
		inputMAC = inputMAC.replaceAll(":", "");
		inputMAC = inputMAC.replaceAll("\\.", "");
		inputMAC = inputMAC.replaceAll("-", "");
		inputMAC = inputMAC.toLowerCase();
		for(int i=0; i<inputMAC.length(); i++) {
			if(!((inputMAC.charAt(i) >= 'a' && inputMAC.charAt(i) <= 'f')
					|| (inputMAC.charAt(i) >= '0' && inputMAC.charAt(i) <= '9')))
				return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(inputMAC.substring(0, 4));
		sb.append('.');
		sb.append(inputMAC.substring(4, 8));
		sb.append('.');
		sb.append(inputMAC.substring(8, 12));
		System.out.println(sb.toString());
		return sb.toString();
		
	}
	public static void printResult(String inputMAC) {
		if(validateMacAddress(inputMAC) != null) {
			System.out.println("올바른 MAC 주소입니다.");
		} else {
			System.out.println("올바르지 않은 MAC 주소입니다.");
		}
		System.out.println(inputMAC);
	}
	public static String garofind(String[][] matrix, String word, int posx, int posy) {
		String pos = null;
		int length = matrix[posx].length;
		boolean correct = true;
		if(length-posy<word.length()) {
			return pos;
		}
		for(int i=0; i<word.length(); i++) {
			if(word.charAt(i) != matrix[posx][posy+i].charAt(0)) {
				correct = false;
			}
		}
		if(correct == true) {
			pos = String.valueOf('a'+posx).concat(String.valueOf(posy));
			System.out.println("단어:"+word+", 가로위치:"+pos);
		}
		return pos;
	}
	public static String serofind(String[][] matrix, String word, int posx, int posy) {
		String pos = null;
		int length = matrix.length;
		boolean correct = true;
		if(length-posx<word.length()) {
			return pos;
		}
		for(int i=0; i<word.length(); i++) {
			if(word.charAt(i) != matrix[posx+i][posy].charAt(0)) {
				correct = false;
			}
		}
		if(correct == true) {
			pos = String.valueOf('a'+posx).concat(String.valueOf(posy));
			System.out.println("단어:"+word+", 세로위치:"+pos);
		}
		return pos;
	}
	public static String diagfind(String[][] matrix, String word, int posx, int posy) {
		String pos = null;
		int serolength = matrix.length;
		int garolength = matrix[posx].length;
		boolean correct = true;
		if((garolength-posy<word.length()) || (serolength-posx<word.length())) {
			return pos;
		}
		for(int i=0; i<word.length(); i++) {
			if(word.charAt(i) != matrix[posx+i][posy+i].charAt(0)) {
				correct = false;
			}
		}
		if(correct == true) {
			pos = String.valueOf('a'+posx).concat(String.valueOf(posy));
			System.out.println("단어:"+word+", 대각선 위치:"+pos);
		}
		return pos;
	}
	public static int GCF(int a, int b) {
		if(b==0) {
			return a;
		} else {
			return GCF(b, a%b);
		}
	}
	public static int LCM(int a, int b) {
		return (a*b)/GCF(a,b);
	}
	public static int isPalindromeInt(int n) {
		String str = String.valueOf(n);
		char charStr[] = str.toCharArray();
		int isPalindrome = 1;
		for(int i=0; i<str.length()/2; i++) {
			if(charStr[i] != charStr[str.length()-1-i]) {
				isPalindrome = 0;
				break;
			}
		}
		return isPalindrome;
	}
	public static void palindrome(String str) {
		char charStr[] = str.toCharArray();
		int isPalindrome = 1;
		if(str.length()>=10) {
			System.out.println(str+"은 10자 이상입니다.");
		}
		else {
			for(int i=0; i<str.length()/2; i++) {
				if(charStr[i] != charStr[str.length()-1-i]) {
					isPalindrome = 0;
					break;
				}
			}
			if(isPalindrome == 0) {
				System.out.println(str+"은 palindrome이 아닙니다.");
			} else {
				System.out.println(str+"은 palindrome입니다.");
			}
		}
	}
	// 90도 반시계방향으로 회전
	public static int[][] rotatedArray(int[][] input) {
		int[][] rotated = new int[4][4];
		int i=0, j=0;
		for(i=0; i<rotated.length; i++) {
			for(j=0; j<rotated[0].length; j++) {
				rotated[rotated.length-1-j][i] = input[i][j];
			}
		}
		for(i=0; i<rotated.length; i++) {
			for(j=0; j<rotated[0].length; j++) {
				System.out.print(rotated[i][j]+" ");
			}
			System.out.println();
		}
		return rotated;
	}
	// 90도 시계방향으로 회전
	public static int[][] rotatedRightArray(int[][] input) {
		int[][] rotated = new int[4][4];
		int i=0, j=0;
		for(i=0; i<rotated.length; i++) {
			for(j=0; j<rotated[0].length; j++) {
				rotated[j][rotated.length-1-i] = input[i][j];
			}
		}
		for(i=0; i<rotated.length; i++) {
			for(j=0; j<rotated[0].length; j++) {
				System.out.print(rotated[i][j]+" ");
			}
			System.out.println();
		}
		return rotated;
	}
	//Input  : arr[] = {1, 2, 3, 5, 4, 7, 10}
	//Output : arr[] = {7, 5, 3, 1, 2, 4, 10}

	//Input  : arr[] = {0, 4, 5, 3, 7, 2, 1}
	//Output : arr[] = {7, 5, 3, 1, 0, 2, 4}
	public static void twoWaySort(Integer arr[], int n) {
		int l=0, r=n-1, k=0;
		while(l<r) {
			while(arr[l]%2 !=0) {
				l++;
				k++;
			}
			while(arr[r]%2 == 0 && l<r) {
				r--;
			}
			if(l<r) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				
			}
		}
		Arrays.sort(arr, 0, k, Collections.reverseOrder());
	}
	//int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
	//int A2[] = {2, 1, 8, 3};
	public static void sortAccording(int A1[], int A2[], int m, int n) {
		int temp[] = new int[m];
		int visited[] = new int[m];
		
		int i=0, k=0, cnt=0, t=0, imsi=0;
		for(i=0; i<m; i++) {
			visited[i] = 0;
		}
		
		for(k=0; k<n; k++) {
			for(i=0; i<m; i++) {
				if(visited[i] != 1) {
					if(A2[k] == A1[i]) {
						temp[cnt] = A1[i];
						visited[i] = 1;
						cnt++;
					}
				}
			}
		}
		int namusi[] = new int[m-cnt];
		for(i=0; i<m-cnt-1; i++) {
			for(t=i; t<m-cnt; t++) {
				if(visited[i] != 1) {
					if(A1[i] > A1[t]) {
						imsi = A1[i];
						A1[i] = A1[t];
						A1[t] = imsi;
					}
				}
			}
		}
	}
	public static List<String> compareStr(String str, String[] strArr) {
		int i=0, j=0;
		List<String> list = new ArrayList<>();
		char[] chArr = str.toCharArray();
		for(i=0; i<str.length(); i++) {
			for(j=0; j<strArr.length; j++) {
				if(chArr[i] == strArr[j].charAt(0)) {
					list.add(strArr[j]);
					System.out.println(i+". "+strArr[j]);
//					break;
				}
			}
		}
		return list;
	}
	public static void analyze(String dirName, String pattern) {
		File file = new File(dirName);
		File[] listFile = file.listFiles();
		pattern = pattern.replace(" ", "");
		java.util.Set<String> set = new HashSet<>();
		for(File f : listFile) {
			if(f.getAbsolutePath().endsWith(".java")) {
				sourceCount++;
				List<String> fileContent = readFile(f);
				String resultStr = "";
				for(String str : fileContent) {
					str = str.replace(" ", "");
					resultStr += str;
					if(!str.isEmpty()) {
						lineCount++;
					}
				}
				if(resultStr.indexOf(pattern) >= 0) {
					System.out.println(resultStr);
					patternCount++;
					set.add(f.getAbsolutePath());
					resultStr = resultStr.substring(resultStr.indexOf(pattern)+pattern.length());
				}
			}
		}
		pFileCount = set.size(); 
	}
	public static Integer findMin(List<Integer> list) {
		if(list == null || list.size() == 0) {
			return Integer.MAX_VALUE;
		}
		List<Integer> sortedList = new ArrayList<>(list);
		Collections.sort(sortedList);
		return sortedList.get(0);
	}
	
	public static Integer findMax(List<Integer> list) {
		if(list == null || list.size() == 0) {
			return Integer.MAX_VALUE;
		}
		List<Integer> sortedList = new ArrayList<>(list);
		Collections.sort(sortedList);
		return sortedList.get(sortedList.size()-1);
	}
	public static List<String> readFile(File file) {
		List<String> strList = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String str = "";
			while((str = br.readLine()) != null) {
				strList.add(str);
			}
			br.close();
		} catch(IOException e) {
			System.out.println("IOException occurred");
		}
		
		return strList;
	}
	/*
	public static List<Set> setting() {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		List<Set> table = new ArrayList<Set>();
		for(int i=0; i<n; i++) {
			Set set = new Set();
			String[] temp = sc.nextLine().split(" ");
			set.setX(Integer.parseInt(temp[0]));
			set.setY(Integer.parseInt(temp[1]));
			table.add(set);
		}
		sc.close();
		return table;
	}
	*/
	/*
	public static String solution(int[] numbers) {
		String answer = "";
		List<String> list = new ArrayList<>();
		for(int i=0; i<numbers.length; i++) {
			list.add(String.valueOf(numbers[i]));
		}
		Collections.sort(list, (a,b) -> (b+a).compareTo(a+b));
		if(list.get(0).equals("0")) {
			return "0";
		}
		for(int i=0, size=list.size(); i<size; i++) {
			answer += list.get(i);
			System.out.println(answer);
		}
		
		return answer;
	}
	*/

}
