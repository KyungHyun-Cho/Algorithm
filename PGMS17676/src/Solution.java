import java.util.*;
class Solution {
	class Info implements Comparable<Info>{
		long STime, ETime;
		int t;
		public Info(long STime, long ETime, int t) {
			this.STime = STime;
			this.ETime = ETime;
			this.t = t;			
		}
		public int compareTo(Info o) {
			return (int)(STime - o.STime);
		}
	}
	public int solution(String[] lines) {
		ArrayList<Info> arr = new ArrayList<>();
		for(String input : lines) {
			long ETime = dateToLong(input);
			int t = (int)(Double.parseDouble(input.split(" ")[2].replace("s", "")) * 1000);
			long STime = ETime - t + 1;
			arr.add(new Info(STime, ETime, t));
		}
		Collections.sort(arr);
		
		int max = 0;
		for(int i = arr.size() - 1; i >= 0; i--) {
			int cnt = 0;
			for(int j = i; j >= 0; j--) {
				if(arr.get(j).ETime > arr.get(i).STime - 1000)
					cnt++;
			}
			max = Math.max(max, cnt);
		}
		return max;
	}
	public static long dateToLong(String date) {
		String[] arr = date.split("-| |:|\\.");
		long day = stol(arr[2]) * 3600 * 24 * 1000;
		long hour = stol(arr[3]) * 3600 * 1000;
		long min = stol(arr[4]) * 60 * 1000;
		long sec = stol(arr[5]) * 1000;
		long mSec = stol(arr[6]);
		return day+hour+min+sec+mSec;		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static long stol(String str) {return Long.parseLong(str);}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] lines = {
"2016-09-15 20:59:57.421 0.351s",
"2016-09-15 20:59:58.233 1.181s",
"2016-09-15 20:59:58.299 0.8s",
"2016-09-15 20:59:58.688 1.041s",
"2016-09-15 20:59:59.591 1.412s",
"2016-09-15 21:00:00.464 1.466s",
"2016-09-15 21:00:00.741 1.581s",
"2016-09-15 21:00:00.748 2.31s",
"2016-09-15 21:00:00.966 0.381s",
"2016-09-15 21:00:02.066 2.62s"
		};
		System.out.println(solution.solution(lines));
	}
}
