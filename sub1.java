import java.io.*;
import java.util.*;

public class sub1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		List command = new ArrayList();
		command.add("ls");
		command.add("-l");
		command.add("./"); 

		ProcessBuilder processBuilder = new ProcessBuilder(command);

		try {
		    System.out.println("run " + (command));

		    Process process = processBuilder.start();

		    BufferedReader outReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		    BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

		    String line;
		    while ((line = outReader.readLine()) != null) {
		        System.out.println(line);
		    }
		    while ((line = errorReader.readLine()) != null) {
		        System.out.println(line);
		    }

		    int exitCode = process.waitFor();
		    System.out.println("\nExited with error code : " + exitCode);
		} catch (IOException ex) {
		    ex.printStackTrace();
		} catch (Exception ex) {
		    ex.printStackTrace();
		} finally {
		    ;
		}
		*/
		
		String line="";
		int cnt = 0, sum = 0, avg = 0, n1 = 0, n2 = 0, n3 = 0;
		ArrayList<String> result = new ArrayList<>();
		ArrayList<String> result2 = new ArrayList<>();
		ArrayList<String> result3 = new ArrayList<>();
		ArrayList<Integer> avglist = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int base = Integer.parseInt(input);
		int five = 0, alarm = 0, max = 0;
		FileReader fr = new FileReader("./INPUT/MONITORING.TXT");
		BufferedReader br = new BufferedReader(fr);
		while((line = br.readLine())!=null) {			
			if(input.compareTo(line.split("#")[1].split(":")[1])<0) {
				result.add(line+"#Y");
			} else {
				result.add(line+"#N");
			}
			
		}
		FileWriter fw = new FileWriter("./OUTPUT/REPORT.TXT");
		for (int i = 0; i < result.size(); i++) {
			fw.write(result.get(i)+"\n");
		}

		for (int i = 0; i < result.size(); i++) {
			if(i==0) {
				n1 = Integer.parseInt(result.get(i).split("#")[1].split(":")[1]);
				cnt++;
				sum += n1;
				avg = sum/cnt;				
			} else if(i==1) {
//				n1 = Integer.parseInt(result.get(i-1).split("#")[1].split(":")[1]);
				n2 = Integer.parseInt(result.get(i).split("#")[1].split(":")[1]);
				cnt++;
				sum += n2;
				avg = sum/cnt;				
			} else if(i==2) {
//				n1 = Integer.parseInt(result.get(i-2).split("#")[1].split(":")[1]);
//				n2 = Integer.parseInt(result.get(i-1).split("#")[1].split(":")[1]);
				n3 = Integer.parseInt(result.get(i).split("#")[1].split(":")[1]);
				cnt++;
				sum += n3;
				avg = sum/cnt;				
			} else {
				n1 = Integer.parseInt(result.get(i-3).split("#")[1].split(":")[1]);
//				n2 = Integer.parseInt(result.get(i-1).split("#")[1].split(":")[1]);
				n3 = Integer.parseInt(result.get(i).split("#")[1].split(":")[1]);
				sum += (-n1+n3);
				avg = sum/3;				
			} 
			avglist.add(avg);
			if(avg>base) {
				five++;
				if(five>5) {
					max = Math.max(max, avg);
					if(max-avg <=3) {
						alarm = 1;
					} else {
						five = 0;
						alarm = 0;
					}
					if(alarm == 1) {
						result3.add(result.get(i)+"#"+String.format("%03d", avg));
					}
				}
			} else {
				five = 0;
				alarm = 0;
			}
			result2.add(result.get(i)+"#"+String.format("%03d", avg));
		}
		FileWriter fw2 = new FileWriter("./OUTPUT/REPORT2.TXT");
		for (int i = 0; i < result2.size(); i++) {
			fw2.write(result2.get(i)+"\n");
		}
		FileWriter fw3 = new FileWriter("./OUTPUT/REPORT3.TXT");
		for (int i = 0; i < result3.size(); i++) {
			fw3.write(result3.get(i)+"\n");
		}
		sc.close();
		br.close();
		fw.close();
		fw2.close();
		fw3.close();
		int[] grades = {89,90,50,87,89,66,89,77,89,90,90,90};
		GuessWhat(grades);
		String grades2 = "89#90#50#87#89#66#89#77#89#90#90#90";
		NumberArrange(grades2);
	}
	public static List<List<Integer>> NumberArrange(String grades) {
		String[] str = grades.split("#");
		Arrays.sort(str);
		int prev = 0, max = 0;
		ArrayList<Integer> nums = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < str.length; i++) {
			int num1 = Integer.parseInt(str[i].substring(0,1));
			int num2 = Integer.parseInt(str[i].substring(1,2));
			if(prev!=num1) {
				if(nums.size()>0) {
					result.add(nums);
					nums = new ArrayList<>();
				}
				nums.add(num1);
				nums.add(num2);
				prev = num1;
			} else {
				nums.add(num2);				
			}
		}
		result.add(nums);

		for(List<Integer> list:result) {
			max = Math.max(list.size(), max);
		}
		for(List<Integer> list:result) {
			while(list.size()<max) {
				list.add(-1);
			}
			Collections.reverse(list);
	        System.out.println(list.toString());

		}
		return result;
	}
	public static int GuessWhat(int[] grades) {
		int answer = 0;

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < grades.length; i++) {
			list.add(grades[i]);
		}
		
        System.out.println(list.toString());

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < grades.length; i++) {
			if(map.containsKey(grades[i])) {
				map.put(grades[i], map.get(grades[i])+1);
			} else {
				map.put(grades[i], 1);
			}
		}
        System.out.println(map);

		Collections.sort(list, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				int i1 = map.get(o1);
				int i2 = map.get(o2);
				int result = i2-i1;
				if(result == 0) {
					result = (int)o2-(int)o1;
				}
				return result;
			}
			
		});
        System.out.println(list);

		answer = list.get(0);
        System.out.println(answer);
		return answer;
	}
}
