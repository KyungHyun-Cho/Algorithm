import java.util.*;
import java.io.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		int n = stoi(str[0]);
		int c = stoi(str[1]);
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = stoi(br.readLine());
		Arrays.sort(arr);
		int ans = 1000000000;
		System.out.println(getAns(arr, c, 0, ans));
		br.close();
		bw.flush();
		bw.close();
	}
	public static boolean isPossible(int[] arr, long ans, int c) {
		int pos = arr[0];
		int cnt = 1;
		for(int i = 0; i < arr.length; i++) {
			if((arr[i] - pos) >= ans) {cnt++; pos = arr[i];}
			if(cnt >= c) return true;
		}
		return false;
	}
	public static long getAns(int[] arr, int c, long l, long r) {
		if(l > r) return r;
		long mid = (l + r) >>> 1;
		/*if(mid < 10) {
			System.out.println("BP!");
		}*/
		boolean p = isPossible(arr, mid, c);
		if(p) {
			//���� ans�� �����ϴٸ�, ans�� �� �÷��� �׽�Ʈ�غ�����. �� ���� �˻�
			return getAns(arr, c, mid+1, r);
		}else {
			//���� ans�� �Ұ����ϴٸ�, ans�� �� �ٿ��� �׽�Ʈ�غ�����. �� ���� �˻�
			return getAns(arr, c, l, mid-1);			
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
