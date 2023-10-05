/*
    백준 1874번: 스택 수열
    알고리즘 분류: #자료구조 #스택
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();


        int n = Integer.parseInt(br.readLine());

        // 수열을 큐에 입력받음
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        // 1 ~ n까지의 수를 스택에 추가
        for (int i = 1; i <= n; i++) {
            // 큐의 맨 앞의 값과 스택의 맨 위 값이 같다면 두 수를 큐와 스택에서 제거
            while (!stack.isEmpty() && Objects.equals(queue.peek(), stack.peek())) {
                queue.poll();
                stack.pop();
                sb.append("-\n");
            }

            stack.push(i);
            sb.append("+\n");
        }

        // 스택이 빌 때까지, 큐와 스택의 다음 요소들을 비교해서 수열이 완성되는지 판단
        while(!stack.isEmpty()) {
            if (Objects.equals(queue.peek(), stack.peek())) {
                queue.poll();
                stack.pop();
                sb.append("-\n");
            } else {
                break;
            }
        }

        // 큐가 비었다면 수열이 완성된 것이므로, 연산 기호를 출력.
        if (queue.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}