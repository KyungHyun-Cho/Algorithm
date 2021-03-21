import java.util.*;
import java.io.*;
public class Main {
	public static int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		String input = "";
		while((input = br.readLine()) != null) {
			ArrayList<Character> set = new ArrayList<Character>();
			StringBuilder sb = new StringBuilder();
			for(char c : input.split(" ")[0].toCharArray())
				set.add(c);			
			int cnt = Integer.parseInt(input.split(" ")[1]);
			if(cnt > fact[set.size()]) {
				answer.append(input + " = No permutation\n");
				continue;
			}
			
			solve(set, sb, cnt-1);
			sb.insert(0, input + " = ");
			answer.append(sb.toString() + "\n");
		}
		System.out.println(answer);
	}
	public static void solve(ArrayList<Character> set, StringBuilder sb, int objCnt) {
		if(set.isEmpty()) return;
		sb.append(set.get(objCnt / fact[set.size() - 1]));
		set.remove(objCnt / fact[set.size() - 1]);
		objCnt %= fact[set.size()];
		solve(set,sb,objCnt);
		
	}
}
