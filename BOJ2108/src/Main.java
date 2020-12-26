import java.util.*;
import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
		System.out.println(Math.round((double)sum/n));
		System.out.println(arr[n/2]);
		System.out.println(get_many(arr));
		System.out.println(arr[n-1]-arr[0]);
	}
	public static int get_many(int[] arr) {
		int[][] tmp = new int[8001][2];
		for(int i = 0; i < arr.length; i++) {
			tmp[arr[i]+4000][0] = arr[i];
			tmp[arr[i]+4000][1]++;
		}
		Arrays.sort(tmp,new Comparator<int[]>() {
			public int compare(int[] o0, int[] o1) {
				if(o0[1] == o1[1])
					return o0[0]-o1[0];
				else
					return o1[1]-o0[1];
			}
			
		});

		if(tmp[0][1] == tmp[1][1])
			return tmp[1][0];
		else
			return tmp[0][0];
	}
}
