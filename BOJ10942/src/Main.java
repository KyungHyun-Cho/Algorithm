import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder() sb = 
		int n = stoi(br.readLine());
		int[] arr = new int[n+1];
		boolean[][] table = new boolean[n+1][n+1];
		String[] str_arr = br.readLine().split(" ");
		for(int i = 0; i < n; i++) 
			arr[i+1] = stoi(str_arr[i]);
		int m = stoi(br.readLine());
		for(int i = 1; i <= n; i++) {
			for(int j = i; j <= n; j++) {
				int new_i = j-i+1;
				int diff = j - new_i;
				System.out.println(new_i + "," + j);
				if(new_i == 1 && j == 7) {
					System.out.println("BP");
				}
				//i == j : true
				//j-i == 1 > i==j?true:false
				//j-i >= 2 > i==j && i+1, j-1 > true ¿©¾ß true
				if(diff == 0)
					table[new_i][j] = true;
				else if(diff == 1)
					table[new_i][j] = arr[new_i]==arr[j];
				else if(diff >= 2)
					table[new_i][j] = (arr[new_i] == arr[j]) && table[new_i+1][j-1];
			}
		}
		for(int i = 0; i < m; i++) {
			str_arr = br.readLine().split(" ");
			int p = stoi(str_arr[0]);
			int q = stoi(str_arr[1]);
			bw.write(table[p][q]?"1\n":"0\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int stoi(String str) {return Integer.parseInt(str);}
}
