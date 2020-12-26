import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int l = 1, r = k;
		long ans = 0;
		while(l <= r) {
			int mid = (l+r) >>> 1;
			long mid_idx = getIdx(n, mid);
			if(mid_idx < k) {
				l = mid + 1;
			}else {
				ans = mid;
				r = mid-1;
			}
				
		}
		System.out.println(ans);
		
	}
	public static long getIdx(int n, int mid) {
		long tmp = 0;
		for(int i = 1; i <= n; i++)
			tmp += Math.min(mid/i, n);
		return tmp;
	}
}
