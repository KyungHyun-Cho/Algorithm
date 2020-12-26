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
		int[][] dist = new int[V+1][V+1]; // dist[i][j] : i���� �����Ͽ� j�� ���� �ִܰ��
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
			//i��° ��带 �湮�� ��
			for(int j = 1; j <= V; j++) {
				//j������ �����Ͽ�
				//dist[j][j] = 0; // �������� �������� ���� ��� 0��ŭ�� ���
				for(int k = 1; k <= V; k++) {
					//k������ �� �� �ִ� ��� ���
					dist[j][k] = Math.min(dist[j][i] + dist[i][k], dist[j][k]);
				}
				/*for(Node node : map[j]) {
					//j������ �����Ͽ� �� �� �ִ� ��� ���
					int to = node.to; // ������
					int cost = node.cost; // �������� ���� ���� ���
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
