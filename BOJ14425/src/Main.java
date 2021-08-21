import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		HashSet<String> set = new HashSet<>();
		int n = stoi(inputArr[0]);
		int k = stoi(inputArr[1]);
		int answer = 0;
		
		while(n-- > 0)
			set.add(br.readLine());
		
		while(k-- > 0)
			if(set.contains(br.readLine()))
				answer++;
		
		System.out.println(answer);
				
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
