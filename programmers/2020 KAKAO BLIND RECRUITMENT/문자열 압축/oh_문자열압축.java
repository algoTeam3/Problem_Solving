package programmers.Lv1;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @packageName : programmers.Lv1
 * @fileName : receive_report_results
 * @date : 2022-01-29
 * @language : JAVA
 * @classification : simulation
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_문자열압축 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[][] map = new int[id_list.length][id_list.length];
        int[] caution = new int[id_list.length];
        //신고
        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i]);
            int from = Arrays.asList(id_list).indexOf(st.nextToken());
            int to = Arrays.asList(id_list).indexOf(st.nextToken());
            map[from][to]=1;
        }
        //정지
        for (int i = 0; i < map[0].length; i++) {
            int count = 0;
            for (int j = 0; j < map.length; j++) {
                if(map[j][i]==1)count++;
            }
            caution[i]=count;
        }
        // 알림
        for (int i = 0; i < map.length; i++) {
            int count = 0;
            for (int j = 0; j < map.length; j++) {
                if(map[i][j]==1){
                    if(caution[j]>=k)count++;
                }
            }
            answer[i]=count;
        }
        return answer;
    }
}
