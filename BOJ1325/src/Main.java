import java.util.*;
import java.io.*;
public class Main {
	public static ArrayList<Integer>[] map;
	public static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = stoi(str[0]);
		int m = stoi(str[1]);
		int max = Integer.MIN_VALUE;
		map = new ArrayList[n+1];
		visit = new boolean[n+1];
		int[] hackingCnt = new int[n+1];
		for(int i = 0; i <= n; i++)
			map[i] = new ArrayList<>();
		for(int i = 0; i < m;i++) {
			str = br.readLine().split(" ");
			int p = stoi(str[0]);
			int q = stoi(str[1]);
			map[q].add(p);
		}
		for(int i = 1; i <= n; i++) {
			Arrays.fill(visit, false);
			if(i == 5)
				System.out.println("BP");
			hackingCnt[i] = find(i, 0);
			max = Math.max(max, hackingCnt[i]);
		}
		for(int i = 1; i <= n; i++)
			if(max == hackingCnt[i]) System.out.print(i + " ");
	}
	public static int find(int idx, int cnt) {
		visit[idx] = true;
		int sum = 0;
		if(map[idx].isEmpty()) return cnt;
		boolean allVisit = false;
		for(int i : map[idx]) {
			if(!visit[i]) {
				sum += find(i, cnt+1);
				allVisit = true;
			}
		}
		if(allVisit) return cnt;
		return sum;
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
