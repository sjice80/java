package org.opentutorials.javatutorials.eclipse;

import java.util.ArrayList;
import java.util.List;

public class Helloworld {

	static int saleNumber = 0;
	static String[] saleKind;
	static String[] products = {"coffee", "gimbap", "water", "ramen", "kimchi", "rice", "cigarettes",
								"milk", "popcorn", "chocolate", "paper", "soju", "beer"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "2h4e1llo7";
		String tmpStr = "";
		String newStr = "";
		int n1 = 1234567;
		String[] phone_book = {"119", "11997674223", "5524119421"};
		
		Solution.solution(phone_book);
		loadData();
	
		saleKind = LGStore.makeNormalData(saleKind, saleNumber);
		System.out.println("1번결과");
		for(int i=0; i<saleNumber; i++) {
			System.out.println(saleKind[i]);
		}
		
		saleKind = LGStore.correctLetterOrder(saleKind, saleNumber, products);
		System.out.println("2번결과");
		for(int i=0; i<saleNumber; i++) {
			System.out.println(saleKind[i]);
		}		

		saleKind = LGStore.makeDistinctedData(saleKind, saleNumber);
		System.out.println("3번결과");
		for(int i=0; i<saleNumber; i++) {
			if(saleKind[i] != null)
				System.out.println(saleKind[i]);
		}
		
		int[][] inputData = {
				{1,2,2,5,4},
				{3,1,3,3,2},
				{5,2,3,4,4},
				{2,4,4,5,1},
				{4,1,5,3,5}
		};
		char c;
		char[] ch = s1.toCharArray();
		for(int i=0; i<ch.length; i++)
		{
			c = ch[i];
			String cToStr = String.valueOf(c);
			if(isNum(cToStr)==true)
			{
				tmpStr += cToStr;
			}
			else
			{
				newStr += cToStr;
			}
		}
		newStr += tmpStr;
		/*
		System.out.println(newStr);
		System.out.println(getProductNum(newStr));
		System.out.println(getLargeNumber(n1));
		System.out.println(getFinalNumber(n1));
		rotateArray(inputData);
		*/
		List<Integer> Move = new ArrayList<Integer>();
		Move = getMoveInfo(11,8);
		System.out.println(getNumber(Move));
		
	} 
	public static boolean isNum(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	public static String getProductNum(String newStr) {
		String productNum = "";
		char[] ch = newStr.toCharArray();
		int num = 9;
		int cal = 0;
		for(char c : ch)
		{
			String cToStr = String.valueOf(c);
			if(isNum(cToStr)) {
				cal += Integer.parseInt(cToStr) * num;
				num--;
			}
		}
		productNum = newStr + (cal%5);
		return productNum;
	}
	public static int getLargeNumber(int inputData) {
		int largeNumber = 0;
		
		String numberStr = String.valueOf(inputData);
		if(numberStr.length() <= 1)
		{
			largeNumber = Integer.parseInt(numberStr);
		}
		else
		{
			int firstNum = 0;
			int secondNum = 0;
			if(numberStr.length() % 2 == 0)
			{
				firstNum = Integer.parseInt(numberStr.substring(0, numberStr.length()/2));
				secondNum = Integer.parseInt(numberStr.substring(numberStr.length()/2));
			}
			else
			{
				firstNum = Integer.parseInt(numberStr.substring(0, numberStr.length()/2));
				secondNum = Integer.parseInt(numberStr.substring(numberStr.length()/2+1));
			}
			if(firstNum>secondNum)
			{
				largeNumber = firstNum;
			}
			else
			{
				largeNumber = secondNum;
			}
		}
		return largeNumber;

	}
	public static int getFinalNumber(int largeNumber) {
		int finalNumber = 0;
		while(true)
		{
			finalNumber = getLargeNumber(largeNumber);
			largeNumber = finalNumber;
//			String largeStr = String.valueOf(largeNumber);
			if(String.valueOf(finalNumber).length() == 1)
			{
//				finalNumber = largeNumber;
				break;
			}
		}
		return finalNumber;		
	}
	public static int[][] rotateArray(int[][] inputData) {
		System.out.println("[입력 배열]");
		for(int k=0; k<inputData.length; k++)
		{
			for(int l=0; l<inputData[k].length; l++)
			{
				System.out.print(inputData[k][l] + " ");
			}
			System.out.println();
		}
		
		int[][] rotatedArray = new int[inputData.length][inputData[0].length];
		for(int i=0; i<inputData.length; i++) {
			System.arraycopy(inputData[i], 0, rotatedArray[i], 0, inputData[i].length);
		}
		for(int i=0; i<inputData.length; i++) {
			for(int j=0; j<inputData[i].length; j++) {
				if(i==0 || i==inputData.length-1 || j==0 || j==inputData[i].length-1)
				{
					rotatedArray[j][inputData.length-i-1] = inputData[i][j];
				}
			}
		}
		System.out.println("\n[회전 배열]");
		for(int k=0; k<rotatedArray.length; k++)
		{
			for(int l=0; l<rotatedArray[k].length; l++)
			{
				System.out.print(rotatedArray[k][l] + " ");
			}
			System.out.println();
		}
		return rotatedArray;
	}
	
	public static List<Integer> getMoveInfo(int numberOfBalloon, int numberOfMove) {
		List<Integer> moveInfo = new ArrayList<Integer>();
		int index=1, i=0;
		int tmpNumberOfMove=0;
		moveInfo.add(numberOfBalloon);
		while(true)
		{
			if(moveInfo.get(index-1) > 1)
			{
				tmpNumberOfMove++;
				moveInfo.set(index-1, moveInfo.get(index-1)-2);
				if(index == moveInfo.size()-1)
				{
					moveInfo.set(index, moveInfo.get(index)+1);
				}
				else
				{
					moveInfo.add(1);
				}
				for(i=0; i<=index; i++)
				{
					System.out.print(moveInfo.get(i)+" ");
				}
				System.out.println();

				if(tmpNumberOfMove == numberOfMove)
				{
					System.out.println("AA");
					break;
				}
				if(moveInfo.get(index-1)<=1 && moveInfo.get(index)<=1)
				{
					System.out.println("TT");
					break;
				}
			}
			else
			{
				index++;
				System.out.println("Next:"+index);
			}
		}
		System.out.println("Final:"+index);
		for(i=0; i<=index; i++)
		{
			System.out.print(moveInfo.get(i)+" ");
		}
		System.out.println();		
		return moveInfo;
		
	}
	public static int getNumber(List<Integer> finalMoveList) {
		int number = 0;
		int index = finalMoveList.size()-1;
		while(true)
		{
			if(finalMoveList.get(index)>0)
			{
				finalMoveList.set(index, finalMoveList.get(index)-1);
				finalMoveList.set(index-1, finalMoveList.get(index-1)+2);
			}
			else
			{
				index--;
			}
			if(index <=  0)
			{
				break;
			}
		}
		number = finalMoveList.get(0);
		return number;
	}
	public static void loadData() {
		saleNumber = 20;
		String data[] = {"coffee", "eeFFCo", "amenr", "Ra Men", "CO FFE E",
				"coFfee", "c#off$ee", "cOe f%%&f*e", "bapgim", "rice", "RiCE", "*Ri&c@e",
				"gim $bap", "BAP@gim", "*G*imba p", "water", "FFCOEE", "WATER", "TERAW", "*tW$a ER#" };
		saleKind = data;
	}	
}

class LGStore {
	static final int PRODUCT_TYPE_NUM = 13;
	static final int MAX_KIND = 500;
	static final int MAX_DISTINCTION_KIND = 100;
	static final int MAX_TEXT_LENGTH = 20;
	
