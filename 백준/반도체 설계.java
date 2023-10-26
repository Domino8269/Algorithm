/*
    백준 2352번: 반도체 설계
    알고리즘 분류: #이분 탐색 #LIS
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 입력된 숫자들을 저장하기 위한 ArrayList
        List<Integer> arr = new ArrayList<>();
        // 길이가 i+1인 가장 긴 증가하는 부분 수열(LIS)의 마지막 원소 중 가장 작은 값을 저장
        List<Integer> lis = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        // 첫 번째 숫자를 lis 배열에 추가 (길이 1의 LIS)
        lis.add(arr.get(0));
        for (int i = 1; i < n; i++) {
            if (arr.get(i) > lis.get(lis.size() - 1)) {
                // 현재 숫자가 lis의 마지막 숫자보다 큰 경우, lis의 마지막 위치 해당 숫자를 추가
                lis.add(arr.get(i));
            } else {
                // 현재 숫자가 LIS의 마지막 숫자보다 작은 경우, 이진 탐색을 통해 위치를 찾아서 교체
                binarySearch(lis, arr.get(i));
            }
        }

        // 가장 긴 LIS의 길이 출력
        System.out.println(lis.size());
    }

    public static void binarySearch(List<Integer> lis, int target) {
        int start = 0;
        int end = lis.size();

        while (start <= end) {
            int mid = (start + end) / 2;

            if (lis.get(mid) == target) {
                return;
            }

            if (lis.get(mid) > target) {
                end = mid - 1;
            }

            if (lis.get(mid) < target) {
                start = mid + 1;
            }
        }
        // start에 target 값을 삽입하여 LIS를 업데이트
        lis.set(start, target);
    }
}
