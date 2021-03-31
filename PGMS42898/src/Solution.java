import java.util.*;
class Solution {
	public int solution(int y, int x, int[][] puddles) {
		int[][] map = new int[x+1][y+1];
		for(int[] info : puddles) {
			int p = info[1];
			int q = info[0];
			map[p][q] = -1;
		}
		map[1][1] = 1;
		for(int i = 1; i <= x; i++) {
			for(int j = 1; j <= y; j++) {
				if(map[i][j] == -1) continue;
				map[i][j] = Math.max(map[i][j], ((map[i-1][j] == -1 ? 0 : map[i-1][j]) + (map[i][j-1] == -1 ? 0 : map[i][j-1])) % 1_000_000_007);
			}
		}
		return map[x][y];
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int m = 4;
		int n = 3;
		int[][] puddles = {{2, 2}};
		System.out.println(solution.solution(m, n, puddles));
	}
}
