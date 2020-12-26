import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\jkh96\\Documents\\input.txt")));
		int T = stoi(br.readLine());
		while(T-->0) {
			int n = stoi(br.readLine());
			int[] arr = new int[n];
			boolean[] sell_arr = new boolean[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 0;
			while(st.hasMoreTokens()) {
				arr[j++] = stoi(st.nextToken());
			}
			int sell_price = arr[n-1];
			sell_arr[n-1] = true;
			for(int i = n-2; i >= 0; i--) {
				if(arr[i] > sell_price) {
					sell_arr[i] = true;
					sell_price = arr[i];
				}
			}
			long now_money = 0;
			long stock_cnt = 0;
			for(int i = 0; i < n; i++) {
				if(sell_arr[i]) {
					now_money += stock_cnt*arr[i];
					stock_cnt = 0;
				}else {
					now_money -= arr[i];
					stock_cnt++;
				}
			}
			System.out.println(now_money);
		}
		br.close();
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}

//89842512
//bssbbsss