package codechef;

import io.InputReader;
import io.OutputWriter;

public class MakeHimHappy {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		int first, second;
		int ans = Integer.MAX_VALUE;
		int N = in.readInt();
		int K = in.readInt();
		int A[] = new int[1000000 + 1];
		for (int i = 1; i <= N; i++) {
			first = in.readInt();
			second = K - first;
			if (second <= 0)
				continue;
			if (A[first] != 0) {
				A[first] = Math.min(A[first], Math.min(i, N - i + 1));
			} else {
				A[first] = Math.min(i, N - i + 1);
			}
			if (A[second] != 0 && first != second) {
				ans = Math.min(ans, Math.max(A[first], A[second]));
			}
		}
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		out.printLine(ans);

	}
}

