import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int offset = (int)Math.round(n*0.15);
		int sum = 0;
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = stoi(br.readLine());
		
		Arrays.sort(arr);
		
		for(int i = offset; i < n-offset; i++)
			sum += arr[i];
		
		System.out.println(Math.round((double)sum / (n-offset*2)));

	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
