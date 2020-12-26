import java.util.*;
class Point {
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //세로선 갯수
		int m = sc.nextInt(); //가로선 갯수
		int h = sc.nextInt(); //세로선마다 가로선을 놓을 수 있는 위치의 갯수
		int[][] map = new int[h][n];
		ArrayList<Point> availableList = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			map[x][y] = 1;
		}
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n-1; j++) {
				if(map[i][j] == 1) continue;
				if(j == 0) {
					if(map[i][j+1] == 0)
						availableList.add(new Point(i, j));
				}else if(j == n-2) {
					if(map[i][j-1] == 0)
						availableList.add(new Point(i, j));
				}else {
					if(map[i][j-1] == 0 && map[i][j+1] == 0)
						availableList.add(new Point(i, j));					
				}
			}
		}		
		//선을 i개 긋고 만족 테스트
		for(int i = 0; i <= 3; i++) 
			comb(map, availableList, 0, i, 0);
		System.out.println(-1);
	}
	public static void comb(int[][] map, ArrayList<Point> availableList, int idx, int c, int forIdx) {
		if(idx == c) {
			if(check(map)) {
				System.out.println(c);
				System.exit(0);
			}
		}else {
			for(int i = idx+forIdx; i < availableList.size(); i++) {
				int x = availableList.get(i).x, y = availableList.get(i).y;
				if(y > 0 && map[x][y-1] == 1)
					continue;
				map[x][y] = 1;
				comb(map, availableList, idx+1, c, i);
				map[x][y] = 0;
			}
		}
	}
	public static boolean check(int[][] map) {
		for(int i = 0; i < map[0].length; i++) 
			if(i != get_ret(map, i)) 
				return false;
		return true;
		
	}
	public static int get_ret(int[][] map, int i) {
		for(int t = 0; t < map.length; t++) {
			if(map[t][i] == 1) //우측으로 이동
				i++;
			else if(i > 0 && map[t][i-1] == 1) //좌측으로 이동
				i--;
		}
		return i;
	}
}
