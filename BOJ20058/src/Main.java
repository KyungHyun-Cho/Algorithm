import java.io.*;
import java.util.*;

class Point{
	int x, y, cnt;
	Point(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
public class Main {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputArr = br.readLine().split(" ");
		int n = (int)Math.pow(2, stoi(inputArr[0]));
		int q = stoi(inputArr[1]);
		
		int[][] map = new int[n][n];
		for(int i = 0; i < n; i++) {
			inputArr = br.readLine().split(" ");
			for(int j = 0; j < n; j++)
				map[i][j] = stoi(inputArr[j]);
		}
		
		inputArr = br.readLine().split(" ");
		for(String query : inputArr) {
			int L = (int)Math.pow(2, stoi(query));
			Rotate(map, L);
			MeltIce(map);
		}
		
		int sum = 0;
		int biggest = 0;
		boolean[][] visit = new boolean[n][n];
		for(int a = 0; a < n; a++) {
			for(int b = 0; b < n; b++) {
				if(visit[a][b]) continue;
				if(map[a][b] == 0) {
					visit[a][b] = true;
					continue;
				}
				int tmpBig = 0;
				
				Queue<Point> qu = new LinkedList<>();
				qu.add(new Point(a, b, 0));
				visit[a][b] = true;
				while(!qu.isEmpty()) {
					Point p = qu.poll();
					int x = p.x;
					int y = p.y;
					sum += map[x][y];
					tmpBig++;
					for(int i = 0; i < 4; i++) {
						int new_x = x + dir[i][0];
						int new_y = y + dir[i][1];
						if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) continue;
						if(visit[new_x][new_y]) continue;
						visit[new_x][new_y] = true;
						if(map[new_x][new_y] == 0) continue;
						qu.add(new Point(new_x, new_y, p.cnt+1));
					}
				}
				
				biggest = Math.max(biggest, tmpBig);
			}
		}

		System.out.println(sum + "\n" + biggest);
	}
	
	
	
	static void Rotate(int[][] map, int L) {
		int n = map.length;
		for(int i = 0; i < n; i += L) {
			for(int j = 0; j < n; j += L) {
				int x1 = i, x2 = i+L, y1 = j, y2 = j+L;
				int[][] tmpMap = Rotate(map, L, x1, x2, y1, y2);
				for(int x = x1; x < x2; x++) {
					for(int y = y1; y < y2; y++) {
						map[x][y] = tmpMap[x-x1][y-y1];
					}
				}
			}
		}
	}
	static int[][] Rotate(int[][] map, int L, int x1, int x2, int y1, int y2) {
		int[][] ret = new int[L][L];
		for(int i = 0; i < L; i++) {
			for(int j = 0; j < L; j++) {
				ret[i][j] = map[i+x1][j+y1];
			}
		}
		
		for(int i = 0; i < L/2; i++) {
			for(int j = 0; j < L; j++) {
				int tmp = ret[L-i-1][j];
				ret[L-i-1][j] = ret[i][j];
				ret[i][j] = tmp;				
			}
		}
		
		for(int i = 0; i < L; i++) {
			for(int j = i+1; j < L; j++) {
				int tmp = ret[i][j];
				ret[i][j] = ret[j][i];
				ret[j][i] = tmp;
			}				
		}
		return ret;
	}
	static void MeltIce(int[][] map) {
		int n = map.length;
		int[][] tmpMap = new int[n][n];
		
		for(int i = 0; i < n; i++)
			tmpMap[0][i]--;
		for(int i = 0; i < n; i++)
			tmpMap[n-1][i]--;
		for(int i = 0; i < n; i++)
			tmpMap[i][0]--;
		for(int i = 0; i < n; i++)
			tmpMap[i][n-1]--;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					for(int k = 0; k < 4; k++) {
						int new_i = i + dir[k][0];
						int new_j = j + dir[k][1];
						if(new_i < 0 || new_i >= n || new_j < 0 || new_j >= n) continue;
						tmpMap[new_i][new_j]--;
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(tmpMap[i][j] < -1) map[i][j] = Math.max(0,  map[i][j]-1);
			}
		}
	}
	static int stoi(String str) {return Integer.parseInt(str);}

}
