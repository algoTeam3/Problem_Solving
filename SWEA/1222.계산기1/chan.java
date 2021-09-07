import java.util.*;
import java.io.*;
class chan {
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int len = Integer.parseInt(br.readLine());
            int ans = 0;
            char[] input = br.readLine().toCharArray();
            Queue<Character> queue = new LinkedList<>();
 
            // 입력받은 식 큐에 넣기
            for (int i = 0; i < len; i++) {
                   queue.offer(input[i]);
            }
 
            Queue<Character> posQueue = new LinkedList<>();
            Stack<Character> stack = new Stack<>();
            // 숫자면 후위식 큐에, 연산자면 스택을 비우고 스택에 추가
            for (int i = 0; i < len; i++) {
                if (queue.peek() == '+') {
                       if (stack.isEmpty()) {
                            stack.add(queue.poll());   
                       } else {
                            while(!stack.isEmpty()) {
                                posQueue.offer(stack.pop());   
                            }
                           stack.push(queue.poll());
                       }
                } else {
                       posQueue.offer(queue.poll());
                }
            }
            // 마지막에 스택에 남아있는 연산자 후위식에 추가하기
            while(!stack.isEmpty()) {
                posQueue.offer(stack.pop());
            }
 
            Stack<Integer> operStack = new Stack<>();
 
            // 후위식큐에서는 숫자면 스택에 추가, 연산자면 스택에서 숫자를 빼서 뒤쪽 피연산자, 하나 더 빼서 앞쪽 피연산자로 두고 연산한다.
            while(!posQueue.isEmpty()) {
                if (posQueue.peek() != '+') {
                    operStack.push(posQueue.poll() - '0');
                } else {
                    int a = operStack.pop();  
                    int b = operStack.pop();
                    posQueue.poll();
                    operStack.push(a + b);
                }
            }
 
            // 마지막에 스택에 남아있는 연산자 후위식에 추가하기
            while(!operStack.isEmpty()) {
               ans = operStack.pop();
            }   
             
            System.out.println("#" + t + " " + ans);
        }
    }
}
