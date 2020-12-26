import java.util.*;
import java.io.*;
import java.lang.*;
class Node{
	int v, d;
	Node(int v, int d){
		this.v = v;
		this.d = d;
	}
}
public class Main {
	static boolean[] visit;
	static ArrayList<Node>[] map;
	//static ArrayList<Integer> startIdx = new ArrayList<Integer>();
	static int lastIdx = 0;
	static int ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		
		map = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) 
			map[i] = new ArrayList<Node>();
		
		for(int i = 0; i < n; i++) {
			String[] str_arr = br.readLine().split(" ");
			int v = stoi(str_arr[0]);
			//if(str_arr.length == 4) startIdx.add(v);
			int tmp_v = 0;
			int tmp_d = 0;
			for(int j = 1; j < str_arr.length; j++) {
				if(j % 2 == 1) {
					//홀수번, 간선번호임
					tmp_v = stoi(str_arr[j]);
					if(tmp_v == -1) break;
				}else if(j % 2 == 0) {
					tmp_d = stoi(str_arr[j]);
					map[v].add(new Node(tmp_v, tmp_d));
				}
			}
		}
		visit = new boolean[n+1];
		DFS(1,0);
		visit = new boolean[n+1];
		DFS(lastIdx,0);
		System.out.println(ans);
	}
	public static void DFS(int start, int d) {
		if(d > ans) {
			ans = d;
			lastIdx = start;
		}
		visit[start] = true;
		for(Node node : map[start]) {
			if(!visit[node.v]) {
				DFS(node.v, node.d + d);
				//sum += Math.max(DFS(node.v));
			}
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
