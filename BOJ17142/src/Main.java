import java.util.*;
class Point{
	int x, y, time = 1;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	Point(int x, int y, int time){
		this.x = x;
		this.y = y;
		this.time = time;
	}
}
public class Main {
	static int n, m, answer = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<Point> availableList = new ArrayList<>();;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) map[i][j] = -1;
				else if(map[i][j] == 2) {
					map[i][j] = 1;
					availableList.add(new Point(i, j));
				}
			}
		}
		if(check(map)) {
			System.out.println(0);
			return;
		}
		Stack<Point> s = new Stack<>();
		for(int i = 1; i <= m; i++)
			pick(0, s, 0);
		if(answer == Integer.MAX_VALUE) 
			System.out.println(-1);
		else
			System.out.println(answer-1);
	}
	public static void pick(int depth, Stack<Point> s, int nowIdx) {
		if(depth == m) {
			BFS(s);
		}else {
			for(; nowIdx < availableList.size(); nowIdx++) {
				s.add(availableList.get(nowIdx));
				pick(depth+1, s, nowIdx+1);
				s.pop();
			}
		}
	}
	public static void BFS(Stack<Point> s) {
		boolean[][] visit = new boolean[n][n];
		int[][] tmp_map = new int[n][n];
		copyMap(map, tmp_map);
		int time = Integer.MIN_VALUE;
		Queue<Point> q = new LinkedList<>();
		for(Point p : s) { 
			q.add(p);
			visit[p.x][p.y] = true;
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			int now_x = p.x;
			int now_y = p.y;
			int now_time = p.time;
			tmp_map[now_x][now_y] = now_time;
			if(map[now_x][now_y] != 1)
				time = Math.max(time, now_time);
			for(int i = 0; i < 4; i++) {
				int new_x = now_x + dir[i][0];
				int new_y = now_y + dir[i][1];
				if(new_x >= 0 && new_y >= 0 && new_x < n && new_y < n) {
					if(!visit[new_x][new_y] && tmp_map[new_x][new_y] != -1) {
						visit[new_x][new_y] = true;
						q.add(new Point(new_x, new_y, now_time+1));
					}
				}
			}
		}
		if(check(tmp_map))
			answer = Math.min(answer, time);
	}
	public static boolean check(int[][] map) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
	public static void copyMap(int[][] src, int[][] dest) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				dest[i][j] = src[i][j];
			}
		}
	}
}
