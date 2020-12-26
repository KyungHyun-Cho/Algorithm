import java.util.*;
import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int h = sc.nextInt();
			if(x == 0 && y == 0 && h == 0)
				return;
			if(x <= 0 || y <= 0 || h <= 0)
				System.out.println("wrong");
			else {
				int[] arr = new int[3];
				arr[0] = x;
				arr[1] = y;
				arr[2] = h;
				Arrays.sort(arr);
				if((Math.pow(arr[0],2) + Math.pow(arr[1],2)) == Math.pow(arr[2],2))
					System.out.println("right");
				else
					System.out.println("wrong");
			}
		}
	}
}
