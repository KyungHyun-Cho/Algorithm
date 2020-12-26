import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++)
			pq.add(sc.nextLong());
		for(int i = 0; i < m; i++) {
			long p = pq.poll();
			long q = pq.poll();
			pq.add(p+q);
			pq.add(p+q);			
		}
		long sum = 0;
		while(!pq.isEmpty())
			sum += pq.poll();
		System.out.println(sum);
	}
}
