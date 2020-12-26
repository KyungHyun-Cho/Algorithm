import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int INF = 16000000;
    static int n;
    static int map[][], dp[][];
    // dp[node][visit] = k -> ���� node���� �հ� visit�� �湮�ϰ� ���� ��
    // 0�� ���� ���� �ּ��� �Ÿ�

    public static void main(String[] args){
        /*for(int i = 0 ; i < 8; i++){
            int next = 1 | (1 << i);
            System.out.println(next);
        }*/
    	Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        dp = new int[n][(1 << n) - 1]; // ������ ��(n)�� 4��� �ϸ� dp�ִ밪�� dp[3][1111];

        for(int i = 0 ; i < n; i++)
            Arrays.fill(dp[i], INF);

        for(int i = 0 ; i < n ; i++)
            for(int j = 0; j < n; j++)
            	map[i][j] = sc.nextInt();

        System.out.println(tsp(0, 1));

        sc.close();
    }

    private static int tsp(int node, int visit){
        // ��� ������ �湮�� ���
        if(visit == (1 << n) - 1){
            if(map[node][0] == 0) return INF; // 0�� ���� ���ư� ����� ���� ���
            return map[node][0];
        }


        // �̹� �湮�� ���
        if(dp[node][visit] != INF) return dp[node][visit];
        
        
        for(int i = 0 ; i < n; i++){
            //���� �����鼭 && �湮�� ��������
            if(map[node][i] != 0 && (visit & (1 << i)) == 0) {
            	dp[node][visit] = Math.min(dp[node][visit], tsp(i, visit | (1 << i)) + map[node][i]);
            }
        }

        return dp[node][visit];
    }
}