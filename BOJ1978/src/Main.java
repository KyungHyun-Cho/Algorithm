import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] arr = new boolean[1001];
		arr[1] = true;
		for(int i = 2; i <= 1000; i++) {
			for(int j = 2; i*j <= 1000; j++) {
				arr[i*j] = true;
			}
		}
		int n = sc.nextInt();
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			if(!arr[tmp]) cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
}
