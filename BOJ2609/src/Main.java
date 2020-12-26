import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int gcd = GCD(n, m);
		int lcm = n*m/gcd;
		System.out.println(gcd + "\n" + lcm);
	}
	public static int GCD(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
