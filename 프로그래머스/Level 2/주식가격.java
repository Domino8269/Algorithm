/*
    프로그래머스 Lv2
    Title: 주식가격
 */

import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < prices.length; i++) {
            // 주식가격이 떨어지는 시점이 생기면 그 시점의 가격보다 높은 가격들의 시간을 구함
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            // 다음 주식가격의 index를 스택에 push
            stack.push(i);
        }

        // 스택에 남아있는 주식가격들의 시간을 구함
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
}

