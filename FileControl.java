import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
/*import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
*/
import java.util.*;
import java.io.*;

class SoccerPlayer implements Comparable<SoccerPlayer> {
	private String name;
	private String position;
	private int age;
	public SoccerPlayer(String name, String position, int age) {
		this.name = name;
		this.position = position;
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPosition() {
		return this.position;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	public int compareTo(SoccerPlayer p) {
		return this.name.compareTo(p.getName());
	}
	public void toString(SoccerPlayer p) {
		System.out.println(p.getName()+","+p.getPosition()+","+p.getAge());
	}
}
public class FileControl {

	private static String LINE_BREAK = System.getProperty("line.seperator");
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		FileWriter fw = new FileWriter("./dest/output.txt");
//		BufferedWriter bw = new BufferedWriter(fw);
		ArrayList<SoccerPlayer> spList = new ArrayList<SoccerPlayer>();
		String name="", position="", age="";
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Input player's name:");
			name = sc.nextLine();
			if(name.equals("quit")||position.equals("quit")||age.equals("quit")) {
				System.out.println("The end");
				break;
			}
			System.out.println("Input player's position:");
			position = sc.nextLine();
			if(name.equals("quit")||position.equals("quit")||age.equals("quit")) {
				System.out.println("The end");
				break;
			}
			System.out.println("Input player's age:");
			age = sc.nextLine();
			if(name.equals("quit")||position.equals("quit")||age.equals("quit")) {
				System.out.println("The end");
				break;
			}
			fw.write(name+"#"+position+"#"+age+"\r\n");
			//fr.write("\n");
			SoccerPlayer sp1 = new SoccerPlayer(name, position, Integer.parseInt(age));
			spList.add(sp1);
		}
		fw.close();
		sc.close();
		
		Collections.sort(spList);
		for(int i=0; i<spList.size(); i++) {
			spList.get(i).toString(spList.get(i));
			//System.out.println(spList.get(i).getName()+","+spList.get(i).getPosition()+","+spList.get(i).getAge());
		}
		*/
//		System.out.print("hello mac!");
		
		String source = ".//input.txt";
		String destination = ".//dest//";
		FileReader fr = new FileReader(source);
		
		
		BufferedReader br = new BufferedReader(fr);
		HashSet<String> folder = new HashSet<String>();
		while(true) {
			String str = br.readLine();
			if(str!=null) {
				folder.add(str.split("#")[0]);
			} else {
				break;
			}
		}
		System.out.println(folder);
		br.close();
		
		
		BufferedReader br2 = new BufferedReader(fr);
		HashMap<String,String> map = new HashMap<String,String>();
		while(true) {
			String str = br2.readLine();
			if(str!=null) {
				if(!map.containsKey(str.split("#")[0])) {
					map.put(str.split("#")[0], str.split("#")[1]);
				} else {
					System.out.println("키 존재함"+map.get(str.split("#")[0]));
					map.replace(str.split("#")[0], map.get(str.split("#")[0])+"#"+str.split("#")[1]);
				}
			} else {
				break;
			}
		}
		for(String s:map.keySet()) {
			System.out.println(s+"#"+map.get(s));
		}
		br2.close();
		
		
		ArrayList<String> sort = new ArrayList<String>(folder);
		Collections.sort(sort);
		System.out.println(sort);
		for(int i=0; i<sort.size(); i++) {
			String mkFolder = destination+sort.get(i);
			File dest = new File(mkFolder);
			if(!dest.exists()) {
				dest.mkdirs();
				System.out.println("폴더생성:"+mkFolder);
			} else {
				System.out.println("폴더생성안 :"+mkFolder);
			}
			
		}
		

		File[] f_list = new File(source).listFiles();
		System.out.println("총 "+f_list.length+"개의 폴더가 존재합니다.");
		for(int folder2=0; folder2<f_list.length; folder2++) {
			System.out.println(folder2+"번째 디렉토리를 분석중입니다.");
			String chk = destination.substring(destination.length()-2, destination.length());
			if(!chk.equals("//")) {
				destination += "//";			
			}
			String mkFolder = destination+f_list[folder2].getName();
			File[] fileList = f_list[3].listFiles();
			File desti = new File(mkFolder);
			if(!desti.exists()) {
				desti.mkdirs();
			} else {
				File[] destroy = desti.listFiles();
				for(File des:destroy) {
					des.delete();
				}
			}
			System.out.println("디렉토리명="+mkFolder);//+fileList[0]);
//			for(int f=0; f<fileList.length; f++) {
//				System.out.println("\t"+fileList[0]+"파일 분석 중...");
				
//			}
		}
		
		/*
		System.out.println(getLastTime(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        System.out.println(getLastTime(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        System.out.println(getLastTime(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
        System.out.println(getLastTime(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        System.out.println(getLastTime(1, 1, 1, new String[]{"23:59"}));
        System.out.println(getLastTime(10, 60, 45, new String[]{"23:59","23:59", "23:59", "23:59", "23:59", "23:59"
                , "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
                */
		/*
		Scanner sc = new Scanner(System.in);
		String  num = sc.nextLine();
		FileReader fr = new FileReader("./output.txt");
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String line = br.readLine();
			if(line!=null) {
				if(num.equals(line.split("#")[0])) {
					System.out.println(line.split("#")[0]+","+line.split("#")[1]);
				}
			} else {
				break;
			}
		}
		*/
		findChain("./chain.txt");
	}
	public static String findChain(String file) throws IOException {
		FileReader fr = new FileReader("./chain.txt");
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
	public static String getLastTime(int n, int t, int m, String[] waitTime) {
		String answer="";
		// 버스 도착시간 계산
		String[] busTime = new String[n];
		for(int i=0; i<n; i++) {
			busTime[i] = getAddTime("9:00", t*i);
		}
		String lastBusTime = busTime[n-1];
		// 대기자 명단을 먼저 온 기준으로 정렬
		Arrays.sort(waitTime);
		int curPos = 0;
		int curAdded = 0;
		String busStop = "";
		for(int j=0; j<busTime.length; j++) {
			busStop = busTime[j];
			curAdded = 0;
			// 순차적으로 버스가 들어옴을 for로 처리
			for(int k=curPos; curPos<waitTime.length; k++) {
				// 현재 버스에 시간 이전에 도착한 사람이 있는 경우 && 현재 버스에 빈자리가 있는 경우
				if(getMinLong(busStop)>=getMinLong(waitTime[k]) && curAdded<m) {
					// 마지막 탑승가능한 사람 도착 시간 임시저장 
					answer = waitTime[curPos];
					// 마지막 탑승가능자보다 1분 빨리 오도록 임시시간 저장
					answer = getAddTime(answer, -1);
					curPos++;
					curAdded++;
					// curAdded<m 버스 자리가 여유있고, 마지막 탑승객이면 현재 버스 시간에 맞게 나감
					if(j==busTime.length-1 && k==waitTime.length-1 && curAdded<m) {
						answer = busTime[n-1];
					}
				} else {
					// 마지막 버스인데 탑승객이 전부 못타는 경우 최종탑승자보다 빨리 와야함
					if(j==busTime.length-1 && curPos>=1) {
						answer = waitTime[curPos-1];
						answer = getAddTime(answer, -1);
					}
					break;
				}
			}
		}
		if("".equals(answer)||getMinLong(answer)>getMinLong(lastBusTime)) {
			answer = lastBusTime;
		}
		return answer;
	}
	private static String getAddTime(String hhmm, int addMin) {
		long temp = getMinLong(hhmm);
		temp = temp + addMin;
		int hh = (int)temp/60;
		int mm = (int)temp%60;
		return String.format("%02d", hh)+":"+String.format("%02d", mm);
	}
	private static long getMinLong(String hhmm) {
		String arr[] = hhmm.split(":");
		int hh = Integer.parseInt(arr[0]);
		int mm = Integer.parseInt(arr[1]);
		return hh*60+mm;
	}
	
/*
	public void saveReportFile(HashMap<String, ReportVo> map, String today) throws IOException {
		String filename = "..//SERVER//REPORT_"+today+".TXT";
		FileWriter fw = null;
		try {
			fw = new FileWriter(filename);
			for(String key:map.keySet()) {
				fw.write(map.get(key).toString());
				fw.write(LINE_BREAK);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(fw!=null) {
				fw.close();
			}
		}
	}
	public void printReport(String date, String option) throws IOException {
		ArrayList<ReportVo> reportList = new ArrayList<>();
		BufferedReader br = null;
		String line;
		try {
			br = new BufferedReader(new FileReader("..//SERVER//REPORT_"+date+".TXT"));
			while((line=br.readLine())!=null) {
				ReportVo userReport = new ReportVo(line);
				reportList.add(userReport);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(br!=null) {
				br.close();
			}
		}
		if("C".equals(option)) {
			Comparator<ReportVo> co = new Comparator<ReportVo>() {
				public int compare(ReportVo o1, ReportVo o2) {
					return (o2.getCheckCard()-o1.getCheckCard());
				}
			};
			Collections.sort(reportList, co);
		}
		for(int i=0; i<reportList.size(); i++) {
			System.out.println(reportList.get(i).toString());
		}
	}
	*/
}
