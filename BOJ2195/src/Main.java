import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 1;
		
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		String p = br.readLine();
		
		int idx = 0;
		while((idx = findNextIdx(s, p, idx)) < p.length()) {
			answer++;
		}
		System.out.println(answer);
	}
	
	static int findNextIdx(String s, String p, int idx) {
		int cnt = Math.min(p.length()-idx, s.length());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < cnt; i++)
			sb.append(p.charAt(i+idx));
		
		while(sb.length() > 0) {
			if(s.contains(sb.toString()))
				return idx + sb.length();
			else
				sb.deleteCharAt(sb.length()-1);
		}
		return -1;
	}	
}
