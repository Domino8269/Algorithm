/**
 *  백준 2531번 - 회전 초밥
 *  알고리즘 분류 - 브루트포스, 투포인터, 슬라이딩 윈도우
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];
        int[] visited = new int[d + 1];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int total = 0;
        for (int i = 0; i < k; i++) {
            if (visited[sushi[i]] == 0) {
                total++;
            }
            visited[sushi[i]]++;
        }

        int max = total;
        for (int i = 0; i < n; i++) {
            if (max <= total) {
                if (visited[c] == 0) {
                    max = total + 1;
                } else {
                    max = total;
                }
            }

            visited[sushi[i]]--;
            if (visited[sushi[i]] == 0) {
                total--;
            }
            if (visited[sushi[(i + k) % n]] == 0){
                total++;
            }
            visited[sushi[(i + k) % n]]++;
        }

        System.out.println(max);
    }
}