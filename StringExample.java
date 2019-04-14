package com.lgcns.tct.string;

import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 1.A37D2CB5E8F
// 1) ADCBEF
// 2) 37258
// 2.A3D7C2B5E8F
// 3.2234 123 5678 456 8978 3321 12 345 689
// 1) 123 5678 456 12 345
// 2) 567812
// 4. 77 78 12 30  7 8 2 0   0 2 7 8   0 2 5 5   0 2 0 0 
//    33 78 9 7    3 8 9 7   3 7 8 9   0 4 7 8   0 4 0 8
//    5 71 84 25   5 1 4 5   1 4 5 5   1 7 7 9   1 0 0 0
//    9 37 0 27    9 7 0 7   0 7 7 9   3 7 8 9   3 0 8 0   2+4+8+1+3+8=26
// 5. GTTAG
//        AGTCATG
// GTAT
//   ATTCGG
public class StringExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String inputData = "A37D2CB5E8F";
		getNewStr(getStrList(inputData));
		//List<String> inputData = Arrays.asList("3425", "689", "456", "2345", "1254", "1254", "7754", "3255", "345");
		//List<String> inputData = Arrays.asList("2234", "123", "5678", "456", "8978", "3321", "12", "345", "689");
		//getMaxNum(getSequenceList(inputData));
		/*
		int[][] inputData = {
				{11, 32, 57, 65, 34},
				{53, 16, 3, 93, 22},
				{35, 22, 73, 64, 14},
				{12, 24, 34, 45, 91},
				{9, 51, 35, 28, 75}
		};
		
		getArrSum(getSortedArray(inputData));
		*/
