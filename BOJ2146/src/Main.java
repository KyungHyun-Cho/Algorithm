import java.util.*;
import java.io.*;
class Point{
	int x, y, landNo, cnt;
	Point(int x, int y, int landNo, int cnt){
		this.x = x;
		this.y = y;
		this.landNo = landNo;
		this.cnt = cnt;
	}
	Point(int landNo){
		this.landNo = landNo;
	}
}
public class Main {
	static int n, landNo = 1, answer = Integer.MAX_VALUE;
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static Point[][] map;
	static boolean[][] visit;
	static Queue<Point> expandQ = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		map = new Point[n][n];
		visit = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] inputArr = br.readLine().split(" ");
			for(int j = 0; j < n; j++)
				map[i][j] =	new Point(stoi(inputArr[j]));
		}
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(map[i][j].landNo != 0 && !visit[i][j]) {
					BFS(i, j);
					landNo++;
				}
		
		
		BFS2();
				
		
		
		System.out.println(answer);
	}
	public static void BFS2() {
		//boolean[][] visit = new boolean[n][n];
		//visit[expandQ.peek().x][expandQ.peek().y] = true;
		while(!expandQ.isEmpty()) {
			Point p = expandQ.poll();
			int x = p.x;
			int y = p.y;
			int nowLandNo = p.landNo;

			for(int i = 0; i < 4; i++) {
				int new_x = x + dir[i][0];
				int new_y = y + dir[i][1];
				if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) continue;
				//if(visit[new_x][new_y]) continue;
				if(map[new_x][new_y].landNo == 0 && map[new_x][new_y].landNo != nowLandNo) {
					//visit[new_x][new_y] = true;
					map[new_x][new_y].landNo = p.landNo;
					map[new_x][new_y].cnt = p.cnt+1;
					expandQ.add(new Point(new_x, new_y, p.landNo, p.cnt+1));
				}
				else if(map[new_x][new_y].landNo > 0 && map[new_x][new_y].landNo != nowLandNo) {
					answer = Math.min(answer, p.cnt + map[new_x][new_y].cnt);
				}
			}
		}	
	}
	public static void BFS(int paramX, int paramY) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(paramX, paramY, landNo, 0));
		visit[paramX][paramY] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			map[x][y].landNo = landNo;
			boolean isSide = false;
			for(int i = 0; i < 4; i++) {
				int new_x = x + dir[i][0];
				int new_y = y + dir[i][1];
				if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) continue;
				if(map[new_x][new_y].landNo == 0) isSide = true;
				else {
					if(!visit[new_x][new_y]) {
						visit[new_x][new_y] = true;
						q.add(new Point(new_x, new_y, landNo, 0));
					}
				}
			}
			if(!isSide) map[x][y].landNo = -1;
			else{
				expandQ.add(new Point(x, y, landNo, 0));
				}
		}				
	}
	static int stoi(String str) {return Integer.parseInt(str);}

}
