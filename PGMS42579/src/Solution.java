import java.util.*;
class GenreInfo implements Comparable<GenreInfo>{
	int no, cnt;
	GenreInfo(int no, int cnt){
		this.no = no;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(GenreInfo o) {
		if(o.cnt == cnt)
			return no - o.no;
		return o.cnt-cnt;
	}
	
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
    	HashMap<String, PriorityQueue<GenreInfo>> infoPerGenre = new HashMap<>();
    	HashMap<String, Integer> sumPerGenre = new HashMap<>();
    	TreeMap<Integer, String> genrePerSum = new TreeMap<>(Collections.reverseOrder());
    	
    	for(int i = 0; i < genres.length; i++) {
    		if(!sumPerGenre.containsKey(genres[i]))
    			sumPerGenre.put(genres[i], plays[i]);
    		else
    			sumPerGenre.put(genres[i], sumPerGenre.get(genres[i]) + plays[i]);
    		
    		if(!infoPerGenre.containsKey(genres[i]))
    			infoPerGenre.put(genres[i], new PriorityQueue<GenreInfo>());
    		infoPerGenre.get(genres[i]).add(new GenreInfo(i, plays[i]));
    	}
    	
    	for(String key : sumPerGenre.keySet())
    		genrePerSum.put(sumPerGenre.get(key), key);
    	
    	int arrCnt = 0;
    	for(PriorityQueue<GenreInfo> pq : infoPerGenre.values())
    		arrCnt += Math.min(pq.size(), 2);
    	
    	int[] answer = new int[arrCnt];
    	int idx = 0;
    	
    	for(String genre : genrePerSum.values()) {
    		for(int i = 0; i < 2; i++)
    			if(!infoPerGenre.get(genre).isEmpty())
    				answer[idx++] = infoPerGenre.get(genre).poll().no;
    	}
        return answer;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int[] ans = solution.solution(genres, plays);
	}
}
