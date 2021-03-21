import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		long sum = 0;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = stoi(br.readLine());
		Arrays.sort(arr);
		if(arr[0] != 1) {
			sum += (arr[0] - 1);
			arr[0] = 1;
		}
		for(int i = 1; i < n; i++) {
			if(arr[i] > arr[i-1]) {
				sum += arr[i] - (arr[i-1] + 1);
				arr[i] = arr[i-1]+1;
				
			}				
		}
		System.out.println(sum);
		br.close();
	}
	public static int stoi(String str) {return Integer.parseInt(str);}

}
