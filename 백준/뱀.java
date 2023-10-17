/*
    백준 3190번: 뱀
    알고리즘 분류: #구현 #시뮬레이션 #자료구조 #덱 #큐
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static HashMap<Integer, String> hm = new HashMap<>();
    // 오른쪽, 아래, 왼쪽, 위 (위치 변환값)
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            // 사과가 있는 곳의 값을 2로 초기화
            map[row - 1][col - 1] = 2;
        }

        // 방향 전환 정보를 해시맵에 저장
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            hm.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        play();
    }

    public static void play() {
        Deque<int[]> snake = new ArrayDeque<>(); // 뱀의 몸 위치를 관리할 Deque
        snake.offer(new int[]{0, 0}); // 초기 뱀의 머리 위치를 큐에 추가
        int direction = 0; // 초기 방향 (오른쪽)
        int time = 1;

        while (true) {
            int[] head = snake.peekLast(); // 뱀의 머리 위치
            int newRow = head[0] + dx[direction];
            int newCol = head[1] + dy[direction];

            if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N || map[newRow][newCol] == 1) {
                // 벽에 부딪히거나 자신의 몸과 부딪히면 게임 종료
                System.out.println(time);
                break;
            }

            if (map[newRow][newCol] != 2) {
                // 이동한 칸에 사과가 없다면 꼬리를 제거
                int[] tail = snake.pollFirst();
                map[tail[0]][tail[1]] = 0;
            }

            snake.offer(new int[]{newRow, newCol}); // 새로운 머리 추가
            map[newRow][newCol] = 1;

            if (hm.containsKey(time)) {
                String turn = hm.get(time);
                if (turn.equals("L")) {
                    direction = (direction + 3) % 4; // 왼쪽으로 90도 회전
                } else {
                    direction = (direction + 1) % 4; // 오른쪽으로 90도 회전
                }
            }

            time++;
        }
    }
}