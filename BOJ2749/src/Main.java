import java.util.Scanner;
public class Main {
	static long[][] default_matrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[][] A = {{1,1},{1,0}};
		
		long n = sc.nextLong();
		default_matrix = new long[][] {{1, 0}, {0, 1}};
		
		
		long[][] B = matrixMul(matrixPow(A, n-1), new long[][] {{1},{0}});
		System.out.println(B[0][0]);
	}
	public static long[][] matrixPow(long[][] A, long n) {
		if(n == 0) return default_matrix;
		long[][] tmp = matrixPow(A, n/2);
		long[][] ret = matrixMul(tmp, tmp);
		if(n % 2 == 1) ret = matrixMul(ret, A);
		return ret;
	}
	public static long[][] matrixMul(long[][] A, long[][] B){
		long[][] C = new long[A.length][B[0].length];
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < B[0].length; j++) {
				for(int k = 0; k < B.length; k++) {
					C[i][j] = (C[i][j] + (A[i][k]*B[k][j])) % 1000000;
				}
			}
		}
		return C;
	}
}
