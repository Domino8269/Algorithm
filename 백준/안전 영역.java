/**
 *  백준 2468번 - 안전 영역
 *  알고리즘 분류 - 그래프 이론, 그래프 탐색, DFS, BFS, 브루트포스
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxArea = 0;
        for (int i = 0; i <= 100; i++) {
            int cnt = 0;
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] >= i && !visited[j][k]) {
                        DFS(i, j, k);
                        cnt++;
                    }
                }
            }

            maxArea = Math.max(maxArea, cnt);
        }

        System.out.println(maxArea);
    }

    public static void DFS(int high, int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dirX[i];
            int newCol = col + dirY[i];

            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N
                    && !visited[newRow][newCol] && map[newRow][newCol] >= high) {
                DFS(high, newRow, newCol);
                visited[newRow][newCol] = true;
            }
        }
    }
}