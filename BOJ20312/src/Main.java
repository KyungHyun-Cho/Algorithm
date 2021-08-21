import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long tmp = 0, answer = 0;
		
		for(int i = 1; i < n; ++i) {
			long bc = sc.nextLong();
			tmp = ((tmp + 1) * bc) % 1_000_000_007;
			answer = (answer + tmp) % 1_000_000_007;
		}
		
		System.out.println(answer);
	}
}