/*		String strFirst = new String();
		String strSecond = new String();
		strFirst = "AGTCATG"; //ATTCGG";	//"AGTCATG";
		strSecond = "GTTAG";	//GTAT";		//"GTTAG";
		int start = 0, i=0, k=0, same_cnt=0, m=0, add=0, max=0, overlap=1, x=0, y=0;
		char[] chFirst = strFirst.toCharArray();
		char[] chSecond = strSecond.toCharArray();
*/
		/*
						// A   C   G   T   0
		int[][] matrix = {{5, -1, -2, -1, -3},
						  {-1, 6, -3, -2, -4},
						  {-2, -3, 7, -1, -2},
						  {-1, -2, -1, 8, -1},
						  {-3, -4, -2, -1, 0}};
		String inputData = "AGTCATG,GTTAG"; 	//"ATTCGG,GTAT";	//"AGTCATG,GTTAG";
		int similarity = measureSimpleComparison(inputData);
		System.out.println("1) 유사도:"+similarity);
		int similarityMax = measureSortComparison(inputData, matrix);
		System.out.println("2) 유사도 메트릭스:"+similarityMax);
*/
		/*
		while(start >= 0 && start < strFirst.length()) {
			same_cnt = 0;
			for(k=0; k<overlap; k++) {
				System.out.println("1:"+(strSecond.length()-1-k));
				System.out.println("2:"+(overlap-1-k));
				if(chSecond[strSecond.length()-1-k] == chFirst[overlap-1-k+add]) {
					same_cnt++;
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
			*/
			/*
			if(chFirst[start] == chSecond[i]) {
				System.out.println("동일문자:"+chFirst[start]+","+chSecond[i]);
				same_cnt++;
				k=start+1;
				m=i+1;
				System.out.println("same_cnt:"+same_cnt+", k:"+k+", m:"+m);
				while(k<strFirst.length()) {
					while(m<strSecond.length()) {
						if(chFirst[k] == chSecond[m]) {
							System.out.println("다음 동일문자:"+chFirst[k]+","+chSecond[m]);
							System.out.println("다음 k:"+k+", m:"+m);
							same_cnt++;
							System.out.println("다음 same_cnt:"+same_cnt);
						}
						k++;
						m++;
					}
					System.out.println("그 다음 k:"+k+", m:"+m);
					if(m==strSecond.length())
					{
						if(same_cnt > max) {
							max = same_cnt;
						}
						System.out.println("최종 same_cnt:"+max);
						end_flag = 1;
						break;
					}
				}
//				System.out.println(same_cnt);
			}
			
			start++;
			if(end_flag == 1) {
				System.out.println("종료");
				break;
			}
*/			
//		}
//		System.out.println("최종 same_cnt:"+max);
		/*
		String strAlpha = new String();
		String strNum = new String();
		String strNew = new String();
		String input = "F7T123GCZ5Q";	// A37D2CB5E8F
		char[] chInput = input.toCharArray();
		int i=0;
		for(i=0; i<input.length(); i++) {
			if(chInput[i]>='1' && chInput[i]<='9') {
				strNum += Character.toString(chInput[i]);
			} else if(chInput[i]>='A' && chInput[i]<='Z') {
				strAlpha += Character.toString(chInput[i]);
			}
		}
		System.out.println("[문자 문자열]"+strAlpha);
		System.out.println("[숫자 문자열]"+strNum);
		char[] chAlpha = strAlpha.toCharArray();
		char[] chNum = strNum.toCharArray();
		
		for(i=0; i<input.length()/2; i++) {
			strNew += (Character.toString(chAlpha[i]) + Character.toString(chNum[i]));
		}
		strNew += (Character.toString(chAlpha[i]));
		System.out.println("[최종 문자열]"+strNew);
		*/
		/*
		Scanner sc1 = new Scanner(new File("score.txt"));
		Scanner sc2 = null;
		int cnt = 0;
		int totalSum = 0;
		
		while(sc1.hasNextLine()) {
			String line = sc1.nextLine();
			sc2 = new Scanner(line).useDelimiter(",");
			int sum = 0;
			while(sc2.hasNextInt()) {
				sum = sum + sc2.nextInt();
			}
			System.out.println(line+" sum:"+sum);
			cnt++;
			sc2.close();
		}
		sc1.close();
		*/
		/*
		String word = "POWER";
		String result = null;
		String[] word_array = word.split("");
		if(word.length()%2==0)
		{
			result = word_array[word.length()/2-1] + word_array[word.length()/2];
		}
		else
		{
			result = word_array[word.length()/2];
		}
//		System.out.println(result);
		
		for(int i=0; i<word.length(); i++)
		{
//			System.out.println(word_array[i]);
		}
		char[] word_charArray = word.toCharArray();
		for(int i=0; i<word.length(); i++)
		{
//			System.out.println(word_charArray[i]);
		}
		char[] word_array2 = new char[word.length()];
		for(int i=0; i<word.length(); i++)
		{
			word_array2[i] = word.charAt(i);
//			System.out.println(word_array2[i]);
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("단어를 입력해주세요");
		String word3 = sc.next();
		String result3 = null;
		String[] word_array3 = new String[word3.length()];
		for(int i=0; i<word3.length(); i++) {
			word_array3[i] = Character.toString(word3.charAt(i));
		}
		if(word3.length()%2 == 0)
		{
			result3 = word_array3[word3.length()/2-1] + word_array3[word3.length()/2];
		}
		else
		{
			result3 = word_array3[word3.length()/2];
		}
		System.out.println(result3);
		System.out.println(word3.substring((word3.length()-1)/2, word3.length()/2+1));
		for(int i=word3.length()-1; i>=0; i--)
		{
			System.out.print(word_array3[i]);
		}
		sc.close();
		*/
	}
	
	public static List<String> getStrList(String inputData) {
		List<String> strList = new ArrayList<String>();
		StringBuilder str = new StringBuilder();
		StringBuilder num = new StringBuilder();
		for(int i=0; i<inputData.length(); i++) {
			if(inputData.charAt(i) >= '0' && inputData.charAt(i) <= '9') {
				num.append(inputData.substring(i, i+1));
			} else {
				str.append(inputData.substring(i, i+1));
			}
		}
		strList.add(str.toString());
		strList.add(num.toString());
		System.out.println(strList);
		return strList;
	}
	
	public static String getNewStr(List<String> strList) {
		String newStr = "";
		//StringBuilder tmp = new StringBuilder();
		String str = strList.get(0);
		String num = strList.get(1);
		int i=0;

		for(i=0; i<num.length(); i++) {
			newStr += str.substring(i, i+1);
			newStr += num.substring(i, i+1);
		}
		newStr += str.substring(i, i+1);
		System.out.println(newStr);
		return newStr;
	}
	public static List<String> getSequenceList(List<String> inputData) {
		List<String> sequenceList = new ArrayList<>();
		int flag = 0, cnt = 0, i = 0;
		for(i=0; i<inputData.size(); i++) {
			flag = 0;
			for(int j=0; j<inputData.get(i).length()-1; j++) {
				if(Integer.parseInt(inputData.get(i).substring(j, j+1)) + 1 == 
						Integer.parseInt(inputData.get(i).substring(j+1, j+2))) {
					continue;
				}
				else
				{
					flag = 1;
					break;
				}
			}
			if(flag == 0) {
				System.out.println(inputData.get(i));
				sequenceList.add(cnt, inputData.get(i));
				cnt++;
			}
		}

		return sequenceList;
	}
	
	public static int getMaxNum(List<String> sequenceList) {
		int maxNum = 0;
		List<Integer> num = new ArrayList<Integer>();
		StringBuilder str = new StringBuilder();
		int max = 0;
		int min = 100000;
		for(int i=0; i<sequenceList.size(); i++) {
			num.add(Integer.parseInt(sequenceList.get(i)));
		}
		for(int i=0; i<num.size(); i++) {
			if(num.get(i) > max) {
				max = num.get(i);
			}
			if(num.get(i) < min) {
				min = num.get(i);
			}
		}
		System.out.println("최대값:"+max+", 최소값:"+min);
		String maxStr = String.valueOf(max);
		String minStr = String.valueOf(min);
		
		if(maxStr.charAt(0) > minStr.charAt(0)) {
			str.append(maxStr);
			str.append(minStr);
		}
		else if(maxStr.charAt(0) < minStr.charAt(0)) {
			str.append(minStr);
			str.append(maxStr);
		}
		else {
			str.append(maxStr);
			str.append(minStr);
		}
		System.out.println("최대문자열:"+str.toString());
		return Integer.parseInt(str.toString());
	}
	
	public static int measureSimpleComparison(String inputData) {
		int similarity = 0;
		String[] genom = inputData.split(",");
		String str1 = null;
		String str2 = null;
		int size = genom[0].length() + genom[1].length();
		String tmpStr2 = getGenom(genom[1], size, genom[0].length());
		for(int i=0; i<genom[1].length()+1; i++) {
			int count = 0;
			str1 = getGenom(genom[0], size, i);
			for(int j=0; j<size; j++) {
				if(str1.charAt(j) != '-' && str1.charAt(j) == tmpStr2.charAt(j)) {
					count++;
				}
			}
			if(count > similarity) {
				similarity = count;
			}
		}
		String tmpStr1 = getGenom(genom[0], size, genom[1].length());	//tmpStr1 = str1; 
		for(int i=0; i<genom[0].length()+1; i++) {
			int count = 0;
			str2 = getGenom(genom[1], size, genom[0].length()-i);
			for(int j=0; j<size; j++) {
				if(str2.charAt(j) != '-' && str2.charAt(j) == tmpStr1.charAt(j)) {
					count++;
				}
			}
			if(count > similarity) {
				similarity = count;
			}
		}
		return similarity;
	}	
	public static int measureSortComparison(String inputData, int[][] similarityMatrix) {
		int maxSimilarity = 0;
		String[] genom = inputData.split(",");
		String str1 = null;
		String str2 = null;
		int size = genom[0].length() + genom[1].length();
		String tmpStr2 = getGenom(genom[1], size, genom[0].length());
		for(int i=0; i<genom[1].length()+1; i++) {
			int count = 0;
			str1 = getGenom(genom[0], size, i);
			for(int j=0; j<size; j++) {
				int x = getNum(str1.charAt(j));
				int y = getNum(tmpStr2.charAt(j));
				count += similarityMatrix[x][y]; 
			}
			if(count > maxSimilarity) {
				maxSimilarity = count;
			}
		}
		String tmpStr1 = getGenom(genom[0], size, genom[1].length());	//tmpStr1 = str1; 
		for(int i=0; i<genom[0].length()+1; i++) {
			int count = 0;
			str2 = getGenom(genom[1], size, genom[0].length()-i);
			for(int j=0; j<size; j++) {
				int x = getNum(str2.charAt(j));
				int y = getNum(tmpStr1.charAt(j));
				count += similarityMatrix[x][y]; 
			}
			if(count > maxSimilarity) {
				maxSimilarity = count;
			}
		}
		return maxSimilarity;
	}
	public static String getGenom(String str, int size, int start) {
		StringBuilder tmp = new StringBuilder();
		
		for(int i=0; i<start; i++) {
			tmp.append("-");
		}
		tmp.append(str);
		for(int i=start+str.length(); i<size; i++) {
			tmp.append("-");
		}
		return tmp.toString();
	}
	public static int getNum(char in) {
		if(in == 'A')
			return 0;
		else if(in == 'C')
			return 1;
		else if(in == 'G')
			return 2;
		else if(in == 'T')
			return 3;
		else
			return 4;
	}
	
	public static int[][] getSortedArray(int[][] inputData) {
		int[][] sortedArray = null;
		int size = inputData.length;
		sortedArray = new int[size][size];
		for(int i=0; i<sortedArray.length; i++) {
			for(int j=0; j<sortedArray[0].length; j++) {
				sortedArray[i][j] = inputData[i][j]%10;
				System.out.print(sortedArray[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0; i<sortedArray.length; i++) {
			Arrays.sort(sortedArray[i]);
		}
		System.out.println("행 정렬후");
		for(int i=0; i<sortedArray.length; i++) {
			for(int j=0; j<sortedArray[0].length; j++) {
				System.out.print(sortedArray[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0; i<sortedArray.length; i++) {
			Arrays.sort(sortedArray[i]);
		}
		System.out.println("열 정렬후");
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
		for(int i=0; i<sortedArray.length; i++) {
			for(int j=0; j<sortedArray[0].length; j++) {
				System.out.print(sortedArray[i][j]+" ");
			}
			System.out.println();
		}
		return sortedArray;
	}
	public static int getArrSum(int[][] sortedArray) {
		int arrSum = 0;
		int size = sortedArray.length;
		int[][] tmp = new int[size][size];
		for(int i=0; i<size; i++) {
			System.arraycopy(sortedArray[i], 0, tmp[i], 0, size);
		}
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(i != size-1 && j != size-1) {
					if(tmp[i][j] == tmp[i][j+1]) {
						sortedArray[i][j] = 0;
						sortedArray[i][j+1] = 0;
					}
					if(tmp[i][j] == tmp[i+1][j]) {
						sortedArray[i][j] = 0;
						sortedArray[i+1][j] = 0;
					}
				}
				else if(i == size-1 && j != size-1) {
					if(tmp[i][j] == tmp[i][j+1]) {
						sortedArray[i][j] = 0;
						sortedArray[i][j+1] = 0;
					}
					if(tmp[i][j] == tmp[i-1][j]) {
						sortedArray[i][j] = 0;
						sortedArray[i-1][j] = 0;
					}
				}
				else if(i != size-1 && j == size-1) {
					if(tmp[i][j] == tmp[i][j-1]) {
						sortedArray[i][j] = 0;
						sortedArray[i][j-1] = 0;
					}
					if(tmp[i][j] == tmp[i+1][j]) {
						sortedArray[i][j] = 0;
						sortedArray[i+1][j] = 0;
					}
				}
			}
		}
		System.out.println();
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(sortedArray[i][j]+" ");
				arrSum += sortedArray[i][j];
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("배열합 : "+arrSum);
		return arrSum;
	}
	

}
