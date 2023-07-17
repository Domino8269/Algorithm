/*
 * ���� 2606��: ���̷���
 * �˰��� �з�: #�׷��� Ž�� #DFS #BFS
 */
import java.io.*;
import java.util.*;

public class Main { 
	public static boolean[][] ary;
	public static boolean[] visited;
	public static int N;
	public static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ary = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<M;i++) {	// ��������� �̿��� �׷��� ����
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ary[a][b]=true;
			ary[b][a]=true;
		}
		System.out.println(bfs(1));
		
	}
	public static int bfs(int i) {	// ť�� �̿��� bfs ����
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		visited[i] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int k=1; k<=N; k++) {
				if(ary[temp][k] && visited[k] == false) {
					q.offer(k);
					visited[k] = true;
					count++;
				}
			}
		}
		
		return count;
	}
}





