/*
    백준 13549번: 숨바꼭질 3
    알고리즘 분류: #그래프 이론 #그래프 탐색 #BFS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int cnt;
    Point(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }
}

public class Main {
    static int n;
    static int k;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        // n이 k보다 클 경우 n부터 k까지 내림차순으로 출력
        if(n > k) {
            System.out.println(n - k);
            return;
        }
        // bfs 메서드 호출
        bfs(new Point(n, 0));
    }

    // 시작 좌표값(n)을 시작으로 너비 우선 탐색(bfs)을 이용해
    // 도착 좌표값(k)까지의 최단 경로를 찾아 최소 이동 시간을 출력
    public static void bfs (Point p) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited[p.x] = true;

        while (!q.isEmpty()) {
            Point temp = q.poll();
            // 큐에 들어있던 좌표(temp.x)와 도착 좌표(k)가 일치하면 이동 시간(cnt) 출력 후 종료
            if (temp.x == k) {
                System.out.println(temp.cnt);
                return;
            }
            /*
                배열 인덱스 범위를 벗어나지 않으면서 방문하지 않은 노드일 경우 3가지 경우를 큐에 추가 (*2, -1, +1)
                *2 는 이동 시간(cnt)을 증가하지 않고, +1, -1 은 이동 시간(cnt)을 1만큼 증가시킴
             */
            if(temp.x * 2 <= k + 1 && !visited[temp.x * 2]) {
                q.offer(new Point(temp.x * 2, temp.cnt));
                visited[temp.x * 2] = true;
            }
            if(temp.x - 1 >= 0 && !visited[temp.x - 1]) {
                q.offer(new Point(temp.x - 1, temp.cnt + 1));
                visited[temp.x - 1] = true;
            }
            if(temp.x + 1 <= k && !visited[temp.x + 1]) {
                q.offer(new Point(temp.x + 1, temp.cnt + 1));
                visited[temp.x + 1] = true;
            }
        }
    }
}