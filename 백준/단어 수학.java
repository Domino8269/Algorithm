/*
    백준 1339번: 단어 수학
    알고리즘 분류: #그리디
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        int[] weight = new int[26];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            // 알파벳들의 자릿수에 따라 가중치를 설정
            for (int j = 0; j < arr[i].length(); j++) {
                weight[arr[i].charAt(j) - 'A'] += (int) Math.pow(10, arr[i].length() - 1 - j);
            }
        }
        // 가중치가 저장된 배열을 정렬
        Arrays.sort(weight);
        // 가중치가 높은 알파벳에 9부터 0까지 순서대로 배정
        int num = 9;

        // 가중치가 큰 순서대로 9 ~ 0 까지 곱해준 뒤 이 값들의 합을 구함
        for (int i = weight.length - 1; num >= 0; i--) {
            sum += weight[i] * num--;
        }

        System.out.println(sum);
    }
}