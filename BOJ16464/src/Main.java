import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[200_001_000];
		for(int i = 1; i <= 14143; i++) {
			int tmp = i;
			for(int j = i+1; j <= 14143; j++) {
				tmp += j;
				arr[tmp] = true;
			}
		}
		
		int n = stoi(br.readLine());
		StringBuilder sb = new StringBuilder(); 				
		while(n-- > 0) {
			sb.append(arr[stoi(br.readLine())] ? "Gazua\n" : "GoHanGang\n");
		}
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}

}
