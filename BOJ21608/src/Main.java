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
	static HashMap<Integer, Point> pointPerSID = new HashMap<>();
	static LinkedHashMap<Integer, HashSet<Integer>> likePerSID = new LinkedHashMap<>();
	static int[][] map, remainSitMap;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		map = new int[n][n];
		
		InitRemainSitMap();
		
		for(int i = 0; i < n*n; i++) {
			String[] inputArr = br.readLine().split(" ");
			int sID = stoi(inputArr[0]);
			HashSet<Integer> likeSet = new HashSet<>();
			likeSet.add(stoi(inputArr[1]));
			likeSet.add(stoi(inputArr[2]));
			likeSet.add(stoi(inputArr[3]));
			likeSet.add(stoi(inputArr[4]));
			
			likePerSID.put(sID, likeSet);
		}
		
		for(int sID : likePerSID.keySet()) {
			Point p = FindBestSit(sID);
			pointPerSID.put(sID, p);
			map[p.x][p.y] = sID;
			remainSitMap[p.x][p.y] = -1;
			for(int i = 0; i < 4; i++) {
				int new_x = p.x + dir[i][0];
				int new_y = p.y + dir[i][1];
				if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) continue;					
				remainSitMap[new_x][new_y]--;
			}
		}
		
		// 점수 구하기
		int answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int sID = map[i][j];
				int likeCnt = 0;
				HashSet<Integer> likeSet = likePerSID.get(sID);
				for(int k = 0; k < 4; k++) {
					int new_x = i + dir[k][0];
					int new_y = j + dir[k][1];
					if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) continue;					
					if(likeSet.contains(map[new_x][new_y])) likeCnt++;
				}
				if(likeCnt == 1) answer += 1;
				else if(likeCnt == 2) answer += 10;
				else if(likeCnt == 3) answer += 100;
				else if(likeCnt == 4) answer += 1000;
				
			}
		}
		System.out.println(answer);
	}
	static Point FindBestSit(int sID) {		
		int[][] tmpMap = new int[n][n];
		HashSet<Integer> likeSet = likePerSID.get(sID);
		Point ret = new Point(-1, -1);
		int maxNextLike = -1;
		int maxEmptyNextLike = -1;
		// 임시 맵에, 해당 위치에 앉으면 몇 명의 좋아하는 학생과 앉을 수 있는지 기록
		for(int likeSID : likeSet) {
			if(pointPerSID.containsKey(likeSID)) {
				Point p = pointPerSID.get(likeSID);
				for(int i = 0; i < 4; i++) {
					int new_x = p.x + dir[i][0];
					int new_y = p.y + dir[i][1];
					if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) continue;
					if(remainSitMap[new_x][new_y] < 0) continue; // 이미 앉은 자리면 PASS
					tmpMap[new_x][new_y]++;
					maxNextLike = Math.max(maxNextLike, tmpMap[new_x][new_y]);
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(tmpMap[i][j] > maxNextLike) {
					maxNextLike = tmpMap[i][j];
					maxEmptyNextLike = remainSitMap[i][j];
					ret.x = i;
					ret.y = j;
				}else if(tmpMap[i][j] == maxNextLike) {
					if(remainSitMap[i][j] > maxEmptyNextLike) {
						maxEmptyNextLike = remainSitMap[i][j];
						ret.x = i;
						ret.y = j;
					}
				}
			}
		}
		
		
		return ret;		
	}
	static void InitRemainSitMap() {
		remainSitMap = new int[n][n];
		
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < n; j++)
				remainSitMap[i][j] = 4;
		for(int i = 0; i < n; i++)
			remainSitMap[0][i]--;
		for(int i = 0; i < n; i++)
			remainSitMap[i][0]--;
		for(int i = 0; i < n; i++)
			remainSitMap[n-1][i]--;
		for(int i = 0; i < n; i++)
			remainSitMap[i][n-1]--;		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
