/*
    백준 2812번: 크게 만들기
    알고리즘 분류: #자료구조 #그리디 #스택
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // N자리 숫자를 문자열 변수에 저장
        String s = br.readLine();

        // 문자열의 각 원소를 순회
        for(int i = 0; i < N; i++){
            // 지울 수 있는 숫자(K)가 더 이상 없으면 남은 숫자를 모두 스택에 push 후 종료
            if(K == 0){
                for(int j = i; j < N; j++){
                    stack.push(s.charAt(j) - '0');
                }
                break;
            }
            // K가 남은 숫자의 길이와 같을 때 (더 이상 스택에 push 불가능)
            if(K == N - i){
                for(int j = i; j < N; j++){
                    // 남은 숫자 중 가장 큰 수를 스택의 가장 위 값과 교체 후 종료
                    if(s.charAt(j) - '0' > stack.peek()){
                        stack.pop();
                        stack.push((s.charAt(j) - '0'));
                    }
                }
                break;
            }
            // 스택이 비거나 K가 0이 될 때까지 반복
            while(!stack.empty() && K != 0){
                // 현재 숫자가 스택의 가장 위 숫자보다 큰 경우 pop 실행 후 K를 1만큼 감소
                if(s.charAt(i) - '0' > stack.peek()){
                    stack.pop();
                    K--;
                }
                // 현재 숫자가 스택의 가장 위 숫자보다 작거나 같은 경우 break
                else{
                    break;
                }
            }
            // 현재 숫자를 stack에 push
            stack.push(s.charAt(i) - '0');
        }
        // 스택에 저장된 값을 출력
        for(int n : stack){
            System.out.print(n);
        }
    }
}