package matrixsum;
import java.util.*;

class Car {
    public String brand;
    public String numberPlate;
    public int noOfDoors;

    public Car(String brand, String numberPlate, int noOfDoors) {
        this.brand = brand;
        this.numberPlate = numberPlate;
        this.noOfDoors = noOfDoors;
    }
}

public class MatrixSum {

	static int saleNumber = 0;
	static String[] saleKind;
	static String[] products = {"coffee", "gimbap", "water", "ramen", "kimchi", "rice", "cigarettes",
								"milk", "popcorn", "chocolate", "paper", "soju", "beer"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ababa";
		
		countSimilarity(str, makeSuffix(str));
		/*
		List<String> inputData = Arrays.asList(
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
		String sellerId = "KIM";
		String periodOfSale = "20-25";
		
		getCosmeticsList(inputData, name, term);
		getPrice(inputData, sellerId, periodOfSale);
		*/
		/*
		int[][] data = {{1099, 18, 0, 19, 15, 1},
						{1077, 19, 30, 0, 0, 0},
						{1044, 18, 45,21, 11, 0},
						{1088, 19, 30, 20, 28, 0},
						{1044, 18, 15, 19, 19, 1},
						{1044, 18, 0, 0, 0, 1}};
		sortTableByEmpno(data, 6);
		//countEmployeeNumber(data, 6);
		makeTotalTable(data, 6);
		*/
		//String inputData = "371B4A4";
		//String inputData = "DC53126";
		/*
		String data[] = {"coffee", "eeFFCo", "amenr", "Ra Men", "CO FFE E",
				"coFfee", "c#off$ee", "cOe f%%&f*e", "bapgim", "rice", "RiCE", "*Ri&c@e",
				"gim $bap", "BAP@gim", "*G*imba p", "water", "FFCOEE", "WATER", "TERAW", "*tW$a ER#" };
		saleKind = makeNormalData(data, 20);
		saleKind = correctLetterOrder(saleKind, 20, products);
		System.out.println();
		makeDistinctedData(saleKind, 20);
		*/
/*		String inputData = "we1re3hewo34ddre67com21rue";
		String backup    = "1eare4hewor5dd8eamcome3rue";
		String[] network = {"wear", "ethe", "worl", "ddre", "amco", "metr", "ue"};

		String inputData1 = "ote12lkja23dhbgfl1ejkhf3uhe";
		String backup1    = "1eare4hewor5dd8eamcome3ruee";
		String[] network1 = {"otek", "plkj", "aopd", "hbgf", "lkej", "khft", "uhe"};
		
		String[] input = {"abc.txt", "abce", "abcd.txt", "acde.txt", "bxyz.txt", "bcde", "axbz.txt", "abcxd.txt", "acxy.txt", "axzy.txt"};
		String[] input2 = {"bcd.txt", "bce", "bcdx.txt", "axcd.txt", "axde", "axyz.txt", "cxyd.txt", "bcxa.txt", "bazy.txt"};
		List<String> list = Arrays.asList(input);
		getFirstCode(list);
		//getResultString(inputData);
		//getStickCnt(4);
		getFirstRecovery(inputData, backup);
*/		
		
		List<Car> list = new ArrayList<>();
		list.add(new Car("Citroen C1", "ZBC 164521", 4));
		list.add(new Car("Dodge Ram" , "KLM 845990", 2));
		Comparator<Car> carBrandComparatorLambda      =
		    (car1, car2) -> car1.brand.compareTo(car2.brand);

		Comparator<Car> carNumberPlatComparatorLambda =
		    (car1, car2) -> car1.numberPlate.compareTo(car2.numberPlate);

		Comparator<Car> carNoOfDoorsComparatorLambda  =
		    (car1, car2) -> car1.noOfDoors - car2.noOfDoors;

		Collections.sort(list, carBrandComparatorLambda);
		for(int i=0; i<list.size(); i++) {
			System.out.println("1. "+list.get(i).brand+", "+list.get(i).numberPlate+", "+list.get(i).noOfDoors);
		}
		Collections.sort(list, carNumberPlatComparatorLambda);
		for(int i=0; i<list.size(); i++) {
			System.out.println("2. "+list.get(i).brand+", "+list.get(i).numberPlate+", "+list.get(i).noOfDoors);
		}
		Collections.sort(list, carNoOfDoorsComparatorLambda);
		for(int i=0; i<list.size(); i++) {
			System.out.println("3. "+list.get(i).brand+", "+list.get(i).numberPlate+", "+list.get(i).noOfDoors);
		}
		

		Comparator<Car> carBrandComparator = new Comparator<Car>() {
		    @Override
		    public int compare(Car car1, Car car2) {
		        return car1.brand.compareTo(car2.brand);
		    }
		};

		Collections.sort(list, carBrandComparator);
	

		
//		getMoveInfo(11, 8);
		Integer[] num = {1,1,0,1};
		List<Integer> move = new ArrayList<>();
		move.add(1);
		move.add(4);
		move.add(1);
		getFirstNumber(move);
		
		List<Integer> move2 = Arrays.asList(num);
		getFirstNumber(move2);
		String[] strArray = {"Hadoop", "BigData", "Java", "Python"};
		List<String> list0 = Arrays.asList(strArray);	// 사이즈 고정
		List<String> list2 = new ArrayList<>();			// 사이즈 유동
		list2.add("J2EE");
		ArrayList<String> a = new ArrayList<String>(list2);
		int counter = 0;
		a.add("J2EE");
		
		System.out.println(list0);
		for(String s:a)
		{
			counter++;
			System.out.println(counter+s);
		}
		System.out.println("최종:"+counter);
		
		List<String> list3      = new ArrayList<>();

		list3.add("element 1");
		list3.add("element 2");
		list3.add("element 3");
		list3.add("element 4");

		//String[] objects1 = list3.toArray(new String[0]);
		String[] objects1 = list3.toArray(new String[list3.size()]);
		counter=0;
		for(Object s:objects1)
		{
			counter++;
			System.out.println(counter+(String)s);
		}	
		
		/*
		int[][] matrix = {
				{5,7,-5,100,73},
				{35,23,4,190,33},
				{49,85,662,39,81},
				{124,-59,86,46,52},
				{27,7,8,33,-56}
		};
		int i=0, j=0, max=0, m=0, n=0, sum=0, size=0;
		for(i=0; i<matrix.length; i++) {
			for(j=0; j<matrix[0].length; j++) {
				if(matrix[i][j] < 0) {
					matrix[i][j] = 0;
				}
				if(matrix[i][j] > 100) {
					matrix[i][j] = matrix[i][j]%100;
				}
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		for(size=1; size<=matrix.length; size++) {
			for(i=0; i<matrix.length-(size-1); i++) {
				for(j=0; j<matrix[0].length-(size-1); j++) {
					sum = 0;
					for(m=i; m<i+size; m++) {
						for(n=j; n<j+size; n++) {
							sum = sum + matrix[m][n];
						}
					}
					if(sum > max) {
						max = sum;
						System.out.println("size:"+size+", i:"+i+", j:"+j+", m:"+m+", n:"+n+", max:"+max);
					}
				}
			}
		}
		System.out.println(max);
		*/
	}
	public static List<String> makeSuffix(String str) {
		List<String> list = new ArrayList<>();
		int i=0;
		for(i=0; i<str.length(); i++) {
			list.add(str.substring(i));
		}
		return list;
	}
	
