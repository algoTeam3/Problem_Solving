import java.util.Stack;

/**
    괄호의 개수는 맞지만 짝이 맞지 않는 형태의 오류
    소스 코드에 작성된 모든 괄호를 뽑아 올바른 순서대로 배치된 괄호 문자열을 알려주는 프로그램을 개발하자
    같은 크기의 괄호의 숫자를 가지면 "균형잡힌 괄호 문자열"
    짝도 모두 맞은 경우 "올바른 괄호 문자열"
    1. 입력이 빈 문자열의 경우, 빈 문자열 반환
    2. 문자열 w를 "균형 잡힌 괄호 문자열" u, v로 분리. 단, u는 "균형 잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있다.
    3. 문자열 u가 "올바른 괄호 문자열"이라면 문자열 v에 대해 1단계부터 다시 수행
        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환
    4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행한다.
        4-1. 빈 문자열에 첫번째 문자로 '('를 붙인다.
        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙인다.
        4-3. ')'를 다시 붙인다.
        4-4. u의 첫번째와 마지막 문자를 제거하고 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙인다.
        4-5. 생성된 문자열 반환
 */
public class D11_괄호변환 {

    public static void main(String[] args) {
        String p = "()))((()";
        String solution = solution(p);
        System.out.println(solution);
    }

    private static String solution(String p) {
        String answer = "";

        //    1. 입력이 빈 문자열의 경우, 빈 문자열 반환
        if (p.isEmpty()) return "";

        int front = 0;
        int back = 0;
        int i = 0;
        for (i = 0; i < p.length(); i++) {
            char aChar = p.charAt(i);
            if (aChar == '(')
                front++;
            else
                back++;
            if (front == back) break;
        }
        String u = p.substring(0,i+1);
        String v = p.substring(i+1, p.length());

        boolean isOk = checkRight(u);
        if (isOk) {
            //    3. 문자열 u가 "올바른 괄호 문자열"이라면 문자열 v에 대해 1단계부터 다시 수행
            String s = solution(v);
            //        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환
            u = u.concat(s);
        }else{
            //    4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행한다.
            String s = "";
            //        4-1. 빈 문자열에 첫번째 문자로 '('를 붙인다.
            s = s.concat("(");
            //        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙인다.
            s = s.concat(solution(v));
            //        4-3. ')'를 다시 붙인다.
            s = s.concat(")");
            //        4-4. u의 첫번째와 마지막 문자를 제거하고 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙인다.
            u = u.substring(1, u.length() - 1);
            u = reverse(u);
            s = s.concat(u);
            //        4-5. 생성된 문자열 반환
            return s;
        }

        return u;
    }

    private static String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);
            if (c == '(')
                sb.append(")");
            else
                sb.append("(");
        }

        return sb.toString();
    }

    private static boolean checkRight(String u) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);
            if(c == '(') s.push(c);
            else{
                if (s.isEmpty()) return false;
                else s.pop();
            }
        }

        if (s.isEmpty()) return true;
        else return false;
    }
}
