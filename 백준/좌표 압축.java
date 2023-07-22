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
		int[] temp = arr.clone();	// temp�� �迭 ����
		Arrays.sort(arr);	// �Է¹��� �迭 ����
		
		for(int i=0;i<n;i++) {	// �迭�� ��� ��� ��ȸ
			if(!hm.containsKey(arr[i])) {	// �ؽøʿ� �迭���� �ش��ϴ� Ű�� �������� ������
				hm.put(arr[i], cnt++);	// ���� count�� ������ �߰��ϰ� count�� ������Ŵ
			}							// �ؽø��� Ư������ �ߺ��� Ű ���� �߰����� ����
		}
		for(int i=0;i<n;i++) {
			sb.append(hm.get(temp[i])).append(" ");	// ó�� �Է¹��� ������� ����ؾ� �ϹǷ�
		}											// temp �迭�� ����� �� ������� StringBuilder�� �߰�
		System.out.println(sb);	
	}
}


