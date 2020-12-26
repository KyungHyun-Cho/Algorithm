import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		PriorityQueue<Short> maxq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Short> minq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			short k = Short.parseShort(br.readLine()); 
			if (i%2 == 0) {
				maxq.add(k);
			}else {
				minq.add(k);
			}
			if(!minq.isEmpty() && !maxq.isEmpty()) {
				if(maxq.peek() > minq.peek()) {
					short t = minq.poll();
					minq.add(maxq.poll());
					maxq.add(t);
				}
			}
			bw.write(maxq.peek() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
