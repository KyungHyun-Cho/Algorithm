import java.util.*;
import java.lang.*;
import java.io.*;

class Pair implements Comparable<Pair>{
	int v, d;
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
	static int[] dist;
	static ArrayList<Pair>[] map;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_arr = br.readLine().split(" ");
		V = stoi(str_arr[0]);
		E = stoi(str_arr[1]);
		map = new ArrayList[V+1];
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i = 0; i <= V; i++)
			map[i] = new ArrayList<Pair>(); // 인접리스트 초기화
		
		int K = stoi(br.readLine());
		for(int i = 0; i < E; i++) {
			str_arr = br.readLine().split(" ");
			map[stoi(str_arr[0])].add(new Pair(stoi(str_arr[1]), stoi(str_arr[2])));
		}
		BFS(K);
		bw.flush();
		br.close();
		bw.close();
	}
	public static void BFS(int start) throws IOException{
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Pair(start,0));
		while(!pq.isEmpty()) {
			int now_v = pq.peek().v; // 노드
			pq.poll();
			for(Pair node : map[now_v]) {
				if(dist[node.v] > dist[now_v] + node.d) {
					dist[node.v] = dist[now_v] + node.d;
					pq.add(new Pair(node.v, dist[node.v]));
					
				}
			}
		}
		for(int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE)
				bw.write("INF\n");
			else
				bw.write(dist[i] + "\n");
			
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
