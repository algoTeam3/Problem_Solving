import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int ans_cnt = 0;
        int wrong_cnt = 0;
        for(int i = 0; i < 6; i++){
            if(lottos[i] == 0) {
                wrong_cnt++;
                continue;
            }
            for(int j = 0; j < 6; j++){
                if(lottos[i] < win_nums[j]) break;
                if(lottos[i] == win_nums[j]) ans_cnt++;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <= 6; i++){
            if(i < 2){
                map.put(i, 6);
            }else{
                int a = 7 - i;
                map.put(i, a);
            }
        }
        answer[1] = map.get(ans_cnt);
        answer[0] = map.get(ans_cnt==6?ans_cnt:ans_cnt+wrong_cnt);
        return answer;
    }
}