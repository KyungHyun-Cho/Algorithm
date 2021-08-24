import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		int n = stoi(inputArr[0]);
		int k = stoi(inputArr[1]);
		inputArr = br.readLine().split(" ");

		boolean[] containArr = new boolean[n+1];
		HashSet<Integer> todoSet = new HashSet<>();
		PriorityQueue<Integer> availableQ = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < n; i++) {
			int a = stoi(inputArr[i]);
			if(a > n) {
				System.out.println(0);
				return;
			}
			if(!containArr[a]) {
				containArr[a] = true;
			}else {
				availableQ.add(a);
			}
		}
		for(int i = 1; i <= n; i++) {
			if(!containArr[i])
				todoSet.add(i);
		}
		while(!availableQ.isEmpty()) {
			int available = availableQ.poll();
			for(int todo : todoSet) {
				if(IsPossible(available, todo, k)) {
					todoSet.remove(todo);
					break;
				}
			}
		}
		
		if(todoSet.isEmpty())
			System.out.println(1);
		else
			System.out.println(0);
			
	}
	public static boolean IsPossible(int available, int todo, int k) {
		if(available > todo) return false;
		return available % k == todo % k;
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
