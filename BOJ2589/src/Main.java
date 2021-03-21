import java.io.*;
import java.util.*;
class Point{
	int x, y, depth = 0;
	Point(int x, int y, int depth){
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}
public class Main {
	public static int[][] map;
	public static boolean[][] visit;
	public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static int max_depth = 0, gx = 0, gy = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input_arr = br.readLine().split(" ");
		gx = stoi(input_arr[0]);
		gy = stoi(input_arr[1]);
		map = new int[gx][gy];
		visit = new boolean[gx][gy];
		
		for(int i = 0; i < gx; i++) {
			String input = br.readLine();
			for(int j = 0; j < gy; j++) {
				char c = input.charAt(j);
				map[i][j] = c == 'W' ? 0 : 1;
			}			
		}

		for(int i = 0; i < gx; i++) {
			for(int j = 0; j < gy; j++) {
				if(map[i][j] == 1) {
					BFS(i, j);
				}
			}
		}
		System.out.println(max_depth);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static void BFS(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		clearVisit();
		q.add(new Point(x, y, 0));
		visit[x][y] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int now_x = p.x;
			int now_y = p.y;
			max_depth = Math.max(max_depth, p.depth);
			for(int i = 0; i < 4; i++) {
				int new_x = now_x + dir[i][0];
				int new_y = now_y + dir[i][1];
				if(new_x < 0 || new_y < 0 || new_x >= gx || new_y >= gy) continue;
				if(visit[new_x][new_y]) continue;
				if(map[new_x][new_y] == 0) continue;
				visit[new_x][new_y] = true;
				q.add(new Point(new_x, new_y, p.depth + 1));
			}
		}
	}
	public static void clearVisit() {
		for(int i = 0; i < gx; i++)
			for(int j = 0; j < gy; j++)
				visit[i][j] = false;
	}
}
