import java.util.*;
import java.io.*;

class DistNode{
   int no, dist;
   DistNode(int no, int dist){
      this.no = no;
      this.dist = dist;
   }
}
public class Main {
   static int cycleIdx = -1;
   static final int CYCLE_CONST = 987_654_321;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      // Input & Init (ArrayList > Map)
      int n = stoi(br.readLine());
      boolean[] isCycle = new boolean[n+1]; // 순환선인지 여부
      int[] distArr = new int[n+1]; // 최단거리를 저장하는 배열
      ArrayList<Integer>[] map = new ArrayList[n+1]; // Map
      int[] parent = new int[n+1]; // Node 번호 역추적 배열, 0인 경우 방문을 안함
      parent[0] = parent[1] = -1;
      for(int i = 1; i <= n; i++)
         map[i] = new ArrayList<>();
      
      // Input
      for(int i = 0; i < n; i++) {
         String[] inputArr = br.readLine().split(" ");
         int from = stoi(inputArr[0]);
         int to = stoi(inputArr[1]);
         
         // 양방향 Graph
         map[from].add(to);
         map[to].add(from);         
      }
      
      // 순환선을 찾는다.
      findCycle(map, isCycle, parent, 1);
      StringBuilder answer = new StringBuilder();
      
      // 임의의 순환선 1개를 시작으로 각 역의 dist를 구한다.
      for(int i = 1; i <= n; i++) {
         if(isCycle[i]) {
        	 findDist(map, isCycle, distArr, i);
        	 break;
         }
      }
      
      for(int i = 1; i <= n; i++)
    	  answer.append(distArr[i]).append(" ");      
      System.out.println(answer.toString());
   }
   
   static void findDist(ArrayList<Integer>[] map, boolean[] isCycle, int[] distArr, int idx) {
      int n = isCycle.length;
      Queue<DistNode> q = new LinkedList<>();
      boolean[] visit = new boolean[n];
      visit[idx] = true;
      q.add(new DistNode(idx, 0));
      
		while(!q.isEmpty()) {
			DistNode distNode = q.poll();
			int nowIdx = distNode.no;
			int dist = distNode.dist;
		    distArr[nowIdx] = dist;
			for(int nextIdx : map[nowIdx]) {
				if(visit[nextIdx]) continue;
				visit[nextIdx] = true;
				if(isCycle[nextIdx])
					q.add(new DistNode(nextIdx, 0));
				else
					q.add(new DistNode(nextIdx, dist+1));
			}
		}
   }
   
   static void findCycle(ArrayList<Integer>[] map, boolean[] isCycle, int[] parent, int idx) {
      for(int nextIdx : map[idx]) {
         // 양방향 그래프에서 부모를 다시 접근하는 경우 건너뛰기
         if(nextIdx == parent[idx]) continue;
         // 부모가 이미 있는데, 사이클 처리가 된 경우 (이미 처리 완료된 경우)
         else if(parent[nextIdx] != 0 && isCycle[nextIdx]) {
        	 isCycle[idx] = true;
         }         // 부모가 이미 있는경우 (순환)
         else if(parent[nextIdx] != 0) {
            cycleIdx = nextIdx;
            isCycle[idx] = true;
         }

         else {
            parent[nextIdx] = idx; // 부모 처리
            findCycle(map, isCycle, parent, nextIdx);
            // 재귀를 끝내고 왔을 때, 시작점이라면 사이클 시작지점 초기화 및 사이클 처리
            if(isCycle[nextIdx] && cycleIdx == idx) {
               cycleIdx = -1;
               isCycle[idx] = true;
            }
            // 재귀를 끝내고 왔을 때, 순환처리 되었다면, 현재 idx도 순환처리 되어야 함.            
            else if(isCycle[nextIdx] && cycleIdx != -1) isCycle[idx] = true;
         }
      }
   }
   static int stoi(String str) {return Integer.parseInt(str);}
}