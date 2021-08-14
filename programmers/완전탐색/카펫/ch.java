import java.util.Arrays;
import java.util.Scanner;

public class Carpet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] answer = new int[2];
        int brown = sc.nextInt();
        int yellow = sc.nextInt();
        answer = solution(brown, yellow);

        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown + yellow;

        for(int i = 1; i <= size; i++) {
            int y = i;  //세로
            int x = size / y;   //가로

            //가로는 세로보다 길거나 세로와 같다
            if( y > x ) continue;

            if((x - 2) * (y - 2) == yellow) {
                answer[0] = x;
                answer[1] = y;
                return answer;
            }
        }
        return answer;
    }
}

