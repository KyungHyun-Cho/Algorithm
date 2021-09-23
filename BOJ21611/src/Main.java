import java.util.*;
import java.io.*;

class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n, m, answer = 0;
	static int[][] destroyDir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] moveDir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	static ArrayList<Point> seqList = new ArrayList<Point>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Input
		String[] inputArr = br.readLine().split(" ");		
		n = stoi(inputArr[0]);
		m = stoi(inputArr[1]);
		
		// Initialize
		int[][] map = new int[n][n];
		for(int i = 0; i < n; i++) {
			inputArr = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j] = stoi(inputArr[j]);
			}
		}
		makeSeqList(seqList);
		
		//explosion(map);
		//System.out.println("BP");
		//move(map);
		//System.out.println("BP");
		// Query
		for(int queryIdx = 0; queryIdx < m; queryIdx++) {
			inputArr = br.readLine().split(" ");
			int d = stoi(inputArr[0])-1;
			int s = stoi(inputArr[1]);
			
			destroy(map, d, s);
			move(map);
			while(explosion(map)) {
				move(map);
			}
			map = grouping(map);
		}
		System.out.println(answer);
	}
	
	static void destroy(int[][] map, int d, int s) {
		int x = n/2;
		int y = n/2;
		
		for(int i = 0; i < s; i++) {
			x += destroyDir[d][0];
			y += destroyDir[d][1];
			map[x][y] = 0;
		}
	}
	
	static void move(int[][] map) {
		int now = 1, find = 1;
		
		while(find < n*n) {
			Point nowPoint = seqList.get(now);
			Point findPoint = seqList.get(find);
			int nowValue = map[nowPoint.x][nowPoint.y];
			int findValue = map[findPoint.x][findPoint.y];
			
			if(nowValue == 0 && findValue == 0) {
				find++;
			}else if(nowValue == 0 && findValue != 0) {
				map[nowPoint.x][nowPoint.y] = map[findPoint.x][findPoint.y];
				map[findPoint.x][findPoint.y] = 0;
				now++;
				find++;
			}else if(nowValue != 0 && findValue == 0) {
				//now++;
				find++;
			}else if(nowValue != 0 && findValue != 0) {
				if(now == find) find++;
				now++;
			}
		}
	}
	
	static boolean explosion(int[][] map) {
		boolean ret = false;
		ArrayList<Point> explosionList = new ArrayList<Point>();
		explosionList.add(seqList.get(1));
		int prevNum = map[seqList.get(1).x][seqList.get(1).y];
		int lastNum = map[seqList.get(1).x][seqList.get(1).y];
		for(int i = 2; i < n*n; i++) {
			Point nowPoint = seqList.get(i);
			int nowNum = map[nowPoint.x][nowPoint.y];
			if(nowNum == 0) break;
			lastNum = nowNum;
			if(nowNum != prevNum) {
				if(explosionList.size() >= 4) {
					ret = true;
					for(Point p : explosionList) {
						answer += map[p.x][p.y];
						map[p.x][p.y] = 0;
					}
				}
				explosionList.clear();
				explosionList.add(nowPoint);
				prevNum = nowNum;
			}else {
				explosionList.add(nowPoint);
			}
		}
		
		// 잔여 구슬 처리
		if(explosionList.size() >= 4) {
			if(lastNum <= 0)
				System.out.println(0/0);
			ret = true;
			for(Point p : explosionList) {
				answer += map[p.x][p.y];
				map[p.x][p.y] = 0;
			}
		}
		
		return ret;
	}
	
	static int[][] grouping(int[][] map) {
		int[][] newMap = new int[n][n];
		int newMapIdx = 0;
		int groupCnt = 1;
		int prevNum = map[seqList.get(1).x][seqList.get(1).y];
		int lastNum = map[seqList.get(1).x][seqList.get(1).y];
		
		if(prevNum == 0) return newMap;
		
		for(int i = 2; i < n*n; i++) {
			Point nowPoint = seqList.get(i);
			int nowNum = map[nowPoint.x][nowPoint.y];
			if(nowNum == 0) break;
			lastNum = nowNum;
			if(nowNum != prevNum) {
				if(++newMapIdx >= n*n) break; // 구슬의 개수가 전체 맵 개수를 넘어가는 경우 for문 종료
				newMap[seqList.get(newMapIdx).x][seqList.get(newMapIdx).y] = groupCnt;
				if(++newMapIdx >= n*n) break; // 구슬의 개수가 전체 맵 개수를 넘어가는 경우 for문 종료
				newMap[seqList.get(newMapIdx).x][seqList.get(newMapIdx).y] = prevNum;
				groupCnt = 1;
				prevNum = nowNum;
			}else {
				groupCnt++;
			}
		}
		
		// 잔여 구슬 처리
		if(++newMapIdx >= n*n) return newMap; // 구슬의 개수가 전체 맵 개수를 넘어가는 경우 for문 종료
		newMap[seqList.get(newMapIdx).x][seqList.get(newMapIdx).y] = groupCnt;
		if(++newMapIdx >= n*n) return newMap; // 구슬의 개수가 전체 맵 개수를 넘어가는 경우 for문 종료
		newMap[seqList.get(newMapIdx).x][seqList.get(newMapIdx).y] = lastNum;
		
		return newMap;
	}
	
	static void makeSeqList(ArrayList<Point> seqList) {
		int x = n/2;
		int y = n/2;
		int dir = 0;
		// n: 3 -> i: 5
		// n: 5 -> i: 9
		// n: 7 -> i: 13
		// n: k -> i: 2*k-1
		for(int i = 0; i < 2*n-1; i++) {
			// 01 23 45 67 89 1011
			// 11 22 33 44 55 66...
			for(int j = 0; j < (i/2) + 1; j++) {
				seqList.add(new Point(x, y));
				x += moveDir[dir][0];
				y += moveDir[dir][1];
			}
			dir = (dir + 1) % 4;
		}
		
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}
