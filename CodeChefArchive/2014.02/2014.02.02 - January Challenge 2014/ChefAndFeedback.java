package codechef;

import io.InputReader;
import io.OutputWriter;

public class ChefAndFeedback {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
		String s = in.next();
		if (s.contains("101")||s.contains("010")) {
			out.printLine("Good");
		}
		else {
			out.printLine("Bad");
		}
    }
}

