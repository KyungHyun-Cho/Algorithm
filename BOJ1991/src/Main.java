import java.util.*;
import java.io.*;
import java.lang.*;
class Node{
	int l, r;
	Node(int l, int r){
		this.l = l;
		this.r = r;
	}
}
public class Main {
	static ArrayList<Node>[] map;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = sc.nextInt();
		map = new ArrayList[n+1];
		visit = new boolean[n+1];
		for(int i = 0; i <= n; i++)
			map[i] = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			int V = sc.next().charAt(0)-'A'+1;
			int lNode = sc.next().charAt(0)-'A'+1;
			int rNode = sc.next().charAt(0)-'A'+1;
			map[V].add(new Node(lNode, rNode));
		}
		DFS(1);
		visit = new boolean[n+1];
		System.out.println();
		DFS2(1);
		visit = new boolean[n+1];
		System.out.println();
		DFS3(1);
		
		//System.out.println("BP");
		//br.close();
		
	}
	public static void DFS(int start) {
		for(Node node : map[start]) {
			System.out.print((char)(start-1+'A'));
			if(node.l != -18) DFS(node.l);
			if(node.r != -18) DFS(node.r);
			
		}
	}

	public static void DFS2(int start) {
		for(Node node : map[start]) {
			if(node.l != -18) DFS2(node.l);
			System.out.print((char)(start-1+'A'));
			if(node.r != -18) DFS2(node.r);
			
		}
	}
	
	public static void DFS3(int start) {
		for(Node node : map[start]) {
			if(node.l != -18) DFS3(node.l);
			if(node.r != -18) DFS3(node.r);
			System.out.print((char)(start-1+'A'));
		}
	}
	/*public static void DFS2(int start) {
		//if(start == -1)
		if(start == 3)
			System.out.println("BP");
		visit[start] = true;
		int lNode = -1;
		int rNode = -1;
		
		for(int i : map[start]) {
			if(!visit[i]) {
				if(lNode == -1)
					lNode = i;
				else
					rNode = i;
			}
		}
		if(lNode != -1)
			DFS2(lNode);
		System.out.print((char)(start-1+'A'));
		if(rNode != -1)
			DFS2(rNode);
		
	}
	
	public static void DFS3(int start) {
		visit[start] = true;
		for(int i : map[start]) {
			if(!visit[i]) {
				DFS3(i);
			}
		}
		System.out.print((char)(start-1+'A'));
	}*/
	public static int stoi(String str) {return Integer.parseInt(str);}
}
