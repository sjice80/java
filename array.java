package array1;

import java.io.*;
import java.util.*;
import java.security.MessageDigest;

public class array {
	static char MimeBase64[] = {
			'A','B','C','D','E','F','G','H',
			'I','J','K','L','M','N','O','P',
			'Q','R','S','T','U','V','W','X',
			'Y','Z','a','b','c','d','e','f',
			'g','h','i','j','k','l','m','n',
			'o','p','q','r','s','t','u','v',
			'w','x','y','z','0','1','2','3',
			'4','5','6','7','8','9','+','/'
		};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		String[][] matrix = {{"B", "H", "E", "Z", "R", "B", "U", "O", "C", "Z"},
							 {"L", "S", "L", "Z", "K", "E", "O", "B", "S", "A"},
							 {"A", "Y", "P", "M", "D", "E", "D", "A", "Q", "Y"},
							 {"C", "W", "R", "P", "G", "D", "T", "N", "D", "I"},
							 {"K", "F", "U", "I", "R", "T", "Y", "K", "N", "N"},
							 {"B", "G", "P", "R", "E", "D", "G", "E", "W", "W"},
							 {"L", "G", "I", "Y", "E", "R", "O", "V", "U", "O"},
							 {"U", "N", "Y", "L", "N", "P", "U", "X", "W", "R"},
							 {"K", "V", "O", "E", "S", "I", "T", "B", "C", "B"},
							 {"I", "W", "N", "Z", "W", "H", "I", "T", "E", "Y"}};
		String[] words = new String[]{"BLACK", "RED", "GREEN", "BROWN", "WHITE", "BLUE", "ORANGE"};
		/*
//		for(int i=0; i<words.length; i++) {
			findWordCount(matrix, words[0]);
			garoWordCount(matrix, words[4]);
			diagWordCount(matrix, words[1]);
//		}
 
 */
		
		String[][] salary = {
				{"23561", "5600"},
				{"37123", "4100"},
				{"33777", "4400"},
				{"13451", "6300"},
				{"23579", "5900"},
				{"87594", "2400"},
				{"59545", "3500"},
				{"49376", "3600"}
		};
		String[][] employees = {
				{"59545", "나연", "대리"},
				{"37123", "정연", "대리"},
				{"23561", "모모", "과장"},
				{"33777", "사나", "과장"},
				{"23579", "지효", "차장"},
				{"87594", "미나", "사원"},
				{"13451", "다현", "부장"},
				{"49376", "채영", "대리"}
		};
		print(salary, employees);
		
