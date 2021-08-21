import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		long max = 0;
		HashMap<Long, Integer> map = new HashMap<>();
		String[] inputArr = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			long tmpInput = stol(inputArr[i]);
			max = Math.max(max, tmpInput);
			if(!map.containsKey(tmpInput))
				map.put(tmpInput, 1);
			else
				map.put(tmpInput, map.get(tmpInput) + 1);
		}
		
		Deque<Long> dq = new LinkedList<>();
		dq.add(max);
		RemoveMap(map, max);
		while(!map.isEmpty()) {
			if(dq.peekLast() % 3 == 0 && RemoveMap(map, dq.peekLast() / 3))
				dq.addLast(dq.peekLast() / 3);
			else if(dq.peekFirst() % 2 == 0 && RemoveMap(map, dq.peekFirst() / 2))
				dq.addFirst(dq.peekFirst() / 2);
			else if(RemoveMap(map, dq.peekLast() * 2))
				dq.addLast(dq.peekLast() * 2);
			else if(RemoveMap(map, dq.peekFirst() * 3))
				dq.addFirst(dq.peekFirst() * 3);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!dq.isEmpty()) {
			sb.append(dq.pollFirst()).append(" ");
		}
		
		System.out.println(sb);
		
	}
	public static boolean RemoveMap(HashMap<Long, Integer> map, long key) {
		if(!map.containsKey(key))
			return false;
		
		if(map.get(key) == 1)
			map.remove(key);
		else
			map.put(key,  map.get(key) - 1);
		return true;
			
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static long stol(String str) {return Long.parseLong(str);}
	
}
