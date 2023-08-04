/*
    백준 9465번: 스티커
    알고리즘 분류: #dp
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[2][n];
            dp = new int[2][n];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    // 0인 점수가 존재할 경우 불필요한 재귀 호출이 일어나므로 dp 배열을 -1로 초기화
                    dp[j][k] = -1;
                }
            }
            // 각 행의 마지막 칸([0][n-1], [1][n-1])이 가질 수 있는 최대 점수 중 더 큰 값을 출력
            int zero = findMax(0, n-1);
            int one = findMax(1, n-1);
            System.out.println(Math.max(zero, one));
        }
    }
    // 해당 칸에 올 수 있는 최대 점수를 구해서 리턴하는 함수
    public static int findMax(int row, int col){
        // 열 번호가 0보다 작을 경우(배열 범위를 벗어남) 0 리턴
        if(col < 0){
            return 0;
        }
        // 해당 칸의 최대 점수가 아직 계산되지 않았다면 행 번호가 0일때와 1일때를 구분해서 계산
        else if(dp[row][col] == -1){
            if(row == 0){
                dp[row][col] = Math.max(findMax(row+1, col-1), findMax(row+1, col-2)) + arr[row][col];
            }
            else{
                dp[row][col] = Math.max(findMax(row-1, col-1), findMax(row-1, col-2)) + arr[row][col];
            }
        }

        return dp[row][col];
    }
}