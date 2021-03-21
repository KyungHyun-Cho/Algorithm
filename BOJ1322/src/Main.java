import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextInt();
		long k = sc.nextInt();
		long ans = 0;
		for(long i = 1; i <= Long.MAX_VALUE; i++) {
			if((x + i) == (x | i)) ans++;
			if(ans == k) {
				System.out.println(i);
				return;
			}
		}
	}
}
