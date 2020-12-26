import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] A, B, C;
		int a_n = sc.nextInt();
		int a_m = sc.nextInt();
		A = new int[a_n][a_m];
		for(int i = 0; i < a_n; i++) {
			for(int j = 0; j < a_m; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		int b_n = sc.nextInt();
		int b_m = sc.nextInt();
		B = new int[b_n][b_m];
		C = new int[a_n][b_m];
		for(int i = 0; i < b_n; i++) {
			for(int j = 0; j < b_m; j++) {
				B[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < a_n; i++) {
			for(int j = 0; j < b_m; j++) {
				for(int k = 0; k < a_m; k++) {
					C[i][j] += (A[i][k]*B[k][j]);
				}
			}
		}
		
		for(int i = 0; i < a_n; i++) {
			for(int j = 0; j < b_m; j++) {
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
	}

}
