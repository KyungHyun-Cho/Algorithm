import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		int n = stoi(inputArr[0]);
		int m = stoi(inputArr[1]);
		/*n %= m;
		double a = (double)n / m;
		int b = (int)Math.ceil(1 / a) - 1;
		System.out.println(b*n);*/
		System.out.println(m - gcd(n,m));
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}
