import java.util.*;
import java.lang.*;
public class Main {
	static boolean[] visit;
	static int find;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int now = sc.nextInt();
		find = sc.nextInt();
		visit = new boolean[200001];
		BFS(now);
		System.out.println(cnt);
	}
	
	public static void BFS(int now) {
		visit[now] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(now);
		q.add(-999);
		while(!q.isEmpty()) {
			int tmp = q.poll();
			if(tmp == -999) {
				//±¸ºÐÁ¡
				if(q.isEmpty()) break;
				q.add(-999);
				tmp = q.poll();
				cnt++;
			}

			visit[tmp] = true;
			if(tmp == find) {
				break;
			}
			int a = tmp-1;
			int b = tmp+1;
			int c = tmp*2;
			if(a >= 0 && a <= 200000 && !visit[a]) q.add(a);
			if(b >= 0 && b <= 200000 && !visit[b]) q.add(b);
			if(c >= 0 && c <= 200000 && !visit[c]) q.add(c);
			
		}
	}
}
