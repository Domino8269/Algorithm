/**
 *  백준 3020번 - 개똥벌레
 *  알고리즘 분류 - 이분 탐색, 누적합
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int[] stalagmites = new int[N / 2 + N % 2]; // 석순
        int[] stalactite = new int[N / 2];  // 종유석

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                stalagmites[i / 2] = Integer.parseInt(br.readLine());
            } else {
                stalactite[i / 2] = Integer.parseInt(br.readLine());
            }
        }

        Arrays.sort(stalagmites);
        Arrays.sort(stalactite);

        int min = Integer.MAX_VALUE;
        int count = 1;
        for (int i = 1; i <= H; i++) {
            int temp = binarySearch(stalagmites, i, true) + binarySearch(stalactite, i,false);
            if (temp < min) {
                min = temp;
                count = 1;
            } else if (temp == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }

    public static int binarySearch(int[] arr, int high, boolean isDown) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isDown) {
                if (arr[mid] >= high) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] >= H - high + 1) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return arr.length - start;
    }
}