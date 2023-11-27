/**
 *  백준 4963번 - 섬의 개수
 *  알고리즘 분류 - #그래프 이론 #그래프 탐색 #BFS #DFS
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int w;
    static int h;
    static int[] dirX = {0, 0, -1 ,1, -1, 1, -1, 1};
    static int[] dirY = {-1, 1, 0, 0, 1, 1, -1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island_count = 0;
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {

                    if(!visited[i][j] && map[i][j] == 1) {
                        island_count++;
                        DFS(i, j);
                    }
                }
            }

            System.out.println(island_count);
        }

    }

    public static void DFS(int row, int col) {
        visited[row][col] = true;

        for(int i=0; i<8; i++) {
            int newRow = dirX[i] + row;
            int newCol = dirY[i] + col;

            if(newRow >= 0 && newCol >= 0 && newRow < h && newCol < w &&
                    !visited[newRow][newCol] && map[newRow][newCol] == 1) {
                DFS(newRow, newCol);
            }
        }
    }
}