import java.util.*;
/*
 * @Override public int compareTo(Student other) { if (!name.equals(other.name)) return name.compareTo(other.name); if (year > other.year) return 1; else if (year < other.year) return -1; return dob.compareTo(other.dob); }

출처: https://plas.tistory.com/14 [프로그래밍노리터]
 */
class Alpha /*implements Comparable<Alpha>*/ {
	String name;
	int[] table = new int[26];
	public Alpha(String name) {
		this.name = name;
	}
	/*
	public int compareTo(Alpha a) {
		int len = this.name.length();
		int len2 = a.name.length();
		int lim = Math.min(len, len2);
		int k=0;
		while(k<lim) {
			int c1 = table[this.name.charAt(k)-'A'];
			int c2 = table[a.name.charAt(k)-'A'];
			System.out.println("this.name:"+this.name+", c1:"+c1+", a.name:"+a.name+", c2:"+c2);
			if(c1!=c2) {
				return c2-c1; //Integer.toString(c1).compareTo(Integer.toString(c2));
			}
			k++;
		}
		System.out.println("1. this.name:"+this.name+", a.name:"+a.name);

		return Integer.toString(len).compareTo(Integer.toString(len2));
	}
	*/
	public String toString() {
		return this.name;
	}
}
class Word implements Comparable<Word> {
	int len;
	String name;
	public Word(int len, String name) {
		this.len = len;
		this.name = name;
	}
	public int compareTo(Word w) {
		if(this.len>w.len) {
			return 1;
		}
		else if(this.len<w.len) {
			return -1;
		}
		return this.name.compareTo(w.name);
	}
	public String toString() {
		return this.name;
	}
}
class Student implements Comparable<Student> {
	String name;
	int[] home = new int[2];
	double grade;
	int index;
	public Student(String name, int[] home, double grade, int index) {
		this.name = name;
		this.home = home;
		this.grade = grade;
		this.index = index;
	}
	public int compareTo(Student s) {
		String str_this = Double.toString(this.grade).substring(0,1);
		String str = Double.toString(s.grade).substring(0,1);
		int dist_this = this.home[0]*this.home[0] + this.home[1]*this.home[1];
		int dist = s.home[0]*s.home[0] + s.home[1]*s.home[1];
		if(!str_this.equals(str)) {
			return str_this.compareTo(str);
		}
		if(dist_this>dist) {
			return 1;
		} else if(dist_this<dist) {
			return -1;
		}
		return s.name.compareTo(this.name);
	}
	public String toString() {
		return Integer.toString(this.index)+": "+this.name+", "+Integer.toString(this.home[0])+", "+Integer.toString(this.home[1])+", "+Double.toString(this.grade);
	}
}
class Pair {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		}

		if (obj instanceof Pair) {
			if (this.x == ((Pair)obj).getX() && this.y == ((Pair)obj).getY()) {
				return true;
			}
		}

		return false;
	}
	
	public String toString() {
		return x+","+y;
	}
}
/*
 * class Trie_SearchLyrics {
    Node_SearchLyrics root;

    public Trie_SearchLyrics() {
        this.root = new Node_SearchLyrics(' ');
        root.usedCnt = 0;
    }

    public void insert(String words) {
        Node_SearchLyrics current = root;
        current.usedCnt++;

        for(int i=0; i<words.length(); ++i){
            char ch = words.charAt(i);
            int index = ch - 'a';

            if(current.child[index] == null){
                current.child[index] = new Node_SearchLyrics(ch);
            }
            else {
                current.child[index].usedCnt++;
            }
            current = current.child[index];
        }
    }

    public int search(String query){
        Node_SearchLyrics current = root;

        for(int i=0; i<query.length(); ++i){
            char ch = query.charAt(i);
            int index = ch - 'a';

            //?인 경우 -> 현재 위치에서 글자 개수 출력
            if(ch == '?') return current.usedCnt;

            //단어가 존재한다면 해당 단어로 이동
            if(current.child[index] != null) current = current.child[index];

            //query의 단어가 존재하지 않는다면 0을 리턴
            else if(current.child[index] == null) return 0;
        }

        //? 표기 없이 전체 단어로 다 돌았을 때 -> 마지막 단어에서 리턴(이 문제에서는 상관 없음)
        return current.usedCnt;
    }
}

class Node_SearchLyrics {
    public char word;
    public Node_SearchLyrics[] child;
    public int usedCnt;

    public Node_SearchLyrics(char word) {
        this.word = word;
        this.child = new Node_SearchLyrics[26];
        this.usedCnt = 1;
    }
}

public class Problem_SearchLyrics {

    static Trie_SearchLyrics[] tries = new Trie_SearchLyrics[10001];
    static Trie_SearchLyrics[] tries_reversed = new Trie_SearchLyrics[10001];

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] answer = solution(words, queries);
        for(int ans : answer)
            System.out.print(ans + " ");
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = {};

        //주어진 단어를 트라이 형태로 정렬
        //단어 개수별로 트라이 정렬 (정방향, 역방향)
        for(String word : words){
            int size = word.length();
            if(tries[size] == null){
                tries[size] = new Trie_SearchLyrics();
            }
            tries[size].insert(word);

            //역방향으로도 트라이 정렬
            StringBuilder sb = new StringBuilder(word);
            String wordReversed = sb.reverse().toString();

            if(tries_reversed[size] == null) tries_reversed[size] = new Trie_SearchLyrics();
            tries_reversed[size].insert(wordReversed);
        }


        //질문에 대한 처리과정
        ArrayList<Integer> answers = new ArrayList<>();
        for(String query : queries){
            int size = query.length();

            //만약에 뒤에 ?가 있다면 -> 해당 단어 개수에 맞는 트라이로 가서 검색
            if(query.charAt(query.length()-1) == '?'){
                if(tries[size] == null) answers.add(0);
                else {
                    int tmp = tries[size].search(query);
                    answers.add(tmp);
                }
            }

            //앞에 ?가 있다면 -> 해당 단어 개수에 맞는 트라이로 가서 검색
            else {
                StringBuilder sb = new StringBuilder(query);
                String queryReversed = sb.reverse().toString();

                if(tries_reversed[size] == null) answers.add(0);
                else {
                    int tmp = tries_reversed[size].search(queryReversed);
                    answers.add(tmp);
                }
            }
        }

        answer = new int[answers.size()];
        for(int i=0; i<answer.length; ++i){
            answer[i] = answers.get(i);
        }

        return answer;
    }
}
 */
class Trie_SearchLyrics {
	Node_SearchLyrics root;
	public Trie_SearchLyrics() {
		this.root = new Node_SearchLyrics(' ');
		root.usedCnt = 0;
	}
	public void insert(String words) {
		Node_SearchLyrics current = root;
		current.usedCnt++;
		for(int i=0; i<words.length(); i++) {
			char ch = words.charAt(i);
			int index = ch - 'a';
			if(current.child[index] == null) {
				current.child[index] = new Node_SearchLyrics(ch);
			} else {
				current.child[index].usedCnt++;
			}
			current = current.child[index];
		}
	}
	public int search(String query) {
		Node_SearchLyrics current = root;
		for(int i=0; i<query.length(); i++) {
			char ch = query.charAt(i);
			int index = ch - 'a';
			if(ch=='?') {
				return current.usedCnt;
			}
			if(current.child[index] != null) {
				current = current.child[index];
			} else if(current.child[index] == null) {
				return 0;
			}
		}
		return current.usedCnt;
	}
}
class Node_SearchLyrics {
	char word;
	Node_SearchLyrics[] child;
	int usedCnt;
	Node_SearchLyrics(char word) {
		this.word = word;
		this.child = new Node_SearchLyrics[26];
		this.usedCnt = 1;
	}
	public String toString() {
		String str = "";
		for(int i=0; i<this.child.length; i++) {
			str += this.word + ", " + this.child[i].word + ", " + this.child[i].usedCnt + ", " + this.usedCnt + "\n";
		}
		return str;
	}
}
class Edge_RemoveCycle {
	int v1;
	int v2;
	Edge_RemoveCycle(int v1, int v2) {
		this.v1 = v1;
		this.v2 = v2;
	}
}
class Node55 { 
	int no; 
	int x; 
	int y; 
	Node55 parent; 
	Node55 leftson; 
	Node55 rightson; 
	boolean checked; 
	Node55(int no, int[] arr) 
	{ 
		this.no = no; 
		this.x = arr[0]; 
		this.y = arr[1]; 
	}
	public String toString() {
		return no+":"+x+","+y;
	}
}
//출처: https://ydeer.tistory.com/69 [현록의 기록저장소]

class NodeV {
	int r, c;
//	boolean visit;
	NodeV(int r, int c) {
		this.r = r;
		this.c = c;
	}
	public String toString() {
		return r+","+c;
	}
	/*
	boolean equals(NodeV obj) {

		if (super.equals(obj)) {
			return true;
		}
		if (obj instanceof NodeV) {
			if (this.r == ((NodeV)obj).r && this.c == ((NodeV)obj).c) {
				return true;
			}
		}
		return false;
	}
	*/
	/*
	void setVisit(boolean v) {
		this.visit = v;
	}
	boolean getVisit() {
		return this.visit;
	}
	*/
}

class Node {
	int r, c;
	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
class Pos {
	char c;
	int x;
	int y;
	public Pos(char c, int x, int y) {
		this.c = c;
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return x+","+y+","+c;
	}
}

class Exist {
	int x;
	int y;
	int d;
	public Exist(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
	public Exist() {
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return x+","+y+","+d;
	}
}

public class BFS1 {
	static ArrayList<Node> list;
	static int[][] dis;
	static boolean[] selected;
	static char[][] map;
	static int ans;
	
