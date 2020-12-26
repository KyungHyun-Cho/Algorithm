import java.util.*;
import java.io.*;
public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fLine = br.readLine();
		n = stoi(fLine.split(" ")[0]);
		m = stoi(fLine.split(" ")[1]);
		map = new int [n+1][m+1];
		visit = new boolean[n+1][m+1];
		
		for(int i = 1; i <= n; i++) {
			String str = br.readLine();			
			for(int j = 1; j <= m; j++)
				map[i][j] = str.charAt(j-1)-'0';
		}
		
		visit[1][1] = true;
		DFS(1, 1, 0, 1);
		
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	
	public static void DFS(int p, int q, int breakCnt, int moveCnt) {
		if(p == n && q == m) {
			if(moveCnt < min)
				min = moveCnt;	
		}else {
			for(int i = 0; i < 4; i++) {
				int newx = p + dir[i][0];
				int newy = q + dir[i][1];				
				if(newx > 0 && newy > 0 && newx <= n && newy <= m) {
					//��ȿ�� ����������� Ȯ��
					if(!visit[newx][newy]) {
						//�湮�� �� �� ��쿡�� �湮�ؾ߰���.
						if(map[newx][newy] == 1) {
							//���̶��
							if(breakCnt == 0) {
								//ó�� �μ��� ��츸 �μ�
								visit[newx][newy] = true;
								DFS(newx,newy,breakCnt+1,moveCnt+1); //���� 1ȸ �μ��� �ٽ� DFS
								visit[newx][newy] = false;
							}
						}else {
							//���� �ƴ϶��
							visit[newx][newy] = true;
							DFS(newx,newy,breakCnt,moveCnt+1); //���� �μ��� �ʰ� �ٽ� DFS
							visit[newx][newy] = false;
						}
					}
				}
			}
		}
	}
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
