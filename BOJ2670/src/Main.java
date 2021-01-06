import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		// 1. �Է��� �޴´�.
		int n = Integer.parseInt(br.readLine());
		double[] arr = new double[n];
		for(int i = 0; i < n; i++) {
			arr[i] = stod(br.readLine());
		}
		
		// 2. double max = arr[0];���� �����Ѵ�.
		double max = arr[0];
		
		// 3. for i -> 1 to n���� �ݺ��ϸ鼭, 
		for(int i = 1; i < n; i++) {
			// arr[i-1]*arr[i]�� arr[i]���� ũ�ٸ�, arr[i]�� �����Ѵ�.
			arr[i] = Math.max(arr[i], arr[i-1] * arr[i]);
			// 4. arr[i]�� max������ ũ�ٸ� max�� �����Ѵ�.
			max = Math.max(max, arr[i]);
		}
		// 5. max�� ����Ѵ�.
		System.out.printf("%.3f", max);
	}
	public static double stod(String str) {return Double.parseDouble(str);}
}
