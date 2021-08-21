import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	for(String time : timetable) {
    		pq.add(strTimeToInt(time));
    	}
    	
    	int nowTime = 540 - t; // 09½Ã00ºÐ
    	int remainSeat = -1;
    	int lastTime = 540;
    	int answerTime = -1;
    	for(int i = 0; i < n; i++) {
    		remainSeat = m;
    		nowTime += t;
    		lastTime = Math.max(lastTime, nowTime);
    		for(int j = 0; j < m; j++) {
    			if(pq.isEmpty()) break;
    			int tmpTime = pq.poll();
    			if(tmpTime <= nowTime) {
	    			lastTime = tmpTime;
	    			remainSeat -= 1;
    			}else {
    				pq.add(tmpTime);
    				break;
    			}
    		}
    		if(pq.isEmpty()) break;
    	}
    	if(!pq.isEmpty()) {
    		if(remainSeat > 0)
    			answerTime = lastTime;
    		else
    			answerTime = lastTime-1;    		
    	}else {
    		if(remainSeat > 0)    			
    			answerTime = Math.max(540, nowTime);
    		else
    			answerTime = lastTime-1;
    	}
    	
        String answer = String.format("%02d:%02d", answerTime / 60, answerTime % 60);
        return answer;
    }

    public int strTimeToInt(String time) {
    	String[] timeSplit = time.split(":");
    	return Integer.parseInt(timeSplit[0])*60 + Integer.parseInt(timeSplit[1]);
    }
    
	public static void main(String[] args) {
		Solution solution = new Solution();
		/*int n = 1;
		int t = 1;
		int m = 5;
		String[] timetable = {"08:00", "08:01", "08:02", "08:03"};*/
		int n = 2;
		int t = 10;
		int m = 3;
		String[] timetable = {"09:00", "09:00", "09:00", "09:00"};
		System.out.println(solution.solution(n, t, m, timetable));
	}

}
