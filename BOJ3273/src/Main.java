import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		int n = stoi(br.readLine());
		int[] arr = new int[n];
		String[] input = br.readLine().split(" ");
		int x = stoi(br.readLine());
		for(int i = 0; i < n; i++) arr[i] = stoi(input[i]);
		Arrays.sort(arr);
		
		int ps = 0, pe = n-1;
		while(ps < pe) {
			int sum = arr[ps] + arr[pe];
			if(sum < x) {
				ps++;
			}else if(sum == x) {
				ans++;
				ps++;
				pe--;
			}else if(sum > x) {
				pe--;
			}
		}
		System.out.println(ans);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
