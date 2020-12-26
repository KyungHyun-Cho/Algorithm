import java.util.*;
import java.lang.*;
public class Main {
	static int n, m;
	static int[][] arr;
	static int[] list;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;
	//static Deque<Integer> s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = n/2;
		arr = new int[n+1][n+1];
		list = new int[m];
		
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				arr[i][j] = sc.nextInt();
		
		DFS(0);
		System.out.println(min);
	}
	public static void DFS(int idx) {
		if (idx == m) {
			visit = new boolean[n+1];
			for(int i = 0; i < m; i++) 
				visit[list[i]] = true;
			int diff = getStatDiff();
			if(diff < min) min = diff;
		}else {
			for(int i = 1; i <= n; i++) {
				list[idx] = i;
				if(idx == 0) {
					DFS(idx+1);
				}else if(list[idx] > list[idx-1]){
					//System.out.println("(" + list[idx-1] + "," + list[idx] + ")");
					DFS(idx+1);
				}
			}
		}
	}
	public static int getStatDiff() {
		int[] teamA = new int[m];
		int[] teamB = new int[m];
		int AIdx = 0, BIdx = 0;
		int AScore = 0, BScore = 0;
		for(int i = 1; i <= n; i++)
			if(visit[i]) teamA[AIdx++] = i;
			else teamB[BIdx++] = i;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				if(i != j) {
					AScore += arr[teamA[i]][teamA[j]]; 
					BScore += arr[teamB[i]][teamB[j]]; 
				}
			}
		}
		return Math.abs(AScore-BScore);
	}
}
