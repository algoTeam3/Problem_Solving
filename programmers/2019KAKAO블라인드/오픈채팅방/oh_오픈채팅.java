package programmers.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @packageName : programmers.Lv2
 * @fileName : openchat
 * @date : 2022-02-10
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_오픈채팅 {
    public String[] solution(String[] record) {

        ArrayList<String[]> order = new ArrayList<>();
        HashMap<String, String> userinfo = new HashMap<>();
        //정보 얻기
        for (int i = 0; i < record.length; i++) {
            String[] st = record[i].split(" ");
            String act = st[0];
            String id = st[1];


            if(act.equals("Enter")){
                order.add(new String[]{act,id});
                String nick = st[2];
                userinfo.put(id,nick);

            }else if(act.equals("Leave")){
                order.add(new String[]{act,id});
            }else{
                String nick = st[2];
                userinfo.put(id,nick);
            }
        }
        String[] answer = new String[order.size()];
        //정보 출력
        for (int i = 0; i < order.size(); i++) {
            String act ="";
            String nick = userinfo.get(order.get(i)[1]);

            if(order.get(i)[0].equals("Enter")){
                act=nick+"님이 들어왔습니다.";
            }else act =nick+"님이 나갔습니다.";

            answer[i]=act;
        }
        return answer;
    }
}
