import java.util.*;
import java.io.*;
class Point{
	int x, y, dir;
	Point(int x, int y, int dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}
public class Main {
	static int n, k;
	static int[][] map;
	static Deque<Integer>[][] kMap;
	static HashMap<Integer, Point> kInfo = new HashMap<>();
	static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		k = stoi(st.nextToken());
		map = new int[n][n];
		kMap = new Deque[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = stoi(st.nextToken());
				kMap[i][j] = new LinkedList<>();
			}
		}
		for(int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken())-1;
			int y = stoi(st.nextToken())-1;
			int dir = stoi(st.nextToken())-1;
			kInfo.put(i, new Point(x, y, dir));
			kMap[x][y].addLast(i);			
		}
		for(int i = 1; i <= 1000; i++) {
			if(solve()) {
				System.out.println(i);
				br.close();
				return;
			}
		}
		System.out.println(-1);
		br.close();
			
	}
	public static boolean solve() {
		for(int kNo : kInfo.keySet()) {
			if(isPossible(kNo)) {
				move(kNo);
			}else {
				changeDir(kNo);
				if(isPossible(kNo)) {
					move(kNo);
				}
			}
			if(isFinish()) return true;
		}
		return false;
	}
	public static boolean isFinish() {
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(kMap[i][j].size() >= 4) return true;
		return false;
	}
	public static void changeDir(int kNo) {
		Point p = kInfo.get(kNo);
		if(p.dir == 0)
			p.dir = 1;
		else if(p.dir == 1)
			p.dir = 0;
		else if(p.dir == 2)
			p.dir = 3;
		else if(p.dir == 3)
			p.dir = 2;
	}
	public static void move(int kNo) {
		Deque<Integer> tmp = new LinkedList<>();
		Point p = kInfo.get(kNo);
		int new_x = p.x + dir[p.dir][0];
		int new_y = p.y + dir[p.dir][1];
		while(true) {
			int nowKNo = kMap[p.x][p.y].pollLast();				
			tmp.addLast(nowKNo);
			kInfo.get(nowKNo).x = new_x;
			kInfo.get(nowKNo).y = new_y;
			
			if(nowKNo == kNo) break;
		}
		if(map[new_x][new_y] == 0) {
			//Èò»ö ¹Ù´ÚÀ¸·Î °¥ ¶§
			while(!tmp.isEmpty())
				kMap[new_x][new_y].addLast(tmp.pollLast());
		}else if(map[new_x][new_y] == 1) {
			//»¡°£»ö ¹Ù´ÚÀ¸·Î °¥ ¶§
			while(!tmp.isEmpty())
				kMap[new_x][new_y].addLast(tmp.pollFirst());
		}
	}
	public static boolean isPossible(int kNo) {
		Point p = kInfo.get(kNo);
		int new_x = p.x + dir[p.dir][0];
		int new_y = p.y + dir[p.dir][1];
		if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) return false;
		if(map[new_x][new_y] == 2) return false;
		return true;
	}
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
