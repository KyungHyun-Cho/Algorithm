import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int sum = 0;
		Deque<Character> q = new LinkedList<>();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				q.addFirst(str.charAt(i));
			}else {
				q.pollFirst();
				if(str.charAt(i-1) == '(') 
					sum += q.size();
				else
					sum++;
			}
		}
		System.out.println(sum);
	}
}