	static char arr[][];
	static char visited[][];
	static String temp = "";
	static int N = 4;
	static int[] cols = new int[N];
	static int cnt;
	static boolean[][] connect;
	public static void main(String[] args) {
		String[] robot = {".......",
						  ".o...*.",
						  ".......",
						  ".*...*.",
						  "......."};
		// TODO Auto-generated method stub
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
		//solution32(board.length,board[0].length(),board);
		//solution33(robot.length,robot[0].length(),robot);
		solution31(board.length,board[0].length(),board);
		/*
		 * triangle	result
			[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30
		 */
//		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
//		solution34(triangle);
		int[] money = {1,2,5};
		solution35(5,money);
		/*
		 * n	k	result
			3	5	[3,1,2]
			[1, 2, 3]
			[1, 3, 2]
			[2, 1, 3]
			[2, 3, 1]
			[3, 1, 2]
			[3, 2, 1]
		 */
		solution36(3,5);
		int[][] cityMap = new int[][] { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };
		solution37(cityMap.length, cityMap[0].length, cityMap);
		int[][] edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
		int[] gps_log =	{1, 2, 3, 3, 6, 7};
		solution38(7, 10, edge_list, 6, gps_log);
		/*
		 * 변수명	값
			n	7
			m	10
			int[][] edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
			k	6
			int[] gps_log =	{1, 2, 3, 3, 6, 7};
			answer	1
			
			변수명	값
			n	7
			m	10
			edge_list	[[1, 2], [1, 3], [2, 3], [2, 4], [3, 4], [3, 5], [4, 6], [5, 6], [5, 7], [6, 7]]
			k	6
			gps_log	[1, 2, 4, 6, 5, 7]
			answer	0
		 */
//		String dirs = "ULURRDLLU"; //7 LULLLLLLU // 7
		String dirs = "LULLLLLLU"; //7 LULLLLLLU // 7
		solution39(dirs);
		solution40(0);
		solution41(3);
		int[] budgets = {120, 110, 140, 150};
		int M = 485;
		solution42(budgets, M);
		solution43(5); // 26
		solution43(6); // 42 1 1 2 3 5 8 13
		int[] weight = {3, 1, 6, 2, 7, 30, 1}; //무게가 각각 [3, 1, 6, 2, 7, 30, 1]인 7개의 저울추를 주어졌을 때, 이 추들로 측정할 수 없는 양의 정수 무게 중 최솟값	21
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		solution45(A, B);
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int n = 4;
		solution46(n, costs);
		solution47(2,9); // {4,5}
		solution48(3); //3
						       //  1  2  3
		int[][] computers = /*1*/{{1, 1, 0}, 
						    /*2*/ {1, 1, 0}, 
						    /*3*/ {0, 0, 1}};
		int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		solution49(3, computers2);
		int[][] road = {{1,2,1},
						{2,3,3},
						{5,2,2},
						{1,4,2},
						{5,3,1},
						{5,4,2}}; // N=5,K=3,result=4
		int[][] road2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}; //N=6,K=4,result=4
		//solution50(5, road, 3);
		solution50(6, road2, 4);
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		//ICN, ATL, ICN, SFO, ATL, SFO
		solution51(tickets);
		String s = "abacde"; //abcdcba	7, abacde	3
		solution52(s);
		/*
		N	stations	W	answer
		11	[4, 11]		1	3
		16	[9]			2	3
		*/
		int[] stations = {9};
		solution53(16, stations, 2);
		/*
		 * nodeinfo	result
[[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]	[[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]
		 */
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		solution55(nodeinfo);
		solution56(5);
		int[] budgets57 = {120, 110, 140, 150};
		solution57(budgets57, 485);
		solution58(tickets);
		/*
		 * n	weak	            dist	        result
		   12	[1, 5, 6, 10]	    [1, 2, 3, 4]	2
		   12	[1, 3, 4, 9, 10]	[3, 5, 7]	    1
		 */
		int[] weak = {1,5,6,10};
		int[] dist = {1,2,3,4};
		solution60(12,weak,dist);
		int[] weak1 = {1,3,4,9,10};
		int[] dist1 = {3,5,7};
		solution60(12,weak1,dist1);
		/*
		 * n	edges	result
		   4	[[1,2],[1,3],[2,3],[2,4],[3,4]]	5
		   8	[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7],[7,8],[8,1],[2,7],[3,6]]	0
		 */
        int[][] edges = {
                {1,2}, {1,3}, {2,3}, {2,4}, {3,4}
//                {1,2}, {2,3}, {3,4}, {4,5}, {5,6},{6,7},{7,8},{8,1},{2,7},{3,6}
        };
        solution61(8, edges);
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] answer = solution62(words, queries);
        for(int ans : answer)
            System.out.print(ans + " ");
        int[][] miro = {{1,0,1,1,1,1},
        		    	{1,0,1,0,1,0},
        		    	{1,0,1,0,1,1},
        		    	{1,1,1,0,1,1}};
        solution63(miro);
        int[][] tomato = {{0,0,0,0,0,0},
        		    	  {0,0,0,0,0,0},
        		    	  {0,0,0,0,0,0},
        		    	  {0,0,0,0,0,1}};
        solution64(tomato);
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
        solution65(inputAry);
        int[][] land = {{1, 0, 1, 0, 0},
        				{1, 0, 0, 0, 0},
        				{1, 0, 1, 0, 1},
        				{1, 0, 0, 1, 0}};
        solution66(land);
        /*
		 * m	n	board	answer
		   3	3	[DBA, C*A, CDB]	ABCD
		   2	4	[NRYN, ARYA]	RYAN
		   4	4	[.ZI., M.**, MZU., .IU.]	MUZI
		   2	2	[AB, BA]	IMPOSSIBLE
		 */
		String[] board67 = {"NRYN", "ARYA"};
		//String[] board67 = {".ZI.", "M.**", "MZU.", ".IU."};
		//String[] board67 = {"DBA", "C*A", "CDB"};
		//String[] board67 = {"AB", "BA"};
        solution67(board67, board67.length, board67[0].length());
        /*
         * cookie	result
         * [1,1,2,3]	3
           [1,2,4,5]	0
         */
        int[] cookie = {1,2,4,5};
        solution68(cookie);
        /*int[][] board69 = {{0,0,0,0,0,0,0,0,0,0},
        				  {0,0,0,0,0,0,0,0,0,0},
        				  {0,0,0,0,0,0,0,0,0,0},
        				  {0,0,0,0,0,0,0,0,0,0},
        				  {0,0,0,0,0,0,4,0,0,0},
        				  {0,0,0,0,0,4,4,0,0,0},
        				  {0,0,0,0,3,0,4,0,0,0},
        				  {0,0,0,2,3,0,0,0,5,5},
        				  {1,2,2,2,3,3,0,0,0,5},
        				  {1,1,1,0,0,0,0,0,0,5}};*/
        solution69(board69);
        /*
         * land	height	result
			[[1, 4, 8, 10], [5, 5, 5, 5], [10, 10, 10, 10], [10, 10, 10, 20]]	3	15
			[[10, 11, 10, 11], [2, 21, 20, 10], [1, 20, 21, 11], [2, 1, 2, 1]]	1	18
         */
        int[][] land70 = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
        solution70(land70, 3);
        solution71("element");
        String[] paths = {"/aa/b/dd", "/aa/b", "/b/dd/a.txt"};
        solution72(paths);
        solution73(4,2);
        int[] row = {2,3};
        int[] col = {1,3};
        char[][] charr = {{'a','b','d','a'},
				  		  {'a','b','d','a'},
				  		  {'a','b','d','a'},
				  		  {'a','b','d','a'}};
        solution74(charr, row, col);
        int[] row_cut = {1,3};
        int[] col_cut = {2,3,4};
        String[] cake = {"AAABB","BCCAA","DDDDD","ZXYAA","ACBAA"};
        solution75(cake, row_cut, col_cut);
        String[] str76 = {"grape", "preag"};
        solution76(str76);
        solution77(2012);
        int[] sticker = {14,6,5,11,3,9,2,10};
        solution78(sticker);
        solution79(sticker);
        int[] arr80 = {1,1,1,1,1,10,10,10,-1,-1};
//        perm(arr80, 0);
//        System.out.println("cnt80:"+cnt80);
        int[] trees = {-1,3,5,7,9};
        trees1(trees);
        String[] names = {"ab","ac","ee","ww","yy"};
        int[][] homes = {{3,4},{-1,5},{3,4},{6,7},{5,2}};
        double[] grades = {4.36,4.56,3.67,3.92,3.33};
        student(names, homes, grades);
        /*baekjoon2669*/
        int[][] square = {{1,2,4,4},
        		   		  {2,3,5,7},
        		   		  {3,1,6,5},
        		   		  {7,3,8,6}};
        solution81(square);
        String[] words82 = {"but","i","wont","hesitate","no","more","no","more","it","cannot","wait","im","yours"};
        solution82(words82);
        /*baekjoon9442*/
        String[] S= {"ANTLER" , "ANY", "COW" , "HILL", "HOW", "HOWEVER", "WHATEVER", "ZONE"};
        String ALPHABET = "UVWXYZNOPQRSTHIJKLMABCDEFG";
        solution83(S, ALPHABET);
        /*
         * strs			t		result
		[ba,na,n,a]	banana	3
		[app,ap,p,l,e,ple,pp]	apple	2
		[ba,an,nan,ban,n]	banana	-1
         */
        String[] str84 = {"app","ap","p","l","e","ple","pp"};//{"ba","na","n","a"};
        String t84 = "apple"; //"banana";
        solution84(str84, t84);
        String begin = "hit";
        String target = "cog";
        String[] words85 = {"hot", "dot", "dog", "lot", "log", "cog"};
        solution85(begin, target, words85);
        /*
         * begin	target	words	return
		hit	cog	[hot, dot, dog, lot, log, cog]	4
		hit	cog	[hot, dot, dog, lot, log]	0
         */
        solution86(5);
        System.out.println();
        solution87(5);

	}
	public static int solution87(int n) {
		int answer = 0, i=0, j=0, k=0, count=1;
		int[][] arr = new int[n][n];
		for(i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				arr[i][j] = 0;
			}
		}
		for(k=0; k<n+n-1; k++) {
			i=0; j=0;
			int a = arr[i][j];
			while(a!=0) {
				if(j!=n-1) {
					j++;
					a = arr[i][j];
				} else {
					i++;
					a = arr[i][j];
				}
			}
			while(i+j==k && 0<=i&&i<=n-1 && 0<=j&&j<=n-1) {
				arr[i][j] = count;
				i++;
				j--;
				count++;
			}
			
		}
		i=0; j=0;

