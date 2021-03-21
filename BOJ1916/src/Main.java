import java.util.*;
import java.io.*;
class Info implements Comparable<Info>{
	int v, cost;
	Info(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
	public int compareTo(Info o) {
		return cost - o.cost;
	}
}
public class Main {
	public static int n, m;
	public static ArrayList<Info>[] map;
	public static int[] cost;
	public static final int INF = 987654321;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		m = stoi(br.readLine());
		map = new ArrayList[n];
		cost = new int[n];
		Arrays.fill(cost,  INF);
		for(int i = 0; i < n; i++)
			map[i] = new ArrayList<>();
		
		StringTokenizer st = null;
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int s = stoi(st.nextToken())-1;
			int e = stoi(st.nextToken())-1;
			int cost = stoi(st.nextToken());
			map[s].add(new Info(e, cost));
		}
		st = new StringTokenizer(br.readLine());
		int start = stoi(st.nextToken())-1;
		int end = stoi(st.nextToken())-1;
		BFS(start);
		System.out.println(cost[end]);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static void BFS(int start) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		cost[start] = 0;
		pq.add(new Info(start, 0));
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			int now_v = info.v;
			if(cost[now_v] < info.cost) continue;
			for(Info next : map[now_v]) {
				if(cost[next.v] > cost[now_v] + next.cost) {
					cost[next.v] = cost[now_v] + next.cost;
					pq.add(new Info(next.v, next.cost));
				}
			}
		}
	}
}
