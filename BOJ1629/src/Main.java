import java.util.Scanner;
public class Main {
	static int a,b,c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		System.out.println(pow(a,b));
	}
	public static long pow(int i, int j) {
		if(j == 0) return 1;
		long tmp = pow(i, j/2);
		long ret = (tmp * tmp) % c;
		if(j % 2 == 1) ret = (ret * i) % c;
		return ret;
	}
}