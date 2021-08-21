import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		int n = stoi(inputArr[0]);
		int k = stoi(inputArr[1]);		
		int[][] map = new int[k+1][n+1];
		int[][] input = new int[k][2];
		
		for(int i = 0; i < k; i++) {
			inputArr = br.readLine().split(" ");
			input[i][0] = stoi(inputArr[0]);
			input[i][1] = stoi(inputArr[1]);			
		}
		
		for(int i = 1; i <= k; i++) {
			for(int j = 1; j <= n; j++) {
				if(j-input[i-1][1] < 0)
					map[i][j] = map[i-1][j];
				else
					map[i][j] = Math.max(map[i-1][j], map[i-1][j-input[i-1][1]] + input[i-1][0]);					
			}
		}
		
		System.out.println(map[k][n]);
		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
