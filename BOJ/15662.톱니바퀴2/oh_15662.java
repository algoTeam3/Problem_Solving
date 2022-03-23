

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class oh_15662 {

    private static gear[] gears;
    private static int t;

    private static class gear {
        private ArrayList<Integer> unit;

        private gear() {
            unit = new ArrayList<>();
        }

        private void setStatus(int n) {
            unit.add(n);
        }

        private void turn(int n) {
            if (n == -1) {
                unit.add(unit.get(0));
                unit.remove(0);
            } else if (n == 1) {
                unit.add(0, unit.get(unit.size() - 1));
                unit.remove(unit.size() - 1);
            }
        }

        private int getStatus(int n) {
            return unit.get(n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        gears = new gear[t];
        StringTokenizer st;

        //톱니정보
        for (int i = 0; i < gears.length; i++) {
            gear temp = new gear();
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                temp.setStatus(str.charAt(j) - '0');
            }
            gears[i] = temp;
        }
        //톱니돌리기
        int turn = Integer.parseInt(br.readLine());
        for (int i = 0; i < turn; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            if(order!=0){
                left(order-1,-dir);
            }
            if(order< t -1){
                right(order+1,-dir);
            }
            gears[order].turn(dir);
        }
        //점수구하기
        int result = 0;
        for (int i = 0; i < gears.length; i++) {
            if (gears[i].getStatus(0) == 1) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void right(int order, int dir) {
        if (order >= t) return;
        if (gears[order-1].getStatus(2) == gears[order].getStatus(6)) return;
        right(order + 1, -dir);
        gears[order].turn(dir);
    }


    private static void left(int order, int dir) {
        if (order == -1) return;
        if (gears[order+1].getStatus(6) == gears[order].getStatus(2)) return;
        left(order - 1, -dir);
        gears[order].turn(dir);
    }
}
