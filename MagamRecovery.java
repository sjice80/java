import java.io.*;
import java.util.*;

class MagamData {
	String time;
	String type;
	String yn;
	
	public MagamData(String time, String type, String yn) {
		this.time = time;
		this.type = type;
		this.yn = yn;
	}
	
	public String getTime() {
		String[] strArr = this.time.split("T");
		return strArr[1];
	}
	public String toString() {
		String s;
		s = this.time+"#"+this.type+"#"+this.yn;
		return s;
	}
}
public class MagamRecovery {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String line = "";
		int oldCnt = 0, typeCnt = 0, i=0, k=0, sameDate = 1, offset=0, five_set=0, n=0, idx=0;
		
		File file = new File(".\\MAGAMFILE_A.TXT");
		Scanner sc = new Scanner(file);
		MagamData[] mg = new MagamData[100];
		MagamData[] newMG = new MagamData[100];
		List<MagamData> list = new ArrayList<>();
		ArrayList<String> oldList = new ArrayList<String>();
		ArrayList<String> newList = new ArrayList<String>();
		Integer[] existList = new Integer[5];
		for(n=0; n<5; n++) {
			existList[n] = 0;
		}

		while(sc.hasNextLine()) {
			line = sc.nextLine();
			oldList.add(line);
			String[] strArr = line.split("#");
			mg[oldCnt] = new MagamData(strArr[0], strArr[1], strArr[2]);
			oldCnt++;
		}
		for(i=0; i<oldCnt; i++) {
			for(k=offset; k<=oldCnt-1; k++) {
				if(k == oldCnt-1) {
					idx = k;
				}
				else
				{
					idx = k+1;
				}
				if(mg[offset].time.equals(mg[idx].time) == true) {
					if(k != oldCnt-1)
						sameDate++;
					if(mg[k].type.equals("AA") == true || mg[idx].type.equals("AA") == true) {
						existList[0] = 1;
					}
					if(mg[k].type.equals("BB") == true || mg[idx].type.equals("BB") == true) {
						existList[1] = 1;
					}
					if(mg[k].type.equals("CC") == true || mg[idx].type.equals("CC") == true) {
						existList[2] = 1;
					}
					if(mg[k].type.equals("DD") == true || mg[idx].type.equals("DD") == true) {
						existList[3] = 1;
					}
					if(mg[k].type.equals("EE") == true || mg[idx].type.equals("EE") == true) {
						existList[4] = 1;
					}
				} else {
					break;
				}
			}
			if (offset == oldCnt) {	
				break;
			}
			typeCnt = 0;
			for(n=offset; n<offset+sameDate; n++) {
				newList.add(five_set*5+typeCnt, oldList.get(n));
				String[] strNew = oldList.get(n).split("#");
				newMG[five_set*5+typeCnt] = new MagamData(strNew[0], strNew[1], strNew[2]);
				list.add(newMG[five_set*5+typeCnt]);
				typeCnt++;
			}

			String temp = "";
			
			for(n=offset+sameDate; n<offset+5; n++) {
				temp = mg[offset].time + "#";
				if(existList[0] == 0) {		
					temp += "AA#Y";
					System.out.println(temp);
					newList.add(five_set*5+typeCnt, temp);
					newMG[five_set*5+typeCnt] = new MagamData(mg[offset].time, "AA", "Y");
					list.add(newMG[five_set*5+typeCnt]);
					existList[0] = 1;
					typeCnt++;
					continue;
				}
				else if(existList[1] == 0) {
					temp += "BB#Y";
					System.out.println(temp);
					newList.add(five_set*5+typeCnt, temp);
					newMG[five_set*5+typeCnt] = new MagamData(mg[offset].time, "BB", "Y");
					list.add(newMG[five_set*5+typeCnt]);
					existList[1] = 1;
					typeCnt++;
					continue;
				}
				else if(existList[2] == 0) {
					temp += "CC#Y";
					System.out.println(temp);
					newList.add(five_set*5+typeCnt, temp);
					newMG[five_set*5+typeCnt] = new MagamData(mg[offset].time, "CC", "Y");
					list.add(newMG[five_set*5+typeCnt]);
					existList[2] = 1;
					typeCnt++;
					continue;
				}
				else if(existList[3] == 0) {
					temp += "DD#Y";
					System.out.println(temp);
					newList.add(five_set*5+typeCnt, temp);
					newMG[five_set*5+typeCnt] = new MagamData(mg[offset].time, "DD", "Y");
					list.add(newMG[five_set*5+typeCnt]);
					existList[3] = 1;
					typeCnt++;
					continue;
				}
				else if(existList[4] == 0) {
					temp += "EE#Y";
					System.out.println(temp);
					newList.add(five_set*5+typeCnt, temp);
					newMG[five_set*5+typeCnt] = new MagamData(mg[offset].time, "EE", "Y");
					list.add(newMG[five_set*5+typeCnt]);
					existList[4] = 1;
					typeCnt++;
					continue;
				}
				
			}
			
//			for(n=five_set*5; n<five_set*5+5; n++) {
//				System.out.println(newList.get(n));
//			}
			five_set++;

			offset = offset + sameDate;
			sameDate = 1;
			for(n=0; n<5; n++) {
				existList[n] = 0;
			}
		}

		FileWriter fw1 = new FileWriter(".\\NEW_MAGAM_A1.TXT");
		BufferedWriter bw1 = new BufferedWriter(fw1);
		for(n=0; n<newList.size(); n++) {
			bw1.write(newList.get(n));
			bw1.newLine();
		}
		bw1.close();
		
		list.sort((o1, o2)-> o1.getTime().compareTo(o2.getTime())); //시간 정렬
		for(int s=0; s<list.size(); s++) {
			newList.set(s, list.get(s).toString());
//			System.out.println(list.get(s).toString());
		}

		FileWriter fw2 = new FileWriter(".\\NEW_MAGAM_A2.TXT");
		BufferedWriter bw2 = new BufferedWriter(fw2);
		for(n=0; n<newList.size(); n++) {
			bw2.write(newList.get(n));
			bw2.newLine();
		}
		bw2.close();
		
		sc.close();
	}
}
