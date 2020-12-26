import java.util.*;
public class Main {
	static int n;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //n이 20인경우 최대 경우의 수 : 10830개
		map = new int[n][n];
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int x = 0; x < n-2; x++) {
			//x는 0~n-3까지만 가능
			for(int y = 1; y < n-1; y++) {
				//y는 1~n-2까지만 가능
				for(int d1 = 1; d1 <= y && (x+d1) < n; d1++) {
					//d1 : x좌표를 xy에서 왼쪽으로 얼만큼 떨어뜨릴 수 있는지?
					for(int d2 = 1; d2 < n-y && x+d1+d2 < n; d2++) {
						//d2 : y좌표를 xy에서 오른쪽으로 얼만큼 떨어뜨릴 수 있는지?
						min = Math.min(min, solve(x,y,d1,d2));
					}
				}
			}
		}
		System.out.println(min);
	}
	public static int solve(int x, int y, int d1, int d2) {
		int[][] tmp_map = new int[n][n];
		//1채우기
		for(int i = 0; i < x+d1; i++) {
			for(int j = 0; j <= y; j++) {
				tmp_map[i][j] = 1;
			}
		}
		//2채우기
		for(int i = 0; i <= x+d2; i++) {
			for(int j = y+1; j < n; j++) {
				tmp_map[i][j] = 2;
			}
		}
		//3채우기
		for(int i = x+d1; i < n; i++) {
			for(int j = 0; j < y-d1+d2; j++) {
				tmp_map[i][j] = 3;
			}
		}
		//4채우기
		for(int i = x+d2+1; i < n; i++) {
			for(int j = y-d1+d2; j < n; j++) {
				tmp_map[i][j] = 4;
			}
		}
		//5경계선 그리기
		for(int i = x, j = y; i <= x+d1 && j >= y-d1; i++, j--) 
			tmp_map[i][j] = 5;
		for(int i = x, j = y; i <= x+d2 && j <= y+d2; i++, j++) 
			tmp_map[i][j] = 5;
		for(int i = x+d1, j = y-d1; i <= x+d1+d2 && j <= y-d1+d2; i++, j++) 
			tmp_map[i][j] = 5;
		for(int i = x+d2, j = y+d2; i <= x+d1+d2 && j >= y-d1+d2; i++, j--) 
			tmp_map[i][j] = 5;
		//5채우기
		for(int i = 0; i < n; i++) {
			int sIdx = -1, eIdx = -1;
			for(int j = 0; j < n; j++) {
				if(tmp_map[i][j] == 5) {
					if(sIdx == -1) sIdx = j;
					else eIdx = j;
				}
			}
			for(int j = sIdx+1; j < eIdx; j++) {
				tmp_map[i][j] = 5;
			}
		}
		return get_diff(tmp_map);
	}
	public static int get_diff(int[][] tmp_map) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[] val = new int[6];
		for(int i = 0; i < tmp_map.length; i++) {
			for(int j = 0; j < tmp_map.length; j++) {
				val[tmp_map[i][j]] += map[i][j];
			}
		}
		for(int i = 1; i < 6; i++) {
			max = Math.max(max, val[i]);
			min = Math.min(min, val[i]);			
		}
		return max-min;
	}
}
