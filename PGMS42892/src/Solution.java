import java.util.*;
class Node{
	public int n, x;
	public Node left, right;
	Node(int n, int x){
		this.n = n;
		this.x = x;
	}
	public Node addLeft(int n, int x) {
		this.left = new Node(n, x);
		return this.left;
	}
	public Node addRight(int n) {
		this.right = new Node(n, x);
		return this.right;
	}
	
}
class Solution {
    public int[][] solution(int[][] nodeinfo) {
    	HashMap<int[], Integer> map = new HashMap<>();
    	for(int i = 0; i < nodeinfo.length; i++)
    		map.put(nodeinfo[i], i);
    	
    	Arrays.sort(nodeinfo, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o2[1] == o1[1])
					return o1[0]-o2[0]; 
				else
					return o2[1]-o1[1];
			}
    	});
    	System.out.println(map.get(nodeinfo[0]));
    	Node root = new Node(0, nodeinfo[0][0]);
        int[][] answer = {};
        return answer;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		solution.solution(nodeinfo);
	}
}