		/*
		int[][] cube = {{5, 7, 8},
					    {4, 2, 1},
				        {2, 5, 6}
		};
		sum(cube);
		*/
		/*
		String[][] department = {
				{"10", "영업팀"},
				{"20", "구매팀"},
				{"30", "개발팀"},
				{"40", "운영팀"}
		};
		
		String[][] employee = {
				{"59545", "최선명", "10"},
				{"23561", "박선주", "20"},
				{"37123", "김길동", "10"},
				{"33777", "이기주", "30"}
		};
		print(department, employee);
		*/
		String inputData = "A37D2CB5E8F";
//		getNewStr(getStrList(inputData));
		int[][] input = {{77,78,12,30},
	             	     {33,78, 9, 7},
	                     { 5,71,84,25},
	                     { 9,37, 0,27}
		};
//		getArrSum(getSortedArray(input));
		int[][] input2 = {{11,32,57,65,34},
        	     		  {53,16, 3,93,22},
        	     		  {35,22,73,64,14},
        	     		  {12,24,34,45,91},
        	     		  { 9,51,35,28,75}
		};
//		getArrSum(getSortedArray(input2));
		String input3 = "AGTCATG,GTTAG";
//		measureSimpleComparison(input3);
		String input4 = "ATTCGG,GTAT";
//		measureSimpleComparison(input4);
		int[][] matrix2 = {{5,-1,-2,-1,-3},
				          {-1,6,-3,-2,-4},
				          {-2,-3,7,-1,-2},
				          {-1,-2,-1,8,-1},
				          {-3,-4,-2,-1,0}
		};
//		measureSortComparison(input3, matrix2);
//		measureSortComparison(input4, matrix2);
		int[][] input5 = {{1,2,2,5,4},
				          {3,1,3,3,2},
				          {5,2,3,4,4},
				          {2,4,4,5,1},
				          {4,1,5,3,5}
		};
//		rotateArray(input5);
		int[] input6 = new int[25];
		for(int i=0; i<25; i++) {
			input6[i] = i+1;
		}
//		diagSum(printMaze(input6));
		String[][] input7 = {
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
		List<String> categories = Arrays.asList("F","N");
		getTopCategory(input7, categories);
		String categoryStr = "J";
		getNumberOfSubcategories(input7, categoryStr);
//		getProductNum(getNewStr("371B4A4"));
//		getProductNum(getNewStr("5312D6C"));
//		getLargeNumber(1234567);
//		getLargeNumber(34217869);
		int[][] input8 = {{1099,18,0,19,15,1},
						  {1077,19,30,0,0,0},
						  {1044,18,45,21,11,0},
						  {1088,19,30,20,28,0},
						  {1044,18,15,19,19,1},
						  {1044,18,0,0,0,1}
		};
//		sortTableByEmpno(input8, 6);
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				for(int k=0; k<words.length; k++) {
					garofound(matrix, words[k], i, j);
					serofound(matrix, words[k], i, j);
					diagfound(matrix, words[k], i, j);
				}
			}
		}
		printSalary(salary, employees);
		getNumber(getMoveInfo(11,8));
		String[] input9 = {"abc.txt", "abce", "abcd.txt", "acde.txt", "bxyz.txt", "bcde", "axbz.txt", "abcxd.txt", "acxy.txt", "axzy.txt"};
		String[] input10 = {"bcd.txt", "bce", "bcdx.txt", "axcd.txt", "axde", "axyz.txt", "cxyd.txt", "bcxa.txt", "bazy.txt"};
		List<String> list = Arrays.asList(input9);
		getSecondCode(getFirstCode(list));
		
		int[][] input11 = {
				{-1,0,7,9},
				{-6,2,-3,5},
				{3,-6,0,-5},
				{7,8,-7,2}
		};
		getMaximumNumber(input11);
		makeString("AAAABBBCDDXXY");
		String input12 = "56#70#66#71#68#66#82#88#72#91#75#74";
		makeReverse(input12);

		List<String> input14 = Arrays.asList(
							  "A,RYU,10",
							  "B,KIM,12",
							  "A,PARK,9",
							  "C,RYU,17",
							  "B,LEE,20",
							  "C,MIN,14",
							  "A,CHOI,8",
							  "B,JEON,15",
							  "C,LIM,19");				
		
		checkReservation(input14, 17);
		List<String> input15 = Arrays.asList(
				"BOOK,CUP,TV,CARD",
				"NOTEBOOK","PEN","BOOK",
				"CARD,TV,POINTER,PEN",
				"MOUSE","POINTER","BOOK"
				);
		makeGoodsList(input15);
		makeCase(10);
		
        String base = "password123";
        
        try{
 
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            System.out.println(hash.length);
            StringBuffer hexString = new StringBuffer();
 
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
 
            //출력
            System.out.println(hexString.toString());
 
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }

    	String input16 = "WINDOW";
    	makeMime(input16);
    	System.out.println();
    	compress1(new File(".\\ABCE.txt"));
    	makeCube(4);
    	num_thirteen(213421313, 0);
    	writeFile("test.csv");
    	readFile("test.csv");
    	writeStars(8);
    	List<Integer> input17 = new ArrayList<>();
    	input17.add(5);
    	input17.add(8);
    	input17.add(9);
    	input17.add(10);
    	makeGCDList(input17);
    	findChain("CHAIN.TXT");
		int[][] input18 = {{0,10,23,7,4,16},
			       {10,0,8,5,13,10},
			       {23,8,0,19,8,11},
			       {7,5,19,0,15,8},
			       {4,13,8,15,0,2},
			       {16,10,11,8,2,0}				
		};
		pro348_1(input18);
		String input19 = "OOXXOXOXOOXOOO";
		pro345(input19);
		coolNumbers(1000);
		String input20 = "66#56#66#68#70#72#73#74#82#77";
		getMaxNumber(input20);
		getReverseArrange(input20);
		List<List<Integer>> input13 = Arrays.asList(
				Arrays.asList(3, 10, 13, 22, 31, 32, 29),
				Arrays.asList(0,0,1,0,0,0,0,  1,0,0,0,1,0,0,  0,0,0,0,1,0,0,  0,0,1,0,0,0,0,  0,0,1,0,0,0,1),
				Arrays.asList(0,0,1,0,0,1,0,  0,0,0,0,0,0,0,  0,0,1,0,0,1,0,  0,0,1,0,0,1,0,  0,0,1,0,0,1,0),
				Arrays.asList(0,0,0,0,0,0,0,  0,0,1,0,0,0,0,  0,0,0,0,0,0,0,  0,0,0,0,0,0,0,  0,0,0,0,0,0,0),
				Arrays.asList(0,0,0,0,0,0,0,  0,0,0,0,0,0,0,  1,0,0,0,0,0,0,  1,0,0,0,0,0,0,  1,0,0,0,0,0,0),
				Arrays.asList(0,0,0,0,0,0,1,  0,0,1,1,0,0,0,  0,0,1,0,1,1,0,  1,0,1,0,0,0,0,  0,0,1,0,0,0,0),
				Arrays.asList(0,0,0,0,0,1,0,  0,0,0,0,0,0,0,  0,0,0,0,0,0,0,  0,0,0,0,0,0,0,  0,0,0,0,0,0,0),
				Arrays.asList(0,0,1,0,0,0,0,  0,0,1,0,0,0,0,  0,0,0,0,0,0,0,  0,0,0,0,0,0,0,  0,0,0,0,0,1,0)
		);
		System.out.println(input13);
		getGameNumber(input13);
		ArrayList<List<Integer>> numbers = new ArrayList<>(input13);
		List<Integer> list13 = numbers.remove(0);
		List<Integer> matchNumbers = new ArrayList<>(list13);
		System.out.println();
		System.out.println(Arrays.toString(list13.toArray()));
		System.out.println(matchNumbers);
		int bonusNum = matchNumbers.remove(matchNumbers.size()-1);
		System.out.println(bonusNum);
		matchRank(getGameNumber(input13), matchNumbers, bonusNum);
	}
	
	public static List<Integer> matchRank(List<List<Integer>> lottoGame, List<Integer> lottoNum, int bonusNum) {
		List<Integer> result = new ArrayList<Integer>();
		for(List<Integer> game:lottoGame) {
			int matchCount = 0;
			boolean bonus = false;
			boolean error = false;
			if(game.size() != 6) {
				result.add(-1);
				continue;
			}
			for(Integer num:game) {
				if(num>45) {
					error = true;
					break;
				}
				if(lottoNum.contains(num)) {
					matchCount++;
				}
				if(num == bonusNum) {
					bonus = true;
				}
			}
			if(error) {
				result.add(-1);
				continue;
			}
			if(matchCount == 6) {
				result.add(1);
			} else if(matchCount == 5 && bonus) {
				result.add(2);
			} else if(matchCount == 5 && !bonus) {
				result.add(3);
			} else if(matchCount == 4) {
				result.add(4);
			} else if(matchCount == 3) {
				result.add(5);
			} else {
				result.add(0);
			}
		}
		System.out.println(result);
		return result;
	}
	public static List<List<Integer>> getGameNumber(List<List<Integer>> input) {
		List<List<Integer>> result = new ArrayList<>();
		System.out.println(input.size());
		for(int i=0; i<5; i++) {
//			List<Integer> list = new ArrayList<>();
			result.add(new ArrayList<Integer>());
		}
		for(int i=1; i<input.size(); i++) {
			for(int j=0; j<35; j++) {
				if(input.get(i).get(j) == 1) {
					int game = j/7;
					int num = (i-1)*7 + j%7 + 1;
					result.get(game).add(num);
				}
			}
			
		}
		for(int i=0; i<5; i++) {
			System.out.println(result.get(i));
		}
		/*
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		List<Integer> list4 = new ArrayList<>();
		List<Integer> list5 = new ArrayList<>();
		int i=0, j=0;
		for(i=0; i<input.size(); i++) {
			for(j=0; j<input.get(i).size(); j++) {
				if(input.get(i).get(j) == 1) {
					if(j>=0 && j<7) {
						System.out.print((7*i+1+(j-0))+" ");
						list1.add(7*i+1+(j-0));
					}
					if(j>=7 && j<14) {
						System.out.print((7*i+1+(j-7))+" ");
						list2.add(7*i+1+(j-7));
					}
					if(j>=14 && j<21) {
						System.out.print((7*i+1+(j-14))+" ");
						list3.add(7*i+1+(j-14));
					}
					if(j>=21 && j<28) {
						System.out.print((7*i+1+(j-21))+" ");
						list4.add(7*i+1+(j-21));
					}
					if(j>=28 && j<35) {
						System.out.print((7*i+1+(j-28))+" ");
						list5.add(7*i+1+(j-28));
					}
				}
			}
		}
		System.out.println();
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		System.out.println(list4);
		System.out.println(list5);
		result.add(list1);
		result.add(list2);
		result.add(list3);
		result.add(list4);
		result.add(list5);
*/		
		return result;
	}
	public static List<List<Integer>> getReverseArrange(String input) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int max = 0, prev = 0, cnt=1;
		String[] str = input.split("#");
		Arrays.sort(str);
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<str.length; i++) {
			int k1 = Integer.parseInt(str[i].substring(0, 1));
			int k2 = Integer.parseInt(str[i].substring(1, 2));
			if(k1!=prev) {			
				if(list.size() > 0) {
					result.add(list);					
				}
				list = new ArrayList<>();
				list.add(k1);
				list.add(k2);
				prev = k1;
			} else {
				list.add(k2);
			}
		}
		if(list.size() > 0) {
			result.add(list);					
//			System.out.println("1. result:"+result);
		}
		for(List<Integer> r:result) {
			max = Math.max(max, r.size());
		}
		for(List<Integer> r:result) {
			while(r.size() < max) {
				r.add(-1);
			}
			Collections.reverse(r);
			System.out.println("result:"+r);
		}
		
		return result;
	}
	public static int getMaxNumber(String input) {
		int result = -1;
		int max = 0, prev = 0, cnt=1;
		String[] str = input.split("#");
		Arrays.sort(str);
		for(int i=0; i<str.length; i++) {
			int k = Integer.parseInt(str[i].substring(0, 1));
			if(k!=prev) {			
				if(cnt > max) {
					max = cnt;
					result = prev;
				}
				prev = k;
				cnt = 1;
			} else {
				cnt++;
			}
		}
		if(cnt > max) {
			max = cnt;
			result = prev;
			System.out.println("1. result:"+result+", max:"+max);
		}
		System.out.println("result:"+result+", max:"+max);
		return result;
	}
	public static int coolNumbers(int input) {
		int cnt=0;
		/*
		for(int k=input; k>=100; k--) {
			String str = Integer.toString(k);
			char[] ch = str.toCharArray();
			int diff = ch[1] - ch[0];
			for(int j=2; j<ch.length; j++) {
				if(ch[j] - ch[j-1] != diff) break;
				if(j==ch.length-1) {
					System.out.println(ch);
					cnt++;
				}
			}
		}
		*/
		
		for(int k=100; k<input; k++) {
			String str = Integer.toString(k);
			char[] ch = str.toCharArray();
			int diff = ch[1] - ch[0];
			for(int i=str.length()-1; i>0; i--) {
				if(ch[i]-ch[i-1] != diff) break;
				if(i==1) {
					System.out.println(ch);
					cnt++;
				}
				//else cnt++;
			}
		}
		
		System.out.println("멋진수:"+cnt);
		return cnt;
	}
	
	public static int pro345(String input) {
		String str = "OOXXOXOXOOXOOO";
		int result=0, cnt=0;
		char[] ch = str.toCharArray();
		for(int i=0; i<str.length(); i++) {
			if(ch[i] == 'O') {
				cnt++;
				result += cnt;
			} else {
				cnt = 0;
			}
			
		}
		System.out.println("result:"+result);
		return result;
	}
	public static int pro348_1(int[][] input) {
		int[][] arr = {{0,10,23,7,4,16},
				       {10,0,8,5,13,10},
				       {23,8,0,19,8,11},
				       {7,5,19,0,15,8},
				       {4,13,8,15,0,2},
				       {16,10,11,8,2,0}				
		};
		int[] visit = new int[6];
		List<Integer> vc = new ArrayList<>();
		int now=0, dist=0, min=100, min_idx=0;
		vc.add(1);
		visit[0] = 1;
		for(int i=0; i<arr[0].length-1; i++) {
			min=100;
			min_idx=now;
			for(int j=0; j<arr[0].length; j++) {
				if(visit[j]!=1 && arr[now][j]<min) {
					min = arr[now][j];					
					min_idx = j;			
				}
			}
			visit[min_idx] = 1;
			now = min_idx;
			vc.add(min_idx+1);
			dist += min;
			System.out.println("min_idx:"+min_idx+", min:"+min+"dist:"+dist);
		}
		dist += arr[now][0];
		System.out.println("vc:"+vc);
		System.out.println("1. min_idx:"+min_idx+", dist:"+dist);
		return dist;		
	}
	public static String findChain(String file) throws IOException {
		FileReader fr = new FileReader("./INFILE/CHAIN.TXT");
		BufferedReader br = new BufferedReader(fr);
		String result = "";
		int cnt=0, max=0;
		List<String[]> list = new ArrayList<String[]>();
		List<String[]> sortList = new ArrayList<String[]>();
		while(true) {
			String temp = br.readLine();
			if(temp != null) {
				cnt++;
				if(cnt%2 == 1) {
					String[] str = temp.split("#");
					list.add(str);
				}
				if(cnt%2 == 0) {
					String[] str = temp.split(",");
					sortList.add(str);
				}
			} else {
				break;
			}
		}
		boolean find = false;
		for(int i=0; i<list.size(); i++) {
			find = false;
			for(int j=0; j<list.size(); j++) {
				if(list.get(i)[0].equals(list.get(j)[1]) == true) {
					find = true;
					break;
				}
			}
			if(find == false) {
				result = list.get(i)[0]+"#"+list.get(i)[1]+"#"+list.get(i)[2];
				System.out.println("마지막 블록 found:"+result);
//				break;
			}
			System.out.println(Arrays.toString(list.get(i)));
		}
		
		for(int i=0; i<sortList.size(); i++) {
			if(Integer.parseInt(sortList.get(i)[2]) > max) {
				max = Integer.parseInt(sortList.get(i)[2]);
				result = sortList.get(i)[0]+","+sortList.get(i)[1]+","+sortList.get(i)[2];
			}
		}
		System.out.println(result);
		br.close();
		fr.close();
		return result;
	}
	public static List<Integer> makeGCDList(List<Integer> input) {
		List<Integer> list = new ArrayList<>();
		int i=0, j=0;
		for(i=0; i<input.size(); i++) {
			int num = input.get(i);
			for(j=1; j<=num; j++) {
				if(num%j == 0) {
					list.add(j);
				}
			}
			System.out.println(list);
		}
		Collections.sort(list);
		System.out.println(list);
		
//		HashSet<Integer> set = new HashSet<>();
		List<Integer> set = new ArrayList<>();
		for(int k:list) {
			if(set.contains(k) == false) {
				set.add(k);
			}
		}
		System.out.println(set);
		return list;
	}
	public static void writeFile(String fileName) throws IOException {
		FileWriter fw = new FileWriter("test.csv");
		BufferedWriter bw = new BufferedWriter(fw);
		
		String[] header = {"Name","Gender","Age"};
		String[] p1 = {"Chulsoo","M","23"};
		String[] p2 = {"Younghee","F","25"};
		String[] p3 = {"Minsoo","M","19"};
		
		ArrayList<String[]> info = new ArrayList<String[]>();
		info.add(header);
		info.add(p1);
		info.add(p2);
		info.add(p3);
		
		for(String[] k:info) {
			for(int i=0; i<k.length-1; i++) {
				bw.write(k[i]);
				bw.write(",");
			}
			bw.write(k[k.length-1]);
			bw.write("\r\n");
		}
		bw.close();
		fw.close();
	}
	
	public static void readFile(String fileName) throws IOException {
		FileReader fr = new FileReader("test.csv");
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String[]> info = new ArrayList<String[]>();
		String[] tList;
		String temp;
		br.readLine();
		int sum=0, cnt=0;
		while(true) {
			temp = br.readLine();
			if(temp == null) break;
			tList = temp.split(",");
			System.out.printf("이름: %s 성별: %s 나이: %s\n", tList[0], tList[1], tList[2]);
			sum += Integer.parseInt(tList[2]);
			cnt++;
			info.add(tList);
		}
		System.out.printf("평균나이: %d\n", sum/cnt);
		br.close();
		fr.close();
	}
	
	public static void writeStars(int count) throws IOException {
		int i=0, num=1;
		String temp="";
		FileWriter fw = new FileWriter("stars.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		while(num<=count) {
//			for(i=0; i<num; i++) {
				temp += "*";			
//			}
			bw.write(temp);
			bw.write("\n\r");
			num++;
		}
		num=1;
		while(num<count) {
//			for(i=0; i<num; i++) {
				temp = temp.substring(0, count-num);			
//			}
			bw.write(temp);
			bw.write("\n\r");
			num++;
		}
		bw.close();
		fw.close();
	}
	public static int num_thirteen(int num, int count) {
		int i=0, cnt=0;
		String str = String.valueOf(num);

		while(str.contains("13")==true) {
			cnt++;
			System.out.println(str+", "+str.indexOf("13"));
			str = str.substring(str.indexOf("13")+2);
		}
	
		System.out.println(cnt);
		count = cnt;
		return count;
	}
	public static int[][] makeCube(int length) {
		int[][] result = new int[length][length];
		int i=0, j=0, k=1, cnt=1;
		for(i=0; i<length; i++) {
			for(j=0; j<length-i; j++) {
				if(j==length-1-i) {
					k=0;
					while(i+k<length) {
						result[i+k][j] = cnt;
						cnt++;
						k++;
					}
				} else {
					result[i][j] = cnt;
					cnt++;
				}
			}
		}
		for(i=0; i<length; i++) {
			for(j=0; j<length; j++) {
				System.out.printf("%4d",result[i][j]);
			}
			System.out.println();
		}
		return result;
	}
	public static String compress1(File file){
		File file2 = new File("ABCE.txt");
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		int same_cnt=0, i=0;
		if(file2!=null) {
			try {
				Scanner sc = new Scanner(file2);
				while(sc.hasNextLine()) {
					String str = sc.nextLine();
					list.add(str);
				}
				sc.close();
			} catch (Exception e) {
				System.out.println(e);
			}			
		}
		for(i=0; i<list.size()-1; i++) {
			String str1 = list.get(i);
			String str2 = list.get(i+1);
			if(str1.equals(str2) == false) {
				if(same_cnt>0) {				
					str1 = String.valueOf(same_cnt+1)+"#"+str1;
					sb.append(str1);
					sb.append("\n");
//					System.out.println("1:"+sb.toString());
				} else {					
					sb.append(str1);
					sb.append("\n");		
//					System.out.println("2:"+sb.toString());
				}		
				if(i == list.size()-2) {
					sb.append(str2);
					sb.append("\n");
				}
				same_cnt=0;
			} else {
				same_cnt++;
			}
		}		
		System.out.println(sb.toString());
		return sb.toString();
	}
	public static String makeMime(String input) {
		String result = "";
		int i=0, j=0, idx=0, t=0, tt=0, cnt=0, pos=0;
		char ch=0;
		char[] chArr = input.toCharArray();
		char[] chArr2 = new char[50];//{'0'};
		for(i=0; i<input.length(); i++) {
			ch = chArr[i];
			for(j=7; j>=0; j--) {
				t = (ch >> j) & 0x01;
				if(t == 1) {
					System.out.print("1");
				} else {
					System.out.print("0");
				}
				tt = chArr2[idx] << 1;
				chArr2[idx] = (char)(tt|t);
				cnt++;
				if(cnt%5==0) {
//					pos = Integer.parseInt(String.valueOf(chArr2[idx]));
					System.out.print(MimeBase64[(int)chArr2[idx]]); 
					idx++;
				}
			}

		}
		return result;
	}
	public static List<String> makeCase(int input) {
		List<String> result = new ArrayList<>();
		String str = "";
		int i=0, cnt=0, sum=0, avg=0, min=100, depart=0, job=0;
		for(i=1;i<=input;i++) {
			if(input%i == 0) {
				str = String.valueOf(i)+"_"+String.valueOf(input/i);
				sum += i;
				cnt++;
				System.out.println(str);
				result.add(str);
			}
		}
		avg = sum/cnt;
		for(i=0; i<result.size(); i++) {
			String[] strArr = result.get(i).split("_");
			if(Math.abs(Integer.parseInt(strArr[0])-avg)<min) {
				min = Math.abs(Integer.parseInt(strArr[0])-avg);
				depart = Integer.parseInt(strArr[0]);
				job = Integer.parseInt(strArr[1]);
			} else if(Math.abs(Integer.parseInt(strArr[0])-avg)==min) {
				if(Integer.parseInt(strArr[0]) > depart) {
					depart = Integer.parseInt(strArr[0]);
					job = Integer.parseInt(strArr[1]);
				}
			}
		}
		String result2 = String.valueOf(depart)+"_"+String.valueOf(job);
		System.out.println(result2);
		
		return result;
	}
	public static HashMap<String,Integer> makeGoodsList(List<String> input) {
		HashMap<String,Integer> result = new HashMap<>();
		int i=0, j=0, type_cnt=0, same_cnt=1;
		String temp="";
		for(i=0;i<input.size();i++) {
			String[] str = input.get(i).split(",");
			for(j=0;j<str.length;j++) {
//				System.out.println("1."+temp+", "+str[j]);
				if(result.containsKey(str[j]) == false) {
					same_cnt=1;
					result.put(str[j], 1);
					type_cnt++;
//					System.out.println("1."+str[j]+", "+result.get(str[j]));
				} else {
					same_cnt++;
					result.replace(str[j], result.get(str[j])+1);
//					System.out.println("2."+str[j]+", "+result.get(str[j]));
				}
			}
		}
		
		for(String key:result.keySet()) {
			int value = result.get(key);
			System.out.println(key+" "+value);
		}
		return result;
	}
	public static boolean checkReservation(List<String> table, int input) {
		boolean isAvailable = false;
		String[][] table1 = new String[table.size()][2];
		String[][] result = new String[table.size()][2];
		int i=0, j=0, type_cnt=0, same_cnt=0;
		String temp= "";
		String temp2 = "";
		for(i=0; i<table.size()-1; i++) {
			for(j=i+1; j<table.size(); j++) {
				if(table.get(i).compareTo(table.get(j)) > 0) {
					temp = table.get(i);
					table.set(i, table.get(j));
					table.set(j, temp);
				}
			}
		}
		for(i=0; i<table.size(); i++) {
			System.out.println(table.get(i));
		}
		for(i=0; i<table.size(); i++) {
			String[] str = table.get(i).split(",");
//			System.out.println(str[0]+" "+str[1]+" "+str[2]);

			if(input == Integer.parseInt(str[2])) {
				table1[i][0] = str[0];
				table1[i][1] = "예약 불가능";
			} else {
				table1[i][0] = str[0];
				table1[i][1] = "예약 가능";
			}
		}
		for(i=0; i<table.size(); i++) {
			System.out.println(table1[i][0]+" "+table1[i][1]);
			if(table1[i][0].equals(temp2) == false) {	
				same_cnt=0;
				temp2 = table1[i][0];
				if(table1[i][1].contains("예약 불가능")) {
					result[type_cnt][0] = temp2;
					result[type_cnt][1] = "예약 불가능";						
				} else {
					result[type_cnt][0] = temp2;
					result[type_cnt][1] = "예약 가능";
				}
				type_cnt++;
//				System.out.println("1."+temp2+" "+type_cnt);
			} else {
				same_cnt++;
//				System.out.println("2."+temp2+" "+type_cnt+" "+same_cnt);
				if(table1[i][1].contains("예약 불가능")) {
					for(int k=0; k<type_cnt; k++) {
//						System.out.println("3."+temp2+" "+type_cnt);
						if(result[k][0].equals(table1[i][0])) {
							result[k][1] = "예약 불가능";	
							break;
						}
					}
				}
			}
		}
		for(i=0; i<type_cnt; i++) {
			System.out.println(result[i][0]+" "+result[i][1]);
		}
		return isAvailable;
	}

	public static List<List<Integer>> makeReverse(String input) {
		List<List<Integer>> result = new ArrayList<>();
		String[] str = input.split("#");
		int i=0, j=0, temp=0, idx=0, max=0;
		int[] ten = new int[str.length];
		int[] one = new int[str.length];
		for(i=0; i<str.length; i++) {
			ten[i] = Integer.parseInt(str[i])/10;
			one[i] = Integer.parseInt(str[i])%10;
		}
		String tempStr = "";
		for(i=0; i<str.length-1; i++) {
			for(j=i+1; j<str.length; j++) {
				if(Integer.parseInt(str[i]) > Integer.parseInt(str[j])) {
					tempStr = str[i];
					str[i] = str[j];
					str[j] = tempStr;
				}
			}
		}
		for(i=0; i<str.length; i++) {
			ten[i] = Integer.parseInt(str[i])/10;
			one[i] = Integer.parseInt(str[i])%10;
		}
		temp = ten[0];
//		System.out.println("0."+temp);
		List<Integer> list = new ArrayList<>();
		list.add(temp);
		for(i=0; i<str.length; i++) {
			if(temp != ten[i]) {
				result.add(idx, list);
				idx++;
				list = new ArrayList<>();
				list.add(ten[i]);
				list.add(one[i]);
				temp = ten[i];
				if(i==str.length-1) {
					result.add(idx, list);
				}
//				System.out.println("1."+result);
			} else {
				list.add(one[i]);
//				System.out.println("2."+result);
			}
		}
		for(i=0; i<result.size(); i++) {		
			if(result.get(i).size() > max) {
				max = result.get(i).size();
			}
		}
//		System.out.println(max);
		for(i=0; i<result.size(); i++) {
			for(j=result.get(i).size(); j<max; j++) {
//				System.out.println("3.1"+result.get(i)+", "+result.get(i).size());
				result.get(i).add(j, -1);
			}
//			System.out.println("3."+result.get(i));
		}
		for(i=0; i<result.size(); i++) {
			Collections.reverse(result.get(i));
			System.out.println(result.get(i));
		}
		return result;
	}
	public static String makeString(String input) {
		String result = "";
		int i=0, cnt=1;
		String str1="", str2="";
		char ch[] = new char[input.length()];
		ch = input.toCharArray();
		char temp = 0;
		System.out.println(input.length());
		for(i=0; i<input.length(); i++) {
			if(temp != ch[i]) {
				if(cnt%2==0) {
					for(int k=0; k<cnt/2; k++) {
						System.out.println("2."+i+", "+cnt+", "+temp+", "+ch[i]);
						if(i==input.length()-1) {
							System.out.println(temp+", "+ch[i]);
							str2 = str2 + temp;
							str1 = str1 + temp + ch[i];
						} else {
							str2 = str2 + temp;
							str1 = str1 + temp;
						}
					}
				} else {
					System.out.println(i+", "+cnt+", "+temp+", "+ch[i]);
					for(int k=0; k<cnt; k++) {
						if(i==input.length()-1) {
							System.out.println(temp+", "+ch[i]);
							str1 = str1 + ch[i];
						} else {
							str1 = str1 + temp;
							str1 = str1.trim();
						}
					}
				}
				cnt=1;
				temp = ch[i];
			} else {
				cnt++;
				temp = ch[i];
				System.out.println("1."+i+", "+cnt+", "+temp+", "+ch[i]);
			}
		}
		char ch2[] = new char[input.length()];
		ch2 = str2.toCharArray();
//		char temp2 = 0;
		for(i=0; i<ch2.length/2; i++) {
			temp = ch2[i];
			ch2[i] = ch2[ch2.length-1-i];
			ch2[ch2.length-1-i] = temp;
		}
		str2 = String.valueOf(ch2);
		result = str1+str2;
		System.out.println(str1+", "+str2+", "+result);
		return result;
	}
	public static int getMaximumNumber(int[][] input) {
		int i=0, j=0, k=0, t=0, num=1;
		int len = input.length;
		int sum=0, max=0;
		while(num <= len) {
			for(i=0; i<=len-num; i++) {
				for(j=0; j<=len-num; j++) {
					sum = 0;
					for(k=i; k<i+num; k++) {
						for(t=j; t<j+num; t++) {
							sum = sum+input[k][t];
						}
					}
					if(sum >max) {
						max = sum;
					}
				}
			}
			num++;
		}
		System.out.println("max:"+max);
		return max;
	}
	public static List<String> getFirstCode(List<String> input) {
		List<String> firstCodeNameList = null;
		firstCodeNameList = new ArrayList<String>();
		for(String name:input) {
			if(name.indexOf(".")>-1){
//				System.out.println(name);
				firstCodeNameList.add(name);
			}
		}
		System.out.println(firstCodeNameList);
		return firstCodeNameList;
	}
	public static List<String> getSecondCode(List<String> input) {
		List<String> secondCodeNameList = null;
		secondCodeNameList = new ArrayList<String>();
		for(int i=0; i<input.size(); i++) {
			String[] str = input.get(i).split("\\.");
			System.out.println(str[0]);
			if(str[0].indexOf("a")>-1 || str[0].indexOf("x")>-1) {
				if(str[0].indexOf("ab")>-1 || str[0].indexOf("xy")>-1 || str[0].indexOf("ax")>-1) {
					secondCodeNameList.add(input.get(i));
				}
			} else {
				secondCodeNameList.add(input.get(i));
			}
		}
		System.out.println(secondCodeNameList);
		return secondCodeNameList;
	}
	public static List<Integer> getMoveInfo(int numberOfBalloon, int numberOfMove) {
		List<Integer> moveInfo = new ArrayList<>();
		int tmpNumberOfMove=0, index=1;
		moveInfo.add(numberOfBalloon);
		while(true)
		{
			if(moveInfo.get(index-1)>1) {
				tmpNumberOfMove++;
				moveInfo.set(index-1, moveInfo.get(index-1)-2);
				if(index == moveInfo.size()-1) {
					moveInfo.set(index, moveInfo.get(index)+1);
					System.out.println("1. "+moveInfo);
				} else {
					moveInfo.add(index, 1);
					System.out.println("2. "+moveInfo);
				}

				if(numberOfMove == tmpNumberOfMove) {
					System.out.println("3. "+moveInfo);
					break;
				}
				if(moveInfo.get(index-1)<=1 && moveInfo.get(index)<=1) {
					System.out.println("4. "+moveInfo);
					break;
				}
			} else {
				index++;
			}
		}
		return moveInfo;
	}
	
	public static int getNumber(List<Integer> finalMoveList) {
//		int number = 0;
		int index = finalMoveList.size()-1;
		while(true) {
			if(finalMoveList.get(index) > 0) {
				finalMoveList.set(index, finalMoveList.get(index)-1);
				finalMoveList.set(index-1, finalMoveList.get(index-1)+2);
			} else {
				index--;
			}
			if(index == 0) {
				break;
			}
		}
		System.out.println(finalMoveList.get(0));
		return finalMoveList.get(0);
	}
	public static String[][] printSalary(String[][] salary, String[][] employee) {
		HashMap<String, Integer> gradeCnt = new HashMap<String, Integer>();
		HashMap<String, Float> salCal = new HashMap<String, Float>();
		int k=0;
		for(int i=0; i<salary.length; i++) {
			for(int j=0; j<employee.length; j++) {
				if(salary[i][0].equals(employee[j][0])==true) {
					if(gradeCnt.get(employee[j][2])==null) {
						gradeCnt.put(employee[j][2], 1);
						salCal.put(employee[j][2], Float.parseFloat(salary[i][1]));
					} else {
						gradeCnt.put(employee[j][2], gradeCnt.get(employee[j][2])+1);
						salCal.put(employee[j][2], salCal.get(employee[j][2])+Float.parseFloat(salary[i][1]));
					}
				}
			}
		}
		
		Set<String> gradeSet = gradeCnt.keySet();
		String[][] result = new String[gradeSet.size()][2];
		Iterator<String> it = gradeSet.iterator();
		while(it.hasNext()) {
			String Ji = it.next();
			result[k][0] = Ji;
			result[k][1] = Integer.toString((int)Math.round(salCal.get(Ji)/gradeCnt.get(Ji)));
			k++;
		}

		String[] temp = new String[k];
		for(int i=0; i<k-1; i++) {
			for(int j=i+1; j<k; j++) {
				if(Integer.parseInt(result[i][1]) > Integer.parseInt(result[j][1])) {
					temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
			}
		}
		for(int i=0; i<k; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
		return result;
	}
	public static String garofound(String[][] matrix, String word, int posx, int posy) {
		int j=0;
		String pos = "";
		boolean correct = true;
		int length = matrix[0].length;
		if(length-posy < word.length()) {
//			System.out.println("length:"+length);
			return pos;
		}
		for(j=0; j<word.length(); j++) {
			if(matrix[posx][posy+j].equals(word.substring(j,j+1)) != true) {
//			if(matrix[posx][posy+j].charAt(0) != word.charAt(j)) {
//				System.out.println("matrix[posx][posy+j]:"+matrix[posx][posy+j]+", word.substring(j,j+1):"+word.substring(j,j+1));
				correct = false;
			}
		}
		if(correct == true) {
			
			pos = String.valueOf((char)('a'+posx)).concat(String.valueOf(posy));
			System.out.println("garofound:"+pos+", word:"+word+", posx:"+posx+", posy:"+posy);
		}
		
		return pos;
	}
	public static String diagfound(String[][] matrix, String word, int posx, int posy) {
		int j=0;
		String pos = "";
		boolean correct = true;
		int length = matrix[0].length;
		if(length-posy < word.length() || length-posx < word.length()) {
//			System.out.println("length:"+length);
			return pos;
		}
		for(j=0; j<word.length(); j++) {
			if(matrix[posx+j][posy+j].equals(word.substring(j,j+1)) != true) {
//			if(matrix[posx][posy+j].charAt(0) != word.charAt(j)) {
//				System.out.println("matrix[posx][posy+j]:"+matrix[posx][posy+j]+", word.substring(0,1):"+word.substring(0,1));
				correct = false;
			}
		}
		if(correct == true) {
			
			pos = String.valueOf((char)('a'+posx)).concat(String.valueOf(posy));
			System.out.println("diagfound:"+pos+", word:"+word+", posx:"+posx+", posy:"+posy);
		}
		
		return pos;
	}
	public static String serofound(String[][] matrix, String word, int posx, int posy) {
		int j=0;
		String pos = "";
		boolean correct = true;
		int length = matrix.length;
		if(length-posx < word.length()) {
//			System.out.println("length:"+length);
			return pos;
		}
		for(j=0; j<word.length(); j++) {
			if(matrix[posx+j][posy].equals(word.substring(j,j+1)) != true) {
//			if(matrix[posx][posy+j].charAt(0) != word.charAt(j)) {
//				System.out.println("matrix[posx][posy+j]:"+matrix[posx][posy+j]+", word.substring(0,1):"+word.substring(0,1));
				correct = false;
			}
		}
		if(correct == true) {
			
			pos = String.valueOf((char)('a'+posx)).concat(String.valueOf(posy));
			System.out.println("serofound:"+pos+", word:"+word+", posx:"+posx+", posy:"+posy);
		}
		
		return pos;
	}
	public static int[][] sortTableByEmpno(int otTable[][], int row) {
		int[][] result = new int[otTable.length][otTable[0].length];
		int[] temp = new int[otTable[0].length];
		for(int i=0; i<otTable.length-1; i++) {
			for(int j=i+1; j<otTable.length; j++) {
				if(otTable[i][0] > otTable[j][0]) {
					temp = otTable[i];
					otTable[i] = otTable[j];
					otTable[j] = temp;
				}
			}
		}
		for(int i=0; i<otTable.length; i++) {
			System.out.println(Arrays.toString(otTable[i]));
		}
		return result;
	}
	public static int getLargeNumber(int input) {
		String num = String.valueOf(input);
		String first = "";
		String second = "";
		int len = num.length();
		while(len > 1) {
			
			if(len % 2 == 0) {
				
				first = num.substring(0, len/2);
				second = num.substring(len/2);
				System.out.println("짝수길이 first:"+first+", second:"+second);
			} else {
				first = num.substring(0, (len-1)/2);
				second = num.substring((len-1)/2+1);
				System.out.println("홀수길이 first:"+first+", second:"+second);
			}
			if(Integer.parseInt(first) > Integer.parseInt(second)) {
				num = first;
			} else {
				num = second;
			}
			len = num.length();
		}
		System.out.println(num);
		return Integer.parseInt(num);
	}
	public static String getNewStr(String input) {
		char[] chStr = input.toCharArray();
		String ch = "";
		String num = "";
		for(int i=0; i<input.length(); i++) {
			if(chStr[i] >= 'A' && chStr[i] <= 'Z') {
				ch = ch + String.valueOf(chStr[i]);
			} else {
				num = num + String.valueOf(chStr[i]); 
			}
		}
		System.out.println(ch+num);
		return ch+num;
	}
	
	public static String getProductNum(String newStr) {
		String num = newStr.substring(2);
		
		char[] chStr = num.toCharArray();
		int idx = 9, sum=0;
		for(int i=0; i<chStr.length; i++) {
			sum = sum + Integer.parseInt(String.valueOf(chStr[i])) * idx;
			idx--;
		}
		sum = sum%5;
		System.out.println(newStr+String.valueOf(sum));
		return newStr+String.valueOf(sum);
		
	}
	public static String getTopCategory(String[][] input, List<String> categories) {
		String topCategory = "";
		Map<String, List<String>> tMap = new LinkedHashMap<String, List<String>>();
		List<String> childs = new ArrayList<String>();
		for(int i=0; i<input.length; i++) {
			String parent = input[i][0];
			String child = input[i][1];
			if(tMap.containsKey(parent)) {
				childs = tMap.get(parent);
				childs.add(child);
				System.out.println("1."+childs);
				tMap.put(parent, childs);
			} else {
				childs = new ArrayList<String>();
				childs.add(child);
				System.out.println("2."+childs);
				tMap.put(parent, childs);
			}
		}
		List<String> hierarchy = new ArrayList<String>();
		List<String> tHierarchy = new ArrayList<String>();
		int index = -1;
		boolean bFirst = false;
		for(String inputCategory:categories) {
			if(!bFirst) {
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
		}
		System.out.println("topCategory: "+topCategory);
		return topCategory;
	}

	public static int getNumberOfSubcategories(String[][] input, String categoryStr) {
		int numberOfSubcategories = 0;
		Map<String, List<String>> tMap = new LinkedHashMap<String, List<String>>();
		List<String> childs = new ArrayList<String>();
		for(int i=0; i<input.length; i++) {
			String parent = input[i][0];
			String child = input[i][1];
			if(tMap.containsKey(parent)) {
				childs = tMap.get(parent);
				childs.add(child);
				tMap.put(parent, childs);
			} else {
				childs = new ArrayList<String>();
				childs.add(child);
				tMap.put(parent, childs);
			}
		}
		for(String key:tMap.keySet()) {
			List<String> values = tMap.get(key);
			if(values.contains(categoryStr)) {
				String parent = getParent(tMap, categoryStr);
				List<String> children = new ArrayList<String>();
				getChildren(tMap, parent, children);
				System.out.println(children);
				numberOfSubcategories = children.size();
				break;
			}
		}
		System.out.println("numberOfSubcategories: "+numberOfSubcategories);
		return numberOfSubcategories;
	}
	public static String getParent(Map<String, List<String>> tMap, String child) {
		String parent = "";
		for(String key:tMap.keySet()) {
			List<String> childs = tMap.get(key);
			if(childs.contains(child)) {
				parent = key;
				break;
			}
		}
		return parent;
	}
	
	public static List<String> getChilds(Map<String, List<String>> tMap, String parent) {
		List<String> childs = new ArrayList<String>();
		if(tMap.containsKey(parent)) {
			childs = tMap.get(parent);
		}
		return childs;
	}
	public static void getChildren(Map<String, List<String>> tMap, String parent, List<String> children) {
		List<String> tChildren = getChilds(tMap, parent);
		if(tChildren.size() > 0) {
			children.addAll(tChildren);
			for(String tChildParents:tChildren) {
				getChildren(tMap, tChildParents, children);
			}
		}
	}
	public static int diagSum(int[][] input) {
		int i=0, j=0, sum=0, k=0;
		for(i=0; i<input.length; i++) {
			for(j=0; j<input[0].length; j++) {
				if(i==j) {
					sum += input[i][j];
					System.out.println(sum+", "+input[i][j]);
					
				}
			}
		}
		System.out.println("sum:"+sum);
		return sum;
	}

	public static int[][] printMaze(int[] input) {
		int[][] result = new int[5][5];
		int i=0, j=0, idx=0;
		for(i=0; i<5; i++) {
			if(i%2 == 0) {
				for(j=0; j<5; j++) {
					result[i][j] = input[idx];
					idx++;
				}
			} else {
				for(j=4; j>=0; j--) {
					result[i][j] = input[idx];
					idx++;
				}
			}
		}
		for(i=0; i<5; i++) {
			for(j=0; j<5; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		return result;
	}
	public static int[][] rotateArray(int[][] input) {
		int row = input.length;
		int col = input[0].length;
		int i=0, j=0;
		int[][] result = new int[row][col];
		for(i=0; i<row; i++) {
			System.arraycopy(input[i], 0, result[i], 0, row);
		}

		for(i=0; i<row; i++) {
			for(j=0; j<col; j++) {
				if( i == 0 || i == row-1 || j == 0 ||  j == col-1 ) {
					result[j][col-1-i] = input[i][j];
				}
//				System.out.print(result[i][j]+" ");
			}
//			System.out.println();
		}
		for(i=0; i<row; i++) {
			for(j=0; j<col; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		return result;
	}
	public static int measureSortComparison(String input, int[][] similarityMatrix) {
		int i=0, j=0, sum=0;
		int start_a=0, len=0, max=0, k=0, fir_idx=0, sec_idx=0;
		
		String[] inputArr = input.split(",");
		char[] first = inputArr[0].toCharArray();
		char[] second = inputArr[1].toCharArray();
		char[][] a = new char[2][first.length+second.length-1];
		for(i=0; i<2; i++) {
			for(j=0; j<first.length+second.length-1; j++) {
				a[i][j] = '0';
			}
		}

		for(k=first.length-1; k<first.length+second.length-1; k++) {
			a[1][k] = second[sec_idx];
			sec_idx++;
		}
		for(j=0; j<second.length; j++) {
			fir_idx = 0;
			sum=0;
			for(k=0; k<j; k++) {
				a[0][k] = '0';
			}
			for(k=j; k<first.length+j; k++) {
				System.out.println("1.fir_idx:"+fir_idx+", k:"+k);
				a[0][k] = first[fir_idx];
				fir_idx++;
				if(fir_idx == first.length) {
					break;
				}
			}
			for(i=0; i<first.length+second.length-1; i++) {
				System.out.println("1.a[0][i]:"+a[0][i]);
				System.out.println("1.a[1][i]:"+a[1][i]);
				System.out.println("1.similarity:"+similarityMatrix[getPos(a[0][i])][getPos(a[1][i])]);
				sum = sum + similarityMatrix[getPos(a[0][i])][getPos(a[1][i])];
				System.out.println("1.sum:"+sum);
			}
			if(sum>max) {
				max = sum;
				System.out.println("1.max:"+max);
			}
		}

		fir_idx = 0;
		for(k=second.length-1; k<first.length+second.length-1; k++) {
			a[0][k] = first[fir_idx];
			fir_idx++;
		}
		for(j=0; j<first.length; j++) {
			sec_idx = 0;
			sum=0;
			for(k=first.length+second.length-2-j; k<first.length+second.length-1; k++) {
				a[1][k] = '0';
			}
//			System.out.println(first.length-1+" "+sec_idx);
			for(k=first.length-1-j; k<second.length+first.length-1; k++) {
//				System.out.println(k+" "+sec_idx);
				a[1][k] = second[sec_idx];
				sec_idx++;
				if(sec_idx == second.length) {
					break;
				}
			}
			for(i=0; i<first.length+second.length-1; i++) {
				System.out.println("2.a[0][i]:"+a[0][i]);
				System.out.println("2.a[1][i]:"+a[1][i]);
				System.out.println("2.similarity:"+similarityMatrix[getPos(a[0][i])][getPos(a[1][i])]);
				sum = sum + similarityMatrix[getPos(a[0][i])][getPos(a[1][i])];
				System.out.println("2.sum:"+sum);
			}
			if(sum>max) {
				max = sum;
				System.out.println("2.max:"+max);
			}
		}
		System.out.println("max sum:"+max);
		return max;
	}
	
	public static int getPos(char gene) {
		switch(gene) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		default:
			return 4;
		}
	}
	public static int measureSimpleComparison(String input) {
		int i=0, j=0, cnt=0, start_a=0, len=0, max=0;
		String[] inputArr = input.split(",");
		char[] first = inputArr[0].toCharArray();
		char[] second = inputArr[1].toCharArray();
		for(i=first.length-1; i>=0; i--) {
			cnt=0;                                                                                                                                                                                                                                                                                                         
			start_a = i;
			len = first.length - i;
			if(len >= second.length) {
				len = second.length;
			}
			for(j=0; j<len; j++) {				
				if(first[start_a+j] == second[j]) {
//					System.out.println("1."+start_a+", "+j+", "+first[start_a+j]+", "+second[j]);
					cnt++;
//					System.out.println("1.cnt:"+cnt);
				}
//				System.out.println();
				
			}
			if(cnt>max) {
				max = cnt;
			}
		}
		for(i=0; i<second.length; i++) {
			cnt=0;                                                                                                                                                                                                                                                                                                         
			start_a = i;
			len = second.length - i;
			for(j=0; j<len; j++) {				
				if(second[start_a+j] == first[j]) {
//					System.out.println("2."+start_a+", "+j+", "+second[start_a+j]+", "+first[j]);
					cnt++;
//					System.out.println("2.cnt:"+cnt);
				}
//				System.out.println();				
			}
			if(cnt>max) {
				max = cnt;
			}
		}
		System.out.println("max:"+max);
		return max;
	}

	
	public static int[][] getSortedArray(int[][] input) {
		
		int row = input.length;
		int col = input[0].length;
		int[][] result = new int[row][col];
		int i=0, j=0, temp=0, k=0;
		for(i=0; i<row; i++) {
			for(j=0; j<col; j++) {
				result[i][j] = input[i][j]%10;
			}
		}
		for(i=0; i<row; i++) {
			for(j=0; j<col-1; j++) {
				for(k=j+1; k<col; k++) {
					if(result[i][j] > result[i][k]) {
						temp = result[i][j];
						result[i][j] = result[i][k];
						result[i][k] = temp;
					}
				}
			}
		}
		for(i=0; i<col; i++) {
			for(j=0; j<row-1; j++) {
				for(k=j+1; k<row; k++) {
					if(result[j][i] > result[k][i]) {
						temp = result[j][i];
						result[j][i] = result[k][i];
						result[k][i] = temp;
					}
				}
			}
		}
		for(i=0; i<row; i++) {
			for(j=0; j<col; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		return result;
	}
	public static int getArrSum(int[][] input) {
		int sum=0;
		int row = input.length;
		int col = input[0].length;
		int[][] result = new int[row][col];
		int i=0, j=0;
		
		for(i=0; i<row; i++) {
			System.arraycopy(input[i], 0, result[i], 0, input.length);
			//for(j=0; j<col; j++) {
			//	result[i][j] = input[i][j];
			//}
		}
		for(i=0; i<row; i++) {
			for(j=0; j<col-1; j++) {
//				System.out.println("1."+input[i][j]+", "+input[i][j+1]);
				if(input[i][j] == input[i][j+1]) {
//					System.out.println("kk:"+input[i][j]+", "+input[i][j+1]);
					result[i][j] = 0;
					result[i][j+1] = 0;
				}
			}
		}	
		for(i=0; i<row-1; i++) {
			for(j=0; j<col; j++) {
//				System.out.println("2."+input[i][j]+", "+input[i+1][j]);
				if(input[i][j] == input[i+1][j]) {
//					System.out.println("tt."+input[i][j]+", "+input[i+1][j]);
					result[i][j] = 0;
					result[i+1][j] = 0;
				}
			}
		}
		/*
		if(input[row-1][col-1] == input[row-1][col-1]) {
			result[row-2][col-1] = 0;
			result[row-1][col-1] = 0;
		}
		if(input[row-1][col-2] == input[row-1][col-1]) {
			result[row-1][col-1] = 0;
			result[row-1][col-2] = 0;
		}
		*/
		System.out.println();
		for(i=0; i<row; i++) {
			for(j=0; j<col; j++) {
				System.out.print(result[i][j]+" ");
				sum += result[i][j];
			}
			System.out.println();
		}
		
		System.out.println("sum:"+sum);
		return sum;
	}
	public static List<String> getStrList(String input) {
		List<String> result = new ArrayList<>();
		int i=0;
		char[] charArr = input.toCharArray();
		String alpha = "";
		String num = "";
		for(i=0; i<input.length(); i++) {
			if(charArr[i] >= 'A' && charArr[i] <= 'Z') {
				alpha += Character.toString(charArr[i]);
			} else {
				num += Character.toString(charArr[i]);
			}
		}
		result.add(alpha);
		result.add(num);
		System.out.println(result);
		return result;
	}
	public static String getNewStr(List<String> list) {
		String result = "";
		int i=0;
		char[] alphaArr = list.get(0).toCharArray();
		char[] numArr = list.get(1).toCharArray();
		System.out.println(alphaArr.length+" "+numArr.length);
		for(i=0; i<numArr.length; i++) {
			result += String.valueOf(alphaArr[i]);
			result += String.valueOf(numArr[i]);
		}
		result += String.valueOf(alphaArr[i]);
		System.out.println(result);
		return result;
	}
	
	public static int[][] sum(int[][] cube) {
		int[][] rotated = new int[cube.length][cube[0].length];
		for(int i=0; i<cube.length; i++) {
			for(int j=0; j<cube[0].length; j++) {
				rotated[j][cube.length-1-i] = cube[i][j];
			}
		}
		for(int i=0; i<cube.length; i++) {
			for(int j=0; j<cube[0].length; j++) {
				rotated[i][j] += cube[i][j];
				System.out.print(rotated[i][j]+" ");
			}
			System.out.println();
		}	
		return rotated;
	}
	/*
	public static String[][] print(String[][] department, String[][] employee) {
		String[][] table = new String[employee.length][3];
		//HashMap<String, String> dep = new HashMap<String, String>();
		//HashMap<String, String> emp = new HashMap<String, String>();
		int i=0, j=0, row=0;
		String[] temp = new String[3];
		for(i=0; i<department.length; i++) {
			for(j=0; j<employee.length; j++) {
				if(department[i][0].equals(employee[j][2])) {
					table[row][0] = department[i][1];
					table[row][1] = employee[j][0];
					table[row][2] = employee[j][1];
					row++;
				}
			}
		}
		for(i=0; i<table.length-1; i++) {
			for(j=i+1; j<table.length; j++) {
				if(table[i][0].equals(table[j][0])) {
					if(Integer.parseInt(table[i][1]) > Integer.parseInt(table[j][1])) {
						temp[0] = table[i][0];
						temp[1] = table[i][1];
						temp[2] = table[i][2];
						
						table[i][0] = table[j][0];
						table[i][1] = table[j][1];
						table[i][2] = table[j][2];
						
						table[j][0] = temp[0];
						table[j][1] = temp[1];
						table[j][2] = temp[2];
					}
				}
			}
		}
		for(i=0; i<table.length; i++) {
			System.out.println(table[i][0]+" "+table[i][1]+" "+table[i][2]);
		}
		return table;
	}
	*/
	public static String[][] print(String[][] salary, String[][] employees) {
		int i=0, j=0;
		int level1=0, level2=0, level3=0, level4=0, level5=0;
		int cnt1=0, cnt2=0, cnt3=0, cnt4=0, cnt5=0;
		String[][] table = new String[5][2];
		for(i=0; i<salary.length; i++) {
			for(j=0; j<employees.length; j++) {
				if(salary[i][0].equals(employees[j][0])) {
					if(employees[j][2].equals("사원")) {
						level1 += Integer.parseInt(salary[i][1]);
						cnt1++;
					} else if(employees[j][2].equals("대리")) {
						level2 += Integer.parseInt(salary[i][1]);
						cnt2++;
					} else if(employees[j][2].equals("과장")) {
						level3 += Integer.parseInt(salary[i][1]);
						cnt3++;
					} else if(employees[j][2].equals("차장")) {
						level4 += Integer.parseInt(salary[i][1]);
						cnt4++;
					} else if(employees[j][2].equals("부장")) {
						level5 += Integer.parseInt(salary[i][1]);
						cnt5++;
					}
				}
			}
		}
		String[] temp=new String[5];
//		if(cnt1!=0 && cnt2!=0 && cnt3!=0 && cnt4!=0 && cnt5!=0) {
			table[0][0] = "사원";
			table[0][1] = String.valueOf(level1/cnt1);
			table[1][0] = "대리";
			table[1][1] = String.valueOf(level2/(cnt2));
			table[2][0] = "과장";
			table[2][1] = String.valueOf(level3/cnt3);
			table[3][0] = "차장";
			table[3][1] = String.valueOf(level4/cnt4);
			table[4][0] = "부장";
			table[4][1] = String.valueOf(level5/cnt5);
//		}
		for(i=0; i<table.length; i++) {
			System.out.println("1.직급:"+table[i][0]+", 평균연봉:"+table[i][1]);
		}
		for(i=0; i<table.length-1; i++) {
			for(j=i+1; j<table.length; j++) {
				if(Integer.parseInt(table[i][1]) > Integer.parseInt(table[j][1])) {
					temp = table[i];
					System.out.println("2.직급:"+Arrays.toString(temp));
					table[i] = table[j];
					table[j] = temp;
					/*
					temp[0] = table[i][0];
					temp[1] = table[i][1];
					
					table[i][0] = table[j][0];
					table[i][1] = table[j][1];
					
					table[j][0] = temp[0];
					table[j][1] = temp[1];
					*/
				}
			}
		}
		for(i=0; i<table.length; i++) {
			System.out.println("직급:"+table[i][0]+", 평균연봉:"+table[i][1]);
		}
		return table;
	}
	
	public static String[] findWordCount(String[][] matrix, String word) {
		String[][] matrixXY = new String[10][10];
		String[] findXY = new String[7];
		char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
		int num = 0, j=0, idx=0, same=1;
		for(int i=0; i<matrix.length; i++) {
			for(j=0; j<matrix[0].length; j++) {
				matrixXY[i][j] = String.valueOf(alpha[i])+String.valueOf(num+j);				
			}
			//System.out.println(Arrays.toString(matrixXY[i]));
		}
		for(int col=0; col<matrix.length; col++) {
			String sero = "";
			idx=0;
			for(int row=0; row<word.length(); row++) {	
//				System.out.println("세로 matrix[row][col]: "+matrix[row][col]+", word.substring(idx, idx+1):"+word.substring(idx, idx+1));
				if(matrix[row][col].equals(word.substring(idx, idx+1))==true) {
					if(sero.isEmpty()) {
//						System.out.println("좌표값:"+matrixXY[row][col]);
						sero = matrixXY[row][col];
					}
					idx++;
					continue;
				} else {
					same=0;
					break;
				}
			}
			if(same==1) {
				System.out.println("세로 found: "+sero+", "+word);
			}
		}
		
		return findXY;
	}
	public static String[] garoWordCount(String[][] matrix, String word) {
		String[][] matrixXY = new String[10][10];
		String[] findXY = new String[7];
		char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
		int num = 0, j=0, idx=0, same=1;
		for(int i=0; i<matrix.length; i++) {
			for(j=0; j<matrix[0].length; j++) {
				matrixXY[i][j] = String.valueOf(alpha[i])+String.valueOf(num+j);				
			}
			//System.out.println(Arrays.toString(matrixXY[i]));
		}
		for(int row=0; row<matrix.length; row++) {
			String garo = "";
			idx=0;
			for(int col=0; col<matrix[0].length-1; col++) {	
				same=0;
//				System.out.println("가로 matrix[row][col]: "+matrix[row][col]+", word.substring(idx, idx+1):"+word.substring(idx, idx+1));
				if(matrix[row][col].equals(word.substring(idx, idx+1))!=true) {
					same=0;
					idx=0;
					continue;
				} else {
					if(idx==0) {
						garo = matrixXY[row][col];
					}
					same=1;
					idx++;
					if(idx == word.length()-1) {
//						System.out.println(word.charAt(idx)+" "+matrix[row][col+1]);
//						System.out.println(word.substring(4,5));
						if(matrix[row][col+1].equals(word.substring(idx, idx+1))==true) {
//							System.out.println("가로 matrix[row][col+1]: "+matrix[row][col+1]+", word.substring(idx, idx+1):"+word.substring(idx, idx+1));
							System.out.println("가로 found: "+garo+", "+word);
							break;
						}
					}
				}
			}
			if(same==1) {
//				System.out.println("가로 found: "+garo+", "+word);
			}
		}
		
		return findXY;
	}
	public static String[] diagWordCount(String[][] matrix, String word) {
		String[][] matrixXY = new String[10][10];
		String[] findXY = new String[7];
		char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
		int num = 0, j=0, idx=0, same=1, k=0;
		for(int i=0; i<matrix.length; i++) {
			for(j=0; j<matrix[0].length; j++) {
				matrixXY[i][j] = String.valueOf(alpha[i])+String.valueOf(num+j);				
			}
			//System.out.println(Arrays.toString(matrixXY[i]));
		}
		for(int row=0; row<matrix.length-1; row++) {
			String diago = "";
			idx=0;
			for(int col=0; col<matrix[0].length-1; col++) {	
				same=0;
				idx=0;
				for(k=0; k<matrix[0].length-1; k++) {	
					if((row+k) < 10 && (col+k) < 10) {
//						System.out.println("1. row+k:"+(row+k)+", col+k:"+(col+k));
						if(idx == word.length()-1) {
//							System.out.println(word.charAt(idx)+" "+matrix[row][col+1]);
//							System.out.println(word.substring(4,5));
							if(matrix[row+k][col+k].equals(word.substring(idx, idx+1))==true) {
								System.out.println("최종 대각선 matrix[row+k][col+k]: "+matrix[row+k][col+k]+", word.substring(idx, idx+1):"+word.substring(idx, idx+1));
								System.out.println("최종 대각선 found: "+diago+", "+word);
								break;
							}
						}
						if(matrix[row+k][col+k].equals(word.substring(idx, idx+1))!=true) {
//							System.out.println("1. idx:"+idx+", 대각선 matrix[row+k][col+k]: "+matrix[row+k][col+k]+", word.substring(idx, idx+1):"+word.substring(idx, idx+1));
							same=0;
							idx=0;
							continue;
						} else {
//							System.out.println("idx:"+idx);
							if(idx==0) {
								diago = matrixXY[row][col];
							}
							same=1;
							idx++;
							if(idx == word.length()-1) {
//								System.out.println(word.charAt(idx)+" "+matrix[row][col+1]);
//								System.out.println(word.substring(4,5));
								if(matrix[row+1][col+1].equals(word.substring(idx, idx+1))==true) {
									System.out.println("대각선 matrix[row][col+1]: "+matrix[row][col+1]+", word.substring(idx, idx+1):"+word.substring(idx, idx+1));
									System.out.println("대각선 found: "+diago+", "+word);
									break;
								}
							}
						}
					}
				}
			}
			if(same==1) {
//				System.out.println("가로 found: "+garo+", "+word);
			}
		}
		
		return findXY;
	}
	/*
	int[][] matrix = {{5, -1, -2, -1, -3},
			  {-1, 6, -3, -2, -4},
			  {-2, -3, 7, -1, -2},
			  {-1, -2, -1, 8, -1},
			  {-3, -4, -2, -1, 0}};
	printMatrix(matrix);
	*/
	//Integer arr[] = {1, 2, 3, 5, 4, 7, 10};
	//Output : arr[] = {7, 5, 3, 1, 2, 4, 10}

	//int arr1[] = {0, 4, 5, 3, 7, 2, 1};
	//Output : arr[] = {7, 5, 3, 1, 0, 2, 4}
	//twoWaySorting(arr, arr.length);
	//reverseIntSorting(arr1, arr1.length);
	//count("Java+ is great.");
	//int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
	//int A2[] = {2, 1, 8, 3};
	//A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
	//sortAccording(A1, A2, A1.length, A2.length);
	/*
	List<Integer> list = new ArrayList<>();
	list.add(20);
	list.add(10);
	list.add(30);
	list.add(2);
	list.add(1);
	Collections.sort(list);
	System.out.println(list);
	list.remove(1);
	System.out.println(list);
	list.remove(new Integer(1));
	System.out.println(list);
	Iterator itr = list.iterator();
	while(itr.hasNext()) {
		int x = (Integer)itr.next();
		if(x>10) {
			itr.remove();
		}
	}
	System.out.println(list);
	*/
	public static void printMatrix(int[][] arr) {
		int matrix[][] = new int[5][5];
		int i=0, k=0; //, row=0, col=0;
		for(i=0; i<matrix.length; i++) {
			
			if(i%2 == 0) {
				for(k=0; k<matrix[0].length; k++) {
					System.out.print(arr[i][k]+" ");
				}
			} else {
				for(k=matrix[0].length-1; k>=0; k--) {
					System.out.print(arr[i][k]+" ");
				}
			}
			
			System.out.println();
		}
	}
	public static int count(String sentence) {
		if(sentence==null || sentence.length()==0) {
			return 0;
		}
		String[] words = sentence.split("\\s+");
		System.out.println(words.length);
		for(int i=0; i<words.length; i++) {
			System.out.println(words[i]);
		}
		return words.length;
	}
	public static int[] reverse(int[] input) {
		int last = input.length-1;
		int middle = input.length/2;
		System.out.println("middle:"+middle);
		for(int i=0; i<middle; i++) {
			int temp = input[i];
			System.out.println("11.temp:"+temp);
			input[i] = input[last-i];
			System.out.println("22.input[i]:"+input[i]);
			input[last-i] = temp;
			System.out.println("33.input[last-i]:"+input[last-i]);
		}
		return input;
	}
	public static void reverseIntSorting(int[] arr, int n) {
		int i=0, cnt_even=0, cnt_odd=0;
		int even[] = new int[3];
		int odd[] = new int[4];
		for(i=0; i<n; i++) {
			if(arr[i]%2 == 0) {
				even[cnt_even] = arr[i];
				System.out.println("1. "+even[cnt_even]);
				cnt_even++;
			} else {
				odd[cnt_odd] = arr[i];
				System.out.println("2. "+odd[cnt_odd]);
				cnt_odd++;
			}
		}
		Arrays.sort(even);
		Arrays.sort(odd);
//		System.out.println(Arrays.toString(odd));
//		reverse(odd);
		System.out.println(Arrays.toString(reverse(odd))+Arrays.toString(even));
		//for(i=0; i<cnt_odd; i++) {
		//	System.out.print(odd[i]+" ");
		//}
		//System.out.println(odd);
	}
	//int arr[] = {1, 2, 3, 5, 4, 7, 10};
	public static void twoWaySorting(Integer[] arr, int n) {
		int i=0, cnt_even=0, cnt_odd=0;
		Integer even[] = new Integer[3];
		Integer odd[] = new Integer[4];
		for(i=0; i<n; i++) {
			if(arr[i]%2 == 0) {
				even[cnt_even] = arr[i];
				System.out.println("1. "+even[cnt_even]);
				cnt_even++;
			} else {
				odd[cnt_odd] = arr[i];
				System.out.println("2. "+odd[cnt_odd]);
				cnt_odd++;
			}
		}
		Arrays.sort(even);
		Arrays.sort(odd, Collections.reverseOrder());
		System.out.println(Arrays.toString(odd)+Arrays.toString(even));
		//for(i=0; i<cnt_odd; i++) {
		//	System.out.print(odd[i]+" ");
		//}
		//System.out.println(odd);
	}
	//int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
	//int A2[] = {2, 1, 8, 3};
	public static void sortAccording(int A1[], int A2[], int m, int n) {
		int temp[] = new int[m];
		int visited[] = new int[m];
		int i=0, k=0, t=0, cnt=0, imsi=0;
		for(i=0; i<m; i++) {
			visited[i] = 0;
		}
		for(i=0; i<n; i++) {
			for(k=0; k<m; k++) {
				if(visited[k] != 1) {
					if(A2[i] == A1[k]) {
						temp[cnt] = A1[k];
						visited[k] = 1;
						cnt++;
					}
				}
			}
		}
//		System.out.println(cnt);
		int imsi2[] = new int[m-cnt];

		for(k=0; k<m; k++) {
			if(visited[k] != 1) {
				imsi2[t] = A1[k];
//				System.out.println(imsi2[t]+" "+t);
				t++;
			}
		}

		for(i=0; i<m-cnt; i++) {
			for(k=i+1; k<m-cnt; k++) {
				if(imsi2[i] > imsi2[k]) {
					imsi = imsi2[i];
					imsi2[i] = imsi2[k];
					imsi2[k] = imsi;
				}
			}
		}
		k=0;
		for(i=cnt; i<m; i++) {
			temp[i] = imsi2[k];
			k++;
		}

		for(i=0; i<m; i++) {
			System.out.print(temp[i]+" ");
		}
	}
}
/*
import java.util.Scanner; // How to check if String is palindrome in Java using StringBuffer and for loop.** @author java67 
public class Palindrome
{ 
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Please enter a String"); 
		String input = reader.nextLine(); 
		System.out.printf("Is %s a palindrome? : %b %n", input, isPalindrome(input)); 
		System.out.println("Please enter another String"); 
		input = reader.nextLine(); 
		System.out.printf("Is %s a palindrome? : %b %n", input, isPalindrome(input));
		reader.close();
	} 
	public static boolean isPalindrome(String input) { 
		if (input == null || input.isEmpty()) { 
			return true;
		}
		char[] array = input.toCharArray();
		StringBuilder sb = new StringBuilder(input.length()); 
		for (int i = input.length() - 1; i >= 0; i--) {
			sb.append(array[i]);
		} 
		String reverseOfString = sb.toString(); 
		return input.equals(reverseOfString);
	} 
} 

Read more: http://www.java67.com/2015/06/how-to-check-is-string-is-palindrome-in.html#ixzz5jiA3xJXX
*/