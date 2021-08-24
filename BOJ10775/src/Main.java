import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = stoi(br.readLine());
		int p = stoi(br.readLine());
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		int[] arr = new int[p];
		for(int i = 0; i < p; i++) {
			arr[i] = stoi(br.readLine());
			if(!map.containsKey(arr[i]))
				map.put(arr[i], new ArrayList<Integer>());
			map.get(arr[i]).add(i);
		}
		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
