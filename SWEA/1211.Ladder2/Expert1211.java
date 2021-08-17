package exD4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Expert1211 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("algo/src/input/input1211.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;
        int count = 0;
        for (int test_case = 1; test_case <= T; test_case++) {
            int pos = 0;
            int test = sc.nextInt();

            //배열담기
            int[][] map = new int[100][100];
            for (int r = 0; r < map.length; r++) {
                for (int c = 0; c < map.length; c++) {
                    map[r][c] = sc.nextInt();

                }

            }
            //가로 줄 위치 찾기
            ArrayList<Integer> row = new ArrayList<>();

            for (int i = 0; i < map.length; i++) {
                if (map[0][i] == 1) {
                    row.add(i);
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < row.size(); i++) {
                int n = i;
                int fall = row.get(n);
                for (int j = 0; j < map.length;) {

                    if (map[j][fall] == 1) {
                        count++;
                    }


                    if (fall - 1 >= 0 && map[j][fall- 1] == 1) {

                        fall = row.get(--n);
                        count += row.get(n + 1) - row.get(n);
                        j++;
                        count++;
                    }else if (fall + 1 < 100 && map[j][fall + 1] == 1) {

                        fall = row.get(++n);
                        count += row.get(n) - row.get(n - 1);
                        j++;
                        count++;
                    }else{
                        j++;
                    }


                }

                if (count < min) {
                    min = count;
                    pos = row.get(i);
                }

                count = 0;
            }
            System.out.print("#" + test + " " + pos + "\n");
        }


    }
}
