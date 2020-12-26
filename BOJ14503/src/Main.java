import java.util.*;
public class Main {
	static boolean[][] isCleaned;
	static int[][] map;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int n, m, x, y, d, cleanCnt=0, rotCnt=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		d = sc.nextInt(); // 0 : 북, 1 : 동, 2 : 남, 3 : 서
		map = new int[n][m];
		isCleaned = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		step1();
		while(true) {
			step2();
		}
		
		
	}
	public static void step1() {
		if(!isCleaned[x][y]) {
			isCleaned[x][y] = true;
			cleanCnt++;
		}
	}
	public static void step2() {
		if(rotCnt == 4) {
			int new_x = x - dir[d][0];
			int new_y = y - dir[d][1];
			if(isWall(new_x, new_y)) {
				System.out.println(cleanCnt);
				System.exit(0);
			}else {
				//후진
				x = new_x;
				y = new_y;
				rotCnt = 0;
			}
		}
		d = (d-1) < 0 ? 3 : d-1;
		rotCnt++;
		int new_x = x + dir[d][0];
		int new_y = y + dir[d][1];
		if(!isWall(new_x,new_y)) {
			//갈 수 있는 곳이라면
			if(!isCleaned[new_x][new_y]) {
				//청소하지 않은 곳이라면 (2-a)
				x = new_x;
				y = new_y;
				step1();
				rotCnt = 0;
			}else {
				//청소할 공간이 없다면 그냥 pass (2-b)
			}
		}
		
		
	}
	public static boolean isWall(int x, int y) {
		return map[x][y] == 0? false:true;
	}
}
