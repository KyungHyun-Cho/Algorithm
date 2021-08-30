import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		int n = stoi(inputArr[0]);
		int m = stoi(inputArr[1]);
		HashSet<Integer> knowPpl = new HashSet<Integer>();
		inputArr = br.readLine().split(" ");
		if(inputArr.length == 1) {
			System.out.println(m);
			return;
		}
		
		for(int i = 1; i < inputArr.length; i++)
			knowPpl.add(stoi(inputArr[i]));
		
		ArrayList<Integer>[] participants = new ArrayList[m];
		for(int i = 0; i < m; i++) {
			participants[i] = new ArrayList<Integer>();
			inputArr = br.readLine().split(" ");
			for(int j = 1; j < inputArr.length; j++)
				participants[i].add(stoi(inputArr[j]));
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				for(int participant : participants[j]) {
					if(knowPpl.contains(participant)) {
						knowPpl.addAll(participants[j]);
						break;
					}
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i < m; i++) {
			boolean isBreak = false;
			for(int participant : participants[i]) {				
				if(knowPpl.contains(participant)) {
					isBreak = true;
					break;
				}
			}
			if(!isBreak) answer++;
		}
		
		System.out.println(answer);
	}
	static int stoi(String str) {return Integer.parseInt(str);}

}
