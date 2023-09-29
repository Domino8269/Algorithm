/*
    백준 17298번: 오큰수
    알고리즘 분류: #자료구조 #스택
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            /*
                스택의 가장 위 원소보다 큰 수가 나왔을 경우 해당 수가 오큰수인 모든 원소들을
                찾고(해당 수보다 작은 수들을 모두 찾음) 오큰수가 정해진 원소들을 pop해서 제거함
             */
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            // 스택에 값을 추가
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            // 오큰수를 찾지 못한 원소의 경우 값이 0이므로, 이때는 -1을 출력함
            sb.append(result[i] == 0 ? -1 : result[i]).append(' ');
        }

        System.out.println(sb);
    }
}