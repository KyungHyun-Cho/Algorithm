import java.util.*;
import java.util.Scanner;
class Graph{
	class Node{
		int data;
		boolean isVisited;
		LinkedList<Node> adj;
		Node(int data) {
			this.data = data;
			isVisited = false;
			adj = new LinkedList<Node>();
		}
	}
	Node[] nodes;
	Graph(int size){
		nodes = new Node[size];
		for(int i = 0; i < size; i++)
			nodes[i] = new Node(i);
	}
	
	void addEdge(int p, int q) {
		Node n1 = nodes[p];
		Node n2 = nodes[q];
		if(!n1.adj.contains(n2))
			n1.adj.add(n2);
		if(!n2.adj.contains(n1))
			n2.adj.add(n1);
	}
	
	void bfs() {
		bfs(0);
	}
	
	void bfs(int idx) {
		Node root = nodes[idx];
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		root.isVisited = true;
		while(!q.isEmpty()) {
			Node r = q.poll();
			for(Node n : r.adj) {
				if(!n.isVisited) {
					n.isVisited = true;
					q.add(n);
				}
			}
			visit(r);
		}
	}
	
	void dfs() {
		dfs(0);
	}
	
	void dfs(int idx) {
		Node n = nodes[idx];
		dfs(n);
	}
	
	void dfs(Node r) {
		if(r == null) return;
		r.isVisited = true;
		visit(r);
		for(Node n : r.adj)
			if(!n.isVisited)
				dfs(n);
	}
	void visit(Node n){
		System.out.print(n.data + " ");
	}
	
	void clearVisit() {
		for(Node n : nodes)
			n.isVisited = false;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		Graph g = new Graph(n+1);
		int[][] arr = new int[m][2];
		for(int i = 0; i < m; i++) {
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			if(tmp1 < tmp2) {
				arr[i][0] = tmp1;
				arr[i][1] = tmp2;
			}else {
				arr[i][0] = tmp2;
				arr[i][1] = tmp1;				
			}
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		for(int i = 0; i < m; i++) {
			g.addEdge(arr[i][0], arr[i][1]);
		}
		g.dfs(k);
		System.out.println();
		g.clearVisit();
		g.bfs(k);
	}
}
