import java.util.Arrays;

public class D5_키패드누르기 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";

        String res = solution(numbers, hand);
        System.out.println(res);
    }

    // 4x3
    static int[] l = new int[]{3,0};
    static int[] r = new int[]{3,2};
    static char[][] keypad = {{'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'}};
    static public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        for (int num : numbers) {
            int jj = 0;
            int[] move = new int[l.length];
            p: for (int i = 0; i < keypad.length; i++) {
                for(int j = 0; j < keypad[i].length; j++){
                    if(keypad[i][j]-'0' == num){
                        jj = j;
                        move = new int[]{i,j};
                        break p;
                    }
                }
            }
            if(jj == 0) {
                answer.append("L");
                l = Arrays.copyOf(move, move.length);
            }else if(jj == 2){
                answer.append("R");
                r = Arrays.copyOf(move, move.length);;
            }else{
                int ldist = Math.abs(move[0]-l[0])+Math.abs(move[1]-l[1]);
                int rdist = Math.abs(move[0]-r[0])+Math.abs(move[1]-r[1]);
                if(ldist < rdist){
                    l = Arrays.copyOf(move, move.length);;
                    answer.append("L");
                }else if(ldist > rdist){
                    r = Arrays.copyOf(move, move.length);;
                    answer.append("R");
                }else{
                    if(hand.startsWith("r")){
                        r = Arrays.copyOf(move, move.length);;
                        answer.append("R");
                    }else{
                        l = Arrays.copyOf(move, move.length);;
                        answer.append("L");
                    }
                }
            }
        }
        return answer.toString();
    }
}
