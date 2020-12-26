import java.util.*;
public class Main {
	static Deque<Integer> dq = new LinkedList<Integer>();
	static int[] idx_arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 0;
		idx_arr = new int[n+1];
		idx_arr[0] = -1;
		for(int i = 1; i <= n; i++)
			dq.addLast(i);
		for(int i = 1; i <= n; i++)
			idx_arr[i] = i-1;
		for(int i = 0; i < m; i++) {
			int k = sc.nextInt();
			boolean isPass = false;
			while(true) {
				if(idx_arr[k] == 0) {
					pop();
					break;
				}
				int diff_left = idx_arr[k];
				int diff_right = dq.size() - idx_arr[k];
				if(diff_left > diff_right) {
					RotateRight();
				}else {
					RotateLeft();
				}
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	public static void RotateRight() {
		dq.addFirst(dq.pollLast());
		for(int i = 1; i < idx_arr.length; i++) {
			if(idx_arr[i] != -1) {
				idx_arr[i]++;
				if(idx_arr[i] > dq.size()-1)
					idx_arr[i] = 0;
			}
		}
	}
	public static void RotateLeft() {
		dq.addLast(dq.pollFirst());
		for(int i = 1; i < idx_arr.length; i++) {
			if(idx_arr[i] != -1) {
				idx_arr[i]--;
				if(idx_arr[i] < 0)
					idx_arr[i] = dq.size()-1;
			}
		}
	}
	public static int pop() {
		for(int i = 1; i < idx_arr.length; i++) {
			if(idx_arr[i] != -1) {
				idx_arr[i]--;
			}
		}
		return dq.pollFirst();
	}
}
