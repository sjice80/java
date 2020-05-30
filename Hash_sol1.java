import java.util.*;
class Disk implements Comparable<Disk> {
    int index;
	int delayTime;
	public Disk(int index, int delayTime) {
		this.index = index;
		this.delayTime = delayTime;
	}
    public int compareTo(Disk o1) {
    	if(this.delayTime > o1.delayTime) {
    		return 1;
    	} else if(this.delayTime < o1.delayTime) {
    		return -1;
    	} else {
    		return 0;
    	}
    		
    }
}
class Squre {
	String x;
	String y;
	public Squre(String x, String y) {
		this.x = x;
		this.y = y;
 	}
	public String toString() {
		return x+","+y;
	}
}
class Loc {
	int x;
	int y;
	public Loc(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
/*
using namespace std;
struct _d { char c; int y, x; };
struct _q { int y, x, d; };
bool operator<(const _d& a, const _d& b) {
    return a.c < b.c;
}
string solution(int m, int n, vector<string> board) {
    string answer = "";
    int i, j, bef, aft, dy[] = { 0,1,0,-1 }, dx[] = { 1,0,-1,0 }, matched, vi[100][100][4], chk[26] = {};
    queue<_q> q;
    set<_d> list;
    for (i = 0; i < m; i++) for (j = 0; j < n; j++)
        if ('A' <= board[i][j] && board[i][j] <= 'Z') {
            list.insert(_d{ board[i][j],i,j });
            chk[board[i][j] - 'A'] = 1;
        }
 
    do {
        bef = (int)list.size();
        for (auto it = list.begin(); it != list.end();it++) {
            memset(vi, 0x7F, sizeof vi);
            while (!q.empty()) q.pop();
 
            for (i = 0; i<4; i++) {
                vi[it->y][it->x][i] = 0;
                q.push(_q{ it->y, it->x, i });
            }
            matched = 0;
            while (!q.empty() && !matched) {
                _q u = q.front(); q.pop();
                for (i = 0; i<4; i++) {
                    int ty = u.y + dy[i], tx = u.x + dx[i], used = i != u.d;
                    if (0 <= ty && ty < m && 0 <= tx && tx < n && vi[u.y][u.x][u.d] + used < 2 && vi[ty][tx][i] > vi[u.y][u.x][u.d] + used && board[ty][tx] != '*' && (board[ty][tx] == '.' || board[ty][tx] == it->c)) {
                        vi[ty][tx][i] = vi[u.y][u.x][u.d] + used;
                        q.push(_q{ ty,tx,i });
                        if (board[ty][tx] == it->c) {
                            matched = 1;
                            board[it->y][it->x] = board[ty][tx] = '.';
                        }
                    }
                }
            }
            if (matched) {
                answer += it->c;
                list.erase(it);
                break;
            }
        }
        aft = (int)list.size();
    } while (bef != aft);
    if (!list.empty()) answer = "IMPOSSIBLE";
    return answer;
}
*/
/*
int arr[110][110];
vector<pair<int, int> > pos['Z' + 5];
// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
 
bool able(char ch)
{
    if(pos[ch].empty()) return false;
    int x = pos[ch][0].first;
    int y = pos[ch][0].second;
    int nx = pos[ch][1].first;
    int ny = pos[ch][1].second;
    int a = x, b = y;
    bool flag = true;
    while(flag && a != nx){
        if(a > nx) a--;
        else if(a < nx) a++;
        if(a != nx || b != ny){
            if(arr[a][b] != '.') flag = false;
        }
    }
    while(flag && b != ny){
        if(b > ny) b--;
        else if(b < ny) b++;
        if(a != nx || b != ny){
            if(arr[a][b] != '.') flag = false;
        }
    }
    if(flag) return true;
    flag = true; a = x; b = y;
    while(flag && b != ny){
        if(b > ny) b--;
        else if(b < ny) b++;
        if(a != nx || b != ny){
            if(arr[a][b] != '.') flag = false;
        }
    }
    while(flag && a != nx){
        if(a > nx) a--;
        else if(a < nx) a++;
        if(a != nx || b != ny){
            if(arr[a][b] != '.') flag = false;
        }
    }
    if(flag) return true;
    return false;
}
 
string solution(int m, int n, vector<string> board) {
    for(int i=0;i<'Z'+5;i++) pos[i].clear();
    memset(arr, -1, sizeof(arr));
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            arr[i][j] = board[i][j];
            if('A' <= arr[i][j] && arr[i][j] <= 'Z'){
                pos[arr[i][j]].push_back(make_pair(i, j));
            }
        }
    }
    bool flag = true;
    string answer = "";
    while(flag)
    {
        flag = false;
        for(int i='A';i<='Z';i++){
            flag = able(i);
            if(flag) {
                arr[pos[i][0].first][pos[i][0].second] = '.';
                arr[pos[i][1].first][pos[i][1].second] = '.';
                pos[i].clear();
                answer += i; break;
            }
        }
    }
    
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(arr[i][j] != '.' && arr[i][j] != '*') return "IMPOSSIBLE";
        }        
    }
  
    return answer;
}


출처: https://wwiiiii.tistory.com/entry/카카오-Code-Festival-본선-16번-풀이 [기리이이이인]
 */
public class Hash_sol1 {

	static int n;
	static boolean stop = false;
    static Loc[] loc1 = new Loc['Z'];
    static Loc[] loc2 = new Loc['Z'];
    static char arr[][];// = new char[110][110];
    static char visited[][];
    static String temp = "";
    static String temp2 = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] participant = {"mislav", "stanko", "mislav", "ana"}; //{"marina", "josipa", "nikola", "vinko", "filipa"}; //{"leo", "kiki", "eden"};
		String[] completion = {"stanko", "ana", "mislav"}; //{"josipa", "filipa", "marina", "nikola"}; //{"eden", "kiki"};
		solution2(participant, completion);
		String[] phone_book = {"12","123","1235","567","88"}; //{"123","456","789"}; //{"119", "97674223", "1195524421"};
		solution3(phone_book);
		//String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		solution4(clothes);
		int[] priorities = {1,1,9,1,1,1};	//{2,1,3,2};
		solution5(priorities, 0);
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		solution6(progresses, speeds);
		int[] heights = {3,9,9,3,5,7,2}; //{6,9,5,7,4};
		solution7(heights);
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		solution8(genres, plays);
		String[] strings = {"sun", "bed", "car"};
		solution9(strings, 1);
		int[] arr10 = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		solution10(arr10, commands);
		int[] numbers = {3, 30, 34, 5, 9};
		solution11(numbers);
		int[] prices = {1, 2, 3, 2, 3};
		solution12(prices);
		//int[][] v = {{1, 4}, {3, 4}, {3, 10}};
		int[][] v = {{1, 1}, {2, 2}, {1, 2}};
		solution13(v);
		solution14(100, 300);
		int[] arr15 = {4,1,3,2};
		solution15(arr15);
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		solution16(skill, skill_trees);
		String s17 = "abacde"; //"abcdcba";
		solution17(s17);
		int[] citations = {3,0,6,1,5};
		solution18(citations);
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
//		solution19(jobs);
		//{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}; //{"I 7","I 5","I -5","D -1"};
		solution20(operations);
		solution21(626331);
		String str22 = "1 2 3 4";
		solution22(str22);
		String[][] clothes2 = {{"yellow_hat,headgear"}, 
								{"blue_sunglasses,eyewear"}, 
								{"green_turban,headgear"}};
		solution23(clothes2);
		int[][] picture = {{1, 1, 1, 0}, 
						   {1, 2, 2, 0}, 
						   {1, 0, 0, 1}, 
						   {0, 0, 0, 1}, 
						   {0, 0, 0, 3}, 
						   {0, 0, 0, 3}};
		solution24(6,4,picture);
		
		String str1 = "E=M*C^2"; //"handshake"; //"aa1+aa2"; // //"FRANCE";
		String str2 = "e=m*c^2"; //"shake hands";//"AAAA12"; // //"french"; //	16384
		solution25(str1, str2);
		solution26(2,4,2,1);
		/*
		 handshake	shake hands	65536
		 aa1+aa2	AAAA12	43690
		 E=M*C^2	e=m*c^2	65536
		 */
		int[] nums = {1,2,3,4}; //{1,2,7,6,4};
		solution27(nums);
		// String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};	//3  ->3,3
		// 5
		// String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}; //0,0
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"}; //1,3
		// 2
		solution28(2, words);
		int[] arr29 = {2,6,8,14};	//168
		solution29(arr29);
		int[] priorities30 = {1, 1, 9, 1, 1, 1};
		solution30(priorities30, 0);
		/*
		 * m	n	board	answer
		   3	3	[DBA, C*A, CDB]	ABCD
		   2	4	[NRYN, ARYA]	RYAN
		   4	4	[.ZI., M.**, MZU., .IU.]	MUZI
		   2	2	[AB, BA]	IMPOSSIBLE
		 */
		//String[] board = {"NRYN", "ARYA"};
		//String[] board = {".ZI.", "M.**", "MZU.", ".IU."};
		String[] board = {"DBA", "C*A", "CDB"};
		//String[] board = {"AB", "BA"}; 
//		solution31(board.length,board[0].length(),board);
	}
	public static int bottom(char[][] board, int x, int y, char ch1) {
		int flag = 0;
		int org_x = x;
		int org_y = y;
		while(flag==0 && x<board.length-1) {
			x++;
			if(ch1 == board[x][y] && ch1 != '.') {
				System.out.println("bottom 일치");
				temp2 += ch1;
				arr[x][y] = '.';
				return 1; // 일치
			} else if(board[x][y] == '.') {
				System.out.println("bottom '.'"+", x:"+x+", y:"+y);
				flag = 0; // .으로 끝남. y>=0이면 right 계속 진행. y<=length-1이면 left 계속 진행
				continue;
			} else if(board[x][y] == '*') {
				System.out.println("bottom '*'"+", x:"+x+", y:"+y);
				return 3; // x=0 -> y+1 -> x++
			} else {
				System.out.println("bottom 아무것도 아님");
				return 4;
			}
		}
		  if(flag == 0) {
			  System.out.println("ssss");
				if(ch1 == board[x][y] && org_x!=x && ch1!='.') {
					System.out.println("111. bottom 일치"+", org_x:"+org_x+", org_y:"+org_y+", ch1:"+ch1);
					temp2 += ch1;
					arr[org_x][org_y] = '.';
					arr[x][y] = '.';
					return 1; // 일치
				}
			  int result = right(arr, x, y,ch1);
			  System.out.println("result:"+result+", x:"+x+", y:"+y+", ch1:"+ch1);
			  if(result == 1) {
				  arr[org_x][org_y] = '.';
				  arr[x][y] = '.';	  					
				  System.out.println("111. right. temp2:"+temp2);
				  return 1;
			  }
		  }
		return flag;
	}
	public static int up(char[][] board, int x, int y, char ch1) {
		int flag = 0;
//		char ch = board[x][y];
		while(flag==0 && x>0) {
			x--;
			if(ch1 == board[x][y]) {
				arr[x][y] = '.';
				return 1; // 일치
			} else if(board[x][y] == '.') {
				flag = 0; // .으로 끝남. y>=0이면 right 계속 진행. y<=length-1이면 left 계속 진행
				continue;
			} else if(board[x][y] == '*') {
				return 3; // x=0 -> y+1 -> x++
			} else {
				return 4;
			}
		}
		return flag;
	}
	public static int right(char[][] board, int x, int y, char ch1) {
		int flag = 0;
		int org_x = x;
		int org_y = y;
//		char ch = board[x][y];
		while(flag==0 && y<board[0].length-1) {
			y++;
			if(ch1 == board[x][y] && ch1!='.') {
				System.out.println("right 일치:"+board[x][y]+", ch1:"+ch1);
				temp2 += arr[x][y];
				arr[x][y] = '.';				
				return 1; // 일치
			} else if(board[x][y] == '.') {
				flag = 0; // .으로 끝남. y>=0이면 right 계속 진행. y<=length-1이면 left 계속 진행
				continue;
			} else if(board[x][y] == '*') {
				return 3; // x=0 -> y+1 -> x++
			} else {
				System.out.println("right:"+board[x][y]+", ch1:"+ch1);
				return 4;
			}
		}
		  if(flag == 0) {
			  System.out.println("tttt");
				if(ch1 == board[x][y]) {
					System.out.println("222. right 일치"+", org_x:"+org_x+", org_y:"+org_y+", ch1:"+ch1);
					temp2 += ch1;
					arr[org_x][org_y] = '.';
					arr[x][y] = '.';
					return 1; // 일치
				}
			  int result = bottom(arr, x, y,ch1);
			  System.out.println("result:"+result+", x:"+x+", y:"+y+", ch1:"+ch1);
			  if(result == 1) {
				  arr[org_x][org_y] = '.';
				  arr[x][y] = '.';	  					
				  System.out.println("222. right. temp2:"+temp2);
				  return 1;
			  }
		  }
		return flag;
	}
	public static int left(char[][] board, int x, int y, char ch1) {
		int flag = 0;
		int org_x = x;
		int org_y = y;
//		char ch = board[x][y];
		while(flag==0 && y>0) {
			y--;
			if(ch1 == board[x][y] && board[x][y] != '.') {
				System.out.println("left 일치:"+board[x][y]+", ch1:"+ch1);
				temp2 += arr[x][y];
				arr[x][y] = '.';
				return 1; // 일치
			} else if(board[x][y] == '.') {
				flag = 0; // .으로 끝남. y>=0이면 right 계속 진행. y<=length-1이면 left 계속 진행
				continue;
			} else if(board[x][y] == '*') {
				return 3; // x=0 -> y+1 -> x++
			} else {
				return 4;
			}
		}
		if(flag == 0) {
			  System.out.println("kkkkk");
				if(ch1 == board[x][y] && board[x][y] != '.') {
					System.out.println("222. left 일치"+", org_x:"+org_x+", org_y:"+org_y+", ch1:"+ch1);
					temp2 += ch1;
					arr[org_x][org_y] = '.';
					arr[x][y] = '.';
					return 1; // 일치
				}
			  int result = bottom(arr, x, y,ch1);
			  System.out.println("tt. result:"+result+", x:"+x+", y:"+y+", ch1:"+ch1);
			  if(result == 1) {
				  arr[org_x][org_y] = '.';
				  arr[x][y] = '.';	  					
				  System.out.println("222. left. temp2:"+temp2);
				  return 1;
			  }
		  }
		return flag;
	}
	/*
	  public static String solution31(int m, int n, String[] board) {
	      String answer = "";
	      arr = new char[board.length][board[0].length()];
	      
	      for(int i=0; i<m; i++) {
	    	  for(int j=0; j<n; j++) {
	    	      arr[i][j] = board[i].charAt(j); 
	    	  }
	      }
	      for(int i=0; i<m; i++) {
	    	  for(int j=0; j<n; j++) {
	    		  if('A'<=arr[i][j] && arr[i][j]<='Z') {
	    	    	  if(checkSame(arr, i, j) == true) {
	    	    		  System.out.println("1. temp:"+temp);
	    	    	  }	
	    		  } 
	    	  }
	      }

	      for(int i=0;i<m;i++){
	          for(int j=0;j<n;j++){
	        	  System.out.print(arr[i][j]+" ");	        	  
	          }    
	          System.out.println();
	      }
	      if(temp.length() == 0) {
	    	  System.out.println("IMPOSSIBLE");
	    	  return "IMPOSSIBLE";
	      }
	      for(int i=0; i<m; i++) {
	    	  for(int j=0; j<n; j++) {
	    		  if(('A'<=arr[i][j] && arr[i][j]<='Z') ) {
	    			  System.out.println("arr[i][j]:"+arr[i][j]);
	    			  System.out.println("i:"+i);
	    			  System.out.println("j:"+j);
	    			  int result = bottom(arr, i, j, arr[i][j]);
	    			  System.out.println("result:"+result);
	    			  if(result == 1) {
	  					  arr[i][j] = '.';	  					
	    				  System.out.println("bottom. temp2:"+temp2);
	    			  }
	    			  if(result == 0) {
		    			  if(right(arr, i, j, arr[i][j]) == 1) {
//		    				  temp2 += arr[i][j];
		  					  arr[i][j] = '.';	  					
		    				  System.out.println("right. temp2:"+temp2);
		    			  }
		    			  if(left(arr, i, j, arr[i][j]) == 1) {
		    				  temp2 += arr[i][j];
		  					  arr[i][j] = '.';	  					
		    				  System.out.println("left. temp2:"+temp2);
		    			  }
	    			  }
	    			  if(result == 3) {
	    				  System.out.println("33333"+", i:"+i+", j:"+j);	    				  
	    				  if(right(arr, i, j, arr[i][j]) == 0) {
	    					  System.out.println("77777"+", i:"+i+", j:"+j);  					
		    				  System.out.println("bottom. temp2:"+temp2);
		    			  }	
	    				  if(left(arr, i, j, arr[i][j]) == 0) {
	    					  System.out.println("88888"+", i:"+i+", j:"+j);  					
		    				  System.out.println("bottom. temp2:"+temp2);
		    			  }	
	    			  }
	    			  if(result == 4) {
	    				  System.out.println("55555"+", i:"+i+", j:"+j);	    				  
	    				  if(right(arr, i, j, arr[i][j]) == 0) {
	    					  System.out.println("44444"+", i:"+i+", j:"+j);  					
		    				  System.out.println("66666. temp2:"+temp2);
		    			  }		    			  				  
	    			  }
	    		  } 
	    	  }
	      }

	      
	      char[] temp3 = temp.toCharArray();
	      Arrays.sort(temp3);
	      for(int i=0; i<temp3.length; i++) {
	    	  answer += temp3[i];
	      }
	      char[] temp4 = temp2.toCharArray();
//	      Arrays.sort(temp4);
	      for(int i=0; i<temp4.length; i++) {
	    	  answer += temp4[i];
	      }
//	      answer = Arrays.toString(temp2);
	      System.out.println("최종:"+answer);
	      return answer;
	  }
	  */
	public static boolean able(char ch) {
//	    if(pos[ch].empty()) return false;
	    int x = loc1[ch].x;
	    System.out.println("x:"+x);
	    int y = loc1[ch].y;
	    System.out.println("y:"+y);
	    int nx = loc2[ch].x;
	    System.out.println("nx:"+nx);
	    int ny = loc2[ch].y;
	    System.out.println("ny:"+ny);
	    int a = x, b = y;
	    System.out.println("a:"+a);
	    System.out.println("b:"+b);
	    boolean flag = true;
	    while(flag && a != nx) {
	        if(a > nx) { 
	        	System.out.println("a--:");
	        	a--;
	        }
	        else if(a < nx) { 
	        	System.out.println("a++:");
	        	a++;
	        }
	        if(a != nx || b != ny) {
	            if(arr[a][b] != '.') {
	            	System.out.println("false:");
	            	flag = false;
	            }
	        }
	    }
	    while(flag && b != ny){
	        if(b > ny) b--;
	        else if(b < ny) b++;
	        if(a != nx || b != ny){
	            if(arr[a][b] != '.') flag = false;
	        }
	    }
	    if(flag) {
	    	System.out.println("flag:true  "+flag);
	    	return true;
	    }
	    System.out.println("flag:false  "+flag);
	    System.out.println("x:"+x);
	    return false;
	}
	public static boolean checkSame(char[][] board, int x, int y, int n) {
		int[] dx = {n,0,-n,0};
		int[] dy = {0,n,0,-n};
		for(int i=0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if(xx>=0 && xx<board.length && yy>= 0 && yy<board[0].length) {
				if(board[x][y] == board[xx][yy]) {
					System.out.println("0. ch:"+board[x][y]);	
					temp += board[x][y];
					arr[x][y] = '.';
					arr[xx][yy] = '.';
					System.out.println("0. x:"+x);	
					System.out.println("0. y:"+y);
					System.out.println("0. xx:"+xx);	
					System.out.println("0. yy:"+yy);
					
					return true;
				}				
			}

		}
		return false;
	}
	
