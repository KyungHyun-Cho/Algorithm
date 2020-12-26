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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int INF = 495000000;
		int V = stoi(br.readLine());
		int E = stoi(br.readLine());
		//ArrayList<Node>[] map = new ArrayList[V+1];
		int[][] dist = new int[V+1][V+1]; // dist[i][j] : i���� �����Ͽ� j�� ���� �ִܰ��
		for(int[] item : dist)
			Arrays.fill(item, INF);
		/*for(int i = 0; i <= V; i++)
			map[i] = new ArrayList<Node>();*/
		
		for(int i = 0; i < E; i++) {
			String[] str_arr = br.readLine().split(" ");
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
				dist[j][j] = 0; // �������� �������� ���� ��� 0��ŭ�� ���
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
		
		for(int i = 1; i <= V; i++) {
			for(int j = 1; j <= V; j++) {
				if(dist[i][j] == INF)
					System.out.print("0 ");
				else
					System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	
}
