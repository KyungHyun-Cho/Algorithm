import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int now = 2;
		while(n != 1) {
			if(n % now == 0) {
				System.out.println(now);
				n /= now;
			}else
				now++;
		}
	}
}
