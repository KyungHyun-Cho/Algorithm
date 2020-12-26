//pop() 맨 마지막 데이터 가져오면서 지우기
//push() 새로운 데이터 쌓기
//peek() 맨 마지막 데이터 보기
//isEmpty() 빈 스택 확인

import java.util.Scanner;
class Stack{
	private class Node{
		private int data;
		private Node next;
		public Node(int data){
			this.data = data;
		}
	}
	private Node top;
	
	public void push(int item) {
		Node t = new Node(item);
		if(top != null) {
			t.next = top;
			top = t;
		}else
			top = t;
	}
	
	public int pop() {
		if(top == null)
			return -1;
		else {
			int tmp = top.data;
			top = top.next;
			return tmp;
		}
			
	}
	public int peek() {
		if(top == null)
			return -1;
		else
			return top.data;
	}
	
	public int isEmpty() {
		if(top == null)
			return 1;
		else
			return 0;
	}
	
	public int getSize() {
		if(top == null)
			return 0;
		else {
			Node tmp = top;
			int cnt = 1;
			while(tmp.next != null) {
				cnt++;
				tmp = tmp.next;
			}
			return cnt;
		}
	}
	
}
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			if(str.equals("push")) {
				int k = sc.nextInt();
				s.push(k);
			}else if(str.equals("pop")) {
				System.out.println(s.pop());
			}else if(str.equals("size")) {
				System.out.println(s.getSize());
			}else if(str.equals("empty")) {
				System.out.println(s.isEmpty());
			}else if(str.equals("top")) {
				System.out.println(s.peek());
			}
		}
	}
}
