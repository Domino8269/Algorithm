/**
 * 백준 2624번 - 동전 바꿔주기
 * 알고리즘 분류 - DP
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] coins = new int[k][2];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i][0] = Integer.parseInt(st.nextToken());
            coins[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[T + 1];
        dp[0] = 1;
        for (int i = 0; i < k; ++i) {
            int coin_val = coins[i][0];
            int coin_cnt = coins[i][1];

            for (int j = T; j > 0; j--) {
                for (int l = 1; l <= coin_cnt && j - coin_val * l >= 0; l++) {
                    dp[j] += dp[j - coin_val * l];
                }
            }
        }

        System.out.println(dp[T]);
    }
}