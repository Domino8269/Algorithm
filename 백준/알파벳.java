/*
    백준 1987번: 알파벳
    알고리즘 분류: #그래프 탐색 #dfs #백트래킹
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int maxCnt = 0;
    static int arrRow;
    static int arrCol;
    // 상하좌우 이동 시 행과 열의 이동 범위를 저장
    static int[][] movePoint = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] arr;
    static boolean[][] visited;
    // 지나간 알파벳을 저장하기 위한 ArrayList
    static ArrayList<Character> ch = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arrRow = Integer.parseInt(st.nextToken());
        arrCol = Integer.parseInt(st.nextToken());
        arr = new char[arrRow][arrCol];
        visited = new boolean[arrRow][arrCol];
        // 알파벳을 char형 2차원 배열에 입력받음
        for(int i = 0; i < arrRow; i++) {
            String s = br.readLine();
            for(int j = 0; j < arrCol; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        // (0, 0)에서 시작해서 최대 이동횟수를 구함
        dfs(0, 0, 1);
        System.out.println(maxCnt);
    }

    public static void dfs(int r, int c, int cnt) {
        // 현재 알파벳을 ArrayList에 추가
        ch.add(arr[r][c]);
        // 방문체크
        visited[r][c] = true;
        // 인접한 네 칸으로 이동 가능하므로 4번 수행
        for(int i = 0; i < 4; i++) {
            int row = r + movePoint[i][0];
            int col = c + movePoint[i][1];
            // 이동할 곳이 배열의 범위를 벗어나지 않으면서
            if(0 <= row && row < arrRow && 0 <= col && col < arrCol) {
                // 방문하지 않은 노드이고, 지나간 알파벳 중에 속하지 않는 값이라면
                if(!ch.contains(arr[row][col]) && !visited[row][col]) {
                    // 해당 위치로 이동 후 count를 증가
                    dfs(row, col, cnt + 1);
                }
            }
        }
        // 현재 노드를 방문하지 않은 곳으로 만들고, 지나간 알파벳 리스트에서 삭제
        visited[r][c] = false;
        ch.remove(ch.size()-1);
        // 현재 깊이(cnt)가 maxCnt보다 크다면 maxCnt를 cnt로 변경
        if(cnt > maxCnt) {
            maxCnt = cnt;
        }
    }
}