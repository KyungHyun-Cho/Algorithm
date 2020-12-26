import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int INF = 16000000;
    static int n;
    static int map[][], dp[][];
    // dp[node][visit] = k -> 현재 node번에 잇고 visit를 방문하고 왔을 때
    // 0번 노드로 가는 최소의 거리

    public static void main(String[] args){
        /*for(int i = 0 ; i < 8; i++){
            int next = 1 | (1 << i);
            System.out.println(next);
        }*/
    	Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        dp = new int[n][(1 << n) - 1]; // 도시의 수(n)가 4라고 하면 dp최대값은 dp[3][1111];

        for(int i = 0 ; i < n; i++)
            Arrays.fill(dp[i], INF);

        for(int i = 0 ; i < n ; i++)
            for(int j = 0; j < n; j++)
            	map[i][j] = sc.nextInt();

        System.out.println(tsp(0, 1));

        sc.close();
    }

    private static int tsp(int node, int visit){
        // 모든 지점을 방문한 경우
        if(visit == (1 << n) - 1){
            if(map[node][0] == 0) return INF; // 0번 노드로 돌아갈 방법이 없는 경우
            return map[node][0];
        }


        // 이미 방문한 노드
        if(dp[node][visit] != INF) return dp[node][visit];
        
        
        for(int i = 0 ; i < n; i++){
            //길이 있으면서 && 방문을 안했으면
            if(map[node][i] != 0 && (visit & (1 << i)) == 0) {
            	dp[node][visit] = Math.min(dp[node][visit], tsp(i, visit | (1 << i)) + map[node][i]);
            }
        }

        return dp[node][visit];
    }
}