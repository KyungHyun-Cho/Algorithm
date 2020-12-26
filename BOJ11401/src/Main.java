import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int d = 1000000007;
		k = n-k < k ? n-k : k;
		long boonja = 1;
		double boonmo = 1;
		for(int i = n; i > n-k; i--) {
			boonja = ((boonja % d) * (i % d)) % d;			
		}
		System.out.println(boonja);
		for(int i = k; i > 0; i--) {
			boonmo = (1.0/((1.0/ ((1.0/boonmo) % d) * ((1.0/i) % d)))) % d;			
		}
		System.out.println(boonmo);
		System.out.println(boonja/boonmo);
		
	}
}
