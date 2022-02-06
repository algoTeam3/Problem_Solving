import java.util.Arrays;

public class Solution_문자열압축2 {

    public static void main(String[] args) {
        String s = "a";
        System.out.println("압축할 문자열은 "+s+"이고, 길이는 "+s.length());
//        System.out.println(s.substring(0,10).length());
        int ans = solution(s);
        System.out.println(ans);
    }

    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        String res = "";
        // +1은 길이가 1인 경우
        for(int i = 1; i <= s.length()/2+1; i++) {
            // i는 반복되는 문자열 길이
            res = "";
            String pattern = "";
            pattern = s.substring(0, i);
            int n = 0;
            for(int j = 0; j <= s.length(); j+=i){

                if(j+i > s.length()){
                    if(n > 1){
                        res += String.valueOf(n);
                    }
                    res += pattern + s.substring(j);
                    break;
                }

                String p = s.substring(j, j+i);
                if(pattern.equals(p)){
                    n++;
                    continue;
                }else{
                    if(n > 1){
                        res += String.valueOf(n);
                    }
                    res += pattern;
                    pattern = s.substring(j, j+i);
                    n = 1;
                }

            }
            answer = Math.min(answer, res.length());
            System.out.println(i+"단위 문자열은 "+res+ "이고, 길이는 "+res.length());
        }

        return answer;
    }

}
