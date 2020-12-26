import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dScore = new int[n][2];
		for(int i = 0; i < n; i++) {
			dScore[i][0] = sc.nextInt();
			dScore[i][1] = sc.nextInt();			
		}

		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			int rank = 1;
			for(int j = 0; j < n; j++) {
				if(i == j) continue;
				if(dScore[i][0] < dScore[j][0] && dScore[i][1] < dScore[j][1]) {
					rank++;
				}
			}
			System.out.print(rank + " ");
		}
			
	}
}
