import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = stoi(input[0]); // n*n의 표
		int m = stoi(input[1]); // 합을 구해야 하는 횟수
		int[][] map = new int[n][n];
		int[][] sumArr = new int[n+1][n+1];
		
		for(int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j] = stoi(input[j]);				
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				if(i == j) {
					sumArr[i+1][j+1] = map[i][j];
				}else {
					if(i != 0 && j == 1) {
						sumArr[i+1][j+1] = sumArr[i][n] + map[i][j];
					}else {
						sumArr[i+1][j+1] = sumArr[i+1][j] + map[i][j];
					}
				}
			}
		}
		System.out.println("BP");
		br.close();
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static int getIdx(int n, int x, int y) {return ((x-1) * n ) + y;}
}
