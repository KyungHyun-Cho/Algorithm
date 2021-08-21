import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int[] arr = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		TreeSet<Integer> ts = new TreeSet<>();
		String[] inputArr = br.readLine().split(" ");
		for(int i = 0; i < n ; i++) {
			arr[i] = stoi(inputArr[i]);
			if(!ts.contains(arr[i]))
				ts.add(arr[i]);
		}
		
		int idx = 0;
		for(int tsVal : ts) {
			map.put(tsVal, idx++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : arr)
			sb.append(map.get(i)).append(" ");
		
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
