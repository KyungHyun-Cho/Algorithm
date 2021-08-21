import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int sortedCnt = 0;
		int allCnt = n;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = stoi(br.readLine());
		
		for(int i = n-1; i >= 0; i--) {
			if(arr[i] == n) {
				n -= 1;
				sortedCnt++;
			}
		}
		
		System.out.println(allCnt - sortedCnt);
		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
