import java.util.*;

class Solution {
    public String[] solution(String[] record) {
       String[] answer;
        HashMap<String, String> id_nickname = new HashMap<>();
        ArrayList<String> userId = new ArrayList<>();
        ArrayList<String> command = new ArrayList<>();

        for (int i = 0; i < record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String cmd = st.nextToken();
            String user_id = st.nextToken();

            if(cmd.startsWith("E")){
                String nickname = st.nextToken();
                id_nickname.put(user_id, nickname);
                userId.add(user_id);
                command.add("님이 들어왔습니다.");
            }else if(cmd.startsWith("L")){
                userId.add(user_id);
                command.add("님이 나갔습니다.");
            }else {// Change
                String nickname = st.nextToken();
                id_nickname.replace(user_id, nickname);
            }
        }

        answer = new String[userId.size()];
        for (int j = 0; j < answer.length; j++){
            StringBuilder sb = new StringBuilder();
            sb.append(id_nickname.get(userId.get(j)));
            sb.append(command.get(j));
            answer[j] = sb.toString();
        }

        return answer;
    }
}