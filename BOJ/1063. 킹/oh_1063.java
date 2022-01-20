


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ1063
 * @date : 2022-01-20
 * @language : JAVA
 * @classification : simulation
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_1063 {
    static String kingpos;
    static String dolpos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        kingpos = st.nextToken();
        dolpos = st.nextToken();
        int move = Integer.parseInt(st.nextToken());

        for (int i = 0; i < move; i++) {
            String dir = br.readLine();
            int row = 0;
            int col = 0;

            if (dir.equals("R")) {
                row = 1;
            } else if (dir.equals("L")) {
                row = -1;
            } else if (dir.equals("B")) {
                col = -1;
            } else if (dir.equals("T")) {
                col = 1;
            } else if (dir.equals("RT")) {
                row = 1;
                col = 1;
            } else if (dir.equals("LT")) {
                row = -1;
                col = 1;
            } else if (dir.equals("RB")) {
                row = 1;
                col = -1;
            } else if (dir.equals("LB")) {
                row = -1;
                col = -1;
            }
            check(row, col);
        }


        System.out.println(kingpos);
        System.out.println(dolpos);

    }

    private static void check(int row, int col) {
        char kingRow = (char)((int)kingpos.charAt(0)+row);
        char kingCol = (char)((int)kingpos.charAt(1)+col);
        if (kingRow < 'A' || kingRow > 'H' || kingCol < '1' || kingCol > '8') {
            return;
        }
        String newKingpos ="";
        newKingpos += kingRow;
        newKingpos += kingCol;
        
        //돌이 있는지확인
        if(dolpos.equals(newKingpos)){
           Checkdol(newKingpos,row,col);
        }else{
            kingpos = newKingpos;
        }
    }

    private static void Checkdol(String newKingpos,int row, int col) {
        char dolRow = (char)((int)dolpos.charAt(0)+row);
        char dolCol = (char)((int)dolpos.charAt(1)+col);
        if(dolRow < 'A' || dolRow > 'H' || dolCol < '1' || dolCol > '8'){
            return;
        }
        String newdolpos = "";
        newdolpos += dolRow;
        newdolpos += dolCol;

        kingpos = newKingpos;
        dolpos = newdolpos;
    }
}
