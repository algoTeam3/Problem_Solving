package programmers.Lv2;

import java.util.ArrayList;

/**
 * @packageName : programmers.Lv2
 * @fileName : string_processin
 * @date : 2022-01-30
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_문자열압축 {
    public int solution(String s) {
        int count=1;
        int answer = Integer.MAX_VALUE;
        StringBuilder sb;
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 1; i <= s.length()/2; i++) {
            sb = new StringBuilder();
            String temp = s.substring(0,i);

            for (int j = i; j < s.length(); j+=i) {
                if(j+i>s.length()){
                    sb.append(s.substring(j-i,s.length()));
                    break;
                }
                String temp2 = s.substring(j,j+i);

                if(temp.equals(temp2)){
                    count++;
                }else{
                    if(count==1){
                        sb.append(temp);
                    }else{
                        sb.append(count).append(temp);
                        count=1;
                    }
                    temp=temp2;
                }

            }
            if(count==1){
                sb.append(temp);
            }else{
                sb.append(count).append(temp);
                count=1;
            }
            answer=Math.min(answer,sb.length());
        }

        return answer;
    }
}
