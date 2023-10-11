/*
    프로그래머스 Lv2
    Title: 주차 요금 계산
 */
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<String, String> inCar = new HashMap<>();    // 입차 정보 저장
        Map<String, Integer> outCar = new HashMap<>();  // 출차 정보 저장

        for (String record : records) {
            String[] s = record.split(" ");
            String time = s[0];
            String carNum = s[1];
            String action = s[2];

            // IN 이라면 차량 번호를 키로 시간을 값으로 해시맵에 저장
            if (action.equals("IN")) {
                inCar.put(carNum, time);
            } else if (action.equals("OUT")) {
                // OUT 이라면 해당 차량이 주차장을 이용한 시간을 해시맵에 저장. 이미 해시맵에 값이 존재하면 누적해서 계산
                if (!outCar.containsKey(carNum)) {
                    outCar.put(carNum, calculateTime(inCar.get(carNum), time));
                } else {
                    outCar.put(carNum, outCar.get(carNum) + calculateTime(inCar.get(carNum), time));
                }
                // 출차한 차량은 입차 목록에서 제거
                inCar.remove(carNum);
            }
        }
        // 입차 목록에 남아있는 차량이 있다면 출차 시간을 23:59로 설정하고 주차 시간을 계산
        if(!inCar.isEmpty()) {
            Set<String> keySet = inCar.keySet();

            for (String key : keySet) {
                if (!outCar.containsKey(key)) {
                    outCar.put(key, calculateTime(inCar.get(key), "23:59"));
                } else {
                    outCar.put(key, outCar.get(key) + calculateTime(inCar.get(key), "23:59"));
                }
            }
        }

        List<String> keySet = new ArrayList<>(outCar.keySet());
        // 출차 목록의 keySet(차량 번호)을 오름차순 정렬
        Collections.sort(keySet);

        int[] answer = new int[keySet.size()];
        int idx = 0;

        // 각 차량의 주차 요금을 계산 후 answer 배열에 저장
        for (String key : keySet) {
            if (outCar.get(key) <= baseTime) {
                answer[idx++] = baseFee;
            } else {
                answer[idx++] = baseFee + (int) Math.ceil((outCar.get(key) - baseTime) / (double) unitTime) * unitFee;
            }
        }

        return answer;
    }

    // 차량이 주차된 시간을 계산 (출차 시간 - 입차 시간)
    private int calculateTime(String inTime, String outTime) {
        String[] in = inTime.split(":");
        String[] out = outTime.split(":");
        int inHours = Integer.parseInt(in[0]);
        int outHours = Integer.parseInt(out[0]);
        int inMinutes = Integer.parseInt(in[1]);
        int outMinutes = Integer.parseInt(out[1]);

        return (outHours * 60 + outMinutes) - (inHours * 60 + inMinutes);
    }
}