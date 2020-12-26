import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		arr[0] = arr[1] = -1;
		if(n >= 2) arr[2] = 1;
		if(n >= 3) arr[3] = -1;
		if(n >= 4) arr[4] = 2;
		if(n >= 5) arr[5] = 1;
		if(n >= 6) arr[6] = 3;
		if(n >= 7) arr[7] = 2;
		if(n >= 8) arr[8] = 4;		
		for(int i = 9; i <= n; i++) {
			arr[i] = Math.min(arr[i-5], arr[i-2])+1;
		}
		System.out.println(arr[n]);
	}
}
