import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_신고결과받기 {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}; // A B = A가 B를 신고
        int k = 2;
        int[] answer = solution(id_list, report, k);

        System.out.println(Arrays.toString(answer));

    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];

        ArrayList<Integer>[] to = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            to[i] = new ArrayList<>();
        }

        t: for(int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i]);
            String f1 = st.nextToken();
            String t1 = st.nextToken();
            int f2 = 0, t2 = 0;
            for(int j = 0; j < n; j++) {
                if(f1.equals(id_list[j])) {
                    f2 = j;
                }
                if(t1.equals(id_list[j])) {
                    t2 = j;
                }
            }
            for(int j = 0; j < to[t2].size(); j++) {
                if(to[t2].get(j) == f2) continue t;
            }
            to[t2].add(f2); // 나를 신고한 사람 리스트
        }

        for(int i = 0; i < n; i++) {
            if(to[i].size() >= k) {
                // 신고당한 사람 i -> 신고한 사람들 answer 증가하기
                for(int j = 0; j < to[i].size(); j++) {
                    answer[to[i].get(j)]++;
                }
            }
        }


        return answer;
    }

}
