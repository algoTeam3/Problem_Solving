import java.util.Stack;

public class D9_짝지어제거하기 {

    public static void main(String[] args) {
        String s = "baabaa";
        int sol = solution(s);
        System.out.println(sol);
    }

    static public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(stack.isEmpty() || stack.peek() != chars[i])
                stack.push(chars[i]);
            else if(stack.peek() == chars[i])
                stack.pop();
        }
        if (stack.isEmpty()) answer = 1;


        return answer;
    }
}
