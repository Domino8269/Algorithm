/*
 * 백준 1149번: RGB거리
 * 알고리즘 분류: #dp
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
	
        for (int i = 0; i < 3; i++) {
            int temp = minCost(i, N - 1);	// 0 -> 빨강, 1-> 초록, 2-> 파랑

            if (temp < min) {
                min = temp;
            }
        }

        System.out.println(min);
    }

    public static int minCost(int color, int N) {
        int result = 0;

        // 기저 조건
        if (N == 0) {
            return cost[0][color];
        }
        // 이미 계산된 값이라면, 해당 값을 리턴
        if(dp[N][color] != 0) {
            result = dp[N][color];
        } else {
            if(color == 0) {
                dp[N][0] = cost[N][0] + Math.min(minCost(1, N - 1), minCost(2, N - 1));
                result = dp[N][0];
            } else if(color == 1) {
                dp[N][1] = cost[N][1] + Math.min(minCost(0, N - 1), minCost(2, N - 1));
                result = dp[N][1];
            } else if(color == 2) {
                dp[N][2] = cost[N][2] + Math.min(minCost(0, N - 1), minCost(1, N - 1));
                result = dp[N][2];
            }
        }

        return result;
    }
}