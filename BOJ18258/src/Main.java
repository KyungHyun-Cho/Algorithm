import java.io.*;

class Queue{
	int qSize = 0;
	class Node{
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node first;
	Node last;
	
	public void push(int item) {
		Node t = new Node(item);
		if(last != null) {
			last.next = t;
		}
		last = t;
		if(first == null) {
			first = last;
		}
		qSize++;
	}
	
	public int pop() {
		if(first == null)
			return -1;
		else {
			int tmp = first.data;
			first = first.next;
			qSize--;
			if(first == null)
				last = null;
			return tmp;
		}
	}
		
	public int isEmpty() {
		if(first == null && last == null)
			return 1;
		else {
			return 0;
		}
	}
	
	public int peekFirst() {
		if(first == null)
			return -1;
		else
			return first.data;
	}
	
	public int peekLast() {
	if(last == null)
		return -1;
	else
		return last.data;
	}
}
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue q = new Queue();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			if(str.contains("push")) {
				int k = Integer.parseInt(str.split(" ")[1]);
				q.push(k);
			}else if(str.equals("pop")) {
				bw.write(q.pop() + "\n");
			}else if(str.equals("size")) {
				bw.write(q.qSize + "\n");
			}else if(str.equals("empty")) {
				bw.write(q.isEmpty() + "\n");
			}else if(str.equals("front")) {
				bw.write(q.peekFirst() + "\n");
			}else if(str.equals("back")) {
				bw.write(q.peekLast() + "\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
