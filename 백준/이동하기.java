/**
 *  백준 11048번 - 이동하기
 *  알고리즘 분류 - DP
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Integer[][] map;
    static Integer[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new Integer[N][M];
        dp = new Integer[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findMax(N - 1, M -1));
    }

    public static int findMax(int row, int col) {
        if (row < 0 || col < 0) {
            return 0;
        }

        if (dp[row][col] == null) {
            dp[row][col] = Math.max(Math.max(findMax(row, col - 1), findMax(row - 1, col)),
                    findMax(row - 1, col -1 )) + map[row][col];
        }

        return dp[row][col];
    }
}