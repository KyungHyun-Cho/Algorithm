import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			Stack<Character> s = new Stack<>();
			String str = sc.next();
			boolean isPass = false;
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '(') {
					s.push(str.charAt(j));
				}else {
					if(s.isEmpty()) {
						System.out.println("NO");
						isPass = true;
						break;
					}
					else {
						s.pop();
					}						
				}
			}
			if(!isPass) {
				if(s.isEmpty())
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
}
