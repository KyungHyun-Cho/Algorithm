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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = stoi(br.readLine());
		String[] str_arr;
		for(int tc = 0; tc < T; tc++) {
			str_arr = br.readLine().split(" ");
			int V = stoi(str_arr[0]); // ������ ����
			int[] dist1 = new int[V+1];
			int[] dist2 = new int[V+1];
			int[] dist3 = new int[V+1];
			Arrays.fill(dist1, Integer.MAX_VALUE);
			Arrays.fill(dist2, Integer.MAX_VALUE);
			Arrays.fill(dist3, Integer.MAX_VALUE);
			ArrayList<Pair>[] map = new ArrayList[V+1];
			for(int i = 0; i <= V; i++) 
				map[i] = new ArrayList<Pair>();			
			int E = stoi(str_arr[1]); // ���� ����
			int t = stoi(str_arr[2]); // ������ �ĺ� ����
			int[] �������ĺ� = new int[t];
			str_arr = br.readLine().split(" ");
			int s = stoi(str_arr[0]); // ���������� �����
			int g = stoi(str_arr[1]); // g�� h���� ���θ� ������
			int h = stoi(str_arr[2]); // g�� h���� ���θ� ������
			for(int i = 0; i < E; i++) {
				str_arr = br.readLine().split(" ");
				int t1 = stoi(str_arr[0]);
				int t2 = stoi(str_arr[1]);
				int t3 = stoi(str_arr[2]);
				map[t1].add(new Pair(t2, t3));
				map[t2].add(new Pair(t1, t3));
			}
			for(int i = 0; i < t; i++)
				�������ĺ�[i] = stoi(br.readLine());

			BFS(map, dist1, s);
			BFS(map, dist2, g);
			BFS(map, dist3, h);
			ArrayList<Integer> tmplist = new ArrayList<>();
			for(int i = 0; i < t; i++) {
				int min = Math.min(dist1[g] + dist2[h] + dist3[�������ĺ�[i]],dist1[h]+dist3[g]+dist2[�������ĺ�[i]]);
				if(min != Integer.MAX_VALUE && dist1[�������ĺ�[i]] != Integer.MAX_VALUE && min <= dist1[�������ĺ�[i]])
					tmplist.add(�������ĺ�[i]);
				/*for(int j = 0; j < t; j++) {
					
				}*/
			}
			Collections.sort(tmplist);
			for(int i = 0; i < tmplist.size(); i++) {
				bw.write(tmplist.get(i) + " ");
			}
			bw.write("\n");
			//int min = Math.min(dist1[g] + dist2[h] + dist3[�������ĺ���ΰ��°���],dist1[h]+dist3[g]+dist2[�������ĺ���ΰ��°���]);
		}
		bw.flush();
		br.close();
		bw.close();
	}
	public static void BFS(ArrayList<Pair>[] map, int[] dist, int start) {
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
