import java.io.*;
import java.util.*;
class Info{
	int x, y, cnt;
	Info(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;		
	}
}
public class Main {
	static int[][] map;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visit;
	static int answer = 987654321;
	static int n, m, t;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		
		n = stoi(inputArr[0]);
		m = stoi(inputArr[1]);
		t = stoi(inputArr[2]);
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			inputArr = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				map[i][j] = stoi(inputArr[j]);
			}
		}
		BFS();

		if(answer > t)
			System.out.println("Fail");
		else
			System.out.println(answer);
	}
	public static void BFS() {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(0, 0, 0));
		visit[0][0] = true;
		while(!q.isEmpty()) {
			Info info = q.poll();
			int x = info.x;
			int y = info.y;
			if(x == n-1 && y == m-1)
				answer = Math.min(answer, info.cnt);
			for(int i = 0; i < 4; i++) {
				int new_x = x + dir[i][0];
				int new_y = y + dir[i][1];
				if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= m) continue;
				if(visit[new_x][new_y]) continue;
				if(map[new_x][new_y] == 1) continue;
				else if(map[new_x][new_y] == 2)
					answer = Math.min(answer, GetDistance(new_x, new_y) + info.cnt+1);
				
				visit[new_x][new_y] = true;
				q.add(new Info(new_x, new_y, info.cnt+1));
			}
		}
	}
	public static int GetDistance(int x1, int y1) {
		return Math.abs(n-x1-1) + Math.abs(m-y1-1);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
