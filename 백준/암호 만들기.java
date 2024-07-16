/**
 * 백준 1759번 - 암호 만들기
 * 알고리즘 분류 - 수학, 브루트포스, 조합, 백트래킹
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int C;
    static char[] arr;
    static char[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        temp = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        dfs(0, 0);
    }

    public static void dfs(int depth, int p) {
        if (depth == L) {
            if (isValid()) {
                for (int i = 0; i < L; i++) {
                    System.out.print(temp[i]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = p; i < C; i++) {
            temp[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }

    public static boolean isValid() {
        int vowel = 0;
        int consonant = 0;
        for (char c : temp) {
            if (c == 'a' || c == 'o' || c == 'i' || c == 'e' || c == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }

        if (1 <= vowel && 2 <= consonant) {
            return true;
        }

        return false;
    }

}