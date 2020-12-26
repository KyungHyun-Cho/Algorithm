import java.util.Scanner;
import java.util.Stack;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			Stack<Character> s = new Stack<>();
			String str = sc.nextLine();
			if(".".equals(str)) break;
			while(!(".".equals(str.substring(str.length()-1,str.length())))) {
				str += sc.nextLine();
			}
			boolean isPass = false;
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '(' || str.charAt(j) == '[') {
					s.push(str.charAt(j));
				}else if(str.charAt(j) == ')' || str.charAt(j) == ']') {
					if(s.isEmpty()) {
						System.out.println("no");
						isPass = true;
						break;
					}
					else {
						char tmp = s.pop();
						if(tmp == '(') {
							if(str.charAt(j) == ']') {
								System.out.println("no");
								isPass = true;
								break;
							}
						}else if(tmp == '[') {
							if(str.charAt(j) == ')') {
								System.out.println("no");
								isPass = true;
								break;
							}
						}
					}						
				}
			}
			if(!isPass) {
				if(s.isEmpty())
					System.out.println("yes");
				else
					System.out.println("no");
			}
		}
	}
}
