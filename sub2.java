import java.util.*;
import java.io.*;

class Bus {
	private String busId;
	private int busLoc;
	private int busVel;
	public Bus(String line) {
		this.busId = line.split(",")[0];
		this.busLoc = Integer.parseInt(line.split(",")[1]);
		this.busVel = 0;
	}
	public String getBusId() {
		return this.busId;
	}
	public int getBusLoc() {
		return this.busLoc;
	}
	public int getBusVel() {
		return this.busVel;
	}
	public void setBusVel(int vel) {
		this.busVel = vel;;
	}
}

class Station {
	private String statId;
	private int statLoc;
	private int statVel;
	public Station(String line) {
		this.statId = line.split("#")[0];
		this.statLoc = Integer.parseInt(line.split("#")[1]);
		this.statVel = Integer.parseInt(line.split("#")[2]);
	}
	public String getStatId() {
		return this.statId;
	}
	public int getStatLoc() {
		return this.statLoc;
	}
	public int getStatVel() {
		return this.statVel;
	}
	public void setStatVel(int vel) {
		this.statVel = vel;;
	}
}

public class sub2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("./INFILE/LOCATION.TXT");
		BufferedReader br = new BufferedReader(fr);
		
		String line="", line2="", pre="", pre2="";
		int i=0, j=0, k=0;
		while(true) {
			line = br.readLine();
			line2 = br.readLine();
			if(!line.contains("#")) {
				System.out.println(pre+","+line);
				System.out.println(pre2+","+line2);
				break;
			} else {
				pre = line;
				pre2 = line2;
			}
		}
		ArrayList<Bus> busList = new ArrayList<Bus>();
		String[] str = pre.split("#");
		String[] str2 = pre2.split("#");
		for(i=1; i<str.length; i++) {
			Bus b = new Bus(str[i]);
			Bus b2 = new Bus(str2[i]);
			busList.add(b2);
			int velocity = b2.getBusLoc() - b.getBusLoc();
			busList.get(j).setBusVel(velocity);
			j++;
			System.out.println(b2.getBusId()+","+b2.getBusLoc()+", "+velocity);
		}
		br.close();
		int interval = Integer.parseInt(line2.split(":")[2]) - Integer.parseInt(str2[0].split(":")[2]);
		System.out.println("interval:"+interval);
		j=0;
		FileReader fr2 = new FileReader("./INFILE/STATION.TXT");
		BufferedReader br2 = new BufferedReader(fr2);
//		FileWriter fw2 = new FileWriter("./OUTFILE/ARRIVAL.TXT");
		ArrayList<Station> statList = new ArrayList<Station>();
		while(true) {
			line = br2.readLine();
			if(line==null) {
				break;
			} else {
				Station s = new Station(line);				
				statList.add(s);
				int velocity = s.getStatVel()*1000/3600;
				statList.get(j).setStatVel(velocity);
				j++;
				System.out.println(s.getStatId()+","+s.getStatLoc()+","+s.getStatVel());
			}
		}
		for(i=0; i<busList.size(); i++) {
			for(j=0; j<statList.size()-1; j++) {
				if(busList.get(i).getBusLoc() >= statList.get(j).getStatLoc() &&
						busList.get(i).getBusLoc() <= statList.get(j+1).getStatLoc()) {
					int diff = Math.min(busList.get(i).getBusVel(), statList.get(j+1).getStatVel()) * interval;
					String newLoc = String.format("%05d", diff+busList.get(i).getBusLoc());
					System.out.println(line2+"#"+busList.get(i).getBusId()+"#"+newLoc);
				}
			}
		}
	}
}
