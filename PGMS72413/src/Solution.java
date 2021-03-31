import java.util.*;
class Solution {
    public long solution(int V, int s, int a, int b, int[][] fares) {
		final long INF = 1990000000;
		int E = fares.length;
		long[][] dist = new long[V+1][V+1];
		for(long[] item : dist)
			Arrays.fill(item, INF);
		
		for(int i = 0; i < E; i++) {
			int from = fares[i][0];
			int to = fares[i][1];
			int cost = fares[i][2];
			dist[from][to] = cost;
			dist[to][from] = cost;			
		}
		for(int i = 1; i <= V; i++) {
			for(int j = 1; j <= V; j++) {
				dist[j][j] = 0;
				for(int k = 1; k <= V; k++) {
					dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
				}
			}
		}
		
		long min = dist[s][a] + dist[s][b];		
		for(int i = 1; i <= V; i++) {
			long tmp1 = dist[s][i] + dist[i][a] + dist[i][b];
			long tmp2 = dist[s][i] + dist[i][a] + dist[a][b];
			long tmp3 = dist[s][i] + dist[i][b] + dist[b][a];
			min = Math.min(Math.min(Math.min(tmp1, min), tmp2), tmp3);
		}
        
        return min;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int n = 6;
    	int s = 4;
    	int a = 6;
    	int b = 2;
    	int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
    	System.out.println(solution.solution(n, s, a, b, fares));
    }
}