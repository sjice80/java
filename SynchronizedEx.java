import java.io.*;
import java.util.*;
import java.security.MessageDigest;

class Address implements Comparable<Address> {
	String name;
	String phone;
	String email;
	public Address(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public int getPhone() {
		String[] str = phone.split("-");
		return Integer.parseInt(str[1]);
	}
	
	public int compareTo(Address o) {
		int result = this.getPhone()-o.getPhone();
		return result;
	}
	
}
class ATM implements Runnable {
	private long depositMoney = 10000;
	public void run() {
		synchronized(this) {
			for(int i=0; i<10; i++) {
				notify();
				try {
					wait();
//					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(getDepositMoney() <= 0) {
					break;
				}
				withDraw(1000);
			}
		}
	}

	public void withDraw(long howMuch) {
		if(getDepositMoney()>0) {
			depositMoney -= howMuch;
			System.out.print(Thread.currentThread().getName()+" , ");
			System.out.printf("잔액:%d원\n", getDepositMoney());
		} else {
			System.out.print(Thread.currentThread().getName()+" , ");
			System.out.println("잔액이 부족합니다.");
		}
	}
	public long getDepositMoney() {
		return depositMoney;
	}
}
public class SynchronizedEx {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*
		ATM atm = new ATM();
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");
		mother.start();
		son.start();
*/
		String input1 = "MISSISSIPPI";
		getAlphabetCount(input1);
		parseAddress("INPUT_EMAIL.TXT");
		String input2 = "2546744753663344466233679";
		countMaxNum(input2);
		int[] input3 = {7,2,4,7,1,3,7,7};
		seqSearch_dup(input3, 7);
		List<List<Integer>> input4 = Arrays.asList(
				Arrays.asList(23, 10, 33, 22, 31, 32, 29),
				Arrays.asList(13, 40, 74, 62, 31, 32, 29),
				Arrays.asList(31, 10, 13, 22, 11, 32, 29),
				Arrays.asList(23, 10, 13, 32, 31, 32, 99),
				Arrays.asList(53, 70, 73, 72, 31, 32, 29)
			);
		countTen(input4);
		parseAddressList("INPUT_EMAIL.TXT");
		parseAddressHashMap("INPUT_EMAIL.TXT");
		sabunSearch("./INFILE/input_gate.txt");
	}
	public static void sabunSearch(String input) throws IOException {
		String line = "";
		String[] gate = new String[100];
		int gate_cnt=0, i=0;
//		while(true) {
			Scanner sc = new Scanner(System.in);
			int sabun = sc.nextInt();
			FileReader f = new FileReader("./INFILE/input_gate.txt");
			BufferedReader br = new BufferedReader(f);
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
			for(i=0; i<gate_cnt-1; i++) {
				for(int j=i+1; j<gate_cnt; j++) {
					if(gate[i].equals(gate[j])==false) {
						
					} else {
						gate[i] = "";
					}
				}
				
			}
			for(i=0; i<gate_cnt; i++) {
				System.out.println("3:"+gate[i]);
			}
			sc.close();
			br.close();
//		}
	}
	public static List<String> sortByValue(final Map<String,String> map) {
        List<String> list = new ArrayList<>();
        list.addAll(map.keySet());
        Collections.sort(list,new Comparator() {
        public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable) v1).compareTo(v2);
            }
        });
        //Collections.reverse(list); // 주석시 내림차순
        return list;
    }

	public static void parseAddressHashMap(String file) throws IOException {
		FileReader ff = new FileReader("./INFILE/INPUT_EMAIL.txt");
		BufferedReader br = new BufferedReader(ff);
		String line="";
		HashMap<String,String> map = new HashMap<String,String>();
		while(true) {
			line = br.readLine();
			if(line!=null) {
				String[] str = line.split("#");
				map.put(str[0], str[1]);
			} else {
				break;
			}
		}
		TreeMap<String,String> tm = new TreeMap<String,String>(map);
		Iterator<String> itrKey = tm.keySet().iterator();
		while(itrKey.hasNext()) {
			String key = itrKey.next();
			System.out.println(key+","+tm.get(key));
		}
        Iterator it = sortByValue(map).iterator();
        System.out.println("------------sort 후 -------------");
        while(it.hasNext()) {
            String temp = (String) it.next();
            System.out.println(temp + " = " + map.get(temp));
        }
	}
	public static List<String> sortByMidPhoneNumber(List<String> input) {
		List<String> result = new ArrayList<>();
		for(int i=0; i<input.size()-1; i++) {
			for(int j=i+1; j<input.size(); j++) {
				String[] str1 = input.get(i).split("-");
				int mid = Integer.parseInt(str1[1]);
				String[] str2 = input.get(j).split("-");
				int mid2 = Integer.parseInt(str2[1]);
				if(mid > mid2) {
					String tmp = input.get(i);
					input.set(i, input.get(j));
					input.set(j, tmp);
				}
			}
		}
		result = input;
		System.out.println(result);
		return result;
	}
	public static void parseAddressList(String file) throws IOException {
		FileReader ff = new FileReader("./INFILE/INPUT_EMAIL.txt");
		BufferedReader br = new BufferedReader(ff);
		List<String> phone_list = new ArrayList<>();
		String line="";
		while(true) {
			line = br.readLine();
			if(line!=null) {
				phone_list = new ArrayList<>();
				String[] str = line.split("#");
//				email_list.add(str[0]);
				for(int i=0; i<str.length; i++) {
					if(str[i].contains("010")) {
						phone_list.add(str[i]);
					}
				}
//				email_list.add(str[str.length-1]);
				System.out.println(phone_list);
				sortByMidPhoneNumber(phone_list);
				
			} else {
				break;
			}
		}
		br.close();
	}
	public static List<List<Integer>> countTen(List<List<Integer>> input) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		int[] ten = new int[10];
		int[] ten_cnt = new int[10];
		int max=0, max_num=0;
		int k=0;
		for(int i=0; i<input.size(); i++) {
			Collections.sort(input.get(i));
			System.out.println();
			max=0; max_num=0;
			for(k=0; k<input.get(i).size(); k++) {
				ten[k] = input.get(i).get(k)/10;	
				System.out.print(ten[k]+", ");
			}
			System.out.println();
			for(k=0; k<input.get(i).size(); k++) {
				ten_cnt[ten[k]]++;
			}
			for(k=1; k<=9; k++) {
				System.out.print(ten_cnt[k]+", ");
				if(ten_cnt[k] > max) {
					max = ten_cnt[k];
					max_num = k;
				}
				ten_cnt[k] = 0;
			}
			System.out.println("제일 갯수 많은 숫자:"+max_num+", 갯수:"+max);
			list.add(k);	
			result.add(list);
		}
		return result;
	}
	public static ArrayList<Integer> seqSearch_dup(int[] array, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0; i<array.length; i++) {
			if(array[i] == k) {
				result.add(i);
			}
		}
		System.out.println(result);
		return result;
	}
	public static int countMaxNum(String input) {
		int num=0, max=0;
		int[] cnt_num = new int[10];
		for(int i=0; i<input.length(); i++) {
			for(int j=0; j<9; j++) {
				if(Integer.parseInt(input.substring(i, i+1)) == j+1) {
					cnt_num[j+1]++;
				}
			}
		}
		for(int i=1; i<=9; i++) {
			System.out.println("num:"+i+", cnt_num:"+cnt_num[i]);
			if(cnt_num[i] > max) {
				max = cnt_num[i];
				num = i;
			} else if(cnt_num[i] == max) {
				if(i < num) {
					num = i;
				}
			}
		}
		System.out.println("num:"+num+", cnt_num:"+max);
		return num;
	}

	public static void parseAddress(String file) throws IOException {
		FileReader ff = new FileReader("./INFILE/INPUT_EMAIL.txt");
		BufferedReader br = new BufferedReader(ff);
		String phone = "";
		int line_cnt=0;
		String[] phone_list = new String[10];
		String[] name_list = new String[10];
		String[] email_list = new String[10];
		while(true) {
			String line = br.readLine();
			phone = "";
			if(line!=null) {
				String[] strArr = line.split("#");
				name_list[line_cnt] = strArr[0];
				for(int i=0; i<strArr.length; i++) {
					if(strArr[i].contains("010")) {
						phone += strArr[i] + "#";
					}
				}
				email_list[line_cnt] = strArr[strArr.length-1];
				phone_list[line_cnt] = phone;
				System.out.println(name_list[line_cnt]+", "+phone_list[line_cnt]+", "+email_list[line_cnt]);
				line_cnt++;
			} else {
				break;
			}
		}
		int k=0;
		for(int i=0; i<phone_list.length; i++) {
//			phone_list[i] = phone_list[i].substring(0, phone_list[i].length()-1);
			if(phone_list[i]!=null) {
				String[] strPhone = phone_list[i].split("#");
				for(int j=0; j<strPhone.length-1; j++) {
					int min = j;
					for(k=j+1; k<strPhone.length; k++) {
						String[] phone_number = strPhone[min].split("-");
						int mid = Integer.parseInt(phone_number[1]);
						String[] phone_number2 = strPhone[k].split("-");
						int mid2 = Integer.parseInt(phone_number2[1]);
						if(mid > mid2) {
							min = k;
						}
					}
					String temp = strPhone[j];
					strPhone[j] = strPhone[min];
					strPhone[min] = temp;
				}
				for(int j=0; j<strPhone.length; j++) {
					System.out.println("정렬후:"+strPhone[j]+",");
				}
				System.out.println();
			}
		}
		File[] f_list = new File("./").listFiles();
		for(int i=0; i<f_list.length; i++) {
			System.out.println(f_list[i]);
		}
		br.close();
	}
	public static String getAlphabetCount(String input) {
		String result="";
		int cnt[] = new int[26];
		for(int i=0; i<input.length(); i++) {
//			for(int j=0; j<26; j++) {
				int idx = input.charAt(i) - 'A';
//				if(j == idx) {
					cnt[idx]++;
//				}
//			}
		}
		for(int i=0; i<26; i++) {
			if(cnt[i]!=0) {
				char ch = (char)(i+'A');
				result += String.valueOf(ch)+cnt[i];
			}
		}
		/*
		for(int i=0; i<input.length(); i++) {
			int idx = input.charAt(i) - 'A';
			if(!result.contains(String.valueOf(input.charAt(i)))) {
				result += String.valueOf(input.charAt(i)) + String.valueOf(cnt[idx]);
			}
		}
		*/
		System.out.println(result);
		return result;
	}
}

