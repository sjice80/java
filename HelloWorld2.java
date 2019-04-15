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
