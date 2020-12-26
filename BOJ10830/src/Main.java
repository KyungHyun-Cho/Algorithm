import java.util.*;
public class Main {
	static int[][] default_matrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] A, B;
		int n = sc.nextInt();
		long m = sc.nextLong();
		A = new int[n][n];
		B = new int[n][n];
		default_matrix = new int[n][n];
		for(int i = 0; i < n; i++) {
			default_matrix[i][i] = 1;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		/*for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					B[i][j] += (A[i][k]*A[k][j]);
				}
			}
		}*/
		
		B = matrixPow(A, m);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(B[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int[][] matrixPow(int[][] A, long n) {
		if(n == 0) return default_matrix;
		int[][] tmp = matrixPow(A, n/2);
		int[][] ret = matrixMul(tmp, tmp);
		if(n % 2 == 1) ret = matrixMul(ret, A);
		return ret;
	}
	public static int[][] matrixMul(int[][] A, int[][] B){
		int[][] C = new int[A.length][B[0].length];
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < B[0].length; j++) {
				for(int k = 0; k < B.length; k++) {
					C[i][j] = (C[i][j] + (A[i][k]*B[k][j])) % 1000;
				}
			}
		}
		return C;
	}
}
