package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ_1107_리모컨
 * @date : 2021. 12. 01.
 * @language : JAVA
 * @classification : brute force
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 **/

public class BOJ1107 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = 100;                                // 시작채널
        int N = Integer.parseInt(br.readLine());        // 이동하려는 채널
        int M = Integer.parseInt(br.readLine());        // 고장난 버튼
        int answer = 0;
        boolean[] error = new boolean[10];              // 고장난 숫자

        //고장난 버튼 체크
        if(M!=0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                error[num] = true;
            }
        }
        //+,-버튼으로만 이동할경우
        answer = Math.abs(N - start);

        //숫자로 이동후 +,-
        for (int i = 0; i < 1000000; i++) {
            boolean flag = true;
            int check = i;



            while (check / 10 != 0) {
                if (error[check % 10]) {
                    flag = false;
                    break;
                }
                check /= 10;
            }

            if (error[check % 10]) {
                flag = false;
            }

            if (flag) {
                int buttenCount = Integer.toString(i).length();
                int gap = Math.abs(N - i);
                answer = Math.min(answer, buttenCount + gap);
            }
        }

        System.out.println(answer);
    }
}
