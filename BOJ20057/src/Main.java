import java.util.*;
import java.io.*;
public class Main {
	static int n, x, y, answer = 0;
	static int[][] map;
	static int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // 서 남 동 북 (토네이도 방향)
	static int[][][] percentMap = {
			{{-1, -1, 2, -1, -1},
			{-1, 10, 7, 1, -1},
			{5, -1, -1, -1, -1},
			{-1, 10, 7, 1, -1},
			{-1, -1, 2, -1, -1}},
			
			{{-1, -1, -1, -1, -1},
			 {-1, 1, -1, 1, -1},
			 {2, 7, -1, 7, 2},
			 {-1, 10, -1, 10, -1},
			 {-1, -1, 5, -1, -1}},
			
			{{-1, -1, 2, -1, -1},
			 {-1, 1, 7, 10, -1},
			 {-1, -1, -1, -1, 5},
			 {-1, 1, 7, 10, -1},
			 {-1, -1, 2, -1, -1}},
			
			{{-1, -1, 5, -1, -1},
			 {-1, 10, -1, 10, -1},
			 {2, 7, -1, 7, 2},
			 {-1, 1, -1, 1, -1},
			 {-1, -1, -1, -1, -1}}						
			};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		x = y = n/2;
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			String[] inputArr = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j] = stoi(inputArr[j]);
			}
		}
		
		int totalMoveCnt = 1;
		int moveDir = 0;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < 2; j++) {
				for(int nowMoveCnt = 0; nowMoveCnt < totalMoveCnt; nowMoveCnt++) {
					Spin(moveDir, x, y);
					x += dir[moveDir][0];
					y += dir[moveDir][1];
				}
				moveDir = (moveDir + 1) % 4;
			}
			totalMoveCnt++;
		}
		
		for(int i = n-1; i > 0; i--) {
			Spin(0, 0, i);
		}
		System.out.println(answer);
	}
	
	public static void Spin(int moveDir, int x, int y) {
		int[][] calculatedMap = new int[5][5];
		int totalCnt = map[x+dir[moveDir][0]][y+dir[moveDir][1]];
		int usingCnt = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(percentMap[moveDir][i][j] < 0){
					calculatedMap[i][j] = -1;
				}else {
					calculatedMap[i][j] = totalCnt * percentMap[moveDir][i][j] / 100;
					usingCnt += calculatedMap[i][j];
				}
			}
		}
		calculatedMap[2+dir[moveDir][0]][2+dir[moveDir][1]] = totalCnt - usingCnt;
		calculatedMap[2][2] = map[x][y];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				int real_x = makeRealX(moveDir, x) + i;
				int real_y = makeRealY(moveDir, y) + j;
				if((real_x < 0 || real_y < 0 || real_x >= n || real_y >= n)) {
					if(calculatedMap[i][j] > 0)
						answer += calculatedMap[i][j];
				}else if(calculatedMap[i][j] != -1){
					map[real_x][real_y] += calculatedMap[i][j];
				}
			}
		}
		map[x+dir[moveDir][0]][y+dir[moveDir][1]] = map[x][y];
	}
	static int makeRealX(int moveDir, int x) {			
		if(moveDir == 1)
			return x-1;
		else if(moveDir == 3)
			return x-3;
		else
			return x-2;
	}
	static int makeRealY(int moveDir, int y) {			
		//0: -3, 1: -2 2: -1, 3:-2
		if(moveDir == 0)
			return y-3;
		else if(moveDir == 2)
			return y-1;
		else
			return y-2;
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}