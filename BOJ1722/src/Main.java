import java.io.*;
import java.util.*;
public class Main {
	public static long[] fact = new long[21];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();		
		ArrayList<String> arr = new ArrayList<>();
		fact[0] = 1;
		for(int i = 1; i <= 20; i++)
			fact[i] = fact[i-1] * i;
		
		if("1".equals(st.nextToken())) {
			for(int i = 1; i <= n; i++) 
				arr.add(Integer.toString(i));
			solve(arr, sb, Long.parseLong(st.nextToken()) - 1);
			System.out.println(sb);
		}else {
			for(int i = 1; i <= n; i++) 
				arr.add(st.nextToken());
			System.out.println(restore(arr));
		}
		
		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static void solve(ArrayList<String> arr, StringBuilder sb, long cnt) {
		if(arr.isEmpty()) return;
		sb.append(arr.get((int)(cnt / fact[arr.size() - 1])) + " ");
		arr.remove((int)(cnt / fact[arr.size() - 1]));
		cnt %= fact[arr.size()];
		solve(arr, sb, cnt);
	}
	public static long restore(ArrayList<String> arr) {
		int size = arr.size();
		long answer = 0;
		boolean[] visit = new boolean[size + 1];
		for(int i = 0; i < size; i++) {
			int n = stoi(arr.get(i));
			for(int j = 1; j < n; j++) {
				if(!visit[j])
					answer += fact[size-i-1];
			}
			visit[n] = true;
		}
		return answer + 1;
	}
}
