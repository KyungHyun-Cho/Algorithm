import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String strs[] = str.split("\\.",-1);
		String ans = "";
		for(int i = 0; i < strs.length; i++) {
			if(strs[i].length() > 0) {
				if(strs[i].length() % 2 != 0) {
					System.out.println(-1);
					return;
				}
				for(int j = 0; j < (strs[i].length()/4)*4; j++)
					ans += "A";
				for(int j = 0; j < strs[i].length()%4; j++)
					ans += "B";
				ans += ".";
			}else {
				ans += ".";
			}
		}
		System.out.println(ans.substring(0, ans.length() - 1));
	}
}