	public static boolean checkGo(char[][] board, int x, int y) {
		char ch = 'A';
		if(board[x][y] != '.') {
			ch = board[x][y];
//			visited[x][y] = 1;
		}
		int a = x;
		int b = y;
		boolean flag = true;
		boolean flag2 = false;
		System.out.println("1. ch:"+ch);
//		System.out.println("1. board.length:"+board.length);
//		while(flag2 == false) {
			while(flag==true && x<board.length-1) {
				x++;
				if(ch == board[x][y] /*&& visited[x][y] == 0*/) {
					temp2 += board[x][y];
					arr[x][y] = '.';
					arr[a][b] = '.';
//					visited[x][y] = 1;
//					visited[a][b] = 1;
					System.out.println("2. board[x][y]:"+board[x][y]);
					return true;
				
				} else if(board[x][y] == '.') {
					System.out.println("3. board[x][y]:"+board[x][y]);
					continue;
				} else if(board[x][y] == '*') {
					System.out.println("4. board[x][y]:"+board[x][y]);
					x--;
					break;
				} else {
					System.out.println("5. board[x][y]:"+board[x][y]);
					return false;
				}
			}
			while(flag==true && y<board[0].length-1) {
				y++;
				if(ch == board[x][y] /*&& visited[x][y] == 0*/) {
					temp2 += board[x][y];
					arr[x][y] = '.';
					arr[a][b] = '.';
//					visited[x][y] = 1;
//					visited[a][b] = 1;
					System.out.println("5. board[x][y]:"+board[x][y]);
					return true;
				} else if(board[x][y] == '.') {
					System.out.println("6. board[x][y]:"+board[x][y]);
					continue;
				} else if(board[x][y] == '*') {
					System.out.println("4-1. board[x][y]:"+board[x][y]);
					y--;
					break;
				} else {
					System.out.println("7. board[x][y]:"+board[x][y]);
					return false;
				}
			}
			while(flag==true && x>0) {
				x--;
				if(ch == board[x][y] /*&& visited[x][y] == 0*/) {
					temp2 += board[x][y];
					arr[x][y] = '.';
					arr[a][b] = '.';
//					visited[x][y] = 1;
//					visited[a][b] = 1;
					System.out.println("8. board[x][y]:"+board[x][y]);
					return true;
				
				} else if(board[x][y] == '.') {
					System.out.println("9. board[x][y]:"+board[x][y]);
					continue;
				} else if(board[x][y] == '*') {
					System.out.println("4-2. board[x][y]:"+board[x][y]);
					System.out.println("4-2. x:"+x);
					System.out.println("4-2. y:"+y);
					x++;
					break;
				} else {
					System.out.println("10. board[x][y]:"+board[x][y]);
					return false;
				}
			}
			while(flag==true && y>0) {
				y--;
				if(ch == board[x][y] /*&& visited[x][y] == 0*/) {
					temp2 += board[x][y];
					arr[x][y] = '.';
					arr[a][b] = '.';
//					visited[x][y] = 1;
//					visited[a][b] = 1;
					System.out.println("11. board[x][y]:"+board[x][y]);
					return true;
				} else if(board[x][y] == '.') {
					System.out.println("12. board[x][y]:"+board[x][y]);
					continue;
				} else if(board[x][y] == '*') {
					y++;
					System.out.println("4-3. board[x][y]:"+board[x][y]);
					break;
				} else {
					System.out.println("13. board[x][y]:"+board[x][y]);
					return false;
				}
			}
			
/*		      
		      for(int i=0;i<board.length;i++){
		          for(int j=0;j<board[0].length;j++){
		              if(visited[i][j] == 1) {
		            	  flag2 = true;
		            	  System.out.println("a. flag2:"+flag2);
		              } else {
		            	  flag2 = false;
		            	  System.out.println("b. flag2:"+flag2);
		              }
		          }        
		      }
*/
		      
//		}
		return flag2;
	}
	  
