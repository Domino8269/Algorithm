/*
    백준 1890번: 점프
    알고리즘 분류: #DP
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 시작 지점에서 이동할 수 있는 칸의 값을 1로 초기화
        if (map[0][0] < N) {
            dp[map[0][0]][0] = 1;
            dp[0][map[0][0]] = 1;
        }
        // bottom-up 방식으로, 시작 지점에서 해당 칸까지 가는 경로의 수를 누적해서 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 해당 칸까지 오는 경로가 적어도 1개 이상 존재하고, 도착 지점이 아닐 경우
                if (dp[i][j] > 0 && !(i == N - 1 && j == N - 1)) {
                    // 맵을 벗어나지 않는다면, 해당 칸에서 이동할 수 있는 칸에 이동 경로의 수를 누적해서 더해줌
                    if(map[i][j] + i < N) {
                        dp[i + map[i][j]][j] += dp[i][j];
                    }
                    if(map[i][j] + j < N) {
                        dp[i][j + map[i][j]] += dp[i][j];
                    }
                }
            }
        }
        // 도착 지점에 저장된 경로의 수를 출력
        System.out.println(dp[N - 1][N - 1]);
    }
}