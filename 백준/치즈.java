/*
    백준 2638번: 치즈
    알고리즘 분류: #구현 #시뮬레이션 #그래프 탐색 #dfs #bfs
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 행과 열 번호를 저장할 Point 클래스
class Point {
    int row;
    int col;
    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {
    static int n;
    static int m;
    static int cnt = 0;
    static int[][] map;
    static boolean[][] visited;
    // 상하좌우 이동 시 행과 열의 이동 범위를 저장
    static int[][] movePoint = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 배열의 첫 요소를 기준으로 bfs 함수 호출
        Point start = new Point(0, 0);
        bfs(start);
        // 맵에 치즈가 존재하지 않을 때까지 반복
        while(true) {
            if(!meltCheese()) {
                System.out.println(cnt);
                break;
            }
            else {
                bfs(start);
                cnt++;
            }
        }
    }
    // 배열을 순회하면서 외부 공기에 해당하는 칸의 값을 2로 설정
    public static void bfs(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited = new boolean[n][m];
        visited[p.row][p.col] = true;

        while(!q.isEmpty()){
            Point temp = q.poll();
            // 큐에 들어있던 노드에 해당하는 위치의 값을 2로 변경
            map[temp.row][temp.col] = 2;
            // 상하좌우 4번 이동
            for (int i = 0; i < 4; i++) {
                int dr = temp.row + movePoint[i][0];
                int dc = temp.col + movePoint[i][1];
                // row, column의 이동값이 배열의 범위를 벗어나지 않으면서
                if ((0 <= dr && dr < n) && (0 <= dc && dc < m)) {
                    // 방문하지 않은 노드이고, 값이 1이 아닐 때(치즈 내부로는 들어가지 않음)
                    if(!visited[dr][dc] && map[dr][dc] != 1) {
                        // 해당 노드를 큐에 추가 후, 방문 체크
                        q.offer(new Point(dr, dc));
                        visited[dr][dc] = true;
                    }
                }
            }
        }
    }
    // 녹을 치즈를 찾아서 해당 위치의 값을 변경해주는 함수
    public static boolean meltCheese() {
        // 주변 4방향에 외부 공기가 얼마나 맞닿아 있는지를 카운트하는 twoCnt 변수
        int twoCnt;
        // 맵에 치즈의 존재 여부를 확인하는 flag. 치즈가 하나도 존재하지 않는다면 false를 리턴
        boolean flag = false;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 해당 칸이 1이라면(치즈가 놓여져 있다면)
                if(map[i][j] == 1) {
                    twoCnt = 0;
                    flag = true;
                    // 주변 4방향을 확인해서 외부 공기와의 접촉 여부를 확인
                    for (int k = 0; k < 4; k++) {
                        int dr = i + movePoint[k][0];
                        int dc = j + movePoint[k][1];
                        // 맵의 범위를 벗어나지 않으면서, 값이 2(외부공기)라면 twoCnt를 1만큼 증가
                        if ((0 <= dr && dr < n) && (0 <= dc && dc < m) && map[dr][dc] == 2) {
                            twoCnt++;
                        }
                    }
                    // 4방향을 확인한 후, twoCnt가 2보다 크다면 2개의 변 이상이 외부공기와 접촉해 있으므로
                    // 해당 위치의 값을 0으로 변경 (이후 bfs 함수 호출로 인해 0 -> 2로 변경됨)
                    if(twoCnt >= 2) {
                        map[i][j] = 0;
                    }
                }
            }
        }

        return flag;
    }
}