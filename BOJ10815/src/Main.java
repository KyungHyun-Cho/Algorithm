import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] A = new boolean[20_000_001];
		boolean[] B = new boolean[20_000_001];
		
		int n = stoi(br.readLine());
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			int val = stoi(input[i]) + 10_000_000;
			A[val] = true;
		}
		int m = stoi(br.readLine());
		input = br.readLine().split(" ");		
		for(int i = 0; i < m; i++) {
			int val = stoi(input[i]) + 10_000_000;
			if(A[val]) sb.append(1);
			else sb.append(0);
			sb.append(' ');
		}
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
