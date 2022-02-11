public class ch_77484 {

    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            int cnt = 0;
            // 모르는 번호 개수 확인
            for(int i = 0; i < 6; i++){
                if(lottos[i] == 0) cnt++;
            }

            int win = 0;
            // 당첨 가능 번호 개수 확인
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 6; j++){
                    if(win_nums[i] == lottos[j]) win++;
                }
            }

            // 등수 계산
            answer[0] = (win + cnt) > 1 ? 6 - (win + cnt) + 1 : 6;
            answer[1] = win > 1 ? 6 - win + 1 : 6;
            return answer;
        }
    }
}
