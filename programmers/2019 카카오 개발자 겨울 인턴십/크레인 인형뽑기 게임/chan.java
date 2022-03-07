import java.util.*;
import java.io.*;

class chan {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer> stack = new Stack<>();
        
        for (int m = 0; m < moves.length; m++) {
            for (int i = 0; i < N; i++) {
                int pickedDoll = board[i][moves[m] - 1];
                
                if (pickedDoll != 0) {               
                    board[i][moves[m] - 1] = 0; // 뽑은 인형 자리는 빈 칸으로 변경
                    
                    // 바구니에 같은 모양의 인형이 제일 위에 없다면 지금 집은 인형 바구니에 넣기
                    if (stack.size() == 0 || stack.peek() != pickedDoll) { 
                        stack.push(pickedDoll);
                    } else { // 바구니 제일 위에 같은 모양의 인형 있으면 터뜨리기
                        stack.pop();
                        answer += 2;
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}