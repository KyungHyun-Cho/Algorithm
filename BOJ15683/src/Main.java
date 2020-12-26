import java.util.*;
class CCTV{
	int x, y, type;
	CCTV(int x, int y, int type){
		this.x = x;
		this.y = y;
		this.type = type;
	}
}
public class Main {
	static int n, m;
	static int[][] map;
	static ArrayList<CCTV> cctv_list = new ArrayList<>();
	static int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // RULD
	static int[][] cctv_info = {
			{1,0,0,0,4},
			{1,0,1,0,2},
			{1,1,0,0,4},
			{1,1,1,0,4},
			{1,1,1,1,1}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] >= 1 && map[i][j] <= 5) {
					cctv_list.add(new CCTV(i, j, map[i][j]));
				}
			}
		}	
		
		System.out.println(solve(0));
	}
	public static int solve(int idx) {
		int ret = 978654321;
		if(idx == cctv_list.size()) {
			int sum = 0;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					if(map[i][j]==0) sum++;
			return sum;
		}
		CCTV cctv = cctv_list.get(idx);
		int[][] temp_map = new int[n][m];
		for(int i = 0; i < cctv_info[cctv.type-1][4]; i++) {
			//모든 방향을 검사할 것
			copyArr(map, temp_map);
			for(int j = 0; j < 4; j++) {
				if(cctv_info[cctv.type-1][j] == 1)
					watch(cctv.x, cctv.y, (i+j)%4);
			}
			ret = Math.min(ret, solve(idx+1));
			copyArr(temp_map, map);
		}
		return ret;
	}
	public static void watch(int x, int y, int cctvDir) {
		while(true) {
			int new_x = x + dir[cctvDir][0];
			int new_y = y + dir[cctvDir][1];
			if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) return;
			if(map[new_x][new_y] == 6) return;
			map[new_x][new_y] = 7;
			x = new_x;
			y = new_y;
		}
	}
	public static void copyArr(int[][] src, int[][] dest) {
		for(int i = 0; i < src.length; i++)
			for(int j = 0; j < src[0].length; j++)
				dest[i][j] = src[i][j];
	}
}
