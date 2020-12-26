import java.util.*;
public class Main {
	static int n, m, x, y, cmd_cnt, bottom=5;
	static int[][] map, dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	static int[] cmd, dice;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		cmd_cnt = sc.nextInt();
		map = new int[n][m];
		cmd = new int[cmd_cnt];
		dice = new int[6]; //상 하 좌 우 앞 뒤
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				map[i][j] = sc.nextInt();
		for(int i = 0; i < cmd_cnt; i++)
			rotate(sc.nextInt());
	}
	public static void swap() {
		if(map[x][y] == 0) {
			map[x][y] = dice[1];
		}else {
			dice[1] = map[x][y];
			map[x][y] = 0;
		}
		System.out.println(dice[0]);
	}
	public static void rotate(int cmd) {
		int new_x = x + dir[cmd-1][0];
		int new_y = y + dir[cmd-1][1];
		if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= m) {
			//밖으로 나가는 경우
			return;
		}
		int temp = 0;
		//			01 23 45
		//dice[] -> 상하좌우앞뒤
		if(cmd == 1) {
			//동쪽
			//앞,뒤는 동일
			//우->하, 하->좌, 좌->상, 상->우
			temp = dice[3];
			dice[3] = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[1];
			dice[1] = temp;
		}else if(cmd == 2) {
			//서쪽
			//앞,뒤는 동일
			//우->상, 상->좌, 좌->하, 하->우
			temp = dice[3];
			dice[3] = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[0];
			dice[0] = temp;
		}else if(cmd == 3) {
			//북쪽
			//좌,우는 동일
			//상->뒤, 뒤->하, 하->앞, 앞->상
			temp = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[5];
			dice[5] = temp;
		}else if(cmd == 4) {
			//남쪽
			//좌,우는 동일
			// 상->앞, 앞->하, 하->뒤, 뒤->상
			temp = dice[0];
			dice[0] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[4];
			dice[4] = temp;
		} 
		x = new_x;
		y = new_y;
		swap();
	}
	
	public static int get_top() {
		return 5-bottom;
	}
}
