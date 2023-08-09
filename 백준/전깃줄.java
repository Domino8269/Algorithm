/*
    백준 2565번: 전깃줄
    알고리즘 분류: #dp #LIS
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // dp[i] -> i번째 전봇대를 마지막으로 배치했을 때 최대 전봇대의 개수
        int[] dp = new int[n];
        int[][] wire = new int[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        // A 전봇대를 기준으로 오름차순 정렬
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // i번째 전봇대를 기준으로 이전 전봇대들을 탐색
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                // 이전 전봇대들 중 선이 교차하지 않게 배치할 수 있는 전봇대가 있다면
                if(wire[i][1] > wire[j][1]){
                    // i번째 전봇대를 j번째 전봇대 뒤로 배치했을 때(dp[j] + 1)와 배치하지 않았을 때(dp[i])
                    // 둘 중 더 큰 값으로 dp[i]를 업데이트
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // dp 배열을 오름차순 정렬
        Arrays.sort(dp);
        // 전체 전깃줄의 개수(n)에서 최대 전깃줄의 개수(dp 배열의 max값)를 빼서 없어야 하는 전깃줄의 최소 개수를 구함
        System.out.println(n - dp[dp.length - 1]);
    }
}