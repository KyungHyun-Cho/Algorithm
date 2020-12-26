import java.util.*;
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int t = sc.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < m; j++) 
				map[i][j] = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int x = sc.nextInt(); // x의 배수인 애들을 d방향으로 회전
			int d = sc.nextInt(); // d:0->시계방향, d:1->반시계방향
			int k = sc.nextInt(); // k번 회전
			for(int j = 0; j < n; j++) {
				if((j+1) % x == 0)
					rotate(map[j], d, k);
			}
			if(!pop())
				set_avg();
		}
		int sum = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
	public static void set_avg() {
		int sum = 0;
		int cnt = 0;
		double avg = 0.0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] != 0) {
					sum += map[i][j];
					cnt++;
				}
			}			
		}
		avg = sum / (double)cnt;
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < m; j++)
				if(map[i][j] != 0 && map[i][j] < avg)
					map[i][j] += 1;
				else if(map[i][j] != 0 && map[i][j] > avg) 
					map[i][j] -= 1;		
		
	}
	public static boolean pop() {
		boolean ret = false;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(BFS(new Point(i, j))) ret = true;
			}
		}
		clear_visit();
		return ret;
	}
	public static boolean BFS(Point start) {
		if(visit[start.x][start.y]) return false;
		Queue<Point> q = new LinkedList<>();
		ArrayList<Point> arrList = new ArrayList<>();
		int std = map[start.x][start.y];
		q.add(start);
		arrList.add(start);
		visit[start.x][start.y] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int i = 0; i < 4; i++) {
				int new_x = x + dir[i][0];
				int new_y = y + dir[i][1];
				if(new_y < 0) new_y = m-1;
				if(new_y > m-1) new_y = 0;
				
				if(new_x >= 0 && new_y >= 0 && new_x < n && new_y < m) {
					if(!visit[new_x][new_y] && map[new_x][new_y] == std && map[new_x][new_y] != 0) {
						visit[new_x][new_y] = true;
						q.add(new Point(new_x,new_y));
						arrList.add(new Point(new_x, new_y));
					}
				}
			}
		}
		if(arrList.size() >= 2) {
			for(Point p : arrList)
				map[p.x][p.y] = 0;
			return true;
		}
		return false;
	}
	public static void rotate(int[] arr, int dir, int k) {
		if(k == m) return;
		Deque<Integer> dq = new LinkedList<>();
		for(int i = 0; i < m; i++)
			dq.addLast(arr[i]);
		for(int i = 0; i < k; i++) {
			if(dir == 0) {
				//시계방향				
				dq.addFirst(dq.pollLast());
			}else {
				//반시계방향
				dq.addLast(dq.pollFirst());
			}
		}
		int idx = 0;
		while(!dq.isEmpty()) {
			arr[idx++] = dq.pollFirst();
		}
	}
	public static void clear_visit() {
		for(boolean[] arr : visit)
			Arrays.fill(arr, false);
	}
}
