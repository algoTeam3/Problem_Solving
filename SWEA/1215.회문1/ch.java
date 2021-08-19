package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA_1215_회문1 {
    static char[][] map;
    static ArrayList<Character> al = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int len = Integer.parseInt(br.readLine());
            // 길이 1짜리를 찾으면
            if(len == 1) System.out.println("#" + t + " " + 64);
            // 값 입력
            map = new char[8][8];
            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                for (int j = 0; j < 8; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            int cnt = 0;
            // 가로 회문 찾기
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8 - len + 1; j++) {
                    al.clear();
                    for (int k = 0; k < len; k++) {
                        al.add(map[i][j + k]);
                    }
                    if(search()) cnt++;
                    else continue;
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8 - len + 1; j++) {
                    al.clear();
                    for (int k = 0; k < len; k++) {
                        al.add(map[j + k][i]);
                    }
                    if(search()) cnt++;
                    else continue;
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
    }

    private static boolean search() {
        for (int i = 0; i < al.size() / 2; i++) {
            if(al.get(i) != al.get((al.size()-1) - i)) return false;
        }
        return true;
    }
}
