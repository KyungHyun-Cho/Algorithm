import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] chr = sc.next().toCharArray();
		Arrays.sort(chr);
		for(int i = chr.length-1; i >= 0; i--)
			System.out.print(chr[i]);
	}
}
