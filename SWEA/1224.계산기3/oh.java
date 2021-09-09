import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Expert1224 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1224.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            Stack<Character> sign = new Stack<>();
            Stack<Character> bracket = new Stack<>();

            //후위식으로 변환
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                switch (ch){
                    case '(':
                        sign.push(ch);
                        break;
                    case '+':
                        if(sign.isEmpty()){
                            sign.push(ch);
                        }else{
                            while(sign.peek()!='('){
                                sb.append(sign.pop());
                            }
                            sign.push(ch);
                        }
                        break;
                    case '*':

                        while (!sign.isEmpty()&&sign.peek() == '*') {
                            sb.append(sign.pop());
                            if(sign.peek()=='('){
                                break;
                            }
                        }
                        sign.push(ch);
                        break;
                    case ')':
                        while (sign.peek()!='('){
                            sb.append(sign.pop());
                        }
                        sign.pop();
                        break;
                    default:
                        sb.append(ch);
                }


            }
            //계산하기
            Stack<Integer> ch = new Stack();
            for (int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i)>=48&& sb.charAt(i)<=59){
                    ch.push(sb.charAt(i)-'0');
                }else{
                    int num1 = ch.pop();
                    int num2 = ch.pop();
                    if(sb.charAt(i)=='+'){
                        ch.push(num1+num2);
                    }else{
                        ch.push(num1*num2);
                    }
                }
            }
            System.out.println("#"+test_case+" "+ch.pop());
        }
    }
}
