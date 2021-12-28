package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @packageName : programmers
 * @fileName : BOJ12891
 * @date : 2021-12-26
 * @language : JAVA
 * @classification : sliding window
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());                   // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken());                   // 부분 문자열 길이
        int start = 0;
        int answer = 0;
        ArrayList<Character> sum = new ArrayList<>();
        Map<Character, Integer> DNA = new HashMap();

        char[] str = br.readLine().toCharArray();


        st = new StringTokenizer(br.readLine());
        DNA.put('A', Integer.parseInt(st.nextToken()));
        DNA.put('C', Integer.parseInt(st.nextToken()));
        DNA.put('G', Integer.parseInt(st.nextToken()));
        DNA.put('T', Integer.parseInt(st.nextToken()));


        for (int end = 0; end < str.length; end++) {

            DNA.put(str[end], DNA.get(str[end]) - 1);

            if (end >= P-1) {
                if(DNA.get('A')<=0&&DNA.get('C')<=0&&DNA.get('G')<=0&&DNA.get('T')<=0){
                    answer++;
                }
                DNA.put(str[start], DNA.get(str[start]) + 1);
                start++;
            }
        }
        System.out.println(answer);
    }
}
