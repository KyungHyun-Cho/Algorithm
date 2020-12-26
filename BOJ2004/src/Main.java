import java.lang.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//System.out.println(zero_cnt(n));
		/*System.out.println(zero_cnt(n));
		System.out.println(zero_cnt(m));
		System.out.println(zero_cnt(n-m));*/
		System.out.println(Math.min(cnt_two(n)-cnt_two(m)-cnt_two(n-m), cnt_five(n)-cnt_five(m)-cnt_five(n-m)));
	}
	public static long cnt_two(int n) {
		long cnt_2=0;
		long int_2 = 2;
		while(int_2 <= 2000000000) {
			cnt_2 += (n / int_2);
			int_2 *= 2;
		}
		return cnt_2;
	}
	public static long cnt_five(int n) {
		long cnt_5=0;
		long int_5 = 5;
		while(int_5 <= 2000000000) {
			cnt_5 += (n / int_5);
			int_5 *= 5;
		}
		return cnt_5;
	}
}
