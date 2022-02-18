public class D3_신규아이디추천 {
    /**
     * 1. 모든 대문자를 소문자로 치환
     * 2. 알파벳 소문자,숫자,-,_,.를 제외한 문자 제거
     * 3. ..가 연속적으로 된 부분은 .으로 치환
     * 4. .이 시작이나 끝에 들어있다면 제거
     * 5. 빈 문자열이면 'a' 대입
     * 6. 길이가 16자 이상이면 첫 15개 문자열만 살리고 날리기
     * 7. 제거 후 .이 마지막에 위치하면 .제거하기
     * 8. 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복하기
     * @param args
     */
    public static void main(String[] args) {
        String new_id = "123_.def";
        String solution = solution(new_id);

        System.out.println(solution);
    }

    public static String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        new_id = new_id.replaceAll("[^0-9a-zA-Z-_.]", "");
        int k = 0;
        for (char c : new_id.toCharArray()) {
            if(c == '.'){
                if(k == 0){
                    sb.append(c);
                }
                k++;
            }else{
                sb.append(c);
                k = 0;
            }
        }
        new_id = sb.toString();
        if(new_id.startsWith(".")) new_id = new_id.substring(1);
        if(new_id.endsWith(".")) new_id = new_id.substring(0,new_id.length()-1);
        if(new_id.length() == 0) new_id = "a";
        if(new_id.length() >= 16) new_id = new_id.substring(0, 15);
        if(new_id.endsWith(".")) new_id = new_id.substring(0,new_id.length()-1);
        sb = new StringBuilder();
        sb.append(new_id);
        String last = new_id.substring(new_id.length()-1);
        while(sb.length() <= 2){
            sb.append(last);
        }

        answer = sb.toString();
        return answer;
    }
}
