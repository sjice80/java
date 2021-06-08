import java.util.*;
import java.io.*;

public class cos1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] switches = {2,3,4};
		cntLamp(8, switches);
		int[] buses = {1734, 1120, 1120};
		transferFare(buses);
		int[] buses2 = {1234, 1125, 1126};
		transferFare(buses2);
		int[] buses3 = {1734, 1120, 1120, };
		transferFare(buses3);
		int[] blocks = {1,1,2,3,3,2,2};
		cntFile(blocks);
		makeSubString("tour");
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}; //{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}; //{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right"; //"left"; //right";
		keypadTouch(numbers, hand);
		String new_id = "...!@BaT#*..y.abcdefghijklm";//"=.=";////"abcdefghijklmn.p"; //// // //
		recommendId(new_id);
/*		
		ArrayList<String> cmd = new ArrayList<>();
		cmd.add("cmd.exe");
		cmd.add("/c");
		cmd.add("ping google.com");
//		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "ping google.com");
		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "echo hello");
		
//		ProcessBuilder pb = new ProcessBuilder(cmd);
		Process p = pb.start();
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		while((line = br.readLine())!=null) {
			System.out.println(line);
		}
		*/
		
		try {
//			String cmd = "./SIGNAGE.EXE";
//			Process p = Runtime.getRuntime().exec("echo hello");
			String file = "./SAMPLE.TXT";
			BufferedWriter bw = null;// = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = "";//br.readLine();
			FileWriter fw = new FileWriter("./OUTFILE.TXT");
			while((s=br.readLine())!=null) {
				String str = "echo " + s;
				Process p = Runtime.getRuntime().exec(str);
//				bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
//				bw.write(s);
//				s = br.readLine();
				BufferedReader br2 = new BufferedReader(new InputStreamReader(p.getInputStream()));
				fw.write(br2.readLine()+"\n");
//				System.out.println(br2.readLine());

			}
			fw.flush();
			
		} catch(IOException ioe) {
			System.out.println(ioe);
		}
		
	}
	
	public static String recommendId(String new_id) {
        String answer = "", new_tmp = "";
        char prev = '.';
        int cnt = 0;
        new_id = new_id.toLowerCase();
        for (int i = 0; i < new_id.length(); i++) {
        	char ch = new_id.charAt(i);
        	answer = new_id.replaceAll("[^0-9A-Za-z-_.]", "");
		}
		System.out.println("1. recommendId: "+answer);

        for (int i = 0; i < answer.length(); i++) {
        	char ch = answer.charAt(i);
        	if(ch == '.') {
        		cnt++;  
        	} else {
        		if(cnt>= 1) {
        			new_tmp = new_tmp + prev + ch; 
        			cnt = 0;
        		} else {
        			new_tmp += ch;
        		}
        	}
        	prev = ch;
        		
        }
        if(new_tmp.length() == 0) {
        	new_tmp = "a";
        }
		System.out.println("2. recommendId: "+new_tmp);

        new_tmp = new_tmp.replaceAll("^[.]|[.]$", "");
		System.out.println("3. recommendId: "+new_tmp);

        /*
        if(new_tmp.charAt(0) == '.') {
        	new_tmp = new_tmp.substring(1);
        }
        if(new_tmp.charAt(new_tmp.length()-1) == '.') {
        	new_tmp = new_tmp.substring(0,new_tmp.length()-1);
        }
*/
        if(new_tmp.length() >= 16) {
        	new_tmp = new_tmp.substring(0,15);
//    		System.out.println("1. recommendId: "+new_tmp);
        }
        if(new_tmp.charAt(new_tmp.length()-1) == '.') {
        	new_tmp = new_tmp.substring(0,new_tmp.length()-1);
        }
        if(new_tmp.length()<=2) {
        	int len = new_tmp.length();
        	for (int i = 0; i < 3-len; i++) {
				new_tmp += new_tmp.charAt(new_tmp.length()-1); 
			}
        }
        answer = new_tmp;
		System.out.println("recommendId: "+new_tmp);
        return answer;
    }
	public static int dist(char[][] keypad, char prev, char curr) {
        int a=0, b=0, c=0, d=0;
        for(int m=0; m<4; m++) {
            for(int n=0; n<3; n++) {
                if(prev == keypad[m][n]) {
                    a = m;
                    b = n;
            		System.out.println("dist prev: "+prev);
               }
                if(curr == keypad[m][n]) {
                    c = m;
                    d = n;
            		System.out.println("dist curr: "+curr);
               }
            }
        }
		System.out.println("dist answer: "+(Math.abs(a-c)+Math.abs(b-d)));
        return Math.abs(a-c)+Math.abs(b-d);
    }
    public static String keypadTouch(int[] numbers, String hand) {
        String answer = "";
        char[][] keypad = {{'1','2','3'},
                           {'4','5','6'},
                           {'7','8','9'},
                           {'*','0','#'}};
        char prev_l = '*', prev_r = '#';
        for(int i=0; i<numbers.length; i++) {
        	char ch = (char)(numbers[i]+'0');
    		System.out.println("0. keypadTouch answer: "+ch);
            if(ch == '1' || ch == '4' || ch == '7' ) {
                answer += "L";
                prev_l = ch;
        		System.out.println("1. keypadTouch answer: "+ch);
           } else if(ch == '3' || ch == '6' || ch == '9' ) {
                answer += "R";
                prev_r = ch; 
        		System.out.println("2. keypadTouch answer: "+ch);
           } else {
                if(dist(keypad, prev_l, ch) > 
                   dist(keypad, prev_r, ch)) {
                    answer += "R";
                    prev_r = ch;
            		System.out.println("3. keypadTouch answer: "+answer);
                } else if(dist(keypad, prev_l, ch) < 
                   dist(keypad, prev_r, ch)) {
                    answer += "L";
                    prev_l = ch;
            		System.out.println("4. keypadTouch answer: "+answer);
                } else {
                    if(hand.equals("left")) {
                        answer += "L";
                        prev_l = ch;
                		System.out.println("5. keypadTouch answer: "+answer);
                   } else {
                        answer += "R";
                        prev_r = ch;
                		System.out.println("6. keypadTouch answer: "+answer);
                   }
                }
            }
        }
		System.out.println("keypadTouch answer: "+answer);

        return answer;
    }
	public static List<String> makeSubString(String text) {
		List<String> list = new ArrayList<>();
		List<String> result = new ArrayList<>();
		list = prefix(text);
		for (int i = 0; i < list.size(); i++) {
			result.addAll(postfix(list.get(i)));
			System.out.println("makeSubString list:"+result);
		}

		Collections.sort(result);
		System.out.println("makeSubString result"+result);
		return result;		
	}
	public static List<String> prefix(String text) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < text.length(); i++) {
			list.add(text.substring(0, i+1));
		}
		System.out.println("prefix list:"+list);

		return list;
	}
	public static List<String> postfix(String text) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < text.length(); i++) {
			list.add(text.substring(i));
		}
		System.out.println("postfix list:"+list);

		return list;
	}
	public static int cntFile(int[] blocks) {
		int answer = 1;
		int prev = blocks[0];
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(prev);
		for (int i = 1; i < blocks.length; i++) {			
			if(prev == blocks[i]) {
				list.add(blocks[i]);
				System.out.println("list:"+list+", map:"+map);
			} else {
				if(map.containsKey(prev)) {
					answer++;
				} 
				map.put(prev, list);
				list = new ArrayList<>();
				list.add(blocks[i]);
				prev = blocks[i];
				System.out.println("list:"+list+", map:"+map);
			}

		}
		if(map.containsKey(prev)) {
			answer++;
		} 
		list.add(prev);
		map.put(prev, list);
		System.out.println("cntFile:"+answer+", map:"+map);

		return answer;
	}
	public static int transferFare(int[] buses) {
		int answer = 1000;
		int prev = buses[0], cnt = 0;
		for (int i = 1; i < buses.length; i++) {
			if(prev != buses[i]) {
				if(cnt>4) {
					answer += 1000;
					cnt = 0;
				} 
			} else {
				answer += 1000;
			}
			prev = buses[i];
			cnt++;
		}
		System.out.println("transferFare:"+answer);

		return answer;
	}
	public static int cntLamp(int n, int[] switches) {
		int answer = 0;
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			map.put(i, false);
		}
		System.out.println("1."+map);
	
		for (int j = 0; j < switches.length; j++) {
			for (int i = 1; i <= n; i++) {
				if(i%switches[j] == 0) {
					if(map.get(i)==true) {
						map.replace(i, false);
						System.out.println("2."+map);
					} else {
						map.replace(i, true);
						System.out.println("3."+map);
					}
				}
			}
		}
		for (int i = 1; i <= map.size(); i++) {
			if(map.get(i)==true) {
				answer++;
			}
		}
//		System.out.println("4."+map);
		System.out.println("cntLamp answer:"+answer);
		
		return answer;
	}
}
