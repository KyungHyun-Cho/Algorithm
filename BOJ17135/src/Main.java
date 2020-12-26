import java.util.*;
class Point{
	int x, y, dist;
	Point(int x, int y, int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}
public class Main {
	static int n, m, d, answer = 0;
	static int[][] map;
	static int[] pos;
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Stack<Integer> st = new Stack<>();
		boolean[] visit = new boolean[m];
		DFS(st, visit, 0, 0);
		System.out.println(answer);
	}
	public static void DFS(Stack<Integer> st, boolean[] visit, int depth, int last) {
		if(depth == 3) {
			process(st);
			/*for(int i : st) {
				System.out.print(i);
			}
			System.out.println();*/
		}else {
			for(int i = 0 + last; i < m; i++) {
				if(visit[i]) continue;
				visit[i] = true;
				st.add(i);
				DFS(st, visit, depth + 1, i);
				visit[i] = false;
				st.pop();
			}
		}
	}
	public static void process(Stack<Integer> st) {
		int cnt = 0;
		int[][] tmpMap = new int[n][m];
		copyMap(map, tmpMap);
		for(int loop = 0; loop < n; loop++) {
			ArrayList<Point> attackList = new ArrayList<>();
			for(int yIdx : st) {
				Point p = getNext(tmpMap, n, yIdx);
				if(p != null) attackList.add(p);
			}
			for(Point p : attackList) {
				if(tmpMap[p.x][p.y] == 1) {
					cnt++;
					tmpMap[p.x][p.y] = 0;
				}
			}
			for(int i = n-1; i >= 1; i--) {
				for(int j = 0; j < m; j++) {
					tmpMap[i][j] = tmpMap[i-1][j];
				}
			}			
			for(int i = 0; i < m; i++)
				tmpMap[0][i] = 0;
		}
		answer = Math.max(answer, cnt);
	}
	public static Point getNext(int[][] map, int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x-1, y, 0));
		if(map[x-1][y] == 1) return new Point(x-1, y, 1);
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int now_x = p.x;
			int now_y = p.y;
			int now_dist = p.dist;
			if(now_dist != 0 && map[now_x][now_y] == 1) {
				return new Point(now_x, now_y, now_dist);
			}else {
				for(int i = 0; i < 3; i++) {
					int new_x = now_x + dir[i][0];
					int new_y = now_y + dir[i][1];
					if(new_x < 0 || new_y < 0 || new_y >= m) continue;
					if(now_dist + 1 >= d) break;
					q.add(new Point(new_x, new_y, now_dist + 1));
				}
			}
		}
		return null;
	}
	public static void copyMap(int[][] src, int[][] dest) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				dest[i][j] = src[i][j];
			}
		}
	}
}
