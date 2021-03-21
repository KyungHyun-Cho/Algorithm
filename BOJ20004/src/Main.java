import java.util.*;
public class Main {
	public static void main(String[] args) {
		//n = 3�� ���
		//30, 26, 22, 18, 14, 10, 6, 2 �� ���ϴ� ����� �ʽ¹���
		//n = 2�� ���
		//30, 27, 24, 21, 18, 15, 12, 9, 6, 3, 0 �� ���ϴ� ����� �ʽ¹���
		//n = 1�� ���
		//30, 28, 26, 24, ... 4, 2, 0�� ���ϴ� ����� �ʽ¹���.
		//��, 30 % (n+1) == 0�̸� �İ��� �̱�� ����.
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
