import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		int[] fibo = new int[n+1];
		fibo[0] = fibo[1] = 1;
		for(int i = 2; i <= n; i++)
			fibo[i] = fibo[i-1] + fibo[i-2];
		
		for(int i = 0; i < m; i++) {
			int idx = sc.nextInt()-1;
			arr[idx] = 1;
		}
		
		int ans = 1;
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i] == 1) {
				ans *= fibo[cnt];
				cnt = 0;
				
			}else
				cnt++;
		}
		ans *= fibo[cnt];
		System.out.println(ans);
	}
}