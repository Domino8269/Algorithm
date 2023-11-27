/**
 *  백준 16926번 - 배열 돌리기 1
 *  알고리즘 분류 - #구현
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            rotate();
        }

        printMap();
    }

    public static void rotate() {
        int stage = Math.min(N, M) / 2;

        for (int i = 0; i < stage; i++) {
            int row = i;
            int col = i;
            int temp = map[i][i];
            int idx = 0;

            while (idx < 4) {
                int nRow = row + dx[idx];
                int nCol = col + dy[idx];

                if (nRow >= i && nRow < N - i && nCol >= i && nCol < M - i) {
                    map[row][col] = map[nRow][nCol];
                    row += dx[idx];
                    col += dy[idx];
                } else {
                    idx++;
                }
            }

            map[i + 1][i] = temp;
        }
    }

    public static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}