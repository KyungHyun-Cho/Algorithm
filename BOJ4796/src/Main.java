import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 1;
		while(true) {
			long L = sc.nextLong();
			long P = sc.nextLong();
			long V = sc.nextLong();
			if(L == 0) break;
			System.out.println("Case " + (i++) +": " +  (((V/P)*L) + ((V%P)>L?L:(V%P))));
		}
	}
}