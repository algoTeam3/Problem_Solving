package exD3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class jamoon {
    public static void main(String[] args) throws FileNotFoundException {
        //System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input1206.txt"));
        Scanner sc = new Scanner(System.in);
        int T=10;
        for(int test_case=1;test_case<=T;test_case++){
            int size=sc.nextInt();
            int[] arr = new int[size];
            //배열담기
            for(int i =0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            //검증
            int count =0;
            for(int z=2;z<arr.length-2;z++){
                if(arr[z]<arr[z-1]||arr[z]<arr[z+1]||arr[z]<arr[z+2]||arr[z]<arr[z-2]){
                    continue;
                }
                int c1= Math.min(arr[z]-arr[z-1],arr[z]-arr[z+1]);
                int c2= Math.min(arr[z]-arr[z-2],arr[z]-arr[z+2]);
                count+=Math.min(c1,c2);
            }
            System.out.printf("#%d %d",test_case,count);
            System.out.println();
        }
    }
}
