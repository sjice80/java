package logfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Log {
	String time;
	String type;
	String msg;

	public Log(String t, String ty, String m) {
		time = t;
		type = ty;
		msg = m;
	}
}

class logType {
	String type;
	int cnt;
	
	public logType(String t, int c) {
		type = t;
		cnt = c;
	}
}

class Card implements Comparable<Card> {
	int num;
	int cnt;
	int check;
	
	public Card(int num, int cnt, int check) {
		this.num = num;
		this.cnt = cnt;
		this.check = check;
	}
	
	public void addCnt() {
		this.cnt += 1;
	}
	// cnt 내림차순, num 오름차순
	public int compareTo(Card c) {
		if(this.cnt < c.cnt)
			return 1;
		else if(this.cnt > c.cnt)
			return -1;
		else
			return this.num - c.num;
	}
}
class Student {
	private Scanner sc;
	private int[] sub_score;
	private int tot;
	private double avg;
	
	public int getTot() { return this.tot; }
	public double getAvg() { return this.avg; }
	
	public Student(int subCnt) {
		sc = new Scanner(System.in);
		sub_score = new int[subCnt];
		tot = 0;
		avg = 0.0;
	}
	
	public void inputScore() {
		for(int i=0; i<sub_score.length; i++) {
			System.out.println((i+1)+"번째 과목 점수 : ");
			sub_score[i] = sc.nextInt();
		}
	}
	
	public void calcTotAvg() {
		for(int i=0; i<sub_score.length; i++) {
			tot += sub_score[i];
		}
		avg = (double)tot / (double)sub_score.length;
		System.out.println("총점 : "+tot+", 평균 : "+avg);
	}
}

class SoccerPlayer implements Comparable<SoccerPlayer> {
	private String name;
	private String position;
	private int age;
	
	public SoccerPlayer(String name, String position, int age) {
		this.name = name;
		this.position = position;
		this.age = age;
	}
	
	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }
	public void setPosition(String position) { this.position = position; }
	public String getPosition() { return this.position; }
	public void setAgee(int age) { this.age = age; }
	public int getAge() { return this.age; }
	
	public int compareTo(SoccerPlayer player) {
		return this.name.compareTo(player.getName());
	}
	
}
public class Logfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		ArrayList<Card> table = new ArrayList<Card>();
		for(int i=0; i<total; i++) {
			Card c = new Card(sc.nextInt(), 0, 0);
			table.add(c);		
		}
		for(int i=0; i<total-1; i++) {
			for(int j=i; j<total; j++) {
				if(table.get(i).num == table.get(j).num && table.get(j).check != 1) {
					table.get(i).addCnt();
					table.get(i).check = 1;
					table.get(j).check = 1;
				}
			}
		}
		for(int i=0; i<total; i++) {
			System.out.println(table.get(i).num+" "+table.get(i).cnt+" "+table.get(i).check);
		}
		System.out.println("정렬 후");
		Collections.sort(table);
		for(int i=0; i<total; i++) {
			System.out.println(table.get(i).num+" "+table.get(i).cnt+" "+table.get(i).check);
		}		
		System.out.println("최종 답:"+table.get(0).num);
		sc.close();
		/*
		String[] sports = new String[] {"Soccer", "Tennis", "Baseball", "Basketball", "Football", "Ski", "Hockey", "Aerobics"};
		String[] names = new String[] {"박보검", "김우빈", "장동건", "하정우", "송중기", "송승헌", "강동원", "박서준", "김수현"};
		
		Arrays.sort(sports);
		Arrays.sort(names);
		
		for(int i=0; i<sports.length; i++) {
			System.out.print(sports[i]+" ");
		}
		
		System.out.println();
		
		for(int i=0; i<names.length; i++) {
			System.out.print(names[i]+" ");
		}		
		
		System.out.println();
		
		ArrayList<String> sportsList = new ArrayList<String>();
		sportsList.add("Soccer");
		sportsList.add("Tennis");
		sportsList.add("Baseball");
		sportsList.add("Basketball");
		sportsList.add("Football");
		sportsList.add("Ski");
		sportsList.add("Hockey");
		sportsList.add("Aerobics");
		
		Collections.sort(sportsList);
		
		for(int i=0; i<sportsList.size(); i++) {
			System.out.print(sportsList.get(i)+" ");
		}
		
		System.out.println();
		
		ArrayList<SoccerPlayer> playerList = new ArrayList<SoccerPlayer>();
		SoccerPlayer player1 = new SoccerPlayer("호날두", "공격수", 22);
		SoccerPlayer player2 = new SoccerPlayer("메시", "공격수", 25);
		SoccerPlayer player3 = new SoccerPlayer("기성용", "미드필더", 23);
		SoccerPlayer player4 = new SoccerPlayer("이승우", "공격수", 21);
		SoccerPlayer player5 = new SoccerPlayer("박지성", "공격수", 29);
		SoccerPlayer player6 = new SoccerPlayer("줄리탄", "미드필더", 28);
		
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		playerList.add(player4);
		playerList.add(player5);
		playerList.add(player6);
		
		Collections.sort(playerList);
		
		for(int i=0; i<playerList.size(); i++) {
			System.out.println(playerList.get(i).getName()+", "+playerList.get(i).getPosition()+", "+playerList.get(i).getAge());
		}
		
		System.out.println();
		
		Collections.sort(playerList, new Comparator<SoccerPlayer>() {
			public int compare(SoccerPlayer p1, SoccerPlayer p2) {
				if(p1.getAge() > p2.getAge())
					return 1;
				else if(p1.getAge() < p2.getAge())
					return -1;
				else
					return 0;
			}
		});
		
		for(int i=0; i<playerList.size(); i++) {
			System.out.println(playerList.get(i).getName()+", "+playerList.get(i).getPosition()+", "+playerList.get(i).getAge());
		}
		
		System.out.println();
		*/
