/*
    프로그래머스 Lv2
    Title: 멀리 뛰기
 */
class Solution {
    static long[] dp = new long[2000];

    public long solution(int n) {
        dp[0] = 1;  // n이 1일때 경우의 수
        dp[1] = 2;  // n이 2일때 경우의 수
        // n개의 칸에 도달하는 경우의 수를 구해서 리턴
        return dp(n - 1);
    }

    public static long dp(int n) {
        if(n <= 1) {
            return dp[n];
        }
        if(dp[n]==0) {
            // n개의 칸에 도달하는 경우의 수는
            // 이전 2개의 칸(n-1, n-2)에 도달하는 경우의 수의 합
            dp[n] = dp(n-1) % 1234567 + dp(n-2) % 1234567;
        }
        return dp[n] % 1234567;
    }

}