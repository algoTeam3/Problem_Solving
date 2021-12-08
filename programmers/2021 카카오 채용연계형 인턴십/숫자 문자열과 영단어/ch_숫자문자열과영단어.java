import java.util.HashMap;

public class ch_숫자문자열과영단어 {
    public int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        String result = "";
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (Character.isDigit(now)) {   // 숫자 여부 판단
                result += now;
                tmp = "";
            } else {
                tmp += now;
                if (map.get(tmp) != null) {
                    result += map.get(tmp);
                    tmp = "";
                }
            }
        }
        return Integer.parseInt(result);
    }
}
