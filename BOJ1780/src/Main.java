import java.io.*;
public class Main {
	static int m = 0,z = 0,o = 0;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(str[j]);
		}
		merge(0,0,n-1,n-1);
		System.out.println(m);
		System.out.println(z);
		System.out.println(o);
		br.close();
	}
	public static void merge(int x0, int y0, int x1, int y1){//int x0, int y0, int x1, int y1) {
		int ret = getColor(x0, y0, x1, y1);
		if(ret == -2) {
			int diff = (x1-x0+1)/3;
			int x_mid1 = x0 + diff;
			int x_mid2 = x0 + diff + diff;
			int y_mid1 = y0 + diff;
			int y_mid2 = y0 + diff + diff;
			//0~8 ¶ó¸é, x_mid = 2
			//±â´ñ°ª : 0~2, 3~5, 6~8
			//0~5 ¶ó¸é, x_mid = 1
			//±â´ñ°ª : 0~1, 2~3, 4~5
			//6~8 ¶ó¸é, x_mid = 4
			//±â´ñ°ª : 6~6, 7~7, 8~8
			merge(x0, y0, x_mid1-1, y_mid1-1);
			merge(x0, y_mid1, x_mid1-1, y_mid2-1);
			merge(x0, y_mid2, x_mid1-1, y_mid2+diff-1);
			merge(x_mid1, y0, x_mid2-1, y_mid1-1);
			merge(x_mid1, y_mid1, x_mid2-1, y_mid2-1);
			merge(x_mid1, y_mid2, x_mid2-1, y_mid2+diff-1);
			merge(x_mid2, y0, x_mid2+diff-1, y_mid1-1);
			merge(x_mid2, y_mid1, x_mid2+diff-1, y_mid2-1);
			merge(x_mid2, y_mid2, x_mid2+diff-1, y_mid2+diff-1);
		}else if(ret == -1)
			m++;
		else if(ret == 0)
			z++;
		else if(ret == 1)
			o++;
	}
	public static int getColor(int x0, int y0, int x1, int y1) {
		//System.out.println("getColor : " + x0 + "," + y0 + "," + x1 + "," + y1);
		int a = arr[x0][y0];
		for(int i = x0; i <= x1; i++) {
			for(int j = y0; j <= y1; j++) {
				if(arr[i][j] != a) return -2;
			}
		}
		return a;
	}
}