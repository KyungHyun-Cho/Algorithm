import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			ArrayList<String> type = new ArrayList<>();
			int n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				sc.next();
				type.add(sc.next());
			}
			Collections.sort(type);
			ArrayList<Integer> cntList = new ArrayList<>();
			int cnt = 0;
			String prev_type = "";
			for(int i = 0; i < type.size(); i++) {
				String now_type = type.get(i);
				if(prev_type.equals(now_type)) {
					cnt++;
				}else {
					if(i != 0) {
						cntList.add(cnt);
					}
					cnt = 1;
				}
				prev_type = now_type;
			}
			cntList.add(cnt);
			int mul = 1;
			if(cntList.size() > 0) {
				for(int i = 0; i < cntList.size(); i++)
					mul *= (cntList.get(i)+1);
			}
			System.out.println(mul-1);
			
		}
	}
}
