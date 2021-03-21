import java.util.*;
import java.io.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\jkh96\\Documents\\input.txt")));
		while(true) {
			String[] arr_str = br.readLine().split(" ");
			int n = stoi(arr_str[0]);
			if(n == 0) break;
			int h = (int)Math.ceil(Math.log(n) / Math.log(2));
			int tree_size = 1 << (h+1);
			long[] tree_arr = new long[tree_size];
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = stoi(arr_str[i+1]);
			init(tree_arr, arr, 1, 0, arr.length-1);
			System.out.println("BP");
			//System.out.println(getMax(arr, 0, n-1, false)[0]);
		}
		br.close();
		
	}
	public static long init(long[] tree_arr, int[] arr, int node, int l, int r) {
		if(l == r) return tree_arr[node] = arr[l];
		int mid = (l+r) >>> 1;
		return tree_arr[node] = init(tree_arr, arr, node*2, l, mid) + init(tree_arr, arr, node*2+1, mid+1, r);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
