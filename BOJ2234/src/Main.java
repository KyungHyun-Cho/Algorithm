import java.util.*;
import java.io.*;
class MapInfo{
	int mapSize;
	HashSet<Integer> connectedMapList;
	MapInfo(int mapSize){
		this.mapSize = mapSize;
		connectedMapList = new HashSet<>();
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
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; // 문제의 Shift연산에 따라 서/북/동/남	
	static int[][] map, mapNumber;
	static boolean[][] visit;
	static HashMap<Integer, MapInfo> mapInfo = new HashMap<>();
	static int maxX, maxY, mapNo = 1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		maxY = stoi(inputArr[0]);
		maxX = stoi(inputArr[1]);		
		map = new int[maxX][maxY];
		mapNumber = new int[maxX][maxY];
		visit = new boolean[maxX][maxY];
		
		for(int i = 0; i < maxX; i++) {
			inputArr = br.readLine().split(" ");
			for(int j = 0; j < maxY; j++) {
				map[i][j] = stoi(inputArr[j]);
			}
		}
		
		for(int x = 0; x < maxX; x++) {
			for(int y = 0; y < maxY; y++) {
				if(visit[x][y]) continue;
				BFS(x, y);
				mapNo++;
			}
		}
		
		int maxSingleRoomSize = 0, maxDoubleRoomSize = 0;
		for(int roomNo : mapInfo.keySet()) {
			maxSingleRoomSize = Math.max(maxSingleRoomSize, mapInfo.get(roomNo).mapSize);
			for(int connectedRoomNo : mapInfo.get(roomNo).connectedMapList)
				maxDoubleRoomSize = Math.max(maxDoubleRoomSize, mapInfo.get(roomNo).mapSize + mapInfo.get(connectedRoomNo).mapSize);			
		}
		System.out.println(mapInfo.size()); // 전체 방의 개수
		System.out.println(maxSingleRoomSize); // 방의 최대 크기
		System.out.println(maxDoubleRoomSize); // 방을 하나 부쉈을 때 최대 크기
		
	}
	static void BFS(int baseX, int baseY) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(baseX, baseY));
		visit[baseX][baseY] = true;
		mapInfo.put(mapNo, new MapInfo(1));
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			mapNumber[x][y] = mapNo;
			for(int i = 0; i < 4; i++) {
				int new_x = x + dir[i][0];
				int new_y = y + dir[i][1];
				if(new_x < 0 || new_y < 0 || new_x >= maxX || new_y >= maxY) continue; // 맵의 범위를 벗어나는 경우
				// 벽으로 막혀있는 경우
				if(isWall(map[x][y], i)){
					// 그곳에 이미 방번호가 부여됐으면, 상호 연결되어있다고 표시
					if(mapNumber[new_x][new_y] != 0 && mapNumber[new_x][new_y] != mapNo) {
						mapInfo.get(mapNo).connectedMapList.add(mapNumber[new_x][new_y]);
						mapInfo.get(mapNumber[new_x][new_y]).connectedMapList.add(mapNo);						
					}
				}
				// 벽으로 막혀있지 않은 경우
				else {
					if(visit[new_x][new_y]) continue; // 이미 방문한 경우
					q.add(new Point(new_x, new_y));
					mapInfo.get(mapNo).mapSize++;
					visit[new_x][new_y] = true;
				}
			}
		}
	}
	static boolean isWall(int roomCondition, int i) {
		// i == {0: 서, 1: 북, 2: 동, 3: 남}		
		return (roomCondition & (1 << i)) != 0;
	}
	
	static int stoi(String str) {return Integer.parseInt(str);}
}
