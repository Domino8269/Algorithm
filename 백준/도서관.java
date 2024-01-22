/**
 *  백준 1461번 - 도서관
 *  알고리즘 분류 - 그리디, 정렬
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < 0) {
                minusQ.offer(Math.abs(num));
            } else {
                plusQ.offer(num);
            }
        }

        int max = 0;
        if (plusQ.isEmpty()) {
            max = minusQ.peek();
        } else if (minusQ.isEmpty()) {
            max = plusQ.peek();
        } else {
            max = Math.max(plusQ.peek(), minusQ.peek());
        }

        int answer = 0;
        while (!plusQ.isEmpty()) {
            int temp = plusQ.poll();
            for (int i = 0; i < M - 1; i++) {
                plusQ.poll();
                if (plusQ.isEmpty()) {
                    break;
                }
            }
            answer += temp * 2;
        }

        while (!minusQ.isEmpty()) {
            int temp = minusQ.poll();
            for (int i = 0; i < M - 1; i++) {
                minusQ.poll();

                if (minusQ.isEmpty()) {
                    break;
                }
            }
            answer += temp * 2;
        }

        answer -= max;
        System.out.println(answer);
    }
}