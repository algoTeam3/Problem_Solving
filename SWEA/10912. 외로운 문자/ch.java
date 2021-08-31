package SWEA;

import java.util.*;

public class SWEA_D3_10912_외로운문자 {
    static ArrayList<Character> al = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 1; t <= T; t++) {
            String ans = "";
            String str = sc.nextLine();
            int[] arr = new int[26];    // 소문자 개수 26개
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    char ch = (char)(i + 'a');
                    ans += ch;
                }
            }

            if (ans == "") {
                System.out.println("#" + t + " " + "Good");
            }
            else {
                System.out.println("#" + t + " " + ans);
            }

        }
    }
}
