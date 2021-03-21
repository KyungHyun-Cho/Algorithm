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
	public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static int r, c;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = stoi(br.readLine());
		while(tc-->0) {
			String[] inputArr = br.readLine().split(" ");
			c = stoi(inputArr[0]);
			r = stoi(inputArr[1]);
			Point start = null;
			Deque<Point> nextSpread = new LinkedList<>();			
			char[][] map = new char[r][c];
			for(int i = 0; i < r; i++) {
				String inputStr = br.readLine();
				for(int j = 0; j < c; j++) {
					map[i][j] = inputStr.charAt(j);
					if(map[i][j] == '@') {
						start = new Point(i, j, 0);
					}else if(map[i][j] == '*') {
						nextSpread.addLast(new Point(i, j, 0));
					}
				}
			}
			int minCnt = BFS(map, nextSpread, start);
			if(minCnt == -1)
				sb.append("IMPOSSIBLE\n");
			else
				sb.append(minCnt + "\n");
		}
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static void spread(char[][] map, Deque<Point> nextSpread) {
		int cnt = nextSpread.size();
		for(int k = 0; k < cnt; k++) {
			Point p = nextSpread.pollFirst();
			int now_x = p.x;
			int now_y = p.y;
			for(int i = 0; i < 4; i++) {
				int new_x = now_x + dir[i][0];
				int new_y = now_y + dir[i][1];
				if(new_x < 0 || new_y < 0 || new_x >= r || new_y >= c) continue;
				if(map[new_x][new_y] == '#' || map[new_x][new_y] == '*') continue;
				map[new_x][new_y] = '*';
				nextSpread.addLast(new Point(new_x, new_y, 0));
			}
		}
	}
	public static int BFS(char[][] map, Deque<Point> nextSpread, Point start) {
		boolean[][] visit = new boolean[r][c];
		Queue<Point> fq = new LinkedList<>();
		Queue<Point> sq = new LinkedList<>();
		
		fq.add(start);
		visit[start.x][start.y] = true;
		int minCnt = -1;
		while(!fq.isEmpty()) {
			spread(map, nextSpread);
			while(!fq.isEmpty()) sq.add(fq.poll());
			while(!sq.isEmpty()) {
				Point p = sq.poll();
				int now_x = p.x;
				int now_y = p.y;
				int now_cnt = p.cnt;
				for(int i = 0; i < 4; i++) {
					int new_x = now_x + dir[i][0];
					int new_y = now_y + dir[i][1];
					if(new_x < 0 || new_y < 0 || new_x >= r || new_y >= c) return now_cnt+1;
					if(map[new_x][new_y] != '.') continue;
					if(visit[new_x][new_y]) continue;
					visit[new_x][new_y] = true;
					fq.add(new Point(new_x, new_y, now_cnt + 1));
				}
			}
		}
		return minCnt;
	}
}
