import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// ù ��° ������ Ű�� ���/ ��Ű�� ���/ �Ұ����� ��� INF�� ����
		int ans1 = 1, ans2 = 0, INF = 987654321;
		String now = sc.next();
		String expect = sc.next();
		
		int[] now_arr_1 = new int[n]; // ù ��° ������ Ű�� ���
		int[] now_arr_2 = new int[n]; // ù ��° ������ Ű�� �ʴ� ���
		int[] expect_arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			now_arr_1[i] = now.charAt(i)-'0';
			now_arr_2[i] = now.charAt(i)-'0';
			expect_arr[i] = expect.charAt(i)-'0';
		}
		now_arr_1[0] = 1-now_arr_1[0]; // ����ġ�� �Ѵ� ���. ������ 1�̾��ٸ� 0����, ������ 0�̾��ٸ� 1�� �ȴ�!
		now_arr_1[1] = 1-now_arr_1[1];
				
		for(int i = 1; i < n; i++) {
			//ù ��° ������ Ű�� ���
			if(now_arr_1[i-1] != expect_arr[i-1]) {
				now_arr_1[i-1] = 1 - now_arr_1[i-1];
				now_arr_1[i] = 1 - now_arr_1[i];
				ans1++;
				if(i != n-1)
					now_arr_1[i+1] = 1 - now_arr_1[i+1];						
				
			}
			
			//ù ��° ������ Ű�� �ʴ� ���
			if(now_arr_2[i-1] != expect_arr[i-1]) {
				now_arr_2[i-1] = 1 - now_arr_2[i-1];
				now_arr_2[i] = 1 - now_arr_2[i];
				ans2++;
				if(i != n-1)
					now_arr_2[i+1] = 1 - now_arr_2[i+1];		
			}
		}

		if(now_arr_1[n-1] != expect_arr[n-1]) ans1 = INF;
		if(now_arr_2[n-1] != expect_arr[n-1]) ans2 = INF;
		
		
		if(ans1 == INF && ans2 == INF)
			System.out.println(-1);
		else
			System.out.println(Math.min(ans1, ans2));
	}
}
