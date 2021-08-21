import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		int n = stoi(inputArr[0]);
		int x = stoi(inputArr[1]);
		
		if(26*n < x) {
			System.out.println("!");
		}else if(n > x) {
			System.out.println("!");
		}else {
			StringBuilder Xsb = new StringBuilder();
			StringBuilder Asb = new StringBuilder();
			char re = 0;
			
			while(n != 0) {
				if(n - 1 + 26 <= x) {
					n--;
					x -= 26;
					Xsb.append('Z');
				}else if(n == x) {
					n--;
					x--;
					Asb.append('A');
				}else {
					int reminder = x-n+1;
					n--;
					x -= reminder;
					re = (char)(reminder + 'A' - 1);
					
				}
			}
			
			System.out.print(Asb.toString());
			System.out.print(re == 0 ? "" : (char)re);
			System.out.print(Xsb.toString());
			
			
			/*int len = 0;
			int gachi = 0;
			len += Xsb.toString().length();
			len += Asb.toString().length();
			len += (re == 0 ? 0 : 1);
			gachi += Xsb.toString().length()*26;
			gachi += Asb.toString().length();
			gachi += re == 0 ? 0 : (re-'A'+1);
			System.out.println(len + " " + gachi);*/
		}
		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
