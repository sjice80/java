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
		FileReader fr = new FileReader("./INFILE/LOCATION.TXT");
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
		String result="";
		FileWriter fw = new FileWriter("./OUTFILE/PREPOST.TXT");
		ArrayList<Bus> busList = new ArrayList<Bus>();
		String[] str = cmd.split("#");
		for(i=1; i<str.length; i++) {
			Bus b = new Bus(str[i]);
			busList.add(b);
			System.out.println(b.getBusId()+","+b.getBusLoc());
		}
		int flag = 0;
		int diff_min=10000;
		int cnt=0;
		
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
					int diff = busList.get(k).getBusLoc() - busList.get(j).getBusLoc();

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
					int diff = busList.get(j).getBusLoc() - busList.get(k).getBusLoc();
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
		System.out.println(post.size());
		for(i=0; i<post.size(); i++) {
			fw.write(str[0] + "#" + busList.get(i).getBusId()+"#"+post.get(busList.get(i).getBusId())+"#"+back.get(busList.get(i).getBusId())+"\r\n");
			System.out.println(str[0] + "#" + busList.get(i).getBusId()+"#"+post.get(busList.get(i).getBusId())+"#"+back.get(busList.get(i).getBusId()));
		}

		br.close();
		fw.close();
	}
}

