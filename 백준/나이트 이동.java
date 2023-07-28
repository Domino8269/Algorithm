/*
 * ���� 7562��: ����Ʈ �̵�
 * �˰��� �з�: #�׷��� Ž�� #bfs
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// ��ǥ�� �̵�Ƚ��(cnt)�� ������ Point Ŭ����
class Point {
    int x;
    int y;
    int cnt;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.cnt = 0;
    }
    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {
    // ����Ʈ�� 8���� �̵����⿡ ���� x, y ��ǥ �̵����� �迭�� ����
    static int[][] moveXY = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    static int l;
    static boolean[][] visited;
    static Point start;
    static Point end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs(start);
        }
    }

    public static void bfs (Point p){
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited[p.x][p.y] = true;

        while(!q.isEmpty()){
            Point temp = q.poll();
            // ���� temp�� ��ǥ���� ��������(end)�� ��ǥ���� ��ġ�ϸ� ���� temp�� �̵�Ƚ��(cnt)�� ��� �� ����
            if(temp.x == end.x && temp.y == end.y){
                System.out.println(temp.cnt);
                return;
            }
            // ����Ʈ�� �̵������ 8�����̹Ƿ� 8�� ����
            for(int i=0; i<8; i++){
                int x = temp.x + moveXY[i][0];
                int y = temp.y + moveXY[i][1];
                // ����Ʈ�� �̵��ϴ� ���� x, y ��ǥ�� ���� ũ�⸦ ����� �����鼭 �湮���� ���� ���̸� ť�� �߰� �� �湮üũ
                if(x>=0 && x < l && y>=0 && y < l && !visited[x][y]) {
                    q.offer(new Point(x, y, temp.cnt + 1));
                    visited[x][y] = true;
                }
            }

        }
    }
}