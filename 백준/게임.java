/**
 *  백준 1072번 - 게임
 *  알고리즘 분류 - #수학 #이분탐색
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long winRate = Y * 100 / X;
        long start = 0;
        long end = X;

        // 승률이 99퍼 이상일 경우 더 이상 승률이 변하지 않으므로 -1 출력
        if (winRate >= 99) {
            System.out.println(-1);
            return;
        }

        // 이분탐색으로 승률이 변하는 시점을 탐색
        while (start <= end) {
            long mid = (start + end) / 2;
            long newWinRate = (Y + mid) * 100 / (X + mid);

            if (newWinRate > winRate) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}