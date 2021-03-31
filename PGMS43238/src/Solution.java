import java.util.*;
public class Solution {
	public long solution(int n, int[] times) {
		long min = 0;
		long max = Long.MAX_VALUE;
		long cnt = -1;
		long avg = 0;
		long ret = max;
		while(max >= min) {
			avg = (min + max) / (long)2;
			cnt = pplCnt(times, avg);
			if(cnt >= n) {
				ret = Math.min(ret, avg);
				max = avg-1;
			}else if(cnt < n) {
				min = avg+1;
			}
		}
		return ret;
	}
	
	public long pplCnt(int[] times, long avg) {
		long sum = 0;
		for(int time : times)
			sum += Math.ceil(avg/time);
		return sum;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 20;
		int[] times = {45, 46, 59, 50, 30, 23, 11, 6, 60, 74};
		//int[] times = {3, 8, 3, 6, 9, 2, 4};
		System.out.println(solution.solution(n, times));
	}

}
