import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = stoi(br.readLine());
		while(tc-- > 0) {
			int[] parent = new int[200_001];
			int[] net = new int[200_001];
			HashMap<String, Integer> map = new HashMap<>();
			int pplIdx = 1;
			int n = stoi(br.readLine());
			
			Arrays.fill(net, 1);
			for(int i = 1; i <= 200000; i++)
				parent[i] = i;
			
			while(n-- > 0){
				String[] inputArr = br.readLine().split(" ");
				if(!map.containsKey(inputArr[0])) map.put(inputArr[0], pplIdx++);
				if(!map.containsKey(inputArr[1])) map.put(inputArr[1], pplIdx++);
				union(parent, net, map.get(inputArr[0]), map.get(inputArr[1]));
			}
		}
		System.out.println(answer);
	}
	static int find(int[] parent, int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent, parent[x]);
	}
	static void union(int[] parent, int[] net, int x, int y) {
		x = find(parent, x); y = find(parent, y);
		if(x != y) {
			parent[y] = x;
			net[x] += net[y];
			net[y] = 1;
		}
		answer.append(net[x]).append('\n');
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
