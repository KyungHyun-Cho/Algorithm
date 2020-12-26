import java.util.*;
public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int n, m;
	static int cnt = 0;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			String n = sc.next();
			for(int j = 0; j < n.length(); j++) {
				map[i][j] = n.charAt(j)-'0';
			}
		}
		BFS(0,0);
		System.out.println(cnt);
	}
	public static void BFS(int p, int q) {
		visit[p][q] = true;
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> qc = new LinkedList<Integer>();
		qx.add(p); qy.add(q); qc.add(1);
		while(!qy.isEmpty()) {
			int cx = qx.poll();
			int cy = qy.poll();
			int cc = qc.poll();
			if(cx == n-1 && cy == m-1){
				cnt = cc;
				break;
			}
			for(int i = 0; i < dir.length; i++) {
				int newp = cx + dir[i][0];
				int newq = cy + dir[i][1];
				if(newp >= 0 && newp < n && newq >= 0 && newq < m && map[newp][newq] == 1 && !visit[newp][newq]) {
					visit[newp][newq] = true;
					qx.add(newp); qy.add(newq); qc.add(cc+1);
				}
			}
			
		}
		
	}
}