		for(i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
		return answer;
	}
	public static int solution86(int n) {
		int answer = 0, j=0, k=1;
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			if(i%2==0) {
				for(j=0; j<n; j++) {
					arr[i][j] = k;
					k++;
				}
			} else {
				for(j=n-1; j>=0; j--) {
					arr[i][j] = k;
					k++;
				}
			}
			/*
			for(j=0; j<n; j++) {
				if(i+j>n-1) {
					arr[i][j] = i+j-2*(i+j-n+1);
					arr[j][i] = i+j-2*(i+j-n+1);
				} else {
					arr[i][j] = i+j;
					arr[j][i] = i+j;
				}
			}
			*/
			
		}
		for(int i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
		return answer;
	}
	public static int solution85(String begin, String target, String[] words) {
//        int answer = 0;
        int minimum = words.length+1;
        minimum = dfs85(begin, target, words, new boolean[words.length], 0, words.length+1, words.length);
		System.out.println("solution85 min:"+minimum);

        return minimum == words.length+1?0:minimum;
//        return answer;
    }
	public static int dfs85(String word, String target, String[] words, boolean[] visited, int n, int minimum, int maximum) {
		for(int i=0; i<maximum; i++) {
			if(!visited[i] && conversion(word, words[i])) {
				System.out.println(n + " " + minimum + " " + word + " " + words[i]);
				if(words[i].equals(target)) {
					return Math.min(minimum, n+1);
				}
				visited[i] = true;
				int num = dfs85(words[i], target, words, visited, n+1, minimum, maximum);
				if(num<minimum) {
					minimum = num;
				}
				visited[i] = true;
			}
		}
		return minimum;
	}
	public static boolean conversion(String w1, String w2) {
		int tmp = 0;
		for(int i=0; i<w1.length(); i++) {
			if(w1.charAt(i)!=w2.charAt(i)) {
				tmp++;
				if(tmp>1) return false;
			}
		}
		return true;
	}
    public static int solution84(String[] strs, String t) {
        int answer = 0;
        int[] dp = new int[20000];
        for(int p=0; p<t.length(); p++) {
        	int index = p;
        	char c = t.charAt(p);
        	dp[index] = t.length()+1;
        	for(int i=0; i<strs.length; i++) {
        		boolean same = true;
        		int length = strs[i].length()-1;
        		if(strs[i].charAt(length) == c) {
        			for(int k=0; k<=length; k++) {
        				if(t.charAt(index-k) != strs[i].charAt(length-k)) {
        					same = false;
        					break;
        				}
        			}
        			if(same) {
        				if(index-length-1 == -1) {
        					dp[index] = 1;
        				} else {
        					if(dp[index-length-1]+1<dp[index]) {
        						dp[index] = dp[index-length-1]+1;
        					}
        				}
        			}
        		}
        	}
        }
        answer = dp[t.length()-1];
        if(answer>t.length()) {
        	answer = -1;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//        System.out.println("일치하지 않음 -1");
		System.out.println("min:"+answer);

        return answer;
    }
	public static String[] solution83(String[] s, String alpha) {
		String[] answer = new String[s.length];
		int[] table = new int[alpha.length()];
		for(int i=0; i<alpha.length(); i++) {
//			Alpha a = new Alpha(s[i]);
			table[alpha.charAt(i)-'A'] = i;
			System.out.println(alpha.charAt(i)-'A');
		}
		for(int i=0; i<s.length-1; i++) {
			for(int j=i+1; j<s.length; j++) {
				int r = compareTo(s[i], s[j], table);
				if(r==1) {
					String tmp = s[i];
					s[i] = s[j];
					s[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(s));
		return answer;
	}
	public static int compareTo(String str, String other, int[] table) {
		int len = str.length();
		int len2 = other.length();
		int lim = Math.min(len, len2);
		int k=0;
		while(k<lim) {
			int c1 = table[str.charAt(k)-'A'];
			int c2 = table[other.charAt(k)-'A'];
			System.out.println("a.name:"+str+", c1:"+c1+", b.name:"+other+", c2:"+c2);
			if(c1>c2) {
				return 1; //Integer.toString(c1).compareTo(Integer.toString(c2));
			} else if(c1<c2) {
				return -1; //Integer.toString(c1).compareTo(Integer.toString(c2));
			}
			k++;
		}
		return len-len2;
	}
	public static String[] solution82(String[] words) {
		String[] answer = new String[words.length];
		ArrayList<Word> list = new ArrayList<>();
		ArrayList<String> strlist = new ArrayList<>();
		ArrayList<String> newlist = new ArrayList<>();
		for(int i=0; i<words.length; i++) {
			Word w = new Word(words[i].length(), words[i]);
			list.add(w);
		}
		Collections.sort(list);
		System.out.println(list.toString());
		for(int i=0; i<list.size(); i++) {
			strlist.add(list.get(i).name);
		}
		for(int i=0; i<list.size(); i++) {
			if(!newlist.contains(strlist.get(i))) {
				newlist.add(strlist.get(i));
			}
		}
		System.out.println(newlist);

		return answer;
	}
	public static int solution81(int[][] square) {
		int answer = 0;
		ArrayList<Pair> list = new ArrayList<>();
		ArrayList<Pair> a = new ArrayList<>();
		for(int i=0; i<square.length; i++) {
			for(int k=square[i][0]; k<square[i][2]; k++) {
				for(int t=square[i][1]; t<square[i][3]; t++) {
					Pair p = new Pair(k,t);
					list.add(p);
					if(!a.contains(p)) {
						a.add(p);
						System.out.println(p.toString());
//						System.out.println(a.get(i));

					} else {
	//					System.out.println("1. "+Arrays.toString(list.get(index)));
						
					}
//					System.out.println(pos[0]+","+pos[1]);

				}
			}
		}
/*
		for(int i=0; i<list.size(); i++) {
//			System.out.println(i+", "+Arrays.toString(list.get(i)));

			if(!a.contains(list.get(i))) {
				a.add(list.get(i));
//				System.out.println(a.get(i));

			}
		}
*/		
		for(int i=0; i<a.size(); i++) {
			System.out.println(a.get(i).toString());
		}
		System.out.println("answer:"+a.size());

		return answer;
	}
	public static int[] student(String[] names, int[][] homes, double[] grades) {
		int[] answer = new int[names.length];
		ArrayList<Student> list = new ArrayList<>();
		for(int i=0; i<names.length; i++) {
			Student s = new Student(names[i], homes[i], grades[i], i+1);
			list.add(s);
		}
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list.toString());
		return answer;
	}
	public static int trees1(int[] trees) {
		int answer=0, sum=0, cnt=trees.length, min=1000000, prev=0, prev_i=0;
		for(int i=0; i<cnt; i++) {
			sum += trees[i];
		}
		int avg = sum/cnt;
		System.out.println("avg:"+avg);
		for(int i=0; i<cnt; i++) {
			min = Math.min(min, Math.abs(avg-trees[i]));
			System.out.println("min:"+min);
		}
		Arrays.sort(trees);
		for(int i=0; i<cnt; i++) {
			prev = Math.abs(avg-trees[i]);
			if(prev==min) {
				prev_i = i; 
				System.out.println("answer:"+trees[prev_i]);
				return trees[prev_i];
			}
		}
		return answer;
	}
	public static int cnt80 = 0;
	public static void perm(int[] arr, int pivot) {
		if(pivot==arr.length) {
			boolean is_T = true;
			for(int i=0; i<arr.length-1; i++) {
				if(arr[i]+arr[i+1]==20 || arr[i]+arr[i+1]==-2) {
					is_T = false;
				}
			}
			if(is_T) cnt80++;
			return;
		}
		for(int i=pivot; i<arr.length; i++) {
			System.out.println("1. Arr:"+Arrays.toString(arr));
			swap(arr, i, pivot);
			System.out.println("2. Arr:"+Arrays.toString(arr));
			perm(arr, pivot+1);
			swap(arr, i, pivot);
			System.out.println("3. Arr:"+Arrays.toString(arr));
		}
		
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int solution79(int sticker[]) {
        int answer = 36;
        int[] dp = new int[sticker.length];
        int temp1=0, temp2=0;
        dp[0] = sticker[0];
        dp[1] = dp[0];
        for(int i=2; i<sticker.length-1; i++) {
        	dp[i] = Math.max(dp[i-1], dp[i-2]+sticker[i]);
        }
        temp1 = dp[sticker.length-2];
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i=2; i<sticker.length; i++) {
        	dp[i] = Math.max(dp[i-1], dp[i-2]+sticker[i]);
        }
        temp2 = dp[sticker.length-1];
        answer = Math.max(temp1, temp2);
        System.out.println("max answer:"+answer);
        return answer;
	}
	public static int solution78(int sticker[]) {
        int answer = 36;
        int max = 0, sum = 0;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        for(int i=0; i<sticker.length; i++) {
        	
        	for(int j=i; j<sticker.length; j++) {
        		TreeMap<Integer, Integer> tm = new TreeMap<>();
                for(int k=0; k<sticker.length; k++) {
                	tm.put(k, sticker[k]);
                }
	        	sum = pivot78(tm, sticker, j);
	        	if(sum>max) {
	        		max = sum;
	        	}
        	}
        }
        answer = max;
        System.out.println("max:"+max);

        return answer;
    }
	public static int pivot78(TreeMap<Integer, Integer> tm, int sticker[], int pivot) {
		int sum = 0;

		
//        System.out.println("tm:"+tm+", pivot:"+(pivot+sticker.length));
        for(int i=pivot; i<8; i++) {
        	if(i>sticker.length-1) {
        		i = i - (sticker.length);
//                System.out.println("1. tm:"+tm);

        	}
	        int a = tm.get(i);
	        if(a!=0) {
//	            System.out.println("2. tm:"+tm);

	        	sum += a;
	        	
	        	if(i==0) {
	        		tm.replace(i+1, 0);
	        		tm.replace(sticker.length-1, 0);
//	                System.out.println("5. tm:"+tm);

	        	} else if(i==sticker.length-1) {
	        		tm.replace(i-1, 0);
	        		tm.replace(0, 0);
//	                System.out.println("4. tm:"+tm);

	        	} else {
	        		tm.replace(i+1, 0);
	        		tm.replace(i-1, 0);
//	                System.out.println("3. tm:"+tm);

	        	}
	        }
//	        System.out.println("6. tm:"+tm);

        }
//        System.out.println("tm:"+tm);

		return sum;
	}
	public static int solution77(int n) {
		int answer = 0;
		String str = "";
		int cnt = 0;
		n++;
		
		while(true) {
			str = Integer.toString(n);
			boolean b = true;
			char[] ch = str.toCharArray();
			for(int i=1; i<ch.length; i++) {
				for(int j=0; j<i; j++) {
					if(ch[j] == ch[i]) {
						b = false;
						break;
					}
				}
			}
			if(b) {
				answer += n;
				cnt++;
				System.out.println("n:"+n+", answer:"+answer);
				if(cnt==5) {
					return answer;
				}
			}
			n++;
		}
		//return answer;
	}
	public static void solution76(String[] arr) {
		char[] ch1 = arr[0].toCharArray();
		Arrays.sort(ch1);
		char[] ch2 = arr[1].toCharArray();
		Arrays.sort(ch2);
		if(ch1.equals(ch2)) {
			System.out.println("not same:"+Arrays.toString(ch1)+", "+Arrays.toString(ch2));
		} else {
			System.out.println("same:"+Arrays.toString(ch1)+", "+Arrays.toString(ch2));
		}
	}
	public static void solution75(String[] arr, int[] row, int[] col) {
		int n = arr.length;
		int m = arr[0].length();
		char[][] ch = new char[n][m];

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				ch[i][j] = arr[i].toCharArray()[j];
				System.out.print(ch[i][j]);
			}
			System.out.println();
		}
		int[] new_row = new int[row.length+2];
		new_row[0] = 0;
		new_row[new_row.length-1] = n;
		for(int i=1; i<new_row.length-1; i++) {
			new_row[i] = row[i-1];
		}
		int[] new_col = new int[col.length+2];
		new_col[0] = 0;
		new_col[new_col.length-1] = m;
		for(int i=1; i<new_col.length-1; i++) {
			new_col[i] = col[i-1];
		}
		HashMap<Character, Integer> hm;// = new HashMap<>();
		ArrayList<HashMap<Character, Integer>> list = new ArrayList<>();

		int k=0, t=0;
		while(k<new_row.length-1) {
			while(t<new_col.length-1) {					
				hm = new HashMap<>();
				for(int i=0; i<n; i++) {
					for(int j=0; j<m; j++) {									
						if(new_row[k]<=i && i<new_row[k+1] && new_col[t]<=j && j<new_col[t+1]) {
							System.out.println("1. new_row[k]:"+new_row[k]+", new_row[k+1]:"+new_row[k+1]+", new_col[k]"+new_col[k]+", new_col[k+1]:"+new_col[k+1]);

							if(hm.containsKey(ch[i][j]) == false) {
								hm.put(ch[i][j], 1);
								System.out.println("1. 리스트:"+hm.toString());

							} else {
								hm.put(ch[i][j], hm.get(ch[i][j])+1);		
								System.out.println("2. 리스트:"+hm.toString());

							}
						}
						
					}
					
				}	
				t++;
				list.add(hm);
			}
			t=0;
			k++;
		}

		int max = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).size() > max) {
				max = list.get(i).size();
			}
			Set<Character> key = list.get(i).keySet();

