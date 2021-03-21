import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int no = 1;
		//1. Input TestCase가 몇개인지 모르므로 while문으로 입력을 받는다.
		while(true) {
			String str = br.readLine();
			if(str.contains("-")) break; // '-'가 포함돼있으면 while문 종료
			
			int n = str.length();
			int cnt = 0;
			Stack<Character> st = new Stack<>();
			
			//2. 문자열의 첫 번째 글자부터 순회한다.!
			for(int i = 0; i < n; i++) {
				char tmp = str.charAt(i);
				if(tmp == '{') {
					//2-1. 만약 문자가 '{' 라면, 그대로 스택에 담는다.
					st.add(tmp);
				}else {
					//2-2. 만약 문자가 '}'라면, 현재 스택을 확인한다.
					if(st.isEmpty()) {
						//2-2-1. 스택이 비어있다면, 문자를 '{'로 변경하여 스택에 저장하고, 변경 횟수를 1 늘린다.
						cnt++;
						st.add('{');
					}
					else
						//2-2-2. 스택이 비어있지 않다면 ('{'가 들어있는 경우) 스택을 pop한다.
						st.pop();
				}
			}
			//3. 2-2-1에서 늘린 변경횟수 + 스택사이즈/2 만큼을 출력한다.
			bw.write((no++) + ". " + (cnt + st.size()/2) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
