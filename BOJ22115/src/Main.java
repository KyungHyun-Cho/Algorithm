import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		final int INF = 987654321;
		int n = stoi(inputArr[0]);
		int k = stoi(inputArr[1]);
		if(k == 0) {
			System.out.println(0);
			return;
		}
		int[] coffees = new int[n];
		int[][] map = new int[n+1][k+1];
		
		for(int i = 0; i <= n; i++)
			for(int j = 0; j <= k; j++)
				map[i][j] = INF;
		
		inputArr = br.readLine().split(" ");
		for(int i = 0; i < n; i++) 
			coffees[i] = stoi(inputArr[i]);
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= k; j++) {
				if(coffees[i-1] == j)
					map[i][j] = 1;
				else if(j >= coffees[i-1])
					map[i][j] = Math.min(map[i-1][j], map[i-1][j-coffees[i-1]] + 1);
				else
					map[i][j] = map[i-1][j];
			}
		}
		
		System.out.println(map[n][k] == INF ? -1 : map[n][k]);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
