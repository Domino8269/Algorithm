/**
 *  백준 2644번 - 촌수계산
 *  알고리즘 분류 - 그래프 이론, 그래프 탐색, DFS, BFS
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int nodeCnt;
    static int edgeCnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        nodeCnt = Integer.parseInt(br.readLine());
        visited = new boolean[nodeCnt + 1];
        graph = new boolean[nodeCnt + 1][nodeCnt + 1];
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }

        System.out.println(BFS(start, end));
    }

    public static int BFS(int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            if (temp[0] == end) {
                return temp[1];
            }

            for (int i = 1; i <= nodeCnt; i++) {
                if (graph[temp[0]][i] && !visited[i]) {
                    q.offer(new int[] {i, temp[1] + 1});
                    visited[i] = true;
                }
            }
        }

        return -1;
    }
}