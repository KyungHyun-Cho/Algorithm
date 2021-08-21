import java.io.*;
import java.util.*;
public class Main {
	public static ArrayList<Integer>[] map;
	public static HashSet<Integer> set = new HashSet<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int m = stoi(br.readLine());
		map = new ArrayList[n];
		for(int i = 0; i < n; i++)
			map[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			String[] inputArr = br.readLine().split(" ");
			int src = stoi(inputArr[0]) - 1;
			int dest = stoi(inputArr[1]) - 1;
			map[src].add(dest);
			map[dest].add(src);
		}
		DFS(0, 1);
		set.remove(0);
		System.out.println(set.size());
	}
	public static void DFS(int id, int depth) {
		if(depth == 2) {
			for(int fId : map[id])
				set.add(fId);
		}else {
			for(int fId : map[id]) {
				set.add(fId);
				DFS(fId, depth + 1);
			}
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
