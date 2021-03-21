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
	public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // ╩С, го, аб, ©Л
	public static int ans = -1, r = 0, c = 0;
	public static Queue<Point> nextFill = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input_arr = br.readLine().split(" ");
		r = Integer.parseInt(input_arr[0]);
		c = Integer.parseInt(input_arr[1]);
		int startX = 0, startY = 0;
		map = new int[r][c];
		for(int i = 0; i < r; i++) {
			String input = br.readLine();
			for(int j = 0; j < c; j++) {
				char ch = input.charAt(j);
				if(ch == 'S') {
					map[i][j] = 8;
					startX = i;
					startY = j;
				}
				else if(ch == 'D')
					map[i][j] = 9;
				else if(ch == '.')
					map[i][j] = 0;
				else if(ch == '*') {
					nextFill.add(new Point(i, j, 0));
					map[i][j] = 1;
				}
				else if(ch == 'X')
					map[i][j] = 2;
			}
		}
		
		BFS(startX, startY);
		if(ans == -1)
			System.out.println("KAKTUS");
		else
			System.out.println(ans);
	}
	public static void BFS(int x, int y) {
		boolean[][] visit = new boolean[r][c];
		Queue<Point> fq = new LinkedList<>();
		Queue<Point> sq = new LinkedList<>();
		
		fq.add(new Point(x, y, 0));
		visit[x][y] = true;
		while(!fq.isEmpty()) {
			fill();
			while(!fq.isEmpty()) {
				sq.add(fq.poll());
			}
			while(!sq.isEmpty()) {
				Point p = sq.poll();
				int now_x = p.x;
				int now_y = p.y;
				int now_cnt = p.cnt;
				if(map[now_x][now_y] == 9) {
					ans = now_cnt;
					break;
				}
				for(int i = 0; i < 4; i++) {
					int new_x = now_x + dir[i][0];
					int new_y = now_y + dir[i][1];
					if(new_x < 0 || new_y < 0 || new_x >= r || new_y >= c) continue;
					if(map[new_x][new_y] == 1 || map[new_x][new_y] == 2) continue;
					if(visit[new_x][new_y]) continue;
					visit[new_x][new_y] = true;
					fq.add(new Point(new_x, new_y, now_cnt+1));
				}
			}
		}
	}
	public static void fill() {
		int qCnt = nextFill.size();
		
		while(qCnt--> 0) {
			Point p = nextFill.poll();
			for(int k = 0; k < 4; k++) {
				int new_x = p.x + dir[k][0];
				int new_y = p.y + dir[k][1];
				if(new_x < 0 || new_y < 0 || new_x >= r || new_y >= c) continue;
				if(map[new_x][new_y] == 0) {
					map[new_x][new_y] = 1;
					nextFill.add(new Point(new_x, new_y, 0));
				}
			}
		}
				
	}
}
