import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for(int i = 0; i < n; i++)
			a[i] = Integer.parseInt(br.readLine());
		int[] aux = new int[n];
		int[] c = new int[10001];
		for(int i = 0; i < n; i++)
			c[a[i]]++;
		for(int i = 1; i <= 10000; i++)
			c[i] += c[i-1];
		for(int i = n-1; i >= 0; i--) {
			int idx = a[i];
			c[idx]--;
			aux[c[idx]] = idx;
		}
		for(int i = 0; i < n; i++)
			bw.write(aux[i] + "\n");
		br.close();
		bw.flush();
		bw.close();
		
	}
}
