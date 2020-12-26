import java.util.*;
public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int cnt=0;
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		BFS();
		if(isFull())
			System.out.println(cnt);
		else
			System.out.println(-1);
	}
	
	public static boolean BFS() {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		int qCount = 0;
		boolean isChanged = false;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					qx.add(i);
					qy.add(j);
				}
			}
		}
		qx.add(-999);
		qy.add(-999);
		while(!qx.isEmpty()) {
			int x = qx.poll();
			int y = qy.poll();
			if(x == -999) {
				//구분자를 만났을 때
				if(qx.size() == 0) {
					//마지막이였다면? 끝내기.
					break;
				}else {
					//아니라면? 다시 -999 넣기
					qx.add(-999);
					qy.add(-999);
					cnt++;
					continue;
				}
			}
			visit[x][y] = true;
			for(int i = 0; i < dir.length; i++) {
				int newx = x + dir[i][0];
				int newy = y + dir[i][1];
				if(newx >= 0 && newx < n && newy >= 0 && newy < m && map[newx][newy] == 0) {
					map[newx][newy] = 1;
					qx.add(newx); qy.add(newy);
					
					isChanged = true;
				}
			}
		}
		return isChanged;
	}
	
	public static void printMap() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
				
			}
			System.out.println();
		}

		System.out.println();
	}
	
	public static boolean isFull() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
}