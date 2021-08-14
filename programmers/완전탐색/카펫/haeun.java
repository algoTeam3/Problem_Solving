import java.util.Arrays;
import java.util.Scanner;

public class Programmers_lv2_카펫 {
	private static int[] answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int brown = sc.nextInt();
		int yellow = sc.nextInt();
		solution(brown, yellow);
		// 출력
		System.out.println(Arrays.toString(answer));
		sc.close();
	}
	
    public static int[] solution(int brown, int yellow) {
        int width = 0;
        int height = 0;
        int sum = brown + yellow;
        
        // 가로*세로 = brown + yellow
        for (int i = 3; i < sum / 2; i++) {
            if (sum % i == 0) {
                width = sum / i;
                height = i;
                // 가로*2 + 세로*2 - 4 = brown
                if (width*2 + height*2 - 4 == brown) break;
            }
        }
        answer = new int[]{width, height};
        return answer;
    }
}
