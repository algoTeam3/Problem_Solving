import java.util.*;
/*
 * 요구사항 : 오픈채팅방에 들어오고 나가거나 닉네임 변경 기록이 담긴 문자열배열이 주어질 때, 
 * 			모든 기록(닉네임변경)이 처리된 후 최종적으로 방의 관리자가 보게되는 메시지를 문자열 배열 형태로 반환해라
 * 조건 : Muzi가 들어왔다 나간 후, 다시 들어올 때 닉네임을 Prodo로 바꿨으면, 기존 채팅방에 남아있던 Muzi라는 이름도 Prodo로 바뀐다.
 * 
 * 풀이 과정 : uid별 닉네임을 관리하는 Map과, 들어오고 나간 기록을 관리하는 ArrayList를 사용
 * 들어온 문자열 각각을 분리해서, 첫번째 단어가 Enter면 
 * 						- 닉네임 관리 : 두번째 단어(uid)를 key로하고, 세번째 단어(nickname)을 value로 하여 map.put
 * 						- 기록 관리 : 두번째 단어(uid)와 첫번째 단어(들어오고 나간 상태)저장
 * 						첫번째 단어가 Leave면 
 * 						- 기록 관리 : 두번째 단어(uid)와 첫번째 단어(들어오고 나간 상태)저장
 * 						첫번째 단어가 Change면 
 * 						- 닉네임 관리 : 두번째 단어(uid)를 key로하고, 세번째 단어(nickname)을 value로 하여 map.put(키의 값 변경)
 */
class Solution {
  // 기록 관리에 사용할 클래스
    class Mng {
        String uid;
        String state;
        Mng(String uid, String state) {
            this.uid = uid;
            this.state = state;
        }
    }
    public String[] solution(String[] record) {
        int msgCnt = record.length;
        HashMap<String, String> map = new HashMap<>();
        ArrayList<Mng> transaction = new ArrayList<>();
        String[] stateString = {"들어왔습니다.", "나갔습니다."};
        
        String uid = "";
        String nickname = "";
        int ansLen = 0;
        for (int i = 0; i < msgCnt; i++) {
            StringTokenizer st = new StringTokenizer(record[i], " ");
            String state = st.nextToken();
            if (state.equals("Enter")) {    // Enter라면 분리된 st는 세 단어가 되고, 닉네임관리와 기록관리가 필요함
                uid = st.nextToken();
                nickname = st.nextToken();
                map.put(uid, nickname);
                transaction.add(new Mng(uid, stateString[0]));
                ansLen++;
            } else if (state.equals("Leave")) {  // Leave라면 분리된 st는 두 단어가 되고, 기록관리가 필요함
                transaction.add(new Mng(st.nextToken(), stateString[1]));
                ansLen++;
            } else {  // Change라면 분리된 st는 세 단어가 되고, 닉네임관리만 필요함
                uid = st.nextToken();
                nickname = st.nextToken();
                map.put(uid, nickname);
            }

        }
      // Enter와 Leave 수만큼 문자열 저장하기
        String[] answer = new String[ansLen];
        for (int i = 0; i < ansLen; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(map.get(transaction.get(i).uid))
                .append("님이 ")
                .append(transaction.get(i).state);
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}
