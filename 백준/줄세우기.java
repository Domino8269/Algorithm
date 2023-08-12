/*
    백준 2631번: 줄세우기
    알고리즘 분류: #dp
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // LIS(최장 증가 부분 수열)의 길이를 구함
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Arrays.sort(dp);
        // 아이들의 수(N) - LIS의 길이 = 옮겨야 하는 아이들의 수
        System.out.println(n - dp[n - 1]);
    }
}