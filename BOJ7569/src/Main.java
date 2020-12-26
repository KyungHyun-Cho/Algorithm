import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	static int[][][] map;
	static boolean[][][] visit;
	static int[][] dir = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
	static int cnt=0;
	static int n, m, h;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
		map = new int[h][n][m];
		visit = new boolean[h][n][m];

		for(int k = 0; k < h; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					map[k][i][j] = sc.nextInt();
				}
			}
		}
		//printMap();
		BFS();
		if(isFull())
			System.out.println(cnt);
		else
			System.out.println(-1);
	}
	
	public static void BFS() {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> qz = new LinkedList<Integer>();
		for(int k = 0; k < h; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[k][i][j] == 1 && !visit[k][i][j]) {
						qx.add(i);
						qy.add(j);
						qz.add(k);
					}
				}
			}
		}
		qx.add(-999);
		qy.add(-999);
		qz.add(-999);
		while(!qx.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			int z = qz.poll();
			if(x == -999) {
				//구분자를 만났을 때
				if(qx.size() == 0) {
					//마지막이였다면? 끝내기.
					break;
				}else {
					//아니라면? 다시 -999 넣기
					qx.add(-999);
					qy.add(-999);
					qz.add(-999);
					cnt++;
					continue;
				}
			}
			visit[z][x][y] = true;
			for(int i = 0; i < dir.length; i++) {
				int newx = x + dir[i][0];
				int newy = y + dir[i][1];
				int newz = z + dir[i][2];
				if(newx >= 0 && newx < n && newy >= 0 && newy < m && newz >= 0 && newz < h && map[newz][newx][newy] == 0) {
					map[newz][newx][newy] = 1;
					qx.add(newx); qy.add(newy);qz.add(newz);
					
				}
			}
		}
	}
	
	public static void printMap() {
		for(int k = 0; k < h; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					System.out.print(map[k][i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean isFull() {
		for(int k = 0; k < h; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[k][i][j] == 0) return false;
				}
			}
		}
		return true;
	}
}