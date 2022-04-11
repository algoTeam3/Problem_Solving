import java.util.*;

/**
    수포자는 수학 문제를 전부 찍으려고 한다
    1번 수포자: 12345,12345 반복
    2번 수포자: 21232425,21232425 반복
    3번 수포자: 3311224455,3311224455 반복
    return 문제를 가장 많이 맞힌 사람 배열에 담아 리턴
 */
public class D10_모의고사 {

    static class S implements Comparable<S>{
        private int n;
        private int cnt;

        public S(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(S o) {
            return Integer.compare(o.cnt, this.cnt);
        }
    }

    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        int[] solution = solution(answers);
        System.out.println(Arrays.toString(solution));
    }

    /**
     *
     * @param answers 문제의 정답
     * @return 가장 많이 맞힌 사람의 번호
     */
    private static int[] solution(int[] answers) {
        S[] res = new S[3];
        int on = 0, tw = 0, th = 0;

        for (int i = 0; i < answers.length; i++) {
            // i 는 문제 번호
            int ans = answers[i];

            // 1번
            if(ans == i%5 + 1) on++;
            // 2번
            if(i%2 == 0){
                // 짝수면 2로 찍는다
                if (ans == 2) tw++;
            }else{
                // i%8이 1,3일 경우
                if (i%8 < 4){
                    if (ans == i%8) tw++;
                // i%8이 5,7일 경우
                }else{
                    double k = i%8;
                    if (ans == Math.ceil(k/2)+1) tw++;
                }
            }
            // 3번
            if(i%10 == 0 || i%10 == 1){
                if (ans == 3) th++;
            }else {
                // i%10이 6보다 작을 경우
                double k = i%10;
                if (k < 6){
                    if (Math.floor(k/2) == ans) th++;
                }else {
                    if (Math.floor(k/2)+1 == ans) th++;
                }
            }
        }

        System.out.println(on+" "+ tw+ " "+th);
        res[0] = new S(1, on);
        res[1] = new S(2, tw);
        res[2] = new S(3, th);

        Arrays.sort(res);
        LinkedList<Integer> answer1 = new LinkedList<>();

        int maxCnt = res[0].cnt;
        answer1.add(res[0].n);
        for (int i = 1; i < res.length; i++) {
            if (res[i].cnt < maxCnt) break;
            answer1.add(res[i].n);
        }

        int[] answer = new int[answer1.size()];
        for (int i = 0; i < answer1.size(); i++) {
            answer[i] = answer1.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
