/*
 * 백준 2178번: 미로 탐색
 * 알고리즘 분류: #그래프 탐색 #bfs
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 배열의 위치를 저장할 Point 클래스
class Point {
    int r;
    int c;
    int cnt;
    Point(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

public class Main {
    // 상하좌우 이동 시 행과 열의 이동 범위를 저장
    static int[][] movePoint = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] map;
    static boolean[][] visited;
    static Point start;
    static Point end;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        start = new Point(1, 1, 1);
        end = new Point(N, M, 1);

        for(int i=1; i<=N; i++){
            String s = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = s.charAt(j-1) - '0';
            }
        }

        bfs();
    }

    public static void bfs (){
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.r][start.c] = true;

        while(!q.isEmpty()){
            Point temp = q.poll();
            // 현재 temp의 row, column과 도착지점(end)의 row, column이 일치하면 temp의 이동횟수(cnt)를 출력 후 종료
            if(temp.r == end.r && temp.c == end.c){
                System.out.println(temp.cnt);
                return;
            }
            // 상하좌우 4번 실행
            for(int i=0; i<4; i++){
                int r = temp.r + movePoint[i][0];
                int c = temp.c + movePoint[i][1];
                // 나이트가 이동하는 곳의 row, column 값이 맵의 크기를 벗어나는지 확인
                if(r >= 1 && r <= N && c >= 1 && c <= M) {
                    // 이동할 수 있는 칸(1)이면서 방문하지 않은 곳이면 방문
                    if (map[r][c] == 1 && !visited[r][c]) {
                        q.offer(new Point(r, c, temp.cnt + 1));
                        visited[r][c] = true;
                    }
                }
            }

        }
    }
}