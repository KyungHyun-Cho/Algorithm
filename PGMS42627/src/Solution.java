import java.util.*;
public class Solution{
	class Info implements Comparable<Info>{
		int s, time;
		
		public Info(int s, int time) {
			this.s = s;
			this.time = time;
		}
		
		public int compareTo(Info o) {
			return time - o.time;
		}
	}
	public int solution(int[][] jobs) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		int idx = 0, pos = 0, cnt = jobs.length, answer = 0;
		
		Arrays.sort(jobs, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		while(idx < cnt || !pq.isEmpty()) {
			while(idx < cnt && jobs[idx][0] <= pos) {
				pq.add(new Info(jobs[idx][0], jobs[idx][1]));
				idx++;
			}
				
			if(pq.isEmpty()) {
				pos = jobs[idx][0];
			}else {
				Info info = pq.poll();
				answer += (pos-info.s+info.time);
				pos += info.time;
			}
			
		}
		
		return answer / cnt;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		//int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		int[][] jobs = {{0, 10}, {2, 10}, {9, 10}, {15, 2}};
		System.out.println(solution.solution(jobs));
	}

}
