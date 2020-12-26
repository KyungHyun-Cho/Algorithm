import java.util.*;
import java.io.*;
public class Main {
	static int n, m;
	static ArrayList<Integer>[] map;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_arr;
		str_arr = br.readLine().split(" ");
		n = stoi(str_arr[0]);
		m = stoi(str_arr[1]);
		map = new ArrayList[n+1];
		visit = new boolean[n+1];
		for(int i = 0; i <= n; i++)
			map[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			str_arr = br.readLine().split(" ");
			int p = stoi(str_arr[0]);
			int q = stoi(str_arr[1]);
			
			map[p].add(q);
			map[q].add(p);
						
		}
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(!visit[i]) {
				cnt++;
				DFS(i);
				
			}
		}
		System.out.println(cnt);
	}
	public static void DFS(int p) {
		visit[p] = true;
		for(int i : map[p]) {
			if(!visit[i])
				DFS(i);
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
