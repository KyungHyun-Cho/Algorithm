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
		for(int i = n; i <= m; i++)
			if(!arr[i])
				System.out.println(i);
		sc.close();
	}
}
