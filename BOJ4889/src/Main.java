import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int no = 1;
		//1. Input TestCase�� ����� �𸣹Ƿ� while������ �Է��� �޴´�.
		while(true) {
			String str = br.readLine();
			if(str.contains("-")) break; // '-'�� ���Ե������� while�� ����
			
			int n = str.length();
			int cnt = 0;
			Stack<Character> st = new Stack<>();
			
			//2. ���ڿ��� ù ��° ���ں��� ��ȸ�Ѵ�.!
			for(int i = 0; i < n; i++) {
				char tmp = str.charAt(i);
				if(tmp == '{') {
					//2-1. ���� ���ڰ� '{' ���, �״�� ���ÿ� ��´�.
					st.add(tmp);
				}else {
					//2-2. ���� ���ڰ� '}'���, ���� ������ Ȯ���Ѵ�.
					if(st.isEmpty()) {
						//2-2-1. ������ ����ִٸ�, ���ڸ� '{'�� �����Ͽ� ���ÿ� �����ϰ�, ���� Ƚ���� 1 �ø���.
						cnt++;
						st.add('{');
					}
					else
						//2-2-2. ������ ������� �ʴٸ� ('{'�� ����ִ� ���) ������ pop�Ѵ�.
						st.pop();
				}
			}
			//3. 2-2-1���� �ø� ����Ƚ�� + ���û�����/2 ��ŭ�� ����Ѵ�.
			bw.write((no++) + ". " + (cnt + st.size()/2) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
