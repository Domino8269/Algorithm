/*
 * 백준 2493번: 탑
 * 알고리즘 분류: #자료구조 #스택
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[N];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			// 스택이 비었으면 0을 출력하고 현재 값을 스택에 push
			if (stack.isEmpty()) {
				System.out.print(0+" ");
				stack.push(i);
				continue;
			}
			// 스택을 비우면서 현재 탑의 신호를 수신할 수 있는 탑을 탐색
			while(true) {
				if(stack.isEmpty()) {
					System.out.print(0+" ");
					stack.push(i);
					break;
				}
				if(arr[stack.peek()]>=arr[i]) {
					System.out.print(stack.peek()+1+" ");
					stack.push(i);
					break;
				}
				else {
					stack.pop();
				}
			}
		}
	}
}