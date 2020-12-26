import java.io.BufferedReader;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		Deque<Integer> q = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			if(str.contains("push")) {
				int k = Integer.parseInt(str.split(" ")[1]);
				q.addLast(k);
			}else if(str.equals("pop")) {
				bw.write((q.isEmpty()?-1:q.pollFirst()) + "\n");
			}else if(str.equals("size")) {
				bw.write(q.size() + "\n");
			}else if(str.equals("empty")) {
				bw.write(((q.isEmpty()?1:0) + "\n"));
			}else if(str.equals("front")) {
				bw.write((q.isEmpty()?-1:q.peekFirst()) + "\n");
			}else if(str.equals("back")) {
				bw.write((q.isEmpty()?-1:q.peekLast()) + "\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
