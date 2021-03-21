import java.util.*;
import java.io.*;
public class Main {
	public static int[] pow = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken())+1;
		int c = Integer.parseInt(st.nextToken())+1;
		int loop = N;
		int answer = 0;
		for(int i = 0; i < loop; i++) {
			int sbm = getSBM(N, r, c);
			N--;
			if(sbm == 1) {
				
			}else if(sbm == 2) {
				answer += (pow[N]*pow[N]);
				c -= pow[N];
			}else if(sbm == 3) {
				answer += (2*pow[N]*pow[N]);
				r -= pow[N];
			}else if(sbm == 4) {
				answer += (3*pow[N]*pow[N]);
				c -= pow[N];
				r -= pow[N];
			}
		}
		System.out.println(answer);
		
	}
	public static int getSBM(int N, int r, int c) {
		if(r <= pow[N-1] && c <= pow[N-1]) {
			return 1;
		}else if(r <= pow[N-1] && c > pow[N-1]) {
			return 2;
		}else if(r > pow[N-1] && c <= pow[N-1]) {
			return 3;
		}else{
			return 4;
		}
	}
}
