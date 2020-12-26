import java.io.*;
public class Main {
	static int n;
	static int m;
	static int[] list;
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		br.close();
		n = Integer.parseInt(str.split(" ")[0]);
		m = Integer.parseInt(str.split(" ")[1]);
		list = new int[n];
		DFS(0);
		bw.flush();
		bw.close();
	}
	public static void DFS(int k) throws IOException {
		if(k == m) {
			for(int i = 0; i < m; i++)
				bw.write(list[i] + " ");
			bw.write("\n");
		}else {
			for(int i = 1; i <= n; i++) {
				list[k] = i;
				DFS(k+1);
			}
		}
	}
}
