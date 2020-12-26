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
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int remain_cnt = 0;
	static boolean[][] visit;
	static Deque<Point> delete = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) remain_cnt++;
			}
		}
		int time = 0;
		int prev_cnt = 0;
		while(remain_cnt != 0) {
			visit = new boolean[n][m];
			prev_cnt = remain_cnt;
			BFS();
			doDelete();
			time++;
		}
		System.out.println(time + "\n" + prev_cnt);
	}
	public static void BFS() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0));
		visit[0][0] = true;
		while(!q.isEmpty()) {
			Point point = q.poll();
			int x = point.x;
			int y = point.y;
			for(int i = 0; i < 4; i++) {
				int new_x = x + dir[i][0];
				int new_y = y + dir[i][1];
				if(new_x >= 0 && new_x < n && new_y >= 0 && new_y < m) {
					if(!visit[new_x][new_y] && map[new_x][new_y] == 0) {
						q.add(new Point(new_x, new_y));
						visit[new_x][new_y] = true;
					}else if(map[new_x][new_y] == 1) {
						delete.addLast(new Point(new_x,new_y));
					}						
				}
			}
		}
	}
	/*public static boolean isPrevious() {
		
	}*/
	public static void doDelete() {
		while(!delete.isEmpty()) {
			Point point = delete.pollFirst();			
			if(map[point.x][point.y] == 1) {
				map[point.x][point.y] = 0;
				remain_cnt--;
			}
		}
	}
}
