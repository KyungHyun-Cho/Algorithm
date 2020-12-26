import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
	int from, to, cost;
	Node(int f, int t, int c){
		from = f;
		to = t;
		cost = c;
	}
}
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_arr;
		str_arr = br.readLine().split(" ");
		int V = stoi(str_arr[0]);
		long[] dist = new long[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		int E = stoi(str_arr[1]);
		Node[] node = new Node[E];
		for(int i = 0; i < E; i++) {
			str_arr = br.readLine().split(" ");
			int from = stoi(str_arr[0]);
			int to = stoi(str_arr[1]);
			int cost = stoi(str_arr[2]);
			node[i] = new Node(from,to,cost);
		}
		
		boolean isCycle = false;
		dist[1] = 0;
		for(int i = 1; i <= V; i++) {
			for(int j = 0; j < E; j++) {
				if(dist[node[j].from] != Integer.MAX_VALUE) {
					if(dist[node[j].to] > dist[node[j].from] + node[j].cost) {
						dist[node[j].to] = dist[node[j].from] + node[j].cost;
						if(i == V) {
							isCycle = true;
							break;
						}
					}
				}
			}
		}
		
		if(isCycle) {
			System.out.println(-1);
		}else {
			for(int i = 2; i <= V; i++) {
				if(dist[i] == Integer.MAX_VALUE) {
					System.out.println(-1);
				}else {
					System.out.println(dist[i]);
				}
			}
		}
		br.close();
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
