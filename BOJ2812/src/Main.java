import java.util.*;
public class Main {
	public static void main(String[] args) {
		Deque<Character> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt()+1;
		char[] chr_arr = sc.next().toCharArray();
		q.addLast('0');
		for(int i = 0; i < n; i++) {
			while(true) {
				if(!q.isEmpty() && k > 0 && q.peekLast() < chr_arr[i]) {
					q.pollLast();
					k--;
				}else
					break;
			}
			q.addLast(chr_arr[i]);
		}
		int qSize = q.size();
		for(int i = 0; i < qSize-k;i++)
			System.out.print((char)q.pollFirst());
		sc.close();
	}
}
/*
8 3
71829364

my ans : 78964
act ans : 89364
 */
