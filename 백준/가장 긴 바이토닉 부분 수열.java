/*
    백준 11054번: 가장 긴 바이토닉 부분 수열
    알고리즘 분류: #DP
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] LIS = new int[n]; // LIS
        int[] rLIS = new int[n]; // reverse LIS

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 정방향 LIS (왼쪽 -> 오른쪽)
        for(int i = 0; i < n; i++){
            LIS[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }
        // 역방향 LIS (오른쪽 -> 왼쪽)
        for(int i = n - 1; i >= 0; i--){
            rLIS[i] = 1;
            for(int j = n - 1; j > i; j--){
                if(arr[i] > arr[j]){
                    rLIS[i] = Math.max(rLIS[i], rLIS[j] + 1);
                }
            }
        }
        // 두 배열의 값을 더해 최댓값 찾기
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(LIS[i] + rLIS[i] > max) {
                max = LIS[i] + rLIS[i];
            }
        }
        // 중복 원소 제거 (max - 1)
        System.out.println(max - 1);
    }
}