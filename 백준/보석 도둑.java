/*
    백준 1202번: 보석 도둑
    알고리즘 분류: #자료구조 #그리디 알고리즘 #정렬 #우선순위 큐
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 보석을 가격에 따라 내림차순으로 정렬할 우선순위 큐
        PriorityQueue<int[]> pricePQ = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        // 보석을 무게에 따라 오름차순으로 정렬할 우선순위 큐
        PriorityQueue<int[]> weightPQ = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int N = Integer.parseInt(st.nextToken()); // 보석의 개수
        int K = Integer.parseInt(st.nextToken()); // 가방의 개수
        long maxPrice = 0; // 최대 가격을 저장할 변수
        int[] bag = new int[K]; // 가방의 무게를 저장할 배열

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 보석 정보를 무게와 가치로 분리하여 우선순위 큐에 저장
            weightPQ.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine()); // 가방의 무게를 배열에 저장
        }
        Arrays.sort(bag); // 가방의 무게를 오름차순으로 정렬

        // 각 가방에 대해 가장 가치가 높은 보석을 선택하고 가격을 누적
        for (int bagSize : bag) {
            // 현재 가방 무게보다 작거나 같은 모든 보석을 우선순위 큐에 넣음
            while (!weightPQ.isEmpty() && weightPQ.peek()[0] <= bagSize) {
                pricePQ.offer(weightPQ.poll());
            }

            // 우선순위 큐에서 최대 가치의 보석을 선택하여 가방에 넣음
            if (!pricePQ.isEmpty()) {
                maxPrice += pricePQ.poll()[1];
            }
        }

        System.out.println(maxPrice); // 최대 가격 출력
    }
}