	public static List<Integer> countSimilarity(String original, List<String> list) {
		List<Integer> result = new ArrayList<>();
		int i=0, count=0, k=0;
		for(k=0; k<list.size(); k++) {
			count = 0;
			for(i=0; i<list.get(k).length(); i++) {
				if(original.charAt(i) == list.get(k).charAt(i)) {
					count++;
				}
			}
			result.add(count);
			System.out.println(count);
		}
		return result;
	}
	public static List<String> getCosmeticsList(List<String> inputData, String name, String term) {
		List<String> cosmeticsList;
		cosmeticsList = new ArrayList<String>();
//		List<String> tmpCosmeticsList = new ArrayList<String>();
		int i = 0;
		int start = Integer.parseInt(term.substring(0,term.indexOf("-")));
		int end = Integer.parseInt(term.substring(term.indexOf("-")+1));
		for(i=0; i<inputData.size(); i++) {
			String[] strArr = inputData.get(i).split(",");
			if(Integer.parseInt(strArr[3]) >= start && Integer.parseInt(strArr[3]) <= end &&
					strArr[1].equals(name) == true) {
				if(!cosmeticsList.contains(strArr[2])) {
					cosmeticsList.add(strArr[2]);
//					tmpCosmeticsList.add(inputData.get(i));
					System.out.println(strArr[0]+" "+strArr[1]+" "+strArr[2]+" "+strArr[3]+" "+strArr[4]);
				}
			}
		}
		return cosmeticsList;
	}
	
