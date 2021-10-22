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
      boolean[] isCycle = new boolean[n+1]; // ��ȯ������ ����
      int[] distArr = new int[n+1]; // �ִܰŸ��� �����ϴ� �迭
      ArrayList<Integer>[] map = new ArrayList[n+1]; // Map
      int[] parent = new int[n+1]; // Node ��ȣ ������ �迭, 0�� ��� �湮�� ����
      parent[0] = parent[1] = -1;
      for(int i = 1; i <= n; i++)
         map[i] = new ArrayList<>();
      
      // Input
      for(int i = 0; i < n; i++) {
         String[] inputArr = br.readLine().split(" ");
         int from = stoi(inputArr[0]);
         int to = stoi(inputArr[1]);
         
         // ����� Graph
         map[from].add(to);
         map[to].add(from);         
      }
      
      // ��ȯ���� ã�´�.
      findCycle(map, isCycle, parent, 1);
      StringBuilder answer = new StringBuilder();
      
      // ������ ��ȯ�� 1���� �������� �� ���� dist�� ���Ѵ�.
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
         // ����� �׷������� �θ� �ٽ� �����ϴ� ��� �ǳʶٱ�
         if(nextIdx == parent[idx]) continue;
         // �θ� �̹� �ִµ�, ����Ŭ ó���� �� ��� (�̹� ó�� �Ϸ�� ���)
         else if(parent[nextIdx] != 0 && isCycle[nextIdx]) {
        	 isCycle[idx] = true;
         }         // �θ� �̹� �ִ°�� (��ȯ)
         else if(parent[nextIdx] != 0) {
            cycleIdx = nextIdx;
            isCycle[idx] = true;
         }

         else {
            parent[nextIdx] = idx; // �θ� ó��
            findCycle(map, isCycle, parent, nextIdx);
            // ��͸� ������ ���� ��, �������̶�� ����Ŭ �������� �ʱ�ȭ �� ����Ŭ ó��
            if(isCycle[nextIdx] && cycleIdx == idx) {
               cycleIdx = -1;
               isCycle[idx] = true;
            }
            // ��͸� ������ ���� ��, ��ȯó�� �Ǿ��ٸ�, ���� idx�� ��ȯó�� �Ǿ�� ��.            
            else if(isCycle[nextIdx] && cycleIdx != -1) isCycle[idx] = true;
         }
      }
   }
   static int stoi(String str) {return Integer.parseInt(str);}
}