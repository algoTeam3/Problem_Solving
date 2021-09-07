import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Expert1222 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            //후위식으로 만들기
            String str =br.readLine();
            for (int i = 0; i < n; i++) {
                switch (str.charAt(i)){
                    case '+':
                        stack.push(str.charAt(i));
                        if(stack.size()==2){
                            sb.append(stack.pop());
                        }
                        break;
                    default:
                        sb.append(str.charAt(i));
                        break;
                }
            }
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
            //계산하기
            Stack<Integer> ch = new Stack<>();
            for (int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i)>=48&&sb.charAt(i)<58){
                    ch.push(sb.charAt(i)-'0');
                }else{
                    int num1 = ch.pop();
                    int num2 = ch.pop();
                    ch.push(num1+num2);
                }
            }
            System.out.println("#"+test_case+" "+ch.pop());
            
        }
    }
}
