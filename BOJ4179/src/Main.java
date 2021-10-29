import java.util.*;
import java.io.*;
class Point{
	int x, y, cnt;
	Point(int x, int y){
		this.x = x;
		this.y = y;
		this.cnt = 0;
	}
	Point(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
public class Main {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		int n = stoi(inputArr[0]);
		int m = stoi(inputArr[1]);
		
		char[][] map = new char[n][m];
		boolean[][] fireVisit = new boolean[n][m];
		boolean[][] visit = new boolean[n][m];
		Queue<Point> fireQ = new ArrayDeque<>();
		Queue<Point> q = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++){
			String input = br.readLine();
			for(int j = 0; j < m; j++) {
				if(input.charAt(j) == 'F') {
					fireVisit[i][j] = true;
					fireQ.add(new Point(i, j));
				}else if(input.charAt(j) == 'J') {
					visit[i][j] = true;
					q.add(new Point(i, j));
				}
				map[i][j] = input.charAt(j);
			}
		}
		
		while(!q.isEmpty()) {
			int fireQSize = fireQ.size();
			for(int f = 0; f < fireQSize; f++) {
				Point fireP = fireQ.poll();
				int fireX = fireP.x;
				int fireY = fireP.y;
				for(int i = 0; i < 4; i++) {
					int new_x = fireX + dir[i][0];
					int new_y = fireY + dir[i][1];
					if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= m) continue;
					else if(fireVisit[new_x][new_y]) continue;				
					else if(map[new_x][new_y] == '#') continue;
					fireVisit[new_x][new_y] = true;
					fireQ.add(new Point(new_x, new_y));
				}
			}
			
			int qCnt = q.size();
			for(int t = 0; t < qCnt; t++) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				int cnt = p.cnt;
				
				for(int i = 0; i < 4; i++) {
					int new_x = x + dir[i][0];
					int new_y = y + dir[i][1];
					if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= m) {
						System.out.println(cnt+1);
						return;
					}else if(visit[new_x][new_y]) continue;
					else if(fireVisit[new_x][new_y]) continue;
					else if(map[new_x][new_y] == '#') continue;
					visit[new_x][new_y] = true;
					q.add(new Point(new_x, new_y, cnt+1));
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}
