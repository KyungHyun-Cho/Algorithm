import java.util.*;
import java.io.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr_str = br.readLine().split(" ");
		int n = stoi(arr_str[0]); // 수의 갯수 (arr배열의 크기)
		int m = stoi(arr_str[1]); // 수의 변경이 일어나는 횟수
		int k = stoi(arr_str[2]); // 구간의 합을 구하는 횟수
		long[] arr = new long[n];
		int h = (int)Math.ceil(Math.log(n) / Math.log(2));
		int tree_size = 1 << (h+1);
		long[] tree_arr = new long[tree_size];
		for(int i = 0; i < n; i++)
			arr[i] = stoi(br.readLine());
		init(tree_arr, arr, 1, 0, arr.length-1);
		/*update(tree_arr, 1, 2, 0, arr.length-1, 3);
		System.out.println(sum(tree_arr, 1, 0, arr.length - 1, 1,4));
		update(tree_arr, 1, 4, 0, arr.length-1, -3);
		System.out.println(sum(tree_arr, 1, 0, arr.length - 1, 2,4));*/
		for(int i = 0; i < m+k; i++) {
			arr_str = br.readLine().split(" ");
			int op = stoi(arr_str[0]); // 1 : b->c, 2 : sysout(b~c)
			int from = stoi(arr_str[1])-1; // arr_str Idx를 사용하므로 -1
			long to = stoi(arr_str[2])-1; // arr_str Idx를 사용하므로 -1
			if(op == 1) {
				//update 연산
				long diff = to-arr[from]+1;
				update(tree_arr,arr, 1, from, 0, arr.length-1, diff);
			}else {
				//sb.append 연산
				sb.append(sum(tree_arr, 1, 0, arr.length - 1, from,to) + "\n");
			}
		}
		
		
		System.out.println(sb.toString());
		br.close();	
	}
	public static long init(long[] tree_arr, long[] arr, int node, int l, int r) {
		if(l == r) return tree_arr[node] = arr[l];
		int mid = (l + r) >>> 1;
		return tree_arr[node] = init(tree_arr, arr, node*2, l, mid) + init(tree_arr, arr, node*2+1, mid+1, r);
	}
	public static void update(long[] tree_arr,long[] arr, int node,int idx, int l, int r, long diff) {
		if(idx < l || idx > r) return;

		tree_arr[node] += diff;
		if(l == r) {
			arr[l] += diff;
		}else {
			int mid = (l+r) >>> 1;
			update(tree_arr,arr, node*2, idx, l, mid, diff);
			update(tree_arr,arr, node*2 + 1, idx, mid+1, r, diff);		
		}
	}
	public static long sum(long[] tree_arr,int node, long s, long e, long l, long r) {
		//l, r : 구하고자 하는 범위
		//s, e : 검사하는 범위, 즉 초기값은 max가 돼야함
		if(r < s || l > e) return 0;
		if(l <= s && e <= r) return tree_arr[node];
		long mid = (s+e) >>> 1;
		return sum(tree_arr, node*2, s, mid, l, r) + sum(tree_arr, node*2+1, mid+1,e,l,r);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
