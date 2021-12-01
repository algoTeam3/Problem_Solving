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

public class oh_1107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //0-9까지
        boolean[] key = new boolean[10];
        //목표
        int target = Integer.parseInt(br.readLine());
        //고장난  숫자
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            key[Integer.parseInt(st.nextToken())] = true;
        }
        //+-버튼으로만 눌려서 
        int answer = Math.abs(target - 100);
        //가까운 채널로 가서 +-
        for (int i = 0; i < 9999999; i++) {
            //갈수 있는 채널인가
            boolean flag = true;
            int num = i;
            int len = 0;

            while (num > 0) {
                int check = num % 10;
                if (key[check]) {
                    flag = false;
                    break;
                } else {
                    num /= 10;
                }
                len++;
            }
            if(i==0){
                answer = Math.min(answer, 1 + (Math.abs(target - i)));
            }
            if (flag) {
                answer = Math.min(answer, len + (Math.abs(target - i)));
            }
        }
        System.out.println(answer);
    }
}
