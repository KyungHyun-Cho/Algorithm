import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(tc-- > 0) {
			HashSet<String> set = new HashSet<String>();
			boolean isBreak = false;
			int n = stoi(br.readLine());
			TreeSet<String> callBook = new TreeSet<String>();
			while(n-- > 0) {
				String input = br.readLine();
				callBook.add(input);
			}
			for(String callNum : callBook) {
				StringBuilder tmp = new StringBuilder(); 
				for(int i = 0; i < callNum.length(); i++) {
					tmp.append(callNum.charAt(i));
					if(set.contains(tmp.toString())) {
						isBreak = true;
						break;
					}
				}
				if(!isBreak)
					set.add(tmp.toString());
			}
			sb.append(isBreak ? "NO" : "YES").append('\n'); 
		}
		System.out.println(sb.toString());
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}
