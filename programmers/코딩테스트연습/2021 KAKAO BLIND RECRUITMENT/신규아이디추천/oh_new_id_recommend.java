package programmers.Lv1;



public class oh_new_id_recommend {
    static String[] SC = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "=", "+", "[", "{", "]", "}", ":", "?", "<", ">", "/",","};

    public String solution(String new_id) {
        String answer = "";

        // 1 소문자 치환
        new_id = new_id.toLowerCase();
        // 2.특수 문자 제거
        for (String c : SC) {
            new_id = new_id.replace(c, "");
        }
        // 3 '.'2개이상 '.'으로 치환
        new_id = new_id.replace("..", ".");
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        // 4 처음 끝 마침표 제거
        if (new_id.length()>0 && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1, new_id.length());
        }
        if (new_id.length()>0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }


        // 5 빈 문자열 "a" 대입
        if (new_id.equals("")) {
            new_id = "a";
        }
        // 6 길이 제한
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);

            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        // 7 길이 늘리기
        if (new_id.length() <= 2) {
            while (new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        answer = new_id;
        return answer;
    }
}
