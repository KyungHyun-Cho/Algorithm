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
	public static int n, m, x;
	public static ArrayList<Info>[] map, map_rev;
	public static int[] cost;
	public static int[] cost_rev;	
	public static final int INF = 987654321;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		x = stoi(st.nextToken())-1;
		
		map = new ArrayList[n];
		map_rev = new ArrayList[n];
		
		cost = new int[n];
		cost_rev = new int[n];
		Arrays.fill(cost, INF);
		Arrays.fill(cost_rev, INF);
		for(int i = 0; i < n; i++) {
			map[i] = new ArrayList<>();
			map_rev[i] = new ArrayList<>();
		}
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int s = stoi(st.nextToken())-1;
			int e = stoi(st.nextToken())-1;
			int cost = stoi(st.nextToken());
			map[s].add(new Info(e, cost));
			map_rev[e].add(new Info(s, cost));
			
		}
		BFS(map, cost, x);
		BFS(map_rev, cost_rev, x);
		
		int ans = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			ans = Math.max(ans, cost[i] + cost_rev[i]);
		}
		System.out.println(ans);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static void BFS(ArrayList<Info>[] map, int[] cost, int start) {
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
