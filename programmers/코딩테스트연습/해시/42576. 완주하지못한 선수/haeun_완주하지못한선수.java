import java.util.HashMap;

public class programmers_lv1_완주하지못한선수 {

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
	}

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<>();
        
        // 참가자 명단
        for (String p : participant) {
        	// 이름 중복 X
        	if (hash.get(p) == null) hash.put(p, 1);
        	// 이름 중복 O
        	else hash.put(p, hash.get(p)+1);
        }
        
        // 완주자 명단
        for (String p : completion) {
        	// 완주 O
        	hash.put(p, hash.get(p)-1);
        }
        
        // 완주하지 못한 참가자
        for (String p : participant) {
        	if (hash.get(p) != 0) answer = p;
        }
        
        return answer;
    }
}
