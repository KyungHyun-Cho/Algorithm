import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int answer = 0;
		boolean usingZero = false;
		ArrayList<Integer> mList = new ArrayList<>();
		ArrayList<Integer> pList = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int input = stoi(br.readLine());
			if(input < 0) mList.add(input);
			else if(input == 0) usingZero = true;
			else if(input == 1) answer += 1;
			else pList.add(input);
		}
		Collections.sort(mList);
		Collections.sort(pList, Collections.reverseOrder());
		if(mList.size() % 2 == 1) {
			answer += usingZero ? 0 : mList.get(mList.size() - 1);
			mList.remove(mList.size() - 1);
		}
		if(pList.size() % 2 == 1) {
			answer += pList.get(pList.size() - 1);
			pList.remove(pList.size() - 1);
		}
		
		for(int i = 0; i < mList.size()-1; i += 2) 
			answer += (mList.get(i) * mList.get(i+1));			
		for(int i = 0; i < pList.size()-1; i += 2) 
			answer += (pList.get(i) * pList.get(i+1));			
		
		System.out.println(answer);
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}
