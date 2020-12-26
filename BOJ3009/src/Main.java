import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] x = new int[1001];
		int[] y = new int[1001];
		for(int i = 0; i < 3; i++) {
			int tmp_x = sc.nextInt();
			int tmp_y = sc.nextInt();
			x[tmp_x]++;
			y[tmp_y]++;			
		}
		int rx = 0;
		int ry = 0;
		for(int i = 1; i <= 1000; i++) {
			if(x[i] == 1) rx = i;
			if(y[i] == 1) ry = i;			
		}
		System.out.println(rx + " " + ry);
	}
}
