import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; //»óÇÏÁÂ¿ì
	static int n;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			char[] chr = str.toCharArray();
			for(int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		ArrayList<Integer> resultList = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					cnt = 0;
					dfs(i,j);
					resultList.add(cnt);
				}
			}
		}
		
		System.out.println(resultList.size());
		Collections.sort(resultList);
		for(int n : resultList)
			System.out.println(n);
	}
	
	public static void dfs(int p, int q) {
		visit[p][q] = true;
		cnt++;
		for(int i = 0; i < dir.length; i++) {
			int newp = p+dir[i][0];
			int newq = q+dir[i][1];
			if(newp >= 0 && newp < n && newq >= 0 && newq < n && map[newp][newq] == 1 && !visit[newp][newq]) {
				dfs(newp,newq);
			}
		}
	}
}
