import java.util.*;

class ch {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        for(int n : numbers) {
            int L_dis = 0;
            int R_dis = 0;
            // 1, 4, 7 번호일 때
            if(n == 1 || n == 4 || n == 7) {
                sb.append("L");
                left = n;
                // 3, 6, 9 번호일 때
            }else if(n == 3 || n == 6 || n == 9) {
                sb.append("R");
                right = n;
                // 가운데 열 숫자일 때
            }else {
                // 0 번은 11로 처리
                if(n==0) n += 11;
                // 왼쪽과 오른쪽 거리 계산
                L_dis = (Math.abs(n - left)) / 3 + (Math.abs(n - left)) % 3;
                R_dis = (Math.abs(right - n)) / 3 + (Math.abs(right - n)) % 3;
                // 거리 비교
                if(L_dis == R_dis) {
                    if(hand.equals("right")) {
                        sb.append("R");
                        right = n;
                    }else {
                        sb.append("L");
                        left = n;
                    }
                }else if(L_dis > R_dis) {
                    sb.append("R");
                    right = n;
                }else {
                    sb.append("L");
                    left = n;
                }
            }
        }
        return sb.toString();
    }
}