/*
    백준 1520번: 내리막길
    알고리즘 분류: #DP #DFS #그래프 이론
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static Integer[][] dp;
    // 상하좌우 이동 시 행과 열의 이동 범위를 저장
    static int[][] movePoint = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new Integer[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));
    }

    // (row, col)에서 목표 지점까지 도달하는 경로의 개수를 반환하는 함수
    public static int dfs(int row, int col) {
        if(row == N - 1 && col == M - 1) {
            return 1;
        }
        // (row, col)에서 목표 지점까지 도달하는 경로의 개수가 계산되어 있다면 그 값을 반환
        if(dp[row][col] != null) {
            return dp[row][col];
        }

        dp[row][col] = 0;   // 현재 위치에서 목표 지점까지 도달하는 경로의 개수를 0으로 초기화
        // 상하좌우 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int dr = row + movePoint[i][0];
            int dc = col + movePoint[i][1];
            // 행과 열의 이동 좌표가 배열의 범위를 벗어나지 않으면서
            if ((0 <= dr && dr < N) && (0 <= dc && dc < M)) {
                // 이동하는 칸의 값이 현재 칸의 값보다 낮다면 (dr, dc)에서 목표 지점까지 도달하는 경로의 개수를 더함
                if (map[dr][dc] < map[row][col]) {
                    dp[row][col] += dfs(dr, dc);
                }
            }
        }

        return dp[row][col];
    }
}