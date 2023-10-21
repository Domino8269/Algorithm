/*
    백준 1781번: 컵라면
    알고리즘 분류: #자료구조 #우선순위 큐 #그리디 알고리즘
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 데드라인 기준 오름차순 정렬
        PriorityQueue<int[]> inputPQ = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        // 컵라면 수 기준 오름차순 정렬. 최종적으로 시간 내에 풀 수 있는 문제들을 저장
        PriorityQueue<int[]> resultPQ = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        int cupRamenCnt = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] temp = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            // 데드라인과 컵라면 수가 담긴 배열을 우선순위 큐에 저장
            inputPQ.offer(temp);
        }

        while (!inputPQ.isEmpty()) {
            // 데드라인이 작은 순서대로 문제를 꺼냄
            int[] inputArr = inputPQ.poll();

            if (inputArr[0] >= resultPQ.size()) {
                int[] resultArr = resultPQ.peek();

                // resultPQ의 size가 현재 문제의 데드라인보다 작다면, 현재 문제를 resultPQ에 삽입
                if (inputArr[0] > resultPQ.size()) {
                    resultPQ.offer(inputArr);
                } else if (inputArr[1] > resultArr[1]) {
                    // 만약 데드라인과 resultPQ의 size가 같다면, resultPQ에서 꺼낸 컵라면의 수와 비교
                    // 현재 문제의 컵라면 수가 더 크면, poll 연산 후 현재 문제를 resultPQ에 삽입
                    resultPQ.poll();
                    resultPQ.offer(inputArr);
                }
            }
        }

        // resultPQ에 저장된 문제들의 컵라면 수를 모두 더함
        while (!resultPQ.isEmpty()) {
            int[] temp = resultPQ.poll();

            cupRamenCnt += temp[1];
        }

        System.out.println(cupRamenCnt);
    }
}