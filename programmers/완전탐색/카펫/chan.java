
import java.util.ArrayList;

public class chan {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int carpet = brown + yellow;
        ArrayList<Integer> list = new ArrayList<>();
        // 카펫 격자 수의 약수 구하기
        for (int i = 1; i <= carpet; i++) {
            if (carpet % i == 0) {
                list.add(i);
            }
        }
        
        while (true) {
            // 카펫 격자수 약수 리스트 중에서 가장 차이가 적은 두 개를 가로 세로로 저장하기
            if (list.size() % 2 == 0) {
                answer[0] = list.get(list.size() / 2);
                answer[1] = list.get(list.size() / 2 - 1);
            } else {
                answer[0] = answer[1] = list.get(list.size() / 2);
            }
            // 예외처리 - (테케 4,6,7실패) 카펫의 갈색줄 테두리 한 줄인지 확인하기
            if ((answer[0] - 2) * (answer[1] - 2) == yellow) break;
            else {
                // 테두리 갈색줄이 한 줄이 아닐 때는 선택한 약수값 삭제하기
                if (list.size() % 2 == 0) {
                    list.remove(list.size() / 2);
                    list.remove(list.size() / 2);
                } else {
                    list.remove(list.size() / 2);
                }
            }
        }
        
        return answer;
    }
}