/**
 *  프로그래머스 Lv2
 *  Title - 택배상자
 */
import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int size = order.length;
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int idx = 0;
        int num = 1;

        while (true) {
            if (idx == size) {
                break;
            }

            if (order[idx] == num) {
                idx++;
                answer++;
                num++;
            } else if (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
            } else if (order[idx] < num) {
                break;
            } else {
                stack.push(num);
                num++;
            }
        }

        return answer;
    }
}