import java.util.*;
class Solution {
	public int solution(int[][] routes) {
		Arrays.sort(routes, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				else 
					return o1[1] - o2[1];
			}
		});
		int pos = routes[0][1];
		int cnt = 1;
		for(int i = 1; i < routes.length; i++) {
			int[] info = routes[i];
			if(info[0] > pos) {
				cnt++;
				pos = info[1];
			}
		}	
		return cnt;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(solution.solution(routes));
	}

}
