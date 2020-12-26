import java.util.*;
public class Main {
	public static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] graph = new int[n+1][n+1];
		boolean[] visit = new boolean[n+1];
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;			
		}
		DFS(graph, visit, 1);
		System.out.println(cnt);
	}
	public static void DFS(int[][] graph, boolean[] visit, int findIdx) {
		visit[findIdx] = true;
		for(int i = 0; i < graph.length; i++) {
			if(graph[findIdx][i] == 1 && !visit[i]) {
				cnt++;
				DFS(graph,visit,i);
			}
		}
	}
}
