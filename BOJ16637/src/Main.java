import java.util.*;
public class Main {
	static int answer = Integer.MIN_VALUE;
	public static void main(String[] args) {
		//System.out.println(calc("2*(6+9)-8*(6+1)*2*9-3"));
		//System.exit(0);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		
		Stack<Integer> st = new Stack<>();
		int max_depth = n / 2;
		DFS(st, str, 0, max_depth);
		
		System.out.println(answer);
		
	}
	public static void DFS(Stack<Integer> st, String str, int depth, int max_depth) {
		if(depth == max_depth) {
			String tmp_str = str;
			for(int i = st.size()-1; i >= 0; i--) {
				if(st.get(i) == 1) {
					tmp_str = setOption(tmp_str, i);
				}
			}
			if(tmp_str.contains("()")) return;
			//System.out.println(tmp_str);
			answer = Math.max(answer, calc(tmp_str));
		}else {
			for(int i = 0; i < 2; i++) {
				st.push(i);
				DFS(st, str, depth + 1, max_depth);
				st.pop();
			}
		}
	}
	public static String setOption(String str, int n) {
		StringBuffer sb = new StringBuffer(str);
		sb.insert((n+1)*2 + 1, ")");
		sb.insert(n*2, "(");		
		return sb.toString();
	}
	public static int calc(String str) {
		Deque<Integer> num = new LinkedList<>();
		Deque<Character> op = new LinkedList<>();		
		while(str.contains("(")) {
			//괄호가 있는 경우, 괄호 먼저 처리
			String tmp = str.split("\\(")[1].split("\\)")[0];
			String tmp_ret = Integer.toString(calc(tmp)).replace("-", "^");
			str = str.replace("(" + tmp + ")", tmp_ret);
		}
		
		int n = str.length();
		String tmp = "";
		for(int i = n-1; i >= 0; i--) {
			if(isDigit(str.charAt(i))) {
				tmp = str.charAt(i) + tmp;
			}else {
				op.addFirst(str.charAt(i));
				num.addFirst(Integer.parseInt(tmp.replace("^", "-")));
				tmp = "";
			}
		}
		num.addFirst(Integer.parseInt(tmp.replace("^","-")));
		
		int ret = num.poll();
		while(!op.isEmpty()) {
			char tmp_op = op.pollFirst();
			int tmp_num = num.pollFirst();
			if(tmp_op == '+') {
				ret += tmp_num;
			}else if(tmp_op == '-') {
				ret -= tmp_num;
			}else if(tmp_op == '*') {
				ret *= tmp_num;
			}
		}
		return ret;		
	}
	public static boolean isDigit(char c) {
		if(c - '0' >= 0 && c - '0' < 10) return true;
		if(c == '^') return true;
		return false;
	}
}
