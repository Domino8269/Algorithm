/*
 * ���� 18870��: ��ǥ ����
 * �˰��� �з�: #���� #��/��ǥ ����
 */

import java.util.*;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int cnt = 0;
	
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			
		}
		// temp�� �迭 ����
		int[] temp = arr.clone();
		// �Է¹��� �迭 ����
		Arrays.sort(arr);
		// �迭�� ��� ��� ��ȸ
		for(int i=0;i<n;i++) {
			// �ؽøʿ� �迭���� �ش��ϴ� Ű�� �������� ������
			if(!hm.containsKey(arr[i])) {
				// ���� count�� ������ �߰��ϰ� count�� ������Ŵ(�ؽø��� Ư������ �ߺ��� Ű ���� �߰����� ����)
				hm.put(arr[i], cnt++);
			}
		}
		for(int i=0;i<n;i++) {
			// ó�� �Է¹��� ������� ����ؾ� �ϹǷ� temp �迭�� ����� �� ������� StringBuilder�� �߰�
			sb.append(hm.get(temp[i])).append(" ");
		}
		System.out.println(sb);	
	}
}


