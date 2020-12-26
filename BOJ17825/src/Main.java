import java.util.*;
class Info{
	int nextId, score;
	Info(int nextId, int score){
		this.nextId = nextId;
		this.score = score;
	}
}
public class Main {
	static int answer = 0;
	static int[] arr;
	static ArrayList<Info>[] map;
	static HashMap<Integer, Integer> kInfo = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new ArrayList[32];
		for(int i = 0; i < 32; i++)
			map[i] = new ArrayList<>();
		init();
		
		arr = new int[10];
		for(int i = 0; i < 10; i++)
			arr[i] = sc.nextInt();
		
		Stack<Integer> st = new Stack<>();
		DFS(st, 0);
		System.out.println(answer);
	}
	public static void DFS(Stack<Integer> st, int depth) {
		if(depth == 10) {
			if(st.get(0) == 0 && st.get(1) == 0 && st.get(2) == 0 && st.get(3) == 1 && st.get(4) == 1 && st.get(5) == 1 && st.get(6) == 2 && st.get(7) == 2 && st.get(8) == 2 && st.get(9) == 3)
				st.contains(0);
			int tmp = solve(st);
			answer = Math.max(answer, tmp);
		}else {
			for(int i = 0; i < 4; i++) {
				st.add(i);
				DFS(st, depth + 1);
				st.pop();
			}
		}
	}
	public static int solve(Stack<Integer> st) {
		kInfo.clear();
		int ans = 0;
		int idx = 0;
		for(int kNo : st) {
			int ret = move(kNo, arr[idx++]);
			if(ret >= 0) {
				ans += ret;
			}else {
				return 0;
			}
		}
		return ans;
	}
	public static int move(int kNo, int cnt) {
		int now_idx = 0;
		int next_idx = -1;
		int now_ret = 0;
		if(kInfo.containsKey(kNo))
			now_idx = kInfo.get(kNo);
		if(now_idx == 99) return -1;
		
		if(now_idx == 5 || now_idx == 10 || now_idx == 15)
			next_idx = map[now_idx].get(1).nextId;
		else 
			next_idx = map[now_idx].get(0).nextId;
		
		for(int i = 0; i < cnt; i++) {
			now_idx = next_idx;
			if(now_idx == 99) {
				now_ret = 0;
				break;
			}
			now_ret = map[now_idx].get(0).score;
			next_idx = map[now_idx].get(0).nextId;
		}
		for(int val : kInfo.values())
			if(val == now_idx && val != 99) return -1;
		kInfo.put(kNo, now_idx);
		return now_ret;
	}
	
	public static void init() {
		map[0].add(new Info(1, 0));
		map[1].add(new Info(2, 2));
		map[2].add(new Info(3, 4));
		map[3].add(new Info(4, 6));
		map[4].add(new Info(5, 8));
		map[5].add(new Info(6, 10));
		map[5].add(new Info(20, 10));
		map[6].add(new Info(7, 12));
		map[7].add(new Info(8, 14));
		map[8].add(new Info(9, 16));
		map[9].add(new Info(10, 18));
		map[10].add(new Info(11, 20));
		map[10].add(new Info(23, 20));
		map[11].add(new Info(12, 22));
		map[12].add(new Info(13, 24));
		map[13].add(new Info(14, 26));
		map[14].add(new Info(15, 28));
		map[15].add(new Info(16, 30));
		map[15].add(new Info(25, 30));
		map[16].add(new Info(17, 32));
		map[17].add(new Info(18, 34));
		map[18].add(new Info(19, 36));
		map[19].add(new Info(31, 38));
		
		map[20].add(new Info(21, 13));
		map[21].add(new Info(22, 16));
		map[22].add(new Info(28, 19));
		
		map[23].add(new Info(24, 22));
		map[24].add(new Info(28, 24));
		
		map[25].add(new Info(26, 28));
		map[26].add(new Info(27, 27));
		map[27].add(new Info(28, 26));
		map[28].add(new Info(29, 25));
		map[29].add(new Info(30, 30));
		map[30].add(new Info(31, 35));
		map[31].add(new Info(99, 40));
	}
}
