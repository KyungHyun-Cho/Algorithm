import java.util.ArrayList;

class Solution {
	public static long answer = 0;
	public static long pCnt = 0, nCnt = 0;
	public static ArrayList<Integer>[] map;
	public static long[] la;
    public long solution(int[] a, int[][] edges) {
    	map = new ArrayList[a.length];
    	la = new long[a.length];
    	
    	for(int i = 0; i < a.length; i++) {
    		map[i] = new ArrayList<>();
    		la[i] = a[i];
    	}
    	for(int i = 0; i < a.length; i++) {
    		if(a[i] < 0) nCnt += a[i];
    		else pCnt += a[i];
    	}
    	
    	if(Math.abs(nCnt) != pCnt)
    		return -1;
    	else if(nCnt == 0)
    		return 0;
    	
    	for(int[] edge : edges) {
    		map[edge[0]].add(edge[1]);
    		map[edge[1]].add(edge[0]);
    	}
    	
    	DFS(0, 0);
        return answer;
    }
    public static void DFS(int before, int selected) {
    	
		for(int next : map[selected]) {
			if(next != before) {
				DFS(selected, next);
			}
		}

		la[before] += la[selected];
		answer += Math.abs(la[selected]);
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] a = {-5,0,2,1,2};
    	int[][] edges = {{0,1},{3,4},{2,3},{0,3}};
    	System.out.println(solution.solution(a, edges));    			
    }
}    