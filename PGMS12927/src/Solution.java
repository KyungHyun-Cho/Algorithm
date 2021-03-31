import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
    	int idx = works.length - 1;
    	Arrays.sort(works);
    	int c = works[idx];
    	
    	while(n-->0) {
    		if(works[idx] == 0) return 0;
    		else if(works[idx] == c) {
    			works[idx--] -= 1;
    			if(idx < 0) idx = works.length - 1;
    		}else {
    			idx = works.length - 1;
    			c = works[idx];
    			n += 1;
    		}
    	}
    	
    	long answer = 0;
    	for(int work : works)
    		answer += Math.pow(work, 2);
        return answer;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		//int n = 4;
		//int[] works = {4, 3, 3};
		int n = 3;
		int[] works = {1, 1};
		//int n = 1;
		//int[] works = {2, 1, 2};
		System.out.println(solution.solution(n, works));
	}

}
