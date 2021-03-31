import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
    	int n = triangle.length;
    	int answer = 0;
    	if(n == 1) return triangle[0][0];
    	
    	int[][] map = new int[n+1][n+1];
    	int[][] dp = new int[n+1][n+1];
    	
    	for(int i = 1; i <= n; i++)
    		for(int j = 1; j <= i; j++)
    			map[i][j] = triangle[i-1][j-1];
    	
    	dp[1][1] = map[1][1];
    	for(int i = 2; i <= n; i++)
    		for(int j = 1; j <= i; j++) {
    			dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j-1], dp[i-1][j]) + map[i][j]);
    			answer = Math.max(dp[i][j],  answer);
    		}
    	
        return answer;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution.solution(triangle));
	}
}
