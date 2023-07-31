/*
    백준 16953번: A -> B
    알고리즘 분류: #그리디 알고리즘 #그래프 탐색 #bfs
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 0;
        // A가 B보다 크거나 같다면 루프 종료
        while(A < B){
            // 2로 나누어 떨어지는 경우
            if(B % 2 == 0){
                B /= 2;
            }
            // 끝자리가 1인 경우
            else if(B % 10 == 1){
                B /= 10;
            }
            // 어느것도 해당되지 않는다면 A를 B로 만들 수 없으므로 -1 출력
            else{
                System.out.println(-1);
                return;
            }
            cnt++;
        }
        // A가 B보다 큰 경우 -1, 그렇지 않다면 연산횟수를 출력
        System.out.println(A > B ? -1 : cnt+1);
    }
}