/*
    백준 10986번: 나머지 합
    알고리즘 분류: #수학 #누적합
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 입력 배열의 길이
        int M = Integer.parseInt(st.nextToken()); // 나눌 값

        int[] numCnt = new int[M]; // 각 나머지값의 빈도를 저장하는 배열
        int sum = 0; // 현재까지의 누적합을 M으로 나눈 나머지를 저장
        long result = 0L; // 결과 값

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken()); // 현재 숫자

            // 현재 숫자를 누적합에 더함
            sum += num;
            // 누적합을 M으로 나눈 나머지를 저장
            sum %= M;

            // 현재까지의 누적합이 M의 배수인 경우 결과를 증가
            if (sum == 0) {
                result++;
            }

            // sum의 빈도를 결과에 더함
            result += numCnt[sum];
            // sum의 빈도를 증가
            numCnt[sum]++;
        }

        System.out.println(result); // 결과 출력
    }
}