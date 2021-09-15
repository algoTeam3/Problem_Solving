import java.io.*;
import java.util.StringTokenizer;

public class Expert1240 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1240.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int[][] map = new int[row][col];
            //배열담기
            for (int i = 0; i < row; i++) {
                String str = br.readLine();
                for (int j = 0; j < col; j++) {
                    map[i][j] = Character.getNumericValue(str.charAt(j));
                }
            }
            int[] code = new int[56];
            out:
            for (int i = 0; i < row; i++) {
                for (int j = col - 1; j >= 0; j--) {
                    if (map[i][j] == 1) {
                        for (int k = 0; k < 55; k++) {
                            code[55 - k] = map[i][j - k];
                        }
                        break out;
                    }
                }
            }
            //코드 해독하기
            int decode[] = new int[8];
            int n = 0;
            String num = "";
            int count =7;
            for (int i = 0; i < code.length; i++) {
                count--;
                num += code[i];
                if (count==0) {
                    switch (num) {
                        case "0001101":
                            decode[n] = 0;
                            n++;
                            break;
                        case "0011001":
                            decode[n] = 1;
                            n++;
                            break;
                        case "0010011":
                            decode[n] = 2;
                            n++;
                            break;
                        case "0111101":
                            decode[n] = 3;
                            n++;
                            break;
                        case "0100011":
                            decode[n] = 4;
                            n++;
                            break;
                        case "0110001":
                            decode[n] = 5;
                            n++;
                            break;
                        case "0101111":
                            decode[n] = 6;
                            n++;
                            break;
                        case "0111011":
                            decode[n] = 7;
                            n++;
                            break;
                        case "0110111":
                            decode[n] = 8;
                            n++;
                            break;
                        case "0001011":
                            decode[n] = 9;
                            n++;
                            break;
                    }
                    num = "";
                    count =7;
                }
            }
            //검증코드 판별
            int odd=0;
            int even = 0;
            for (int i = 0; i < decode.length-1; i++) {
                if(i%2==1){
                    odd+=decode[i];
                }else{
                    even+=decode[i];
                }
            }
            int answer = 0;
            int flag=(even*3)+odd+decode[decode.length-1];
            if(flag%10==0){
                for (int i : decode) {
                    answer +=i;
                }

            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}
