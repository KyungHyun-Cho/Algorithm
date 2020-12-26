import java.util.*;
class Command{
	int loc, dir;
	Command(int loc, int dir){
		this.loc = loc;
		this.dir = dir;
	}
}
public class Main {
	static int U,D,F,B,L,R;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		for(int tc = 0; tc < k; tc++) {
			int n = sc.nextInt();			
			U=0; D=1; F=2; B=3; L=4; R=5;
			char[][][] map = {{{'w','w','w'}, {'w','w','w'}, {'w','w','w'}},
							{{'y','y','y'}, {'y','y','y'}, {'y','y','y'}},
							{{'r','r','r'}, {'r','r','r'}, {'r','r','r'}},
							{{'o','o','o'}, {'o','o','o'}, {'o','o','o'}},
							{{'g','g','g'}, {'g','g','g'}, {'g','g','g'}},
							{{'b','b','b'}, {'b','b','b'}, {'b','b','b'}}};
			
			//0상 1하 2앞 3뒤 4왼 5우
			for(int i = 0; i < n; i++) {
				String str = sc.next();
				makeTop(str.charAt(0));
				rotateLoc(map, str.charAt(1));
				rotateSub(map, str.charAt(1));
			}
			printTop(map);
		}
	}
	public static void printTop(char[][][] map) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(map[U][i][j]);
			}
			System.out.println();
		}
	}
	public static void makeTop(char loc) {
		int tmp = -1;
		if(loc == 'U') return;
		else if(loc == 'D') {
			tmp = U; U = D; D = tmp; tmp = F; F = B; B = tmp;
		}else if(loc == 'F') {
			tmp = U; U = F; F = D; D = B; B = tmp;
		}else if(loc == 'B') {
			tmp = U; U = B; B = D; D = F; F = tmp;
		}else if(loc == 'L') {
			tmp = U; U = L; L = D; D = R; R = tmp;
		}else if(loc == 'R') {
			tmp = U; U = R; R = D; D = L; L = tmp;
		}
	}
	public static void rotateLoc(char[][][] map, char dir) {
		if(dir == '+') {
			//시계 방향
			char tmp = map[U][0][0];
			map[U][0][0] = map[U][2][0];
			map[U][2][0] = map[U][2][2];
			map[U][2][2] = map[U][0][2];
			map[U][0][2] = tmp;
			tmp = map[U][0][1];
			map[U][0][1] = map[U][1][0];
			map[U][1][0] = map[U][2][1];
			map[U][2][1] = map[U][1][2];
			map[U][1][2] = tmp;
		}else if(dir == '-') {
			//반시계 방향
			char tmp = map[U][0][0];
			map[U][0][0] = map[U][0][2];
			map[U][0][2] = map[U][2][2];
			map[U][2][2] = map[U][2][0];
			map[U][2][0] = tmp;
			tmp = map[U][0][1];
			map[U][0][1] = map[U][1][2];
			map[U][1][2] = map[U][2][1];
			map[U][2][1] = map[U][1][0];
			map[U][1][0] = tmp;
		}
	}
	public static void rotateSub(char[][][] map, char dir) {
		char tmp1 = map[F][0][0], tmp2 = map[F][0][1], tmp3 = map[F][0][2];
		if(dir == '+') {
			//시계 방향
			map[F][0][0] = map[L][0][0];
			map[F][0][1] = map[L][0][1];
			map[F][0][2] = map[L][0][2];
			map[L][0][0] = map[B][0][0];
			map[L][0][1] = map[B][0][1];
			map[L][0][2] = map[B][0][2];
			map[B][0][0] = map[R][0][0];
			map[B][0][1] = map[R][0][1];
			map[B][0][2] = map[R][0][2];
			map[R][0][0] = tmp1;
			map[R][0][1] = tmp2;
			map[R][0][2] = tmp3;
		}else if(dir == '-') {
			//반시계 방향
			map[F][0][0] = map[R][0][0];
			map[F][0][1] = map[R][0][1];
			map[F][0][2] = map[R][0][2];
			map[R][0][0] = map[B][0][0];
			map[R][0][1] = map[B][0][1];
			map[R][0][2] = map[B][0][2];
			map[B][0][0] = map[L][0][0];
			map[B][0][1] = map[L][0][1];
			map[B][0][2] = map[L][0][2];
			map[L][0][0] = tmp1;
			map[L][0][1] = tmp2;
			map[L][0][2] = tmp3;
		}
	}
}
