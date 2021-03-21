import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		final int INF = 987654321;
		int n = stoi(br.readLine());
		int m = stoi(br.readLine());
		int[][] map = new int[n][n];
		int[][] map_rev = new int[n][n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(map[i], INF);
			Arrays.fill(map_rev[i], INF);
			map[i][i] = 0;
			map_rev[i][i] = 0;
		}
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int p = stoi(st.nextToken())-1;
			int q = stoi(st.nextToken())-1;
			map[p][q] = 0;
			map_rev[q][p] = 0;
		}
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
					if(map_rev[i][j] > map_rev[i][k] + map_rev[k][j])
						map_rev[i][j] = map_rev[i][k] + map_rev[k][j];
					
				}
			}
		}
		for(int i = 0; i < n; i++) {
			int cnt = 0;
			for(int j = 0; j < n; j++) 
				if(map[i][j] == INF && map_rev[i][j] == INF) cnt++;
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
