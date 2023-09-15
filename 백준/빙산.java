/*
    백준 2573번: 빙산
    알고리즘 분류: #구현 #그래프 이론 #그래프 탐색 #DFS #BFS
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int year;
    static int[][] map;
    static boolean[][] visited;
    // 상하좌우 이동 시 행과 열의 이동 범위를 저장
    static int[][] movePoint = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        // 빙산의 정보를 2차원 배열에 입력받음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                // 0일경우 -1로 저장
                map[i][j] = num == 0 ? -1 : num;
            }
        }

        while(true) {
            // 빙산의 덩어리 수를 count
            int cnt = 0;

            // dfs 함수를 호출해 빙산이 몇 덩어리인지 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] > 0 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                        // 두 덩어리가 되는 순간 현재 year를 출력 후 종료
                        if(cnt >= 2) {
                            System.out.println(year);
                            return;
                        }
                    }
                }
            }
            // 빙산이 존재하지 않는다면 0을 출력 후 종료
            if(cnt == 0) {
                System.out.println(0);
                return;
            }
            // 1년 후 녹을 빙산을 배열에 반영
            afterYear();
        }

    }

    // 1년 후 빙산의 변화를 계산하여 map에 반영
    public static void afterYear() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] > 0) {
                    int cnt = 0;
                    // 상하좌우 네 방향을 조사해, 인접한 바닷물 칸의 수를 count
                    for (int k = 0; k < 4; k++) {
                        if(map[i + movePoint[k][0]][j + movePoint[k][1]] == -1) {
                            cnt++;
                        }
                    }
                    map[i][j] = Math.max(map[i][j] - cnt, 0);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = -1;
                }
            }
        }
        // 년도를 증가시키고, 방문 체크 배열을 초기화
        year++;
        visited = new boolean[N][M];
    }

    public static void dfs (int r, int c) {
        visited[r][c] = true;

        for (int k = 0; k < 4; k++) {
            int row = r + movePoint[k][0];
            int col = c + movePoint[k][1];
            if(map[row][col] > 0 && !visited[row][col]) {
                dfs(row, col);
            }
        }

    }
}