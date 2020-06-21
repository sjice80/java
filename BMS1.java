import java.util.*;
import java.io.*;

class BMS implements Comparable<BMS> {
	//10:00:03#BUS01,02395#BUS02,00815#BUS03,07854
	String time;
	String id;
	String loc;
	int vel;
	int arrivalTime = 10000;
	String arrivalBus = "NOBUS";
	String arrivalTimeS = "00:00:00";
	public BMS(String time, String line) {
		// TODO Auto-generated constructor stub
		this.time = time;		
		this.id = line.split(",")[0];
		this.loc= line.split(",")[1];		
	}

	public BMS(String time, String line, String stop) {
		// TODO Auto-generated constructor stub
		this.time = time;		
		this.id = stop.split("#")[0];
		this.loc= stop.split("#")[1];
		this.vel = (Integer.parseInt(stop.split("#")[2])*1000)/3600;
	}
	
	public BMS(String time, String line, int vel) {
		// TODO Auto-generated constructor stub
		this.time = time;		
		this.id = line.split(",")[0];
		this.loc = line.split(",")[1];
		this.vel = vel;
	}
	
	@Override
	public int compareTo(BMS o) {
		// TODO Auto-generated method stub
		if(this.loc.compareTo(o.loc)>0)
			return 1;
		else if(this.loc.compareTo(o.loc)<0)
			return -1;
		else 
			return 0;
	}
	public String toString() {
		return this.time+"#"+this.id+"#"+this.arrivalBus+","+this.arrivalTimeS;
	}
	
}
public class BMS1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("./INFILE/LOCATION.TXT"));
		BufferedReader sbr = new BufferedReader(new FileReader("./INFILE/STATION.TXT"));

		String line = "", preline="", sline="", time="";
		int[] vel_arr = {};
		String[] str = {};
		String[] str2 = {};
		while((line=br.readLine())!=null) {
			if(preline!="" && line.length()>8) {
				str = preline.split("#");
				str2 = line.split("#");
				vel_arr = new int[str.length-1];
				for (int i = 1; i < str.length; i++) {
					vel_arr[i-1] = Integer.parseInt(str2[i].split(",")[1]) - Integer.parseInt(str[i].split(",")[1]);
//					System.out.println(str2.length+","+vel_arr[i-1]);
				}
			}
			if(line.equals("PRINT")) {
				break;
			}
			if(line.length()>8) {
				preline = line;
				time = line.substring(0,8);
			} else {
				String m = "";
				int i = 0;
				for (i = 1; i < str2.length-1; i++) {
					int tmp = Integer.parseInt(str2[i].split(",")[1]) + vel_arr[i-1];
//					System.out.println(i+":"+tmp);
					m += str2[i].split(",")[0]+","+String.format("%05d", Integer.parseInt(str2[i].split(",")[1]) + vel_arr[i-1])+"#";
				}
				m += str2[i].split(",")[0]+","+String.format("%05d", Integer.parseInt(str2[i].split(",")[1]) + vel_arr[i-1]);
				line = line + "#" + m;
				str2 = line.split("#");
				System.out.println(line);
				preline = line;
				time = line.substring(0,8);
			}
		}
		for (int i = 1; i < str.length; i++) {
//			System.out.println(i+":"+vel_arr[i-1]);
		}
		ArrayList<BMS> list = new ArrayList<>();
		ArrayList<BMS> sortlist = new ArrayList<>();
		ArrayList<BMS> prelist = new ArrayList<>();
//		System.out.println("1."+preline);
		str = preline.split("#");
		for (int i = 1; i < str.length; i++) {
			BMS b = new BMS(time, str[i], vel_arr[i-1]);
			list.add(b);
			sortlist.add(b);
			prelist.add(b);
		}
		while((sline=sbr.readLine())!=null) {
			BMS b = new BMS(time, "", sline);
			sortlist.add(b);
		}
		Collections.sort(prelist);
		Collections.sort(sortlist);
