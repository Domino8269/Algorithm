/**
 *  백준 1780번 - 종이의 개수
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int negative;
    static int zero;
    static int positive;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        run(N, 0, 0);
        System.out.println(negative + "\n" + zero + "\n" + positive);
    }

    public static void run(int size, int r, int c) {
        if (size == 1 || checkMap(size, r, c)) {
            if (map[r][c] == -1) {
                negative++;
            } else if (map[r][c] == 0) {
                zero++;
            } else {
                positive++;
            }

            return;
        }

        int newSize = size / 3;
        run(newSize, r, c);
        run(newSize, r, c + newSize);
        run(newSize, r, c + newSize * 2);

        run(newSize, r + newSize, c);
        run(newSize, r + newSize, c + newSize);
        run(newSize, r + newSize, c + newSize * 2);

        run(newSize, r + newSize * 2, c);
        run(newSize, r + newSize * 2, c + newSize);
        run(newSize, r + newSize * 2, c + newSize * 2);
    }

    public static boolean checkMap(int size, int r, int c) {
        int target = map[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] != target) {
                    return false;
                }
            }
        }

        return true;
    }
}