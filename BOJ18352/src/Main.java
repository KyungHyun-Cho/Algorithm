import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Integer>[] map;
	static int[] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		final int INF = 987654321;
		int V = stoi(input[0]); // 정점
		int E = stoi(input[1]); // 간선
		int k = stoi(input[2]); // 구해야하는 최단거리
		int x = stoi(input[3]); // 시작점
		map = new ArrayList[V+1];
		dist = new int[V+1];
		for(int i = 0; i <= V; i++) {
			map[i] = new ArrayList<>();
			dist[i] = INF;
		}
		for(int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			int p = stoi(input[0]);
			int q = stoi(input[1]);
			map[p].add(q);
		}
		solve(x);
		boolean isAvailable = false;
		for(int i = 1; i <= V; i++) {
			if(dist[i] == k) {
				System.out.println(i);
				isAvailable = true;
			}
		}
		if(!isAvailable)
			System.out.println(-1);
	}
	public static void solve(int n) {
		Deque<Integer> dq = new LinkedList<>();
		dq.addLast(n);
		dist[n] = 0;
		while(!dq.isEmpty()) {
			int idx = dq.pollFirst();
			for(int i : map[idx]) {
				if(dist[i] > dist[idx] + 1) {
					dist[i] = dist[idx] + 1;
					dq.addLast(i);
				}
			}
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}	
}