    public static int solution30(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i:priorities) {
        	que.add(i);
        }
        Arrays.sort(priorities);
        int len = priorities.length-1;
        while(!que.isEmpty()) {        
        	int k = que.poll();
        	if(k==priorities[len-answer]) {
        		answer++;
        		location--;
        		if(location<0) {
        			System.out.println(answer+"번째 출력됨");
        			break;
        		}
        	} else {
        		que.add(k);
        		location--;
        		if(location<0) {
        			location = que.size()-1;
        		}
        	}
        }
        
        return answer;
    }
	  public static int solution29(int[] arr) {
	      int answer = 0;
	      int cnt=1, flag=0;
	      Arrays.sort(arr);
	      for(int k=0; k<cnt; k++) {
		      for(int i=0; i<arr.length; i++) {
		    	  if((arr[arr.length-1] * cnt)%arr[i] == 0) {
		    		  flag=0;
		    	  } else {
		    		  cnt++;
		    		  flag=1;
		    		  break;
		    	  }
		      }
		      if(flag==0) {
		    	  answer = arr[arr.length-1] * cnt;
		    	  System.out.println("최소공배수:"+answer);
		    	  return answer;
		      }
	      }
	      return answer;
	  }
	  
    public static int[] solution28(int n, String[] words) {
        int[] answer = new int[2]; //{};
        int cnt=0, turn=0;
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<words.length-1; i++) {
        	cnt++;
        	if(cnt==n) {
        		cnt=0;
        		turn++;
        	}
        	if(words[i].charAt(words[i].length()-1) == words[i+1].charAt(0)) {
        		if(list.contains(words[i+1])) {
        			answer[0] = cnt+1;
        			answer[1] = turn+1;
        			System.out.println("중복오류 실패:"+Arrays.toString(answer));
        			return answer;
        		}
        		list.add(words[i]);
        		list.add(words[i+1]);
        		continue;
        	} else {
    			answer[0] = cnt+1;
    			answer[1] = turn+1;
    			System.out.println("끝말잇기 실패:"+Arrays.toString(answer));
    			return answer;        		
        	}
        }      
		answer[0] = 0;
		answer[1] = 0;
		System.out.println("끝말잇기 성공:"+Arrays.toString(answer));
        return answer;
    }
	public static boolean isPrime(int num) {
		if(num==0 || num==1 || num==2) {
			return true;	// 솟수
		}
		for(int i=2; i<num; i++) {
			if(num%i == 0) {
				return false;	// 솟수 아님				
			}
		}
		return true;	// 솟수
	}
    public static int solution27(int[] nums) {
        int answer = -1;
        int cnt=0, sum=0;
        for(int i=0; i<nums.length-2; i++) {
        	for(int j=i+1; j<nums.length-1; j++) {
        		for(int k=j+1; k<nums.length; k++) {
        			sum = nums[i] + nums[j] + nums[k];
        			if(isPrime(sum) == true) {
        				cnt++;
        			}
        		}
        	}
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("cnt:"+cnt);
        answer = cnt;
        return answer;
    }
	/*
	 * 테스트 1
입력값 〉	"FRANCE", "french"
기댓값 〉	16384
실행 결과 〉	테스트를 통과하였습니다.
테스트 2
입력값 〉	"handshake", "shake hands"
기댓값 〉	65536
실행 결과 〉	실행한 결괏값 93622이(가) 기댓값 65536와(과) 다릅니다.
테스트 3
입력값 〉	"aa1+aa2", "AAAA12"
기댓값 〉	43690
실행 결과 〉	실행한 결괏값 -196608이(가) 기댓값 43690와(과) 다릅니다.
테스트 4
입력값 〉	"E=M*C^2", "e=m*c^2"
기댓값 〉	65536
실행 결과 〉	테스트를 통과하였습니다.
	 */
	/*
	 * n	t	m	p	result
	 * 2	4	2	1	0111
	 * 16	16	2	1	02468ACE11111111
	 * 16	16	2	2	13579BDF01234567
	 */
	public static char[] convert(int n, int value) {
        if( value == 0 ) return new char[] {'0'};

        StringBuilder sb = new StringBuilder();
        while( value > 0 ) {
            int rest = value % n;
            if( rest >= 10 )
                sb.append((char)(65+(rest-10)));
            else
                sb.append(rest);

            // sb.append(rest >= 10 ? (char)(65+(rest-10)) : rest);
            // 이렇게 하면 '65' 가 입력됨.. 무슨 차이?
            value /= n;
        }

        return sb.reverse().toString().toCharArray();
    }

    public static String solution(int n, int t, int m, int p) {
        String caseAll = "";
        int index = 0;
        for (int i = 0; i < t*m; i++) {
            char[] charNum = convert(n,i);  // 1) 0 ~ t*m N진수로 변환
            for (char ch : charNum) {   // 2) 일단 모든 경우의 수(t*m) 배열에 넣음
                if( index > t*m )   break;
                caseAll += ch;
                index ++;
            }
        }

        // 3) 튜브의 차례에 맞는 출력 프로그램
        char[] toCharCase = caseAll.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i=0;
        for( char ch : toCharCase ) {
            i++;

            // 튜브 차례
            if( i == p )    sb.append(ch);

            // 구할 숫자의 갯수 이상일 때, break
            if( sb.length() >= t ) break;

            // 한 턴
            if( i == m )    i = 0;
        }

        return sb.toString();
    }



	public static String solution26(int n, int t, int m, int p) {
	    String answer = "";
	    String temp = "";
	    String temp2 = "";
	    int cnt = 0;
        String caseAll = "";
        int index = 0;
        for (int i = 0; i < t*m; i++) {
            char[] charNum = convert(n,i);  // 1) 0 ~ t*m N진수로 변환
            for (char ch : charNum) {   // 2) 일단 모든 경우의 수(t*m) 배열에 넣음
                if( index > t*m )   break;
                caseAll += ch;
                index ++;
            }
        }
        temp = caseAll;
	    for(int i=0; i<temp.length(); i++) {
	    	cnt++;
	    	if(cnt==p) {
	    		temp2 = temp2 + temp.charAt(i);
	    	}
	    	if(temp2.length() >= t) {
	    		answer = temp2.toUpperCase();
	    		break;
	    	}
	    	if(cnt == m) cnt = 0;
	    }
	    System.out.println("N진수:"+answer);
	    return answer;
	}
	
	public static int solution25(String str1, String str2) {
		int answer = 0;
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		ArrayList<String> strlist1 = new ArrayList<>();
		ArrayList<String> strlist2 = new ArrayList<>();
		ArrayList<String> temp1 = new ArrayList<>();
		ArrayList<String> temp2 = new ArrayList<>();

		for(int i=0; i<str1.length()-1; i++) {
			strlist1.add(str1.substring(i, i+2));
			temp1.add(str1.substring(i, i+2));
		}
		for(int i=0; i<str2.length()-1; i++) {
			strlist2.add(str2.substring(i, i+2));
			temp2.add(str2.substring(i, i+2));
		}
//		System.out.println("Strlist1:"+strlist1);
//		System.out.println("Strlist2:"+strlist2);
		for(int i=0; i<strlist1.size(); i++) {			
			if(!(strlist1.get(i).charAt(0)>='a'&&strlist1.get(i).charAt(0)<='z') ||
					!(strlist1.get(i).charAt(1)>='a'&&strlist1.get(i).charAt(1)<='z')) {
//				System.out.println("strlist1.get(i).charAt(0):"+strlist1.get(i).charAt(0));
//				System.out.println("strlist1.get(i).charAt(1):"+strlist1.get(i).charAt(1));
				temp1.remove(strlist1.get(i));
			}
		}
		for(int i=0; i<strlist2.size(); i++) {
			if(!(strlist2.get(i).charAt(0)>='a'&&strlist2.get(i).charAt(0)<='z') ||
					!(strlist2.get(i).charAt(1)>='a'&&strlist2.get(i).charAt(1)<='z')) {
				temp2.remove(strlist2.get(i));
			}
		}
//		System.out.println("temp1:"+temp1);
//		System.out.println("temp2:"+temp2);
		int same_cnt = 0;

		for(int i=0; i<temp1.size(); i++) {
			for(int j=0; j<temp2.size(); j++) {					
				//System.out.println("strlist2.get(j):"+strlist2.get(j));
				if(temp1.get(i).equals(temp2.get(j))) {
//					System.out.println("temp1.get(i):"+temp1.get(i));
					same_cnt++;
					break;
				}
			}
		}
		
		if(same_cnt==0) {
			System.out.println("same_cnt=0:65536");
			return 65536;
		}
		int sum = temp1.size() + temp2.size();
//		System.out.println("sum1:"+sum);//5
//		System.out.println("same_cnt:"+same_cnt);//2
		sum = sum-same_cnt;
//		System.out.println("sum2:"+sum);//3
		if(sum==0) {
//			System.out.println("sum=0:65536");
			return 65536;
		}

		answer = (int)((double)same_cnt/(double)sum * 65536);
		System.out.println("answer:"+answer);
		return answer;
	}
	public static void checkPosition(int[][] sample, int x, int y, List<String> tmp) {
		sample[x][y] = 1;
		tmp.add(x+","+y);
		System.out.println(tmp);
		int[] di = {-1,0,1,0};
		int[] dj = {0,-1,0,1};
		for(int d=0; d<4; d++) {
			int dx = x+di[d];
			int dy = y+dj[d];
			if(dx>=0 && dx<sample.length && dy>=0 && dy<sample[0].length) {
				if(sample[dx][dy] == 0) {
					checkPosition(sample, dx, dy, tmp);
				}
			}
		}

	}
	public static int[] solution24(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int size=0;
		boolean[][] visited = new boolean[m][n]; 
		Stack<Integer> sx = new Stack<>();
		Stack<Integer> sy = new Stack<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				size = 0;
				if(picture[i][j] != 0 && visited[i][j] != true) {		
					addComponent(sx, sy, i, j, visited);
					size++;
					numberOfArea++;
					
					while(!sx.isEmpty()) {
						int x = sx.pop();
						int y = sy.pop();
						if(x-1>=0) {
							if(picture[i][j] == picture[x-1][y] && visited[x-1][y] != true) {
								size++;
								addComponent(sx, sy, x-1, y, visited);
							}
						}
						if(x+1<m) {
							if(picture[i][j] == picture[x+1][y] && visited[x+1][y] != true) {
								size++;
								addComponent(sx, sy, x+1, y, visited);
							}
						}
						if(y-1>=0) {
							if(picture[i][j] == picture[x][y-1] && visited[x][y-1] != true) {
								size++;
								addComponent(sx, sy, x, y-1, visited);
							}
						}
						if(y+1<n) {
							if(picture[i][j] == picture[x][y+1] && visited[x][y+1] != true) {
								size++;
								addComponent(sx, sy, x, y+1, visited);
							}
						}
					}
					maxSizeOfOneArea = Math.max(size, maxSizeOfOneArea);
				}
			}
			
		}
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		System.out.println("answer:"+Arrays.toString(answer));
		return answer;
	}
	static void addComponent(Stack<Integer> sx, Stack<Integer> sy, int x, int y, boolean[][] visited) {
		sx.add(x);
		sy.add(y);
		visited[x][y] = true;
	}
	/*
	 Class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] picture;
    static boolean[][] visited;
    
  public int[] solution(int m, int n, int[][] picture) {
      int numberOfArea = 0;
      int maxSizeOfOneArea = 0;
        
      this.picture = picture;
      visited = new boolean[m][n];
      
      int[] answer = bfs(m, n);
      System.out.println(answer[0]);
     
      return answer;
  }
    static int[] bfs(int m, int n) {
        int[] answer = new int[2];
        Stack<Integer> sx = new Stack<>();
        Stack<Integer> sy = new Stack<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (picture[i][j] != 0 && !visited[i][j]) {
                    addComponent(sx, sy, i, j);
                    count++;
                    answer[0]++;
                }
                
                while(!sx.isEmpty()) {
                    int x = sx.pop();
                    int y = sy.pop();
                    
                    if (x > 0 && picture[x-1][y]== picture[i][j] && !visited[x-1][y]) {
                        addComponent(sx, sy, x-1, y);
                        count++;
                    }
                    
                     if (y > 0 && picture[x][y-1]== picture[i][j] && !visited[x][y-1]) {
                        addComponent(sx, sy, x, y-1);
                        count++;
                    }
                    
                     if (x < m-1 && picture[x+1][y]== picture[i][j] && !visited[x+1][y]) {
                        addComponent(sx, sy, x+1, y);
                        count++;
                    }
                    
                     if (y < n-1 && picture[x][y+1]== picture[i][j] && !visited[x][y+1]) {
                        addComponent(sx, sy, x, y+1);
                        count++;
                    }
                }
                answer[1] = Math.max(count, answer[1]);
            }
        }
        return answer;
    }
    static void addComponent(Stack<Integer> sx, Stack<Integer> sy, int x, int y) {
        sx.add(x);
        sy.add(y);
        visited[x][y] = true;
    }
}
	 */
    public static int solution23(String[][] clothes) {
        int answer = 0;
        //System.out.println(clothes[0][0].split(",")[0]);
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        
        ArrayList<String> arrlist = new ArrayList<>();
        arrlist.add(clothes[0][0].split(",")[0]);
        hm.put(clothes[0][0].split(",")[1], arrlist);
        for(int i=0; i<clothes.length; i++) {
        	arrlist = new ArrayList<>();
        	for(int j=0; j<clothes[0].length; j++) {
        		for(String key:hm.keySet()) {
        			if(key.equals(clothes[i][j].split(",")[1])) {
        				arrlist.add(clothes[i][j].split(",")[0]);
        			} else {
        				
        			}
        		}
        		hm.put(clothes[i][j].split(",")[1], arrlist);
        	}
        }
        return answer;
    }
	  public static String solution22(String s) {
	      String answer = "";
	      String[] temp = s.split(" ");
	      int[] itemp = new int[temp.length];
	      for(int i=0; i<temp.length; i++) {
	    	  itemp[i] = Integer.parseInt(temp[i]);
	      }
	      Arrays.sort(itemp);
	      answer = itemp[0] + " " + itemp[itemp.length-1];
	      System.out.println(answer);
	      return answer;
	  }
	  public static int solution21(int num) {
	      int answer = 0;
	      long temp = (long)num;
	      while(temp != 1) {
	          if(temp % 2 == 0) {
	        	  temp = temp / 2;
	          } else {
	        	  temp = temp * 3 + 1;
	          }
	          answer++;
	          System.out.println("answer:"+answer+", num:"+temp);
	          
	          if(answer >= 500 && temp!=1) {
	        	  System.out.println("return -1:"+answer);
	              return (-1);
	          }
	          if(temp == 1 && answer<500) {
	        	  System.out.println("break:"+answer);
	              break;
	          }

	      }
	      
	      return answer;
	  }
    public static int[] solution20(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(operations.length, Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        
        for(String operation : operations) {
        	String[] command = operation.split(" ");
        	if(command[0].equals("I")) {
        		minQ.add(Integer.parseInt(command[1])); 
        		maxQ.add(Integer.parseInt(command[1]));
        	}
        	if(command[0].equals("D")) {
        		if(!maxQ.isEmpty()/*&& !minQ.isEmpty()*/) {
	        		if(command[1].equals("1")) {
	        			int max = maxQ.peek();
	        			System.out.println("max:"+max);
	        			maxQ.remove(max); 
	        			minQ.remove(max); 
	        			
	        			
	        		} else {
	        			int min = minQ.peek();
	        			System.out.println("min:"+min);
	        			maxQ.remove(min); 
	        			minQ.remove(min);
	        		}
        		}
        	}

    	}
    	if(!maxQ.isEmpty() && !minQ.isEmpty()) {
    		answer[0] = maxQ.peek();
    		answer[1] = minQ.peek();
    		System.out.println(Arrays.toString(answer));
    	}
        //System.out.println(Arrays.toString(answer));
        return answer;
    }
    public int solution19(int[][] jobs) {
    	
    	 Arrays.sort(jobs, new Comparator<int[]>() {
          public int compare(int[] o1, int[] o2) {
              if(o1[0] <= o2[0]){
                  return -1;
              }
              return 1;
          }
      });      

      PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
          public int compare(int[] o1, int[] o2) {
              if(o1[1] < o2[1]){
                  return -1;
              }
              return 1;
          }
      });

      int time = 0;
      int index = 0;
      float answer = 0;

      while(true){
          while(index < jobs.length && jobs[index][0] <= time){
              queue.offer(jobs[index]);
              index ++;
          }
          if(queue.size() == 0){
              time = jobs[index][0];
              continue;
          }
          int[] job = queue.poll();
          time += job[1];
          answer += time - job[0];
          if(index == jobs.length && queue.size() == 0){
              break;
          }
      }

      answer /= jobs.length;
      return (int)answer;
    }
    	 /*
        int answer = 0;
        PriorityQueue<Disk> sortWithIndex = new PriorityQueue<>();
        PriorityQueue<Disk> priorityQueue2 = new PriorityQueue<>(this::compareToDelay);
        List<Disk> answers = new ArrayList<>();
        for(int[] job:jobs) {
        	sortWithIndex.add(new Disk(job[0], job[1]));
        }
        int time = 0;
        while(!sortWithIndex.isEmpty()) {
        	while(!sortWithIndex.isEmpty() && sortWithIndex.peek().index<=time) {
        		priorityQueue2.add(sortWithIndex.poll());
        	}
        	if(!priorityQueue2.isEmpty()) {
        		Disk andDisk = priorityQueue2.poll();
        		answers.add(andDisk);
        		time += andDisk.delayTime;
        		
        		answer += time - andDisk.index;
        		for(Disk disk:priorityQueue2) {
        			sortWithIndex.add(disk);
        		}
        		priorityQueue2.clear();
        	} else {
        		time++;
        	}
        }
        answer = (int)Math.floor(answer/jobs.length);
        return answer;
    }
    
    public int compareToDelay(Disk o1, Disk o2) {
    	if(o1.delayTime > o2.delayTime) {
    		return 1;
    	} else if(o1.delayTime < o2.delayTime) {
    		return -1;
    	} else {
    		return 0;
    	}
    		
    }
    */
    public static int solution18(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++) {
        	if(citations[i] >= citations.length-i) {
        		answer = citations.length-i;
        		break;
        	}
        }
        System.out.println("H-Index:"+answer);
        return answer;
    }
    public static int isPalindrome(String s) {
        int pal = 0;
    	int len = s.length();
    	for(int k=0; k<len/2; k++) {
    		if(s.charAt(k) == s.charAt(len-k-1)) { 
    			
    		} else {
    			pal = 1;
    			break;
    		}
    	}
    	if(pal==0) {
//    		System.out.println("palindrome:"+s);
    		return pal;
    	}

        return pal;
    }
    public static int solution17(String s)
    {
    	/*
    	  String reverse = "";

	      for(int i= input.length()-1; i >= 0; i--){
	         reverse += input.charAt(i);
	      }
	
	      System.out.println(input);
	      System.out.println(reverse);
	      System.out.println("======================");
	
	//    가장긴 리버스가 같은 문자열 고르기
	      int max = 1;
	      for(int i = input.length(); i > 1 ; i--){
	         for(int j = 0; j <= input.length() - i; j++){
	            if(reverse.contains(input.substring( j, i+j))){
	               max = i;
	               return max;
	            }
	         }
	      }
	      return max;
    	 */
        int answer = 0;
        int max_len = 0;
        for(int i=0; i<s.length(); i++) {
        	for(int k=i; k<=s.length(); k++) {
	        	if(isPalindrome(s.substring(i, k)) == 0) {
	        		if(s.substring(i, k).length() > max_len) {
	        			max_len = s.substring(i, k).length();
	        		}
	        	}
        	}
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("max_len:"+max_len);
        answer = max_len;
        return answer;
    }
    public static int solution16(String skill, String[] skill_trees) {
        int answer = 0;
        int start = 0;
        int flag = 0;
        for(int i=0; i<skill_trees.length; i++) {
        	start = 0;
        	flag = 0;
        	for(int k=0; k<skill_trees[i].length(); k++) {
        		for(int t=start; t<skill.length(); t++) {
        			if(skill_trees[i].charAt(k) == skill.charAt(t)) {
        				if(t==start) {
        					start++;
        				} else {
        					flag = 1;
        				}
        			}
	        		
	        	}
        	}
        	if(flag == 0) {
        		answer++;
        	}
        }
        System.out.println("스킬갯수:"+answer);
        return answer;
    }	
    public static boolean solution15(int[] arr) {
        boolean answer = true;
        int flag = 0;
        Arrays.sort(arr);
        for(int i=1; i<=arr.length; i++) {
        	if(arr[i-1] == i) {
        		
        	} else {
        		flag = 1;
        		break;
        	}
        }
        if(flag == 0) {
        	answer = true;
        	System.out.println("모두 포함");
        } else {
        	answer = false;
        	System.out.println("포함안함");
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        

        return answer;
    }
    public static int solution14(int n, int m) {
        int answer = 0;
        int pal = 0;
        for(int i=n; i<=m; i++) {
        	pal = 0;
        	int len = Integer.toString(i).length();
        	System.out.println("len:"+len);
        	for(int k=0; k<len/2; k++) {
        		if(Integer.toString(i).charAt(k) == Integer.toString(i).charAt(len-k-1)) {
        			
        		} else {
        			pal = 1;
        			break;
        		}
        	}
        	if(pal==0) {
        		System.out.println("palindrome:"+Integer.toString(i));
        		answer++;
        	}
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("count:"+answer);

        return answer;
    }
    public static int[] solution13(int[][] v) {
        int[] answer = {};
        answer = new int[2];
        int garo=0, sero=0, gijun_x = 100, gijun_y=100, k=0;
        for(int i=0; i<v.length-1; i++) { 
        	gijun_x = Math.min(v[i][0], gijun_x);
        	gijun_y = Math.min(v[i][1], gijun_y);
        }
        System.out.println();
        System.out.println("gijun_x:"+gijun_x+", gijun_y:"+gijun_y);
        
        while(true) { 
        	garo = Math.abs(v[k][0] - gijun_x);
        	if(garo==0) {
        		k++;
        		garo = Math.abs(v[k][0] - gijun_x);
        		if(garo!=0) {
        			break;
        		}
        	}
        }
        k=0;
        while(true) { 
        	sero = Math.abs(v[k][1] - gijun_y);
        	if(sero==0) {
        		k++;
        		sero = Math.abs(v[k][1] - gijun_y);
        		if(sero!=0) {
        			break;
        		}
        	}
        }       

        
//        System.out.println();
//        System.out.println("gijun_x:"+gijun_x+", gijun_y:"+gijun_y);
        System.out.println("garo:"+garo+", sero:"+sero);
        ArrayList<Squre> sq1 = new ArrayList<Squre>();
        for(int i=0; i<v.length; i++) {
        	System.out.println(v[i][0]+","+v[i][1]);
        	sq1.add(new Squre(Integer.toString(v[i][0]), Integer.toString(v[i][1])));
        }
        System.out.println(sq1.get(0).x);
        ArrayList<Squre> sq2 = new ArrayList<Squre>();
        sq2.add(new Squre(Integer.toString(gijun_x), Integer.toString(gijun_y)));
        sq2.add(new Squre(Integer.toString(gijun_x+garo), Integer.toString(gijun_y)));
        sq2.add(new Squre(Integer.toString(gijun_x), Integer.toString(gijun_y+sero)));
        sq2.add(new Squre(Integer.toString(gijun_x+garo), Integer.toString(gijun_y+sero)));

        int found = 0;
        for(int i=0; i<sq2.size(); i++) {
        	found = 0;
        	for(int j=0; j<sq1.size(); j++) {
	        	System.out.println("sq1:"+sq1.get(j).toString());
	        	System.out.println("sq2:"+sq2.get(i).toString());
	        	if(sq2.get(i).toString().equals(sq1.get(j).toString())) {
	        		found = 1;
	        		break;
	        	} else {
	        		System.out.println("답:"+sq1.get(j).toString());
	        		
	        	}
        	}
        	if(found == 0) {
        		answer[0] = Integer.parseInt(sq2.get(i).x);
        		answer[1] = Integer.parseInt(sq2.get(i).y);
        	}
        }
        /*
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<int[]> list_new = new ArrayList<>();
        ArrayList<int[]> list_answer = new ArrayList<>();
        for(int i=0; i<v.length; i++) {
        	list.add(v[i]);
        }
        int[] arr = {};
        arr = new int[2];
        arr[0] = gijun_x;
        arr[1] = gijun_y;
        list_new.add(arr);

        System.out.println(list_new.get(0)[0]);
        arr = new int[2];
        arr[0] = gijun_x+garo;
        arr[1] = gijun_y;
        list_new.add(arr);
        
        arr = new int[2];
        arr[0] = gijun_x;
        arr[1] = gijun_y+sero;
        list_new.add(arr);
        
        arr = new int[2];
        arr[0] = gijun_x+garo;
        arr[1] = gijun_y+sero;
        list_new.add(arr);
        
        k=0;
        for(int i=0; i<list_new.size(); i++) {
        	System.out.println(list_new.get(i));
        	if(!list_new.contains(list.get(k))) {
        		answer = list.get(k);
        	} else {
        		k++;
        	}
        }
        */
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
    public static int[] solution12(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length-1; i++) {
        	for(int j=i+1; j<prices.length; j++) {
        		if(prices[i] <= prices[j]) {
        			answer[i]++;
        		} else {
        			answer[i]++;
        			break;
        		}
        	}
        }
        answer[prices.length-1] = 0;
        System.out.println();
        System.out.println(Arrays.toString(answer));
        
        /*
        Stack<Integer> beginIdxs = new Stack<>();
        int i=0;
        int[] terms = new int[prices.length];

        beginIdxs.push(i);
        for (i=1; i<prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
         */
        return answer;
    }
	
    public static String solution11(int[] numbers) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
            //list.add(Integer.toString(numbers[i]));
         }
         
         for(int i=0; i<list.size(); i++) {
             if(!list.get(i).equals("0")) {
                 break;
             }
             
             if(i==list.size()-1) {
                 return "0";
             }
         }
        	

        Collections.sort(list, new Comparator<String>() {
        	public int compare(String arg0, String arg1) {
        		return (arg1+arg0).compareTo(arg0+arg1);
        	}
        });
        System.out.println(list);
        for(int i=0; i<list.size(); i++) {
        	answer += list.get(i);
        }
        System.out.println("solution11:"+answer);
        return answer;
    }
    public static int[] solution10(int[] array, int[][] commands) {
        int[] answer = {};
        /*
            for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
         */
        int m = commands.length;
//        int n = commands[0].length;
        int j=0;
        answer = new int[m];
        int[] temp = {};
        System.out.println();
        for(int i=0; i<m; i++) {       	
        	j=0;
            int start = commands[i][j];
            j++;
            int end = commands[i][j];
            j++;
            int select = commands[i][j];
            j++;
            temp = new int[end-start+1];
            for(int k=0; k<end-start+1; k++) {
            	temp[k] = array[start-1+k];
            }
            Arrays.sort(temp);
            System.out.println(Arrays.toString(temp));
            answer[i] = temp[select-1];
            System.out.println(answer[i]);
        }
        return answer;
    }
	public static String[] solution9(String[] strings, int n) {
//		String[] answer = new String[strings.length];
		System.out.println();
		Arrays.sort(strings, new Comparator<String>() {
			public int compare(String str1, String str2) {
				System.out.println("0. str1:"+str1+", str2:"+str2);
				if( str1.charAt(n) - str2.charAt(n) == 0 ) {
					System.out.println("1. str1:"+str1+", str2:"+str2+", "+str1.compareTo(str2));
					return str1.compareTo(str2);
				} else {
					System.out.println("2. str1:"+str1.charAt(n)+", str2:"+str2.charAt(n)+", "+
							(str1.charAt(n) - str2.charAt(n))+", "+str1.compareTo(str2));
					return str1.charAt(n) - str2.charAt(n);
				}
			}
		});
		System.out.println();
		for(int i=0; i<strings.length; i++)
			System.out.println(strings[i]);
		return strings;
		/*
		String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
		 */
	}
    public static int[] solution8(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<Integer>();
        HashMap<String, Integer> genrePlayHashMap = new HashMap<String, Integer>();
        for(int i=0; i<genres.length; i++) {
        	genrePlayHashMap.put(genres[i], genrePlayHashMap.getOrDefault(genres[i], 0)+plays[i]);
        }
        System.out.println();
        Set<String> key = genrePlayHashMap.keySet();
        for(String s:key) {
        	System.out.println(s+", "+genrePlayHashMap.get(s));
        }
        HashMap<Integer, String> playGenreHashMap = new HashMap<Integer, String>();
        for(String s:key) {
        	playGenreHashMap.put(genrePlayHashMap.get(s), s);
        	System.out.println(genrePlayHashMap.get(s) +", "+playGenreHashMap.get(genrePlayHashMap.get(s)));
        }      
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(playGenreHashMap);
        int treeMapSize = treeMap.size();
        for(int i=0; i<treeMapSize; i++) {
        	String genre = treeMap.lastEntry().getValue();	// pop
        	int deleteKey = treeMap.lastEntry().getKey();	// 3100
        	int max = -1, nextmax = -1;
        	int maxIndex = -1, nextmaxIndex = -1;
        	for(int g=0; g<genres.length; g++) {
        		if(genres[g].equals(genre)) {
        			boolean check = max != plays[g];
        			max = Math.max(max, plays[g]);
        			if(plays[g] == max && check) {
        				maxIndex = g;
        			}
        		}
        	}
        	plays[maxIndex] = -1;
        	genres[maxIndex] = "-1";
        	answerList.add(maxIndex);
        	
        	for(int g=0; g<genres.length; g++) {
        		if(genres[g].equals(genre)) {
        			boolean check = nextmax != plays[g];
        			nextmax = Math.max(nextmax, plays[g]);
        			if(plays[g] == nextmax && check) {
        				nextmaxIndex = g;
        			}
        		}
        	}
        	if(nextmaxIndex != -1) {
	        	plays[nextmaxIndex] = -1;
	        	genres[nextmaxIndex] = "-1";
	        	answerList.add(nextmaxIndex);
        	}
        	treeMap.remove(deleteKey);
        }
        System.out.println();
        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
        	answer[i] = answerList.get(i);
        	System.out.print(answer[i] + " ");
        }
 /*       
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        TreeMap<Integer, String> tm = new TreeMap<>();
        for(int i=0; i<genres.length; i++) {
        	if(hm.containsKey(genres[i])) {
        		hm.get(genres[i]).add(plays[i]);
        	} else {
        		al = new ArrayList<>();
        		al.add(plays[i]);
        		hm.put(genres[i], al);
        	}
        }
        System.out.println();
        int sum = 0, cnt=0, max=0;
        for(String key:hm.keySet()) {  
        	sum = 0;
        	Collections.sort(hm.get(key));      
        	for(int i=0; i<hm.get(key).size(); i++) {
        		sum += hm.get(key).get(i);
        	}
        	tm.put(sum, key);
        	System.out.println(key + "," + hm.get(key) + "," + sum);
        }
        answer = new int[tm.size()*2];
        System.out.println();
        for(String key:hm.keySet()) {
        	if(key.equals(tm.lastEntry().getValue())) {
        		answer[cnt] = hm.get(key).get(hm.get(key).size()-1);
        		System.out.print(key+" "+answer[cnt]+" ");
        		cnt++;        		
        		answer[cnt] = hm.get(key).get(hm.get(key).size()-2);
        		System.out.print(key+" "+answer[cnt]+" ");
        		cnt++;
        	}

        	tm.remove(tm.lastEntry().getKey());
        }
        System.out.println();
        for(int i=0; i<cnt; i++) {
        	for(int j=0; j<plays.length; j++) {
//        		System.out.println(answer[i]+" "+plays[j]);
	        	if(answer[i] == plays[j]) {
	        		answer[i] = j;
	        		System.out.print(answer[i]+" ");
	        		break;
	        	}
        	}
        }
*/        
        return answer;
    }
    public static int[] solution7(int[] heights) {
        int[] answer = {};
        answer = new int[heights.length];
        for(int i=heights.length-1; i>=0; i--) {
        	for(int j=i-1; j>=0; j--) {
        		if(heights[i] < heights[j]) {
        			answer[i] = j+1;
        			break;
        		} else if(j==0) {
        			answer[i] = 0;
        		}
        	}
        }
        System.out.println();
        for(int i=0; i<heights.length; i++)
        	System.out.print(answer[i]+" ");
        return answer;
    }
    public static int[] solution6(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<progresses.length; i++) {
        	int day = (100-progresses[i])/speeds[i];
        	int remain = (100-progresses[i])%speeds[i];
        	if(remain>0) {
        		remain = 1;
        	}
        	day = day+remain;
        	temp.add(day);
        }
        int d = temp.get(0);
        int cnt = 1;
        for(int i=1; i<progresses.length; i++) {
        	if(temp.get(i) <= d) {
        		cnt++;
        	} else {
        		result.add(cnt);
        		d = temp.get(i);
        		cnt = 1;
        	}
        }
        result.add(cnt);
        answer = new int[result.size()+1];
        for(int i=0; i<result.size(); i++) {
        	answer[i] = result.get(i);
        	System.out.print(answer[i]+" ");
        }
        return answer;
    }
    
    public static int solution5(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int pri:priorities) {
        	que.add(pri);
        }
        Arrays.sort(priorities);
        int length = priorities.length - 1;
        while(!que.isEmpty()) {
        	int current = que.poll();
        	if(current == priorities[length-answer]) {
        		answer++;
        		location--;
        		System.out.println("answer1:"+answer+", location:"+location+", current:"+current);
        		if(location<0) {
        			System.out.println("answer2:"+answer+", location:"+location+", current:"+current);
        			break;
        		}
        	} else {
        		que.add(current);
        		location--;
        		System.out.println("answer3:"+answer+", location:"+location+", current:"+current);
        		if(location<0) {
        			location = que.size()-1;
        			System.out.println("answer4:"+answer+", location:"+location+", current:"+current);
        		}
        	}
        }
        System.out.println("answer5:"+answer+", location:"+location);
        return answer;
    }
    public static int solution4(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i=0; i<clothes.length; i++) { 	
    		if(hm.containsKey(clothes[i][1])) {
    			hm.put(clothes[i][1], hm.get(clothes[i][1])+1);      
    		} else {
    			hm.put(clothes[i][1], 1); 
        	}
        }
        answer = 1;
        for(int value:hm.values()) {
            answer *= (value+1);
        }
        answer -= 1;
        System.out.println(answer);
        return answer;
    }
    public static boolean solution3(String[] phone_book) {
        boolean answer = true;
        for(int i=0; i<phone_book.length-1; i++) {
        	for(int j=i+1; j<phone_book.length; j++) {
        		if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) {
        			answer = false;
        			System.out.println("false:"+phone_book[i]);
        			return answer;
        		}
        	}
        }
        System.out.println("true");
        return answer;
    }
	public static void dfs(int len, String s) {
		if(stop) {
			return;
		}
		if(n==len) {
			stop = true;
			System.out.println(s);
		} else {
			for(int i=1; i<=3; i++) {
				
			}
		}
	}
	public static boolean isSatisfy(String s) {
		int len = s.length();
		int loop = len/2;
		int start = len-1;
		int end = len;
		for(int i=1; i<=loop; i++) {
			if(s.substring(start-i, end-i).equals(s.substring(start, end))) {
				return false;
			}
			start -= 1;
		}
		return true;
	}
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        int count=0;
        for(int i=0; i<participant.length; i++) {
            count=0;
            answer = participant[i];
            List<String> list = new ArrayList<>(Arrays.asList(completion));
            for(int j=0; j<completion.length; j++) {
                if(participant[i].equals(completion[j])) {
                    count++;
                    list.remove(j);
                    completion = list.toArray(new String[list.size()]);
                    break;
                }
            }
            if(count==0) {
                System.out.println(answer);
                return answer;
            }
        } 
        return answer;
    }
	public static String solution2(String[] participant, String[] completion) {
        String answer = "";
        int val=0;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(String s:participant) {
        	if(hm.get(s) == null) {
        		hm.put(s,1);
        	} else {
        		val = hm.get(s)+1;
        		hm.put(s, val);
        	}
        }
        for(String st:completion) {
        	val = hm.get(st) - 1;
        	hm.put(st, val);
        }
        for(String key:hm.keySet()) {
        	if(hm.get(key)==1) {
        		answer = key;
        		System.out.println(answer);
        	}
        }
        return answer;
	}
}
