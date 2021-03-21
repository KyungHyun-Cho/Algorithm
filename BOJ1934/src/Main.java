import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = stoi(br.readLine());
		while(tc--> 0) {
			String[] input = br.readLine().split(" ");
			int n = stoi(input[0]);
			int m = stoi(input[1]);
			sb.append(n*m/GCD(n, m) + "\n");
		}
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	
	public static int GCD(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
