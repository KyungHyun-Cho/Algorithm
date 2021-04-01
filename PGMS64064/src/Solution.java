import java.util.*;
class Solution {
	public static int answer = 0;
    public int solution(String[] user_id, String[] banned_id) {
    	int banned_cnt = banned_id.length;
    	Deque<String> picked = new LinkedList<>();
    	pick(user_id, banned_id , picked, 0, user_id.length, banned_cnt);
        return answer;
    }
    public static void pick(String[] user_id, String[] banned, Deque<String> picked, int start, int n, int r) {
    	if(r == 0) {
    		String[] picked_arr = new String[picked.size()];
    		String[] output_arr = new String[picked.size()];
    		boolean[] visit = new boolean[picked.size()];
    		picked.toArray(picked_arr);
    		if(comp(picked_arr, banned, output_arr, visit, 0, picked.size()))
    			answer++;
    	}else {
    		for(int i = start; i < n; i++) {
    			picked.addLast(user_id[i]);
    			pick(user_id, banned, picked, i + 1, n, r - 1);
    			picked.pollLast();
    		}
    	}
    }
    
    static boolean comp(String[] picked, String[] banned, String[] output, boolean[] visited, int depth, int r) {
        if (depth == r) {
            if(isPossible(picked, output)) return true;
        }else {     
	        for (int i=0; i<r; i++) {
	            if (visited[i] != true) {
	                visited[i] = true;
	                output[depth] = banned[i];
	                if(comp(picked, banned, output, visited, depth + 1, r)) return true;
	                visited[i] = false;
	            }
	        }
        }
        return false;
    }
    
    static boolean isPossible(String[] picked, String[] banned) {
    	
    	for(int i = 0; i < picked.length; i++) {
    		String src = picked[i];
    		String dest = banned[i];
    		if(src.length() != dest.length()) return false;
    		for(int j = 0; j < dest.length(); j++)
    			if(dest.charAt(j) != '*' && src.charAt(j) != dest.charAt(j)) return false;
    	}
    	return true;
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "abc1**"};
		Deque<String> dq = new LinkedList<>();
		System.out.println(solution.solution(user_id, banned_id));
	}

}
