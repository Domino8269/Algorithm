/**
 * 백준 2667번 - 단지번호붙이기
 * 알고리즘 분류 - 그래프 이론, 그래프 탐색, BFS, DFS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static int cnt = 1;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> answer = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 1 && !visited[r][c]) {
                    DFS(r, c);
                    answer.add(cnt);
                    cnt = 1;
                }
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for (int num : answer) {
            System.out.println(num);
        }
    }

    public static void DFS(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = dirX[i] + row;
            int newCol = dirY[i] + col;

            if (newRow >= 0 && newCol >= 0 && newRow < N && newCol < N &&
                    !visited[newRow][newCol] && map[newRow][newCol] == 1) {
                cnt++;
                DFS(newRow, newCol);
            }
        }
    }
}