//		Scanner sc = new Scanner(System.in);
		/*
		Student[] stdnt;
		int subCnt = 0;
		
		System.out.print("학생 수를 입력하세요 : ");
		stdnt = new Student[sc.nextInt()];
		
		System.out.print("과목 수를 입력하세요: ");
		subCnt = sc.nextInt();
		
		for(int i=0; i<stdnt.length; i++) {
			stdnt[i] = new Student(subCnt);
		}
		
		for(int i=0; i<stdnt.length; i++) {
			System.out.println((i+1)+"번째 학생 : ");
			stdnt[i].inputScore();
			stdnt[i].calcTotAvg();
			stdnt[i].getTot();
			stdnt[i].getAvg();
		}
		*/
		/*
		String line = "";
		File file = new File(".\\LOGFILE_A.TXT");
		Scanner sc = new Scanner(file);
		Log[] log = new Log[100];
		logType[] lt = new logType[50];
		int cnt = 0, type_cnt=0, i=0;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			String[] strArr = line.split("#");
			log[cnt] = new Log(strArr[0], strArr[1], strArr[2]);
			for(i=0; i<type_cnt; i++) {
				if(lt[i].type.equals(strArr[1]) == true)
				{
					lt[i].cnt++;
//					System.out.println("1.타입:"+lt[i].type+", 갯수:"+lt[i].cnt);
					break;
				}
			}
			if(i == type_cnt) {
				lt[type_cnt] = new logType("", 0);
//				if(lt[type_cnt].type.equals(strArr[1]) == false)
				{
					lt[type_cnt].type = strArr[1];
					lt[type_cnt].cnt++;
					type_cnt++;
//					System.out.println("2.타입:"+lt[i].type+", 갯수:"+lt[i].cnt);
				}
				
//				System.out.println(type_cnt);
			}
			cnt++;
//			System.out.println(line);
			
		}
		sc.close();
		*/
