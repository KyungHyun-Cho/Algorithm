import java.util.*;
class Point {
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n, m; // �ٸ� �Լ����� �����ϱ� ���� ���������� ����
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // �� �� �� ��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int answer = 0;
		int[][] map = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				map[i][j] = sc.nextInt();
		
		while(true) {
			int massCnt = getMassCnt(map);
			if(massCnt >= 2) {
				System.out.println(answer);
				return;
			}else if(massCnt == 0) {
				System.out.println(0);
			}
			melt(map);
			answer++;
		}
	}
	public static void melt(int[][] map) {
		//�ٴ� ��ġ�� ������ش�.
		ArrayList<Point> waterList = new ArrayList<>();
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(map[i][j] == 0) waterList.add(new Point(i, j));
		
		for(Point p : waterList) {
			int now_x = p.x;
			int now_y = p.y;
			for(int i = 0; i < 4; i++) {
				//������������ ������ dir�� �̿��� �����¿� �̵� �õ�!
				int new_x = now_x + dir[i][0];
				int new_y = now_y + dir[i][1];
				
				//���� ���� �̵��� ��ǥ�� ���� �����, ���� �������� continue!
				//���� ���� �̵��� ��ǥ�� ������ �ƴ� �ٴ幰�̶��, �н�!
				if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= m) continue;
				if(map[new_x][new_y] == 0) continue;

				//������ 1�� ���δ�!
				map[new_x][new_y]--;
			}
		}
	}
	public static int getMassCnt(int[][] map) {
		boolean[][] visit = new boolean[n][m];
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				//�� ��ü�� ��ȸ�ϸ鼭!
				if(!visit[i][j] && map[i][j] != 0) {
					//�湮�� ���� ����, �����̶�� (�ٴ幰�� �ƴ϶��) ����� ������ 1 �����ϰ� BFS ����!
					cnt++;
					Queue<Point> q = new LinkedList<>();
					q.add(new Point(i, j));
					visit[i][j] = true; // �ش� ��ǥ�� �湮ó���Ѵ�!
					while(!q.isEmpty()) {
						Point p = q.poll();
						int now_x = p.x;
						int now_y = p.y;
						for(int k = 0; k < 4; k++) {
							//������������ ������ dir�� �̿��� �����¿� �̵� �õ�!
							int new_x = now_x + dir[k][0];
							int new_y = now_y + dir[k][1];
							
							//���� ���� �̵��� ��ǥ�� ���� �����, ���� �������� continue!
							//���� ���� �̵��� ��ǥ�� ������ �ƴ� �ٴ幰�̶��, �н�!
							//���� �̵��� ��ǥ�� �̹� �湮�� ���̶��, �н�!
							if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= m) continue;
							if(map[new_x][new_y] == 0) continue;
							if(visit[new_x][new_y]) continue;
							
							//���� �̵��� ��ǥ�� �� �ȿ� �ִٸ�, ť�� �־��ְ� �湮ó��!
							q.add(new Point(new_x, new_y));
							visit[new_x][new_y] = true;
						}
					}
				}
			}
		}
		return cnt;
	}
}
