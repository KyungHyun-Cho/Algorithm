import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = 1; i < n; i++) {
			System.out.println((arr[0] / GCD(arr[0], arr[i])) + "/" + (arr[i] / GCD(arr[0], arr[i])));
		}
		
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