			System.out.println("리스트:"+key.toString());

		}
		System.out.println("사이즈:"+max);
	}
	public static void solution74(char[][] arr, int[] row, int[] col) {
		int n = arr.length;
		ArrayList<ArrayList<Pair>> listall = new ArrayList<>();

		ArrayList<Pair> list = new ArrayList<>();
		ArrayList<Pair> list2 = new ArrayList<>();
		ArrayList<Pair> list3 = new ArrayList<>();
		ArrayList<Pair> list4 = new ArrayList<>();
		ArrayList<Pair> list5 = new ArrayList<>();
		ArrayList<Pair> list6 = new ArrayList<>();
		ArrayList<Pair> list7= new ArrayList<>();
		ArrayList<Pair> list8 = new ArrayList<>();
		ArrayList<Pair> list9 = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(0<=i && i<row[0] && 0<=j && j<col[0]) {
					list.add(new Pair(i,j));
				}
				if(0<=i && i<row[0] && col[0]<=j && j<col[1]) {
					list2.add(new Pair(i,j));
				}
				if(0<=i && i<row[0] && col[1]<=j && j<n) {
					list3.add(new Pair(i,j));
				}
				if(row[0]<=i && i<row[1] && 0<=j && j<col[0]) {
					list4.add(new Pair(i,j));
				}
				if(row[0]<=i && i<row[1] && col[0]<=j && j<col[1]) {
					list5.add(new Pair(i,j));
				}
				if(row[0]<=i && i<row[1] && col[1]<=j && j<n) {
					list6.add(new Pair(i,j));
				}
				if(row[1]<=i && i<n && 0<=j && j<col[0]) {
					list7.add(new Pair(i,j));
				}
				if(row[1]<=i && i<n && col[0]<=j && j<col[1]) {
					list8.add(new Pair(i,j));
				}
				if(row[1]<=i && i<n && col[1]<=j && j<n) {
					list9.add(new Pair(i,j));
				}
			}
		}
		listall.add(list);
		listall.add(list2);
		listall.add(list3);
		listall.add(list4);
		listall.add(list5);
		listall.add(list6);
		listall.add(list7);
		listall.add(list8);
		listall.add(list9);
		
		for(int i=0; i<listall.size(); i++) {
			for(int j=0; j<listall.get(i).size(); j++) {
				System.out.print(listall.get(i).get(j).x+", "+listall.get(i).get(j).y+"  ");
			}
			System.out.println();
		}
		
	}
	static int RIGHT = 0;
	static int DOWN = 1;
	static int LEFT = 2;
	static int UP = 3;
	static int[][] matrix = new int[4][4];
	static boolean[][] visit73 = new boolean[4][4];
	static int m73 = matrix.length;
	static int n73 = matrix[0].length;
	static int INIT_VALUE = -1;
	public static boolean isMovable(int x, int y) {
		if(x>=m73 || y>=n73 || x<0 || y<0 || visit73[x][y] == true) //matrix[x][y] != INIT_VALUE)
			return false;
		return true;
	}
	public static void init() {
		for(int i=0; i<m73; i++) {
			for(int j=0; j<n73; j++) {
				matrix[i][j] = INIT_VALUE;
			}
		}
	}
	public static int[] getNextPosition(int[] position, int direction) {
		int x = position[0];
		int y = position[1];
		int nowDirection = direction%4;
		if(nowDirection == RIGHT) {
//			System.out.println("RIGHT: x:"+x+", y:"+y);
			y++;
		}
		else if(nowDirection == DOWN) {
//			System.out.println("DOWN: x:"+x+", y:"+y);
			x++;
		}
		else if(nowDirection == LEFT) {
//			System.out.println("LEFT: x:"+x+", y:"+y);
			y--;
		}
		else {
//			System.out.println("UP: x:"+x+", y:"+y);
			x--;
		}
		return new int[]{x,y};
	}
	static int cnt73 = 0;
	static int nowNumber = 1;
	static ArrayList<int[]> list73 = new ArrayList<>();
	public static boolean move(int[] position, int direction) {
//		int nowNumber = matrix[position[0]][position[1]];
		boolean moved = false;
		int[] nextPosition = getNextPosition(position, direction);
		while(isMovable(nextPosition[0], nextPosition[1])) {
//			System.out.println("cnt73:"+cnt73);
			moved = true;
			visit73[nextPosition[0]][nextPosition[1]] = moved;
			cnt73++;
			position[0] = nextPosition[0];
			position[1] = nextPosition[1];
			if(cnt73==3)
			{
				nowNumber++;
				matrix[position[0]][position[1]] = nowNumber;
				cnt73 = 0;
				list73.add(position);

			} else {
//				matrix[position[0]][position[1]] = 0;

			}
			nextPosition = getNextPosition(position, direction);
		}
		return moved;
	}
	public static void solution73(int n, int jump) {
//		init();
		matrix[0][0] = 1;
		visit73[0][0] = true;
		int[] startPosition = new int[]{0,0};
		int direction = RIGHT;
		while(move(startPosition, direction))
			direction++;
		
		for(int i=0; i<m73; i++) {
			for(int j=0; j<n73; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		/*
		for(int i=0; i<m73; i++) {
			for(int j=0; j<n73; j++) {
				System.out.print(visit73[i][j]+" ");
			}
			System.out.println();
		}
		*/
		System.out.println("answer: "+list73.get(list73.size()-1)[0]+", "+list73.get(list73.size()-1)[1]);
	}
	public static void solution72(String[] str) {
		int fcnt=0, dcnt=0;
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<str.length; i++) {
			String[] sub = str[i].split("/");
			for(int j=0; j<sub.length; j++) {
				if(list.contains(sub[j])==false) {
					list.add(sub[j]);
				}
			}
		}
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));

			if(list.get(i).contains("txt")) {
				fcnt++;
			} else if(!list.get(i).equals("")){
				dcnt++;
			}
		}
		System.out.println("파일수:"+fcnt+", 경로수:"+dcnt);
	}
	public static String solution71(String str) {
		String answer = "";
		char[] ch = str.toCharArray();
		TreeMap<Character, Integer> hm = new TreeMap<>();
		for(int i=0; i<str.length(); i++) {
			if(hm.containsKey(ch[i])==false) 
			{
				hm.put(ch[i], 1);
			} else {
				hm.put(ch[i], hm.get(ch[i])+1);
			}
		}
		Set<Character> key = hm.keySet(); 
		int max = 0;
		for(char c:key) {
			System.out.println(c+","+hm.get(c));
			if(hm.get(c)> max) {
				max = hm.get(c);
				answer = c + "";
			} else if(hm.get(c) == max) {
				answer += c;
			}
		}
		System.out.println("answer:"+answer);

		return answer;
	}
	/*
	 * int dr[4] = {-1, 0, 1, 0}; 
int dc[4] = {0, 1, 0, -1}; 
int root[90000]; 
int N, M; 
bool visited[301][301]; 
int map[301][301]; 
vector<vector<int>> graph; 

int find(int u){ // 자기 자신의 부모 노드 번호 찾기
    if(u == root[u]) return u; 
    else return find(root[u]); 
}


void Numbering(int st_r, int st_c, int ch_num, vector<vector<int>> &land , int height){
    queue<pair<int,int>> q; 
    q.push(make_pair(st_r, st_c)); 
    map[st_r][st_c] = ch_num; 
    visited[st_r][st_c] = true ;

    while(!q.empty()){
        int cur_r = q.front().first; 
        int cur_c = q.front().second; 
        q.pop(); 

        for(int i=0; i<4; i++){
            int rr = cur_r + dr[i]; 
            int cc = cur_c + dc[i]; 
            if(rr>=0 && rr<N && cc>=0 && cc <M){
                if(!visited[rr][cc] && abs(land[cur_r][cur_c] - land[rr][cc]) <=height){
                    visited[rr][cc] = true; 
                    map[rr][cc] = ch_num; 
                    q.push(make_pair(rr,cc)); 
                }
            }
        }
    }
}



int solution(vector<vector<int>> land, int height) {
    int answer = 0;
    int ch_num = 1; 
    N = land.size(), M = land[0].size(); 

    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            if(!visited[i][j]){
                Numbering(i,j,ch_num++,land, height); 
            }
        }
    }    

    graph = vector<vector<int>> (ch_num, vector<int> (ch_num, 987654321)); 

    for(int i=0; i<N; i++){ // 각 구역간의 갈 수 있는 그래프 완성 
        for(int j=0; j<M; j++){
            for(int k=1; k<3; k++){
                int rr = i + dr[k]; 
                int cc = j + dc[k]; 
                if(rr >=0 && rr<N && cc>=0 && cc<M){
                    if(map[i][j] != map[rr][cc] ){
                        graph[map[rr][cc]][map[i][j]] = graph[ map[i][j]][map[rr][cc]] = min(graph[map[i][j]][map[rr][cc]], abs(land[i][j] - land[rr][cc])); 

                    }
                }
            }
        }
    }    

    priority_queue<pair<int, pair<int,int>>> pq; 
    for(int i=0; i<ch_num; i++){
        for(int j=i+1; j<ch_num; j++){
            if(graph[i][j] != 987654321)
                pq.push({-graph[i][j], {i, j}}); 
        }
    }

     // MST 최소 미니멈 트리 사용. 
    for(int i=1; i<ch_num; i++) // 부모노드들 최소화 
        root[i] = i; 

    while(!pq.empty()){
        int u = pq.top().second.first; 
        int v = pq.top().second.second; 
        int weight = -pq.top().first;
        pq.pop(); 

        u = find(u); 
        v = find(v); 

        if(u == v)    continue; 

        answer += weight; 
        if( u > v ) 
            root[u] = v; 
        else 
            root[v] = u; 

    }

    return answer;
}
	 */
	public static int solution70(int[][] land, int height) {
        int answer = 0;
        int n = land.length;
        visited70 = new boolean[n][n];
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
		        answer += dfs70(land, i, j, height);
        	}
        }
        System.out.println("answer70:"+answer);
        return answer;
    }
	static boolean[][] visited70;
	public static int dfs70(int[][] land, int x, int y, int height) {
        int answer = 0;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int n = land.length;
        int flag = 0;
        int max = 0;
        for(int k=0; k<4; k++) {
        	flag = 0;
        	int nx = x + dx[k];
        	int ny = y + dy[k];
        	if(nx>=0&&ny>=0&&nx<n&&ny<n) {
        		max = Math.abs(land[x][y]-land[nx][ny]);
        		if(max<=height && visited70[x][y]==false) {
                	System.out.println("1. 최대값:"+max+", x:"+x+", y:"+y+", nx:"+nx+", ny:"+ny);
                	visited70[x][y] = true;
        			flag = 1;
        			dfs70(land, nx, ny, height);
        		} else {
        			visited70[nx][ny] = true;
        		}
        	}
        }
        if(flag==0) {
        	System.out.println("최대값:"+max);
        	return max;
        }

        return answer;
    }
	static int[][] board69 = {{0,0,0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,4,0,0,0},
			  {0,0,0,0,0,4,4,0,0,0},
			  {0,0,0,0,3,0,4,0,0,0},
			  {0,0,0,2,3,0,0,0,5,5},
			  {1,2,2,2,3,3,0,0,0,5},
			  {1,1,1,0,0,0,0,0,0,5}};
	static int n69 = board69.length;

	public static boolean drop(int x, int y, int value) {
		for(int i=0; i<x; i++) {
			if(board69[i][y]==0) continue;
			if(board69[i][y]!=value) return false;
		}
		return true;
	}
	public static void remove(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		board69[x1][y1] = 0;
		board69[x2][y2] = 0;
		board69[x3][y3] = 0;
		board69[x4][y4] = 0;
		
	}
	public static boolean isA(int x, int y) {
		int num = board69[x][y];
		if(y+2>=n69 || x+1>=n69) return false;
		return board69[x+1][y]==num && board69[x+1][y+1]==num && board69[x+1][y+2]==num;
	}
	public static boolean isB(int x, int y) {
		int num = board69[x][y];
		if(y-1<0 || x+2>=n69) return false;
		return board69[x+1][y]==num && board69[x+2][y]==num && board69[x+2][y-1]==num;
	}
	public static boolean isC(int x, int y) {
		int num = board69[x][y];
		if(y+1>=n69 || x+2>=n69) return false;
		return board69[x+1][y]==num && board69[x+2][y]==num && board69[x+2][y+1]==num;
	}
	public static boolean isD(int x, int y) {
		int num = board69[x][y];
		if(y-2<0 || x+1>=n69) return false;
		return board69[x+1][y]==num && board69[x+1][y-1]==num && board69[x+1][y-2]==num;
	}
	public static boolean isE(int x, int y) {
		int num = board69[x][y];
		if(y+1>=n69 || y-1<0 || x+1>=n69) return false;
		return board69[x+1][y]==num && board69[x+1][y+1]==num && board69[x+1][y-1]==num;
	}
	public static int solution69(int[][] board) {
        int answer = 0;
        System.out.println("n69:"+n69);
        for(int i=0; i<n69; i++) {
        	for(int j=0; j<n69; j++) {
        		if(board69[i][j]==0) continue;
        		if(isA(i,j)) {
        	        System.out.println("A n69:"+n69);

        			if(drop(i+1, j+1, board69[i][j]) && drop(i+1, j+2, board69[i][j])) {
        				remove(i,j,i+1,j,i+1,j+1,i+1,j+2);
        				j=-1;
        				answer++;
        			}
        		}
        		else if(isB(i,j)) {
        	        System.out.println("B n69:"+n69);

        			if(drop(i+2, j-1, board69[i][j])) {
        				remove(i,j,i+1,j,i+2,j,i+2,j-1);
        				j=-1;
        				answer++;
        			}
        		}
        		else if(isC(i,j)) {
        	        System.out.println("C n69:"+n69);

        			if(drop(i+2, j+1, board69[i][j])) {
        				remove(i,j,i+1,j,i+2,j,i+2,j+1);
        				j=-1;
        				answer++;
        			}
        		} 
        		else if(isD(i,j)) {
        	        System.out.println("D n69:"+n69);

        			if(drop(i+1, j-1, board69[i][j]) && drop(i+1, j-2, board69[i][j])) {
        				remove(i,j,i+1,j,i+1,j-1,i+1,j-2);
        				j=-1;
        				answer++;
        			}
        		}
        		else if(isE(i,j)) {
        	        System.out.println("E n69:"+n69);

        			if(drop(i+1, j+1, board69[i][j]) && drop(i+1, j-1, board69[i][j])) {
        				remove(i,j,i+1,j,i+1,j-1,i+1,j+1);
        				j=-1;
        				answer++;
        			}
        		}
        	}
        }
        System.out.println("answer:"+answer);
        return answer;
    }
	public static int solution68(int[] cookie) {
        int answer = -1;
        int max = 0;
        int frontSum = 0, backSum = 0, indexOfFrontSum = 0, indexOfBackSum = 0;
        if(cookie.length < 2) {
        	return 0;
        }
        if(cookie.length == 2) {
        	if(cookie[0] == cookie[1]) {
        		return cookie[0];
        	} else {
        		return 0;
        	}
        }
        for(int i=0; i<cookie.length-1; i++) {
        	indexOfFrontSum = i;
        	frontSum = cookie[i];
        	
        	indexOfBackSum = i+1;
        	backSum = cookie[i+1];
        	while(true) {
        		if(frontSum == backSum) {
        			max = Math.max(frontSum, max);
        		} 
        		if(indexOfFrontSum>0 && frontSum<=backSum) {
        			indexOfFrontSum--;
        			frontSum += cookie[indexOfFrontSum];
        		} else if(indexOfBackSum<cookie.length-1 && frontSum>=backSum) {
        			indexOfBackSum++;
        			backSum += cookie[indexOfBackSum];
        		} else {
        			break;
        		}
        	}
        	answer = max;
        }
        System.out.println("answer:"+answer);
        return answer;
    }
	static char[][] arr67;
	public static String solution67(String[] str, int n, int m) {
		String answer = "";
		arr67 = new char[n][m];
		visited67 = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr67[i][j] = str[i].charAt(j);
			}
		}
		int end = 0;
		int row=0, col=0;
		while(true) {
			for(int k=0; k<26; k++) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<m; j++) {
						if(arr67[i][j] == k+'A') {
							dfs67(arr67, i, j, arr67[i][j]);
						}

					}
				}				
			}
			
			for(row=0; row<n; row++) {
				for(col=0; col<m; col++) {
					if(arr67[row][col] == '.' || arr67[row][col] == '*') {
						end = 1;
					} else {
						end = 0;
						break;
					}
				}
				if(end == 0) {
					break;
				}
			}
			if(end == 1) {
//				System.out.println("row"+row+", col:"+col);
				break;
			} 
			/*
			if(end == 0) {
				System.out.println("IMPOSSIBLE: row"+row+", col:"+col);
				answer = "IMPOSSIBLE";
				if(row==0 && col==0)
					return answer;
			}
			*/
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr67[i][j]+" ");
			}
			System.out.println();
		}
		/*
		answer += str67.charAt(0);
		int cnt = 1;
		for(int i=1; i<str67.length(); i++) {
			if(answer.charAt(cnt-1) == str67.charAt(i)) {
				
				
			} else {
				answer += str67.charAt(i);
				cnt++;
			}
		}
		System.out.println("str67:"+str67);
		*/
		answer = str67;
		System.out.println("answer:"+answer);
		return answer;
	}
	static String str67 = "";
	static int cnt67;
	static boolean visited67[][];
	static int ox=0, oy=0;
	public static void dfs67(char[][] arr, int x, int y, char c) {
		int n = arr.length;
		int m = arr[0].length;
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && ny>=0 && nx<n && ny<m) {
				if(arr67[nx][ny]!='*') {
					if(arr67[nx][ny] == c) {
						if(visited67[nx][ny] != true) {																		
							if(x>=0 && y>=0 && x<n && y<m) {
								if(!str67.contains(arr67[nx][ny]+""))
									str67 += arr67[nx][ny];	
//								System.out.println("x:"+x+", y:"+y+", nx:"+nx+", ny"+ny);
								arr67[nx][ny] = '.';
								arr67[x][y] = '.';
								
								if(cnt67!=0) {
									arr67[ox][oy] = '.';
								}
								return;
							} 
						}
					} else if(arr67[nx][ny] == '.') {
						cnt67++;
						if(x<n && ny==y) {
							if(cnt67==1) {								
								ox = x;
								oy = y;
								visited67[ox][oy] = true;
							}
							dfs67(arr67, ++x, y, c);
						}
						else if(y<m && nx==x) {
							if(cnt67==1) {								
								ox = x;
								oy = y;
								visited67[ox][oy] = true;
							}							
							dfs67(arr67, x, ++y, c);
						}						
					} else {												
						continue;
					}
				}
			}
		}		
	}
	static int[] dx66 = {0,0,1,-1,1,-1,1,-1};
	static int[] dy66 = {1,-1,0,0,1,-1,-1,1};
	static boolean[][] visit66 = new boolean[4][6];
	static int[][] group66;
	public static int solution66(int[][] land) {
		int answer = 0;
		group66 = new int[4][5];
		int cnt = 0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<5; j++) {
				if(land[i][j]==1 && group66[i][j]==0) {
					dfs66(land, i, j, land.length, land[0].length, ++cnt);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<4; i++) {
			for(int j=0; j<5; j++) {
				if(group66[i][j] > max) {
					max = group66[i][j];
				}
				System.out.print(group66[i][j]+" ");
			}
			System.out.println();
		}
		answer = max;
		System.out.println("answer:"+answer);
		return answer;
	}
	public static void dfs66(int[][] input, int x, int y, int n, int m, int cnt) {
		group66[x][y] = cnt;
    	for(int i=0; i<8; i++) {
    		int nx = x+dx66[i];
    		int ny = y+dy66[i];
    		if(nx>=0 && ny>=0 && nx<n && ny<m) {
    			if(input[nx][ny]==1 && group66[nx][ny]==0) {
    				dfs66(input, nx, ny, n, m, cnt);
    			}
    		}
    	}
	}
	static int[][] dist65;
	static int[][] group;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static int solution65(int[][] inputAry) {
		int answer = 0;
		group = new int[10][10];
		int cnt = 0;
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(inputAry[i][j] == 1 && group[i][j] == 0) {
                    dfs65(inputAry, i,j,10,++cnt);
                }
            }
        }
        answer = Integer.MAX_VALUE;
        for(int i = 1; i <= cnt; i++) {
            answer = Math.min(answer, bfs65(i, 10)); 
        }
        System.out.println("answer:"+answer);
		return answer;
	}
    public static void dfs65(int[][] input, int x, int y, int n, int cnt) {
    	group[x][y] = cnt;
    	for(int i=0; i<4; i++) {
    		int nx = x+dx[i];
    		int ny = y+dy[i];
    		if(nx>=0 && ny>=0 && nx<n && ny<n) {
    			if(input[nx][ny]==1 && group[nx][ny]==0) {
    				dfs65(input, nx, ny, n, cnt);
    			}
    		}
    	}
    }
    public static int bfs65(int cnt, int n) {
    	Queue<Pair> q = new LinkedList<Pair>();
    	dist65 = new int[10][10];
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(group[i][j]==cnt) {	// 같은 섬
    				dist65[i][j] = 0;
    				q.add(new Pair(i,j));
    			} else if(group[i][j]==0) { // 바다
    				dist65[i][j] = -1;
    			} else { // 다른 섬
    				dist65[i][j] = -2;
    			}
    		}
    	}
    	int min = Integer.MAX_VALUE;
    	while(!q.isEmpty()) {
    		Pair p = q.remove();
    		int x = p.x;
    		int y = p.y;
    		for(int i=0; i<4; i++) {
    			int nx = x+dx[i];
    			int ny = y+dy[i];
    			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
    				if(dist65[nx][ny]==-2) {
    					min = Math.min(min, dist65[x][y]);
    					continue;
    				} else if(dist65[nx][ny]==-1) {
    					q.add(new Pair(nx, ny));
    					dist65[nx][ny] = dist65[x][y]+1;
    				}
    			}
    		}
    	}
    	System.out.println("min:"+min);
    	return min;
    }
	public static int solution64(int[][] tomato) {
		int answer = 0;
		int n = tomato.length;
		int m = tomato[0].length;
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		Queue<Pair> q = new LinkedList<Pair>();
		int[][] dist = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dist[i][j] = -1;
				if(tomato[i][j] == 1) {
					q.add(new Pair(i,j));
					dist[i][j] = 0;
				}
			}
		}
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(dist[nx][ny]==-1 && tomato[nx][ny]==0) {
						q.add(new Pair(nx, ny));
						dist[nx][ny] = dist[x][y] + 1;
					}
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(dist[i][j]+" ");
				if(answer<dist[i][j]) {
					answer = dist[i][j];
				}
			}
			System.out.println();
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(tomato[i][j]==0&&dist[i][j]==-1) {
					answer = -1;
				}
			}
		}
		
		System.out.println("answer:"+answer);
		return answer;
	}
	public static int solution63(int[][] miro) {
		int answer = 0;
		int n = miro.length;
		int m = miro[0].length;
		boolean[][] check = new boolean[n][m];
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		Queue<Pair> q = new LinkedList<Pair>();
		int[][] a = new int[n][m];
		a[0][0] = 1;
		check[0][0] = true;
		q.add(new Pair(0,0));
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(!check[nx][ny] && miro[nx][ny]==1) {
						q.add(new Pair(nx, ny));
						check[nx][ny] = true;
						a[nx][ny] = a[x][y] + 1;
					}
				}
			}
		}
		System.out.println();
		System.out.println("answer:"+a[n-1][m-1]);
		return answer;
	}
	static Trie_SearchLyrics[] tries = new Trie_SearchLyrics[10001];
	static Trie_SearchLyrics[] tries_reversed = new Trie_SearchLyrics[10001];
	
	public static int[] solution62(String[] words, String[] queries) {
        int[] answer = {};
        for(String word:words) {
        	int size = word.length();
        	if(tries[size] == null) {
        		tries[size] = new Trie_SearchLyrics();
        	}
        	tries[size].insert(word);
        	
        	StringBuilder sb = new StringBuilder(word);
        	String wordReversed = sb.reverse().toString();
        	if(tries_reversed[size] == null) {
        		tries_reversed[size] = new Trie_SearchLyrics();
        	}
        	tries_reversed[size].insert(wordReversed);
        }
        ArrayList<Integer> answers = new ArrayList<>();
        for(String query : queries){
            int size = query.length();

            //만약에 뒤에 ?가 있다면 -> 해당 단어 개수에 맞는 트라이로 가서 검색
            if(query.charAt(query.length()-1) == '?'){
                if(tries[size] == null) answers.add(0);
                else {
                    int tmp = tries[size].search(query);
                    answers.add(tmp);
                }
            }

            //앞에 ?가 있다면 -> 해당 단어 개수에 맞는 트라이로 가서 검색
            else {
                StringBuilder sb = new StringBuilder(query);
                String queryReversed = sb.reverse().toString();

                if(tries_reversed[size] == null) answers.add(0);
                else {
                    int tmp = tries_reversed[size].search(queryReversed);
                    answers.add(tmp);
                }
            }
        }

        answer = new int[answers.size()];
        for(int i=0; i<answer.length; ++i){
            answer[i] = answers.get(i);
        }
        return answer;
	}
	static int[] parent;
	public static int solution61(int n, int[][] edges) {
        int answer = 0;
        Edge_RemoveCycle[] edgesInfo = new Edge_RemoveCycle[edges.length];
        for(int i=0; i<edges.length; i++) {
        	edgesInfo[i] = new Edge_RemoveCycle(edges[i][0], edges[i][1]);
        }
        for(int node=1; node<=n; node++) {
        	initParent(n);
        	boolean find = false;
        	for(Edge_RemoveCycle edge: edgesInfo) {
        		if(edge.v1 == node || edge.v2 == node) {
        			continue;
        		}
        		if(!isSameParent(edge.v1, edge.v2)) {
        			union(edge.v1, edge.v2);
        		} else {
        			find = true;
        			break;
        		}
        	}
        	if(!find) {
            	answer += node;
            }
        }
        
        System.out.println("answer:"+answer);
        return answer;
    }

    public static int find(int x) {
    	if(x==parent[x]) {
    		return x;
    	} else {
    		parent[x] = find(parent[x]);
    		return parent[x];
    	}
    }
    public static void union(int x, int y) {
    	x = find(x);
    	y = find(y);
    	if(x!=y) {
    		parent[y] = x;
    	}
    }
    public static boolean isSameParent(int x, int y) {
    	x = find(x);
    	y = find(y);
    	if(x==y) {
    		return true;
    	} else {
    		return false;
    	}
    }
    public static void initParent(int n) {
    	parent = new int[n+1];
    	for(int i=1; i<=n; i++) {
    		parent[i] = i;
    	}
    }
	public static int[] solution59(String[] genres, int[] plays) {
        int[] answer = {};
        return answer;
    }
	
	static int n=12, num = 0;
    static boolean finish = false;
    static int[] weak, dist, choice;
    static int[][] rotateWeak;

    public static int solution60(int n, int[] weak, int[] dist) {
        setWeak(weak);

        for (int i = 1; i <= dist.length; i++) {
            num = i;
            System.out.println("num:"+num);
            choice = new int[num];
            permutation(0, new boolean[dist.length], dist);
            if (finish) break;
        }
        
        return (finish) ? num : -1;
    }

    public static void permutation(int depth, boolean[] visit, int[] dist) {
        if (finish) { return; }
        if (depth == num) {
//        	System.out.println("depth==num");
            check();
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!visit[i]) {
                choice[depth] = dist[i];
//                System.out.println("0. choice[depth]:"+choice[depth]+", depth:"+depth);
                visit[i] = true;
                permutation(depth + 1, visit, dist);
//                System.out.println("1. choice[depth]:"+choice[depth]+", depth:"+depth);
                visit[i] = false;
            }
        }
    }

    public static void check() {
        for (int[] weak : rotateWeak) {
            int idx = 0, start = 0;
            boolean[] visit = new boolean[weak.length];

            while (idx != num) {
                int i = start;
                int value = choice[idx++];
//                System.out.println(Arrays.toString(choice));
                for (int j = start; j < weak.length; j++) {
                    if (!(weak[i] <= weak[j] && weak[j] <= weak[i] + value)) {
//                    	System.out.println("0. weak[i]:"+weak[i]+", weak[j]:"+weak[j]+", value:"+value);
                    	break;
                    } else {
//                    	System.out.println("1. weak[i]:"+weak[i]+", weak[j]:"+weak[j]+", value:"+value);
                    }
                    visit[j] = true;
                    start++;
                }
            }

            if (isFinish(visit)) {
                finish = true;
                return;
            }
        }
    }

    public static boolean isFinish(boolean[] visit) {
        for (boolean bool : visit) {
            if (!bool) return false;
        }
        return true;
    }

    public static void setWeak(int[] weak) { // weak를 0 ~ n-1번 회전하여 rotateWeak에 저장
        int len = weak.length;
        rotateWeak = new int[len][len];

        for (int i = 0; i < len; i++) {
            rotateWeak[i] = rotate(weak, i);
            System.out.println(Arrays.toString(rotateWeak[i]));
        }
        
    }

    public static int[] rotate(int[] weak, int idx) {
        int len = weak.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (i + idx < len) {
            	result[i] = weak[i + idx];
            } else {
            	result[i] = weak[i + idx - len] + n;
            }
        }
        return result;
    }
	
	static ArrayList<String> list58 = new ArrayList<String>();
	static String route58 = "";
	static boolean[] visit58;
	public static String[] solution58(String[][] tickets) {
        String[] answer = {};
        for(int i=0; i<tickets.length; i++) {
        	String start = tickets[i][0];
        	String end = tickets[i][1];
        	visit58 = new boolean[tickets.length];
        	if(start.equals("ICN")) {
        		route = start + ",";
        		visit58[i] = true;
        		dfs58(tickets, end, 1);
        	}
        }
        Collections.sort(list58);
        answer = list58.get(0).split(",");
        System.out.println("list:"+Arrays.toString(answer));
        return answer;
    }
	public static void dfs58(String[][] tickets, String end, int cnt) {
		route += end + ",";
        if(cnt==tickets.length) {
        	list58.add(route);
        	return;
        }
        for(int i=0; i<tickets.length; i++) {
        	String s = tickets[i][0];
        	String e = tickets[i][1];
        	if(end.equals(s) && !visit58[i]) {        		
        		visit58[i] = true;
        		dfs58(tickets, e, cnt+1);
        		visit58[i] = false;
				route = route.substring(0, route.length()-4);
        	}
        }
    }
	public static int solution57(int[] budgets, int M) {
        int answer = 0;
        int right=0, left=0, middle=0;
        for(int budget:budgets) {
        	if(budget>right) {
        		right = budget;
        	}
        }
        while(left<=right) {
        	long sum=0;
        	middle = (right+left)/2;
        	for(int budget:budgets) {
        		if(budget>=middle) {
        			sum += middle;
        		} else {
        			sum += budget;
        		}
        	}
        	if(sum>M) {
        		right = middle-1;
        	} else {
        		answer = middle;
        		left = middle+1;
        	}
        }
        System.out.println("middle:"+answer);
        return answer;
    }
	public static int solution56(int n) {
	     int answer = 0;
	     if(n==1) {
	    	 return 1;
	     }
		 if(n==2) {
		    return 2;
		 } 
		 int a=1, b=2, temp=0;
		 for(int i=3; i<=n; i++) {
			temp = a;
		    a = b%1000000007;
		    b = (a+temp)%1000000007;
		 }
	      
	     System.out.println("fib:"+b);
	     return b;
	}
	public static int fib(int n) {
		if(n==1) {
	    	return 1;
	    } else if(n==2) {
	    	return 2;
	    } else {
	    	return fib(n-2)+fib(n-1);
	    }
	}
	static int[][] answer55;
	public static int[][] solution55(int[][] nodeinfo) {
//        int[][] answer = {};
        Comparator<Node55> cmp = (a,b)->{ 
        	if(a.y!=b.y) 
        		return b.y-a.y; 
        	else 
        		return a.x-b.x; 
        }; 
        PriorityQueue<Node55> que = new PriorityQueue<>(cmp); 
        for(int i=0;i<nodeinfo.length;i++) 
        	que.add(new Node55(i+1,nodeinfo[i])); 
        System.out.println(que.toString());
        Node55 primary = que.poll();
        System.out.println("primary:"+primary.toString());
        while(!que.isEmpty()) 
        { 
        	Node55 fornew = que.poll(); 
        	System.out.println("fornew:"+fornew.toString());
        	Node55 now = primary; 
        	while(true) { 
        		if(fornew.x<now.x) { 
        			if(now.leftson==null) { 
        				now.leftson = fornew; 
        				fornew.parent = now; 
        				System.out.println("1. fornew.parent:"+fornew.parent.toString());
        				System.out.println("1. now.leftson:"+now.leftson.toString());
        				break; 
        			} else 
        				now = now.leftson; 
        		} else { 
        			if(now.rightson==null) { 
        				now.rightson = fornew; 
        				fornew.parent = now; 
        				break;
        			} else 
        				now = now.rightson; 
    			} 
    		} 
    	}
        answer55 = new int[2][nodeinfo.length]; 
        preorder(primary); 
        postorder(primary); 
        System.out.println(Arrays.toString(answer55[0]));
        System.out.println(Arrays.toString(answer55[1]));
        return answer55;
    }
	public static void preorder(Node55 now) { 
		for(int i=0;i<answer55[0].length;i++) { 
			if(answer55[0][i]==0) { 
				answer55[0][i]=now.no; 
				break;
			} 
		} 
		if(now.leftson!=null) 
			preorder(now.leftson); 
		if(now.rightson!=null) 
			preorder(now.rightson); 
	}
	public static void postorder(Node55 now) { 
		if((now.leftson==null||now.leftson.checked)&&(now.rightson==null||now.rightson.checked)) { 
			for(int i=0;i<answer55[1].length;i++) { 
				if(answer55[1][i]==0) { 
					answer55[1][i]=now.no; 
					break; 
				} 
			} 
			now.checked = true; 
			if(now.parent!=null) 
				postorder(now.parent); 
		} else { 
			if(now.leftson!=null&&!now.leftson.checked) 
				postorder(now.leftson); 
			else if(now.rightson!=null&&!now.rightson.checked) 
				postorder(now.rightson); 
		} 
	}



	   static int[] crewTimeTable = null;
	    static int[] busTimeTable = null;

	    //stringToMinute()는 역할이 비슷하므로, overloading 해줬음.
	    //String으로 된 크루들의 도착 시간표를 분으로 나타낸 int[] crewTimeTable로 바꾼다.
	    static void stringToMinute(String[] timetable){
	        for(int i=0; i<timetable.length; i++){
	            int hour = Integer.parseInt(timetable[i].substring(0,2));
	            int minute = Integer.parseInt(timetable[i].substring(3, 5));
	            crewTimeTable[i] = hour*60 + minute;
	        }
	    }

	    //버스 시간표를 만든다. int[] busTimeTable = new int[n]; -> n번 운행하므로 n개 할당.
	    static void stringToMinute(int n, int t){
	        //09:00 첫출발, 9*60 = 540분
	        int firstTime = 540;

	        //총 n회 운영되므로 n번의 loop를 돌린다.
	        for(int i=0; i<n; i++){
	            busTimeTable[i] = firstTime+ t*i;
	        }
	    }

	    
	    // 가장 늦은 도착시간 구하기
	    static int getToBusStopTime(int m){
	        int answer = 0;
	        int max = m;
	        boolean flag = false;
	        int tmp = 0;

	        List<Integer> consTime = new LinkedList<>();

	        Arrays.sort(crewTimeTable);

	        int i=0, j=0;
	        while(i<busTimeTable.length){
	            max = m;
	            flag = false;
	            tmp = 0;
	            j=0;
	            while(j<crewTimeTable.length){
	                if(crewTimeTable[j] < 0){
	                    j++;
	                    continue;
	                }
	                if(max <= 0){
	                    consTime.add(tmp-1);
	                    break;
	                }

	                if(busTimeTable[i] >= crewTimeTable[j]){
	                    tmp = crewTimeTable[j];
	                    crewTimeTable[j] = -1;
	                    max -= 1;
	                }
	                j++;
	            }

	            //System.out.println(max);
	            printArr(crewTimeTable);
	            // 한번에 탈 때
	            if(max > 0){
	                max -= 1;
	                consTime.add(busTimeTable[i]);
	            }
	            i++;
	        }

	        if(max <= 0){
	            consTime.add(tmp-1);
	        }

	        Collections.sort(consTime);

	        System.out.println(consTime);

	        answer = consTime.get(consTime.size()-1);

	        return answer;
	    }



	    static String minuteToHourMin(int min){
	        String str = "";

	        String hour = String.valueOf(min/60);
	        String minute = String.valueOf(min - ((min/60)*60));
	        if(hour.length() < 2){
	            hour = "0" + hour;
	        }
	        if(minute.length() < 2){
	            minute = "0" + minute;
	        }

	        str = hour + ":" + minute;

	        return str;

	    }



	    static void printArr(int[] arr){
	        for(int ai : arr){
	            System.out.print(ai + " ");
	        }
	        System.out.println();
	    }

	    public static String solution54(int n, int t, int m, String[] timetable) {
	        String answer = "";


	        //String으로 된 크루들의 도착 시간표를 분으로 나타낸 int[] crewTimeTable로 바꾼다.
	        crewTimeTable = new int[timetable.length];
	        stringToMinute(timetable);

	        //버스 시간표를 만든다. int[] busTimeTable = new int[n]; -> n번 운행하므로 n개 할당.
	        busTimeTable = new int[n];
	        stringToMinute(n, t);


	        //crewTimeTable과 busTimeTable 비교
	        int min = getToBusStopTime(m);


	        //String으로 변환하기
	        answer = minuteToHourMin(min);


	        return answer;
	    }
	public static int solution53(int n, int[] stations, int w) {
        int answer = 0;
        /*
         * int si = 0;	// station의 인덱스
	int position = 1;	// 아파트 1동부터 끝까지 
	while(position <= n) {	// 동 전체을 돌면서	
    
		// 기지국이 설치된(stations 배열의 요소가 존재할 때 까지) 곳 까지만 탐색
                // 현재의 위치(posotion)가 기존 설치된 기지국(stations[si])의 전파 범위(w) 안에 있는지 확인
                // 만약 기존 설치된 기지국의 범위 안에 있을경우 => 전파 범위이므로 기지국을 설치할 필요가 없다.
		if(si < stations.length && position >= stations[si] - w) {
			// 다음 이동해야 할 포지션
			position = stations[si] + w + 1;	// 기지국의 오른쪽 끝
			si ++;	// 다음 설치한 기지국을 찾기 위해 인덱스 +1
 		}
		else {
			answer += 1;	// 기지국 하나 설치
			
			// 기지국 설치에 의해 발생하는 최대 전파범위
			// 왼쪽 전파범위 + 기지국설치(1) + 오른쪽 전파범위
			position += (w*2) + 1;
		}
	}
         */
        int[] check = new int[n];
        int cnt=0;
        for(int i=0; i<n; i++) {
        	check[i] = 0;
        }
        for(int k=0; k<stations.length; k++) {
        	check[stations[k]-1] = 1;
	        for(int i=1; i<=w; i++) {
	        	if(stations[k]-1+i < n)
	        		check[stations[k]-1+i] = 1;
	        	if(stations[k]-1-i >= 0)
	        		check[stations[k]-1-i] = 1;
	        }
        }
        System.out.println(Arrays.toString(check));

        for(int k=0; k<n; k++) {
        	if(check[k] == 0) {
        		cnt++;
        		System.out.println("cnt:"+cnt);
        	} else {
        		if(cnt%(2*w+1) != 0) {
        			answer = answer + cnt/(2*w+1) + 1;
        			System.out.println("1. cnt:"+cnt+", answer:"+answer);
        		} else {
        			answer = answer + cnt/(2*w+1);
        			System.out.println("2. cnt:"+cnt+", answer:"+answer);
        		}
        		cnt = 0;
        	}
        }
        if(cnt%(2*w+1) != 0) {
			answer = answer + cnt/(2*w+1) + 1;
			System.out.println("3. cnt:"+cnt+", answer:"+answer);
		} else {
			answer = answer + cnt/(2*w+1);
			System.out.println("4. cnt:"+cnt+", answer:"+answer);
		}
       
        System.out.println("answer:"+answer);
        return answer;
    }
	public static int palindromeMaxLength(String s, int left, int right) {
        int L = left; int R = right;
        
        while( L >=0 && R < s.length() && s.charAt(L) == s.charAt(R) ) {
            L--;
            R++;
        }
//        System.out.println("R-L-1:"+ (R-L-1));
        return R-L-1;
    }

    public static int solution52(String s) {
        int length = s.length();
        
        int len = 1;
        for (int i = length; i >= 0; i--) {
            len = Math.max(len,palindromeMaxLength(s,i,i)); // palindrome이 홀수일때 길이
            len = Math.max(len,palindromeMaxLength(s,i,i+1)); // palindrome이 짝수일때 길이
        }
        System.out.println("len:"+len);
        return len;
    }
	static ArrayList<String> list51 = new ArrayList<String>();
	static String route = "";
	static boolean[] visit51;
	public static void dfs51(String[][] tickets, String end, int cnt) {
		route += end + ",";
		if(cnt==tickets.length) {
			list51.add(route);
			return;
		}
		for(int i=0; i<tickets.length; i++) {
			String s = tickets[i][0], e = tickets[i][1];
			if(s.equals(end) && !visit51[i]) {
				visit51[i] = true;
				dfs51(tickets, e, cnt+1);
				
				//visit51[i] = false;
				//route = route.substring(0, route.length()-4);
//				System.out.println("route:"+route);
			}
		}
	}
	public static String[] solution51(String[][] tickets) {
        String[] answer = {};
        for(int i=0; i<tickets.length; i++) {
        	visit51 = new boolean[tickets.length];
        	String start = tickets[i][0], end = tickets[i][1];
        	if(start.equals("ICN")) {
        		route = start + ",";
        		visit51[i] = true;
        		dfs51(tickets, end, 1);
        	}
        }
//        System.out.println(list51);
        Collections.sort(list51);
        answer = list51.get(0).split(",");
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	static int NN = 6;
	static int K = 4;
	static int answer50 = 1;
	static int[] visitlen = new int[51];
	static ArrayList<ArrayList<int[]>> adj = new ArrayList<ArrayList<int[]>>();
	public static void checkSum_dfs(int cur, int len) {
		visitlen[cur] = len;
		System.out.println("cur:"+cur+", len:"+len);

		for(int[] nx:adj.get(cur)) {
			System.out.println(Arrays.toString(nx));
			if(visitlen[nx[0]]<nx[1]+len || K<nx[1]+len) {
				continue;
			}
			if(visitlen[nx[0]]==Integer.MAX_VALUE) {
				answer50++;
			}
			checkSum_dfs(nx[0], nx[1]+len);
		}
	}
	public static int solution50(int N, int[][] road, int K) {
        int answer = 0;        
		Arrays.fill(visitlen, Integer.MAX_VALUE);
		for(int i=0; i<51; i++) {
			adj.add(new ArrayList<int[]>());
		}
		for(int i=0; i<road.length; i++) {
			adj.get(road[i][0]).add(new int[]{road[i][1], road[i][2]});
			adj.get(road[i][1]).add(new int[]{road[i][0], road[i][2]});
		}
		checkSum_dfs(1,0);
		answer = answer50;
		System.out.println("answer:"+answer);
        return answer;
    }
	public static void dfs(int start, int n, int[][] computers) {
        for(int i=0; i<n; i++) {
        	if(computers[start][i]==1 && connect[start][i]==false) {
        		System.out.println("start:"+start+", i:"+i);
        		connect[start][i] = connect[i][start] = true;
        		dfs(i, n, computers);
        	}
        }
    }
	public static int solution49(int n, int[][] computers) {
        int answer = 0;
        connect = new boolean[n][n];
        for(int i=0; i<n; i++) {
        	if(connect[i][i]==false) {
        		answer++;
        		System.out.println("i:"+i);
        		dfs(i, n, computers);
        	}
        }
        System.out.println("answer:"+answer);
        return answer;
    }
	public static long factorial(int n) {
		long result = 1;
		for(int i=1; i<=n; i++) {
			result = i * result;
		}
		return result;
	}
	public static long solution48(int n) {
	      long answer = 0;	      
    	  
    	  if(n%2==0) {
    		  for(int i=1; i<n/2; i++) {
        		  answer += factorial(i+n-2*i)/(factorial(i)*factorial(n-2*i));
        		  System.out.println("1. answer:"+answer);
    	      }
    		  answer += 2;
    		  System.out.println("2. answer:"+answer);
    	  } else {
    		  for(int i=1; i<(n+1)/2; i++) {
        		  answer += factorial(i+n-2*i)/(factorial(i)*factorial(n-2*i));
        		  System.out.println("1. answer:"+answer);
    	      }
    		  answer += 1;
    		  System.out.println("3. answer:"+answer);
    	  }
	      System.out.println("answer:"+answer);
	      return answer;
	  }
	public static int[] solution47(int n, int s) {
//	      int[] answer = {};
	      if(n>s){
	          return new int[]{-1};
	      }else{
	          int[] result = new int[n];
	          int q = s/n;
	          int r = s%n;
	          for(int i=0;i<n;i++){
	              if(i>=n-r){
	                  result[i] = q+1;
	              }else{
	                  result[i] = q;
	              }
	          }
	          System.out.println(Arrays.toString(result));
	          return result;
	      } 
//	      return answer;
	  }
	public static int solution46(int n, int[][] costs) {
        int answer = 0;
        int[][] adj = new int[n][n];
        for(int i=0; i<costs.length; i++) {
        	adj[costs[i][0]][costs[i][1]] = adj[costs[i][1]][costs[i][0]] = costs[i][2];
        }
        boolean[] visit = new boolean[n];
        ArrayList<Integer> connect = new ArrayList<>();
        connect.add(0);
        visit[0] = true;
        while(connect.size() < n) {
	        int min = Integer.MAX_VALUE;
	        int minIdx = -1;
//	        System.out.println("connect.size():"+connect.size());
	        for(int island=0; island<connect.size(); island++) {
	        	int i = connect.get(island);
	        	for(int j=0; j<n; j++) {
	        		if(!visit[j] && i!=j && adj[i][j] > 0 && adj[i][j] < min) {
	        			min = adj[i][j];
	        			minIdx = j;
	        		}
	        	}
	        }
	        visit[minIdx] = true;
	        connect.add(minIdx);
	        answer += min;
        }
        System.out.println("answer:"+answer);
        return answer;
    }
	public static int solution45(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int indexa = A.length - 1;
        int indexb = indexa;
        while(indexa>=0) {
        	int a = A[indexa];
        	int b = B[indexb];
        	if(b>a) {
        		indexb--;
        		answer++;
        	}
        	indexa--;
        }
        System.out.println("score:"+answer);
        return answer;
    }
	public static int solution44(int[] weight) {
        int answer = 0;
        return answer;
    }
	public static long solution43(int N) {
        long answer = 0;
        long[] arr = new long[N];
        arr[0] = 1;
        arr[1] = 1;
        if(N==1) {
        	return 4;
        }
        else {
	        for(int i=2; i<N; i++) {
	        	arr[i] = arr[i-2] + arr[i-1];
	        }
	        answer = arr[N-1]*4+arr[N-2]*2;
        } 
        System.out.println("둘레:"+answer);
        return answer;
    }
	public static int solution42(int[] budgets, int M) {
        int answer = 0;
        int left = 0, right = 0, middle = 0;
        for(int budget : budgets) {
        	if(budget > right) {
        		right = budget;
        	}
        }
        System.out.println("Max(right):"+right);
        while(left<=right) {
        	long sum = 0;
        	middle = (left+right)/2;
        	System.out.println("0. Sum:"+sum+", middle:"+middle);
        	for(int budget:budgets) {
        		if(budget>=middle) {
        			sum += middle;
        			System.out.println("1. Sum:"+sum+", middle:"+middle);
        		} else {
        			sum += budget;
        			System.out.println("2. Sum:"+sum+", middle:"+middle);
        		}
        	}
        	if(sum>M) {
        		right = middle-1;
        		System.out.println("3. Sum:"+sum+", middle:"+middle);
        	} else {
        		answer = middle;
        		left = middle+1;
        		System.out.println("4. Sum:"+sum+", middle:"+middle);
        	}
        }
        System.out.println("answer:"+answer);
        return answer;
    }
	public static int[] solution41(int n) {
        int[] answer = new int[100];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        if(n==1) {
        	
        	return answer;
        }
        for(int i=2; i<=n; i++) {
        	list.add(0);
        	System.out.println(list.size()/2);
        	for(int j=list.size()-2; j>=0; j--) {
        		System.out.println("0."+list.toString());
        		if(list.get(j)==0) {        			
        			list.add(1);
        			System.out.println("1."+list.toString());
        		} else {
        			list.add(0);
        			System.out.println("2."+list.toString());
        		}
        	}
        	
        }
        System.out.println(list.toString());
        
        
        return answer;
    }
	public static int solution40(int level) {
        int answer = 0;
        
        backtracking(0);
        System.out.println("cnt:"+cnt);
        answer = cnt;
        
        return answer;
    }
	public static void backtracking(int level) {
        if(level==N) {
	        for(int i=0; i<level; i++) {
	        	System.out.print(cols[i]+" ");
	        }
	        System.out.println();
	        cnt++;
        } else {
        	for(int i=0; i<N; i++) {
        		cols[level] = i;
//        		System.out.println("1. cnt:"+cnt);
        		if(isPossible(level)) {
//        			System.out.println("2. cnt:"+cnt);
        			backtracking(level+1);
        		}
        	}
        }
//        System.out.println("cnt:"+cnt);
    }
	public static boolean isPossible(int level) {
		for(int i=0; i<level; i++) {
			if(cols[i] == cols[level] || Math.abs(level-i) == Math.abs(cols[level]-cols[i])) {
//				System.out.println("3. cnt:"+cnt);
				return false;
			}
		}
//		System.out.println("4. cnt:"+cnt);
		return true;
	}
    public static int solution39(String dirs) {
        int answer = 0;
        int x=5, y=5, cnt=1, contains=0;
        ArrayList<NodeV> nlist = new ArrayList<>();
        NodeV n = new NodeV(x, y);
//        n.setVisit(true);
        nlist.add(n);
        
        for(int i=0; i<dirs.length(); i++) {
        	if(dirs.charAt(i) == 'U') {
        		x--;        
        	} else if(dirs.charAt(i) == 'D') {
        		x++;
        	} else if(dirs.charAt(i) == 'L') {
        		y--;
        	} else if(dirs.charAt(i) == 'R') {
        		y++;
        	}
        	if(0<=x && x<=10 && 0<=y && y<=10) {
	        	NodeV nu = new NodeV(x, y);
	        	contains = 0;
	        	for(int k=0; k<nlist.size(); k++) {
	        		if(nu.toString().equals(nlist.get(k).toString())) {
//	        			System.out.println("0. "+nu.toString());
	        			contains = 1;
	        			break;
	        		}
	        	}
	        	
	        	if(contains==1 || (x == 5 && y == 5)) {
//	        		System.out.println("1. "+x+", "+y);
	        	} else {
//	        		System.out.println("2. "+x+", "+y);
	        		nlist.add(nu);
	        		cnt++;
	        	}
        	}

        }
        answer = cnt;
        System.out.println("이동거리 : "+answer);
        return answer;
    }
    public static boolean check(int x, int y) {
    	if(0<=x&&x<=10) {
    		return true;
    	}
    	if(0<=y&&y<=10) {
    		return true;
    	}
    	return false;
    }
	public static int solution38(int n, int m, int[][] edge_list, int k, int[] gps_log) {
	      int answer = 0;
	      ArrayList<Integer> list[] = new ArrayList[100];
	      int[][] dp = new int[100][100];
	      for(int i=0; i<100; i++) {
	    	  list[i] = new ArrayList<Integer>();
	    	  for(int j=0; j<100; j++) {
	    		  dp[i][j] = 100;
	    	  }
	      }
	      for(int i=0; i<edge_list.length; i++) {
	    	  list[edge_list[i][0]].add(edge_list[i][1]);
	    	  list[edge_list[i][1]].add(edge_list[i][0]);
//	    	  System.out.println(list[i]);
	      }
	      for(int i=1; i<=k; i++) {
//	    	  System.out.println(list[i]);
	      }
	      dp[0][gps_log[0]] = 0;
	      for(int i=1; i<k; i++) {
	    	  for(int j=1; j<=n; j++) {
	    		  int add = (gps_log[i]==j?0:1);
	    		  dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+add);
//	    		  System.out.println("1.dp[i][j]:"+dp[i][j]);
	    		  for(int p:list[i]) {
	    			  dp[i][j] = Math.min(dp[i-1][p]+add, dp[i][j]);
//	    			  System.out.println("2.dp[i][j]:"+dp[i][j]);
	    		  }
	    	  }
	      }
	      int inf = 10000000;
	      answer = inf;
	      for(int p:list[gps_log.length-1]) {
	    	  answer = Math.min(answer, dp[gps_log.length-2][p]);
	      }
	      if(answer>inf/2) {
	    	  answer = -1;
	      }
	      System.out.println("answer:"+answer);
	      /*
	       *     init(edge_list);
    dp[0][gps_log[0]] = 0;
    for(int i=1;i<k-1;i++)
    {
        for(int j=1;j<=n;j++)
        {
            int add = (gps_log[i] == j ? 0 : 1);
            dp[i][j] = min(dp[i][j], dp[i-1][j] + add);
            for(auto p : adj[j]){
                dp[i][j] = min(dp[i-1][p] + add, dp[i][j]);
            }
        }
    }
    answer = inf;
    for(auto p : adj[gps_log.back()]){
        answer = min(answer, dp[gps_log.size()-2][p]);
    }
    if(answer > inf / 2) answer = -1;


출처: https://wwiiiii.tistory.com/entry/카카오-Code-Festival-본선-16번-풀이 [기리이이이인]
	       */
	      return answer;
	  
	}
	public static int[] solution36(int n, long k) {
	      int[] answer = {};
	      return answer;
	  }
	  public static int solution35(int n, int[] money) {
	      int answer = 0;
	      int[] dp = new int[n+1];

	      for(int i=0; i<=n; i++){
	    	  dp[i] = (i % money[0] == 0) ? 1 : 0;
	      }

	      Arrays.sort(money);
	      for(int i=1; i<money.length; i++) {
	    	  for(int j=money[i]; j<=n; j++) {
	    		  dp[j] = dp[j] + dp[j-money[i]];
	    	  }
	      }
	      answer = dp[n]%1000000007;
	      System.out.println("경우의 수:"+answer);
	      return answer;
	  }
	/*
	 * 
 


출처: https://pasudo123.tistory.com/227 [Contact 1997]
	 */
	  public static int solution37(int m, int n, int[][] cityMap) {
        int answer = 0;
        int MOD = 20170805;
        int[][][] dp = new int[2][m + 1][n + 1];
        dp[0][1][1] = 1; // 행 담당
        dp[1][1][1] = 1; // 열 담당
 
        // 행렬
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
 
                // 자유롭게
                if (cityMap[i - 1][j - 1] == 0) {
                    dp[0][i][j] = (dp[0][i][j] + dp[0][i - 1][j] + dp[1][i][j - 1]) % MOD;
                    dp[1][i][j] = (dp[1][i][j] + dp[0][i - 1][j] + dp[1][i][j - 1]) % MOD;
                }
 
                // 통행금지
                else if (cityMap[i - 1][j - 1] == 1) {
                    dp[0][i][j] = 0;
                    dp[1][i][j] = 0;
                }
 
                // 한방향
                else {
                    // 행은 행 & 열은 열
                    dp[0][i][j] = dp[0][i - 1][j];
                    dp[1][i][j] = dp[1][i][j - 1];
                }
            } // for
        } // for
 
