import java.util.*;
import java.io.*;
class Place{
	int x, y;
	int breakCnt;
	int moveCnt;
	public Place(int x, int y,int breakCnt, int moveCnt) {
		this.x = x;
		this.y = y;
		this.breakCnt = breakCnt;
		this.moveCnt = moveCnt;
	}
}
public class Main {
	static int n, m;
	static int[][] map;
	static int[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int min = Integer.MAX_VALUE;	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fLine = br.readLine();
		n = stoi(fLine.split(" ")[0]);
		m = stoi(fLine.split(" ")[1]);
		map = new int [n+1][m+1];
		visit = new int[n+1][m+1];
		
		for(int i = 1; i <= n; i++) {
			String str = br.readLine();			
			for(int j = 1; j <= m; j++) {
				map[i][j] = str.charAt(j-1)-'0';
				visit[i][j] = 2;
			}
		}
		min = Integer.MAX_VALUE;
		
		BFS(1,1);
		
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	public static void BFS(int x, int y) {
		Deque<Place> q = new LinkedList<Place>();
		q.add(new Place(x,y,0,1));
		visit[x][y] = 0;
		while(!q.isEmpty()) {
			Place p = q.pollFirst();
			if(p.x == n && p.y == m) {
				min = p.moveCnt;
				return;
			}else {
				for(int i = 0; i < 4; i++) {
					int newx = p.x + dir[i][0];
					int newy = p.y + dir[i][1];
					if(newx > 0 && newx <= n && newy > 0 && newy <= m) {
						//��ȿ�� ���� �˻�
						if(visit[newx][newy] > p.breakCnt) {
							//visit : 2 -> �̹湮�̹Ƿ� p�� ���� 0�� �ν��� 1�� �ν��� ������
							//visit : 1 -> �ѹ� �μ� ���̹Ƿ� p.bCnt == 0�� ��尡 �´ٸ�, �ּҰ�θ� ������ �� �����Ƿ� True�� ��ȯ�ϳ�
							//				p.bCnt == 1�� ��尡 �´ٸ�, ����? ���� �����µ� �ð�������
							//visit : 0 -> �̹� 0�� �μ��� �� �� �ִ� ���ε� ���� 1�� �μ��� �ǵ��ư� �ʿ䰡 ����?
							if(map[newx][newy] == 0) {
								//���� �ƴϸ�
								
								/*if(visit[newx][newy] == 1)
									System.out.println("�̷� ��쵵 �ִ��� ������� (Ʋ�Ƚ��ϴ� ��������?)");
									//������ ����ʰ��� ��µǴ� ���� Ȯ����!*/

								visit[newx][newy] = p.breakCnt;
								q.add(new Place(newx, newy, p.breakCnt, p.moveCnt+1));
							}else {
								//���̸�
								if(p.breakCnt == 0) {
									//�ѹ��� ���μ����� ���ٸ�
									visit[newx][newy] = p.breakCnt + 1; //���μ� ó��
									q.add(new Place(newx, newy, p.breakCnt + 1, p.moveCnt + 1));
								}
							}
						}
					}
				}
			}
		}
		System.out.println("����");
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
