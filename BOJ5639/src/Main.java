import java.util.*;
import java.io.*;
import java.lang.*;

class Node{
	int data, l, r;
	Node(int data, int l, int r){
		this.data = data;
		this.l = l;
		this.r = r;
	}
}
public class Main {
	static ArrayList<Node>[] map;
	static int V = 1;
	static boolean[] visit;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[10001];
		Arrays.fill(arr, -1);
		while(sc.hasNextInt()) 
			arr[V++] = sc.nextInt();
		
		map = new ArrayList[V + 2];
		visit = new boolean[V + 2];
		for(int i = 0; i <= V+1; i++)
			map[i] = new ArrayList<Node>();
		
		fill_node(1,1);
		System.out.println("BP");
	}
	public static void fill_node(int arr_idx, int node_idx){
		visit[arr_idx] = true;
		Node now = new Node(arr[arr_idx], -1, -1);
		if(arr[arr_idx+1] != -1 && !visit[arr_idx + 1]) {
			//다음 배열이 존재하면서 방문하지 않았을 경우
			if(arr[arr_idx + 1] < arr[arr_idx] ) {
				//다음 노드가 현재 노드의 값보다 작다면
				now.l = arr[arr_idx+1];
				fill_node(arr_idx+1, node_idx*2);
			}else {
				now.r = arr[arr_idx+1];
				fill_node(arr_idx+1, node_idx*2+1);
			}
		}else {
			return;
		}
		map[arr_idx].add(now);
	}

}
