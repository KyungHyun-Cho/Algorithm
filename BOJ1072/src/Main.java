import java.io.*;
import java.util.*;
public class Main {
	public static long X, Y;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		X = stoi(inputArr[0]);
		Y = stoi(inputArr[1]);		
		long firstWinRate = GetWinRate(0);
		if(firstWinRate >= 99)
		{
			System.out.println(-1);
			return;
		}
		long l = 0;
		long r = X;
		long mid = (l + r) / 2;
		while(l < r) {
			if(firstWinRate != GetWinRate(mid))
				r = mid;
			else
				l = mid + 1;
			mid = (l + r) / 2;
		}
		System.out.println(mid);
	}
	public static long GetWinRate(long playCnt) {
		return (Y+playCnt)*100 / (X+playCnt);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