	public static int getPrice(List<String> inputData, String sellerId, String periodOfSale) {
		int i = 0, sum=0;
		int start = Integer.parseInt(periodOfSale.substring(0,periodOfSale.indexOf("-")));
		int end = Integer.parseInt(periodOfSale.substring(periodOfSale.indexOf("-")+1));
		for(i=0; i<inputData.size(); i++) {
			String[] strArr = inputData.get(i).split(",");
			if(Integer.parseInt(strArr[3]) >= start && Integer.parseInt(strArr[3]) <= end &&
					strArr[0].equals(sellerId) == true) 
			{
				sum += Integer.parseInt(strArr[4]);
				System.out.println(sum+" "+strArr[0]+" "+strArr[1]+" "+strArr[2]+" "+strArr[3]+" "+strArr[4]);
				
			}
		}
		return sum;
	}
	public static int[][] sortTableByEmpno(int[][] otTable, int row) {
		int retTable[][] = new int[128][6];
		int tmpRow[] = new int[6];
		int time1, time2;
		for(int i=0; i<otTable.length-1; i++) {
			for(int j=i+1; j<otTable.length; j++) {
				if(otTable[i][0] > otTable[j][0]) {
					tmpRow = otTable[i];
					otTable[i] = otTable[j];
					otTable[j] = tmpRow;
				} else if(otTable[i][0] == otTable[j][0]) {
					time1 = otTable[i][1] * 60 + otTable[i][2];
					time2 = otTable[j][1] * 60 + otTable[j][2];
					if(time1 > time2) {
						tmpRow = otTable[i];
						otTable[i] = otTable[j];
						otTable[j] = tmpRow;						
					}
				}
				
			}
			
		}
		for(int i=0; i<otTable.length; i++) {
			System.out.println(otTable[i][0]+" "+otTable[i][1]+" "+otTable[i][2]+" "+otTable[i][3]+" "+otTable[i][4]+" "+otTable[i][5]);
		}
		retTable = otTable;
		return retTable;
	}
	public static int countEmployeeNumber(int[][] otTable, int row) {
		int empNumber = 0;
		int time = 0;
		int[] empList = new int[6];
		int index = 0;
		for(int i=0; i<otTable.length; i++) {
			time = otTable[i][3] * 60 + otTable[i][4];
			if(time != 0) {
				empList[index++] = otTable[i][0];
			}
		}
		int[] empSet = new int[6];
		int idx2 = 0;
		empSet[idx2] = empList[0];
		for(int i=1; i<index; i++) {
			if(empList[i] != empSet[idx2]) {
				idx2++;
				empSet[idx2] = empList[i];
			}
		}
		for(int i=0; i<idx2+1; i++) {
			System.out.println("직원번호:"+empSet[i]);
		}
		empNumber = idx2+1;
		System.out.println("직원수:"+empNumber);
		return empNumber;
	}
	public static int[][] makeTotalTable(int[][] otTable, int row) {
		int retTable[][] = new int[128][2];
		int stime, etime, tripYN;
		int i, j, idx=0, newRowNum=0;
		int newOtTable[][] = new int[128][6];
		int tmpTotalTable[][] = new int[128][4];
		for(i=0; i<otTable.length; i++) {
			etime = otTable[i][3] * 60 + otTable[i][4];
			if(etime != 0) {
				newOtTable[newRowNum] = otTable[i];
				newRowNum++;
			}
		}

		stime = newOtTable[0][1] * 60 + newOtTable[0][2];
		etime = newOtTable[0][3] * 60 + newOtTable[0][4];
		
		tmpTotalTable[idx][0] = newOtTable[0][0];
		tmpTotalTable[idx][1] = stime;
		tmpTotalTable[idx][2] = etime;
		tmpTotalTable[idx][3] = newOtTable[0][5];
		
		for(i=0; i<newRowNum; i++) {
			System.out.println("0."+newOtTable[i][0]+" "+newOtTable[i][1]+" "+newOtTable[i][2]+" "+newOtTable[i][3]);
		}
		for(i=1; i<newRowNum; i++) {
			if(tmpTotalTable[idx][0] != newOtTable[i][0]) { 
				idx++;
				stime = newOtTable[i][1] * 60 + newOtTable[i][2];
				etime = newOtTable[i][3] * 60 + newOtTable[i][4];
				
				tmpTotalTable[idx][0] = newOtTable[i][0];
				tmpTotalTable[idx][1] = stime;
				tmpTotalTable[idx][2] = etime;
				tmpTotalTable[idx][3] = newOtTable[i][5];
				System.out.println("1."+idx+" "+i+" "+tmpTotalTable[idx][0]+" "+tmpTotalTable[idx][1]+" "+tmpTotalTable[idx][2]+" "+tmpTotalTable[idx][3]);
			} else if(tmpTotalTable[idx][0] == newOtTable[i][0]) { 
				stime = newOtTable[i][1] * 60 + newOtTable[i][2];
				etime = newOtTable[i][3] * 60 + newOtTable[i][4];
				tripYN  = newOtTable[i][5];
				if(stime < tmpTotalTable[idx][1]) {
					tmpTotalTable[idx][1] = stime;
				}
				if(etime > tmpTotalTable[idx][2]) {
					tmpTotalTable[idx][2] = etime;
				}
				if(tripYN > tmpTotalTable[idx][3]) {
					tmpTotalTable[idx][3] = tripYN;
				}
				System.out.println("2."+idx+" "+i+" "+tmpTotalTable[idx][0]+" "+tmpTotalTable[idx][1]+" "+tmpTotalTable[idx][2]+" "+tmpTotalTable[idx][3]);
			}
		}
		idx++;
		int totalValue;
		for(i=0; i<idx; i++) {
			retTable[i][0] = tmpTotalTable[i][0];
			totalValue = tmpTotalTable[i][2] - tmpTotalTable[i][1];
			if(tmpTotalTable[i][3] == 1) {
				totalValue = (int)(totalValue * 1.5);
			}
			retTable[i][1] = totalValue;
			System.out.println(retTable[i][0]+" "+retTable[i][1]);
		}
		return retTable;
	}
	public static String[] makeNormalData(String[] saleKind, int saleNumber) {
		String[] retData = new String[500];
		char[] newKind = new char[20];
		int index = 0;
		for(int i=0; i<saleNumber; i++) {
			index = 0;
			for(int j=0; j<saleKind[i].length(); j++) {
				if((saleKind[i].charAt(j) >= 'A' && saleKind[i].charAt(j) <= 'Z') || 
						(saleKind[i].charAt(j) >= 'a' && saleKind[i].charAt(j) <= 'z')) 
				{
					newKind[index] = saleKind[i].charAt(j);
					if(saleKind[i].charAt(j) >= 'A' && saleKind[i].charAt(j) <= 'Z') {
						newKind[index] += ('a' - 'A'); 
					}
					index++;
				}
//				System.out.print(newKind[index]);
				
			}
			retData[i] = new String(newKind, 0, index).trim();
			System.out.print(retData[i]+" ");
		}
		return retData;
	}
	

