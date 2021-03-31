import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
    	final int INF = 987654321;
    	int[][] map = new int[n][n];
    	for(int i = 0; i < n; i++)
    		for(int j = 0; j < n; j++)
    			if(i != j)
    				map[i][j] = INF;
    	
    	for(int[] cost : costs) {
    		int p = cost[0];
    		int q = cost[1];
    		int dist = cost[2];
    		map[p][q] = dist;
    		map[q][p] = dist;
    	}
    	
    	for(int k = 0; k < n; k++) {
    		for(int i = 0; i < n; i++) {
    			for(int j = 0; j < n; j++) {
    				map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
    			}
    		}
    	}
    	int answer = 0;
    	boolean[] visit = new boolean[n];
    	for(int i = 0; i < n; i++) {
    		int min = INF;
    		for(int j = 0; j < n; j++) {
    			if(!visit[j] && i != j && map[i][j] < min) {
    				min = map[i][j];
    				visit[j] = true;
    			}
    		}
    		answer += min;
    	}
        return answer;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution.solution(n, costs));
	}

}
