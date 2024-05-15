/**
 * 백준 2096번 - 내려가기
 * 알고리즘 분류 - DP, 슬라이딩 윈도우
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] maxDP = new int[N][3];
        int[][] minDP = new int[N][3];
        // DP 배열 초기화
        for (int i = 0; i < 3; i++) {
            maxDP[0][i] = map[0][i];
            minDP[0][i] = map[0][i];
        }
        for (int i = 1; i < N; i++) {
            Arrays.fill(maxDP[i], Integer.MIN_VALUE);
            Arrays.fill(minDP[i], Integer.MAX_VALUE);
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    maxDP[i][0] = Math.max(maxDP[i - 1][0], maxDP[i - 1][1]) + map[i][0];
                    minDP[i][0] = Math.min(minDP[i - 1][0], minDP[i - 1][1]) + map[i][0];
                } else if (j == 1) {
                    maxDP[i][1] = Math.max(maxDP[i - 1][0], Math.max(maxDP[i - 1][1], maxDP[i - 1][2])) + map[i][1];
                    minDP[i][1] = Math.min(minDP[i - 1][0], Math.min(minDP[i - 1][1], minDP[i - 1][2])) + map[i][1];
                } else {
                    maxDP[i][2] = Math.max(maxDP[i - 1][1], maxDP[i - 1][2]) + map[i][2];
                    minDP[i][2] = Math.min(minDP[i - 1][1], minDP[i - 1][2]) + map[i][2];
                }
            }
        }

        int maxNum = Math.max(maxDP[N - 1][0], Math.max(maxDP[N - 1][1], maxDP[N - 1][2]));
        int minNum = Math.min(minDP[N - 1][0], Math.min(minDP[N - 1][1], minDP[N - 1][2]));
        System.out.println(maxNum + " " + minNum);
    }
}