class Solution {
    public int solution(int n, int[] money) {
        int mCnt = money.length;
        int[] dp = new int[n+1];
        //Arrays.sort(money);
        dp[0] = 1;
		for(int i = 0; i < mCnt; i++) {
			for(int j = money[i]; j <= n; j++) {
				dp[j] = (dp[j] + dp[j-money[i]]) % 1_000_000_007;
			}
		}
        return dp[n];
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int n = 3;
    	int[] money = {1,2,5};
    	System.out.println(solution.solution(n, money));    			
    }
}    