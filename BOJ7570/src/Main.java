import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		String[] inputArr = br.readLine().split(" ");
		
		int[] arr = new int[n+1];
		int max = 0;
		for(int i = 0; i < n; i++) {
			int k = stoi(inputArr[i]);
			arr[k] = Math.max(arr[k-1]+1, arr[k]);
			max = Math.max(arr[k], max);
		}
		System.out.println(n-max);
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}