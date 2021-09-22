import java.io.*;
import java.util.*;
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		int score = 0;
		int n = stoi(inputArr[0]);
		int m = stoi(inputArr[1]);
		
		int[][] map = new int[n][n];
		for(int i = 0; i < n; i++) {
			inputArr = br.readLine().split(" ");
			for(int j = 0; j < n; j++)
				map[i][j] = stoi(inputArr[j]);
		}
		
		ArrayList<Point> pointList;
		while((pointList = findNextGroup(map))!= null) {
			score += (pointList.size() * pointList.size());
			remove(map, pointList);
			gravity(map);
			rotate(map);
			gravity(map);
		}
		System.out.println(score);
	}
	
	static void remove(int[][] map, ArrayList<Point> pointList) {
		for(Point p : pointList) {
			map[p.x][p.y] = -99;
		}
	}
	static ArrayList<Point> findNextGroup(int[][] map) {
		ArrayList<ArrayList<Point>> ret = new ArrayList<>();
		int n = map.length;
		int maxRainbowCnt = -1;
		int maxIdx = -1;
		int maxStdX = -1;
		int maxStdY = -1;
		
		boolean[][] globalVisit = new boolean[n][n];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] <= 0) continue;
				if(globalVisit[i][j]) continue;
				int nowIdx = ret.size();
				int nowRainbowCnt = 0;
				
				ret.add(new ArrayList<Point>());
				
				boolean[][] localVisit = new boolean[n][n];
				Queue<Point> q = new LinkedList<>();
				q.add(new Point(i, j));
				globalVisit[i][j] = true;
				while(!q.isEmpty()) {
					Point p = q.poll();
					int x = p.x;
					int y = p.y;
					if(map[x][y] == 0) nowRainbowCnt++;
					ret.get(nowIdx).add(p);
					for(int k = 0; k < 4; k++) {
						int new_x = x + dir[k][0];
						int new_y = y + dir[k][1];
						if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) continue;
						if(map[new_x][new_y] < 0)
							continue;
						else if(map[new_x][new_y] == 0) {
							if(localVisit[new_x][new_y]) continue;
							localVisit[new_x][new_y] = true;
							q.add(new Point(new_x, new_y));
						}else if(map[new_x][new_y] == map[i][j]) {
							if(globalVisit[new_x][new_y]) continue;	
							globalVisit[new_x][new_y] = true;
							q.add(new Point(new_x, new_y));
						}
						
					}
				}
				
				int nowCount = ret.get(nowIdx).size();
				if(nowCount >= 2) {
					if(maxIdx == -1) {
						maxIdx = nowIdx;
						maxRainbowCnt = nowRainbowCnt;
						maxStdX = i;
						maxStdY = j;
					}else if(ret.get(maxIdx).size() < nowCount) {
						maxIdx = nowIdx;
						maxRainbowCnt = nowRainbowCnt;
						maxStdX = i;
						maxStdY = j;
					}else if(ret.get(maxIdx).size() == nowCount) {
						if(maxRainbowCnt < nowRainbowCnt) {
							maxIdx = nowIdx;
							maxRainbowCnt = nowRainbowCnt;
							maxStdX = i;
							maxStdY = j;
						}else if(maxRainbowCnt == nowRainbowCnt) {
							if(maxStdX < i) {
								maxIdx = nowIdx;
								maxRainbowCnt = nowRainbowCnt;
								maxStdX = i;
								maxStdY = j;
								
							}else if(maxStdX == i) {
								if(maxStdY < j) {
									maxIdx = nowIdx;
									maxRainbowCnt = nowRainbowCnt;
									maxStdX = i;
									maxStdY = j;
									
								}
							}
						}
					}
				}
			}			
		}
			
		return maxIdx == -1 ? null : ret.get(maxIdx);
	}
	static void rotate(int[][] map) {
		int n = map.length;
		
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < n; j++) {
				int tmp = map[n-i-1][j];
				map[n-i-1][j] = map[i][j];
				map[i][j] = tmp;				
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = n-i-2; j >= 0; j--) {
				int tmp = map[i][j];
				map[i][j] = map[n-1-j][n-1-i];
				map[n-1-j][n-1-i] = tmp;
			}
		}
	}
	
	static void gravity(int[][] map) {
		int n = map.length;
		for(int k = 0; k < n; k++) {
			for(int i = n-2; i >= 0; i--) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] >= 0 && map[i+1][j] == -99) {
						map[i+1][j] = map[i][j];
						map[i][j] = -99;
					}
				}
			}
		}
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}
