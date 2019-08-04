import java.util.*;
import java.io.*;

class Bus {
	private String busId;
	private int busLoc;
	public Bus(String line) {
		this.busId = line.split(",")[0];
		this.busLoc = Integer.parseInt(line.split(",")[1]);
	}
	public String getBusId() {
		return this.busId;
	}
	public int getBusLoc() {
		return this.busLoc;
	}
}

class Station {
	private String statId;
	private int statLoc;
	public Station(String line) {
		this.statId = line.split("#")[0];
		this.statLoc = Integer.parseInt(line.split("#")[1]);
	}
	public String getStatId() {
		return this.statId;
	}
	public int getStatLoc() {
		return this.statLoc;
	}
}

public class sub1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("./INFILE/LOCATION2.TXT");
		BufferedReader br = new BufferedReader(fr);
		String line="", cmd="";
		int i=0, j=0, k=0;
		while(true) {
			line = br.readLine();
			if(line.equals("PRINT")) {
				break;
			} else {
				cmd = line;
			}
		}
		
		FileReader fr2 = new FileReader("./INFILE/STATION2.TXT");
		BufferedReader br2 = new BufferedReader(fr2);
		FileWriter fw2 = new FileWriter("./OUTFILE/PREPOST.TXT");
		ArrayList<Station> statList = new ArrayList<Station>();
		while(true) {
			line = br2.readLine();
			if(line==null) {
				break;
			} else {
				Station s = new Station(line);
				statList.add(s);
				System.out.println(s.getStatId()+","+s.getStatLoc());
			}
		}
		
		String result="";
		FileWriter fw = new FileWriter("./OUTFILE/ARRIVAL.TXT");
		ArrayList<Bus> busList = new ArrayList<Bus>();
		String[] str = cmd.split("#");
		for(i=1; i<str.length; i++) {
			Bus b = new Bus(str[i]);
			busList.add(b);
			System.out.println(b.getBusId()+","+b.getBusLoc());
		}
		int diff_min=10000;
		int flag = 0;
		int min=10000, diff=0;
		int cnt=0;
		HashMap<String, String> stop = new HashMap<String, String>();
		
		for(j=0; j<statList.size(); j++) {
			cnt=0;
			flag=0;
			min=10000;
			for(k=0; k<busList.size(); k++) {
				if(busList.get(k).getBusLoc() <= statList.get(j).getStatLoc()) {
					flag=1;
					diff = statList.get(j).getStatLoc() - busList.get(k).getBusLoc();					
//					System.out.println("1."+statList.get(j).getStatId()+"#"+busList.get(k).getBusId()+","+String.format("%05d", diff));
					if(diff < min) {
						min = diff;
//						stop.put(statList.get(j).getStatId(), busList.get(k).getBusId()+","+String.format("%05d", min));
						String str2 = String.format("%05d", min);
						result = statList.get(j).getStatId()+"#"+busList.get(k).getBusId()+","+str2;
//						System.out.println(result);
						stop.put(statList.get(j).getStatId(), busList.get(k).getBusId()+","+String.format("%05d", min));
					}
				} 
			}
			if(flag==0) {
				diff = statList.get(j).getStatLoc();
				String str2 = String.format("%05d", diff);
				stop.put(statList.get(j).getStatId(), "NOBUS,"+str2);
				result = statList.get(j).getStatId()+"#NOBUS,"+str2;
//				System.out.println(result);
			}
		}
		
		for(i=0; i<stop.size(); i++) {
			fw2.write(statList.get(i).getStatId()+"#"+stop.get(statList.get(i).getStatId())+"\r\n");
			System.out.println(statList.get(i).getStatId()+"#"+stop.get(statList.get(i).getStatId()));
		}
		HashMap<String, String> post = new HashMap<String, String>();
		for(j=0; j<busList.size(); j++) {
			result = str[0] + "#" + busList.get(j).getBusId();
			flag = 0;
			diff_min=10000;
			cnt=0;
			for(k=0; k<busList.size(); k++) {
				if(busList.get(j).getBusLoc() < busList.get(k).getBusLoc()) {
					flag = 1;
					cnt++;
					diff = busList.get(k).getBusLoc() - busList.get(j).getBusLoc();

					if(cnt>=2) {
						if(diff<diff_min) {				
							diff_min = diff;
							String diff_str = String.format("%05d", diff_min);
							post.replace(busList.get(j).getBusId(), busList.get(k).getBusId() + "," + diff_str);
							result = str[0] + "#" + busList.get(j).getBusId() + "#" + busList.get(k).getBusId() + "," + diff_str;
							break;
						}
					} else {
						diff_min = diff;
						String diff_str = String.format("%05d", diff_min);
						post.put(busList.get(j).getBusId(), busList.get(k).getBusId() + "," + diff_str);
						result = result + "#" + busList.get(k).getBusId() + "," + diff_str;
					}
	
				}
			}
			if(flag == 0) {
				result = result + "#NOBUS,00000";
				post.put(busList.get(j).getBusId(),"NOBUS,00000");
			}
		}
		HashMap<String, String> back = new HashMap<String, String>();
		for(j=0; j<busList.size(); j++) {
			result = str[0] + "#" + busList.get(j).getBusId();
			flag = 0;
			diff_min=10000;
			cnt=0;
			for(k=0; k<busList.size(); k++) {
				if(busList.get(j).getBusLoc() > busList.get(k).getBusLoc()) {
					flag = 1;
					cnt++;
					diff = busList.get(j).getBusLoc() - busList.get(k).getBusLoc();
					if(cnt>=2) {
						if(diff<diff_min) {				
							diff_min = diff;
							String diff_str = String.format("%05d", diff_min);
							back.replace(busList.get(j).getBusId(), busList.get(k).getBusId() + "," + diff_str);
							break;
						}
					} else {
						diff_min = diff;
						String diff_str = String.format("%05d", diff_min);
						back.put(busList.get(j).getBusId(), busList.get(k).getBusId() + "," + diff_str);
					}
				}
			}
			if(flag == 0) {
				back.put(busList.get(j).getBusId(),"NOBUS,00000");
			}
		}
		System.out.println(stop.size());
		for(i=0; i<post.size(); i++) {
			fw.write(str[0] + "#" + busList.get(i).getBusId()+"#"+post.get(busList.get(i).getBusId())+"#"+back.get(busList.get(i).getBusId())+"\r\n");
			System.out.println(str[0] + "#" + busList.get(i).getBusId()+"#"+post.get(busList.get(i).getBusId())+"#"+back.get(busList.get(i).getBusId()));
		}

		br.close();
		fw.close();
		br2.close();
		fw2.close();
	}
}
