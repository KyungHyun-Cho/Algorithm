import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, Integer> map = new TreeMap<>();
		int cnt = 0;
		String treeSpecies = null;
		while((treeSpecies = br.readLine()) != null && !treeSpecies.isEmpty()) {
			if(!map.containsKey(treeSpecies))
				map.put(treeSpecies, 1);
			else
				map.put(treeSpecies, map.get(treeSpecies) + 1);
			cnt++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(String key : map.keySet()) {
			int val = map.get(key);
			double percent = (double)val / cnt * 100;
			sb.append(key).append(' ').append(String.format("%.4f", percent)).append('\n');
		}
		System.out.println(sb);
	}
}
