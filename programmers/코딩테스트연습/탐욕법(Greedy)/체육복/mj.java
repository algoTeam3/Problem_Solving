import java.util.Arrays;
import java.util.LinkedList;

/**
    학생의 번호는 체격 순. 바로 앞번호나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있다.
    체육복을 적절히 빌려 최대한 많은 학생이 체육 수업을 들어야 한다.

 */
public class D10_체육복 {

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};

        int solution = solution(n, lost, reserve);
        System.out.println(solution);

    }

    /**
     * 배열은 모두 오름차순
     * @param n 전체 학생의 수
     * @param lost 채육복을 도난당한 학생들의 번호 배열
     * @param reserve 여벌의 체육복을 가져온 학생들의 번호 배열
     * @return 수업을 들을 수 있는 학생의 최대값
    */
    private static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 원래 모두 하나씩
        int[] check = new int[n+1];
        Arrays.fill(check, 1);

        // 도난당한 경우 0
        for (int i = 0; i < lost.length; i++) {
            check[lost[i]]--;
        }

        // 도난 당했지만 여벌 있는 경우 1
        // 도난 당했고 여벌 없는 경우 0
        for (int i = 0; i < reserve.length; i++) {
            check[reserve[i]]++;
        }

        // 체육복이 없는 사람
        LinkedList<Integer> lost2 = new LinkedList<>();
        LinkedList<Integer> reserve2 = new LinkedList<>();
        for (int i = 1; i < check.length; i++) {
            if (check[i] == 0) lost2.add(i);
            else if (check[i] == 2) reserve2.add(i);
        }

        for (int i = 0; i < reserve2.size(); i++) {
            for (int j = 0; j < lost2.size(); j++) {
                if (lost2.get(j) == -1) continue;
                if (Math.abs(reserve2.get(i)-lost2.get(j)) == 1){
                    reserve2.set(i, -1);
                    lost2.set(j, -1);
                    break;
                }
            }
        }

        int k = 0;
        for (Integer integer : lost2) {
            if (integer != -1) k++;
        }

        return n-k;
    }
}
