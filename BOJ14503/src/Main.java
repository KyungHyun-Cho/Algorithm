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
		d = sc.nextInt(); // 0 : ��, 1 : ��, 2 : ��, 3 : ��
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
				//����
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
			//�� �� �ִ� ���̶��
			if(!isCleaned[new_x][new_y]) {
				//û������ ���� ���̶�� (2-a)
				x = new_x;
				y = new_y;
				step1();
				rotCnt = 0;
			}else {
				//û���� ������ ���ٸ� �׳� pass (2-b)
			}
		}
		
		
	}
	public static boolean isWall(int x, int y) {
		return map[x][y] == 0? false:true;
	}
}
