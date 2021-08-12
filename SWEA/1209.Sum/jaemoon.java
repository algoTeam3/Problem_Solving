package exD3;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expert1209 {
    public static void main(String[] args) throws FileNotFoundException {
        //System.setIn(new FileInputStream("algo/src/input/input1209.txt"));

        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case<=10; test_case++){
            int N =sc.nextInt();
            int[][] arr = new int[100][100];
            for(int r=0;r<arr.length;r++){
                for(int c=0;c<arr.length;c++){
                    arr[r][c]=sc.nextInt();
                }
            }
            int max = Integer.MIN_VALUE;
            int amount =0;
            //열 세기
            for(int r=0;r<arr.length;r++){
                    amount =0;
                for(int c=0;c<arr.length;c++){
                    amount += arr[r][c];
                }
                max= Math.max(max,amount);
            }
            // 행세기
            for(int c =0;c<arr.length;c++){
                    amount =0;
                for(int r=0;r<arr.length;r++){
                    amount += arr[r][c];
                }
                max= Math.max(max,amount);
            }
            //대각선 세기
            for(int r = 0;r<arr.length;r++){
                amount=0;
                for(int c=0;c<arr.length;c++){
                    if(r==c){
                        amount+=arr[r][c];
                    }
                }
                max=Math.max(max,amount);
            }
            System.out.print("#"+test_case+" "+max+"\n");
        }
    }
}
