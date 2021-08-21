import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
    	int start = 1;
    	int answer = 0;
    	for(int station : stations) {
    		int diff = station - w - start;
    		answer += diff % (w*2+1) == 0 ? (diff / (w*2+1)) : (diff / (w*2+1))+1;
    		start = station + w + 1;
    	}
    	if(start <= n) {
    		answer += (n-start+1) % (w*2+1) == 0 ? ((n-start+1) / (w*2+1)) : ((n-start+1) / (w*2+1))+1;
    	}
        return answer;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 16;
		int[] stations = {9};
		int w = 2;
		System.out.println(solution.solution(n, stations, w));
		int a = -1;
		int b = 15;
		System.out.println(a%b);
		System.out.println(a/b);
		System.out.println(a%b == 0 ? (a/b) : (a < 0 ? (a/b) : (a/b)+1));
		System.out.println(a%b == 0 ? (a/b) : (a <= 0 ? (a/b) : (a/b)+1));
		System.out.println(Math.ceil((double)a/b));
	}
}
