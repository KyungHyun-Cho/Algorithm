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
	static int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
	static int n, m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		n = stoi(inputArr[0]);
		m = stoi(inputArr[1]);
		int[][] map = new int[n][n];
		
		// Initialize
		ArrayList<Point> cloudList = new ArrayList<Point>();
		cloudList.add(new Point(n-1, 0));
		cloudList.add(new Point(n-1, 1));
		cloudList.add(new Point(n-2, 0));
		cloudList.add(new Point(n-2, 1));
		
		// Input
		for(int i = 0; i < n; i++) {
			inputArr = br.readLine().split(" ");
			for(int j = 0; j < n; j++)
				map[i][j] = stoi(inputArr[j]);
		}
		
		//move(cloudList, 1, 3);
		
		// Query
		for(int queryIdx = 0; queryIdx < m; queryIdx++) {
			inputArr = br.readLine().split(" ");
			int d = stoi(inputArr[0]) - 1;
			int s = stoi(inputArr[1]);
			
			move(cloudList, d, s);
			rain(map, cloudList);
			copy(map, cloudList);
			resetCloudList(map, cloudList);
		}		
		
		System.out.println(sum(map));
	}
	
	static int sum(int[][] map) {
		int ret = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				ret += map[i][j];
		
		return ret;
	}
	static void move(ArrayList<Point> cloutList, int d, int s) {
		for(Point p : cloutList) {
			p.x = (((p.x + dir[d][0]*s) % n) + n) % n;
			p.y = (((p.y + dir[d][1]*s) % n) + n) % n;			
		}
	}
	
	static void rain(int[][] map, ArrayList<Point> cloudList) {
		for(Point p : cloudList) {
			map[p.x][p.y]++;
		}
	}
	
	static void copy(int[][] map, ArrayList<Point> cloudList) {
		HashMap<Point, Integer> addWaterPerPoint = new HashMap<Point, Integer>();
		for(Point p : cloudList) {
			int addCnt = 0;
			for(int i = 1; i <= 8; i += 2) {
				int new_x = p.x + dir[i][0];
				int new_y = p.y + dir[i][1];
				if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) continue;
				if(map[new_x][new_y] > 0) addCnt++;
			}
			if(addCnt > 0)
				addWaterPerPoint.put(p, addCnt);
		}
		
		for(Point p : addWaterPerPoint.keySet()) {
			map[p.x][p.y] += addWaterPerPoint.get(p);
		}
	}
	
	static void resetCloudList(int[][] map, ArrayList<Point> cloudList){
		boolean[][] originMap = new boolean[n][n];
		for(Point p : cloudList)
			originMap[p.x][p.y] = true;
		
		cloudList.clear();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] >= 2 && !originMap[i][j]) {
					map[i][j] -= 2;
					cloudList.add(new Point(i, j));
				}
			}
		}
	}
	
	static int stoi(String str) {return Integer.parseInt(str);}
}
