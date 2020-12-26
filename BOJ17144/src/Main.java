import java.util.*;
class vNode{
	int x, y;
	vNode(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int x, y, t;
	static int[][] map;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static ArrayList<vNode> v = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		t = sc.nextInt();
		map = new int[x][y];
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1)
					v.add(new vNode(i, j));
			}
		}
		for(int i = 0; i < t; i++) {
			Spread();
			Circulate();
		}

		System.out.println(getMCnt());
	}
	public static int getMCnt() {
		int sum = 0;
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				if(map[i][j] != -1)
					sum += map[i][j];
			}
		}
		return sum;
	}
	public static void Spread() {
		int[][] tmp = new int[x][y];
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				if(!(map[i][j] == -1 || map[i][j] == 0)) {
					//청소기거나, 먼지가 없는 경우가 아니라면
					int spread_cnt = 0;
					int mCnt = map[i][j] / 5; // 먼지 갯수는 /5한 결과
					for(int k = 0; k < 4; k++) {
						int new_x = i + dir[k][0];
						int new_y = j + dir[k][1];
						if(new_x >= 0 && new_y >= 0 && new_x < x && new_y < y) {
							//범위 안에 있으면서
							if(map[new_x][new_y] != -1) {
								//청소기가 아니라면
								spread_cnt++; // 청소된 구역 1 증가
								tmp[new_x][new_y] += mCnt; 
							}
						}
					}
					tmp[i][j] = tmp[i][j] + map[i][j] - (mCnt*spread_cnt);
				}
			}
		}
		copyArr(tmp, map);
		map[v.get(0).x][0] = -1;
		map[v.get(1).x][0] = -1;
		
	}
	
	
	public static void Circulate() {
		vNode v1 = v.get(0);
		vNode v2 = v.get(1);
		
		//위쪽 순환
		for(int i = v1.x-1 ; i > 0; i--)
			map[i][0] = map[i-1][0];
		for(int i = 0; i < y-1; i++)
			map[0][i] = map[0][i+1];
		for(int i = 0; i < v1.x; i++)
			map[i][y-1] = map[i+1][y-1];
		for(int i = y-1; i > 1; i--)
			map[v1.x][i] = map[v1.x][i-1];
		map[v1.x][v1.y+1] = 0;
		//아래쪽 순환
		for(int i = v2.x + 1; i < x-1; i++)
			map[i][0] = map[i+1][0];
		for(int i = 0; i < y-1; i++)
			map[x-1][i] = map[x-1][i+1];
		for(int i = x-1; i > v2.x; i--)
			map[i][y-1] = map[i-1][y-1];
		for(int i = y-1; i > 1; i--)
			map[v2.x][i] = map[v2.x][i-1];
		map[v2.x][v2.y+1] = 0;

	}
	public static void copyArr(int[][] src, int[][] dest) {
		for(int i = 0; i < x; i++)
			for(int j = 0; j < y; j++)
				dest[i][j] = src[i][j];		
	}
	
}
