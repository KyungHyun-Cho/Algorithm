import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> dq = new LinkedList<Integer>();
		int n = sc.nextInt();
		int k = sc.nextInt();
		String str = "<";
		for(int i = 1; i <= n; i++)
			dq.addLast(i);
		while(!dq.isEmpty()) {
			for(int i = 0; i < k-1; i++)
				dq.addLast(dq.pollFirst());
			str += dq.pollFirst() + ", ";
		}
		str = str.substring(0,str.length()-2) + ">";
		System.out.print(str);
	}
}
