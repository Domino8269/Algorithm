/*
    백준 11497번: 통나무 건너뛰기
    알고리즘 분류: #그리디 #정렬
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int[] resultArr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int k = 0; k < n; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }
            // 배열 오름차순 정렬
            Arrays.sort(arr);
            // 배열의 최대값을 resultArr의 중앙에 배치
            resultArr[n/2] = arr[n-1];

            // 배열 왼쪽 채우기
            int p = n/2 - 1;
            for(int k = n-2; k >= 0; k = k - 2) {
                resultArr[p--] = arr[k];
            }

            // 배열 오른쪽 채우기
            p = n/2 + 1;
            for(int k = n-3; k >= 0; k-=2) {
                resultArr[p++] = arr[k];
            }

            // 난이도 찾기
            int lv = 0;
            for(int k = 1; k < n; k++) {
                int temp = Math.abs(resultArr[k] - resultArr[k-1]);
                if(temp > lv) {
                    lv = temp;
                }
            }

            System.out.println(lv);
        }
    }
}