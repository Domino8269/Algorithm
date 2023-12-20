/**
 *  백준 2512번 - 예산
 *  알고리즘 분류 - 이분 탐색, 매개 변수 탐색
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int budget = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int start = 0;
        int end = arr[N - 1];

        while(start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                sum += Math.min(arr[i], mid);
            }

            if (sum > budget) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}