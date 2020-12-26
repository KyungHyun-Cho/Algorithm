import java.util.*;
public class Main {
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max = Integer.MIN_VALUE;
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			int len = str.length();
			for(int j = 0; j < len; j++) {
				map[i][j] = str.charAt(j) - '0';
				max = Math.max(max, map[i][j]);
			}
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				if(map[i][j] == 0) continue;
				int min = retMin(i, j);
				if(min != 0) 
					map[i][j] = (int)Math.pow(Math.sqrt(min) + 1, 2.0);
				max = Math.max(max, map[i][j]);
			}
		}
		System.out.println(max);
	}
	public static int retMin(int i, int j) {
		int t1, t2, t3, min = Integer.MAX_VALUE;
		t1 = map[i-1][j-1];
		t2 = map[i-1][j];
		t3 = map[i][j-1];
		min = Math.min(min, t1);
		min = Math.min(min, t2);
		min = Math.min(min, t3);
		return min;
	}
}
