import java.util.*;
public class Main {
	static int n, m;
	static int[][] map;
	static boolean[] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int max = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+1][m+1];
		visit = new boolean[26];
		for(int i = 1; i <= n; i++) {
			String str = sc.next();
			for(int j = 0; j < str.length(); j++) {
				map[i][j+1] = str.charAt(j)-'A';
			}
		}
		visit[map[1][1]] = true;
		DFS(1,1,1);
		System.out.println(max);
	}
	public static void DFS(int p, int q, int move_cnt) {
		max = move_cnt>max?move_cnt:max;
		for(int i = 0; i < 4; i++) {
			int new_p = p + dir[i][0];
			int new_q = q + dir[i][1];
			if(new_p > 0 && new_p <= n && new_q > 0 && new_q <= m) {
				if(!visit[map[new_p][new_q]]) {
					visit[map[new_p][new_q]] = true;
					DFS(new_p, new_q, move_cnt + 1);
					visit[map[new_p][new_q]] = false;					
				}
			}
		}
	}
}

//BPZUWKYCGR