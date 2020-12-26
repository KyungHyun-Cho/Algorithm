import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] arr = new boolean[m+1];
		arr[1] = true;
		for(int i = 2; i <= m; i++) {
			for(int j = 2; i*j <= m; j++) {
				arr[i*j] = true;
			}
		}
		int sum = 0;
		int min = -1;
		for(int i = m; i >= n; i--)
			if(!arr[i]) {
				sum += i;
				min = i;
			}
		if(sum == 0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
			
		sc.close();
	}
}
