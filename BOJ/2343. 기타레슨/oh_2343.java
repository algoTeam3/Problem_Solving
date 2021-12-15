

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_1920_기타레슨
 * @date : 2021. 12. 11.
 * @language : JAVA
 * @classification : binnary search
 * @time_limit : 1sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 **/
public class oh_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());               //강의 갯수
        int M = Integer.parseInt(st.nextToken());               //블루레이 녹화 갯수
        int min = 0;
        int max = 0;
        List<Integer> que = new ArrayList<>();                 //강의의 길이를 담는 곳
        ArrayList<Integer> bluray = null;                      //블루레이 담는 곳
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            que.add(temp);
            max += temp;
            min = Math.max(min,temp);
        }

        //lower bound
        while (min <= max) {
            int mid = (min + max)/2;                          //블루레이의 최대크기

            /*
             * 블루레이 최대 크기만큼 강의를 채운다
             * 블루레이의 최대크기를 넘으면 새로운 블루레이에 담는다
             *
             */
            int len = 0;
            Queue<Integer> copy = new LinkedList<>(que);
            bluray = new ArrayList<>();
            while (!copy.isEmpty()) {
                int temp = copy.peek();
                len += temp;
                if (len <= mid) {
                    copy.poll();
                    if(copy.isEmpty()){
                        bluray.add(len);
                    }
                } else {
                    bluray.add(len-temp);
                    len = 0;
                }
            }

            /*
             * 블루레이 담는 곳 사이즈가 M보다 크면
             * mid의 크기를 늘린다.
             *
             */
            if (bluray.size() <= M) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min);

    }
}
