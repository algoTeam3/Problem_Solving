import java.util.Stack;

public class ch_64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();

        // 크레인 이동
        outer: for(int i = 0; i < moves.length; i++){
            // 높이만큼 반복하여 인형 찾기
            for(int j = 0; j < board[0].length; j++){
                int pick = board[j][moves[i] - 1];

                // 인형이 있으면
                if(pick != 0){
                    // 해당 칸 비우기
                    board[j][moves[i] - 1] = 0;

                    // 아무것도 없거나 가장 위의 인형과 넣을 인형이 같지 않으면
                    if(st.isEmpty() || st.peek() != pick){
                        st.push(pick);
                    }else {
                        st.pop();
                        // 같은 두개 터트리기
                        answer += 2;
                    }
                    continue outer;
                }
            }
        }
        return answer;
    }
}