	public static String[] makeNormalData(String[] saleKind, int saleNumber) {
		String[] retData = new String[MAX_KIND];
		int i, k;
		int index = 0;
		
		char[] newKind = new char[MAX_TEXT_LENGTH];
		for(i=0; i<saleNumber; i++) {
			index = 0;
			for(k=0; k<saleKind[i].length(); k++) {
				if((saleKind[i].charAt(k) >= 'A' && saleKind[i].charAt(k) <= 'Z') || 
						(saleKind[i].charAt(k) >= 'a' && saleKind[i].charAt(k) <= 'z')) {
					newKind[index] = saleKind[i].charAt(k);
					if(saleKind[i].charAt(k) >= 'A' && saleKind[i].charAt(k) <= 'Z') {
						newKind[index] += ('a' - 'A'); 
					}
					index++;
				}
			}
			retData[i] = new String(newKind, 0, index).trim();
		}
		return retData;
	}
	public static String[] correctLetterOrder(String[] saleKind, int saleNumber, String[] products) {
		String[] retData = new String[MAX_KIND];
		String[] sortedProducts = new String[13];
		for(int i=0; i<PRODUCT_TYPE_NUM; i++) {
			sortedProducts[i] = new String(products[i]);
		}
		
		int i, k, num;
		char tmpCh;
		char[] prodStr = new char[MAX_TEXT_LENGTH];
		for(num=0; num<PRODUCT_TYPE_NUM; num++) {
			prodStr = sortedProducts[num].toCharArray();
			for(i=0; i<prodStr.length-1; i++) {
				for(k=i+1; k<prodStr.length; k++) {
					if(prodStr[i] > prodStr[k]) {
						tmpCh = prodStr[i];
						prodStr[i] = prodStr[k];
						prodStr[k] = tmpCh;
					}
				}
			}
			sortedProducts[num] = new String(prodStr, 0, prodStr.length).trim();
		}
		
		for(num=0; num<saleNumber; num++) {
			prodStr = saleKind[num].toCharArray();
			for(i=0; i<prodStr.length-1; i++) {
				for(k=i+1; k<prodStr.length; k++) {
					if(prodStr[i] > prodStr[k]) {
						tmpCh = prodStr[i];
						prodStr[i] = prodStr[k];
						prodStr[k] = tmpCh;
					}
				}
			}
			String prodStrImsi = new String(prodStr, 0, prodStr.length).trim();
			for(i=0; i<PRODUCT_TYPE_NUM; i++) {
				if(prodStrImsi.equals(sortedProducts[i]) == true) {
					saleKind[num] = products[i];
					break;
				}
			}
		}
		retData = saleKind;
		

		return retData;
	}
	public static String[] makeDistinctedData(String[] saleKind, int saleNumber) {
		String[] retData = new String[MAX_DISTINCTION_KIND];
		int i, k, index = 0;
		char find = 'N';
		
		for(i=0; i<saleNumber; i++) {
			find = 'N';
			for(k=0; k<index; k++) {
				if(saleKind[i].equals(retData[k]) == true) {
					find = 'Y';
					break;
				}
			}
			if(find == 'N') {
				retData[index] = saleKind[i];
				index++;
			}
		}

		System.out.println("makeDistinctedData");
		for(int j=0; j<index; j++) {
			if(retData[j] != null)
				System.out.println(retData[j]);
		}
		char ch1, ch2;
		String tmpStr = new String();
		int sw = 0;
		for(i=0; i<index-1; i++) {
			sw = 0;
			for(k=0; k<index-1-i; k++) {
				ch1 = retData[k].charAt(1);
				ch2 = retData[k+1].charAt(1);
				if(ch1 > ch2) {
					sw = 1;
					tmpStr = retData[k];
					retData[k] = retData[k+1];
					retData[k+1] = tmpStr;
				}
				else if(ch1 == ch2) {
					ch1 = retData[k].charAt(0);
					ch2 = retData[k+1].charAt(0);
					if(ch1 > ch2) {
						sw = 1;
						tmpStr = retData[k];
						retData[k] = retData[k+1];
						retData[k+1] = tmpStr;
					}
				}
			}
			if(sw == 0) {
				break;
			}
		}
		return retData;
	}
}

class Solution {
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		for(int i=0; i<phone_book.length; i++) {
			for(int j=0; j<phone_book.length; j++) {
				if(i==j) {
					continue;
				} else if(phone_book[j].startsWith(phone_book[i])) {
					answer = false;
					System.out.println(phone_book[i]+"=="+phone_book[j]);
					break;
				}
				
			}
		}
		return answer;
	}
}
