/*
    백준 12904번: A와 B
    알고리즘 분류: #문자열 #그리디
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();
        StringBuilder sb;
        // T와 S의 길이가 같아질 때까지 반복 (T를 하나씩 줄여가며 S로 만들기)
        for (int i = T.length() - 1; i >= S.length(); i--) {
            // T의 마지막 문자가 'A'라면 해당 문자를 지움
            if(T.charAt(i) == 'A'){
                T = T.substring(0, i );
            }
            // T의 마지막 문자가 'B'라면 해당 문자를 지우고 문자열을 뒤집음
            else {
                T = T.substring(0, i);
                sb = new StringBuilder(T);
                T = sb.reverse().toString();
            }
        }
        // T와 S의 길이가 같아졌을 때, 두 문자열이 같다면 S를 T로 만들 수 있으므로 1을 출력
        if(S.equals(T)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}