public class Solution {
    public String solution (String new_id) {
        // 1단계(소문자)
        String answer = new_id.toLowerCase()
                // 2단계(소문자, 숫자, (-), (_), (.)를 제외한 문자 제거)
                .replaceAll("[^a-z0-9-_.]", "")
                // 3단계(연속된 .는 .한개로 치환)
                .replaceAll("[.]{2,}", ".")
                // 4단계(처음 .이나 끝 .은 제거)
                .replaceAll("^([.])|([.])$", "");
        
        // 5단계(빈 문자열일 때 'a'대입)
        if (answer.length() == 0) answer += 'a';
        // 6단계(16자 이상이면 제거, .로 끝나면 .제거)
        if (answer.length() >= 16) answer = answer.substring(0, 15).replaceAll("([.])$", "");
        // 7단계(2자 이하면, 마지막 문자 반복)
        while (answer.length() < 3) answer += answer.charAt(answer.length()-1);
       
       // answer 반환
       return answer;
    }
}
