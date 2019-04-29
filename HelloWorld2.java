package com.lgcns.first;


import java.util.*;
//import java.util.Set;
//import java.util.HashSet;
import java.io.*;

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
	}
	public static HashMap<String, Integer> countType(List<String> input) {
		int i=0, j=0, type_cnt=0, same_cnt=0;
		String temp="";
		//int[][] result = new int[input.size()][2];
		HashMap<String, Integer> result = new HashMap<>();
		for(i=0; i<input.size(); i++) {
			String[] strArr = input.get(i).split("#");
			if(temp.equals(strArr[0]) == false) {
				if(result.containsKey(strArr[0])) {
					result.replace(strArr[0], result.get(strArr[0])+1);
					same_cnt++;
				} else {
					same_cnt=0;
					temp = strArr[0];
					result.put(temp, 1);
					type_cnt++;
				}
			} else {
				result.replace(temp, result.get(temp)+1);
				same_cnt++;			
			}
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
