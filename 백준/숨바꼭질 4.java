/*
    백준 13913번: 숨바꼭질 4
    알고리즘 분류: #그래프 탐색 #bfs
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 좌표값(x)과 이동 경로(arr)를 저장할 Point 클래스
class Point {
    int x;
    ArrayList<Integer> arr = new ArrayList<>();
    Point(int x) {
        this.x = x;
        this.arr.add(x);
    }
    Point(int x, ArrayList<Integer> arr) {
        this.x = x;
        this.arr = new ArrayList<>(arr);
        this.arr.add(x);
    }
}

public class Main {
    static int n;
    static int k;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        // n이 k보다 클 경우 n부터 k까지 내림차순으로 출력('+', '*' 연산이 불가능)
        if(n > k) {
            System.out.println(n - k);
            for(int i = n; n >= k; n--){
                System.out.print(n + " ");
            }
            return;
        }
        // bfs 메서드 호출
        bfs(new Point(n));
    }
    // 출발 좌표값(n)을 시작으로 너비 우선 탐색(bfs)을 이용해
    // 도착 좌표값(k)까지의 최단 경로를 찾아 해당 이동 경로를 출력
    public static void bfs (Point p) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited[p.x] = true;

        while (!q.isEmpty()) {
            Point temp = q.poll();
            // 큐에 들어있던 좌표값(temp.x)과 도착 좌표(k)가 일치하면 이동 횟수와 경로를 출력 후 종료
            if (temp.x == k) {
                System.out.println(temp.arr.size() - 1);
                for(int num : temp.arr){
                    System.out.print(num + " ");
                }
                return;
            }
            // 배열 인덱스 범위를 벗어나지 않으면서 방문하지 않은 노드일 경우
            // 3가지 이동 경로(*2, +1, -1)를 큐에 추가 후, 방문 체크
            if(temp.x * 2 <= k + 1 && !visited[temp.x * 2]) {
                q.offer(new Point(temp.x * 2, temp.arr));
                visited[temp.x * 2] = true;
            }
            if(temp.x + 1 <= k && !visited[temp.x + 1]) {
                q.offer(new Point(temp.x + 1, temp.arr));
                visited[temp.x + 1] = true;
            }
            if(temp.x - 1 >= 0 && !visited[temp.x - 1]) {
                q.offer(new Point(temp.x - 1, temp.arr));
                visited[temp.x - 1] = true;
            }
        }
    }
}