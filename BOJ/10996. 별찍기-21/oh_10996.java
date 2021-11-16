

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class oh_10996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();


        int num = Integer.parseInt(br.readLine());
            for (int i = 0; i < num/2; i++) {
                sb1.append("* ");
                sb2.append("* ");
            }
        if(num%2!=0) {
            sb1.append("*");
        }


        for (int i = 0; i < num; i++) {
            System.out.println(sb1);
            System.out.println(" "+sb2);
        }
    }
}
