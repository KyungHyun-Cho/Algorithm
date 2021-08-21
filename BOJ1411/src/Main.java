import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = br.readLine();
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				if(IsShom(arr[i], arr[j]))
					answer++;
			}
		}
		
		System.out.println(answer);
	}
	public static boolean IsShom(String src, String comp) {
		if(src.length() != comp.length()) return false;
		HashMap<Character, Character> changeMap = new HashMap<>(); 
		HashSet<Character> changedSet = new HashSet<>();
		
		for(int i = 0; i < src.length(); i++) {
			if(src.charAt(i) == comp.charAt(i))
				continue;
			
			if(!changeMap.containsKey(src.charAt(i)))
			{				
				changeMap.put(src.charAt(i), comp.charAt(i));
				if(changedSet.contains(comp.charAt(i)))
					return false;
				else
					changedSet.add(comp.charAt(i));
			}
			else
				if(changeMap.get(src.charAt(i)) != comp.charAt(i))
					return false;
		}
		return true;
	}

}
