import java.lang.*;
import java.util.*;
import java.io.*;
public class Main {
	static long d = 1000000007;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr_str = br.readLine().split(" ");
		int n = stoi(arr_str[0]); // 수의 갯수 (arr배열의 크기)
		int m = stoi(arr_str[1]); // 수의 변경이 일어나는 횟수
		int k = stoi(arr_str[2]); // 구간의 합을 구하는 횟수
		long[] arr = new long[n];
		int[] tree_idx_arr = new int[n];
		int h = (int)Math.ceil(Math.log(n)/Math.log(2));
		int tree_size = 1 << (h+1);
		long[] tree_arr = new long[tree_size];
		for(int i = 0; i < n; i++)
			arr[i] = stoi(br.readLine());
		init(tree_arr, arr,tree_idx_arr, 1, 0, arr.length-1);
		for(int i = 0; i < m+k; i++) {
			arr_str = br.readLine().split(" ");
			int op = stoi(arr_str[0]); // 1 : b->c, 2 : sysout(b~c)
			int from = stoi(arr_str[1])-1; // arr_str Idx를 사용하므로 -1
			long to = stoi(arr_str[2]);
			if(op == 1) {

				//arr[from] = to;
				//init(tree_arr, arr, 1, 0, arr.length-1);
				update(tree_arr,arr,tree_idx_arr, from, to);
			}else {
				sb.append(mul(tree_arr,arr,1,from,to-1,0,arr.length-1) + "\n");
			}
		}
		
		
		System.out.println(sb.toString());
		br.close();	
	}
	
	public static long init(long[] tree_arr, long[] arr, int[] tree_idx_arr, int node, int l, int r) {
		if(l == r) {
			tree_idx_arr[l] = node;
			return tree_arr[node] = arr[l];
		}
		int mid = (l+r) >>> 1;
		return tree_arr[node] = (init(tree_arr, arr, tree_idx_arr, node*2, l, mid) * init(tree_arr, arr, tree_idx_arr, node*2+1, mid+1,r)) % d;
	}
	public static void update(long[] tree_arr, long[] arr, int[] tree_idx_arr, int idx, long diff) {
		int tree_idx = tree_idx_arr[idx];
		arr[idx] = diff;
		tree_arr[tree_idx] = diff;
		tree_idx /= 2;
		
		while(tree_idx != 0) {
			tree_arr[tree_idx] = (tree_arr[tree_idx*2] * tree_arr[tree_idx*2 + 1]) % d;
			tree_idx /= 2;
		}
	}
	public static long mul(long[] tree_arr, long[] arr, int node, long l, long r, int s, int e) {
		//l,r 구하고자 하는 l,r
		//s,e 현재 탐색중인 범위 (초반에 0, max 해야함)
		if(r < s || e < l) return 1;
		if(l <= s && e <= r) return tree_arr[node];
		int mid = (s+e) >>> 1;
		return (mul(tree_arr, arr, node*2, l, r, s, mid) * mul(tree_arr,arr,node*2+1,l,r,mid+1,e))%d;
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
