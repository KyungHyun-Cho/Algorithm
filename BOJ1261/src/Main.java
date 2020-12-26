import java.util.*;
class Node implements Comparable<Node>{
	int x, y, cost, break_cnt;
	Node(int x, int y, int cost, int break_cnt){
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.break_cnt = break_cnt;
	}
	public int compareTo(Node o) {
		if(break_cnt == o.break_cnt)
			return cost - o.cost;
		else
			return break_cnt - o.break_cnt;
	}
}
public class Main {
	static int m, n;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[n+1][m+1];
		visit = new boolean[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			String str = sc.next();
			for(int j = 1; j <= str.length(); j++) {
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		if(m == 1 && n == 1)
			System.out.println(0);
		else
			BFS();
	}
	public static void BFS() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(1,1,0,0));
		visit[1][1] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int now_x = node.x;
			int now_y = node.y;
			int now_cost = node.cost;
			int now_break_cnt = node.break_cnt;
			for(int i = 0; i < 4; i++) {
				int new_x = now_x + dir[i][0];
				int new_y = now_y + dir[i][1];
				if(new_x > 0 && new_y > 0 && new_x <= n && new_y <= m) {
					//갈 수 있는 곳이면
					if(new_x == n && new_y == m) {
						//마지막 점에 도달했다면 현재까지 부순 벽의 갯수 출력하고 종료
						System.out.println(now_break_cnt);
						return;
					}
					if(!visit[new_x][new_y]) {
						//방문하지 않은 곳이면
						visit[new_x][new_y] = true;

						if(map[new_x][new_y] == 1) {
							q.add(new Node(new_x, new_y, 1, now_break_cnt+1));
						}else {
							q.add(new Node(new_x, new_y, 0, now_break_cnt));
						}
					}
				}
			}
		}
	}
}
