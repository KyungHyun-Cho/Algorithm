import java.util.*;
import java.lang.*;
import java.io.*;
class Node{
	int to, cost;
	Node(int t, int c){
		to = t;
		cost = c;
	}
}
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int INF = 798000000;
		String[] str_arr;
		str_arr = br.readLine().split(" ");
		int V = stoi(str_arr[0]);
		int E = stoi(str_arr[1]);
		//ArrayList<Node>[] map = new ArrayList[V+1];
		int[][] dist = new int[V+1][V+1]; // dist[i][j] : i에서 시작하여 j로 가는 최단경로
		for(int[] item : dist)
			Arrays.fill(item, INF);
		/*for(int i = 0; i <= V; i++)
			map[i] = new ArrayList<Node>();*/
		
		for(int i = 0; i < E; i++) {
			str_arr = br.readLine().split(" ");
			int from = stoi(str_arr[0]);
			int to = stoi(str_arr[1]);
			int cost = stoi(str_arr[2]);
			//dist[from][to] = cost;
			dist[from][to] = Math.min(cost,dist[from][to]);
			//map[from].add(new Node(to, cost));
		}
		
		for(int i = 1; i <= V; i++) {
			//i번째 노드를 방문할 때
			for(int j = 1; j <= V; j++) {
				//j번에서 시작하여
				//dist[j][j] = 0; // 시작점과 도착점이 같은 경우 0만큼의 비용
				for(int k = 1; k <= V; k++) {
					//k번까지 갈 수 있는 모든 경로
					dist[j][k] = Math.min(dist[j][i] + dist[i][k], dist[j][k]);
				}
				/*for(Node node : map[j]) {
					//j번에서 시작하여 갈 수 있는 모든 경로
					int to = node.to; // 목적지
					int cost = node.cost; // 목적지로 가기 위한 비용
				}*/
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= V; i++) {
			for(int j = 1; j <= V; j++) {
				if(i == j && dist[i][j] != INF)
					min = Math.min(min, dist[i][j]);
			}
		}
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
		br.close();
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	
}
