import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int diffMax = Integer.MAX_VALUE, ansS = -1, ansE = -1;
		int n = stoi(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) arr[i] = stoi(input[i]);
		Arrays.sort(arr);
		
		int ps = 0, pe = n-1;
		while(ps < pe) {
			int diff = arr[ps] + arr[pe];
			int diffAbs = Math.abs(diff);
			if(diff == 0) {
				System.out.println(arr[ps] + " " + arr[pe]);
				return;
			}
			
			if(diffAbs < diffMax) {
				ansS = arr[ps];
				ansE = arr[pe];
				diffMax = diffAbs;
			}else {
				if(diff < 0) ps++;
				else pe--;
			}
		}
		System.out.println(ansS + " " + ansE);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
