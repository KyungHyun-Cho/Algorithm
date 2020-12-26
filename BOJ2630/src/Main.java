import java.util.*;
import java.lang.*;
public class Main {
	static int w = 0, b = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				arr[i][j] = sc.nextInt();
		}
		merge(arr, 0,0,n-1,n-1);
		System.out.println(w);
		System.out.println(b);
	}
	public static void merge(int[][] arr, int x0, int y0, int x1, int y1){//int x0, int y0, int x1, int y1) {
		/*
		 * 만약 getColor == -1이면
		 *  4개의 머지로 다시 나눈다
		 *  int x_mid = x1/2;
		 *  int y_mid = x1/2;
		 *  merge(arr, 0, 0, x_mid - 1, y_mid-1);
		 *  merge(arr, x_mid, 0, x1, y_mid - 1);
		 *  merge(arr, 0, y_mid-1, x_mid - 1, y1);
		 *  merge(arr, x_mid, y_mid, x1, y1);
		 * 0이면 0카운트++
		 * 1이면 1카운트++
		 * */
		int ret = getColor(arr, x0, y0, x1, y1);
		if(ret == -1) {
			int x_mid = (x0 + x1)/2 + 1;
			int y_mid = (y0 + y1)/2 + 1;
			merge(arr, x0, y0, x_mid - 1, y_mid-1);
			merge(arr, x_mid, y0, x1, y_mid - 1);
			merge(arr, x0, y_mid, x_mid - 1, y1);
			merge(arr, x_mid, y_mid, x1, y1);
		}else if(ret == 0)
			w++;
		else if(ret == 1)
			b++;
	}
	public static int getColor(int[][] arr, int x0, int y0, int x1, int y1) {
		//System.out.println("getColor : " + x0 + "," + y0 + "," + x1 + "," + y1);
		int a = arr[x0][y0];
		for(int i = x0; i <= x1; i++) {
			for(int j = y0; j <= y1; j++) {
				int tmp = a ^ arr[i][j];
				//System.out.println("(" + a + "," + tmp + ")");
				if(tmp == 1)
					return -1;
			}
		}
		return a;
	}
}