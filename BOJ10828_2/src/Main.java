import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<>();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			if(str.equals("push")) {
				int k = sc.nextInt();
				s.push(k);
			}else if(str.equals("pop")) {
				System.out.println((s.isEmpty()?-1:s.pop()));
			}else if(str.equals("size")) {
				System.out.println(s.size());
			}else if(str.equals("empty")) {
				System.out.println(s.isEmpty()?1:0);
			}else if(str.equals("top")) {
				System.out.println(s.isEmpty()?-1:s.peek());
			}
		}
	}
}
