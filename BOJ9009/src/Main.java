import java.util.*;
public class Main {
	static final int F_MAX = 45;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[F_MAX+1];
		arr[0]=0;
		arr[1]=1;
		for(int i = 2; i <= F_MAX; i++)
			arr[i] = arr[i-1] + arr[i-2];
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int j = F_MAX; j >= 0; j--) {
				if(arr[j] <= num) {pq.add(arr[j]); num -= arr[j];}
				if(num == 0) break;
			}
			while(!pq.isEmpty())
				System.out.print(pq.poll() + " ");
			System.out.println();
		}
	}
}
