import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[][] ppl = new int[15][15];
		for(int i = 0; i < 15; i++)
			ppl[0][i] = i;
		for(int i = 1; i < 15; i++) 
			for(int j = 1; j < 15; j++) 
				ppl[i][j] = ppl[i][j-1] + ppl[i-1][j];
		for(int i = 0; i < tc; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(ppl[n][m]);
		}
	}
}
