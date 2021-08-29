import java.util.*;
import java.io.*;
class Pair{	
	int start, end;
	Pair(int start, int end){
		this.start = start;
		this.end = end;
	}
}
public class Main {
	static ArrayList<Pair> pair = new ArrayList<>();
	static TreeSet<String> answer = new TreeSet<String>();
	static String input;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(')
				st.add(i);
			else if(input.charAt(i) == ')')
				pair.add(new Pair(st.pop(), i));
		}
		
		for(int i = 1; i <= pair.size(); i++)
			DFS(new Stack<Integer>(), i, 0, 0);
		
		StringBuilder ans = new StringBuilder();
		for(String str : answer) {
			ans.append(str).append('\n');
		}
		System.out.println(ans);
	}
	static void DFS(Stack<Integer> st, int pickCnt, int nowCnt, int next) {
		if(nowCnt == pickCnt) {
			answer.add(MakeStr(st));
		}else {
			for(int i = next; i < pair.size(); i++) {
				st.add(i);
				DFS(st, pickCnt, nowCnt+1, i + 1);
				st.pop();
			}
		}
	}
	static String MakeStr(Stack<Integer> removeSet) {
		HashSet<Integer> removeIdxSet = new HashSet<Integer>();
		for(int idx : removeSet) {
			removeIdxSet.add(pair.get(idx).start);
			removeIdxSet.add(pair.get(idx).end);			
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < input.length(); i++) {
			if(!removeIdxSet.contains(i))
				sb.append(input.charAt(i));
		}
		return sb.toString();
	}
}
