import java.util.*;
public class Solution {
	class DPriorityQueue<T>{
		private PriorityQueue<T> min = new PriorityQueue<>();
		private PriorityQueue<T> max = new PriorityQueue<>(Collections.reverseOrder());
		private int qCnt = 0;
		
		public void add(T val) {
			isEmpty();
			min.add(val);
			max.add(val);
			qCnt += 1;
		}
		
		public T peekMax() {
			if(isEmpty()) return null;
			return max.peek();
		}
		
		public T peekMin() {
			if(isEmpty()) return null;
			return min.peek();			
		}
		
		public T pollMax() {
			if(isEmpty()) return null;
			qCnt -= 1;
			return max.poll();
		}
		
		public T pollMin() {
			if(isEmpty()) return null;
			qCnt -= 1;
			return min.poll();
		}
		
		public boolean isEmpty() {
			if(qCnt == 0) {
				min.clear();
				max.clear();
				return true;
			}
			return false;
		}
	}
	public int[] solution(String[] operations) {
		DPriorityQueue<Integer> dpq = new DPriorityQueue<>();
		for(String operation : operations) {
			if("D 1".equals(operation))
				dpq.pollMax();
			else if("D -1".equals(operation))
				dpq.pollMin();
			else
				dpq.add(Integer.parseInt(operation.substring(2)));
		}
		if(dpq.isEmpty())
			return new int[] {0, 0};
		else
			return new int[] {dpq.peekMax(), dpq.peekMin()};
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] operations = {"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"};
		int[] ret = solution.solution(operations);
		for(int i : ret)
			System.out.println(i);
	}

}
