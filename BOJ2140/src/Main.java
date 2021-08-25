import java.io.*;
import java.util.*;
class Mine implements Comparable<Mine>{
	int cnt, x, y;
	Mine(int cnt, int x, int y){
		this.cnt = cnt;
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Mine o) {
		return o.cnt - this.cnt; // ��������
	}
	
}
public class Main {
	static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static int n;
	static final int AREA_UNKNOWN = -99, AREA_MINE = -9, AREA_NOT_MINE = 9;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		
		// ���� 3x3 ���� �۴ٸ�, ��δ� �����ִ� ����
		if(n < 3) {
			System.out.println(0);
			return;
		}
		PriorityQueue<Mine> pq = new PriorityQueue<>();		
		int[][] map = new int[n][n];
		
		
		// �Է��� �޴´�.
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			for(int j = 0; j < n; j++) {
				char c = line.charAt(j);
				// # (�����ִ� ����)�̸�
				if(c == '#') {
					// ������ ����
					if(i == 1 || j == 1 || i == n-2 || j == n-2)
						map[i][j] = AREA_UNKNOWN;
					// �� �� ���� ����. �������� �ִ� ���� ������ �䱸�ϹǷ�, ���� ���� ó��
					else 
						map[i][j] = AREA_MINE;
				}
				// �����ִ� �����̸�
				else {
					map[i][j] = c - '0'; // Map�� ä���ְ�
					// �� �𼭸��� �ƴ϶�� �켱���� ť�� ����
					if(!((i == 0 && j == 0) || (i == 0 && j == 0) || (i == 0 && j == 0) || (i == 0 && j == 0)))
						pq.add(new Mine(map[i][j], i, j));					
				}
			}
		}
		
		// �˰���
		// 1. �� �𼭸��� �밢�� ���⿡�� ������ ��ġ�Ƿ�, �� �𼭸� ���� ó��
		// 2. ��, �� �������� �׸����ϰ� ����
		
		// 1. �� �𼭸��� ���� ó��
		map[1][1] = map[0][0] == 1 ? AREA_MINE : AREA_NOT_MINE;
		map[1][n-2] = map[0][n-1] == 1 ? AREA_MINE : AREA_NOT_MINE;
		map[n-2][1] = map[n-1][0] == 1 ? AREA_MINE : AREA_NOT_MINE;
		map[n-2][n-2] = map[n-1][n-1] == 1 ? AREA_MINE : AREA_NOT_MINE;
		
		// 2. pq�� �������鼭
		for(int i = 1; i < n-1; i++)
			MakeMap(map, 0, i, map[0][i]);
		for(int i = 1; i < n-1; i++)
			MakeMap(map, i, n-1, map[i][n-1]);
		for(int i = 1; i < n-1; i++)
			MakeMap(map, i, 0, map[i][0]);
		for(int i = 1; i < n-1; i++)
			MakeMap(map, n-1, i, map[n-1][i]);
		
		System.out.println(GetAnswer(map));
	}
	static int GetAnswer(int[][] map) {
		int answer = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(map[i][j] == AREA_MINE) answer++;
		return answer;
	}
	static void MakeMap(int[][] map, int x, int y, int val) {
		int[][] dir = new int[3][2];
		int mineCnt = 0;
		if(x == 0) {
			dir[0][0] = 1; dir[0][1] = -1; dir[1][0] = 1; dir[1][1] = 0; dir[2][0] = 1; dir[2][1] = 1; 
		}else if(y == 0) {
			dir[0][0] = -1; dir[0][1] = 1; dir[1][0] = 0; dir[1][1] = 1; dir[2][0] = 1; dir[2][1] = 1; 
		}else if(x == n-1) {
			dir[0][0] = -1; dir[0][1] = -1; dir[1][0] = -1; dir[1][1] = 0; dir[2][0] = -1; dir[2][1] = 1; 
		}else if(y == n-1) {
			dir[0][0] = -1; dir[0][1] = -1; dir[1][0] = 0; dir[1][1] = -1; dir[2][0] = 1; dir[2][1] = -1; 
		}
		// ������ x, y ��ǥ�� ��� ������ ��ȸ�ϸ鼭
		for(int i = 0; i < 3; i++) {
			int new_x = x + dir[i][0]; // ���ο� x��ǥ
			int new_y = y + dir[i][1]; // ���ο� y��ǥ
			if(new_x == 0 || new_y == 0 || new_x == n-1 || new_y == n-1) continue;
			if(map[new_x][new_y] == AREA_MINE) mineCnt++;
			else if(map[new_x][new_y] == AREA_NOT_MINE) continue;
			else {
				if(val == mineCnt)
					map[new_x][new_y] = AREA_NOT_MINE;
				else{
					map[new_x][new_y] = AREA_MINE;
					mineCnt++;
				}
			}
		}
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}
