import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int INF = 987654321;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = stoi(st.nextToken());
		int m= stoi(st.nextToken());
		int[][] map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(map[i], INF);
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s1 = stoi(st.nextToken())-1;
			int s2 = stoi(st.nextToken())-1;
			
			map[s1][s2] = 1;
		}
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(i == j) continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					
				}
			}
		}
		
		StringBuilder answer = new StringBuilder();
		int k = stoi(br.readLine());
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p1 = stoi(st.nextToken())-1;
			int p2 = stoi(st.nextToken())-1;
			
			if(map[p1][p2] != INF)
				answer.append(-1).append('\n');
			else if(map[p2][p1] != INF)
				answer.append(1).append('\n');
			else
				answer.append(0).append('\n');
			
		}
		
		System.out.println(answer);
		
	}
	static int stoi(String str) {return Integer.parseInt(str);}

}
