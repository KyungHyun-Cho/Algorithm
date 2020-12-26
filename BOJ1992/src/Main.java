import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			for(int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		merge(arr,0,0,n-1,n-1);
		
	}
	public static void merge(int[][] arr, int x0, int y0, int x1, int y1) {
		int color = getColor(arr, x0, y0, x1, y1);
		if(color == -1) {
			int mid_x = (x0+x1)/2;
			int mid_y = (y0+y1)/2;
			System.out.print("(");
			merge(arr, x0, y0, mid_x, mid_y);
			merge(arr, x0, mid_y+1, mid_x, y1);
			merge(arr, mid_x+1, y0, x1, mid_y);
			merge(arr, mid_x+1, mid_y+1, x1, y1);
			System.out.print(")");
			
		}else if(color == 0) {
			System.out.print(0);
		}else if(color == 1) {
			System.out.print(1);			
		}
	}
	public static int getColor(int[][] arr, int x0, int y0, int x1, int y1) {
		int first = arr[x0][y0];
		for(int i = x0; i <= x1; i++) {
			for(int j = y0; j <= y1; j++) {
				int tmp = arr[i][j] ^ first;
				if(tmp == 1) return -1;
			}
		}
		return first;
	}
}