	public static String[] correctLetterOrder(String[] saleKind, int saleNumber, String[] products) {
		String[] retData = new String[500];
		String[] sortedProducts = new String[13];
		int i=0, n=0;
		char chTemp;
		System.out.println();
		for(i=0; i<products.length; i++) {
			sortedProducts[i] = new String(products[i]);
		}
		for(i=0; i<sortedProducts.length; i++) {
			char[] chPro = sortedProducts[i].toCharArray();
			for(int k=0; k<chPro.length-1; k++) {
				for(int j=k+1; j<chPro.length; j++) {
					if(chPro[k] > chPro[j]) {
						chTemp = chPro[k];
						chPro[k] = chPro[j];
						chPro[j] = chTemp;
					}
				}
			}
			//sortedProducts[i] = Arrays.toString(chPro);
			sortedProducts[i] = new String(chPro, 0, chPro.length); //.trim();
		}
		
		for(i=0; i<saleNumber; i++) {
			char[] chPro = saleKind[i].toCharArray();
			for(int k=0; k<chPro.length-1; k++) {
				for(int j=k+1; j<chPro.length; j++) {
					if(chPro[k] > chPro[j]) {
						chTemp = chPro[k];
						chPro[k] = chPro[j];
						chPro[j] = chTemp;
					}
				}
			}
			String proImsi = new String(chPro, 0, chPro.length); //.trim();
			//String proImsi = Arrays.toString(chPro);
			for(n=0; n<sortedProducts.length; n++) {
				if(proImsi.equals(sortedProducts[n]) == true) {
					retData[i] = products[n];
					System.out.print(retData[i]+" ");
					break;
				}
			}
			
		}
		return retData;
	}
	
