import java.util.*;
import java.io.*;

class Info{
	int x, y;
	Info(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Info[] day = new Info[D+1];
		day[1] = new Info(1, 0);
		day[2] = new Info(0, 1);
		for(int i = 3; i <= D; i++) 
			day[i] = new Info(day[i-2].x + day[i-1].x, day[i-2].y + day[i-1].y);
		
		for(int i = 1; i < 999999999; i++) {
			if((K-day[D].x*i) % day[D].y == 0) {
				System.out.println(i);
				System.out.println((K-day[D].x*i) / day[D].y);
				return;
			}
		}
	}
}
