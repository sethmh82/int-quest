import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
        while (T > 0) {
    	    int n = sc.nextInt();
    	    int m = sc.nextInt();
    	    int x = sc.nextInt();
    	    
    	    int[] A = new int[n];
    	    int[] B = new int[m];
    	    for (int i = 0; i < n; i++) {
    	        A[i] = sc.nextInt();
    	    }
    	    for (int i = 0; i < m; i++) {
    	        B[i] = sc.nextInt();
    	    }
    	    findSum(A, B, x);
    	    T--;
    	}
	}
	private static void findSum(int[] A, int[] B, int x) {
	    Arrays.sort(A);
	    // Arrays.sort(B);
	    
	    HashSet<Integer> hash = new HashSet<>();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < B.length; i++) {
	        hash.add(B[i]);
	    }
	    for (int i = 0; i < A.length; i++) {
	        if (hash.contains(x - A[i])) {
	            sb.append(A[i] + " ");
	            sb.append((x - A[i]) + ", ");
	        }
	    }
	    if (sb.length() == 0) {
	        System.out.println(-1);
	    } else {
	        sb.setLength(sb.length() - 2);
	        System.out.println(sb.toString());
	    }
	}
}
