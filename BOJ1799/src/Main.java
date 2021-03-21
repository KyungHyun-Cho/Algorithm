import java.util.*;
import java.lang.*;
public class Main {
	static int n, cnt;
	static int[][] map;
	static boolean[][] visit;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
		map = new int[n+1][n+1];
		visit = new boolean[n+1][n+1];
    	for(int i = 1; i <= n; i++) 
    		for(int j = 1; j <= n; j++) {
    			int t = sc.nextInt();
    			map[i][j] = t;
    			//if(t == 0) visit[i][j] = true;
    		}
    	//visit[1][1] = true;
		DFS(1, 1);
    	System.out.println(cnt);
    }
    public static void DFS(int row, int col) {
    	//System.out.println("½ÇÇà?");
    	if(col > n) {
    		row++;
    		col = 1;
    		//System.out.println(row + "," + col);
    	}
    	if(row == n && col == n) {
    		cnt = 0;
    		for(int i = 1; i <= n; i++) {
    			for(int j = 1; j <= n; j++) {
    				if(visit[i][j] && map[i][j] == 1) {
    					System.out.println(i + "," + j);
    					cnt++;
    				}
    			}
    		}
    		System.out.println(cnt);
    	}else {
    		if(map[row][col] == 1) {
				//System.out.println(":)_?");
    			for(int i = 1; i <= n; i++) {
	    			for(int j = 0; j < n; j++) {
						if(map[i][j+1] == 1 && !visit[i][j+1]) {
							//System.out.println("?");
			    			if(isPossible(i,j+1)) {
			    				//System.out.println("++");
		    					visit[i][j+1] = true;
			    				DFS(i,j+1);
			    				System.out.println(row+","+col);
			    				if(i == 5 && j+1 == 4) {
			    					System.out.println("BP");
			    				}
			    				if(i == 1 && j+1 == 1) {
			    					System.out.println("BP2");
			    				}
				    			visit[i][j+1] = false;
			    				//System.out.println("P?");
			    			}
		    			}
	    			}
    			}
    		}else {
    			DFS(row,col+1);
    		}
    	}
    }
    public static boolean isPossible(int row, int col) {
    	for(int i = 1; i <= row; i++) {
    		for(int j = 1; j <= n; j++) {
    			if(visit[i][j]) {
        			if(Math.abs(i-row) == Math.abs(j-col)) return false;
    			}
    		}
    	}
    	return true;
    }
}