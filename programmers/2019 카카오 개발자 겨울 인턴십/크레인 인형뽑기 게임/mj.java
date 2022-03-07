import java.util.Stack;

public class D6_크레인인형뽑기게임 {

    public static void main(String[] args) {

        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int ans = solution(board, moves);
        System.out.println(ans);
    }

    static public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        int r = board.length;
        int c = board[0].length;

        // moves의 개수만큼 반복
        for(int i = 0; i < moves.length; i++){
            int where = moves[i]-1;
            int pick = 0;

            // 가져온 인형 찾기
            for(int j = 0; j < c; j++){
                if(board[j][where] != 0) {
                    pick = board[j][where];
                    board[j][where] = 0;
                    break;
                }
            }
            // 인형을 가져왔다면
            if(pick != 0){
                // 바구니가 비어있지 않다면
                if(!s.isEmpty()){
                    int first = s.peek();
                    // 두개가 같은 인형이라면
                    if(first == pick) {
                        // 삭제
                        s.pop();
                        // 사라진 인형의 개수 증가
                        answer = answer+2;
                    }else{
                        // 다른 인형이라면 가져온 것 넣기
                        s.push(pick);
                    }
                }else {
                    // 비어있다면 그대로 넣어주기
                    s.push(pick);
                }
            }

        }

        return answer;
    }
}
