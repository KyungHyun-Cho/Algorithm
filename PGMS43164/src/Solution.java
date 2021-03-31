import java.util.*;
public class Solution {
	public static HashMap<String, Integer> map = new HashMap<>();
	public static HashMap<Integer, String> map2 = new HashMap<>();
	
	public static ArrayList<Integer>[] arrList;
	public static int ticketCnt = 0;
	public static boolean isComp = false;
	public static Deque<String> ans = new LinkedList<>();
	public static String[] answer;
	public static int idx = 0;
	public String[] solution(String[][] tickets) {
		ticketCnt = tickets.length;
		answer = new String[ticketCnt+1];
		
		Arrays.sort(tickets, new Comparator<String[]>() {
			public int compare(String[] o1, String[] o2) {
				if(o1[0].equals(o2[0]))
					return o1[1].compareTo(o2[1]);
				else
					return o1[0].compareTo(o2[0]);
			}
		});
		
		for(String[] arr : tickets) {
			if(!map.containsKey(arr[0])) {
				map.put(arr[0], map.size());
				map2.put(map.size()-1, arr[0]);
			}
			if(!map.containsKey(arr[1])) {
				map.put(arr[1], map.size());
				map2.put(map.size()-1, arr[1]);
			}			
		}
		
		arrList = new ArrayList[map.size()];
		
		for(int i = 0; i < map.size(); i++)
			arrList[i] = new ArrayList<>();
		
		for(String[] s : tickets) 
			arrList[map.get(s[0])].add(map.get(s[1]));
		
		DFS(map.get("ICN"), 0);
		return answer;
	}
	public static void DFS(int start, int usedCnt) {
		if(usedCnt == ticketCnt) {
			isComp = true;
			answer[idx++] = map2.get(start);
		}else {
			int qSize = arrList[start].size();
			for(int i = 0; i < qSize; i++) {
				int next = arrList[start].get(i);
				arrList[start].remove(i);
				answer[idx++] = map2.get(start);
				DFS(next, usedCnt + 1);
				if(isComp) return;
				else {
					idx--;
					arrList[start].add(i, next);
				}				
			}
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		//String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		//String[][] tickets = { {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}, {"ICN", "SFO"}, {"ICN", "ATL"}};
		String[][] tickets = {{"ICN","AAA"},{"ICN","AAA"},{"ICN","AAA"},{"AAA","ICN"},{"AAA","ICN"}};
		//String[][] tickets = {{"ICN","B"},{"B","ICN"},{"ICN","A"},{"A","D"},{"D","A"}};
		String[] answer = solution.solution(tickets);
		for(String a : answer)
			System.out.println(a);
				
	}
}
