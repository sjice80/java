import java.util.*;
import java.io.*;

public class ssp_gate2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		sabunSearch();
	}
	public static void sabunSearch() throws IOException {
		String line="";
		int flag=0, start=0, end=0;
		FileWriter fw = new FileWriter("./OUTFILE/RESULT.TXT");
		ArrayList<Integer> list = new ArrayList<Integer>();;
		BufferedWriter bw = new BufferedWriter(fw);
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		HashMap<String, ArrayList<Integer>> map2 = new HashMap<String, ArrayList<Integer>>();
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
						if(input.equals(line.split("#")[0])) {
							String[] str = line.split("#")[1].split("-");
							start = Integer.parseInt(str[0]);
							end = Integer.parseInt(str[1]);
							list = new ArrayList<Integer>();
							for(int i=start; i<=end; i++) {
								list.add(i);
							}
							Collections.sort(list);
							if(!map.containsKey(input)) {
								map.put(input, list);
							} else {
								map2.put(input, list);
								map2.forEach((K, V) -> {
						            map.merge(K, V, (list1, list2) -> {
						                list1.addAll(list2);
						                return list1;
						            });
						        });
						        System.out.println("Merged: \n"+map);
							}
							flag=1;
						} 
					} else {
						break;
					}
				}


				if(flag==1) {
					ArrayList<Integer> newList = new ArrayList<Integer>();
					for(int i:map.get(input)) {
						if(!newList.contains(i)) {
							newList.add(i);
						}
					}
					bw.write(input+"#");
					for(int i:newList) {
						if(i==newList.get(newList.size()-1)) {
							break;
						}
						bw.write(String.format("%02d", i)+",");
						System.out.print(i+", ");
					}
					bw.write(String.format("%02d",newList.get(newList.size()-1))+"\r\n");
					System.out.println(newList.get(newList.size()-1));
				}
				if(flag==0) {
					bw.write(input+"#N\r\n");
				}
				br.close();
				bw.close();
			}
			sc.close();
		}
	}
}
