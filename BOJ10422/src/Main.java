import java.io.*;
import java.util.*;
class Info{
	long x, y;
	Info(long x, long y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Info[] info = new Info[2501];
		info[1] = new Info(1, 0);
		info[2] = new Info(2, 0);
		for(int i = 3; i <= 2500; i++) {
			long x = (info[i-1].x + (i-1)) % 1_000_000_007;
			long y = (info[i-1].x + info[i-1].y - 1) % 1_000_000_007;
			info[i] = new Info(x, y);
		}
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			int input = Integer.parseInt(br.readLine());
			if(input % 2 == 0) {
				sb.append((info[input/2].x + info[input/2].y) % 1_000_000_007 + "\n");
			}else {
				sb.append("0\n");
			}
		}
		System.out.println(sb);
	}
}
