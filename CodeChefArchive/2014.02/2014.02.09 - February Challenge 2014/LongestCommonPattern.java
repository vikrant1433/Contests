package codechef;

import io.InputReader;
import io.OutputWriter;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestCommonPattern {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
		String A = in.readString();
		String B = in.readString();
		int arrA[][] = new int[3][26];
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			if (Character.isDigit(c)) {
				arrA[2][c-'0']++;
			}
			else if (Character.isUpperCase(c)) {
				arrA[1][c - 'A']++;
			} else {
				arrA[0][c-'a']++;
			}
		}
		int cnt=0;
		for (int i = 0; i < B.length(); i++) {
			char c = B.charAt(i);
			if (Character.isDigit(c) && arrA[2][c-'0'] > 0) {
				cnt++;
				arrA[2][c-'0']--;
			}
			else if (Character.isUpperCase(c) && arrA[1][c - 'A'] > 0) {
				cnt++;
				arrA[1][c - 'A']--;
			} else if (Character.isLowerCase(c) && arrA[0][c-'a'] > 0){
				cnt++;
				arrA[0][c-'a']--;
			}
		}
		out.printLine(cnt);

	}
}

