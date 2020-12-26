import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long sum = 0;
		int[] s = new int[n];
		for(int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
		}
		Arrays.sort(s);
		for(int i= 0; i < n; i++) {
			sum += Math.abs(s[i]-i-1);
		}
		System.out.println(sum);
	}
}
