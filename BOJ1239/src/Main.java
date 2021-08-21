import java.util.*;
import java.io.*;
public class Main {
	static int n = 0, answer = 0;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		if(n == 1) {
			System.out.println(0);
			return;
		}
		String[] inputArr = br.readLine().split(" ");
		arr = new int[n];
		visit = new boolean[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = stoi(inputArr[i]);
				
		System.out.println(DFS(new int[n], 0));
		
	}
	static int DFS(int[] a, int idx) {
		int ret = 0;
		if(idx == n) {
			return GetSepCnt(a);
		}else {
			for(int i = 0; i < n; i++) {
				if(visit[i]) continue;
				visit[i] = true;
				a[idx] = arr[i];
				ret = Math.max(ret, DFS(a, idx + 1));
				visit[i] = false;
			}
		}
		return ret;
	}
	static int GetSepCnt(int[] arr) {
		int mid = GetMid(arr);
		int cnt = 0; // 중앙을 가로지르는 선의 개수
		
		int s = 0;
		int e = 0;
		int sum = arr[0];
		while(s <= mid && e <= n-1 && s <= e) {
			if(sum == 50) {
				cnt++;
				sum -= arr[s++];
				if(e+1 < n)
					sum += arr[++e];
			}else if(sum < 50) {
				if(e+1 < n)
					sum += arr[++e];
			}else if(sum > 50) {
				sum -= arr[s++];
			}
		}
		return cnt;
	}
	
	static int GetMid(int[] arr) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += arr[i];
			if(sum >= 50) return i;
		}
		return -1;
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