//		System.out.println(list);
//		System.out.println(prelist);
//		System.out.println(sortlist);
		String result = "";
		int cnt = 1;
		FileWriter afw = new FileWriter("./OUTFILE/ARRIVAL.TXT");
		for (int j = 0; j < sortlist.size(); j++) {
			if(sortlist.get(j).id.substring(0,3).equals("STA")) {
				if(j!=0 && !sortlist.get(j-1).id.substring(0,5).equals("STA01")) {
					cnt = 1;
					if(sortlist.get(j-cnt).id.substring(0,3).equals("BUS")) {
						int diff = Integer.parseInt(sortlist.get(j).loc) - Integer.parseInt(sortlist.get(j-cnt).loc);
						String s = String.format("%05d", diff);
						result = sortlist.get(j).time+"#"+sortlist.get(j).id+"#"+sortlist.get(j-cnt).id+","+s+"\r\n";
						afw.write(result);
						System.out.print(result);
						
					} else {
						cnt++;
						while(sortlist.get(j-cnt).id.substring(0,3).equals("STA")) {
							cnt++;
						}
						int diff = Integer.parseInt(sortlist.get(j).loc) - Integer.parseInt(sortlist.get(j-cnt).loc);
						String s = String.format("%05d", diff);
						result = sortlist.get(j).time+"#"+sortlist.get(j).id+"#"+sortlist.get(j-cnt).id+","+s+"\r\n";
						afw.write(result);
						cnt++;
						System.out.print(result);
					}
				} else {
					result = sortlist.get(j).time+"#"+sortlist.get(j).id+"#NOBUS,00000"+"\r\n";
					afw.write(result);
					System.out.print(result);
				}
			}
		}
		afw.close();
		
		FileWriter fw = new FileWriter("./OUTFILE/PREPOST.TXT");
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < prelist.size(); j++) {
				if(list.get(i).id.equals(prelist.get(j).id)) {
					if(j+1==prelist.size()) {
						int diff = Integer.parseInt(prelist.get(j).loc) - Integer.parseInt(prelist.get(j-1).loc);
						String s = String.format("%05d", diff);
						result = list.get(i).time+"#"+list.get(i).id+"#NOBUS,00000"+"#"+prelist.get(j-1).id+","+s+"\r\n";
						fw.write(result);
						System.out.print(result);
					} else if(j-1==-1) {
						int diff = Integer.parseInt(prelist.get(j+1).loc) - Integer.parseInt(prelist.get(j).loc);
						String s = String.format("%05d", diff);
						result = list.get(i).time+"#"+list.get(i).id+"#"+prelist.get(j+1).id+","+s+"#NOBUS,00000"+"\r\n";
						fw.write(result);
						System.out.print(result);
					} else {
						int diff1 = Integer.parseInt(prelist.get(j+1).loc) - Integer.parseInt(prelist.get(j).loc);
						String s1 = String.format("%05d", diff1);
						int diff2 = Integer.parseInt(prelist.get(j).loc) - Integer.parseInt(prelist.get(j-1).loc);
						String s2 = String.format("%05d", diff2);						
						result = list.get(i).time+"#"+list.get(i).id+"#"+prelist.get(j+1).id+","+s1+"#"+prelist.get(j-1).id+","+s2+"\r\n";
						fw.write(result);
						System.out.print(result);
					}
				}
			}
		}
		fw.close();
		
		ArrayList<BMS> buslist = new ArrayList<>();
		ArrayList<BMS> stalist = new ArrayList<>();
		for (int i = 0; i < sortlist.size(); i++) {
			if(sortlist.get(i).id.substring(0,3).equals("BUS")) {
				buslist.add(sortlist.get(i));
			} else {
				stalist.add(sortlist.get(i));
			}
		}
//		System.out.println(buslist);
//		System.out.println(stalist);
		int vel = 0, dist = 0, time1 = 0;
		for (int i = 0; i < buslist.size(); i++) {
			time1 = 0;
			for (int j = 1; j < stalist.size(); j++) {
				vel = buslist.get(i).vel;

				if(Integer.parseInt(buslist.get(i).loc) < Integer.parseInt(stalist.get(j).loc)) {
					if(buslist.get(i).vel > stalist.get(j-1).vel && stalist.get(j-1).vel!=0) {
						time1 = (Integer.parseInt(stalist.get(j-1).loc) - Integer.parseInt(buslist.get(i).loc))/buslist.get(i).vel +
								(Integer.parseInt(stalist.get(j).loc) - Integer.parseInt(stalist.get(j-1).loc))/stalist.get(j-1).vel;
					} else {				
						dist = Integer.parseInt(stalist.get(j).loc) - Integer.parseInt(buslist.get(i).loc);
						time1 = dist/vel;
					}
//					System.out.println("dist:"+dist+", vel:"+vel);
						
					if(time1 < stalist.get(j).arrivalTime) {
						stalist.get(j).arrivalTime = time1;
						stalist.get(j).arrivalBus = buslist.get(i).id;
					}
					String tstr = makeTime(list.get(0).time, stalist.get(j).arrivalTime);
					stalist.get(j).arrivalTimeS = tstr;
//					System.out.println(buslist.get(i)+","+stalist.get(j)+","+tstr);					
				}
				
			}
		}
		FileWriter sfw = new FileWriter("./OUTFILE/SIGNAGE.TXT");
		for (int i = 0; i < stalist.size(); i++) {
			sfw.write(stalist.get(i).toString()+"\r\n");
			System.out.println(stalist.get(i).toString());
		}
		sfw.close();
		/*
		11:00:06#STA01#NOBUS,00:00:00
		11:00:06#STA02#NOBUS,00:00:00
		11:00:06#STA03#BUS02,11:00:31
		11:00:06#STA04#BUS02,11:01:04
		11:00:06#STA05#BUS02,11:03:07
		11:00:06#STA06#BUS02,11:04:34
		11:00:06#STA07#BUS02,11:05:54
		11:00:06#STA08#BUS03,11:01:56
		*/		
	}
	public static void execSignage() throws IOException {
		ProcessBuilder bld = new ProcessBuilder("SIGNAGE.EXE");
		Process p = bld.start();
		Scanner sc = new Scanner(System.in);
		String line = "";
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
		BufferedReader br = new BufferedReader(new FileReader("./OUTFILE/CMP_SIGNAGE.TXT"));
		while((line = sc.nextLine())!=null) {
			bw.write(line+"\r\n");
			if(line.equals("")) {
				break;
			}
		}
		/*
		while((line = br.readLine())!=null) {
			bw.write(line+"\r\n");
		}
		*/
		sc.close();
		bw.flush();
		bw.close();
	}
	public static String makeTime(String time, int delay) {
		String result = "";
		String[] str = time.split(":");
		int hour = 0, min = 0, sec = 0;
		hour = Integer.parseInt(str[0]) + (delay / (60*60));
		min = Integer.parseInt(str[1]) + (delay % (60*60))/60;
		sec = Integer.parseInt(str[2]) + (delay % (60*60))%60;
		if(sec>=60) {
			sec = sec - 60;
			min = min + 1;
		}
		if(min>=60) {
			min = min - 60;
			hour = hour + 1;
		}
		result = String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec);
//		System.out.println(result);
		return result;
	}
}
