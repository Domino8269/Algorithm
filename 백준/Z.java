/*
    백준 1074번: Z
    알고리즘 분류: #분할정복 #재귀
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);    // 한 변의 길이를 계산

        findAnswer(size, row, col);
        System.out.println(answer);
    }

    public static void findAnswer(int size, int row, int col) {
        if (size == 1) {
            return;
        }

        int quarterSize = size * size / 4;  // 1/4 크기의 부분 행렬 크기를 계산

        if (row < size / 2 && col < size / 2) {
            // 주어진 좌표가 1사분면에 위치한 경우
            findAnswer(size / 2, row, col);
        } else if (row < size / 2 && col >= size / 2) {
            // 주어진 좌표가 2사분면에 위치한 경우
            answer += quarterSize;
            findAnswer(size / 2, row, col - size / 2);
        } else if (row >= size / 2 && col < size / 2) {
            // 주어진 좌표가 3사분면에 위치한 경우
            answer += quarterSize * 2;
            findAnswer(size / 2, row - size / 2, col);
        } else {
            // 주어진 좌표가 4사분면에 위치한 경우
            answer += quarterSize * 3;
            findAnswer(size / 2, row - size / 2, col - size / 2);
        }
    }
}