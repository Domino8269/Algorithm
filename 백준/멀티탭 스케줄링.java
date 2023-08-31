/*
    백준 1700번: 멀티탭 스케줄링
    알고리즘 분류: #그리디
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 전기용품의 번호와 남은 사용 횟수를 저장할 해시맵
        HashMap<Integer, Integer> hm = new HashMap<>(100);
        // 현재 꽂혀있는 플러그의 번호를 저장할 배열
        ArrayList<Integer> arrList = new ArrayList<>();

        int resultCnt = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(hm.containsKey(arr[i])) {    // 해시맵에 이미 존재하는 키값이면, 사용 횟수를 1회 증가
                hm.replace(arr[i], hm.get(arr[i]) + 1);
            } else {    // 아니라면, 해당 전기용품 번호를 해시맵에 저장 (처음 저장 시 사용 횟수는 1)
                hm.put(arr[i], 1);
            }
        }

        for(int i = 0; i < k; i++) {
            int temp = -1;

            // 꽂을 플러그의 사용 횟수를 1회 감소
            hm.replace(arr[i], hm.get(arr[i]) - 1);
            // 사용 횟수가 0이 되면 해시맵에서 제거
            if(hm.get(arr[i]) == 0) {
                hm.remove(arr[i]);
            }
            // 플러그가 꽂혀있지 않은 경우
            if (!arrList.contains(arr[i])) {
                // 플러그를 꽂을 공간이 없는 경우
                if (arrList.size() >= n) {
                    // 현재 꽂혀있는 플러그가 나중에 사용되는지 확인
                    for(int j = 0; j < arrList.size(); j++) {
                        // 나중에 사용되지 않는 플러그가 있다면 해당 플러그를 제거
                        if(!hm.containsKey(arrList.get(j))) {
                            temp = j;
                        }
                    }
                    // 현재 꽂혀 있는 모든 플러그가 나중에도 사용될 경우 가장 마지막에 사용되는 플러그를 제거
                    if(temp == -1) {
                        int cnt = 0;
                        boolean[] check = new boolean[n];
                        // 마지막에 사용되는 플러그를 찾음
                        for(int j = i + 1; j < k; j++) {
                            for(int l = 0; l < arrList.size(); l++) {
                                // 다음에 사용될 플러그를 n-1개까지 찾으면 남은 1개의 플러그가 마지막 플러그가 됨
                                if(cnt == n - 1) {
                                    for(int h = 0; h < n; h++) {
                                        if(!check[h]) {
                                            temp = h;
                                        }
                                    }
                                }
                                // 꽂혀있는 플러그 목록과 다음에 꽂을 플러그를 비교하여 일치하면 count 증가
                                if(arrList.get(l) == arr[j]) {
                                    check[l] = true;
                                    cnt++;
                                }
                            }
                        }
                    }
                    // 위의 알고리즘에 의해 선정된 플러그를 제거
                    arrList.remove(temp);
                    // 플러그를 빼는 경우, resultCnt의 값을 1만큼 증가
                    resultCnt++;
                }
                // 플러그를 꽂음
                arrList.add(arr[i]);
            }
        }
        // 플러그를 뺀 횟수를 출력
        System.out.println(resultCnt);
    }
}