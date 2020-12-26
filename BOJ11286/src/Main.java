import java.util.*;
import java.lang.*;
class absClass implements Comparable<absClass>{
	int n;
	public absClass(int n) {
		this.n = n;
	}
	
	public int compareTo(absClass target) {
		if(Math.abs(this.n) > Math.abs(target.n))
			return 1;
		if(Math.abs(this.n) < Math.abs(target.n))
			return -1;
		else
			return this.n - target.n;
		
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<absClass> q = new PriorityQueue<>();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int op = sc.nextInt();
			if(op == 0) {
				if(q.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(q.poll().n);
				}
			}else {
				q.add(new absClass(op));
			}
		}
	}
}
