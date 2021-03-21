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
	static int[][] dir = {{-2, 1}, {-1, 2}, {2, 1}, {1, 2}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = stoi(br.readLine());
		while(tc--> 0) {
			int n = stoi(br.readLine());
			boolean[][] visit = new boolean[n][n];
			Queue<Point> q = new LinkedList<Point>();
			String[] input = br.readLine().split(" ");
			q.add(new Point(stoi(input[0]), stoi(input[1]), 0));
			visit[q.peek().x][q.peek().y] = true;
			input = br.readLine().split(" ");
			Point goal = new Point(stoi(input[0]), stoi(input[1]), 0);
			while(!q.isEmpty()) {
				Point p = q.poll();
				int now_x = p.x;
				int now_y = p.y;
				int now_cnt = p.cnt;
				if(now_x == goal.x && now_y == goal.y) {
					System.out.println(now_cnt);
					break;
				}
				for(int i = 0; i < 8; i++) {
					int new_x = now_x + dir[i][0];
					int new_y = now_y + dir[i][1];
					if(new_x >= 0 && new_y >= 0 && new_x < n && new_y < n) {
						if(!visit[new_x][new_y]) {
							visit[new_x][new_y] = true;
							q.add(new Point(new_x, new_y, now_cnt + 1));
						}
					}
				}
			}
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
