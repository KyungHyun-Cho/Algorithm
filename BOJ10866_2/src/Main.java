import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<Integer> dq = new LinkedList<Integer>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			if(str.contains("push")) {
				int k = Integer.parseInt(str.split(" ")[1]);
				if(str.contains("front"))
					dq.addFirst(k);
				else
					dq.addLast(k);
			}else if(str.contains("pop")) {
				if(dq.isEmpty())
					bw.write(-1 + "\n");
				else if(str.contains("front"))
					bw.write(dq.pollFirst() + "\n");
				else
					bw.write(dq.pollLast() + "\n");
			}else if(str.equals("size")) {
				bw.write(dq.size() + "\n");
			}else if(str.equals("empty")) {
				bw.write((dq.isEmpty()?1:0) + "\n");
			}else if(str.equals("front")) {
				bw.write((dq.isEmpty()?-1:dq.peekFirst()) + "\n");
			}else if(str.equals("back")) {
				bw.write((dq.isEmpty()?-1:dq.peekLast()) + "\n");
			}
			//dq.print_dq();
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
