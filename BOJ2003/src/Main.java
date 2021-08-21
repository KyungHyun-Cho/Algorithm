import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;
    static int[] nums;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int right = 0;
        int left = 0;
        int count = 0;
        int sum = nums[0];

        while(true){
            if (sum == K){
                count++;
                sum -= nums[left++];
            }
            else if (sum < K){
                sum += nums[++right];
            }
            else if (sum > K){
                sum -= nums[left++];
            }
            if (right == N){
                break;
            }
        }
        System.out.println(count);
    }
}

