import java.util.*;
class Point {
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n, m; // 다른 함수에서 접근하기 위해 전역변수로 변경
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int answer = 0;
		int[][] map = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				map[i][j] = sc.nextInt();
		
		while(true) {
			int massCnt = getMassCnt(map);
			if(massCnt >= 2) {
				System.out.println(answer);
				return;
			}else if(massCnt == 0) {
				System.out.println(0);
			}
			melt(map);
			answer++;
		}
	}
	public static void melt(int[][] map) {
		//바다 위치를 기억해준다.
		ArrayList<Point> waterList = new ArrayList<>();
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(map[i][j] == 0) waterList.add(new Point(i, j));
		
		for(Point p : waterList) {
			int now_x = p.x;
			int now_y = p.y;
			for(int i = 0; i < 4; i++) {
				//전역변수에서 선언한 dir을 이용해 상하좌우 이동 시도!
				int new_x = now_x + dir[i][0];
				int new_y = now_y + dir[i][1];
				
				//만약 새로 이동할 좌표가 맵을 벗어나면, 다음 방향으로 continue!
				//만약 새로 이동할 좌표가 빙산이 아닌 바닷물이라면, 패스!
				if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= m) continue;
				if(map[new_x][new_y] == 0) continue;

				//빙산을 1씩 녹인다!
				map[new_x][new_y]--;
			}
		}
	}
	public static int getMassCnt(int[][] map) {
		boolean[][] visit = new boolean[n][m];
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				//맵 전체를 순회하면서!
				if(!visit[i][j] && map[i][j] != 0) {
					//방문한 적이 없고, 빙산이라면 (바닷물이 아니라면) 덩어리의 갯수를 1 증가하고 BFS 수행!
					cnt++;
					Queue<Point> q = new LinkedList<>();
					q.add(new Point(i, j));
					visit[i][j] = true; // 해당 좌표를 방문처리한다!
					while(!q.isEmpty()) {
						Point p = q.poll();
						int now_x = p.x;
						int now_y = p.y;
						for(int k = 0; k < 4; k++) {
							//전역변수에서 선언한 dir을 이용해 상하좌우 이동 시도!
							int new_x = now_x + dir[k][0];
							int new_y = now_y + dir[k][1];
							
							//만약 새로 이동할 좌표가 맵을 벗어나면, 다음 방향으로 continue!
							//만약 새로 이동할 좌표가 빙산이 아닌 바닷물이라면, 패스!
							//새로 이동할 좌표가 이미 방문한 곳이라면, 패스!
							if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= m) continue;
							if(map[new_x][new_y] == 0) continue;
							if(visit[new_x][new_y]) continue;
							
							//새로 이동할 좌표가 맵 안에 있다면, 큐에 넣어주고 방문처리!
							q.add(new Point(new_x, new_y));
							visit[new_x][new_y] = true;
						}
					}
				}
			}
		}
		return cnt;
	}
}
