/*
    백준 9251번: LCS
    알고리즘 분류: #문자열 #DP
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        // 인덱스를 한 줄씩 추가
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        // 1부터 시작해서 두 문자열의 각 문자를 비교
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                // 두 문자가 같다면 이전 행(i-1), 이전 열(j-1)의 dp에 +1 한 값으로 갱신
                if(s1[i-1] == s2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                // 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        // dp 배열의 마지막 원소가 LCS(최장 공통 부분 수열)의 길이가 됨
        System.out.println(dp[s1.length][s2.length]);
    }
}