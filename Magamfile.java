package magamfile;

import java.io.*;
import java.util.*;

public class Magamfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*
		int v1 = 1;
		Int v2 = new Int(2);
		Int v3 = new Int(3);
		
		doubleThem(v1, v2, v3);
		System.out.println("main first:"+v1+", second:"+v2.getInt()+", third:"+v3.getInt());
		*/
		/*
		File file = new File(".\\INPUT_EMAIL.TXT");
		Scanner sc = new Scanner(file);
		String line = "";
		String[] id = new String[10];
		String[] id_final = new String[10];
		String[] email_main = new String[20];
		int id_cnt = 0, final_cnt = 0, i = 0, k = 0, email_cnt=0;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			StringTokenizer s = new StringTokenizer(line, "@");
			id[id_cnt] = s.nextToken();
			id_cnt++;
			StringTokenizer s1 = new StringTokenizer(s.nextToken(), ".");
			while(s1.hasMoreTokens()) {
				email_main[email_cnt] = s1.nextToken();
				System.out.print(email_main[email_cnt]+" ");
				email_cnt++;
			}
			System.out.println(email_cnt);
		}
		for(i=0; i<id_cnt; i++) {
			for(k=0; k<final_cnt; k++) {
				if(id[i].equals(id_final[k]) == true) {
					break;
				}
			}
			if(k==final_cnt) {
				id_final[final_cnt] = id[i];
				final_cnt++;
			}
			System.out.println(id[i]);
		}
		System.out.println();
		for(k=0; k<final_cnt; k++) {
			System.out.println(id_final[k]);
		}
		*/
/*
		FileInputStream is = new FileInputStream(".\\INPUT_EMAIL.TXT");
		int i=0;
		String input = "";
		int number=0;
		try {
			while((i=is.read()) != -1) {
				input = input + (char)i;
			}
			System.out.println("File's input:"+input);
			StringTokenizer s = new StringTokenizer(input);
			while(s.hasMoreTokens()) {
				number++;
				System.out.println(number+": "+s.nextToken(","));
			}
		} catch(FileNotFoundException e) {
			System.out.println("The file doesn't exist.");
		}
*/		
		
		String line = "";
		File file = new File(".\\MAGAMFILE_A.TXT");
		Scanner sc = new Scanner(file);
		MagamData[] mg = new MagamData[100];
		int cnt=0, daily_cnt=0, offset=0, i=0, k=0, m=0, six_set=0;
		ArrayList<String> oldList = new ArrayList<String>();
		ArrayList<String> newList = new ArrayList<String>();
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			oldList.add(line);
			String[] strArr = line.split("#");
			mg[cnt] = new MagamData(strArr[0], strArr[1], strArr[2], strArr[3]);
			cnt++;
		}
		System.out.println(cnt);
		daily_cnt = 1;

		for(i=0; i<cnt; i++)
		{
			for(k=offset; k<cnt-1; k++) {
				if(mg[offset].time.equals(mg[k+1].time) == true) {
					daily_cnt++;
				} else {
//						System.out.println("대표 갯수 total:"+daily_cnt);
					break;
				}
			}
//				System.out.println("offset:"+offset+", 마감시간:"+mg[offset].time+", 생성여부:"+mg[offset].yn+", 타입:"+mg[offset].type+", 메시지:"+mg[offset].msg);				

			if(offset == cnt) {
//					offset = offset - total;					
//					System.out.println("종료 대표 갯수 total:"+total);
//					System.out.println("offset:"+offset+", 마감시간:"+mg[offset].time+", 생성여부:"+mg[offset].yn+", 타입:"+mg[offset].type+", 메시지:"+mg[offset].msg);
//					System.out.println("종료"+k+offset);
				break;
			}
			for(m=6*six_set; m<6*six_set+6; m++) {
				newList.add(m, oldList.get(offset));
			}
			six_set++;

			offset = offset + daily_cnt;

//				System.out.println();
			daily_cnt = 1;
		}

		for(int n=0; n<newList.size(); n++) {
			System.out.println(newList.get(n));
		}
		
		FileWriter fw = new FileWriter(".\\NEW_MAGAM.TXT");
		BufferedWriter bw = new BufferedWriter(fw);
		for(int n=0; n<newList.size(); n++) {
			bw.write(newList.get(n));
			bw.newLine();
		}
		sc.close();
		bw.close();
		
	}
	private static void doubleThem(int first, Int second, Int third) {
		first = first * 2;
		second.setInt(second.getInt() * 2);
		third = new Int(third.getInt() * 2);
		System.out.println("함수 안 first:"+first+", second:"+second.getInt()+", third:"+third.getInt());
	}
}

class MagamData /*implements Comparable<MagamData>*/ {
	// 인스턴스 변수
	String time;
	String yn;
	String type;
	String msg;
	// 생성자 : 인스턴스 변수 초기화
	public MagamData(String time, String yn, String type, String msg) {
		this.time = time;
		this.yn = yn;
		this.type = type;
		this.msg = msg;
	}
}

class Int {
	private int value;
	// constructor
	public Int(int value) {
		this.value = value;
	}
	
	public void setInt(int value) {
		this.value = value;
	}
	
	public int getInt() {
		return this.value;
	}
	
}
