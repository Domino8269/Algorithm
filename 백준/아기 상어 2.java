/*
    백준 17086번: 아기 상어 2
    알고리즘 분류: #그래프 이론 #그래프 탐색 #BFS
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int row;
    int col;
    int cnt;
    Point(int row, int col, int cnt) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}

public class Main {
    static int N;
    static int M;
    static int result = 0;
    static int[][] map;
    static boolean[][] visited;
    // 8방향의 이동 좌표
    static int[][] movePoint = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    result = Math.max(bfs(new Point(i, j, 0)), result);
                }
            }
        }

        System.out.println(result);
    }

    public static int bfs(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited = new boolean[N][M];
        visited[p.row][p.col] = true;

        while(!q.isEmpty()) {
            Point temp = q.poll();

            if(map[temp.row][temp.col] == 1) {
                return temp.cnt;
            }

            // 8방향 이동
            for (int i = 0; i < movePoint.length; i++) {
                int dr = temp.row + movePoint[i][0];
                int dc = temp.col + movePoint[i][1];
                // row, column의 이동값이 배열의 범위를 벗어나지 않으면서
                if ((0 <= dr && dr < N) && (0 <= dc && dc < M)) {
                    // 방문하지 않은 노드이면 큐에 추가
                    if(!visited[dr][dc]) {
                        // 해당 노드를 큐에 추가 후, 방문 체크
                        q.offer(new Point(dr, dc, temp.cnt + 1));
                        visited[dr][dc] = true;
                    }
                }
            }
        }

        return 0;
    }
}