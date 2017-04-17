import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static int findEqualPoint(String brackets) {
		// find total number of  open and closing brackets
		int numOpen = 0;
		int numClosed = 0;

		for (char c: brackets.toCharArray()) {
			if (c == '(') {
				numOpen++;
			}
		}

		numClosed = brackets.length() - numOpen;

		// Now find K
		int openLeft = 0;
		int closedRight = numClosed;

		int i = 0;
		for (i = 0; i < brackets.length(); i++) {
			if (openLeft == closedRight) {
				break;
			}
			char c = brackets.charAt(i);
			if (c == '(') {
				openLeft++;
			}
			else {
				closedRight--;
			}
		}

		return i;
	}
    
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		for (int i = 0; i < n; i++) {
		    System.out.println(findEqualPoint(s.next()));
		}
	}
}
