import java.util.*;
import java.io.*;

// Á¤¸®
// st++ : NUM / DUP
// st-- : POP / ADD / SUB / MUL / DIV / MOD 
// st : INV / SWP

public class Main {
	static final long MAX = 1_000_000_000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> plusCommand = new HashSet<>();
		HashSet<String> minusCommand = new HashSet<>();
		
		plusCommand.add("NUM");
		plusCommand.add("DUP");
		
		minusCommand.add("POP");
		minusCommand.add("ADD");
		minusCommand.add("SUB");
		minusCommand.add("MUL");
		minusCommand.add("DIV");
		minusCommand.add("MOD");
		
		StringBuilder answer = new StringBuilder();
		
		while(true) {
			ArrayList<String> cmdList = new ArrayList<String>();
			int retStackCnt = 1;
			String cmd;
			
			while(!"END".equals(cmd = br.readLine())) {
				if("QUIT".equals(cmd)) {System.out.println(answer); return;}
				
				cmdList.add(cmd);
				if(plusCommand.contains(cmd) || cmd.length() > 3) retStackCnt++;
				else if(minusCommand.contains(cmd)) retStackCnt--;				
			}
			
			int n = stoi(br.readLine());
			for(int i = 0; i < n; i++) {
				int query = stoi(br.readLine());
				if(retStackCnt != 1)
					answer.append("ERROR\n");
				else {
					boolean isBreak = false;
					Stack<Long> st = new Stack<>();
					st.add((long)query);
					for(String tmpCmd: cmdList) {
						if(!process(st, tmpCmd)) {
							isBreak = true;
							break;
						}
					}
					if(isBreak) {
						answer.append("ERROR\n");
						continue;
					}else {
						answer.append(st.pop()).append("\n");
					}
				}
			}
			br.readLine();
			answer.append("\n");
		}
	}
	static int stoi(String str) {return Integer.parseInt(str);}
	static boolean process(Stack<Long> st, String op) {
		try {
			if("DUP".equals(op))
				st.add(st.peek());
			else if("POP".equals(op))
				st.pop();
			else if("ADD".equals(op)) {
				long a = st.pop();
				long b = st.pop();
				if(Math.abs(a+b) > MAX) return false;
				st.add(a+b);
			}else if("SUB".equals(op)) {
				long a = st.pop();
				long b = st.pop();
				if(Math.abs(b-a) > MAX) return false;
				st.add(b-a);
			}else if("MUL".equals(op)) {
				long a = st.pop();
				long b = st.pop();
				if(Math.abs(a*b) > MAX) return false;
				st.add(a*b);
			}else if("DIV".equals(op)) {
				long a = st.pop();
				long b = st.pop();
				if(Math.abs(b/a) > MAX) return false;
				st.add(b/a);
			}else if("MOD".equals(op)) {
				long a = st.pop();
				long b = st.pop();
				if(Math.abs(b%a) > MAX) return false;
				st.add(b%a);
			}else if("INV".equals(op))
				st.add(st.pop() * -1);
			else if("SWP".equals(op)) {
				long a = st.pop();
				long b = st.pop();
				st.add(a);
				st.add(b);
			}else {
				// NUM X
				st.add((long) stoi(op.split(" ")[1]));
			}
			return true;
		}catch(Exception ex) {
			return false;
		}
		
	}
}
