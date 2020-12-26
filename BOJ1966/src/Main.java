import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i = 0; i < tc; i++) {

			int[] pri_arr = new int[10];
			Deque<Integer> dq = new LinkedList<Integer>();
			Deque<Integer> no = new LinkedList<Integer>();
			int n = sc.nextInt();
			int cnt = 1;
			int myPri = -1;
			int findIdx = sc.nextInt();
			for(int j = 0; j < n; j++) {
				int tmp = sc.nextInt();
				pri_arr[tmp]++;
				if(j == findIdx)
					myPri = tmp;
				dq.addLast(tmp);
			}
			for(int j = 9; j > 0; j--) {
				boolean isPass = false;
				while(pri_arr[j] > 0) {
					int tmp = dq.peekFirst();
					if(tmp == j) {
						if(findIdx == 0) {
							isPass = true;
							break;
						}
						cnt++;
						dq.pollFirst();
						findIdx--;
						pri_arr[j]--;
					}else {
						dq.addLast(dq.pollFirst());
						if(findIdx == 0)
							findIdx = dq.size()-1;
						else
							findIdx--;
					}
							
				}
				if(isPass) break;
			}
			System.out.println(cnt);
		}
	}
}