//        display(cityMap, dp, m, n);
 
        answer = (dp[0][m - 1][n] + dp[1][m][n - 1]) % MOD;
        System.out.println("answer:"+answer);
        return answer;
    }
 

/*
출처: https://pasudo123.tistory.com/227 [Contact 1997]
	 */
    public static int solution34(int[][] triangle) {
        int answer = 0;
        int m = triangle.length-1;
        int n = triangle[m].length-1;
        for(int i=0; i<=m; i++) {
        	for(int j=0; j<=triangle[i].length-1; j++) {
//        		System.out.print(triangle[i][j]+" ");
        	}
        	System.out.println();
        }
        for(int i=1; i<=m; i++) {
        	for(int j=0; j<i+1; j++) {
        		if(j==0) {
        			triangle[i][j] += triangle[i-1][j]; 
        		} else if(i==j) {
        			triangle[i][j] += triangle[i-1][j-1];
        		} else {
        			triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
        		}
        	}
        }
        for(int i=0; i<=m; i++) {
        	for(int j=0; j<=triangle[i].length-1; j++) {
        		System.out.print(triangle[i][j]+" ");
        	}
        	System.out.println();
        }
        
        Arrays.sort(triangle[m]);
        answer = triangle[m][n];
        System.out.println("최대숫자:"+answer);
        return answer;
    }
	public static String solution31(int m, int n, String[] board) {
	      String answer = "";

	      int i, j, bef, aft, dx[] = { 0,1,0,-1 }, dy[] = { 1,0,-1,0 }, matched;
	      int[][][] vi = new int[100][100][4];
//	      int[] chk = new int[26];
	      int used = 0;
	      arr = new char[board.length][board[0].length()];
	      Queue<Exist> q = new LinkedList<>();
	      ArrayList<Pos> list = new ArrayList<>();
	      
	      for(i=0; i<m; i++) {
	    	  for(j=0; j<n; j++) {
	    	      arr[i][j] = board[i].charAt(j); 
	    	      for(int k=0; k<4; k++) {
	    	    	  vi[i][j][k] = 127;
	    	      }
	    	  }
	      }
	      for(int k='A'-65; k<='Z'-65; k++) {
		      for(i=0; i<m; i++) {
		    	  for(j=0; j<n; j++) {
//		    		  if ('A' <= arr[i][j] && arr[i][j] <= 'Z') {
		    		  if((char)('A'+k) == arr[i][j]) {
		    			  list.add(new Pos(arr[i][j], i, j));
		    		  }
		    	  }
		      }
	      }
//	      System.out.println(list.toString());
//	      
	      do {
//	    	  System.out.println("bef:"+list.size());
	    	  bef = list.size();
	    	  for(i=0; i<bef; i++) {
	    		  while(!q.isEmpty()) {
	    			  q.poll();
	    		  }
	    		  
	    		  for(int k=0; k<4; k++) {
	    			  vi[list.get(i).x][list.get(i).y][k] = 0;
	    			  q.add(new Exist(list.get(i).x, list.get(i).y, k));
//	    			  System.out.println(q.toString());
	    		  }
	    		  matched = 0;
	    		  while(!q.isEmpty() && matched==0) {
//	    			  Exist ex = new Exist(0,0,0);
	    			  Exist ex = q.peek();
//	    			  System.out.println(ex.toString());
	    			  q.poll();
	    			  for(j=0; j<4; j++) {
	    				  int tx = ex.x + dx[j];
	    				  int ty = ex.y + dy[j];
	    				  used = (j != ex.d)?1:0;
//	    				  System.out.println("tx:"+tx+",ty:"+ty+",used:"+used);
//	    				  System.out.println("vi[ex.x][ex.y][ex.d]:"+vi[ex.x][ex.y][ex.d]);
//	    				  System.out.println("list.get(i).c:"+list.get(i).c);
	    				  if (0 <= tx && tx < m && 0 <= ty && ty < n && vi[ex.x][ex.y][ex.d] + used < 2 && 
	    						  vi[tx][ty][j] > vi[ex.x][ex.y][ex.d] + used && arr[tx][ty] != '*' && 
	    						  (arr[tx][ty] == '.' || arr[tx][ty] == list.get(i).c)) {
	    					  
	                          vi[tx][ty][j] = vi[ex.x][ex.y][ex.d] + used;
	                          q.add(new Exist(list.get(i).x, list.get(i).y, j));
	                          if (arr[tx][ty] == list.get(i).c) {
//	                        	  System.out.println(list.get(i).toString());
	                              matched = 1;
	                              arr[list.get(i).x][list.get(i).y] = arr[tx][ty] = '.';
//	                              System.out.println(list.get(i).toString());
//		    					  
	                          }
	                      }
	                  }
	    			  
	    		  }
	    		  if (matched==1) {
	                  answer += list.get(i).c;
	                  list.remove(list.get(i));
	                  break;
	              }
	    	  }
	    	  aft = list.size();
//	    	  System.out.println("aft:"+list.size());
	      } while(aft != bef);
	      if (list.isEmpty()) {
	    	  System.out.println("Impossible");
	    	  answer = "IMPOSSIBLE";
	      }
	      System.out.println("answer:"+answer);
	      return answer;
	}

	public static int solution33(int m, int n, String[] board) {
		  map = new char[m][n];
		  list = new ArrayList<>();
		  for(int i=0; i<m; i++) {
			  for(int j=0; j<n; j++) {
				  map[i][j] = board[i].charAt(j);
				  if(map[i][j] == 'o') {
					  list.add(0, new Node(i,j));
				  } else if(map[i][j] == '*') {
					  list.add(new Node(i,j));
				  }
			  }
		  }
		  int size = list.size();
		  dis = new int[size][size];
		  selected = new boolean[size];
		  for(int idx=0; idx<size; idx++) {
			  if(bfs(idx, m, n)==-1) {
				  ans = -1;
				  break;
			  }
		  }
		  if(ans == -1) {
			  System.out.println(ans);
		  } else {
			  ans = Integer.MAX_VALUE;
			  selected[0] = true;
			  dfs(0,0,0);
			  System.out.println("최단거리:"+ans);
		  }
		  return ans;
	}
	public static void dfs(int depth, int dist, int from) {
		if(depth == selected.length-1) {
			ans = ans>dist? dist:ans;
			return;
		}
		for(int to=1; to<selected.length; to++) {
			if(!selected[to]) {
				selected[to] = true;
				dfs(depth+1, dist+dis[from][to], to);
				selected[to] = false;
			}
		}
	}
	public static int bfs(int from, int m, int n) {
		boolean[][] visit = new boolean[m][n];
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		Queue<Node> q = new LinkedList<>();
		int dust = 0;
		int cnt = 0;
		Node start = list.get(from);
		visit[start.r][start.c] = true;
		q.offer(start);
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for(int i=0; i<size; i++) {
				Node cur = q.poll();
				for(int d=0; d<4; d++) {
					int nr = cur.r + dir[d][0];
					int nc = cur.c + dir[d][1];
					if(nr>=m || nr<0 || nc>=n || nc<0 || visit[nr][nc] || map[nr][nc]=='x') {
						continue;
					}
					if(map[nr][nc]=='o' || map[nr][nc]=='*') {
						for(int to=0; to<list.size(); to++) {
							Node end = list.get(to);
							if(end.r == nr && end.c == nc) {
								dis[from][to] = cnt;
								dis[to][from] = cnt;
								dust++;
							}
						}
					}
					visit[nr][nc] = true;
					q.offer(new Node(nr, nc));
				}
			}
		}
		if(dust != list.size()-1) {
			return -1;
		} else {
			return 0;
		}
	}
	public static String solution32(int m, int n, String[] board) {
		  String answer = "";
		  int end=1;
	      arr = new char[board.length][board[0].length()];
	      visited = new char[board.length][board[0].length()];
	      for(int i=0; i<m; i++) {
	    	  for(int j=0; j<n; j++) {
	    	      arr[i][j] = board[i].charAt(j); 
	    	      visited[i][j] = 0;
	    	      if('A'<=arr[i][j] && arr[i][j]<='Z') {
	    	    	  end++;
	    	      }
	    	  }
	      }
//	      while(end==1) {
		      for(int k='A'-65; k<='Z'-65; k++) {
			      for(int i=0; i<m; i++) {
			    	  for(int j=0; j<n; j++) {
			    		  if((char)(k+'A') == arr[i][j]) {
			    			  System.out.println("arr[i][j]:"+arr[i][j]);
	//		    		  if('A'<=arr[i][j] && arr[i][j]<='Z') {
			    			  int result = checkSame(arr, i, j);
			    	    	  if(result == 1) {
			    	    		  System.out.println("1. temp:"+temp);
			    	    	  }	else {
			    	    		  int result2 = checkSame(arr, i, j);
			    	    		  System.out.println("result2:"+result2);
//			    	    		  continue;
			    	    	  }
			    		  } 
			    	  }
			      }
		      }
		      /*
		      for(int i=0; i<m; i++) {
		    	  for(int j=0; j<n; j++) {
		    		  if(arr[i][j]=='.'||arr[i][j]=='*') {
//		    			  end=0;
		    			  System.out.println("끝남:"+temp);
		    		  } else {
		    			  System.out.println("안끝남:"+temp);
		    			  end=1;
		    		  }
		    	  }
		      }
	    	  if(end!=1) {
	    		  end=0;
	    	  }
	    	  */
//	      }
	      answer = temp;
	      System.out.println("최종:"+answer);
	      return answer;
	}
	public static int checkSame(char[][] board, int x, int y) {
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		int flag = 0, dot=0;
		char ch = board[x][y];
		int org_x = x, org_y = y;
		int dot_x = 0, dot_y = 0;

		for(int i=0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if(xx<0 || xx>=board.length || yy< 0 || yy>=board[0].length || board[xx][yy]=='*') {
				continue;
			}
			if(ch == board[xx][yy] && visited[org_x][org_y] == 0) {
				System.out.println("0. ch:"+ch);	
				temp += ch;
				arr[org_x][org_y] = '.';
				arr[xx][yy] = '.';
				System.out.println("0. org_x:"+org_x);	
				System.out.println("0. org_y:"+org_y);
				System.out.println("0. xx:"+xx);	
				System.out.println("0. yy:"+yy);
				flag = 1;
				return flag;
			}	
			if(board[xx][yy] == '.') {
				dot = 1;
				dot_x = xx;
				dot_y = yy;
			}
/*			
			if(flag == 0) {				
				if(xx>=0 && xx<board.length && yy>= 0 && yy<board[0].length) {
//					System.out.println("안탐11");
					if(board[xx][yy] == '.') {
						System.out.println("1. org_x:"+org_x);	
						System.out.println("1. org_y:"+org_y);
						System.out.println("1. xx:"+xx);	
						System.out.println("1. yy:"+yy);
						visited[org_x][org_y] = 1;
						x = xx;
						y = yy;
//						break;
					}
					
					if(board[xx][yy] == '*') {
//						continue;
					
					}
					
				} 
			}
*/
		}
		// 맨 마지막에 다른 문자로 끝났을 때, *, . 있는 경우 '.' 선택
		if(flag==0 && dot==1) {
			flag = 2;
			visited[org_x][org_y] = 1;
			int second = checkSame(arr, dot_x, dot_y);
		}
		// 다른 문자 또는 * 밖에 없는 경우 0 리턴
		return flag;
	}
}
