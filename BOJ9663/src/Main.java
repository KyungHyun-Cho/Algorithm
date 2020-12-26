import java.util.*;
import java.lang.*;
public class Main {
	static int n, cnt;
	static int[] col;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	for(int i = 1; i <= n; i++) {
    		col = new int[n+1];
    		col[1] = i;
    		DFS(1);
    	}
    	System.out.println(cnt);
    }
    public static void DFS(int row) {
    	if(row == n) {
    		cnt++;
    	}else {
    		for(int i = 1; i <= n; i++) {
    			col[row+1] = i;
    			if(isPossible(row+1)) {
    				DFS(row+1);
    			}
    		}
    	}
    }
    public static boolean isPossible(int row) {
    	for(int i = 1; i < row; i++) {
    		if(col[i] == col[row]) return false;
    		if(Math.abs(i-row) == Math.abs(col[i]-col[row])) return false;
    	}
    	return true;
    }
}