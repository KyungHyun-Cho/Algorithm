import java.util.*;
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class MapInfo{
	int sharkNo, smell;
	MapInfo(int sharkNo, int smell){
		this.sharkNo = sharkNo;
		this.smell = smell;
	}
}

class SharkInfo{
	int x, y, dir;
	SharkInfo(int x, int y, int dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	SharkInfo(int x, int y){
		this.x = x;
		this.y = y;
		this.dir = -1;
	}
	SharkInfo(int dir){
		this.x = -1;
		this.y = -1;
		this.dir = dir;
	}
}

public class Main {
	static int n, m, k;
	static MapInfo[][] map;
	static int[][][] priority;
	static HashMap<Integer, SharkInfo> sharkInfo = new HashMap<>();
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // �� ũ�� (n*n)
		m = sc.nextInt(); // ��� ��
		k = sc.nextInt(); // k�� �� ������ �����
		map = new MapInfo[n][n];
		priority = new int[m+1][4][4];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int sharkNo = sc.nextInt();
				if(sharkNo == 0)
					map[i][j] = new MapInfo(sharkNo, 0);
				else {
					map[i][j] = new MapInfo(sharkNo, k);
					sharkInfo.put(sharkNo, new SharkInfo(i, j));
				}
			}
		}
		for(int i = 1; i <= m; i++)
			sharkInfo.get(i).dir = sc.nextInt()-1;
		
		for(int i = 1; i <= m; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					priority[i][j][k] = sc.nextInt()-1;
				}
			}
		}
		//��� �̵�
		//����--
		/*
		 * �� �������� ��� ó��? �ʿ����� ����� �� ����
		 * �Ź� for������ ������ ã������ �ð��� �ʹ� �����ɸ���
		 * hashmap?
		 * */
		for(int i = 1; i <= 1000; i++) {
			sharkMove();
			setSmell();
			outSmell();
			if(sharkInfo.size() == 1) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
	public static void sharkMove() {
		//������ ����� Reverse�� ����
		ArrayList<Integer> sharkList = new ArrayList<Integer>(sharkInfo.keySet());
		Collections.sort(sharkList, Collections.reverseOrder());
		
		//���� �̵������� Point�� ã��
		for(int sharkNo : sharkList) {
			int x = sharkInfo.get(sharkNo).x;
			int y = sharkInfo.get(sharkNo).y;
			int sharkDir = sharkInfo.get(sharkNo).dir;
			int nextX = -1, nextY = -1, nextDir = -1;
			ArrayList<Point> available_list = new ArrayList<>();
			
			//���� ���� �������� �� �� �ִ� �� Ȯ��
			for(int i = 0; i < 4; i++) {
				int new_x = x + dir[priority[sharkNo][sharkDir][i]][0];
				int new_y = y + dir[priority[sharkNo][sharkDir][i]][1];
				if(new_x >= 0 && new_y >= 0 && new_x < n && new_y < n) {
					if(map[new_x][new_y].smell == 0) {
						nextX = new_x;
						nextY = new_y;
						nextDir = priority[sharkNo][sharkDir][i];
						break;
					}
				}
			}
			
			//�� �������� �� ���� ���, �ڽ��� ������ �� �� �ִ� �� Ȯ��
			if(nextX == -1) {
				for(int i = 0; i < 4; i++) {
					int new_x = x + dir[priority[sharkNo][sharkDir][i]][0];
					int new_y = y + dir[priority[sharkNo][sharkDir][i]][1];
					if(new_x >= 0 && new_y >= 0 && new_x < n && new_y < n) {
						if(map[new_x][new_y].sharkNo == sharkNo) {
							nextX = new_x;
							nextY = new_y;
							nextDir = priority[sharkNo][sharkDir][i];
							break;
						}
					}
				}
			}

			//�̹� �װ��� ��ġ�� �� �ִٸ�, �ش� ��ġ�� �� hashmap���� ����
			if(map[nextX][nextY].sharkNo != 0 && map[nextX][nextY].sharkNo != sharkNo)
				sharkInfo.remove(map[nextX][nextY].sharkNo);
			
			map[nextX][nextY].sharkNo = sharkNo;

			sharkInfo.get(sharkNo).x = nextX;
			sharkInfo.get(sharkNo).y = nextY;
			sharkInfo.get(sharkNo).dir = nextDir;
		}
	}
	public static void setSmell() {
		for(int key : sharkInfo.keySet())
			map[sharkInfo.get(key).x][sharkInfo.get(key).y].smell = k;
	}	
	public static void outSmell() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j].smell > 0) {
					int sharkNo = map[i][j].sharkNo;
					if(!sharkInfo.containsKey(sharkNo)) {
						//�� �̹� ������ ���ٸ�...
						map[i][j].smell--;
					}else {
						int x = sharkInfo.get(sharkNo).x;
						int y = sharkInfo.get(sharkNo).y;					
						if(!(x == i && y == j)) {
							//���� ��ġ�� �� ��ġ�� ���� �ƴ϶��
							map[i][j].smell--;
						}
					}
					//������ �� �����ٸ� ��� ��ȣ�� �ʱ�ȭ
					if(map[i][j].smell == 0) map[i][j].sharkNo = 0;
				}
				
			}
		}
	}
}
