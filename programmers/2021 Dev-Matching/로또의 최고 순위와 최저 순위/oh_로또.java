package programmers.Lv1;

import java.util.HashMap;

/**
 * @packageName : programmers.Lv1
 * @fileName : lotto
 * @date : 2022-02-08
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_로또 {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        int countRank = 0;
        int countZero = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                countZero++;
            } else {
                map.put(lotto, 0);
            }
        }
        for (int i : win_nums) {
            if(map.containsKey(i)){
                countRank++;
            }
        }

        answer[0]=7-countRank-countZero==7?6:7-countRank-countZero;
        answer[1]= 7-countRank==7?6:7-countRank;
        return answer;
    }
}

