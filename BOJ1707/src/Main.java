import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			String[] str_arr = br.readLine().split(" ");
			int V = stoi(str_arr[0]);
			int E = stoi(str_arr[1]);
			ArrayList<Integer>[] map = new ArrayList[V+1];
			int[] color = new int[V+1];
			for(int i = 0; i <= V; i++)
				map[i] = new ArrayList<Integer>();
			
			for(int i = 0; i < E; i++) {
				str_arr = br.readLine().split(" ");
				int t1 = stoi(str_arr[0]);
				int t2 = stoi(str_arr[1]);
				map[t1].add(t2);
				map[t2].add(t1);					
			}
			boolean ret = true;
			
			color[1] = 1;
			for(int i = 1; i <= V; i++) {
				for(int v : map[i]) {
					if(color[v] == 0) {
						ret = DFS(v, map, color, -1);
						if(!ret) break;
					}
				}
				if(!ret) break;
			}
			System.out.println(ret?"YES":"NO");
		}
	}
	public static boolean DFS(int v, ArrayList<Integer>[] map, int[] color, int nowColor) {
		color[v] = nowColor;
		boolean ret = true;
		for(int node: map[v]) {
			if(color[node] == 0)
				ret = DFS(node, map, color, nowColor*-1);
			else if(color[node] == nowColor)
				return false;
		}
		return ret;
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
