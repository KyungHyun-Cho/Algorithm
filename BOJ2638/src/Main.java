import java.util.*;
import java.io.*;
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;		
	}
}
public class Main {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static final int AIR = 99;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		String[] inputArr = br.readLine().split(" ");
		int n = stoi(inputArr[0]);
		int m = stoi(inputArr[1]);
		int[][] map = new int[n][m];
		ArrayList<Point> arr = new ArrayList<Point>();

		for(int i = 0; i < n; i++) {
			inputArr = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				if(inputArr[j].charAt(0) == '1') map[i][j] = 1;
			}
		}
		
		while((arr = fillAir(map)).size() > 0) {			
			for(Point p : arr)
				map[p.x][p.y] = AIR;
			answer++;
		}
		
		System.out.println(answer);
		
		
	}
	
	static ArrayList<Point> fillAir(int[][] map) {
		int n = map.length;
		int m = map[0].length;
		boolean[][] visit = new boolean[n][m];
		ArrayList<Point> ret = new ArrayList<Point>();
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			map[x][y] = AIR;
			for(int i = 0; i < 4; i++) {
				int new_x = x + dir[i][0];
				int new_y = y + dir[i][1];
				if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= m) continue;
				if(map[new_x][new_y] != 0 && map[new_x][new_y] != AIR) map[new_x][new_y]++;
				if(visit[new_x][new_y]) continue;
				visit[new_x][new_y] = true;
				if(map[new_x][new_y] == 0 || map[new_x][new_y] == AIR)
					q.add(new Point(new_x, new_y));
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0 || map[i][j] == AIR) continue;
				if(map[i][j] >= 3) ret.add(new Point(i, j));
				else map[i][j] = 1;
			}
		}
		
		return ret;
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}