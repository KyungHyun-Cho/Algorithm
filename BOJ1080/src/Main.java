import java.util.*;
public class Main {
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] A = new int[n][m];
		int[][] B = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			for(int j = 0; j <= str.length()-1; j++) {
				A[i][j] = str.charAt(j)-'0';
			}
		}
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			for(int j = 0; j <= str.length()-1; j++) {
				B[i][j] = str.charAt(j)-'0';
			}
		}
		if(n < 3 || m < 3) {
			//3x3보다 작은 행렬의 경우 바로 정합성
		}else {
			//flip
			for(int i = 0; i < n-2; i++) {
				for(int j = 0; j < m-2; j++) {
					boolean isLast = false;
					if(j == m-3) isLast = true;
					flip(A,B,i,j,isLast);
					if(cnt == -1) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		//정합성 테스트
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(A[i][j] != B[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(cnt);
	}
	public static void flip(int[][] A, int[][] B, int x, int y, boolean isLast) {
		if(A[x][y] == B[x][y] && A[x][y+1] == B[x][y+1] && A[x][y+2] == B[x][y+2]) {
			return;
		}
		if(isLast) {
			if(!(A[x][y] != B[x][y] && A[x][y+1] != B[x][y+1] && A[x][y+2] != B[x][y+2])) {
				cnt = -1;
				return;
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				A[x+i][y+j] = A[x+i][y+j]==1?0:1;
			}
		}
		cnt++;
	}

}
