import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int tmp_sum = 0;
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] cards = new int[n];
		for(int i = 0; i < n; i++)
			cards[i] = sc.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				for(int k = j+1; k < n; k++) {
					tmp_sum = cards[i] + cards[j] + cards[k];
					if(tmp_sum > max && tmp_sum <= m)
						max = tmp_sum;
				}
			}
		}
		System.out.println(max);
	}
}
