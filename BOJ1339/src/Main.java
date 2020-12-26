import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int[] arr = new int[26];
		for(int i = 0; i < n; i++) {
			String tmp = sc.next();
			for(int j = 0; j < tmp.length(); j++) {
				int p = tmp.length()-j-1;
				arr[tmp.charAt(j)-'A'] += (int)Math.pow(10, p);
			}
		}
		Arrays.sort(arr);
		int t = 9;
		for(int i = arr.length-1; i >= 0; i--) {
			if(arr[i] == 0) break;
			sum += arr[i]*t;
			t--;
		}
		System.out.println(sum);
		
	}
}
