import java.util.*;
class Solution {
	class Info{
		String str = "";
		int cnt = 0;
		Info(String str, int cnt){
			this.str = str;
			this.cnt = cnt;
		}
	}
    public int solution(String begin, String target, String[] words) {
    	Queue<Info> q = new LinkedList<>();
    	q.add(new Info(begin, 0));
    	
    	while(!q.isEmpty()) {
    		Info info = q.poll();
    		if(target.equals(info.str)) return info.cnt;
    		for(int i = 0; i < words.length; i++)
    			if(!"".equals(words[i]) && isPossible(info.str, words[i])) {
    				q.add(new Info(words[i], info.cnt + 1));
    				words[i] = "";    				
    			}
    	}
        return 0;
    }
    public static boolean isPossible(String src, String dest) {
    	int cnt = 0;
    	for(int i = 0; i < src.length(); i++) {
    		if(src.charAt(i) != dest.charAt(i)) {
    			cnt++;
    			if(cnt > 1) return false;
    		}    		
    	}
    	return cnt == 1;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	String begin = "hit";
    	String target = "cog";
    	String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    	System.out.println(solution.solution(begin, target, words));
    }
}
