import java.util.*;

class Point{
	int x, y, moveCnt = 0;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	Point(int x, int y, int moveCnt){
		this.x = x;
		this.y = y;
		this.moveCnt = moveCnt;
	}
}
public class Main {
	static int n, m, fuel, now_x, now_y;
	static int[][] map;
	static ArrayList<Point> cust, dest;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static Point taxi;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cust = new ArrayList<>();
		dest = new ArrayList<>();
		n = sc.nextInt();
		m = sc.nextInt();
		fuel = sc.nextInt();
		
		map = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				map[i][j] = sc.nextInt();
		
		int now_x = sc.nextInt()-1;
		int now_y = sc.nextInt()-1;
		taxi = new Point(now_x, now_y);
		for(int i = 0; i < m; i++) { 
			int depart_x = sc.nextInt()-1;
			int depart_y = sc.nextInt()-1;
			int dest_x = sc.nextInt()-1;
			int dest_y = sc.nextInt()-1;
			cust.add(new Point(depart_x, depart_y));
			dest.add(new Point(dest_x, dest_y));
		}
		int ans = 0;
		for(; ans < m; ans++) {
			int min_idx = -1;
			int fuel_taxi_cust = Integer.MAX_VALUE;
			int fuel_cust_dest = 0;
			for(int i = 0; i < cust.size(); i++) {
				int tmp_dist = get_dist(taxi, cust.get(i));
				if(fuel_taxi_cust > tmp_dist) {
					fuel_taxi_cust = tmp_dist;
					min_idx = i;
				}else if(fuel_taxi_cust == tmp_dist) {
					if(cust.get(i).x < cust.get(min_idx).x) {
						min_idx = i;
					}else if(cust.get(i).x == cust.get(min_idx).x && cust.get(i).y < cust.get(min_idx).y) {
						min_idx = i;
					}
				}
			}
			
			if(fuel_taxi_cust > fuel) {
				fuel = -1;
				break;
			}
			fuel_cust_dest = get_dist(cust.get(min_idx), dest.get(min_idx));
			if(fuel_taxi_cust + fuel_cust_dest > fuel) {
				fuel = -1;
				break;
			}
			fuel -= (fuel_taxi_cust + fuel_cust_dest);
			fuel += (fuel_cust_dest*2);
			taxi.x = dest.get(min_idx).x;
			taxi.y = dest.get(min_idx).y;
			
			cust.remove(min_idx);
			dest.remove(min_idx);
		}
		System.out.println(fuel);
	}
	public static int get_dist(Point src, Point dest) {
		boolean[][] visit = new boolean[n][n];
		Queue<Point> q = new LinkedList<>();
		q.add(src);
		visit[src.x][src.y] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			int moveCnt = p.moveCnt;
			if(x == dest.x && y == dest.y) {
				return moveCnt;
			}
			for(int i = 0; i < 4; i++) {
				int new_x = x + dir[i][0];
				int new_y = y + dir[i][1];
				if(new_x >= 0 && new_y >= 0 && new_x < n && new_y < n) {
					if(!visit[new_x][new_y] && map[new_x][new_y] != 1) {
						visit[new_x][new_y] = true;
						q.add(new Point(new_x, new_y, moveCnt+1));
					}
				}				
			}
		}
		System.out.println(-1);
		System.exit(0);
		return -1;
	}
}
