/**
 * 프로그래머스 Lv2
 * Title - 피로도
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int maxDungeon;
    static int fatigue;
    static int[] sequence;
    static int[][] dump;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
        System.out.println(maxDungeon);
    }

    public static int solution(int k, int[][] dungeons) {
        fatigue = k;
        dump = dungeons;
        sequence = new int[dungeons.length];
        visited = new boolean[dungeons.length];
        dfs(0, dungeons.length);

        return maxDungeon;
    }

    public static void dfs(int depth, int size) {
        if (depth == size) {
            maxDungeon = Math.max(run(), maxDungeon);
        }

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i;
                dfs(depth + 1, size);
                visited[i] = false;
            }
        }
    }

    public static int run() {
        int pirodo = fatigue;
        int max = 0;

        for (int i = 0; i < sequence.length; i++) {
            if (dump[sequence[i]][0] <= pirodo) {
                pirodo -= dump[sequence[i]][1];
                max++;
            } else {
                break;
            }
        }

        return max;
    }
}