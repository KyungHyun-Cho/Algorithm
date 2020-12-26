import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int max_sTime = Integer.MIN_VALUE;
		int min_eTime = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			String[] str_arr = br.readLine().split(" ");
			int sTime = stoi(str_arr[0]);
			int eTime = stoi(str_arr[1]);
			max_sTime = Math.max(sTime, max_sTime);
			min_eTime = Math.min(eTime, min_eTime);
		}
		System.out.println(max_sTime-min_eTime<0?0:max_sTime-min_eTime);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}

}
