import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		while(!(input = br.readLine()).equals("*")) {
			boolean isBreak = false;
			for(int i = 0; i < input.length() - 2; i++) {
				if(!CheckNUil(input, i)) {
					System.out.println(input + " is NOT surprising.");
					isBreak = true;
					break;
				}
			}
			if(!isBreak) {
				System.out.println(input + " is surprising.");
			}
		}
	}
	
	public static boolean CheckNUil(String str, int n) {
		HashSet<String> hashSet = new HashSet<>();
		int s = 0, e = n+1;
		while(e < str.length()) {
			String combinedStr = Character.toString(str.charAt(s)) + Character.toString(str.charAt(e));
			if(!hashSet.add(combinedStr)) return false;
			s++;
			e++;
		}
		return true;		
	}
}
