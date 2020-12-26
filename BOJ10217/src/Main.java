import java.util.*;
import java.io.*;
import java.lang.*;

class Node implements Comparable<Node>{
	int to, cost, time;
	Node(int to,int cost, int time){
		this.to = to;
		this.cost = cost;
		this.time = time;
	}
	public int compareTo(Node o) {
		if(this.time == o.time) return this.cost - o.cost; 
		return this.time - o.time;
	}
}
public class Main {
	static int V;
	static final int INF = 100*99*1000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str_arr;
		int T = stoi(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			str_arr = br.readLine().split(" ");
			V = stoi(str_arr[0]);
			
			//int[][][] map = new int[V+1][V+1][2];
			ArrayList<Node>[] map = new ArrayList[V+1];

			for(int i = 0; i <= V; i++)
				map[i] = new ArrayList<Node>();
			
			int max_cost = stoi(str_arr[1]);
			int E = stoi(str_arr[2]);
			int[][] dp = new int[V+1][max_cost+1]; // dp[i][j] : i번 노드까지 j비용으로 갔을 때 최소 시간
			for(int[] item : dp)
				Arrays.fill(item, INF);
			dp[1][0] = 0;
			for(int i = 0; i < E; i++) {
				str_arr = br.readLine().split(" ");
				int from = stoi(str_arr[0]);
				int to = stoi(str_arr[1]);
				int cost = stoi(str_arr[2]);
				int time = stoi(str_arr[3]);
//				map[from][to][0] = cost;
//				map[from][to][1] = time;
				
				map[from].add(new Node(to,cost,time));
			}
			BFS(map, dp, max_cost);
			int min=INF;
			for(int i = 0; i <= max_cost; i++) {
				min = Math.min(min, dp[V][i]);
			}
			if(min == INF)
				System.out.println("Poor KCM");
			else
				System.out.println(min);
		}		
		br.close();
	}
	public static void BFS(ArrayList<Node>[] map, int[][] dp, int max_cost) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(1,0,0));
		while(!pq.isEmpty()) {
			Node pNode = pq.poll();
			int from = pNode.to;
			int cost = pNode.cost;
			int time = pNode.time;
			if(dp[from][cost] < time) continue;
			for(Node node : map[from]) {
				int sum_time = time + node.time;
				int sum_cost = cost + node.cost;
				if(max_cost >= sum_cost && dp[node.to][sum_cost] > sum_time) {
					for(int j = sum_cost; j <= max_cost; j++)
						if(dp[node.to][j] > sum_time) dp[node.to][j] = sum_time;
//					dp[i][sum_cost] = sum_time;
					pq.add(new Node(node.to, sum_cost, sum_time));
				}
			}
//			for(int i = 1; i <= V; i++) {
//				if(map[from][i][1] != 0) {
//					//갈 수 있는 곳이라면
//					int sum_time = time + map[from][i][1];
//					int sum_cost = cost + map[from][i][0];
//					if(max_cost >= sum_cost && dp[i][sum_cost] > sum_time) {
//						for(int j = sum_cost; j <= max_cost; j++)
//							if(dp[i][j] > sum_time) dp[i][j] = sum_time;
////						dp[i][sum_cost] = sum_time;
//						pq.add(new Node(i, sum_cost, sum_time));
//					}
//				}
//			}
		}
		//System.out.println("BP");
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
