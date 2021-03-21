import java.util.*;
public class Main {
	public static void main(String[] args) {
		//n = 3인 경우
		//30, 26, 22, 18, 14, 10, 6, 2 를 말하는 사람이 필승법임
		//n = 2인 경우
		//30, 27, 24, 21, 18, 15, 12, 9, 6, 3, 0 을 말하는 사람이 필승법임
		//n = 1인 경우
		//30, 28, 26, 24, ... 4, 2, 0을 말하는 사람이 필승법임.
		//즉, 30 % (n+1) == 0이면 후공이 이기는 구조.
		Scanner sc = new Scanner(System.in);
		boolean[] possible = new boolean[32];
		for(int i = 1; i <= 31; i++) {
			possible[i] = (30 % (i+1)) == 0;
		}
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			if(possible[i]) System.out.println(i);
		}
	}
}
