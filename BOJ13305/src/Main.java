import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long ans = 0;
		
		int n = stoi(br.readLine());
		int[] distArr = new int[n-1];
		int[] priceArr = new int[n];
		
		String[] distStr = br.readLine().split(" ");
		String[] priceStr = br.readLine().split(" ");
		
		for(int i = 0; i < n-1; i++)
			distArr[i] = stoi(distStr[i]);
		for(int i = 0; i < n; i++)
			priceArr[i] = stoi(priceStr[i]);

		int nowIdx = 0;
		while(nowIdx < n) {
			long distSum = 0;
			long nowCost = priceArr[nowIdx];
			for(nowIdx++; nowIdx < n; nowIdx++) {				
				distSum += distArr[nowIdx-1];
				if(priceArr[nowIdx] < nowCost) {
					break;
				}
			}
			ans += (nowCost*distSum);
		}
		System.out.println(ans);
		br.close();
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}