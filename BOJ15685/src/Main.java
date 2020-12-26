import java.util.*;
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static final int SIZE = 101;
	static int[][] map = new int[SIZE][SIZE];
	//static int[][] dir = {{0, 1}, {-1, 0}, {0, -1} ,{1, 0}};
	static int[][] dir = {{1, 0}, {0, -1}, {-1, 0} ,{0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			Stack<Point> s = new Stack<>();
			s.push(new Point(x,y));
			map[y][x] = 1;
			int new_x = x + dir[d][0];
			int new_y = y + dir[d][1];
			s.push(new Point(new_x, new_y));
			map[new_y][new_x] = 1;
			for(int j = 0; j < g; j++) {				
				rotate(s);
			}
		}
		System.out.println(get_answer());
	}
	public static void rotate(Stack<Point> s) {
		Point base = s.peek();
		int sSize = s.size();
		for(int i = sSize-2; i >= 0; i--) {
			Point p = s.get(i);
			int now_x = p.x;
			int now_y = p.y;
			int new_x = -1;
			int new_y = -1;
			int x_diff = Math.abs(now_x-base.x);
			int y_diff = Math.abs(now_y-base.y);
			if(now_x > base.x && now_y < base.y) {
				//1사분면
				new_x = base.x + y_diff;
				new_y = base.y + x_diff;
			}else if(now_x < base.x && now_y < base.y) {
				//2사분면
				new_x = base.x + y_diff;
				new_y = base.y - x_diff;
			}else if(now_x < base.x && now_y > base.y) {
				//3사분면
				new_x = base.x - y_diff;
				new_y = base.y - x_diff;
			}else if(now_x > base.x && now_y > base.y) {
				//4사분면
				new_x = base.x - y_diff;
				new_y = base.y + x_diff;
			}else if(now_x > base.x && now_y == base.y) {
				//오른쪽에 걸친
				new_x = base.x;
				new_y = base.y + x_diff;
			}else if(now_x == base.x && now_y > base.y) {
				//아래에 걸친
				new_x = base.x - y_diff;
				new_y = base.y;
			}else if(now_x < base.x && now_y == base.y) {
				//왼쪽에 걸친
				new_x = base.x;
				new_y = base.y - x_diff;
			}else if(now_x == base.x && now_y < base.y) {
				//위에 걸친
				new_x = base.x + y_diff;
				new_y = base.y;
			}
			if(new_x >= 0 && new_y >= 0 && new_x < SIZE && new_y < SIZE) {
				s.push(new Point(new_x, new_y));
				map[new_y][new_x] = 1;
			}
		}
	}
	public static int get_answer() {
		int ret = 0;
		for(int i = 0; i < SIZE-1; i++) {
			for(int j = 0; j < SIZE-1; j++) {
				if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1)
					ret++;
			}
		}
		return ret;
	}
}
