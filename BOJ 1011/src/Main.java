import java.util.Scanner;
import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			y -= x;
			x = 0;
			if(y <= 3) {
				System.out.println(y);
			}else if(isPow(y)) {
				System.out.println((int)Math.sqrt(y)*2-1);
			}else {
				int min = (int)Math.sqrt(y)*2;
				if(y <= Math.pow((int)Math.sqrt(y)+1,2) - (int)Math.sqrt(y) - 1)
					System.out.println(min);
				else
					System.out.println(min+1);
			}
		}
	}
	public static boolean isPow(int k) {
		if(Math.sqrt(k) == (int)Math.sqrt(k)) {
			return true;
		}else
			return false;
	}
}
