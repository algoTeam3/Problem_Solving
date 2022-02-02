import java.util.Arrays;
import java.util.StringTokenizer;

public class ch_92334 {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            StringTokenizer st;
            boolean[][] visited = new boolean[id_list.length][id_list.length];

            // 신고
            for(int i = 0; i < report.length; i++){
                st = new StringTokenizer(report[i]);
                visited[Arrays.asList(id_list).indexOf(st.nextToken())]
                        [Arrays.asList(id_list).indexOf(st.nextToken())] = true;
            }

            int[] temp = new int[id_list.length];
            // 신고 횟수 처리
            for (int i = 0; i < id_list.length; i++)
                for (int j = 0; j < id_list.length; j++)
                    if (visited[j][i]) temp[i]++;


            // 메일 보낼 사람 처리
            for (int i = 0; i < temp.length; i++) {
                // 신고받은 횟수가 정리 처분이면
                if (temp[i] >= k) {
                    for (int j = 0; j < id_list.length; j++)
                        // 정지 처리 메일 보내기
                        if (visited[j][i]) answer[j]++;
                }
            }
            return answer;
        }
    }
}
