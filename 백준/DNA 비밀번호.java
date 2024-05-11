/**
 * 백준 12891번 - DNA 비밀번호
 * 알고리즘 분류 - 문자열, 슬라이딩 윈도우
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ACGT;
    static int[] tempACGT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        char[] arr = new char[str.length()];

        for (int i = 0; i < S; i++) {
            arr[i] = str.charAt(i);
        }

        st = new StringTokenizer(br.readLine());
        ACGT = new int[4];
        for (int i = 0; i < 4; i++) {
            ACGT[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = P - 1;
        tempACGT = new int[26];
        int answer = 0;

        for (int i = 0; i < P; i++) {
            tempACGT[arr[i] - 65]++;
        }
        if (checkACGT()) {
            answer++;
        }

        while (end < S - 1) {
            tempACGT[arr[start++] - 65]--;
            tempACGT[arr[++end] - 65]++;
            if (checkACGT()) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean checkACGT() {
        if (tempACGT['A' - 65] >= ACGT[0] && tempACGT['C' - 65] >= ACGT[1] && tempACGT['G' - 65] >= ACGT[2] && tempACGT['T' - 65] >= ACGT[3]) {
            return true;
        }
        return false;
    }
}