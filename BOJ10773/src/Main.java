import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<>();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int k = sc.nextInt();
			if(k == 0)
				s.pop();
			else
				s.push(k);
		}
		if(s.isEmpty())
			System.out.println(0);
		else {
			int sum = 0;
			while(!s.isEmpty()) {
				sum += s.pop();
			}
			System.out.println(sum);
		}
	}
}
