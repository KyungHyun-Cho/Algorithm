class Solution {
    public int solution(int[] money) {
    	int len = money.length;
    	if(len == 3) 
    		return Math.max(money[0], Math.max(money[1], money[2]));
    	else if(len == 4)
    		return Math.max(money[0] + money[2], money[1] + money[3]);

    	int[] dp = new int[len];
    	int[] dp2 = new int[len];
    	dp[0] = money[0];
    	dp[1] = Math.max(money[0], money[1]);
    	
    	dp2[0] = money[1];
    	dp2[1] = Math.max(money[1]], money[2]);
    	for(int i = 2; i < len-1; i++) {
    		dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
    	}
    	for(int i = 2; i < len-1; i++) {
    		dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i+1]);
    	}
    	
        return Math.max(dp[len-2], dp2[len-2]);
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] money = {1, 2, 0, 1, 4, 6, 7};
		System.out.println(solution.solution(money));
	}

}
