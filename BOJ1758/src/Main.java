import java.util.*;
import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] t = new int[n];
		long sum = 0;
		int s = 0;
		for(int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
		}
		Arrays.sort(t);
		for(int i = n-1; i >= 0; i--) {
			sum += Math.max(0, t[i] - s);
			s++;
		}
		System.out.println(sum);
	}
}
