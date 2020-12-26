import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int n = stoi(str.split(" ")[0]);
		int m = stoi(str.split(" ")[1]);
		int[] arr = new int[n];
		int ans = -1;
		String[] arr_str = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			arr[i] = stoi(arr_str[i]);
			if(arr[i] > ans) ans = arr[i];
		}
		Arrays.sort(arr);
		System.out.println(getAns(arr, m, 0, ans));
		bw.flush();
		bw.close();
		br.close();
	}
	public static long getCnt(int[] arr, long ans) {
		long sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += Math.max(arr[i] - ans, 0);
		}
		return sum;
	}
	public static long getAns(int[] arr, int m, long l, long r) {
		if(l > r) return r;		
		long mid = (l+r) >>> 1;
		long cnt = getCnt(arr, mid);
		if(cnt >= m) {
			//잘려진 나무의 길이 합이 원하는 나무의 길이보다 많음
			//잘려진 나무의 길이 합을 줄여야함
			//톱의 높이를 올려야함 (우측 탐색)
			return getAns(arr, m, mid+1, r);
		}else {
			//잘려진 나무의 길이 합이 원하는 나무의 길이보다 적음
			//잘려진 나무의 길이 합을 늘려여야함
			//톱의 높이를 낮춰야함 (좌측 탐색)

			return getAns(arr, m, l, mid-1);
		}
	}
	
	public static int stoi(String str) {return Integer.parseInt(str);}
}
