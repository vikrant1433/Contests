package topcoder;

import java.util.Arrays;

public class EllysSubstringSorter {
    public String getMin(String S, int L) {
		char [] carr = S.toCharArray();
		Arrays.sort(carr,0,L);
		char c = S.charAt(0);
		int i=0;
		while (i+L < S.length() && c == carr[i])  {
			i++;
			Arrays.sort(carr,i,i+L);
			c = S.charAt(i);
		}
		char [] arr = S.toCharArray();
		Arrays.sort(arr,i,i+L);
		return String.valueOf(arr);
    }
}
