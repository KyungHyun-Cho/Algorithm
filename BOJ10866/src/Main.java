import java.io.*;

class Deque{
	class Node{
		private int data;
		private Node prev;
		private Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public int dSize = 0;
	private Node first;
	private Node last;
	
	public void push_first(int item) {
		Node t = new Node(item);
		if(first != null) {
			first.prev = t;
			t.next = first;
		}
		first = t;
		if(last == null)
			last = first;
		dSize++;
	}
	
	public void push_last(int item) {
		Node t = new Node(item);
		if(last != null) {
			last.next = t;
			t.prev = last;
		}
		last = t;
		if(first == null)
			first = last;
		dSize++;
	}

	public int pop_first() {
		if(first == null)
			return -1;
		else {
			int t = first.data;
			first = first.next;
			if(first == null)
				last = null;
			else
				first.prev = null;
			dSize--;
			return t;
		}	
	}

	public int pop_last() {
		if(last == null)
			return -1;
		else {
			int t = last.data;
			last = last.prev;
			if(last == null)
				first = null;
			else
				last.next = null;
			dSize--;
			return t;
		}	
	}

	public int isEmpty() {
		if(first == null && last == null)
			return 1;
		else
			return 0;
	}

	public int peek_first() {
		if(first == null)
			return -1;
		else
			return first.data;
	}

	public int peek_last() {
		if(last == null)
			return -1;
		else
			return last.data;		
	}
	
	public void print_dq() {
		Node tmp = first;
		System.out.print("Deque >> ");
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
		System.out.println();
	}

}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque dq = new Deque();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			if(str.contains("push")) {
				int k = Integer.parseInt(str.split(" ")[1]);
				if(str.contains("front"))
					dq.push_first(k);
				else
					dq.push_last(k);
			}else if(str.contains("pop")) {
				if(str.contains("front"))
					bw.write(dq.pop_first() + "\n");
				else
					bw.write(dq.pop_last() + "\n");
			}else if(str.equals("size")) {
				bw.write(dq.dSize + "\n");
			}else if(str.equals("empty")) {
				bw.write(dq.isEmpty() + "\n");
			}else if(str.equals("front")) {
				bw.write(dq.peek_first() + "\n");
			}else if(str.equals("back")) {
				bw.write(dq.peek_last() + "\n");
			}
			//dq.print_dq();
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
