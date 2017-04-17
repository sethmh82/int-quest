//EXAMPLE 1

import java.util.*;

public class Main {
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int t = in.nextInt(), n, m, x, i;
		String str;
		while (t-- > 0) {
			n = in.nextInt();
			m = in.nextInt();
			x = in.nextInt();
			int arr[] = new int[n];
			int arr2[] = new int[m];
			for (i = 0; i < n; i++)
				arr[i] = in.nextInt();
			for (i = 0; i < m; i++)
				arr2[i] = in.nextInt();
			Arrays.sort(arr);
			Arrays.sort(arr2);
			str = "";
			for (i = 0; i < n; i++) {
				int ind = Arrays.binarySearch(arr2, (x - arr[i]));
				if (ind >= 0 && ind < m) {
					str += (" " + arr[i] + " " + arr2[ind] + ",");
				}
			}
			if (str.equals(""))
				System.out.println(-1);
			else
				System.out.println(str.substring(1, str.length() - 1));

		}

	}
}


//EXAMPLE 3

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) 
	{
	    class Result
	    {
	        int a;
	        int b;
	    }
	    class CustomComparator implements Comparator<Result> {
            @Override
            public int compare(Result o1, Result o2) {
                Integer a1 = new Integer(o1.a);
                Integer a2 = new Integer(o2.a);
                int res = a1.compareTo(a2);
                if(res == 0)
                {
                    Integer b1 = new Integer(o1.b);
                    Integer b2 = new Integer(o2.b);
                    return b1.compareTo(b2);
                }
                return res;
            }
        }
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int x = sc.nextInt();
		    int[] A = new int[n];
		    int[] B = new int[m];
		    for(int i = 0; i < n; i++)
		        A[i] = sc.nextInt();
		    for(int i = 0; i < m; i++)
		        B[i] = sc.nextInt();
		    
		    HashSet<Integer> l = new HashSet<Integer>();
		    ArrayList<Result> result = new ArrayList<Result>();
	        for(int i = 0; i < m; i++)
	        {
	            l.add(B[i]*-1);
	        }
	        
	        for(int i = 0; i < n; i++)
	        {
	            if(l.contains(A[i]-x))
	            {
	                Result tmp = new Result();
	                tmp.a = A[i];
	                tmp.b = (A[i]-x)*-1;
	                result.add(tmp);
	            }
	        }
	        // result
	        Collections.sort(result, new CustomComparator());
		    if(result.size() == 0)
		        System.out.println(-1);
		    else
		    {
		        StringBuilder res = new StringBuilder();
		        for(int i=0; i < result.size();i++)
		        {
		            if(res.length() != 0)
		            {
		                res.append(", ");
		            }
		            res.append(result.get(i).a+" "+result.get(i).b);
		        }
		        System.out.println(res.toString());
		    }
		}
	}
}


//EXAMPLE 2

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

//DONE IN PYTHON

t=int(input())
while(t>0):
    t-=1
    n,m,x=input().split()
    n,m,x=int(n),int(m),int(x)
    a=[]
    b=[]
    for i in input().split():
        a.append(int(i))
    for i in input().split():
        b.append(int(i))
    ans=[]
    for i in range(n):
        for j in range(m):
            if(a[i]+b[j]==x):
                ans.append((a[i],b[j]))
    ans.sort()
    le=len(ans)
    if(le==0):
        print(-1)
    else:
        for i in range(le-1):
            print(ans[i][0],ans[i][1],end=', ')
        print(ans[le-1][0],ans[le-1][1])
        




import java.util.Collections; 
import java.util.HashMap; 
import java.util.Iterator; 
import java.util.Map; 
import java.util.Set;

public class HashMapSynchronizationDemo{

		    public static void main(String args[]) {

	        Map<String, String> currencies = new HashMap<String, String>();

				currencies.put("USA", "USD"); 
				currencies.put("England", "GBP"); 
				currencies.put("Canada", "CAD"); 
				currencies.put("HongKong", "HKD"); 
				currencies.put("Australia", "AUD");

	        currencies = Collections.synchronizedMap(currencies);
	        Set<String> keySet = currencies.keySet();  

	        synchronized(currencies) {  
				Iterator<String> itr = keySet.iterator();
	            while (itr.hasNext()){
						System.out.println(itr.next()); 
			} 
		} 
	} 
} 

Output 
USA 
Canada 
HongKong 
England 
Australia
