import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	static int[][] map = new int[10][10];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		for(int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 9; j++)
				map[i][j] = stoi(st.nextToken());
		}
		DFS(1,1);
		bw.close();
		br.close();
	}
	public static void DFS(int x, int y) throws IOException{
		if(x == 9 && y == 10) {
			for(int i = 1; i <= 9; i++) {
				for(int j = 1; j <= 9; j++) {
					bw.write(map[i][j] + " ");
				}
				bw.write("\n");
			}
			bw.flush();
			System.exit(0);
			return;
		}else {
			if(y >= 10) {x++; y=1;}
			if(map[x][y] == 0) {
				for(int i = 1; i <= 9 ; i++) {
					if(map[x][y] == 0 && isPossible(x, y, i)) {
						map[x][y] = i;
						DFS(x, y+1);
						map[x][y] = 0;
					}
				}
			}else
				DFS(x, y+1);
		}
		
	}
	public static boolean isPossible(int p, int q, int k) {
		//���� �˻�
		for(int i = 1; i <= 9; i++) 
			if(i != q && map[p][i] == k) return false;
		//���� �˻�
		for(int i = 1; i <= 9; i++) 
			if(i != p && map[i][q] == k) return false;
		//�� ĭ �˻�
		if(p >= 1 && q >= 1 && p <= 3 && q <= 3) {
			for(int i = 1; i <= 3; i++) {
				for(int j = 1; j <= 3; j++) {
					if(i != p && j != q && map[i][j] == k) return false;
				}
			}
		}else if(p >= 1 && q >= 4 && p <= 3 && q <= 6) {
			for(int i = 1; i <= 3; i++) {
				for(int j = 4; j <= 6; j++) {
					if(i != p && j != q && map[i][j] == k) return false;
				}
			}
		}else if(p >= 1 && q >= 7 && p <= 3 && q <= 9) {
			for(int i = 1; i <= 3; i++) {
				for(int j = 7; j <= 9; j++) {
					if(i != p && j != q && map[i][j] == k) return false;
				}
			}
		}else if(p >= 4 && q >= 1 && p <= 6 && q <= 3) {
			for(int i = 4; i <= 6; i++) {
				for(int j = 1; j <= 3; j++) {
					if(i != p && j != q && map[i][j] == k) return false;
				}
			}
		}else if(p >= 4 && q >= 4 && p <= 6 && q <= 6) {
			for(int i = 4; i <= 6; i++) {
				for(int j = 4; j <= 6; j++) {
					if(i != p && j != q && map[i][j] == k) return false;
				}
			}
		}else if(p >= 4 && q >= 7 && p <= 6 && q <= 9) {
			for(int i = 4; i <= 6; i++) {
				for(int j = 7; j <= 9; j++) {
					if(i != p && j != q && map[i][j] == k) return false;
				}
			}
		}else if(p >= 7 && q >= 1 && p <= 9 && q <= 3) {
			for(int i = 7; i <= 9; i++) {
				for(int j = 1; j <= 3; j++) {
					if(i != p && j != q && map[i][j] == k) return false;
				}
			}
		}else if(p >= 7 && q >= 4 && p <= 9 && q <= 6) {
			for(int i = 7; i <= 9; i++) {
				for(int j = 4; j <= 6; j++) {
					if(i != p && j != q && map[i][j] == k) return false;
				}
			}
		}else if(p >= 7 && q >= 9 && p <= 7 && q <= 9) {
			for(int i = 7; i <= 9; i++) {
				for(int j = 7; j <= 9; j++) {
					if(i != p && j != q && map[i][j] == k) return false;
				}
			}
		}
		return true;
		//(3,2) �˻��
		//31, 33, 34, 35, 36...
		//12 22 42 52 62 72 82...
		//���ΰ˻�
		//���ΰ˻�
		//�� ĭ�˻�
	}
	public static int stoi(String str) {return Integer.parseInt(str);}

}
