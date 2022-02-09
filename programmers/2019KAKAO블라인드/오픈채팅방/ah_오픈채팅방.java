import java.util.*;

public class ah_오픈채팅방 {
	public String[] solution(String[] record) {
		StringTokenizer st;
		ArrayList<String> log = new ArrayList<>();
		HashMap<String, String> userInfo = new HashMap<>();
		for (String r : record) {
			st = new StringTokenizer(r);
			String firstWord = st.nextToken();
			String userId = st.nextToken();
			String nickName = "";
			if (!firstWord.equals("Leave")) {
				nickName = st.nextToken();
			}

			if (firstWord.equals("Enter")) {
				userInfo.put(userId, nickName);
				log.add(userId + "님이 들어왔습니다.");
			} else if (firstWord.equals("Leave")) {
				log.add(userId + "님이 나갔습니다.");
			} else if (firstWord.equals("Change")) {
				userInfo.put(userId, nickName);
			}
		}
		String[] answer = new String[log.size()];
		int i = 0;
		for (String str : log) {
			String id = str.substring(0, str.indexOf("님"));
			answer[i++] = str.replace(id, userInfo.get(id));
		}
		return answer;
	}
}