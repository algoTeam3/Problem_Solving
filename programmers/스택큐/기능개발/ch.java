package Programmers;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
    private static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> anslist = new ArrayList<>();
        int[] daycnt = new int[100];
        int day = 0;

        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (day * speeds[i]) < 100) {
                day += 1;
            }
            daycnt[day] += 1;
        }

        for (int i = 0; i < daycnt.length; i++) {
            if (daycnt[i] == 0) {
                continue;
            } else {
                anslist.add(daycnt[i]);
            }
        }
        int[] answer = new int[anslist.size()];

        for (int i = 0; i < anslist.size(); i++) {
            answer[i] = anslist.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        solution(progresses, speeds);
    }
}
