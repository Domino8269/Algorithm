/**
 *  백준 18352번 - 특정 거리의 도시 찾기
 *  알고리즘 분류 - 그래프 이론, 그래프 탐색, BFS, 최단 경로
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int K;
    static int X;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
        }

        BFS(X);

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for (int node : answer) {
                System.out.println(node);
            }
        }
    }

    public static void BFS(int node) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {node, 0});
        visited[node] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            if (temp[1] == K) {
                answer.add(temp[0]);
            }

            if (temp[1] > K) {
                break;
            }

            for (int i = 1; i <= N; i++) {
                if (graph.get(temp[0]).contains(i) && !visited[i]) {
                    q.offer(new int[] {i, temp[1] + 1});
                    visited[i] = true;
                }
            }
        }
    }
}