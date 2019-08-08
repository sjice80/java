import java.util.*;
import java.io.*;

public class ssp_gate1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		sabunSearch();
	}
	public static void sabunSearch() throws IOException {
		String line="";
		int flag=0;
		FileWriter fw = new FileWriter("./OUTFILE/RESULT.TXT");
		BufferedWriter bw = new BufferedWriter(fw);
		while(true) {
			Scanner sc = new Scanner(System.in);
			while(sc.hasNext()) {
				String input = sc.nextLine();
				FileReader f = new FileReader("./INFILE/EMPGATE.TXT");
				BufferedReader br = new BufferedReader(f);
				fw = new FileWriter("./OUTFILE/RESULT.TXT", true);
				bw = new BufferedWriter(fw);
				flag=0;
				while(true) {
					line = br.readLine();
					if(line!=null) {
						if(line.equals(input)) {
							bw.write(input+"#Y\r\n");
							flag=1;
						} 
					} else {
						break;
					}
				}
				if(flag==0) {
					bw.write(input+"#N\r\n");
				}
				br.close();
				bw.close();
			}
		}
		/*
		String line = "";
		String[] gate = new String[100];
		String[] gate_new = new String[100];
		int gate_cnt=0, i=0, new_cnt=0, j=0, same_flag=0;
		while(true) {
			Scanner sc = new Scanner(System.in);
			while(sc.hasNextInt()) {
				int sabun = sc.nextInt();
				FileReader f = new FileReader("./INFILE/EMPGATE.TXT");
				BufferedReader br = new BufferedReader(f);
				FileWriter fw = new FileWriter("./OUTFILE/RESULT.TXT", true);
				BufferedWriter bw = new BufferedWriter(fw);
				gate = new String[100];
				gate_new = new String[100];
				gate_cnt=0; 
				new_cnt=0;
				while(true) {
					line = br.readLine();
					if(line!=null) {
						String[] str = line.split("#");
						if(Integer.parseInt(str[0])==sabun) {
							for(i=0; i<gate_cnt; i++) {								
								if(str[1].equals(gate[i])==false) {
									System.out.println("2:"+sabun+","+str[1]+","+gate[i]);
									gate[gate_cnt] = str[1];
									gate_cnt++;
									break;
								} else {
									continue;
								}
							}
							if(i==gate_cnt) {
								gate[gate_cnt] = str[1];
								gate_cnt++;		
								System.out.println("1:"+sabun+","+gate[i]);
							}
						}
					} else {
						break;
					}
				}
				System.out.println("4:"+gate_cnt);
	
				for(i=0; i<gate_cnt; i++) {
					same_flag = 0;
					for(j=0; j<gate_cnt; j++) {
						if(gate[i].equals(gate_new[j]) == true) {
							same_flag = 1;
							break;
						}
					}
					if(same_flag == 0) {
						gate_new[new_cnt] = gate[i];
						new_cnt++;					
					}
				}
				for(i=0; i<new_cnt; i++) {
					System.out.println("3:"+gate_new[i]);
				}
				System.out.println("5:"+new_cnt);
				bw.write(String.valueOf(sabun)+",");
				for(i=0; i<new_cnt-1; i++) {
//						System.out.println("3:"+gate_new[i]);
					bw.write(gate_new[i]+",");
				}
				bw.write(gate_new[new_cnt-1]);
				bw.newLine();
				br.close();
				bw.close();
			}
				sc.close();
				//bw.close();
		}
*/		
	}
	
}
