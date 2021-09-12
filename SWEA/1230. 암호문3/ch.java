package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1. I(삽입) x, y, s : 앞에서부터 x의 위치
 * 바로 다음에 y개의 숫자를 삽입한다. s는
 * 덧붙일 숫자들이다
 * D(삭제) x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다
 * A(추가) y, s : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다. s는 덧붙일 숫자들이다
 */
public class SWEA_D3_1230_암호문3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= null;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> al = new ArrayList<>();

        for (int t = 1; t <= 10; t++) {
            //StringBuilder, ArrayList 초기화
            sb.setLength(0);
            al.clear();
            // 원본 암호문 길이
            int len = Integer.parseInt(br.readLine());
            // 원본 암호문 길이만큼 배열 선언
            // 원본 암호문 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= len; i++) {
                al.add(Integer.parseInt(st.nextToken()));
            }
            int orderlen = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < orderlen; i++) {
                String input = st.nextToken();
                if (input.equals("I")) {
                    // x의 위치 바로 다음에  y 삽입
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        if (x + j >= len) {
                            st.nextToken(); // 암호문 길이를 넘어가면 다음 명령어 만나기 전까지 비움
                            continue;
                        }
                        al.add(x + j, Integer.parseInt(st.nextToken()));    // 해당 인덱스 위치에 삽입
                    }
                }else if (input.equals("D")) {
                    // x의 위치 바로 다음부터 y개 삭제
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < y; j++){
                        al.remove(x);
                    }
                }else if (input.equals("A")){
                    // y 개의 숫자를 맨 뒤에 추가
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        al.add(Integer.parseInt(st.nextToken()));
                    }
                }
            }
            // 처음 10개 숫자 출력
            for (int i = 0; i < 10; i++) {
                sb.append(al.get(i) + " ");
            }
            sb.append("\n");
            System.out.print("#" + t + " " + sb);
        }
    }
}
