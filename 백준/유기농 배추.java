/**
 * 백준 1012번 - 유기농 배추
 * 알고리즘 분류 - 그래프 이론, 그래프 탐색, BFS, DFS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, cnt;
    static boolean[][] visited;
    static int[][] map;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            cnt = Integer.parseInt(st.nextToken());

            map = new int[r][c];
            visited = new boolean[r][c];
            for (int j = 0; j < cnt; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int answer = 0;
            for (int i = 0; i < r; i++) {
                for (int k = 0; k < c; k++) {
                    if (map[i][k] == 1 && !visited[i][k]) {
                        DFS(i, k);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void DFS(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = dirX[i] + row;
            int newCol = dirY[i] + col;

            if (newRow >= 0 && newCol >= 0 && newRow < r && newCol < c &&
                    !visited[newRow][newCol] && map[newRow][newCol] == 1) {
                DFS(newRow, newCol);
            }
        }

    }
}