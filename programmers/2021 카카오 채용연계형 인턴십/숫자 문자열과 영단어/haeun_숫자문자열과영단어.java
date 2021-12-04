import java.util.HashMap;

public class programmers_lv1_숫자문자열과영단어 {

	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
	}
	
	 public static int solution(String s) {
        String answer = "";
        HashMap<String, String> hash = new HashMap<>();
        hash.put("zero", "0");
        hash.put("one", "1");
        hash.put("two", "2");
        hash.put("three", "3");
        hash.put("four", "4");
        hash.put("five", "5");
        hash.put("six", "6");
        hash.put("seven", "7");
        hash.put("eight", "8");
        hash.put("nine", "9");
        
        for (int i = 0; i < s.length(); i++) {
        	// 숫자는 그대로 넣기
        	if (s.charAt(i) >= '0' && s.charAt(i) <= '9') answer += s.charAt(i);
        	// 영단어에 대응되는 숫자 찾기
        	else {
        		// 영단어 하나씩 늘리기
        		for (int j = i + 1; j <= i + 5; j++) {
        			String temp = s.substring(i, j);
        			// 영단어에 해당하는 숫자가 있다면 answer에 넣기
        			if (hash.containsKey(temp)) {
        				answer += hash.get(temp);
        				// 영단어 길이만큼 생략
        				i = j - 1;
        				// for문 탈출 다음값 탐색
        				break;
        			}
        		}
        	}
        }
        
        // 숫자로 변환 후 출력
        return Integer.parseInt(answer);
    }
}
