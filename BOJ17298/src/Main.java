import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> ans = new Stack<Integer>();
		Stack<Integer> tmp = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int n = stoi(br.readLine());
		String[] input = br.readLine().split(" ");
		
		for(int i = n-1; i >= 0; i--) {
			int num = stoi(input[i]);
			while(!tmp.isEmpty() && (num >= tmp.peek())) {
				tmp.pop();
			}
			if(tmp.isEmpty()) {
				ans.add(-1);
			}else {
				ans.add(tmp.peek());
			}
			tmp.add(num);
		}
		
		while(!ans.isEmpty()) {
			sb.append(ans.pop() + " ");
		}
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
