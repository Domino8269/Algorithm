/*
    백준 12865번: 평범한 배낭
    알고리즘 분류: #dp #냅색
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] W;
    static int[] V;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        W = new int[n + 1];
        V = new int[n + 1];
        dp = new Integer[n + 1][k + 1];
        // 물건의 무게(W)와 가치(V)를 각각의 배열에 저장함
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        // 냅색 알고리즘 호출 후 반환값 출력. (n은 물건의 개수, k는 최대 무게를 의미함)
        System.out.println(knapsack(n, k));
    }

    public static int knapsack(int n, int k){
        // 물건의 개수가 0이 될 경우 담을 수 있는 물건이 없으므로 0을 리턴
        if(n == 0){
            return 0;
        }
        // 아직 탐색하지 않은 경우
        else if(dp[n][k] == null){
            // 현재 물건의 무게(W[n])가 남은 무게(k)보다 클 경우 물건을 담을 수 없으므로
            // 다음 물건을 탐색 (n - 1)
            if(W[n] > k){
                dp[n][k] = knapsack(n - 1, k);
            }
            // 현재 물건을 담을 수 있는 경우
            else{
                // 현재 물건을 담지 않았을 때와 담았을 때의 가치를 비교해 더 큰 값을 저장
                // 물건을 담았을 경우는 물건의 개수(n)를 하나 줄이고, 남은 무게에서 현재 물건의 무게만큼 빼고(k - W[n]) 현재 가치(V[n])를 더함
                dp[n][k] = Math.max(knapsack(n - 1, k), knapsack(n - 1, k - W[n]) + V[n]);
            }
        }
        return dp[n][k];
    }
}