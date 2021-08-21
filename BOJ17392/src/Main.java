import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		int n = stoi(inputArr[0]);
		int m = stoi(inputArr[1]);
		
		int[] arr = new int[n];
		int pDay = 0;
		int rDay = m;
		int groupCnt = n + 1;
		inputArr = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			arr[i] = stoi(inputArr[i]);
			pDay += (arr[i] + 1);
			rDay -= (arr[i] + 1);
		}
		
		if(pDay < m) {
			int fDay = rDay / groupCnt;
			int remain = rDay % groupCnt;
			System.out.println((GetFDay(fDay)*(groupCnt-remain)) + (GetFDay(fDay+1)*remain));

		}else {
			System.out.println(0);
		}		
	}
	
	public static long GetFDay(int fDay) {
		long ret = 0;
		for(int i = 1; i <= fDay; i++)
			ret += (i*i);
		return ret;
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
