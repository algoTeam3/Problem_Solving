import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1. I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]
 *
 * 2. D(삭제) x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.[ ex) D 4 4 ]
 *
 * 3. A(추가) y, s : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다. s는 덧붙일 숫자들이다. [ ex) A 2 421257 796813 ]
 *
 * 첫 번째 줄 : 원본 암호문의 길이 N ( 2000 ≤ N ≤ 4000 의 정수)
 * <p>
 * 두 번째 줄 : 원본 암호문
 * <p>
 * 세 번째 줄 : 명령어의 개수 ( 250 ≤ N ≤ 500 의 정수)
 * <p>
 * 네 번째 줄 : 명령어
 */

public class Expert1230 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1230.txt"));

        Scanner sc = new Scanner(System.in);

        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int length = sc.nextInt();
            ArrayList<Integer> integers = new ArrayList<>();
            //배열담기
            for (int i = 0; i < length; i++) {
                integers.add(sc.nextInt());
            }
            //명령하기
            int commend = sc.nextInt();
            for (int i = 0; i < commend; i++) {
                switch (sc.next().charAt(0)) {
                    case 'I':
                        int x1 = sc.nextInt();
                        int y1 = sc.nextInt();
                        for (int j = 0; j < y1; j++) {
                            integers.add(x1++,sc.nextInt());

                        }
                        break;
                    case 'D':
                        int x2= sc.nextInt();
                        int y2= sc.nextInt();
                        for (int j = 0; j < y2; j++) {
                            integers.remove(x2);
                        }
                        break;
                    case 'A':
                        int y3= sc.nextInt();

                        for (int j = 0; j < y3; j++) {
                            integers.add(sc.nextInt());
                        }
                }
            }
            System.out.printf("#%d ",test_case);
            for (int i = 0; i < 10; i++) {
                System.out.printf("%d ",integers.get(i));
            }
            System.out.println();
        }

    }
}
