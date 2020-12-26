import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int n = stoi(br.readLine());
		for(int i = 0; i < n; i++) {
			String[] str_arr = br.readLine().split(" ");
			String op = str_arr[0];
			if("push".equals(op)) {
				int num = stoi(str_arr[1]);
				q.addLast(num);
			}else if("pop".equals(op)) {
				sb.append(q.isEmpty()?"-1\n":q.pollFirst()+"\n");
			}else if("size".equals(op)) {
				sb.append(q.size() + "\n");
			}else if("empty".equals(op)) {
				sb.append(q.isEmpty()?"1\n":"0\n");
			}else if("front".equals(op)) {
				sb.append(q.isEmpty()?"-1\n":q.peekFirst()+"\n");
			}else if("back".equals(op)) {
				sb.append(q.isEmpty()?"-1\n":q.peekLast()+"\n");
			}
		}
		System.out.println(sb.toString());
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
