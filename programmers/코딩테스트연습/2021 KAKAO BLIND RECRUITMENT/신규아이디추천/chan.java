class chan {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();   // 1단계
        answer = answer.replaceAll("[^a-z0-9-_.]","");  // 2단계. 리턴값으로 answer 받아야 변경 적용
        answer = answer.replaceAll("\\.+",".");  // 3단계. 특수문자(.)는 역슬래시 두 개 (자바)
        answer = answer.replaceAll("(^\\.|\\.$)","");  // 4단계. 처음이나 끝에 위치하는 . 제거
        // 5단계
        if (answer.length() == 0) answer = "a";
        // 6단계
        if (answer.length() >= 16) {
            answer = answer.substring(0,15);
            answer = answer.replaceAll("(^\\.|\\.$)","");
        }
        // 7단계
        if (answer.length() <= 2) {
            char ch = answer.charAt(answer.length() - 1);
            while(answer.length() < 3) answer += ch;
        }
        return answer;
    }
}