import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num = 0;
		int cnt = 0;
		int n = sc.nextInt();
		while(cnt != n) {
			num++;
			if(Long.toString(num).contains("666")) cnt++;
		}
		System.out.println(num);
		sc.close();
	}
}
