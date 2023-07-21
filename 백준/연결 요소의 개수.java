/*
 * ���� 11724��: ���� ����� ����
 * �˰��� �з�: #�׷��� �̷� #�׷��� Ž�� #dfs #bfs
 */

import java.util.*;

public class Main {
	static int[][] graph;
	static int V;
	static int E;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new int[V+1][V+1];
		visited = new boolean[V+1];
		
		for(int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		int cnt = 0 ;
		
		for(int i = 1; i <= V; i++) {
			if(!visited[i]) { // �湮�� �� ���� ����� dfs
				dfs(i);
				cnt++;	// dfs�� ���������� cnt�� ������Ŵ (���� ����� ��)
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int index) {
		visited[index] = true;
		for(int i=1; i<=V; i++) {
			if(graph[index][i]==1 && !visited[i]) {
				dfs(i);
			}
		}
	}
}


