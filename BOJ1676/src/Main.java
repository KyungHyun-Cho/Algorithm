import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			int tmp = i;
			while(true) {
				if(tmp % 5 == 0) {
					cnt++;
					tmp /= 5;
				}else
					break;
			}
		}
		System.out.println(cnt);
	}
}
//import java.util.*;
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		System.out.println(n/5 + n/25 + n/125);
//	}
//}
