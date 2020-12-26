import java.util.Scanner;
import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] map = new char[n][m];
		int[][] first_is_black = new int[n][m];
		int[][] first_is_white = new int[n][m];
		
		for(int i = 0; i < n; i++)
			map[i] = sc.next().toCharArray();
		

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(i % 2 == 0) {
					if(j % 2 == 0) {
						if('W' != map[i][j]) first_is_white[i][j] = 1;
						if('B' != map[i][j]) first_is_black[i][j] = 1;
					}else{
						if('W' == map[i][j]) first_is_white[i][j] = 1;
						if('B' == map[i][j]) first_is_black[i][j] = 1;
					}
				}else {
					if(j % 2 == 0) {
						if('W' == map[i][j]) first_is_white[i][j] = 1;
						if('B' == map[i][j]) first_is_black[i][j] = 1;
					}else{
						if('W' != map[i][j]) first_is_white[i][j] = 1;
						if('B' != map[i][j]) first_is_black[i][j] = 1;
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int x = 0; x < n-8+1; x++) {
			for(int y = 0; y < m-8+1; y++) {
				int sum_b = 0;
				int sum_w = 0;
				for(int i = x; i < x+8; i++) {
					for(int j = y; j < y+8; j++) {
						sum_b += first_is_black[i][j];
						sum_w += first_is_white[i][j];						
					}
				}
				min = Math.min(min,Math.min(sum_b,sum_w));
			}
		}
		System.out.println(min);
		sc.close();
	}
}
