import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Schedule implements Comparable<Schedule> {
	String id;
	String start;
	String end;
	String place;
	public Schedule(String line) {
		this.id = line.split(" ")[0];
		this.start = line.split(" ")[1];
		this.end = line.split(" ")[2];
		this.place = line.split(" ")[3];
	}
	@Override
	public int compareTo(Schedule o) {
		// TODO Auto-generated method stub
		int result = this.id.compareTo(o.id);
		if(result == 0) {
			result = this.start.compareTo(o.start);
		} else if(result == 0) {
			result = this.end.compareTo(o.end);
		} else if(result == 0) {
			result = this.place.compareTo(o.place);
		}
		return result;
	}
	public String toString() {
		return this.id+","+this.start+","+this.end+","+this.place+"\n";
	}
}	

public class Covid {
	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		/*
		int[] arr = {1,2,3,4};
		perm(arr, 0);
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list);
		System.out.println(list);
		*/
		FileReader fr = new FileReader("./INFILE/SAMPLE.TXT");
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		ArrayList<Schedule> list = new ArrayList<>();
		while((line = br.readLine()) != null) {
			Schedule sc = new Schedule(line);
			list.add(sc);
			System.out.print(sc.toString());

		}
		Collections.sort(list);
		System.out.println(list.toString());
		Scanner scan = new Scanner(System.in);
		String id = scan.nextLine();
		FileWriter fw = new FileWriter("./OUTFILE/"+id+".TXT");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		for (int i = 0; i < list.size(); i++) {
			if(id.equals(list.get(i).id)) {
				long diff = (sdf.parse(list.get(i).end).getTime() - sdf.parse(list.get(i).start).getTime())/(1000*60);
				System.out.println("차이:"+diff);
				fw.write(list.get(i).toString());
			}
		}
		fw.close();
		br.close();
		fr.close();
		scan.close();
		
		/*
		int[][] inputAry = {{1, 1, 1, 0, 0, 0, 0, 1, 1, 1},
							{1, 1, 1, 1, 0, 0, 0, 0, 1, 1},
							{1, 0, 1, 1, 0, 0, 0, 0, 1, 1},
							{0, 0, 1, 1, 1, 0, 0, 0, 0, 1},
							{0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							{0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
							{0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
		landCount(inputAry);
		String sample = "HHAAAATTCGVVTXXY";
		stringMixing(sample);
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		changeWords(begin, target, words);
		*/
	}
    public static int changeWords(String begin, String target, String[] words) {
        int answer = 0;
        int min = words.length+1;
        min = dfs_changeWords(begin, target, words, new boolean[words.length], 0, words.length+1, words.length);    
        answer = min==words.length+1?0:min;
        System.out.println("changeWords:"+answer);
        return answer;
    }
    public static int dfs_changeWords(String word, String target, String[] words, boolean[] visited, int n, int min, int max) {
    	for (int i = 0; i < words.length; i++) {
			if(!visited[i] && conversion(word, words[i])) {
				System.out.println(n + " " + min + " " + word + " " + words[i]);
				if(words[i].equals(target)) {
					System.out.println("dfs_changeWords:"+Math.min(min, n+1));
					return Math.min(min, n+1);
				}
				visited[i] = true;
				int num = dfs_changeWords(words[i], target, words, visited, n+1, min, max);
				if(num<min) {
					min = num;
				}
				visited[i] = true;
			}
		}
    	return min;
    }
    public static boolean conversion(String s1, String s2) {
    	int tmp = 0;
    	for (int i = 0; i < s1.length(); i++) {
    		if(s1.charAt(i)!=s2.charAt(i)) {
    			tmp++;
    			if(tmp>1) return false;
    		}
		}
    	return true;
    }
	public static String stringMixing(String sample) {
		String answer = "";
		String tmp1 = "", tmp2 = "", str = "";
		ArrayList<String> s1 = new ArrayList<>();
		for (int i = 0; i < sample.length(); i++) {
			str += sample.charAt(i);
			if(i>=sample.length()-1) {
				s1.add(str);
				break;
			}
			if(sample.charAt(i) != sample.charAt(i+1)) {
				s1.add(str);
				str = "";
			}
		}
		System.out.println(s1);
		for (int i = 0; i < s1.size(); i++) {
			if(s1.get(i).length()%2 == 0) {
				tmp1 += s1.get(i).substring(0, s1.get(i).length()/2);
				tmp2 = s1.get(i).substring(s1.get(i).length()/2) + tmp2;
			} else {
				tmp1 += s1.get(i);
			}
		}
		answer = tmp1 + tmp2;
		System.out.println("stringMixing:"+answer);
		
		return answer;
	}
	public static int landCount(int[][] inputAry) {
		int answer = 0;
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		ArrayList<String> tmp = new ArrayList<>();
		for (int i = 0; i < inputAry.length; i++) {
			for (int j = 0; j < inputAry[0].length; j++) {
				if(inputAry[i][j] == 1) {
					tmp = new ArrayList<>();
					result.add(tmp);
					checkPosition(inputAry, i, j, tmp);
				}
			}
		}
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		answer = result.size();
		System.out.println("landCount:"+answer);
		return answer;
	}
	public static void checkPosition(int[][] inputAry, int i, int j, ArrayList<String> temp) {
		inputAry[i][j] = 0;
		temp.add(i+","+j);
		int[] dx = {0,1,0,-1};
		int[] dy = {-1,0,1,0};
		for (int k = 0; k < 4; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			if(x>=0 && x<inputAry.length && y>=0 && y<inputAry[0].length) {
				if(inputAry[x][y] == 1) {
					checkPosition(inputAry, x, y, temp);
				}
			}
		}
	}
	public static void perm(int[] arr, int pivot) {
		for (int i = pivot; i < arr.length; i++) {
			swap(arr, i, pivot);
			set.add(Arrays.toString(arr));
			perm(arr, pivot+1);
			swap(arr, i, pivot);
		}
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
