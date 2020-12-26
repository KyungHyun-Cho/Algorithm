import java.util.*;
import java.lang.*;
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int answer = 0;
		int[][] map = new int[n][m];
		int[][] copy_map = new int[n][m];
		
		ArrayList<Point> arrlist = new ArrayList<>();
		ArrayList<Point> vlist = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) {
					arrlist.add(new Point(i, j));
				}else if(map[i][j] == 2) {
					vlist.add(new Point(i, j));
				}
			}
		}
		for(int i = 0; i < arrlist.size(); i++) {
			Point p1 = arrlist.get(i);
			map[p1.x][p1.y] = 1;
			for(int j = i+1; j < arrlist.size(); j++) {
				Point p2 = arrlist.get(j);
				map[p2.x][p2.y] = 1;
				for(int k = j+1; k < arrlist.size(); k++) {
					Point p3 = arrlist.get(k);
					map[p3.x][p3.y] = 1;					
					copy_arr(map, copy_map);
					for(Point p : vlist)
						DFS(copy_map, n, m, p.x, p.y);
					answer = Math.max(answer, get_vCnt(copy_map));
					map[p3.x][p3.y] = 0;
				}
				map[p2.x][p2.y] = 0;
			}
			map[p1.x][p1.y] = 0;
		}
		System.out.println(answer);
	}
	public static void DFS(int[][] map, int n, int m, int x, int y) {
		map[x][y] = 2;
		for(int i = 0; i < 4; i++) {
			int new_x = x + dir[i][0];
			int new_y = y + dir[i][1];
			if(new_x >= 0 && new_y >= 0 && new_x < n && new_y < m) {
				if(map[new_x][new_y] == 0) {
					DFS(map, n, m, new_x, new_y);
				}
			}
		}
	}
	public static void copy_arr(int[][] src, int[][] dest) {
		for(int i = 0; i < src.length; i++) {
			for(int j = 0; j < src[0].length; j++) {
				dest[i][j] = src[i][j];
			}
		}
	}
	public static int get_vCnt(int[][] map) {
		int cnt = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
}
