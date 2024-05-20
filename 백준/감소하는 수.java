/**
 * 백준 1038번 - 감소하는 수
 * 알고리즘 분류 - 브루트포스, 백트래킹
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N < 10) {
            System.out.println(N);
            System.exit(0);
        }
        if (N > 1022) {
            System.out.println(-1);
            System.exit(0);
        }

        for (int i = 0; i < 10; i++) {
            search(i, 1);
        }

        Collections.sort(list);
        System.out.println(list.get(N));
    }

    public static void search(long num, int idx) {
        if (idx > 10) {
            return;
        }

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            search((num * 10) + i, idx + 1);
        }
    }
}