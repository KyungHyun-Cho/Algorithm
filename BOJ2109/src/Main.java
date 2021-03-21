/*
3
10 3
20 3
30 3
Print : 30
Answer : 60
*/
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int[] max = new int[10001];
		int[][] arr = new int[n][2];
		for(int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();			
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o2[1] == o1[1]) return o2[0] - o1[0];
				return o2[1] - o1[1];
			}
		});
		int idx = 0;
		for(int d = 10000; d > 0; d--) {
			int cost = arr[idx][0];
			int dueDate = arr[idx][1];
			if(dueDate < d) {
				continue;
			}else {
				max[d] = Math.max(max[d], cost);
				idx++;
			}
		}
		for(int i = 0; i < 10001; i++)
			sum += max[i];
		System.out.println(sum);
	}
}
