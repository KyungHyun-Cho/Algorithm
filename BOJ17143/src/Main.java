import java.util.*;

import javax.swing.text.ChangedCharSetException;
class Info{
	int x, y, dir, size, speed;
	Info(int x, int y, int speed, int dir, int size){
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.size = size;
		this.speed = speed;
	}
}
public class Main {
	static int n, m, sum = 0;
	static int[][] map;
	static HashMap<Integer, Info> sharkInfo = new HashMap<>();
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int k = sc.nextInt();
		if(k == 0) {
			System.out.println(0);
			return;
		}
		map = new int[n][m];
		for(int i = 1; i <= k; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int s = sc.nextInt();
			int d = sc.nextInt()-1;
			int z = sc.nextInt();
			map[x][y] = i;
			sharkInfo.put(i, new Info(x, y, s, d, z));
		}
		
		for(int i = 0; i < m; i++) {
			getShark(i);
			moveShark();
		}
		System.out.println(sum);
	}
	public static void getShark(int idx) {
		Info shark = null;
		int sharkIdx = -1;
		for(int i = 0; i < n; i++) {
			if(map[i][idx] != 0) {
				sharkIdx = map[i][idx];
				shark = sharkInfo.get(sharkIdx);				
				break;
			}
		}
		if(sharkIdx != -1) {
			sum += shark.size;
			removeShark(sharkIdx);
		}
	}
	public static void moveShark() {
		HashMap<Integer, Info> new_loc = new HashMap<>();
		for(int sharkIdx : sharkInfo.keySet()) {
			Info shark = sharkInfo.get(sharkIdx);
			map[shark.x][shark.y] = 0; // 일단 맵에서 지움
			int wall_diff = -1;
			int new_x = -1, new_y = -1;
			if(shark.dir == 0) 
				wall_diff = shark.x;
			else if(shark.dir == 1) 
				wall_diff = n - shark.x - 1;
			else if(shark.dir == 3) 
				wall_diff = shark.y;
			else if(shark.dir == 2) 
				wall_diff = m - shark.y - 1;
			
			if(wall_diff >= shark.speed) {
				new_x = shark.x + dir[shark.dir][0] * shark.speed;
				new_y = shark.y + dir[shark.dir][1] * shark.speed;				
			}else {
				new_x = shark.x;
				new_y = shark.y;
				int tmp = shark.speed - wall_diff - 1;
				int tmp_diff = 0;
				boolean v = false;
				if(shark.dir == 0 || shark.dir == 1) {
					//상하이동
					tmp_diff = n-1;
					v = true;
				}else if(shark.dir == 2 || shark.dir == 3) {
					//좌우이동
					tmp_diff = m-1;
					v = false;
				}
				if((tmp / tmp_diff) % 2 == 0) 
					turnShark(sharkIdx);
				if(v) {
					//new_x를 조정
					if(shark.dir == 0) {
						new_x = tmp_diff - (tmp % tmp_diff) - 1;
					}else {
						new_x = (tmp % tmp_diff) + 1;
					}
				}else {
					//new_y를 조정
					if(shark.dir == 3) {
						new_y = tmp_diff - (tmp % tmp_diff) - 1;
					}else {
						new_y = (tmp % tmp_diff) + 1;
					}
				}
			}
			
			new_loc.put(sharkIdx, new Info(new_x, new_y, shark.speed, shark.dir, shark.size));
		}
		for(int sharkIdx : new_loc.keySet()) {
			Info shark = new_loc.get(sharkIdx);
			Info prevShark = sharkInfo.get(sharkIdx);
			if(map[shark.x][shark.y] == 0) {
				//맵에 없다면
				map[shark.x][shark.y] = sharkIdx;
				prevShark.x = shark.x;
				prevShark.y = shark.y;				
			}else {
				//이미 상어가 있다면
				int existSharkIdx = map[shark.x][shark.y];
				Info existShark = sharkInfo.get(existSharkIdx);
				if(shark.size > existShark.size) {
					//새로운 상어가 더 크다면
					sharkInfo.remove(existSharkIdx);
					map[shark.x][shark.y] = sharkIdx;
					prevShark.x = shark.x;
					prevShark.y = shark.y;	
				}else {
					//기존 상어가 더 크다면
					sharkInfo.remove(sharkIdx);
					map[shark.x][shark.y] = existSharkIdx;
				}
			}
		}
	}
	public static void turnShark(int sharkIdx) {
		Info shark = sharkInfo.get(sharkIdx);
		if(shark.dir == 0)
			shark.dir = 1;
		else if(shark.dir == 1)
			shark.dir = 0;
		else if(shark.dir == 2)
			shark.dir = 3;
		else if(shark.dir == 3)
			shark.dir = 2;
	}
	public static void removeShark(int sharkIdx) {
		Info shark = sharkInfo.get(sharkIdx);
		map[shark.x][shark.y] = 0;
		sharkInfo.remove(sharkIdx);
	}
}
