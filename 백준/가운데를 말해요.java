/*
    백준 1655번: 가운데를 말해요
    알고리즘 분류: #자료구조 #우선순위 큐
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 최대힙과 최소힙을 선언 (둘을 모래시계처럼 위아래로 배치해서 중간값을 찾음)
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            // 최대힙과 최소힙을 번갈아 가면서 채워줌 (비슷한 크기를 유지)
            if(i % 2 == 0) {
                maxPQ.offer(num);
            } else {
                minPQ.offer(num);
            }
            // 최대힙에서 꺼낸 값이 최소힙에서 꺼낸 값보다 크다면 둘을 교환
            if(!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
                minPQ.add(maxPQ.poll());
                maxPQ.add(minPQ.poll());
            }
            // 중간값은 최대힙에서 우선순위가 가장 높은(가장 큰) 값이 됨
            sb.append(maxPQ.peek() + "\n");
        }

        System.out.println(sb);
    }
}