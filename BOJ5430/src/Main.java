import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0; i < tc; i++) {
			boolean r = false;
			StringBuilder tmp_sb = new StringBuilder();
			Deque<String> dq = new LinkedList<String>();
			
			String op = br.readLine();
			op = op.replace("RR","");
			
			int n = Integer.parseInt(br.readLine());
			String tmp_str = br.readLine().replace("[","").replace("]","");
			StringTokenizer st = new StringTokenizer(tmp_str,",");
			String[] str_arr = new String[st.countTokens()];
			int stt = 0;
			while(st.hasMoreTokens()) {
				str_arr[stt] = st.nextToken();
				stt++;
			}
			if(op.replace("R","").length() > n) {
				sb.append("error\n");
				continue;
			}else if(op.replace("R","").length() == n) {
				sb.append("[]\n");
				continue;
			}
			for(int j = 0; j < str_arr.length; j++)
				dq.addLast(str_arr[j]);
			int oplentmp = op.length();
			for(int j = 0; j < oplentmp; j++) {
				char sub_op = op.charAt(j);
				if(sub_op == 'R') {
					r = !r;
				}else if(sub_op == 'D') {
						if(r)
							dq.pollLast();
						else
							dq.pollFirst();
				}
			}
			while(!dq.isEmpty()) {
				if(r)
					tmp_sb.append(dq.pollLast() + ",");
				else
					tmp_sb.append(dq.pollFirst() + ",");
			}
			sb.append("[" + tmp_sb.toString().substring(0,tmp_sb.toString().length()-1) + "]\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
