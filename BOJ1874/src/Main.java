import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int now = 1;
		boolean[] isUsed = new boolean[n+1];
		Deque<Integer> dq = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			int k = sc.nextInt();
			if(k >= now) {
				for(int j = now; j <= k; j++) {
					if(!isUsed[j]) {
						dq.addFirst(j);
						sb.append("+\n");
						now = j;
						isUsed[j] = true;
					}
				}
				dq.pollFirst();
				now--;
				if(now == 0) now = 1;
				sb.append("-\n");
			}else {
				if(dq.peekFirst() == k) {
					dq.pollFirst();
					now--;
					if(now == 0) now = 1;
					sb.append("-\n");
				}else {
					if(now-k >= 1) {
						System.out.println("NO");
						return;
					}else {
						dq.pollFirst();
						now--;
						if(now == 0) now = 1;
						sb.append("-\n");
					}
				}
			}
		}
		System.out.println(sb.toString());
	}

}
