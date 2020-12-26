import java.util.*;
import java.io.*;
public class Main{
	static int n,m;
	static int[] list;
	static boolean[] visit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		list = new int[n];
		visit = new boolean[n+1];
		
		DFS(0);
		bw.flush();
		bw.close();
		sc.close();
	}
	public static void DFS(int k) throws IOException{
		if(m == k) {
			for(int i = 0; i < m; i++)
				bw.write(list[i] + " ");
			bw.write("\n");
		}else {
			for(int i = 1; i <= n; i++) {
				list[k] = i;
				if(k == 0) 
					DFS(k+1);
				else if(list[k] >= list[k-1])
					DFS(k+1);
			}
		}
	}
}