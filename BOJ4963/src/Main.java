import java.util.*;
import java.io.*;
public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int w, h;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_arr;
		while(true) {
			str_arr = br.readLine().split(" ");
			w = stoi(str_arr[0]);
			h = stoi(str_arr[1]);
			map = new int[h+1][w+1];
			visit = new boolean[h+1][w+1];
			if(w == 0 && h == 0) break;
			for(int i = 1; i <= h; i++) {
				str_arr = br.readLine().split(" ");
				for(int j = 1; j <= w; j++)
					map[i][j] = stoi(str_arr[j-1]);
			}
			int cnt = 0;
			for(int i = 1; i <= h; i++) {
				for(int j = 1; j <= w; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						cnt++;
						DFS(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}
	public static void DFS(int p, int q) {
		visit[p][q] = true;
		for(int i = 0; i < 8; i++) {
			int new_p = p + dir[i][0];
			int new_q = q + dir[i][1];
			if(new_p > 0 && new_p <= h && new_q > 0 && new_q <= w && !visit[new_p][new_q] && map[new_p][new_q] == 1) {
				DFS(new_p,new_q);
			}
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
