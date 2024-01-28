/**
 * 프로그래머스 Lv3
 * Title: 섬 연결하기
 */

import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return weight - e.weight;
    }
}

class Solution {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {
            int v1 = costs[i][0];
            int v2 = costs[i][1];
            int weight = costs[i][2];

            queue.offer(new Edge(v1, v2, weight));
        }

        int weight = 0;
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (find(edge.v1) != find(edge.v2)) {
                union(edge.v1, edge.v2);
                weight += edge.weight;
            }
        }

        return weight;
    }

    public static void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if (p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }

    public static int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }
}