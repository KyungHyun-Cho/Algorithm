import java.util.*;
public class Main {
	static int n, answer = 0;;
	static int[][] map; // 0빈칸 1벽 2가로 3세로 4대각선
	static int[][] dir = {{0, 1}, {1, 0}, {1, 1}}; // 0가로 1세로 2대각선
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				map[i][j] = sc.nextInt();
		
		map[0][1] = 2;
		DFS(0, 1);
		System.out.println(answer);
	}
	public static void DFS(int x, int y) {
		if(x == n-1 && y == n-1) {
			answer++;
		}else {
			if(map[x][y] == 2) {
				//가로인 경우 가로 + 대각선만 놓을 수 있음
				if(isPossible(x, y, 2)) {
					map[x][y+1] = 2;
					DFS(x, y+1);
					map[x][y+1] = 0;
				}
				if(isPossible(x, y, 4)) {
					map[x+1][y+1] = 4;
					DFS(x+1, y+1);
					map[x+1][y+1] = 0;
				}
			}else if(map[x][y] == 3) {
				//세로인 경우 세로 + 대각선 가능
				if(isPossible(x, y, 3)) {
					map[x+1][y] = 3;
					DFS(x+1, y);
					map[x+1][y] = 0;
				}
				if(isPossible(x, y, 4)) {
					map[x+1][y+1] = 4;
					DFS(x+1, y+1);
					map[x+1][y+1] = 0;
				}
			}else if(map[x][y] == 4) {
				//대각선인 경우 가로 세로 대각선 가능
				if(isPossible(x, y, 2)) {
					map[x][y+1] = 2;
					DFS(x, y+1);
					map[x][y+1] = 0;
				}
				if(isPossible(x, y, 3)) {
					map[x+1][y] = 3;
					DFS(x+1, y);
					map[x+1][y] = 0;
				}
				if(isPossible(x, y, 4)) {
					map[x+1][y+1] = 4;
					DFS(x+1, y+1);
					map[x+1][y+1] = 0;
				}
			}
		}
	}
	public static boolean isPossible(int x, int y, int mode) {
		x += dir[mode-2][0];
		y += dir[mode-2][1];
		//맵을 벗어나는 경우 false
		if(x < 0 || y < 0 || x >= n || y >= n) return false;
		//가고자 하는 곳이 빈 공간이 아니면 false
		if(map[x][y] != 0) return false;
		//대각선의 경우 좌측,상단도 확인해줘야함
		if(mode == 4) 
			if(map[x-1][y] != 0 || map[x][y-1] != 0) return false;
		
		return true;
	}
}
