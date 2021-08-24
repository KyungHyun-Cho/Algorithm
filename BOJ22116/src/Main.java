import java.io.*;
import java.util.*;

class Info implements Comparable<Info>{
	Info(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	int x, y, cost;
	@Override
	public int compareTo(Info o) {
		return this.cost - o.cost;
	}
}
public class Main {
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // ©Л го аб ╩С
	static int[][] map, cost;
	static boolean[][] visit;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int INF = 987654321;
		n = stoi(br.readLine());
		map = new int[n][n];
		cost = new int[n][n];
		visit = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] inputArr = br.readLine().split(" ");
			Arrays.fill(cost[i], INF);
			for(int j = 0; j < n; j++) {
				map[i][j] = stoi(inputArr[j]);
			}
		}
		
		BFS();
		System.out.println(cost[n-1][n-1]);
	}
	public static void BFS() {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(0, 0, 0));
		cost[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			int x = info.x;
			int y = info.y;
			visit[x][y] = true;
			for(int i = 0; i < 4; i++) {
				int new_x = x + dir[i][0];
				int new_y = y + dir[i][1];
				if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) continue;
				if(visit[new_x][new_y]) continue;
				if(cost[new_x][new_y] > Math.max(info.cost, (int)Math.abs(map[new_x][new_y] - map[x][y]))) {
					cost[new_x][new_y] = Math.max(info.cost, (int)Math.abs(map[new_x][new_y] - map[x][y]));
					pq.add(new Info(new_x, new_y, cost[new_x][new_y]));
				}
			}
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
