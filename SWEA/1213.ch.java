package SWEA;

import java.util.Scanner;

public class SWEA_1213_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10 ; t++) {
            Integer.parseInt(sc.nextLine());    // 테스트케이스 번호
            String findstr = sc.nextLine();     // 찾고자 하는 문자열
            String str = sc.nextLine();         // 제공된 문자열
            int cnt = 0;                        // 문자열 포함 개수를 세기 위한 카운트

            while(true) {
                int idx = str.indexOf(findstr); // 해당 index에 필요한 문자열이 있으면 해당 index 대입
                if(idx == -1) break;            // 필요한 문자열이 없으면 -1이 출력되므로 반복문 탈출
                cnt++;
                str = str.substring(idx+findstr.length());  // 문자열이 포함된 위치까지 자르기
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
}
