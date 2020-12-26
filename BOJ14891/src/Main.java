import java.util.*;
class CMD{
	int idx;
	boolean isLeft;
	CMD(int idx, boolean isLeft){
		this.idx = idx;
		this.isLeft = isLeft;
	}
}
public class Main {
	static int[][] wheel;
	static final int LEFT_IDX = 6;
	static final int RIGHT_IDX = 2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		wheel = new int[4][8];
		for(int i = 0; i < 4; i++) {
			String str = sc.next();
			for(int j = 0; j < 8; j++) {
				wheel[i][j] = str.charAt(j)-'0';
			}
		}
		int cmd_cnt = sc.nextInt();
		ArrayList<CMD> cmd_list = new ArrayList<>();
		for(int i = 0; i < cmd_cnt; i++) {
			int idx = sc.nextInt();
			boolean isLeft = sc.nextInt()==-1?true:false;
			cmd_list.add(new CMD(idx-1, isLeft));
		}
		for(int i = 0; i < cmd_cnt; i++) {
			CMD cmd = cmd_list.get(i);
			if(cmd.idx == 0) {
				process(cmd, 0);
			}else if(cmd.idx == 3) {
				process(cmd, 1);
			}else{
				process(cmd, 2);
			}
		}
		int sum = 0;
		sum += wheel[0][0] * 1;
		sum += wheel[1][0] * 2;
		sum += wheel[2][0] * 4;
		sum += wheel[3][0] * 8;
		
			
		System.out.println(sum);
		
	}
	public static void process(CMD cmd, int dir) {
		//dir:0 -> 우측 방향으로 연쇄작업
		//dir:1 -> 좌측 방향으로 연쇄작업
		//dir:2 -> 양쪽 방향으로 연쇄작업
		int idx = cmd.idx;
		boolean isLeft = cmd.isLeft;
		boolean lPossible = (idx-1) >= 0 && wheel[idx][LEFT_IDX] != wheel[idx-1][RIGHT_IDX];
		boolean rPossible = (idx+1) < 4 && wheel[idx][RIGHT_IDX] != wheel[idx+1][LEFT_IDX];
		rotate(wheel[idx], isLeft);
		if(dir == 0) {
			if(rPossible) process(new CMD(idx+1, !isLeft), dir);
		}else if(dir == 1) {
			if(lPossible) process(new CMD(idx-1, !isLeft), dir);
		}else if(dir == 2) {
			if(lPossible) process(new CMD(idx-1, !isLeft), 1);
			if(rPossible) process(new CMD(idx+1, !isLeft), 0);		
		}
	}
	public static void rotate(int[] src, boolean isLeft) {
		int tmp;
		if(isLeft) {
			tmp = src[0];
			for(int i = 0; i < 7; i++) {
				src[i] = src[i+1];
			}
			src[7] = tmp;
		}else {
			tmp = src[7];
			for(int i = 7; i > 0; i--) {
				src[i] = src[i-1];
			}
			src[0] = tmp;
		}
	}
}
