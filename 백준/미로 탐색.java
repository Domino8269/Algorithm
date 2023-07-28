/*
 * ���� 2178��: �̷� Ž��
 * �˰��� �з�: #�׷��� Ž�� #bfs
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// �迭�� ��ġ�� ������ Point Ŭ����
class Point {
    int r;
    int c;
    int cnt;
    Point(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

public class Main {
    // �����¿� �̵� �� ��� ���� �̵� ������ ����
    static int[][] movePoint = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] map;
    static boolean[][] visited;
    static Point start;
    static Point end;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        start = new Point(1, 1, 1);
        end = new Point(N, M, 1);

        for(int i=1; i<=N; i++){
            String s = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = s.charAt(j-1) - '0';
            }
        }

        bfs();
    }

    public static void bfs (){
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.r][start.c] = true;

        while(!q.isEmpty()){
            Point temp = q.poll();
            // ���� temp�� row, column�� ��������(end)�� row, column�� ��ġ�ϸ� temp�� �̵�Ƚ��(cnt)�� ��� �� ����
            if(temp.r == end.r && temp.c == end.c){
                System.out.println(temp.cnt);
                return;
            }
            // �����¿� 4�� ����
            for(int i=0; i<4; i++){
                int r = temp.r + movePoint[i][0];
                int c = temp.c + movePoint[i][1];
                // ����Ʈ�� �̵��ϴ� ���� row, column ���� ���� ũ�⸦ ������� Ȯ��
                if(r >= 1 && r <= N && c >= 1 && c <= M) {
                    // �̵��� �� �ִ� ĭ(1)�̸鼭 �湮���� ���� ���̸� �湮
                    if (map[r][c] == 1 && !visited[r][c]) {
                        q.offer(new Point(r, c, temp.cnt + 1));
                        visited[r][c] = true;
                    }
                }
            }

        }
    }
}