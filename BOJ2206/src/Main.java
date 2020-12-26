import java.util.*;
import java.io.*;
class Place{
	int x, y;
	int breakCnt;
	int moveCnt;
	public Place(int x, int y,int breakCnt, int moveCnt) {
		this.x = x;
		this.y = y;
		this.breakCnt = breakCnt;
		this.moveCnt = moveCnt;
	}
}
public class Main {
	static int n, m;
	static int[][] map;
	static int[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int min = Integer.MAX_VALUE;	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fLine = br.readLine();
		n = stoi(fLine.split(" ")[0]);
		m = stoi(fLine.split(" ")[1]);
		map = new int [n+1][m+1];
		visit = new int[n+1][m+1];
		
		for(int i = 1; i <= n; i++) {
			String str = br.readLine();			
			for(int j = 1; j <= m; j++) {
				map[i][j] = str.charAt(j-1)-'0';
				visit[i][j] = 2;
			}
		}
		min = Integer.MAX_VALUE;
		
		BFS(1,1);
		
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	public static void BFS(int x, int y) {
		Deque<Place> q = new LinkedList<Place>();
		q.add(new Place(x,y,0,1));
		visit[x][y] = 0;
		while(!q.isEmpty()) {
			Place p = q.pollFirst();
			if(p.x == n && p.y == m) {
				min = p.moveCnt;
				return;
			}else {
				for(int i = 0; i < 4; i++) {
					int newx = p.x + dir[i][0];
					int newy = p.y + dir[i][1];
					if(newx > 0 && newx <= n && newy > 0 && newy <= m) {
						//유효성 먼저 검사
						if(visit[newx][newy] > p.breakCnt) {
							//visit : 2 -> 미방문이므로 p가 벽을 0번 부쉈든 1번 부쉈든 가능함
							//visit : 1 -> 한번 부순 벽이므로 p.bCnt == 0인 노드가 온다면, 최소경로를 갱신할 수 있으므로 True를 반환하나
							//				p.bCnt == 1인 노드가 온다면, 굳이? 답은 나오는데 시간낭비임
							//visit : 0 -> 이미 0번 부수고 갈 수 있는 길인데 굳이 1번 부수고서 되돌아갈 필요가 있음?
							if(map[newx][newy] == 0) {
								//벽이 아니면
								
								/*if(visit[newx][newy] == 1)
									System.out.println("이런 경우도 있는지 보고싶음 (틀렸습니다 나오겠지?)");
									//실제로 출력초과가 출력되는 것을 확인함!*/

								visit[newx][newy] = p.breakCnt;
								q.add(new Place(newx, newy, p.breakCnt, p.moveCnt+1));
							}else {
								//벽이면
								if(p.breakCnt == 0) {
									//한번도 깨부순적이 없다면
									visit[newx][newy] = p.breakCnt + 1; //깨부순 처리
									q.add(new Place(newx, newy, p.breakCnt + 1, p.moveCnt + 1));
								}
							}
						}
					}
				}
			}
		}
		System.out.println("없다");
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
