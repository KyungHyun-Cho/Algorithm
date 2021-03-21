import java.io.*;
import java.util.*;
public class Main {
	public static int[] ans;
	public static int root;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = stoi(input[0]);
		root = stoi(input[1])-1;
		ans = new int[n];
		int q = stoi(input[2]);
		ArrayList<Integer>[] map = new ArrayList[n];
		for(int i = 0; i < n; i++)
			map[i] = new ArrayList<>();
		
		for(int i = 0; i < n-1; i++) {
			input = br.readLine().split(" ");
			int E1 = stoi(input[0])-1;
			int E2 = stoi(input[1])-1;
			map[E1].add(E2);
			map[E2].add(E1);			
		}
		DFS(map, root, root);
		while(q--> 0) {
			System.out.println(ans[stoi(br.readLine())-1]);
		}
		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static int DFS(ArrayList<Integer>[] map, int startIdx, int prevIdx) {
		int sum = 1;
		if(startIdx != root && map[startIdx].size() == 1) {
			ans[startIdx] = 1;
			return 1;
		}
		for(int nextIdx : map[startIdx]) {
			if(nextIdx != prevIdx) {
				sum += DFS(map, nextIdx, startIdx);
			}
		}
		ans[startIdx] = sum;
		return sum;
	}
}
