import java.util.*;

class chan {
   
    public String solution(String p) {
        String answer = solve(p);
        
        return answer;
    }
    
    private String solve(String p) {
        // 1.
        if (p.equals("")) {
            return p;
        }
        
        // 2.
        String u = "";
        String v = "";
        int balanceStrIdx = splitBal(p);
        if (balanceStrIdx == p.length() - 1) u = p;
        else {
            u = p.substring(0, balanceStrIdx + 1);
            v = p.substring(balanceStrIdx + 1);
        }
        
        if (isCorrectStr(u)) {  // 3.
            return u + solve(v); 
        } else {    // 4.
            String emptyStr = "(";
            emptyStr += solve(v);
            emptyStr += ")";
            String newU = u.substring(1, u.length() - 1);
            for (int i = 0; i < newU.length(); i++) {
                char cur = newU.charAt(i);
                if (cur == '(') emptyStr += ")";
                else emptyStr += "(";
            }
            return emptyStr;
        }
        
    }
    
    // 더 이상 분리할 수 없는 "균형잡힌 괄호 문자열"의 마지막 인덱스 반환
    private int splitBal(String p) {
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        stack.push(p.charAt(idx));
        for (int i = 1; i < p.length(); i++) {
            char cur = p.charAt(i);
            if (!stack.isEmpty()) {
                if (stack.peek() == cur) stack.push(cur);
                else stack.pop();
            } 
            if (stack.isEmpty()) {
                idx = i;
                break;
            }
        }
        
        return idx;
    }
    
    // 올바른 괄호 문자열인지 여부 확인
    private boolean isCorrectStr(String u) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < u.length(); i++) {
            char cur = u.charAt(i);
            if (cur == '(') {
                stack.push(cur);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
                
        return true;
        
    }
}