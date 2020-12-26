import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] arr = new boolean[264913];
		arr[1] = true;
		for(int i = 2; i <= 246912; i++) {
			for(int j = 2; i*j <= 246912; j++) {
				arr[i*j] = true;
			}
		}
		while(true) {
			int n = sc.nextInt();
			if(n == 0) return;
			int cnt = 0;
			for(int i = n+1; i <= 2*n; i++)
				if(!arr[i])
					cnt++;
			System.out.println(cnt);
		}

	}
}
