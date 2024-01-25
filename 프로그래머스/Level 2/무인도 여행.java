/**
 * 프로그래머스 Lv2
 * Title: 무인도 여행
 */

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static int row;
    static int col;
    static int sum;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public int[] solution(String[] maps) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        row = maps.length;
        col = maps[0].length();
        map = new char[row][col];
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    DFS(i, j, visited);
                    arrayList.add(sum);
                    sum = 0;
                }
            }
        }

        int[] answer = new int[Math.max(arrayList.size(), 1)];
        if (arrayList.isEmpty()) {
            answer[0] = -1;
        } else {
            for (int i = 0; i < answer.length; i++) {
                answer[i] = arrayList.get(i);
            }
            Arrays.sort(answer);
        }

        return answer;
    }

    public static void DFS(int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        sum += map[i][j] - '0';
        for (int k = 0; k < 4; k++) {
            int newRow = i + dx[k];
            int newCol = j + dy[k];
            if (0 <= newRow && newRow < row && 0 <= newCol && newCol < col) {
                if (!visited[newRow][newCol] && map[newRow][newCol] != 'X') {
                    DFS(newRow, newCol, visited);
                }
            }
        }
    }
}