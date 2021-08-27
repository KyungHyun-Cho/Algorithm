import java.util.*;
public class Solution {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
	}
	static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		HashSet<Character> each_skill_set = new HashSet<>();
		for(char c : skill.toCharArray())
			each_skill_set.add(c);
		
		for(String skill_tree : skill_trees) {
			ArrayList<Character> major_skill_tree_list = new ArrayList<>(); 
			for(char c : skill_tree.toCharArray()) {
				if(each_skill_set.contains(c))
					major_skill_tree_list.add(c);
			}

			for(int i = 0; i < major_skill_tree_list.size(); i++)
				if(major_skill_tree_list.get(i) != skill.charAt(i)) {
					answer--;
					break;
				}
			answer++;
		}
        return answer;
	}

}
