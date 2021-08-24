import java.io.*;
import java.util.*;
public class Main {
	static int len, dest, m, answer = Integer.MAX_VALUE;
	static boolean done = false;
	static HashSet<Integer> availableSet = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dest = stoi(br.readLine());
		len = Integer.toString(dest).length();
		m = stoi(br.readLine());
		if(m == 0) {
			System.out.println(Math.min(len, Math.abs(100-dest)));
		}else if(m == 10) {
			System.out.println(Math.abs(dest - 100));
		}else {
			String[] inputArr = br.readLine().split(" ");			
			for(String s : inputArr)
				availableSet.remove(stoi(s));			
			int manualCnt = Math.abs(dest - 100);
			DFS(0, 1);
			System.out.println(Math.min(manualCnt, answer));
		}
	}
	public static void DFS(int picked, int idx) {
		if(idx == len+2) {
			if(picked > dest) {
				done = true;
			}
			answer = Math.min(answer, Math.abs(dest - picked) + idx-1);
		}else if(idx != 1 && (idx == len || idx == len + 1)){
			answer = Math.min(answer, Math.abs(dest - picked) + idx-1);
			if(!done) {
				for(int available : availableSet) {
					DFS(picked + available * (int)Math.pow(10, idx-1), idx + 1);
				}	
			}			
		}
		else {		
			for(int available : availableSet) {
				DFS(picked + available * (int)Math.pow(10, idx-1), idx + 1);
			}
		}
		
	}
	
	public static int stoi(String str) {return Integer.parseInt(str);}
}
