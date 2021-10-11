import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long answer = 0;
		String[] inputArr = br.readLine().split(" ");
		int[] strLenArr = new int[21];
		Queue<Integer> q = new LinkedList<>();
		
		int n = stoi(inputArr[0]);
		int qSize = stoi(inputArr[1])+1;

		while(n --> 0) {
			int len = br.readLine().length();
			
			if(q.size() >= qSize) {
				strLenArr[q.peek()]--;
				answer += strLenArr[q.poll()];
			}
			
			q.add(len);
			strLenArr[len]++;
		}
		
		while(!q.isEmpty()) {
			strLenArr[q.peek()]--;
			answer += strLenArr[q.poll()];
		}
		
		System.out.println(answer);
	}
	
	static int stoi(String str) {return Integer.parseInt(str);}
}
