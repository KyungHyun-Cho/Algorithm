import java.util.*;
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n, m, answer = Integer.MAX_VALUE;
	static char[][] map;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static HashMap<Integer, Point> bMap = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R') bMap.put(0, new Point(i, j));
				else if(map[i][j] == 'B') bMap.put(1, new Point(i, j));
			}
		}
		
		Stack<Integer> st = new Stack<>();
		DFS(st, 0);
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}else
			System.out.println(answer);
	}
	public static void DFS(Stack<Integer> st, int depth) {
		if(depth == 10) {
			int ret = process(st);
			if(ret != -1) answer = Math.min(answer, ret);
		}else {
			for(int i = 0; i < 4; i++) {
				st.add(i);
				DFS(st, depth + 1);
				st.pop();
			}
		}
	}
	public static int process(Stack<Integer> st) {
		int time = 1;
		char[][] copy_map = new char[n][m];
		HashMap<Integer, Point> copy_bmap = new HashMap<>();
		copyMap(map, copy_map);
		copyBMap(bMap, copy_bmap);
		
		for(int cmd : st) {
			int firstBall = getPriority(cmd, copy_bmap);
			int secondBall = firstBall ^ 1;
			move(firstBall, cmd, copy_map, copy_bmap);
			move(secondBall, cmd, copy_map, copy_bmap);
			if(!copy_bmap.containsKey(1)) {
				//블루구슬이 들어갔다면
				return -1;
			}else if(!copy_bmap.containsKey(0)) {
				//블루구슬은 있고, 레드구슬이 들어갔다면
				return time;
			}
			time++;
		}
		return -1;
	}
	public static void move(int ballIdx, int cmd, char[][] map, HashMap<Integer, Point> bMap) {
		int x = bMap.get(ballIdx).x;
		int y = bMap.get(ballIdx).y;
		map[x][y] = '.';
		while(true) {
			x += dir[cmd][0];
			y += dir[cmd][1];
			if(map[x][y] != '.') {
				//길이 아니면
				if(map[x][y] == 'O') {
					//구멍을 만났다면
					bMap.remove(ballIdx);
					return;
				}
				//빠꾸
				x -= dir[cmd][0];
				y -= dir[cmd][1];
				map[x][y] = ballIdx == 0? 'R' : 'B';
				bMap.put(ballIdx, new Point(x, y));				
				return;
			}		
		}
	}
	public static int getPriority(int cmd, HashMap<Integer, Point> bMap) {
		int red_x = bMap.get(0).x;
		int red_y = bMap.get(0).y;
		int blue_x = bMap.get(1).x;
		int blue_y = bMap.get(1).y;
		int ret = -1;
		if(cmd == 0) { //상
			ret = blue_x < red_x ? 1 : 0;
		}else if(cmd == 1) { //하
			ret = blue_x > red_x ? 1 : 0;
		}else if(cmd == 2) { //좌
			ret = blue_y < red_y ? 1 : 0;
		}else if(cmd == 3) { //우
			ret = blue_y > red_y ? 1 : 0;
		}
		return ret;
	}
	public static void copyMap(char[][] src, char[][] dest) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				dest[i][j] = src[i][j];
			}
		}
	}
	public static void copyBMap(HashMap<Integer, Point> src, HashMap<Integer, Point> dest) {
		for(int key : src.keySet()) {
			dest.put(key, new Point(src.get(key).x, src.get(key).y));
		}
	}
}
