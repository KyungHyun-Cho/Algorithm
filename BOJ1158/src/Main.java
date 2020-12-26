import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int k = sc.nextInt();
		for(int i = 1; i <= n; i++)
			q.add(i);
		sb.append("<");
		while(!q.isEmpty()) {
			for(int i = 0; i < k-1; i++) {
				q.add(q.poll());
			}
			sb.append(q.poll() + ", ");
		}
		System.out.println(sb.substring(0, sb.length()-2) + ">");
	}

}
