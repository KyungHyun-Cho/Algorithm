import java.io.*;
import java.util.*;
class Point implements Comparable<Point>{
	int x, y, dist = 0;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	Point(int x, int y, int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
	public int compareTo(Point o) {
		return o.dist - dist;
	}
	
}
public class Main {
	static int n, m, answer = 0, INF = 100000;
	static int[][] map, map2;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		int country_cnt = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					setNum(i, j, country_cnt++);
				}
			}
		}
		country_cnt--;
		map2 = new int[country_cnt+1][country_cnt+1];
		for(int i = 0; i < country_cnt+1; i++) {
			for(int j = 0; j < country_cnt+1; j++) {
				map2[i][j] = INF;
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] > 0) {
					getDist(i, j, map[i][j], 0);
					getDist(i, j, map[i][j], 1);
				}
			}
		}
		for(int k = 1; k <= country_cnt; k++) {
			for(int i = 1; i <= country_cnt; i++) {
				for(int j = 1; j <= country_cnt; j++) {
					map2[i][j] = Math.min(map2[i][j], map2[i][k] + map2[k][j]);
				}
			}
		}
		int[] tmp = new int[country_cnt+1]; 
		Arrays.fill(tmp, INF);
		for(int i = 1; i <= country_cnt; i++) {
			for(int j = 1; j <= country_cnt; j++) {
				if(map2[i][j] == INF) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		//최소신장트리
		MST(country_cnt);
		
		System.out.println(answer);
		bw.flush();
		br.close();
		bw.close();
	}
	public static void MST(int max) {
		boolean[] visit = new boolean[max+1];
		PriorityQueue<Point> pq = new PriorityQueue<>(Collections.reverseOrder());
		Deque<Integer> dq = new LinkedList<>();
		dq.addLast(1);
		ArrayList<Point> tmp_list = new ArrayList<>();
		while(!dq.isEmpty()) {
			int now_idx = dq.pollFirst();
			visit[now_idx] = true;
			int cnt = 0;
			for(int i = 1; i <= max; i++) {
				if(map2[now_idx][i] != INF) {
					cnt++;
					if(!visit[i])
						pq.add(new Point(now_idx, i, map2[now_idx][i]));
				}
			}
			if(cnt == 0) {
				System.out.println(-1);
				System.exit(0);
			}
			while(!pq.isEmpty()) {
				Point p = pq.poll();
				if(!visit[p.y]) {
					visit[p.y] = true;
					answer += p.dist;
					dq.add(p.y);
					break;
				}else {
					map2[p.x][p.y] = INF;
					map2[p.y][p.x] = INF;
				}
			}
		}
	}
	public static void getDist(int x, int y, int startNo, int tDir) {
		boolean[][] visit = new boolean[n][m];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 0));
		visit[x][y] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int now_x = p.x;
			int now_y = p.y;
			int now_dist = p.dist;
			if(map[now_x][now_y] > 0 && map[now_x][now_y] != startNo) {
				if(now_dist == 2) continue;
				map2[startNo][map[now_x][now_y]] = Math.min(map2[startNo][map[now_x][now_y]], now_dist - 1);
				continue;
			}
			int s = -1;
			if(tDir == 0) s = 0;
			else s = 2;
			
			for(int i = s; i < s+2; i++) {
				int new_x = now_x + dir[i][0];
				int new_y = now_y + dir[i][1];
				if(new_x >= 0 && new_y >= 0 && new_x < n && new_y < m) {
					if(!visit[new_x][new_y] && map[new_x][new_y] != startNo) {
						visit[new_x][new_y] = true;
						q.add(new Point(new_x, new_y, now_dist + 1));
					}
				}
			}
		}
	}
	public static void setNum(int x, int y, int no) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visit[x][y] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int now_x = p.x;
			int now_y = p.y;
			map[now_x][now_y] = no;
			for(int i = 0; i < 4; i++) {
				int new_x = now_x + dir[i][0];
				int new_y = now_y + dir[i][1];
				if(new_x >= 0 && new_y >= 0 && new_x < n && new_y < m) {
					if(!visit[new_x][new_y] && map[new_x][new_y] == 1) {
						visit[new_x][new_y] = true;
						q.add(new Point(new_x, new_y));
					}
				}
			}
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
