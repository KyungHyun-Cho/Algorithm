import java.util.*;
class Node implements Comparable<Node>{
	int x, y, movCnt;
	Node(int x, int y, int movCnt){
		this.x = x;
		this.y = y;
		this.movCnt = movCnt;
	}
	public int compareTo(Node o) {
		if(x == o.x)
			return y - o.y;
		else
			return x - o.x;
	}
}
public class Main {
	static int n, now_x, now_y;
	static int[][] map;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n+1][n+1];

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {now_x = i; now_y = j;}
			}
		}
		System.out.println(BFS(now_x, now_y));
	}
	public static int BFS(int p, int q) {
		int shark_level = 2;
		int remain_exp = 2;
		int dist = 0;
		
		Deque<Node> dq = new LinkedList<>();
		PriorityQueue<Node> fish = new PriorityQueue<>();
		boolean[][] visit = new boolean[n+1][n+1];
		
		dq.addLast(new Node(p, q, 0));
		visit[p][q] = true;
		while(!dq.isEmpty()) {
			int qSize = dq.size();
			for(int t = 0; t < qSize; t++) {
				Node node = dq.pollFirst();
				int tmp_p = node.x;
				int tmp_q = node.y;
				int tmp_movCnt = node.movCnt;

				for(int i = 0; i < 4; i++) {
					int new_p = tmp_p + dir[i][0];
					int new_q = tmp_q + dir[i][1];
					
					if(new_p > 0 && new_p <= n && new_q > 0 && new_q <= n) {
						//벽 안에 있으면서
						if(!visit[new_p][new_q] && map[new_p][new_q] <= shark_level) {
							//방문을 안했으면서, 움직일 수 있는거리라면
							dq.addLast(new Node(new_p, new_q, tmp_movCnt+1));
							visit[new_p][new_q] = true;
							if(map[new_p][new_q] != 0 && map[new_p][new_q] < shark_level) {
								fish.add(new Node(new_p, new_q, tmp_movCnt+1));
							}
						}
					}
				}
			}
			if(!fish.isEmpty()) {
				Node meal = fish.poll();
				fish.clear();
				remain_exp--;
				if(remain_exp == 0) {shark_level++; remain_exp = shark_level;}

				map[p][q] = 0;
				p = meal.x; q = meal.y;
				map[p][q] = 9;
				

				dist += meal.movCnt;
				meal.movCnt = 0;
				dq.clear();
				dq.add(meal);
				
				for(boolean[] tmp_visit:visit)
					Arrays.fill(tmp_visit, false);
				visit[p][q] = true;
				
			}
		}
		return dist;
	}
}
