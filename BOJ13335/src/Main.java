import java.util.*;
class Status{
	int w, pos;
	Status(int w, int pos){
		this.w = w;
		this.pos = pos;
	}
}
public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int l = sc.nextInt();		
		int time = 0;
		Queue<Integer> trucks = new LinkedList<>();
		Queue<Status> q = new LinkedList<>();
		for(int i = 0; i < n; i++)
			trucks.add(sc.nextInt());
		while(n > 0) {
			for(Status s : q) {
				s.pos++;
			}
			if(!q.isEmpty() && q.peek().pos > w) {
				q.poll();
				n--;
			}
			int bW = getW(q);
			if(!trucks.isEmpty() && bW + trucks.peek() <= l && q.size() < w) {
				//다리의 총 무게가 l(다리의 최대하중)보다 작거나 같고
				//현재 올라가있는 트럭의 갯수가 w(다리의 길이)보다 작다면
				q.add(new Status(trucks.poll(), 1));
			}
			time++;
		}
		System.out.println(time);
	}
	public static int getW(Queue<Status> trucks) {
		int sum = 0;
		for(Status s : trucks)
			sum += s.w;
		return sum;
	}
}
