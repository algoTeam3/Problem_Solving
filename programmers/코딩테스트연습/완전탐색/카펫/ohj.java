package programmers;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class 카펫 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int yellow = 2;


        int brown = 10;

        int sum = brown + yellow;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= sum; i++) {
            if (sum % i == 0) {
                arr.add(i);
            }
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            int row = arr.get(i);
            int col = sum / row;
            if (row < col) continue;

            if (row - 2 < 0 && col - 2 < 0) {
                continue;
            } else if((row-2)*(col-2)==yellow) {
                System.out.print(row);
                System.out.print(col);

            }

        }
    }
}


