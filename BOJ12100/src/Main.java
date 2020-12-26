import java.util.*;
public class Main {
	static int n, answer = 0;
	static int[][] map, copyMap;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		copyMap = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				answer = Math.max(map[i][j], answer);
			}
		Stack<Integer> st = new Stack<>();
		DFS(st, 0);		
		System.out.println(answer);
	}
	public static void DFS(Stack<Integer> st, int depth) {
		if(depth == 5) {
			process(st);
		}else {
			for(int i = 0; i < 4; i++) {
				st.push(i);
				DFS(st, depth + 1);
				st.pop();
			}
		}
	}
	public static void process(Stack<Integer> st) {
		copyArr(map, copyMap);
		for(int nowDir : st) {
			boolean[][] visit = new boolean[n][n];
			if(nowDir == 0) {
				for(int i = 1; i < n; i++) {
					for(int j = 0; j < n; j++) {
						if(copyMap[i][j] != 0) move(visit, i, j , nowDir);
					}
				}
			}else if(nowDir == 1) {
				for(int i = n-2; i >= 0; i--) {
					for(int j = 0; j < n; j++) {
						if(copyMap[i][j] != 0) move(visit, i, j , nowDir);
					}
				}
			}else if(nowDir == 2) {
				for(int j = 1; j < n; j++) {
					for(int i = 0; i < n; i++) {
						if(copyMap[i][j] != 0) move(visit, i, j , nowDir);
					}
				}
			}else if(nowDir == 3) {
				for(int j = n-2; j >= 0; j--) {
					for(int i = 0; i < n; i++) {
						if(copyMap[i][j] != 0) move(visit, i, j , nowDir);
					}
				}
			}
		}
	}
	public static void move(boolean[][] visit, int x, int y, int nowDir) {
		int val = copyMap[x][y];
		copyMap[x][y] = 0;
		while(true) {
			x += dir[nowDir][0];
			y += dir[nowDir][1];
			if(x < 0 || y < 0 || x >= n || y >= n) {
				x -= dir[nowDir][0];
				y -= dir[nowDir][1];
				copyMap[x][y] = val;
				break;
			}
			if(copyMap[x][y] == 0) {
				continue;
			}else if(copyMap[x][y] == val) {
				if(visit[x][y]) {
					x -= dir[nowDir][0];
					y -= dir[nowDir][1];
					copyMap[x][y] = val;
					break;
				}else {
					copyMap[x][y] += val;
					visit[x][y] = true;
					answer = Math.max(copyMap[x][y], answer);
					break;
				}
			}else{
				x -= dir[nowDir][0];
				y -= dir[nowDir][1];
				copyMap[x][y] = val;
				break;
			}
		}
	}
	public static void copyArr(int[][] src, int[][] dest) {
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				dest[i][j] = src[i][j];
	}
}
