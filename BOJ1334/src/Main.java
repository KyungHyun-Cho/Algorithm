import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String originStr = br.readLine();
		String prefix = originStr.substring(0, originStr.length() / 2);
		String mid = originStr.length() % 2 == 1 ? Character.toString(originStr.charAt(originStr.length() / 2)) : "";
		StringBuilder answer = new StringBuilder();
		
		answer.append(prefix).append(mid).append(MakeReverse(prefix));		
		
		if(IsPossible(originStr, answer.toString())) {
			System.out.println(answer);
		}else {
			answer = new StringBuilder();
			
			String newPrefix = AddOne(prefix + mid);
			String reverse = MakeReverse(newPrefix);

			if(originStr.length() % 2 == 1)
				reverse = reverse.substring(1);
			
			if(newPrefix.length() > prefix.length() + mid.length()) 
				newPrefix = newPrefix.substring(0, newPrefix.length()-1);
			
			answer.append(newPrefix).append(reverse);
			System.out.println(answer);
		}
	}
	public static boolean IsPossible(String orig, String comp) {
		if(orig.length() != comp.length()) return false;
		else if(orig.equals(comp)) return false;
		else {
			for(int i = 0; i < orig.length(); i++) {
				if(orig.charAt(i) < comp.charAt(i)) return true;
				else if(orig.charAt(i) > comp.charAt(i)) return false;
			}
			return true;
		}
	}
	public static String AddOne(String str) {
		Stack<Integer> st = new Stack<>();
		StringBuilder ret = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			st.add(str.charAt(i) - '0');
		}
		while(!st.isEmpty() && st.peek() == 9) {
			ret.append(0);
			st.pop();
		}
		if(st.isEmpty()) {
			ret.append(1);
		}
		else {
			ret.append(st.pop() + 1);
			while(!st.isEmpty())
				ret.append(st.pop());
		}
		return ret.reverse().toString();
	}
	public static String MakeReverse(String str) {
		StringBuilder ret = new StringBuilder(); 				
		for(int i = str.length()-1; i >= 0; i--)
			ret.append(str.charAt(i));
		return ret.toString();
	}
}
