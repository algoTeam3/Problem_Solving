public class ch {
    public String solution(String new_id) {
        // 1단계 : new_id 모든 대문자를 대응 소문자로  치환
        String answer = new_id.toLowerCase();
        // 2단계 : 소문자, 숫자, -, _, .를 제외한 문자 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        // 3단계 : 중복된 .은 하나로 표시
        // 하나 이상(+)
        answer = answer.replaceAll("\\.+", ".");
        // 4단계 : 마침표가 처음이나 끝이면 제거
        // 시작점(^) 끝점($)
        answer = answer.replaceAll("(^\\.|\\.$)", "");
        // 5단계 : 빈 문자열이면 a대입
        if(answer.length() == 0) answer = "a";
        // 6단계 : 길이가 16이상이면 첫 15개 제외한 문자 제거
        // 제거 후 마침표 있으면 마침표 제거
        if(answer.length() >= 16) answer = answer.substring(0, 15).replaceAll("(\\.$)", "");
        // 7단계 : 길이가 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반복
        if(answer.length() <= 2) {
            char ch = answer.charAt(answer.length() - 1);
            while(answer.length() < 3) {
                answer += ch;
            }
        }
        return answer;
    }
}
