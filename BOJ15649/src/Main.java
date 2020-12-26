import java.util.Scanner;
import java.io.*;
public class Main {
    static int n;
    static int m;
    static int[] list;
    static boolean[] visit;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	n = sc.nextInt();
    	m = sc.nextInt();
    	list = new int[n+1];
    	visit = new boolean[n+1];
    	
    	DFS(0);
    	bw.flush();
    	bw.close();
    	sc.close();
    }
    public static void DFS(int k) throws IOException{
    	if(k == m) {
    		for(int i = 0; i < m; i++)
    			bw.write(list[i] + " ");
    		bw.write("\n");
    	}else {
    		for(int i = 1; i <= n; i++) {
    			if(!visit[i]) {
    				visit[i] = true;
	    			list[k] = i;
	    			DFS(k+1);
	    			visit[i] = false;
    			}
    		}
    	}
    }
}