import java.io.*;
import java.util.*;
class Point{
	int x, y, cnt;
	Point(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
public class Main {
	public static int[][] map;
	public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static int[][] visit;
	public static int n = 0;
	public static final int INF = 987654321;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		map = new int[n][n];
		visit = new int[n][n];
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j) - '0';
				if(map[i][j] == 0) visit[i][j] = INF;
			}
		}
		BFS();
		System.out.println(visit[n-1][n-1]);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static void BFS() {
		boolean[][] wVisit = new boolean[n][n];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0));
		wVisit[0][0] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int now_x = p.x;
			int now_y = p.y;
			for(int i = 0; i < 4; i++) {
				int new_x = now_x + dir[i][0];
				int new_y = now_y + dir[i][1];
				if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) continue;
				if(map[new_x][new_y] == 0) {
					if(visit[new_x][new_y] > visit[now_x][now_y]) {
						visit[new_x][new_y] = visit[now_x][now_y] + 1;
						q.add(new Point(new_x, new_y, 0));
					}
				}else {
					if(!wVisit[new_x][new_y]) {
						wVisit[new_x][new_y] = true;
						visit[new_x][new_y] = visit[now_x][now_y];
						q.add(new Point(new_x, new_y, 0));
					}else if(wVisit[new_x][new_y] && visit[new_x][new_y] > visit[now_x][now_y]) {
						visit[new_x][new_y] = visit[now_x][now_y];
						q.add(new Point(new_x, new_y, 0));
					}
				}
			}
		}
	}
}
