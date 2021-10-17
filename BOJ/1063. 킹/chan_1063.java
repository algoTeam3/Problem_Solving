import java.io.BufferedReader;
import java.io.InputStreamReader;

public class chan_1063 {

    public static void main(String[] args) throws Exception {
        String locI = "87654321";
        String locJ = "ABCDEFGH";
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int kx, ky, rx, ry; // 킹의 위치, 돌의 위치;
        String[] input = br.readLine().split(" ");
        kx = input[0].charAt(0) - 65;
        ky = locI.indexOf(input[0].charAt(1));
        rx = input[1].charAt(0) - 65;
        ry = locI.indexOf(input[1].charAt(1));
        int N = Integer.parseInt(input[2]);

        for (int i = 0; i < N; i++) {
            char[] direction = br.readLine().toCharArray();
            int nkx = kx;
            int nky = ky;
            for (int j = 0; j < direction.length; j++) {
                int d = -1;
                switch (direction[j]) {
                    case 'R':
                        d = 0;
                        break;
                    case 'L':
                        d = 1;
                        break;
                    case 'B':
                        d = 2;
                        break;
                    case 'T':
                        d = 3;
                        break;
                }
                nkx += dx[d];
                nky += dy[d];
            }
            if (nkx < 0 || nky < 0 || nkx >= 8 || nky >= 8)
                continue;

            int nrx = rx;
            int nry = ry;
            if (nkx == nrx && nky == nry) {
                for (int j = 0; j < direction.length; j++) {
                    int d = -1;
                    switch (direction[j]) {
                        case 'R':
                            d = 0;
                            break;
                        case 'L':
                            d = 1;
                            break;
                        case 'B':
                            d = 2;
                            break;
                        case 'T':
                            d = 3;
                            break;
                    }
                    nrx += dx[d];
                    nry += dy[d];
                }
            }
            if (nrx < 0 || nry < 0 || nrx >= 8 || nry >= 8)
                continue;

            kx = nkx;
            ky = nky;
            rx = nrx;
            ry = nry;
        }
        System.out.print(locJ.charAt(kx));
        System.out.println(locI.charAt(ky));
        System.out.print(locJ.charAt(rx));
        System.out.println(locI.charAt(ry));
    }

}
