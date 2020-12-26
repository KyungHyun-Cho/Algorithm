import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int k = sc.nextInt();
		int n = sc.nextInt();
		int ans = -1;
		int[] arr = new int[k];
		for(int i = 0; i < k; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] > ans) ans = arr[i];
		}
		System.out.println(getMax(arr,n,0,ans));
	}
	public static long getCnt(int[] arr, long ans) {
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			cnt += arr[i] / ans;
		}
		return cnt;
	}
	public static long getMax(int[] arr, int n, long l, long r) {
		if(l > r) return r;
		long mid = (l+r+1) >>> 1;
		long cnt = getCnt(arr, mid);
		if(cnt < n) {
			//���� ���� ��ǥ������ ����. ��, mid���� �ʹ� ũ�ٴ� ����. mid���� �ٿ�����, mid ���� �������� �˻�
			return getMax(arr, n, l, mid-1);
		}else {
			//���� ���� ��ǥ������ ���ų�. ��, mid���� �ʹ� �۴ٴ� ����. mid���� �÷�����, mid ���� �������� �˻�
			return getMax(arr, n, mid+1, r);
		}
	}
}
