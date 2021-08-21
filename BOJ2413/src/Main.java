import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> IdxPerN = new HashMap<>();
		
		int n = stoi(br.readLine());
		String[] strArr = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i = 0; i < n-1; i++) {
			arr[i] = stoi(strArr[i])-1;
			IdxPerN.put(arr[i], i);
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
