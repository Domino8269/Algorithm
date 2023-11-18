/**
 *  백준 4179번 - 불!
 *  알고리즘 분류 - #그래프 이론 #그래프 탐색 #BFS
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int row;
    int col;
    int time;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class Main {
    static int R;
    static int C;
    static char[][] map;
    static boolean[][] visited;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        Queue<Position> jihoonQueue = new LinkedList<>();
        Queue<Position> fireQueue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'J') {
                    map[i][j] = '.';
                    jihoonQueue.add(new Position(i, j, 0));
                    visited[i][j] = true;
                } else if (map[i][j] == 'F') {
                    fireQueue.add(new Position(i, j, 0));
                }
            }
        }

        int escapeTime = BFS(jihoonQueue, fireQueue);

        if (escapeTime == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(escapeTime);
        }
    }

    private static int BFS(Queue<Position> jinhoQueue, Queue<Position> fireQueue) {
        int escapeTime = -1;

        while (!jinhoQueue.isEmpty()) {
            // 불 퍼뜨리기
            int fireSize = fireQueue.size();
            for (int k = 0; k < fireSize; k++) {
                Position firePos = fireQueue.poll();
                for (int[] dir : directions) {
                    int newRow = firePos.row + dir[0];
                    int newCol = firePos.col + dir[1];
                    if (newRow >= 0 && newRow < R && newCol >= 0 && newCol < C
                            && map[newRow][newCol] == '.') {
                        map[newRow][newCol] = 'F';
                        fireQueue.add(new Position(newRow, newCol));
                    }
                }
            }

            // 지훈이 이동
            int jihoonSize = jinhoQueue.size();
            for (int k = 0; k < jihoonSize; k++) {
                Position jihoonPos = jinhoQueue.poll();
                int row = jihoonPos.row;
                int col = jihoonPos.col;
                int time = jihoonPos.time;

                if (row == 0 || row == R - 1 || col == 0 || col == C - 1) {
                    // 지훈이가 미로 가장자리에 도달하면 시간 출력하고 종료
                    escapeTime = time + 1;
                    break;
                }

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < R && newCol >= 0 && newCol < C
                            && map[newRow][newCol] == '.' && !visited[newRow][newCol]) {
                        jinhoQueue.add(new Position(newRow, newCol, time + 1));
                        visited[newRow][newCol] = true;
                    }
                }
            }

            if (escapeTime != -1) {
                break;
            }
        }

        return escapeTime;
    }
}