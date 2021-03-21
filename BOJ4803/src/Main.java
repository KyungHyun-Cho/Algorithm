import java.io.*;
import java.util.*;
public class Main {
	public static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int tc = 1;
		while(!(input = br.readLine()).equals("0 0")) {
			String[] inputArr = input.split(" ");
			int vCnt = stoi(inputArr[0]);
			int eCnt = stoi(inputArr[1]);
			int treeCnt = 0;
			visit = new boolean[vCnt];
			ArrayList<Integer>[] map = new ArrayList[vCnt];
			for(int i = 0; i < vCnt; i++)
				map[i] = new ArrayList<>();
			
			for(int i = 0; i < eCnt; i++) {
				inputArr = br.readLine().split(" ");
				int v = stoi(inputArr[0]) - 1;
				int e = stoi(inputArr[1]) - 1;
				map[v].add(e);
				map[e].add(v);
			}
			
			for(int i = 0; i < vCnt; i++) {
				if(!visit[i]) {
					visit[i] = true;
					if(DFS(map, visit, i, i))
						treeCnt++;
				}
			}
			if(treeCnt == 0) {
				System.out.printf("Case %d: No trees.\n", tc);
			}else if(treeCnt == 1) {
				System.out.printf("Case %d: There is one tree.\n", tc);
			}else {
				System.out.printf("Case %d: A forest of %d trees.\n", tc, treeCnt);
			}
			tc++;
			
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static boolean DFS(ArrayList<Integer>[] map, boolean[] visit, int startIdx, int prevIdx) {
		boolean isTree = true;
		if(map[startIdx].size() == 0) return true;
		for(int nextIdx : map[startIdx]) {
			if(!visit[nextIdx]) {
				visit[nextIdx] = true;
				isTree = DFS(map, visit, nextIdx, startIdx);
				if(!isTree) return isTree;
			}else {
				if(nextIdx != prevIdx)
					return false;
			}
		}
		return isTree;
	}
}
