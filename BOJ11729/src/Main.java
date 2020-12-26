import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		move(n,1,3);
		System.out.println(cnt);
		System.out.println(sb.toString());
		
	}
	public static void move(int n, int from, int to) {
		int middle = 6-from-to;
		if(n == 1) {
			cnt++;
			sb.append(from + " " + to + "\n");
			return;
		}
		else if(n >= 2) {
			move(n-1, from, middle);
			move(1, from, to);
			move(n-1, middle, to);
		}
	}
}