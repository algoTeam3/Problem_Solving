import java.util.Arrays;

public class ch {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);


        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                // 여벌 학생 도난당한 경우
                if(lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                // 체육복 빌려주는 경우
                if((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }


        return answer;
    }
}
