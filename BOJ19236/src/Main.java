import java.util.*;
class Info{
	int fishSize, dir;
	Info(int fishSize, int dir){
		this.fishSize = fishSize;
		this.dir = dir;
	}
}
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int[][] dir = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Info[][] map = new Info[4][4];
		HashMap<Integer, Point> fishNum = new HashMap<>();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				int fishSize = sc.nextInt();
				int dir = sc.nextInt()-1;
				fishNum.put(fishSize, new Point(i, j));
				map[i][j] = new Info(fishSize, dir);
			}
		}
		//상어 위치 추가
		fishNum.put(-1, new Point(0, 0));
		int answer = DFS(map, fishNum, 0, 0, 0);
		System.out.println(answer);
		
	}
	public static int DFS(Info[][] map, HashMap<Integer, Point> fishNum, int x, int y, int sum) {
		//물고기 이동
		//상어 이동
		//현재 위치에 존재하는 물고기를 먹음
		sum += map[x][y].fishSize; // 물고기 크기를 더함
		fishNum.put(map[x][y].fishSize, new Point(-1, -1)); // 먹힌 물고기의 방을 비움
		map[fishNum.get(-1).x][fishNum.get(-1).y].fishSize = 0;//기존에 상어가 있던 위치를 빈칸으로 만듦
		fishNum.put(-1, new Point(x, y)); //상어 위치 변경
		map[x][y].fishSize = -1; // 상어 위치 변경
		
		Info[][] copy_map = new Info[4][4];
		HashMap<Integer, Point> copy_fishNum = new HashMap<>();
		ArrayList<Point> available_map = new ArrayList<>();		

		
		//물고기 이동
		moveFish(map, fishNum);
		
		//상어가 먹을 수 있는 먹이 위치 구함
		get_feed(map, fishNum, available_map);
		int max_sum = 0;
		if(available_map.size() == 0) {
			return sum;
		}else {
			//상어가 먹이를 먹고 이동
			for(int i = 0; i < available_map.size(); i++) {
				copyArr(map, copy_map);
				copyMap(fishNum, copy_fishNum);
				max_sum = Math.max(max_sum, DFS(copy_map, copy_fishNum, available_map.get(i).x, available_map.get(i).y, sum));				
			}
		}
		
		return max_sum;
	}
	public static void get_feed(Info[][] map, HashMap<Integer, Point> fishNum, ArrayList<Point> available_map) {
		Point shark = fishNum.get(-1);
		int sharkDir = map[shark.x][shark.y].dir;
		int new_x = shark.x + dir[sharkDir][0];
		int new_y = shark.y + dir[sharkDir][1];
		while(new_x >= 0 && new_y >= 0 && new_x < 4 && new_y < 4) {
			if(map[new_x][new_y].fishSize != 0)
				available_map.add(new Point(new_x, new_y));
			new_x = new_x + dir[sharkDir][0];
			new_y = new_y + dir[sharkDir][1];
		}
	}
	public static void moveFish(Info[][] map, HashMap<Integer, Point> fishNum) {
		for(int i = 1; i <= 16; i++) {
			if(fishNum.get(i).x != -1) {
				//존재하는 물고기이면
				
				Point p = fishNum.get(i);				
				Info info = map[p.x][p.y];
				//물고기의 새로운 좌표 구함
				int new_x = p.x + dir[info.dir][0];
				int new_y = p.y + dir[info.dir][1];
				
				//그곳이 갈 수 있는 곳이 될 때까지 회전
				while(!possible(map, new_x, new_y)) {
					info.dir = (info.dir+1) % 8;
					new_x = p.x + dir[info.dir][0];
					new_y = p.y + dir[info.dir][1];
				}
				//회전을 완료했다면 위치 변경
				fishSwap(map, fishNum, new Point(p.x, p.y), new Point(new_x, new_y));
			}
		}
	}
	public static void fishSwap(Info[][] map, HashMap<Integer, Point> fishNum, Point src, Point dest) {		
		//목적지가 빈 곳이라면 물고기를 그냥 이동
		if(map[dest.x][dest.y].fishSize == 0) {
			map[dest.x][dest.y].fishSize = map[src.x][src.y].fishSize;
			map[dest.x][dest.y].dir = map[src.x][src.y].dir;
			map[src.x][src.y].fishSize = 0;
			map[src.x][src.y].dir = -1;
			fishNum.put(map[dest.x][dest.y].fishSize, new Point(dest.x,dest.y));
		}else {
			//목적지에 다른 물고기가 있다면 서로의 위치를 변경
			int tmp_fishSize = map[dest.x][dest.y].fishSize;
			int tmp_dir = map[dest.x][dest.y].dir;
			map[dest.x][dest.y].fishSize = map[src.x][src.y].fishSize;
			map[dest.x][dest.y].dir = map[src.x][src.y].dir;
			map[src.x][src.y].fishSize = tmp_fishSize;
			map[src.x][src.y].dir = tmp_dir;
			fishNum.put(map[src.x][src.y].fishSize, new Point(src.x,src.y));
			fishNum.put(map[dest.x][dest.y].fishSize, new Point(dest.x,dest.y));
		}
	}
	public static boolean possible(Info[][] map, int x, int y) {
		if(x < 0 || y < 0 || x > 3 || y > 3) {
			return false;
		}else {
			if(map[x][y].fishSize == -1)
				return false;
		}
		
		return true;
	}
	public static void copyArr(Info[][] src, Info[][] dest) {
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				dest[i][j] = new Info(src[i][j].fishSize, src[i][j].dir);
	}
	public static void copyMap(HashMap<Integer, Point> src, HashMap<Integer, Point> dest) {
		for(int k : src.keySet()) {
			dest.put(k, new Point(src.get(k).x, src.get(k).y));
		}
	}
}
