import java.util.*;
import java.io.*;

class Base {
	String id;
	String num1;
	String num2;
	String num3;
	String check;
	public Base(String id, String num1, String num2, String num3, String check) {
		this.id = id;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.check = check;
	}
	public Base(String line) {
		int max1 = 0, max2 = 0, max3 = 0;
		this.id = line.split(" ")[0];
		for (int i = 1; i < 5; i++) {
			max1 = Math.max(Integer.parseInt(line.split(" ")[i]), max1);			
		}
		this.num1 = String.format("%05d", max1);
		for (int i = 5; i < 9; i++) {
			max2 = Math.max(Integer.parseInt(line.split(" ")[i]), max2);			
		}
		this.num2 = String.format("%05d", max2);
		for (int i = 9; i < 13; i++) {
			max3 = Math.max(Integer.parseInt(line.split(" ")[i]), max3);			
		}
		this.num3 = String.format("%05d", max3);
		this.check = line.split(" ")[13];
	}
	public String toString() {
		return this.id+" "+this.num1+" "+this.num2+" "+this.num3+"\r\n";
	}
	public String toString2() {
		return this.id+" "+this.check+"\r\n";
	}
}
public class sub1 {
	static ArrayList<Base> baselist = new ArrayList<>();
	static ArrayList<Base> reqlist = new ArrayList<>();
	static ArrayList<Base> verlist = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader basefr = new FileReader("./SAMPLE/SAMPLE.TXT");
		BufferedReader basebr = new BufferedReader(basefr);
		String line="", cmd="";
		int min=1000000000, sum=0, k=0;
		
		while((line = basebr.readLine())!=null) {
			Base b = new Base(line);
			baselist.add(b);
		}
		
		FileWriter basefw = new FileWriter("./OUTFILE/BASE_FEATURE.TXT");
		for(Base b:baselist) {
			basefw.write(b.toString());
			System.out.print(b.toString());
		}
		basefw.close();
		
		FileReader reqfr = new FileReader("./SAMPLE/REQUEST.TXT");
		BufferedReader reqbr = new BufferedReader(reqfr);
		
		while((line = reqbr.readLine())!=null) {
			Base b = new Base(line);
			reqlist.add(b);
		}
		FileWriter reqfw = new FileWriter("./OUTFILE/REPORT.TXT");
		for(Base b:reqlist) {
//			reqfw.write(b.toString());
			System.out.print(b.toString());
		}
		
		int diff1=0, diff2=0, diff3=0;
		for (int l = 0; l < reqlist.size(); l++) {
			min=1000000000;
			for (int l2 = 0; l2 < baselist.size(); l2++) {
				sum=0;				
				diff1 = Math.abs(Integer.parseInt(reqlist.get(l).num1)-Integer.parseInt(baselist.get(l2).num1));
				diff1 = (int) Math.pow(diff1, 2);
				diff2 = Math.abs(Integer.parseInt(reqlist.get(l).num2)-Integer.parseInt(baselist.get(l2).num2));
				diff2 = (int) Math.pow(diff2, 2);
				diff3 = Math.abs(Integer.parseInt(reqlist.get(l).num3)-Integer.parseInt(baselist.get(l2).num3));
				diff3 = (int) Math.pow(diff3, 2);
				sum = diff1 + diff2 + diff3;
				if(sum<min) {
					min = sum;
					reqlist.get(l).check = baselist.get(l2).check;
//					System.out.println("min:"+min);
				}
			}
		}
		for(Base b:reqlist) {
			reqfw.write(b.toString2());
			System.out.print(b.toString2());
		}
		reqfw.close();
	}
	public static void execProcess() throws IOException {
		String line="", result="";
		FileReader verfr = new FileReader("./SAMPLE/VERIFY.TXT");
		BufferedReader verbr = new BufferedReader(verfr);
		
		List<String> cmd = null; //new ArrayList<String>();
//		cmd.add(".//EXTRACTOR//EXTRACTOR_A.EXE");
		File[] fileList = new File(".//EXTRACTOR//").listFiles();
		int max = 0;
		while((line = verbr.readLine())!=null) {
			for(int i=0; i<fileList.length; i++) {
				File file = fileList[i];
				verlist = new ArrayList<>();
				cmd = new ArrayList<String>();
				cmd.add(".//EXTRACTOR//"+file.getName());
				cmd.add(line.substring(9, line.length()-2));
				ProcessBuilder bld = new ProcessBuilder(cmd);
//				bld.directory(new File("d:/workspace/some project"));	// change directory
				Process process = bld.start();

		        try {
		            BufferedReader reader =
		                    new BufferedReader(new InputStreamReader(process.getInputStream()));

		            while ((result = reader.readLine()) != null) {
		                System.out.println(result);
		                Base b = new Base(line.substring(0, 8), result.split(" ")[0], result.split(" ")[1], 
		                		result.split(" ")[2], line.substring(line.length()-1, line.length()));
		                verlist.add(b);
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        } 
		        int corrRate = correctRate();
		        if(corrRate > max) {
		        	FileWriter reqfw = new FileWriter("./OUTFILE/REPORT.TXT");
		        	max = corrRate;
		    		for(Base b:verlist) {
		    			reqfw.write(b.toString2());
		    			System.out.print(b.toString2());
		    		}
		        }
			}

		}
		for(Base b:verlist) {
//			reqfw.write(b.toString2());
			System.out.print(b.toString2());
		}        
	}
	public static int correctRate() {
		int total = verlist.size();
		int cnt = 0;
		for (int i = 0; i < total; i++) {
			if(verlist.get(i).check.equals(reqlist.get(i).check)) {
				cnt++;
			}
		}
		int rate = cnt/total;
		return rate;
	}
}
