/**
 * 백준 1043번 - 거짓말
 * 알고리즘 분류 - 그래프 이론, 그래프 탐색, 자료구조, 분리집합
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int parentTrue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        parentTrue = 0;

        st = new StringTokenizer(br.readLine());
        int participants = Integer.parseInt(st.nextToken());

        int[] truePeople = new int[participants];
        for (int i = 0; i < participants; i++) {
            truePeople[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < participants - 1; i++) {
            union(truePeople[i], truePeople[i + 1]);
        }

        if (truePeople.length != 0) {
            parentTrue = truePeople[0];
        }

        int[][] party = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            party[i] = new int[p];

            for (int j = 0; j < p; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < p - 1; j++) {
                union(party[i][j], party[i][j + 1]);
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            boolean flag = false;
            for (int j = 0; j < party[i].length; j++) {
                if (find(party[i][j]) == parentTrue) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a == parentTrue) {
                parent[b] = a;
            } else if (b == parentTrue) {
                parent[a] = b;
            } else {
                parent[b] = a;
            }
        }
    }
}