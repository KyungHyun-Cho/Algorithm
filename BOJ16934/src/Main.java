import java.io.*;
import java.util.*;
class TrieNode{
	HashMap<Character, TrieNode> map = new HashMap<>();
	boolean isLastChar = false;
	int cnt = 2;
}
class Trie{
	TrieNode root = new TrieNode();
	
	public void add(StringBuilder answer, String word) {
		TrieNode thisNode = root;
		StringBuilder saveFromFirst = new StringBuilder();
		boolean isAlreadyFindBranch = false;
		for(char c : word.toCharArray()) {
			saveFromFirst.append(c);
			if(!thisNode.map.containsKey(c)) {
				thisNode.map.put(c, new TrieNode());
				// 처음 나온 분기점이라면, 이번 단어를 합쳐서 answer에 추가
				if(!isAlreadyFindBranch) {
					answer.append(saveFromFirst).append('\n');
					isAlreadyFindBranch = true;
				}
			}
			thisNode = thisNode.map.get(c);
		}
		// branch를 찾지 못했는데, 만약 지금까지 찾은 노드가 lastChar이면, 뒤에 idx붙여서 answer에 추가
		if(!isAlreadyFindBranch) {
			if(thisNode.isLastChar)
				answer.append(word).append(thisNode.cnt++).append('\n');			
			else
				answer.append(word).append('\n');
		}
		// lastChar set하기
		thisNode.isLastChar = true;
	}
}
public class Main {
	static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		
		Trie trie = new Trie();
		while(n-- > 0) {
			trie.add(answer, br.readLine());
		}
		System.out.println(answer);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
