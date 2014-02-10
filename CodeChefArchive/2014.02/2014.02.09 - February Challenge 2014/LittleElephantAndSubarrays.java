package codechef;

import io.InputReader;
import io.OutputWriter;

public class LittleElephantAndSubarrays {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

		int N  = in.readInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = in.readInt();
		}
		int Q = in.readInt();
		for (int i = 0; i < Q; i++) {
			int K = in.readInt();
			out.printLine(getNumSubArray(A,K, N));
		}

	}

	private int getNumSubArray(int[] a, int k, int N) {
		int cnt = 0;
		int posR = 0;
		int add = 0;
		boolean kFound = false;
		for (int i = N-1; i >= 0; i--) {
			if (a[i] > k) {
				posR++;
			}
			else if (a[i] == k) {
				kFound = true;
				posR++;
				add = posR;
			}
			else if (a[i] < k) {
				posR = 0;
				kFound = false;
			}
			if (kFound) {
				cnt += add;
			}
		}
		return cnt;
	}
}

