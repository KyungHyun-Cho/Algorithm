import java.util.*;
public class Main {
	static int r, c, k, now_x=3, now_y=3;
	static int[][] map = new int[100][100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time = 0;
		r = sc.nextInt()-1;
		c = sc.nextInt()-1;
		k = sc.nextInt();
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				map[i][j] = sc.nextInt();
		
		//0초에 끝내는 경우
		if(check()) {
			System.out.println(time);
			return;
		}
		//1초 이상 걸리는 경우
		for(time = 1; time <= 101; time++) {
			if(time == 101) {
				//101초가 되면 -1을 출력
				System.out.println(-1);
				return;
			}else {
				//100초 이하인 경우
				if(now_x >= now_y) //행의갯수 >= 열의갯수인 경우 R연산
					R();
				else  //행의갯수 < 열의갯수인 경우 C연산
					C();
				
				if(check()) {
					System.out.println(time);
					return;
				}
			}
		}
	}
	public static boolean check() {
		if(map[r][c] == k) return true;
		return false;
	}
	public static void R() {
		int max_y = 0;
		for(int i = 0; i < now_x; i++) {
			int[][] tmp = new int[101][2];
			for(int j = 0; j < 101; j++) {
				tmp[j][0] = j;
			}
			for(int j = 0; j < 100; j++) {
				if(map[i][j] != 0) tmp[map[i][j]][1]++;
			}
			for(int j = 0; j < 101; j++)
				if(tmp[j][1] == 0) tmp[j][1] = 999;
			Arrays.sort(tmp, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if(o1[1]==o2[1]) return o1[0]-o2[0];
					return o1[1]-o2[1];
				}				
			});
			int idx = 0, tmp_y = 0;
			
			for(int j = 0; j < 101; j++) {
				if(tmp[j][1] == 999) break;
				map[i][idx++] = tmp[j][0];
				map[i][idx++] = tmp[j][1];
				tmp_y += 2;
			}
			for(; idx < 100; idx++)
				map[i][idx] = 0;
			max_y = Math.max(max_y, tmp_y);
		}
		now_y = Math.max(now_y, max_y);
	}
	public static void C() {
		int max_x = 0;
		for(int i = 0; i < now_y; i++) {
			int[][] tmp = new int[101][2];
			for(int j = 0; j < 101; j++) {
				tmp[j][0] = j;
			}
			for(int j = 0; j < 100; j++) {
				if(map[j][i] != 0) tmp[map[j][i]][1]++;
			}
			for(int j = 0; j < 101; j++)
				if(tmp[j][1] == 0) tmp[j][1] = 999;
			Arrays.sort(tmp, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if(o1[1]==o2[1]) return o1[0]-o2[0];
					return o1[1]-o2[1];
				}				
			});
			int idx = 0, tmp_x = 0;
			for(int j = 0; j < 101; j++) {
				if(tmp[j][1] == 999) break;
				map[idx++][i] = tmp[j][0];
				map[idx++][i] = tmp[j][1];
				tmp_x += 2;
			}
			for(; idx < 100; idx++)
				map[idx][i] = 0;
			max_x = Math.max(max_x, tmp_x);
		}
		now_x = Math.max(now_x, max_x);
	}
	public static void clearMap() {
		for(int[] t : map)
			Arrays.fill(t,  0);
	}
}
