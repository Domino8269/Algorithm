/*
    백준 12789번: 도키도키 간식드리미
    알고리즘 분류: #자료구조 #스택
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();   // 아래쪽 대기열을 스택으로 활용

        int lineNum = 1;    // 번호표는 1번부터 시작
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            // 학생들의 번호표(input)를 큐에 삽입
            queue.add(Integer.parseInt(st.nextToken()));
        }
        // 큐에 들어었는 번호표를 꺼내서 왼쪽 라인과 아래쪽 라인(스택)으로 분류
        while(!queue.isEmpty()) {
            if(queue.peek() == lineNum) {
                queue.poll();
                lineNum++;
            } else if(!stack.isEmpty() && stack.peek() == lineNum) {
                // 스택
                stack.pop();
                lineNum++;
            } else {
                stack.add(queue.poll());
            }
        }
        // 스택에 들어있는 번호표를 꺼내서 분류
        while(!stack.isEmpty()) {
            if(stack.peek() == lineNum) {
                lineNum++;
            }
            stack.pop();
        }
        // 위의 과정을 거친 후, lineNum이 n + 1과 같다면 마지막
        // 번호표를 가진 사람까지 간식을 받은 것이므로 "Nice" 를 출력
        if(lineNum == n + 1) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}