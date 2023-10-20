/*
    프로그래머스 Lv 2
    Title: 이모티콘 할인행사
 */
class Solution {
    static int[] emoticonDiscounts;  // 이모티콘의 할인율
    static int totalCost;   // 총 판매액
    static int maxUsers;    // 최대 서비스 가입자 수
    public int[] solution(int[][] users, int[] emoticons) {
        int[] result = new int[2];
        emoticonDiscounts = new int[emoticons.length];

        dfs(users, emoticons, 0);

        result[0] = maxUsers;
        result[1] = totalCost;

        return result;
    }

    // 백트래킹으로 모든 경우의 수 확인
    public void dfs(int[][] users, int[] emoticons, int depth) {
        // 할인율이 이모티콘의 수만큼 선택되었을 때, 서비스 가입자 수와 판매액을 계산
        if(depth == emoticons.length) {
            calculate(users, emoticons);
            return;
        }

        // 각 이모티콘의 할인율을 선택 (10% ~ 40%)
        for (int i = 1; i <= 4; i++) {
            emoticonDiscounts[depth] = i;
            dfs(users, emoticons, depth + 1);
        }
    }

    public void calculate(int[][] users, int[] emoticons) {
        int money = 0;
        int user = 0;
        int[][] newUsers = new int[users.length][2];

        // users 배열 복사
        for(int i = 0; i < users.length; i++) {
            newUsers[i] = users[i].clone();
        }

        for (int i = 0; i < newUsers.length; i++) {
            for (int j = 0; j < emoticons.length; j++) {
                // 이모티콘 할인율이 유저의 기준 할인율보다 큰 경우 이모티콘을 구매
                if (newUsers[i][0] <= emoticonDiscounts[j] * 10) {
                    int temp = emoticons[j] - (int) (emoticons[j] * emoticonDiscounts[j] / 10.0);

                    // 이모티콘 구매 비용의 합이 설정한 기준치를 초과한 경우, 이모티콘 구매를 모두 취소하고, 이모티콘 플러스 서비스 가입
                    if (newUsers[i][1] - temp <= 0) {
                        money -= (users[i][1] - newUsers[i][1]);
                        user++;
                        break;
                    } else {
                        money += temp;
                        newUsers[i][1] -= temp;
                    }
                }
            }
        }

        // 최대 서비스 가입자 수를 갱신
        if (user >= maxUsers) {
            if (user > maxUsers) {
                totalCost = money;
            } else {
                totalCost = Math.max(totalCost, money);
            }
            maxUsers = user;
        }
    }
}