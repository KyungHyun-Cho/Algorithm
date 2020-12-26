import java.util.Scanner;
import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			int big_r = 0;
			int small_r = 0;
			if(r1 > r2) {
				big_r = r1;
				small_r = r2;
			}else {
				big_r = r2;
				small_r = r1;
			}
			double dist = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				//두 좌표 및 반지름이 모두 같은 경우 무수히 많은 해 (-1)
				System.out.println(-1);
			}else {
				if(dist == big_r) {
					//두 점 사이 거리와 큰 반지름이 동일하다면 무조건 2
					System.out.println(2);
				}else if(dist < big_r) {
					//원 안에 원이 있는 경우
					if(dist + small_r - big_r < 0)
						System.out.println(0);
					else if(dist + small_r - big_r == 0)
						System.out.println(1);
					else if(dist + small_r - big_r > 0)
						System.out.println(2);
					
				}else if(dist > big_r) {
					//원 밖에 원이 있는 경우
					if(dist - small_r - big_r > 0)
						System.out.println(0);
					else if(dist - small_r - big_r == 0)
						System.out.println(1);
					else if(dist - small_r - big_r < 0)
						System.out.println(2);
				}
			}
			
		}
	}
}
