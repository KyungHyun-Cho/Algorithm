import java.util.*;
import java.io.*;
class Cmd{
	int x, y, s;
	Cmd(int x, int y, int s){
		this.x = x;
		this.y = y;
		this.s = s;
	}
}
public class Main {
	static int n, m, k, answer = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<Cmd> cmd_list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());		
		k = stoi(st.nextToken());
		map = new int[n][m];
		boolean[] visit = new boolean[k];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = stoi(st.nextToken()) - 1;
			int c = stoi(st.nextToken()) - 1;
			int s = stoi(st.nextToken());
			cmd_list.add(new Cmd(r,c,s));
		}
		//rotate(map, 2,3,2);
		//rotate(map, 3,1,1);
		
		Stack<Integer> stk = new Stack<>();
		DFS(stk, visit, 0);
		bw.write(answer + "");
		bw.flush();		
		br.close();
		bw.close();
	}
	public static void DFS(Stack<Integer> st, boolean[] visit, int depth) {
		if(depth == k) {
			Cmd cmd = null;
			int[][] tmp_map = new int[n][m];
			copyMap(map, tmp_map);
			for(int i : st) {
				cmd = cmd_list.get(i);
				rotate(tmp_map, cmd.x, cmd.y, cmd.s);
			}
			for(int i = 0; i < n; i++) {
				int sum = 0;
				for(int j = 0; j < m; j++) {
					sum += tmp_map[i][j];
				}
				answer = Math.min(answer, sum);
			}
		}else {
			for(int i = 0; i < k; i++) {
				if(!visit[i]) {
					visit[i] = true;
					st.add(i);
					DFS(st, visit, depth + 1);
					st.pop();
					visit[i] = false;
				}
			}
		}
	}
	public static void rotate(int[][] map, int x, int y, int s) {
		for(int i = 1; i <= s; i++) {
			int tmp_x = x-i;
			int tmp_y = y-i;
			int tmp = map[tmp_x][tmp_y];
			int len = 2*i;
			for(int p = 0; p < len; p++) map[tmp_x+p][tmp_y] = map[tmp_x+p+1][tmp_y];
			for(int p = 0; p < len; p++) map[tmp_x+len][tmp_y+p] = map[tmp_x+len][tmp_y+p+1];
			for(int p = 0; p < len; p++) map[tmp_x+len-p][tmp_y+len] = map[tmp_x+len-p-1][tmp_y+len];
			for(int p = 0; p < len; p++) {
				if(tmp_y+len-p-1 == tmp_y) {
					map[tmp_x][tmp_y+len-p] = tmp;
				}else {
					map[tmp_x][tmp_y+len-p] = map[tmp_x][tmp_y+len-p-1];
				}
			}
		}
	}
	public static void copyMap(int[][] src, int[][] dest) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				dest[i][j] = src[i][j];
			}
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
