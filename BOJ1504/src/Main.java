import java.util.*;
import java.lang.*;
import java.io.*;
class Pair implements Comparable<Pair>{
	public int v, d;
	Pair(int v, int d){
		this.v = v;
		this.d = d;
	}	
	public int compareTo(Pair o) {
		return d - o.d;
	}
}
public class Main {
	static int V, E;
	static ArrayList<Pair>[] map;
	static int[] dist1, dist2, dist3;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_arr = br.readLine().split(" ");
		V = stoi(str_arr[0]);
		E = stoi(str_arr[1]);
		map = new ArrayList[V+1];
		dist1 = new int[V+1];
		dist2 = new int[V+1];
		dist3 = new int[V+1];
		Arrays.fill(dist1, Integer.MAX_VALUE);
		Arrays.fill(dist2, Integer.MAX_VALUE);
		Arrays.fill(dist3, Integer.MAX_VALUE);
		for(int i = 0; i <= V; i++)
			map[i] = new ArrayList<Pair>();
		
		for(int i = 0; i < E; i++) {
			str_arr = br.readLine().split(" ");
			int t1 = stoi(str_arr[0]);
			int t2 = stoi(str_arr[1]);
			int t3 = stoi(str_arr[2]);			
			map[t1].add(new Pair(t2, t3));	
			map[t2].add(new Pair(t1, t3));
		}
		str_arr = br.readLine().split(" ");
		int e1 = stoi(str_arr[0]);
		int e2 = stoi(str_arr[1]);
		BFS(dist1, 1);
		BFS(dist2, e1);
		BFS(dist3, e2);
		
		int min = Math.min(dist1[e1] + dist2[e2] + dist3[V], dist1[e2] + dist3[e1] + dist2[V]);
		System.out.println(min > 200000000?-1:min);
		br.close();
	}
	public static void BFS(int[] dist, int start) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Pair(start, 0));
		while(!pq.isEmpty()) {
			int now_v = pq.poll().v;
			for(Pair node : map[now_v]) {
				if(dist[node.v] > dist[now_v] + node.d) {
					dist[node.v] = dist[now_v] + node.d;
					pq.add(new Pair(node.v, dist[node.v]));
				}
			}
		}
		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
