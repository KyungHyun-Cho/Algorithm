import java.util.*;
class Solution {
	public String solution(String sentence) {
		//1���� ó��
		if(sentence.length() == 1) {
			if(isLowerCase(sentence.charAt(0)))
				return "invalid";
			else
				return sentence;
		}
		
		StringBuilder sb = new StringBuilder();
		HashSet<String> hs = new HashSet<>();
		int len = sentence.length();
		char lastChar = sentence.charAt(0);
		boolean isStart = isLowerCase(lastChar);
		if(!isStart) sb.append(lastChar);
		
		for(int i = 1; i < len; i++) {
			char c = sentence.charAt(i);
			if(isLowerCase(c)) {
				if(isStart) { // �ҹ��ڰ� �ΰ� �̻� ���� ���
					return "invalid";
				}else {
					if()
				}
			}else {
				
			}
		}
		String answer = "";
		return answer;
	}
	public static boolean isLowerCase(char c) {
		return ('a' <= c && c <= 'z');
	}
	public static void main(String[] args) {
		//Solution solution = new Solution();
		//String sentence = "HaEaLaLaObWORLDb";
		//System.out.println(solution.solution(sentence));
		String t = "aHbEbLbLbOacWdOdRdLdDc";
		String[] arr = t.split("c");
	}

}
