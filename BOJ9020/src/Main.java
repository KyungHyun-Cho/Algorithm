import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] arr = new boolean[10001];
		arr[1] = true;
		for(int i = 2; i <= 10000; i++) {
			for(int j = 2; i*j <= 10000; j++) {
				arr[i*j] = true;
			}
		}
		int tc = sc.nextInt();
		for(int i = 0; i < tc; i++) {
			int n = sc.nextInt();
			int min = Integer.MAX_VALUE;
			int x = -1, y = -1;
			for(int j = 2; j <= 6000; j++) {
				if(j > n-j) break;
				if(!arr[j] && !arr[n-j]) {
					x = j; y = n-j;
				}
			}
			System.out.println(x + " " + y);
		}
	}
}
