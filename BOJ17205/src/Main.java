import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] p = br.readLine().toCharArray();

		long t = 0;
		for (int i = 0; i < p.length; i++) {
			if (i == N - 1) {
				t += p[i] - 'a' + 1;
				break;
			}

			long c = 26;
			for (int j = i + 2; j < N; j++)
				c = c * 26 + 26;

			t += (p[i] - 'a') * c + (p[i] - 'a' + 1);
		}

		System.out.println(t);
	}
}