class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        boolean[] isSelected = new boolean[win_nums.length];
        
        int cnt = 0;
        int correct = 0;
        
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) cnt++;
            
            for (int j = 0; j < win_nums.length; j++) {
                if (isSelected[j]) continue;
                if (lottos[i] == win_nums[j]) {
                    isSelected[j] = true;
                    correct++;
                }
            }
        }

        int max = cnt + correct;
        int min = correct;

        if (max == 0) {
            answer[0] = 6;
        } else {
            answer[0] = 7 - max;
        }
        if (min <= 1) {
            answer[1] = 6;
        } else {
            answer[1] = 7 - min;
        }
        
        return answer;
    }
}