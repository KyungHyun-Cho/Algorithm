import java.util.*;
public class Main {
	static ArrayList<Integer>[] map;
	static boolean[] visit;
	static int friendCnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = Integer.MIN_VALUE;
		map = new ArrayList[n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++)
			map[i] = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			int strLength = str.length();
			for(int j = 0; j < strLength; j++) {
				if(str.charAt(j) == 'Y') {
					map[i].add(j);					
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			friendCnt = 0;
			Arrays.fill(visit, false);
			getFriendCount(i);
			ans = Math.max(ans,  friendCnt);
		}
		System.out.println(ans);
		
	}
	public static void getFriendCount(int idx) {
		visit[idx] = true;
		for(int i : map[idx]) {
			if(!visit[i]) {
				friendCnt++;
				getFriendCount(i);
			}
		}
	}
}
