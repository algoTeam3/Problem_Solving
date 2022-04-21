import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class chan {

	static class Operation implements Comparable<Operation>{
		int num;
		int freq;
		public Operation(int num, int freq) {
			this.num = num;
			this.freq = freq;
		}
		public int compareTo(Operation o) {
			if (o.freq == this.freq) return this.num - o.num;
			return this.freq - o.freq;
		}
	}
	
	static int maxRowNum, maxColNum;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[100][100];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while (time <= 100) {
			
			if (arr[r - 1][c - 1] == k) break;

			// R연산인지 C연산인지
			whichOperation();
			
			if (maxRowNum >= maxColNum) {	// R연산
				rOperation();
			} else {	// C연산
				cOperation();
			}
			
			time++;
			
		}
		
		
		if (time != 101) System.out.println(time);
		else System.out.println(-1);
		
	}
	
	private static void cOperation() {
		for (int i = 0; i < arr.length; i++) {
			
			int[] freqArr = new int[101];
			ArrayList<Operation> list = new ArrayList<>();
			
			for (int j = 0; j < arr[i].length; j++) {
				// 나온 빈도 수 체크
				freqArr[arr[j][i]]++;
			}
			
			for (int k = 1; k < freqArr.length; k++) {
				if (freqArr[k] != 0) {
					list.add(new Operation(k, freqArr[k]));
				}
			}
			
			Collections.sort(list);
			
			for (int j = 0; j < arr[0].length; j++) {
				arr[j][i] = 0;
			}
			
			int idx = 0;
			for (int k = 0; k < list.size(); k++) {
				arr[idx++][i] = list.get(k).num;
				arr[idx++][i] = list.get(k).freq;
			}
		}		
	}

	private static void rOperation() {
		
		for (int i = 0; i < arr.length; i++) {
			
			int[] freqArr = new int[101];
			ArrayList<Operation> list = new ArrayList<>();
			
			for (int j = 0; j < arr[i].length; j++) {
				// 나온 빈도 수 체크
				freqArr[arr[i][j]]++;
			}
			
			for (int k = 1; k < freqArr.length; k++) {
				if (freqArr[k] != 0) {
					list.add(new Operation(k, freqArr[k]));
				}
			}
			
			Collections.sort(list);
			
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = 0;
			}
			
			int idx = 0;
			for (int k = 0; k < list.size(); k++) {
				arr[i][idx++] = list.get(k).num;
				arr[i][idx++] = list.get(k).freq;
			}
		}
		
	}

	private static void whichOperation() {
		
		// 최대 열의 개수
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					maxColNum = maxColNum > j ? maxColNum : j;
					break;
				}
			}
		}
		
		// 최대 행의 개수
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[j][i] == 0) {
					maxRowNum = maxRowNum > j ? maxRowNum : j;
					break;
				}
			}
		}
	}

}
