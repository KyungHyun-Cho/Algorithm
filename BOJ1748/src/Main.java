import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int tmp = 0;
		int len = 11_111_111;
		for(int i = 8; i >= 0; i--) {
			tmp = n - len*9;
			len /= 10;
			if(tmp < 0) continue;
			n -= tmp;
			sum += ((i+1)*tmp);
		}
		
		
		System.out.println(sum);
	}

}
