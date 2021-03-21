import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int INF = 987654321;
		
		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());
		int r = stoi(st.nextToken());
		int[] itemCnt = new int[n];
		int[][] map = new int[n][n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			itemCnt[i] = stoi(st.nextToken());
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int p = stoi(st.nextToken()) - 1;
			int q = stoi(st.nextToken()) - 1;
			int l = stoi(st.nextToken());
			map[p][q] = map[q][p] = l;
		}
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = 0; j < n; j++)
				if(map[i][j] <= m) sum += itemCnt[j];
			
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
