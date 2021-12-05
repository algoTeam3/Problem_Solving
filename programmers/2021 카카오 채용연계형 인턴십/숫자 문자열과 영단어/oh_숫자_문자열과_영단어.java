/**
 * @packageName : programmers
 * @fileName : 숫자 문자열과 영단어
 * @date : 2021. 12. 06.
 * @language : JAVA
 * @classification : String
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:00
 * @submissions : 1
 * @description
 *
 **/
public class oh_숫자_문자열과_영단어 {
    static String[] arr ={"zero","one","two","three","four","five","six","seven","eight","nine"};

    public static void main(String[] args) {
        int result = solution("2three45sixseven");
        System.out.println(result);
    }
    public static int solution(String s) {
        for (int i = 0; i < arr.length; i++) {
            if(s.contains(arr[i])){
                s=s.replace(arr[i],Integer.toString(i));
            }
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}
