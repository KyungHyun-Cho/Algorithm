import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int tc = stoi(br.readLine());
		for(int t = 1; t <= tc; t++) {
			answer.append("Scenario ").append(t).append(":\n");
			int usrCnt = stoi(br.readLine());
			int relationCnt = stoi(br.readLine());
			// Union-Find 초기화
			int[] parent = new int[usrCnt];
			for(int i = 0; i < usrCnt; i++)
				parent[i] = i;
			
			// 친구 관계 정의
			for(int i = 0; i < relationCnt; i++) {
				String[] inputArr = br.readLine().split(" ");
				union(parent, stoi(inputArr[0]), stoi(inputArr[1]));				
			}
			
			int queryCnt = stoi(br.readLine());
			for(int i = 0; i < queryCnt; i++) {
				String[] inputArr = br.readLine().split(" ");
				if(find(parent, stoi(inputArr[0])) == find(parent, stoi(inputArr[1])))
					answer.append(1).append('\n');
				else
					answer.append(0).append('\n');
			}
			answer.append('\n');
			
		}
		System.out.println(answer);
	}
	static int find(int[] parent, int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent, parent[x]);
	}
	static void union(int[] parent, int x, int y) {
		x = find(parent, x); y = find(parent, y);
		if(x != y) parent[x] = y;
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
