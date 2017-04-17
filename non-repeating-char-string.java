
//First non-repeating character in a stream 
Given an input stream of n characters consisting only of small case alphabets the task is to find the first non repeating character each time a character is inserted to the stream.

Example

Flow in stream : a, a, b, c
a goes to stream : 1st non repeating element a (a)
a goes to stream : no non repeating element -1 (5, 15)
b goes to stream : 1st non repeating element is b (a, a, b)
c goes to stream : 1st non repeating element is b (a, a, b, c)

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N denoting the size of the stream. Then in the next line are x characters which are inserted to the stream.

Output:
For each test case in a new line print the first non repeating elements separated by spaces present in the stream at every instinct when a character is added to the stream, if no such element is present print -1.

Constraints:
1<=T<=200
1<=N<=500

Example:
Input:
2
4
a a b c
3
a a c 
Output:
a -1 b b
a -1 c
 

**For More Examples Use Expected Output**


import java.util.*;
import java.lang.*;
import java.io.*;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        //code

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // One by one run for all input test cases
        while (t > 0) {
            int N = sc.nextInt();
            // ArrayList<Character> input = new ArrayList<>();
            LinkedHashSet <String> unique = new LinkedHashSet <>();
            HashSet<String> repeat = new HashSet<>();
            String c = sc.next(".");
            System.out.print(c);
            unique.add(c);
            for (int i=1; i<N; i++){
                c = sc.next(".");
                if (unique.contains(c)){
                    unique.remove(c);
                    repeat.add(c);
                } else if (!repeat.contains(c)){
                    unique.add(c);
                }
                if (unique.isEmpty()){
                    System.out.print(" "+-1);
                } else {
                    System.out.print(" "+ unique.toArray()[0]);
                }
            }
            System.out.println();
            t--;
        }
    }
}


// C++ EXAMPLE 

#include <iostream>
#include<queue>
using namespace std;

int main() {
    
    int t;
    cin>>t;
    while(t--)
    {
        queue<char> q;
        int n;
        cin>>n;
        int a[123]={0};
        for(int i=0;i<n;i++)
        {
            char c;
            cin>>c;
            a[c]+=1;
            if(a[c]==1)q.push(c);
            int temp=0;
            while(!q.empty())
            {
                c=q.front();
                if(a[c]==1)
                {
                    cout<<c<<" ";
                    temp=1;
                    break;
                }
                else
                    q.pop();
            }
            if(temp==0)cout<<"-1 ";
        }
        cout<<endl;
    }
    return 0;
}
