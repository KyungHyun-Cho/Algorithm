import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int tmp = 0;
		for(int i = 1; i <= n; i++) {
			int tmp2 = get_sum(i);
			if(tmp2 > n) {
				System.out.println(i);
				System.out.println(tmp2);
				break;
			}
			if(arr[tmp2] == 0) arr[tmp2] = i;
		}
		System.out.println(arr[n]);
	}
	public static int get_sum(int k) {
		int sum = k;
		while(k != 0) {
			sum += k%10;
			k /= 10;
		}
		return sum;
	}
}
