/**
 *  프로그래머스 Lv2
 *  Title: 전력망을 둘로 나누기
 */
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[][] graph;
    static boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }

        for (int[] wire : wires) {
            int num1 = countNode(wire[0], wire[1], n);
            int num2 = countNode(wire[1], wire[0], n);

            if (Math.abs(num1 - num2) < answer) {
                answer = Math.abs(num1 - num2);
            }
        }

        return answer;
    }

    public static int countNode(int start, int blockNode, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited = new boolean[n + 1];
        visited[start] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int i = 1; i <= n; i++) {
                if (graph[node][i] && !visited[i] && i != blockNode) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }

        return count;
    }
}