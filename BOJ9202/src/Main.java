import java.util.*;
import java.io.*;
class TrieNode{
	HashMap<Character, TrieNode> node = new HashMap<>();
	TrieNode prev;
	boolean isLastChar;
}
class Trie{
	TrieNode root;
	Trie(){
		root = new TrieNode();
	}
	public void insert(String word) {
		TrieNode thisNode = root;
		
		for(char c : word.toCharArray()) {
			if(!thisNode.node.containsKey(c)) thisNode.node.put(c, new TrieNode());
			thisNode.node.get(c).prev = thisNode;
			thisNode = thisNode.node.get(c);
			
		}
		
		thisNode.isLastChar = true;
	}
	/*public boolean contains(String word) {
		TrieNode thisNode = root;
		
		for(char c : word.toCharArray()) {
			if(!thisNode.node.containsKey(c)) return false;
			thisNode = thisNode.node.get(c);
		}
		return thisNode.isLastChar;
	}*/
	/*public boolean delete(String word) {
		return delete(word, 0);
	}
	private boolean delete(String word, int idx) {
		
	}*/
}
public class Main {
	static int dir[][] = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static int[] score = {0, 0, 0, 1, 1, 2, 3, 5 ,11};
	static char[][] boogleMap;
	static boolean[][] visit;
	static HashSet<String> findSet;
	static StringBuilder answer = new StringBuilder();
	static Trie trie = new Trie();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
		int n = stoi(br.readLine());
		while(n-- > 0)
			trie.insert(br.readLine());
		br.readLine(); // 공백 지우기
		int boogleCnt = stoi(br.readLine());
		while(boogleCnt-- > 0) {
			boogleMap = new char[4][4];
			visit = new boolean[4][4];
			findSet = new HashSet<>();
			
			for(int i = 0; i < 4; i++) {
				String inputStr = br.readLine();
				for(int j = 0; j < 4; j++)
					boogleMap[i][j] = inputStr.charAt(j);
			}
			if(boogleCnt != 0) br.readLine(); // 공백 지우기
			for(int i = 0; i < 4; i++)
				for(int j = 0; j < 4; j++) {
					if(!trie.root.node.containsKey(boogleMap[i][j])) continue;
					visit[i][j] = true;
					StringBuilder inputSb = new StringBuilder();
					inputSb.append(boogleMap[i][j]);
					DFS(trie.root.node.get(boogleMap[i][j]), inputSb, i, j, 1);
					visit[i][j] = false;
				}
			
			int maxScore = 0;
			String maxWord = "";
			for(String findWord : findSet) {
				maxScore += score[findWord.length()];
				if(maxWord.length() == findWord.length())
					maxWord = maxWord.compareTo(findWord) < 0 ? maxWord : findWord;
				else if(maxWord.length() < findWord.length())
					maxWord = findWord;
			}
			int findCnt = findSet.size();
			
			answer.append(maxScore).append(' ').append(maxWord).append(' ').append(findCnt).append('\n');
		}
		System.out.println(answer);
	}
	static void DFS(TrieNode node, StringBuilder sb, int x, int y, int findCnt) {
		if(findCnt == 8) {
			if(node.isLastChar) findSet.add(sb.toString());
		}else {
			if(node.isLastChar)
				findSet.add(sb.toString());
			for(int i = 0; i < 8; i++) {
				int new_x = x + dir[i][0];
				int new_y = y + dir[i][1];
				if(new_x < 0 || new_y < 0 || new_x >= 4 || new_y >= 4) continue;
				if(visit[new_x][new_y]) continue;
				visit[new_x][new_y] = true;
				if(node.node.containsKey(boogleMap[new_x][new_y])) {
					sb.append(boogleMap[new_x][new_y]);
					DFS(node.node.get(boogleMap[new_x][new_y]), sb, new_x, new_y, findCnt+1);
					sb.deleteCharAt(findCnt);
				}
				visit[new_x][new_y] = false;
			}
		}
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}
