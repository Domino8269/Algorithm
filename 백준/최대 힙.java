/*
    백준 11279번: 최대 힙
    알고리즘 분류: #자료구조 #우선순위 큐
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // heap 객체를 생성
        maxHeap heap = new maxHeap();
        // n개의 명령을 수행
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            // 0이 입력되면 heap에서 가장 큰 값을 출력하고 해당 숫자를 제거
            if(num == 0){
                System.out.println(heap.delete());
            }
            // 그 외의 다른 숫자가 입력되면 해당 숫자를 heap에 추가
            else{
                heap.insert(num);
            }
        }
    }
}

class maxHeap{
    private ArrayList<Integer> heap;
    // 초기 heap의 상태를 설정 (ArrayList로 구현. 첫번째 요소(index->0)는 사용하지 않음)
    public maxHeap() {
        heap = new ArrayList<>();
        heap.add(Integer.MAX_VALUE);
    }
    // heap에 값을 추가할 경우 마지막 노드에 해당 값을 추가하고 부모 노드의 값과 비교하며 힙 조건에 맞게 스왑함
    public void insert(int val) {
        heap.add(val);
        // 현재 노드의 인덱스 값(마지막 노드의 인덱스로 초기화)
        int p = heap.size() - 1;
        // 부모 노드가 존재하고(p > 1), 부모 노드보다 현재 노드의 값이 크다면 부모 노드와 스왑
        while(p > 1 && heap.get(p / 2) < heap.get(p)) {
            int temp = heap.get(p / 2);
            heap.set(p / 2, heap.get(p));
            heap.set(p, temp);

            p = p / 2;
        }
    }
    // heap에서 값을 삭제하는 경우 첫 번째 노드를 삭제하고, 마지막 노드를 첫 번째 노드의 자리로 가져온 뒤
    // 자식 노드와 값을 비교하며 힙 조건에 맞게 스왑함
    public int delete() {
        if(heap.size() - 1 < 1){
            return 0;
        }

        int deleteVal = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        // 현재 노드의 인덱스 값(첫 번째 노드의 인덱스로 초기화)
        int pos = 1;
        // 자식 노드가 존재하면 반복문을 수행
        while((pos * 2) < heap.size()) {
            int max = heap.get(pos * 2);
            int maxPos = pos * 2;
            // 자식 노드 중 오른쪽 노드의 값이 더 크면 오른쪽 노드와 스왑
            if((pos * 2 + 1) < heap.size() && max < heap.get(pos * 2 + 1)) {
                max = heap.get(pos * 2 + 1);
                maxPos = pos * 2 + 1;
            }
            // 현재 노드가 자식 노드보다 큰 값이라면 스왑종료
            if(heap.get(pos) > max){
                break;
            }
            // 현재 노드와 자식 노드를 스왑
            int temp = heap.get(pos);
            heap.set(pos, heap.get(maxPos));
            heap.set(maxPos, temp);
            pos = maxPos;
        }
        return deleteVal;
    }
}