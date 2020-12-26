import java.util.*;
 
class Main {
	static int n;
	static int[] arr;
	static int[] op = new int[4];
	static char[] op_chr = {'+','-','*','/'};
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        
        for(int i = 0; i < n; i++)
        	arr[i] = sc.nextInt();
        for(int i = 0; i < 4; i++)
        	op[i] = sc.nextInt();
        
        DFS(arr[0], 0);
        System.out.println(max + "\n" + min);
    }
 
    static void DFS(int sum, int k) {
    	if(k == n-1) {
    		if(sum < min) min = sum;
    		if(sum > max) max = sum;
    	}else {
    		for(int i = 0; i < 4; i++) {
    			if(op[i] != 0) {
    				--op[i];
    				if(i == 0) {
    					DFS(sum + arr[k+1], k+1);
    				}else if(i == 1) {
    					DFS(sum - arr[k+1], k+1);
    				}else if(i == 2) {
    					DFS(sum * arr[k+1], k+1);
    				}else if(i == 3) {
    					DFS(sum / arr[k+1], k+1);
    				}
    				++op[i];
    			}
    		}
    	}
    }
}
