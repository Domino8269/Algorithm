/*
    백준 17144번: 미세먼지 안녕!
    알고리즘 분류: #구현 #시뮬레이션
 */
import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] map;
    static int[] cleaner;   // 공기청정기 위치

    static int[][] movePoint = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cleanerCnt = 0;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        cleaner = new int[2];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    cleaner[cleanerCnt++] = i;
                }
            }
        }

        // 초 단위로 먼지의 확산, 공기청정기 실행을 반복
        for (int t = 0; t < T; t++) {
            spreadDust();
            runCleaner();
        }

        System.out.println(countDust());
    }

    // 미세먼지의 확산
    static void spreadDust() {
        int[][] newMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    int spreadAmount = map[i][j] / 5;
                    int spreadCount = 0;

                    for (int k = 0; k < 4; k++) {
                        int dr = i + movePoint[k][0];
                        int dc = j + movePoint[k][1];

                        if (dr >= 0 && dr < R && dc >= 0 && dc < C && map[dr][dc] != -1) {
                            newMap[dr][dc] += spreadAmount;
                            spreadCount++;
                        }
                    }

                    newMap[i][j] = (newMap[i][j] + map[i][j]) - (spreadAmount * spreadCount);
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = newMap[i][j];
            }
        }

        map[cleaner[0]][0] = -1;
        map[cleaner[1]][0] = -1;
    }

    // 공기청정기 작동
    static void runCleaner() {
        int upR = cleaner[0];
        int downR = cleaner[1];

        // 위쪽 공기 순환
        for (int r = upR - 1; r > 0; r--) {
            map[r][0] = map[r - 1][0];
        }
        for (int c = 0; c < C - 1; c++) {
            map[0][c] = map[0][c + 1];
        }
        for (int r = 0; r < upR; r++) {
            map[r][C - 1] = map[r + 1][C - 1];
        }
        for (int c = C - 1; c > 1; c--) {
            map[upR][c] = map[upR][c - 1];
        }
        map[upR][1] = 0;

        // 아래쪽 공기 순환
        for (int r = downR + 1; r < R - 1; r++) {
            map[r][0] = map[r + 1][0];
        }
        for (int c = 0; c < C - 1; c++) {
            map[R - 1][c] = map[R - 1][c + 1];
        }
        for (int r = R - 1; r > downR; r--) {
            map[r][C - 1] = map[r - 1][C - 1];
        }
        for (int c = C - 1; c > 1; c--) {
            map[downR][c] = map[downR][c - 1];
        }
        map[downR][1] = 0;
    }

    // 현재 미세먼지의 양을 계산
    static int countDust() {
        int count = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    count += map[i][j];
                }
            }
        }

        return count;
    }
}