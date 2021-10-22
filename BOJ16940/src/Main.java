import java.util.*;
import java.io.*;
class Node{
	int idx;
	HashMap<Integer, Node> childNode = null;
	Node(int idx){
		this.idx = idx;
		childNode = new LinkedHashMap<>();
	}
	boolean containsKey(int key) {return childNode.containsKey(key);}
	Node get(int key) {return childNode.get(key);}
	void remove(int key) {childNode.remove(key);}
	void put(int key, Node value) {childNode.put(key, value);}
	int count() {return childNode.size();}
}
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Node> nodeMap = new HashMap<>();		
		int n = stoi(br.readLine());
		for(int i = 1; i <= n; i++)
			nodeMap.put(i, new Node(i));
		
		
		for(int i = 0; i < n-1; i++) {
			String[] inputArr = br.readLine().split(" ");
			int p = stoi(inputArr[0]);
			int q = stoi(inputArr[1]);
			Node pNode = nodeMap.get(p);
			Node qNode = nodeMap.get(q);
			if(!pNode.containsKey(q)) pNode.put(q, qNode);
			if(!qNode.containsKey(p)) qNode.put(p, pNode);			
		}

		Queue<Node> q = new LinkedList<>();
		q.add(nodeMap.get(1));
		
		String[] inputArr = br.readLine().split(" ");
		if(stoi(inputArr[0]) != 1) {
			System.out.println(0);
			return;
		}
		
		int idx = 1;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int nodeIdx = node.idx;
			int nodeSize = node.count();
			while(nodeSize-- > 0) {
				int findIdx = stoi(inputArr[idx++]);
				if(node.containsKey(findIdx)) {
					node.get(findIdx).remove(nodeIdx);
					q.add(node.get(findIdx));
				}
				else {
					System.out.println(0);
					return;
				}
			}
		}
		
		System.out.println(1);
	}
	
	static int stoi(String str) {return Integer.parseInt(str);}
}
