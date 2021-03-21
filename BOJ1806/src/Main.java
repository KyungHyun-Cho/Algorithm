import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");		
		int n = stoi(input[0]);
		int s = stoi(input[1]);
		Integer[] arr = new Integer[n];
		input = br.readLine().split(" ");
		for(int i = 0; i < n; i++) arr[i] = stoi(input[i]);
		Arrays.sort(arr, Collections.reverseOrder());
		
		int ans = 1;
		int sum = arr[0];
		
		for(int i = 1; i < n; i++) {
			if(sum >= s) {
				System.out.println(ans);
				return;
			}else {
				if(arr[i] == (arr[i-1] - 1)) {
					ans++;
					sum += arr[i];
				}else {
					ans = 1;
					sum = arr[i];
				}
			}
		}
		
		if(sum >= s) {
			System.out.println(ans);
		}else {
			System.out.println(0);
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
