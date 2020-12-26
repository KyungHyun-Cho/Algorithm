import java.util.*;
public class Main {
	static int n, answer = 0;;
	static int[][] map; // 0��ĭ 1�� 2���� 3���� 4�밢��
	static int[][] dir = {{0, 1}, {1, 0}, {1, 1}}; // 0���� 1���� 2�밢��
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
				//������ ��� ���� + �밢���� ���� �� ����
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
				//������ ��� ���� + �밢�� ����
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
				//�밢���� ��� ���� ���� �밢�� ����
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
		//���� ����� ��� false
		if(x < 0 || y < 0 || x >= n || y >= n) return false;
		//������ �ϴ� ���� �� ������ �ƴϸ� false
		if(map[x][y] != 0) return false;
		//�밢���� ��� ����,��ܵ� Ȯ���������
		if(mode == 4) 
			if(map[x-1][y] != 0 || map[x][y-1] != 0) return false;
		
		return true;
	}
}
