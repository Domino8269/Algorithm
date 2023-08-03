/*
    백준 7576번: 토마토
    알고리즘 분류: #그래프 탐색 #bfs
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2차원 배열의 위치(r -> 행, c -> 열)와 이동 횟수(cnt)를 저장할 Point 클래스
class Point {
    int r;
    int c;
    int cnt;
    Point(int r, int c, int cnt) {
        this(r, c);
        this.cnt = cnt;
    }
    Point(int r, int c) {
        this.r = r;
        this.c = c;
        this.cnt = 0;
    }
}

public class Main {
    // 상하좌우 이동 시 행과 열의 이동 범위를 저장
    static int[][] movePoint = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] map;
    static int row;
    static int col;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        // 2차원 배열 map에 토마토들의 상태를 저장
        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        int day = bfs();
        // map에 0이 존재한다면 토마토가 모두 익지 못하는 상황이므로 -1 출력
        if(findZero()){
            System.out.println(-1);
        }
        // 0이 존재하지 않는다면 모든 토마토가 익어있는 상태이므로 day를 출력
        else{
            System.out.println(day);
        }
    }
    // bfs(넓이 우선 탐색)를 사용해 토마토가 모두 익는 데 걸리는 최소 날짜(day)를 구해 이를 반환
    public static int bfs(){
        Queue<Point> q = new LinkedList<>();
        // 익어 있는 토마토(1)를 모두 찾아 큐에 집어넣음. (큐는 처음 주어진 map의 1의 위치를 모두 갖고 시작함)
        findOne(q);
        // 최소 날짜를 저장할 lastCnt
        int lastCnt = 0;
        while(!q.isEmpty()){
            Point temp = q.poll();
            // 상하좌우로 영향을 줄 수 있으므로 4번 실행
            for(int i = 0; i < 4; i++){
                int r = temp.r + movePoint[i][0];
                int c = temp.c + movePoint[i][1];
                // 해당 칸으로 이동 가능하면서(맵을 벗어나지 않으면서) 익지 않은 토마토(0)가 있는 칸이라면
                if((0 <= r && r < row) && (0 <= c && c < col) && map[r][c] == 0){
                    // 해당 칸을 익은 토마토(1)로 만들고 큐에 삽입
                    map[r][c] = 1;
                    q.offer(new Point(r, c, temp.cnt + 1));
                }
            }
            // 현재 칸의 이동 횟수(cnt)를 저장
            lastCnt = temp.cnt;
        }
        // 큐가 모두 비었을 때(더 이상 이동할 수 없을 때) 마지막에 큐에 들어있던 칸의 이동 횟수(cnt)가 최소 날짜가 됨
        return lastCnt;
    }
    // map에서 1을 탐색해서 해당 칸의 위치를 큐에 삽입
    public static void findOne(Queue q){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(map[i][j] == 1){
                    q.offer(new Point(i, j));
                }
            }
        }
    }
    // map에 0이 존재한다면 true, 아니라면 false를 리턴
    public static boolean findZero(){
        boolean hasZero = false;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(map[i][j] == 0){
                    hasZero = true;
                }
            }
        }

        return hasZero;
    }
}