	public static String[] makeDistinctedData(String[] saleKind, int saleNumber) {
		String[] retData = new String[500];
		char found = 'N';
		int i=0, j=0, index=0, sw=0;
		char chFirst, chSecond;
		for(i=0; i<saleNumber; i++) {
			found = 'N';
			for(j=0; j<index; j++) {
				if(saleKind[i].equals(retData[j]) == true) {
					found = 'Y';
					break;
				}
			}
			if(found == 'N') {
				retData[index] = saleKind[i];
				System.out.print(retData[index]+" ");
				index++;
			}
		}
		for(j=0; j<index-1; j++) {
//			sw = 0;
			for(i=0; i<index-1-j; i++) {
				chFirst = retData[i].charAt(1);
				chSecond = retData[i+1].charAt(1);
				String tmpStr;
				if(chFirst > chSecond) {
					tmpStr = retData[i];
					retData[i] = retData[i+1];
					retData[i+1] = tmpStr;
//					sw = 1;
				} else if(chFirst == chSecond) {
					chFirst = retData[i].charAt(0);
					chSecond = retData[i+1].charAt(0);
					if(chFirst > chSecond) {
						tmpStr = retData[i];
						retData[i] = retData[i+1];
						retData[i+1] = tmpStr;
//						sw = 1;
					}
				}
			}
			if(sw == 0) {
//				break;
			}
		}
		System.out.println();
		for(j=0; j<index; j++) {
			System.out.print(retData[j]+" ");
		}
		return retData;
	}
	public static List<String> getFirstCode(List<String> inputData) {
		List<String> list = new ArrayList<>();
		for(int i=0; i<inputData.size(); i++) {
			if(inputData.get(i).contains(".")) {
				String[] str = inputData.get(i).split("\\.");
				if(str[0].contains("a") && str[0].contains("x")) {
					for(int j=0; j<str[0].length()-1; j++) {
						if(str[0].charAt(j) == 'a' && str[0].charAt(j+1) == 'x') {
							System.out.println("ax: "+inputData.get(i));
							list.add(inputData.get(i));
						} else if(str[0].charAt(j) == 'a' && str[0].charAt(j+1) == 'b') {
							System.out.println("ab: "+inputData.get(i));
							list.add(inputData.get(i));
						} else if(str[0].charAt(j) == 'x' && str[0].charAt(j+1) == 'y') {
							System.out.println("xy: "+inputData.get(i));
							list.add(inputData.get(i));
						}
					}
				} else if(str[0].contains("a") || str[0].contains("x")) {
					for(int j=0; j<str[0].length()-1; j++) {
						if(str[0].charAt(j) == 'a' && str[0].charAt(j+1) == 'b') {
							System.out.println("ab: "+inputData.get(i));
							list.add(inputData.get(i));
						} else if(str[0].charAt(j) == 'x' && str[0].charAt(j+1) == 'y') {
							System.out.println("xy: "+inputData.get(i));
							list.add(inputData.get(i));
						}
					}
				} else {
					System.out.println("!a!x: "+inputData.get(i));
					list.add(inputData.get(i));
				}
				
					
			}
		}
		System.out.println(list);
		return list;
	}
	public static String getFirstRecovery(String inputData, String backup) {
		String strResult = "";
		char[] chInput = inputData.toCharArray();
		char[] chBackup = backup.toCharArray();
		for(int i=0; i<inputData.length(); i++) {
			if((chInput[i] >= '0' && chInput[i] <= '9') &&
					!(chBackup[i] >= '0' && chBackup[i] <= '9')) {
				strResult += String.valueOf(chBackup[i]);
			} else if((chInput[i] >= '0' && chInput[i] <= '9') &&
					(chBackup[i] >= '0' && chBackup[i] <= '9')) {
				strResult += String.valueOf(chInput[i]);
			} else {
				strResult += String.valueOf(chInput[i]);
			}
		}
		System.out.println(strResult);
		return strResult;
	}
/*	
	public static String getSecondRecovery(String firstRecovery, String[] netWork) {
		
	}
*/	
	public static int getStickCnt(int floor) {
		int triangleCnt = 0, sameStick=0;
		for(int i=1; i<=floor; i++) {
			triangleCnt += (3+(2*i-2)*2);
			if(i!=floor)
				sameStick += i;
		}
		System.out.println(triangleCnt+", "+sameStick);
		return triangleCnt - sameStick;
	}
	public static String getResultString(String inputData) {
		String strResult = "";
		String strTmp = "";
		int n = 9, sum=0;
		char[] chStr = inputData.toCharArray();
		for(int i=0; i<inputData.length(); i++) {
			if(chStr[i] >= 'A' && chStr[i] <= 'Z') {
				strResult += String.valueOf(chStr[i]);
			} else {
				strTmp += String.valueOf(chStr[i]);
				sum = sum + Integer.parseInt(String.valueOf(chStr[i])) * n;
				n--;
			}
		}

		sum = sum % 5;
		strResult += strTmp;
		strResult += sum;
		System.out.println(strResult);
		return strResult;
	}
	public static List<Integer> getMoveInfo(int numberOfBalloon, int numberOfMove) {
		List<Integer> moveInfo = new ArrayList<>();
		int index=1, i=0, tmpNumberOfMove=0;
		moveInfo.add(numberOfBalloon);
		while(true) {
			if(moveInfo.get(index-1) > 1) {
				tmpNumberOfMove++;
				moveInfo.set(index-1, moveInfo.get(index-1)-2);
				if(index == moveInfo.size()-1) {
					moveInfo.set(index, moveInfo.get(index)+1);
				} else {
					moveInfo.add(index, 1);
				}	
				for(i=0; i<=index; i++)
				{
					System.out.print(moveInfo.get(i)+" ");
				}
				if(tmpNumberOfMove == numberOfMove) {
					System.out.println();
					System.out.println("AA");
					break;
				}
				if(moveInfo.get(index-1)<=1 && moveInfo.get(index)<=1) {
					System.out.println("BB");
					break;
				}
			}
			else {
				System.out.println("KK");
				index++;
			}
			System.out.println();
		}
		
		return moveInfo;
	}
	
	public static int getFirstNumber(List<Integer> moveList) {
		int index = moveList.size()-1;
		while(true) {
			if(moveList.get(index)>0) {
				moveList.set(index, moveList.get(index)-1);
				moveList.set(index-1, moveList.get(index-1)+2);
				
				for(int i=0; i<=index; i++)
				{
					System.out.print(moveList.get(i)+" ");
				}
				System.out.println();
			} else {
				index--;
			}
			if(index <= 0) {
				System.out.println("처음숫자:"+moveList.get(0));
				return moveList.get(0);
			}
		}
	}
}
