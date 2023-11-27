/**
 *  백준 2470번 - 두 용액
 *  알고리즘 분류 - #정렬 #이분 탐색 #투 포인터
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int result = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int gap = Math.abs(sum);

            if (gap < result) {
                result = gap;
                num1 = arr[left];
                num2 = arr[right];
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(num1 + " " + num2);
    }
}