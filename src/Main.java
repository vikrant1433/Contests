import java.io.*;
import java.util.InputMismatchException;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Vikrant Singh
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		MakeHimHappy solver = new MakeHimHappy();
		solver.solve(1, in, out);
		out.close();
	}
}

class MakeHimHappy {
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

class InputReader {

	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public static boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			}
			catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

}

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(outputStream);
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	public void printLine(Object... objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}

}

