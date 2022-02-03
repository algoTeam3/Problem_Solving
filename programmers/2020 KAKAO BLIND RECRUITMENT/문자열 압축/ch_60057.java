public class ch_60057 {
    private static int Solution(String s) {
        int answer = s.length();
        /*
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            map.clear();
            for (int j = 1; j < s.length(); j++) {
                String str = s.substring(j, j + i);
                if (map.containsKey(str)){
                    int value = map.get(str);
                    map.put(str, ++value);
                }else {
                    map.put(str, 1);
                }
            }
            for(Map.Entry<String, Integer> elem : map.entrySet()) {
                if (elem.getValue() > 1)
                    sb.append(elem.getValue() + elem.getKey());
                else
                    sb.append(elem.getKey());
            }
            answer = Math.min(answer, sb.length());
        }
        */

        for (int i = 1; i <= s.length() / 2; i++) {
            int cnt = 1;    //압축 단어 길이
            StringBuilder sb = new StringBuilder();
            String str = s.substring(0, i);

            for (int j = i; j <= s.length(); j += i) {
                // 다음 문자열
                String temp = s.substring(j, j + i > s.length() ? s.length() : i + j); // 범위 체크
                // 현재와 다음 문자열이 같으면 cnt 증가
                if (str.equals(temp)) cnt++;
                else {
                    sb.append((cnt != 1 ? cnt : "") + str); // 압축시 cnt를 아닐 시 공백을 추가 + 다음 압축할 문자
                    str = temp;     //다음 문자부터로 이동
                    cnt = 1;
                }
            }
            sb.append(str); // 압축 안된 문자열 추가
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