//		System.out.println("라인수:"+cnt);
/*
		for(int i=0; i<log.length; i++)
		{
			line = sc.nextLine();
			String[] strArr = line.split("#");
			log[i] = new Log(strArr[0], strArr[1], strArr[2]);
		}

		for(int j=0; j<cnt; j++) {
			System.out.println("시간:"+log[j].time+", 타입:"+log[j].type+", 메시지:"+log[j].msg);
		}
*/
		/*
		for(int j=0; j<type_cnt; j++) {
			System.out.println("타입:"+lt[j].type+", 갯수:"+lt[j].cnt);
		}
		*/
		/*
		System.out.println("<텍스트 파일 불러오기>\n");
		FileReader fr = new FileReader(".\\dic.txt");
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> arr = new ArrayList<String>();
		String line;
		while((line = br.readLine())!= null) {
			arr.add(line);
		}
		System.out.println("<오름차순 정렬 전>\n");
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
			CntChar(arr.get(i));
		}
		System.out.println("<정렬이 완료되었습니다.>\n");
		arr = AscedingOrder(arr);
		System.out.println("<오름차순 정렬 후>\n");
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		System.out.println("<텍스트 파일 내보내기>\n");
		FileWriter fw = new FileWriter(".\\output.txt");
		BufferedWriter bw = new BufferedWriter(fw);	
		for(int i=0; i<arr.size(); i++) {
			bw.write(arr.get(i));
			bw.newLine();
		}
		br.close();
		bw.close();
		fr.close();
		fw.close();
		*/
		/*
		try {
			File file = new File(".\\LOGFILE_A.TXT");
			Scanner scan = new Scanner(file);
			String[] parse = new String[3*18];
			int i=0;
			int line=0;
			while(scan.hasNextLine()) {
				parse[i] = scan.useDelimiter("#").next();
				//System.out.println(scan.nextLine());
				System.out.println(parse[i]);
				i++;
				line++;
			}
			scan.close();
			System.out.println(line);

			FileReader filereader = new FileReader(file);
			int singleCh = 0;
			while((singleCh = filereader.read()) != -1) {
				System.out.print((char)singleCh);
				if((char)singleCh == '\r') {
					System.out.print("오");
				}
				if((char)singleCh == '\n') {
					System.out.print("아");
				}
				
			}
			filereader.close();
			
		} catch(FileNotFoundException e) {
			
		} catch(IOException e) {
			System.out.println(e);
		}
		*/
	}
	public static ArrayList AscedingOrder(ArrayList<String> al) {
		String temp = "";
		ArrayList<String> newList = new ArrayList<String>();
		for(int i=0; i<al.size()-1; i++) {
			for(int j=i+1; j<al.size(); j++) {
				if(al.get(i).compareTo(al.get(j)) > 0) {
					temp = al.get(i);
					al.set(i, al.get(j));
					al.set(j, temp);
				}
			}
		}
		newList = al;
		return newList;
	}
	
	public static void CntChar(String line) {
		int total = 0, uppercase = 0, lowercase = 0, digit = 0, whitespace = 0, other = 0;
		char[] input = line.toCharArray();
		for(int i=0; i<input.length; i++) {
			if(input[i] >= 'A' && input[i] <= 'Z') {
				uppercase++;
				total++;
			}
			else if(input[i] >= 'a' && input[i] <= 'z') {
				lowercase++;
				total++;
			}
			else if(input[i] >= '0' && input[i] <= '9') {
				digit++;
				total++;
			}
			else if(input[i] == ' ' || input[i] == '\n') {
				whitespace++;
				total++;
			}
			else {
				other++;
				total++;
			}
		}
		System.out.println("Uppercase:"+uppercase+", Lowercase:"+lowercase+", Digit:"+digit+", Whitespace:"+whitespace+", Others:"+other);
	}

}


