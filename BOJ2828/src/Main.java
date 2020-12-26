import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s_width = sc.nextInt();
		int b_width = sc.nextInt();
		int b_x_min = 1;
		int b_x_max = b_width;
		int n = sc.nextInt();
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			int a_x = sc.nextInt();
			if(!(b_x_min <= a_x && a_x <= b_x_max)) {
				int diff = -1;
				if(a_x > b_x_max) { //오른쪽으로 이동
					diff = a_x - b_x_max;
					b_x_min += diff;
					b_x_max += diff;
					cnt += diff;
				}else if(a_x < b_x_min) { // 왼쪽으로 이동
					diff = b_x_min - a_x;
					b_x_min -= diff;
					b_x_max -= diff;
					cnt += diff;
				}
			}
		}
		System.out.println(cnt);
	}
}
