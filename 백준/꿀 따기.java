/**
 * 백준 21758번 - 꿀 따기
 * 알고리즘 분류 - 그리디, 누적합
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        prefixSum = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = i == 0 ? arr[0] : prefixSum[i - 1] + arr[i];
        }

        int left = leftHoney();
        int mid = midHoney();
        int right = rightHoney();

        System.out.println(Math.max(left, Math.max(mid, right)));
    }

    public static int leftHoney() {
        int max = -1;
        for (int i = 1; i < N - 1; i++) {
            int tmp = (prefixSum[i] - arr[i]) + (prefixSum[N - 2] - arr[i]);
            if (max < tmp) {
                max = tmp;
            }
        }

        return max;
    }

    public static int midHoney() {
        int max = -1;
        for (int i = 1; i < N - 1; i++) {
            int tmp = (prefixSum[i] - arr[0]) + (prefixSum[N - 1] - prefixSum[i - 1] - arr[N - 1]);
            if (max < tmp) {
                max = tmp;
            }
        }

        return max;
    }

    public static int rightHoney() {
        int max = -1;
        for (int i = 1; i < N - 1; i++) {
            int tmp = (prefixSum[N - 1] - prefixSum[i]) + (prefixSum[N - 1] - arr[0] - arr[i]);
            if (max < tmp) {
                max = tmp;
            }
        }

        return max;
    }
}