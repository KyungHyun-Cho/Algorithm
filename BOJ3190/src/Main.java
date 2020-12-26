import java.lang.*;
import java.util.*;
import java.io.*;
class Node{
	int x, y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int dir_idx = 3;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Node> q = new LinkedList<>();
		q.addFirst(new Node(1,1));
		int n = sc.nextInt();		
		int apple_cnt = sc.nextInt();
		int[][] map = new int[n+1][n+1];
		map[1][1] = 1;
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		char[] dir_info = new char[10001];
		for(int i = 0; i < apple_cnt; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 9; // ����� �ʿ� 9�� ǥ��
		}
		
		int dir_cnt = sc.nextInt();
		for(int i = 0; i < dir_cnt; i++) {
			int time = sc.nextInt();
			char tmp_dir = sc.next().charAt(0);
			dir_info[time] = tmp_dir;
		}
		for(int time = 1; ; time++) {
			Node node = q.peekLast();
			int new_x = node.x + dir[dir_idx][0];
			int new_y = node.y + dir[dir_idx][1];
			if(new_x < 1 || new_y < 1 || new_x > n || new_y > n) {
				//�� ������ �Ѿ�� ���
				System.out.println(time);
				break;
			}else if(map[new_x][new_y] == 1) {
				//�ڽ��� ����� �΋H�� ���
				System.out.println(time);
				break;
			}else if(map[new_x][new_y] == 9) {
				//����� ���� ���
				map[new_x][new_y] = 1;
				q.addLast(new Node(new_x, new_y));
			}else {
				//�Ϲ� �������� �Ѿ ���
				map[new_x][new_y] = 1; // ������ ������ ���ؼ� �߰� ǥ��
				q.addLast(new Node(new_x, new_y));
				Node node2 = q.pollFirst(); // �����κ� ����
				map[node2.x][node2.y] = 0; // �����κ� ����
			}
			if(dir_info[time] == 'D' || dir_info[time] == 'L') {
				//ȸ���� �ؾ� �ϴ� �����
				changeDir(dir_info[time]);
			}
			
		}
	}
	public static void changeDir(char dir) {
		if(dir == 'D') {
			//�������� 90�� ȸ��
			if(dir_idx == 0) {
				dir_idx = 3;
			}else if(dir_idx == 1) {
				dir_idx = 2;				
			}else if(dir_idx == 2) {
				dir_idx = 0;			
			}else if(dir_idx == 3) {
				dir_idx = 1;				
			}
		}else {
			//�������� 90�� ȸ��
			if(dir_idx == 0) {
				dir_idx = 2;
			}else if(dir_idx == 1) {
				dir_idx = 3;				
			}else if(dir_idx == 2) {
				dir_idx = 1;			
			}else if(dir_idx == 3) {
				dir_idx = 0;				
			}
		}
	}
}
