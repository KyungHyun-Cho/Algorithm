import java.util.Scanner;
import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int k = sc.nextInt();
			int floor = k % h;
			if(floor == 0) floor = h;
			int ho = (int) Math.ceil((double)k/(double)h);
			System.out.print(floor);
			System.out.printf("%02d", ho);
			System.out.println("");
		}
	}
}
