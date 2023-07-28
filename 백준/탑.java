/*
 * ���� 2493��: ž
 * �˰��� �з�: #�ڷᱸ�� #����
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
			// ������ ������� 0�� ����ϰ� ���� ���� ���ÿ� push
			if (stack.isEmpty()) {
				System.out.print(0+" ");
				stack.push(i);
				continue;
			}
			// ������ ���鼭 ���� ž�� ��ȣ�� ������ �� �ִ� ž�� Ž��
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