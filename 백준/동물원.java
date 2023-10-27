/*
    백준 1309번: 동물원
    알고리즘 분류: #dp
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n];

        if (n == 1) {
            System.out.println(3);
            return;
        }

        dp[0] = 3;
        dp[1] = 7;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901;
        }

        System.out.println(dp[n - 1]);
    }
}
