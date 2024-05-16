/**
 * 백준 14503번 - 로봇 청소기
 * 알고리즘 분류 - 구현, 시뮬레이션
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int robotR, robotC, robotDir;
    static int[][] map;
    static int[] dirR = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dirC = {-1, 1, 0, 0, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        robotR = Integer.parseInt(st.nextToken());
        robotC = Integer.parseInt(st.nextToken());
        robotDir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(run());
    }

    public static int run() {
        int answer = 0;

        Loop1:
        while (true) {
            if (map[robotR][robotC] == 0) {
                map[robotR][robotC] = 2;
                answer++;
            } else {
                for (int i = 0; i < 4; i++) {
                    int moveR = robotR + dirR[i];
                    int moveC = robotC + dirC[i];

                    if (map[moveR][moveC] == 0) {
                        turn();
                        continue Loop1;
                    }
                }

                if (!backward()) {
                    break Loop1;
                }
            }
        }

        return answer;
    }

    public static void turn() {
        int dir = robotDir;
        for (int i = 0; i < 4; i++) {
            int r = robotR;
            int c = robotC;
            dir = (dir == 0) ? 3 : dir - 1;
            if (dir == 0) r--;
            if (dir == 1) c++;
            if (dir == 2) r++;
            if (dir == 3) c--;
            if (r < N && 0 <= r && c < M && 0 <= c && map[r][c] == 0) {
                robotR = r;
                robotC = c;
                robotDir = dir;
                break;
            }
        }
    }

    public static boolean backward() {
        int r = robotR;
        int c = robotC;

        if (robotDir == 0) r++;
        if (robotDir == 1) c--;
        if (robotDir == 2) r--;
        if (robotDir == 3) c++;
        if (r < N && 0 < r && c < M && 0 < c && map[r][c] != 1) {
            robotR = r;
            robotC = c;
        } else {
            return false;
        }

        return true;
    }
}