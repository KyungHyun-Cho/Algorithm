import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), g = 0;
		while(n-->0) {
			g ^= sc.nextInt();
		}
		System.out.println(g>0?"koosaga":"cubelover");
	}
}