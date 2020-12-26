import java.util.*;
public class Main {
	public static int ret = -1;
	public static boolean[] visit;
	public static ArrayList<Integer>[] arrList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int src = sc.nextInt();
		int dest = sc.nextInt();
		int relationCount = sc.nextInt();
		visit = new boolean[n+1];
		arrList = new ArrayList[n+1];
		for(int i = 0; i <= n; i++)
			arrList[i] = new ArrayList<>();
		for(int i = 0; i < relationCount; i++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			arrList[p].add(q);
			arrList[q].add(p);			
		}
		find(src, dest, 0);
		System.out.println(ret);		
	}
	public static void find(int src, int dest, int depth) {
		if(src == dest)
			ret = depth;
		else {
			for(int next : arrList[src])
				if(!visit[next]) {
					visit[next] = true;
					find(next, dest, depth+1);
				}
		}
	}
}
