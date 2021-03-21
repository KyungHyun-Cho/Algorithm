import java.io.*;
import java.util.*;
class Point{
	int next, cnt;
	Point(int next, int cnt){
		this.next = next;
		this.cnt = cnt;		
	}
}
public class Main {
	public static ArrayList<Point>[] map;
	public static int[] dist;
	public static int a = 0, b = 0, n = 0, m = 0;
	public static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		a = stoi(input[0])-1;
		b = stoi(input[1])-1;
		input = br.readLine().split(" ");
		n = stoi(input[0]);
		m = stoi(input[1]);
		map = new ArrayList[n];
		dist = new int[n];
		Arrays.fill(dist,  INF);
		for(int i = 0; i < n; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int p = stoi(input[0])-1;
			int q = stoi(input[1])-1;

			map[p].add(new Point(q, 0));
			map[q].add(new Point(p, 0));
		}
		BFS(a);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static void BFS(int start) {
		boolean[] visit = new boolean[n];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(start, 0));
		visit[start] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int next = p.next;
			if(next == b) {
				System.out.println(p.cnt);
				return;
			}
			for(Point nextP : map[next]) {
				if(!visit[nextP.next]) {
					visit[nextP.next] = true;
					q.add(new Point(nextP.next, p.cnt+1));
				}
			}
		}
		System.out.println(-1);
	}
}
