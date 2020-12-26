import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int op = sc.nextInt();
			if(op == 0) {
				if(q.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(q.poll());
				}
			}else {
				q.add(op);
			}
		}
	}
}
