/**
 *  백준 14225번 - 부분수열의 합
 *  알고리즘 분류 - 완전 탐색
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] answerVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        answerVisited = new boolean[100000 * 20 + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            saebyeok(0, i, 0);
        }

        // 가장 작은 수 찾기
        for (int i = 1; i < answerVisited.length; i++) {
            if (!answerVisited[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void saebyeok(int start, int r, int sum) {
        if (r == 0) {
            answerVisited[sum] = true;
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            sum += arr[i];
            saebyeok(i + 1, r - 1, sum);
            visited[i] = false;
            sum -= arr[i];
        }
    }
}