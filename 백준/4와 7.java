/*
    백준 2877번: 4와 7
    알고리즘 분류: #수학 #구현
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int n;

        int k = Integer.parseInt(br.readLine());

        for(int i = 1;; i++) {
            // 2의 거듭제곱 수들을 더해가면서 누적합을 계산 (자릿수가 늘어날 때마다 2의 거듭제곱 만큼 경우의 수가 더해짐)
            sum += (int) Math.pow(2, i);
            // 누적합이 k보다 크거나 같아지는 순간 출력값(결과)의 자릿수(n)와 해당 자릿수의 시작지점(sum)을 알 수 있음
            if (sum >= k) {
                n = i;
                sum -= (int) Math.pow(2, i);
                break;
            }
        }

        // n자릿수 중 몇 번째로 큰 수인지 계산
        int cnt = k - sum - 1;
        // 해당 수를 2진수로 표현
        String binary = Integer.toBinaryString(cnt);

        // 2진수를 0 -> 4, 1 -> 7로 치환해서 저장
        for(int i = 0; i < binary.length(); i++){
            if((binary.charAt(i)-'0') == 0){
                sb.append(4);
            }
            else{
                sb.append(7);
            }
        }
        // 출력값의 자릿수에서 모자란 만큼 앞에서 부터 4로 채움
        for(int i = 0; i < n - binary.length(); i++){
            sb.insert(0, 4);
        }

        System.out.println(sb.toString());
    }
}