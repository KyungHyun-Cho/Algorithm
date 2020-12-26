import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		int[] arr = new int[n];
		int h = (int)Math.ceil(Math.log(n)/Math.log(2));
		int tree_size = 1 << (h+1);
		int[] min_tree_arr = new int[tree_size];
		int[] max_tree_arr = new int[tree_size];
		for(int i = 0; i < n; i++)
			arr[i] = stoi(br.readLine());
		init_min(min_tree_arr, arr, 1, 0, arr.length-1);
		init_max(max_tree_arr, arr, 1, 0, arr.length-1);		
		for(int i = 0; i < m; i++) {
			arr_str = br.readLine().split(" ");
			int from = stoi(arr_str[0]) - 1; // arr_str Idx를 사용하므로 -1
			int to = stoi(arr_str[1]) - 1;
			sb.append(get_min_value(min_tree_arr, 1, from, to, 0, arr.length-1) + " " + get_max_value(max_tree_arr, 1, from, to, 0, arr.length-1) + "\n");
		}
		
		
		System.out.println(sb.toString());
		br.close();	
	}
	public static int init_min(int[] tree_arr, int[] arr, int node, int l, int r) {
		if(l == r) return tree_arr[node] = arr[l];
		int mid = (l+r) >>> 1;
		return tree_arr[node] = Math.min(init_min(tree_arr, arr, node*2, l, mid), init_min(tree_arr, arr, node*2+1, mid+1, r));
	}
	public static int init_max(int[] tree_arr, int[] arr, int node, int l, int r) {
		if(l == r) return tree_arr[node] = arr[l];
		int mid = (l+r) >>> 1;
		return tree_arr[node] = Math.max(init_max(tree_arr, arr, node*2, l, mid), init_max(tree_arr, arr, node*2+1, mid+1, r));
	}
	public static int get_min_value(int[] tree_arr, int node, int l, int r, int s, int e) {
		//l,r : 내가 구하고자 하는 범위
		//s,e : 현재 검사하는 범위
		if(r < s || l > e) return Integer.MAX_VALUE;
		if(l <= s && e <= r) return tree_arr[node];
		int mid = (s+e) >>> 1;
		return Math.min(get_min_value(tree_arr, node*2, l, r, s, mid),get_min_value(tree_arr, node*2+1, l, r, mid+1, e));
	}
	public static int get_max_value(int[] tree_arr, int node, int l, int r, int s, int e) {
		//l,r : 내가 구하고자 하는 범위
		//s,e : 현재 검사하는 범위
		if(r < s || l > e) return Integer.MIN_VALUE;
		if(l <= s && e <= r) return tree_arr[node];
		int mid = (s+e) >>> 1;
		return Math.max(get_max_value(tree_arr, node*2, l, r, s, mid),get_max_value(tree_arr, node*2+1, l, r, mid+1, e));
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
