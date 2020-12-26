import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] map;
	static int n;
	static boolean[] visit;
	static int[] pa_arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str_arr;
		n = stoi(br.readLine());
		map = new ArrayList[n+1];
		visit = new boolean[n+1];
		pa_arr = new int[n+1];
		for(int i = 0; i <= n; i++)
			map[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < n-1; i++) {
			str_arr = br.readLine().split(" ");
			int t1 = stoi(str_arr[0]);
			int t2 = stoi(str_arr[1]);
			map[t1].add(t2);
			map[t2].add(t1);
		}
		DFS(1);
		for(int i = 2; i <= n; i++)
			sb.append(pa_arr[i]+"\n");
		System.out.println(sb.toString());
		br.close();
	}
	public static void DFS(int start) {
		visit[start] = true;
		for(int i : map[start]) {
			if(!visit[i]) {
				pa_arr[i] = start;
				DFS(i);
			}
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
