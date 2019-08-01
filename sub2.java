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

public class sub2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("./INFILE/LOCATION.TXT");
		BufferedReader br = new BufferedReader(fr);
		
		String line="", line2="";
		int i=0, j=0, k=0;
		while(true) {
			line = br.readLine();
			line2 = br.readLine();
			if(!line.contains("#")) {
				break;
			} else {
				ArrayList<Bus> busList = new ArrayList<Bus>();
				String[] str = line.split("#");
				String[] str2 = line2.split("#");
				for(i=1; i<str.length; i++) {
					Bus b = new Bus(str[i]);
					Bus b2 = new Bus(str2[i]);
					busList.add(b2);
					int velocity = b2.getBusLoc() - b.getBusLoc();
					System.out.println(b2.getBusId()+","+b2.getBusLoc()+", "+velocity);
				}
			}
		}
		br.close();
	}

}
