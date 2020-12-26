import java.util.*;
import java.io.*;
public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fLine = br.readLine();
		n = stoi(fLine.split(" ")[0]);
		m = stoi(fLine.split(" ")[1]);
		map = new int [n+1][m+1];
		visit = new boolean[n+1][m+1];
		
		for(int i = 1; i <= n; i++) {
			String str = br.readLine();			
			for(int j = 1; j <= m; j++)
				map[i][j] = str.charAt(j-1)-'0';
		}
		
		visit[1][1] = true;
		DFS(1, 1, 0, 1);
		
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	
	public static void DFS(int p, int q, int breakCnt, int moveCnt) {
		if(p == n && q == m) {
			if(moveCnt < min)
				min = moveCnt;	
		}else {
			for(int i = 0; i < 4; i++) {
				int newx = p + dir[i][0];
				int newy = q + dir[i][1];				
				if(newx > 0 && newy > 0 && newx <= n && newy <= m) {
					//유효한 경로인지부터 확인
					if(!visit[newx][newy]) {
						//방문을 안 한 경우에만 방문해야겠음.
						if(map[newx][newy] == 1) {
							//벽이라면
							if(breakCnt == 0) {
								//처음 부수는 경우만 부숨
								visit[newx][newy] = true;
								DFS(newx,newy,breakCnt+1,moveCnt+1); //벽을 1회 부수고 다시 DFS
								visit[newx][newy] = false;
							}
						}else {
							//벽이 아니라면
							visit[newx][newy] = true;
							DFS(newx,newy,breakCnt,moveCnt+1); //벽을 부수지 않고 다시 DFS
							visit[newx][newy] = false;
						}
					}
				}
			}
		}
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
