/*
 * 백준 7562번: 나이트 이동
 * 알고리즘 분류: #그래프 탐색 #bfs
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 좌표와 이동횟수(cnt)를 저장할 Point 클래스
class Point {
    int x;
    int y;
    int cnt;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.cnt = 0;
    }
    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {
    // 나이트의 8가지 이동방향에 대한 x, y 좌표 이동값을 배열에 저장
    static int[][] moveXY = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    static int l;
    static boolean[][] visited;
    static Point start;
    static Point end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs(start);
        }
    }

    public static void bfs (Point p){
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited[p.x][p.y] = true;

        while(!q.isEmpty()){
            Point temp = q.poll();
            // 현재 temp의 좌표값과 도착지점(end)의 좌표값이 일치하면 현재 temp의 이동횟수(cnt)를 출력 후 종료
            if(temp.x == end.x && temp.y == end.y){
                System.out.println(temp.cnt);
                return;
            }
            // 나이트의 이동방법이 8가지이므로 8번 수행
            for(int i=0; i<8; i++){
                int x = temp.x + moveXY[i][0];
                int y = temp.y + moveXY[i][1];
                // 나이트가 이동하는 곳의 x, y 좌표가 맵의 크기를 벗어나지 않으면서 방문하지 않은 곳이면 큐에 추가 후 방문체크
                if(x>=0 && x < l && y>=0 && y < l && !visited[x][y]) {
                    q.offer(new Point(x, y, temp.cnt + 1));
                    visited[x][y] = true;
                }
            }

        }
    }
}