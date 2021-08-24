import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int answer = 1;
		ArrayList<HashSet<Integer>>[] list = new ArrayList[n];
		Stack<HashSet<Integer>> st = new Stack<>();
		// 리스트 초기화
		//for(int i = 0; i < n; i++)
		//	list[i] = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			String[] inputArr = br.readLine().split(" ");			
			HashSet<Integer> set = new HashSet<>();
			set.add(stoi(inputArr[0]));
			set.add(stoi(inputArr[1]));
			set.add(stoi(inputArr[2]));
			//list[i].add(set);
			st.add(set);
		}
		
		HashSet<Integer> src = st.pop();
		while(!st.isEmpty()) {
			HashSet<Integer> comp = st.pop();
			boolean isBreak = false; // 연쇄적으로 깨지는게 있는가?
			for(int printNum : src) {
				if(comp.contains(printNum)) {
					isBreak = true;
					break;
				}
			}
			// 연쇄적으로 깨지는게 없다면, 개별적으로 깨야하므로 answer++;
			if(!isBreak)
				answer++;
			src = comp;
		}
		
		
		System.out.println(answer);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}

}
