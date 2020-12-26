import java.util.*;
class Point{
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n, m, k;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		int max = Integer.MIN_VALUE;
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i < k; i++) {
			int p = sc.nextInt()-1;
			int q = sc.nextInt()-1;
			map[p][q] = 1;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visit[i][j] && map[i][j] == 1) {
					int ret = getMax(i, j);
					max = Math.max(max,  ret);
				}
			}
		}
		System.out.println(max);
	}
	public static int getMax(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i, j));
		visit[i][j] = true;
		int sum = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();

			sum++;
			int now_x = p.x;
			int now_y = p.y;
			for(int t = 0; t < 4; t++) {
				int new_x = now_x + dir[t][0];
				int new_y = now_y + dir[t][1];
				if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= m) continue;
				if(visit[new_x][new_y]) continue;
				visit[new_x][new_y] = true;
				if(map[new_x][new_y] == 1) 
					q.add(new Point(new_x, new_y));
				
			}
		}
		return sum;
	}
}
