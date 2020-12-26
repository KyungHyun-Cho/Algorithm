import java.util.*;
import java.io.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = stoi(br.readLine());
		int bitmask = 0;
		for(int i = 0; i < n; i++) {
			String[] str_arr = br.readLine().split(" ");
			String op = str_arr[0];
			int num = 0;
			if(!("all".equals(op) || "empty".equals(op)))
				num = stoi(str_arr[1]);
			num--;
			if("add".equals(op)) {
				bitmask |= (1 << num);
			}else if("remove".equals(op)) {
				bitmask &= ~(1 << num);
			}else if("check".equals(op)) {
				if((bitmask & (1 << num)) > 0)
					sb.append("1\n");
				else
					sb.append("0\n");
			}else if("toggle".equals(op)) {
				bitmask ^= (1 << num);
			}else if("all".equals(op)) {
				bitmask = (1 << 20)-1;
			}else if("empty".equals(op)) {
				bitmask = 0;
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
