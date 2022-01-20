/*
Q) Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor)
of the remaining array is maximum. Find the maximum value of GCD.
Problem Constraints
2 <= N <= 10^5
1 <= A[i] <= 10^9

Input Format: First argument is integer array A
Output Format: Return an integer denoting the maximum value of GCD.

Example:
A = [12, 15, 18]
Output: 6
Explanation :
 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum value of gcd is 6.

Solution:
The Brute Force approach will be to delete every element and then compute GCD of remaining elements. Find max.
This approach will be too costly in terms of time complexity

Efficient approach here is to create a prefixGCD array and suffixGCD array
eg:
Array =     [   15  18  25  20  60  ]
prefixGCD=  [   15  3   1   1   1   ]
suffixGCD=  [   1   1   5   20  60  ]
So prefixGCD array will have GCD of elements in array before i
suffixGCD array will have GCD of elements in array after i

To compute gcd when array i is deleted, it is gcd(prefixGCD[i-1],suffixGCD[i+1]), find max of this in 1 pass only
 */
package Mathematics.GCD;
import java.util.Scanner;
public class DeleteOne {
    public static void main(String[] args) {
        //Take input in form of String
        //String 1 is space separated integers with first integer as length of array followed by as many array integers
        System.out.println("Input the space separated Array (first element is size of array):");
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] s = line1.split(" ");
        int N = Integer.parseInt(s[0]);
        int[] arr = new int[N];
        for(int i=0 ; i<N; i++){
            arr[i] = Integer.parseInt(s[i+1]);
        }

        int result = solve(arr);
        System.out.println("Max GCD is: "+result);

    }
    public static int solve(int[] A) {
        //Compute prefix gcd array
        int[] prefixGCD = new int[A.length];
        prefixGCD[0]=A[0];
        for(int i=1; i<A.length; i++){
            prefixGCD[i]=gcd(prefixGCD[i-1],A[i]);
        }

        //Compute suffix GCD array
        int[] suffixGCD = new int[A.length];
        suffixGCD[A.length-1]=A[A.length-1];
        for(int i=A.length-2;i>=0;i--){
            suffixGCD[i]=gcd(suffixGCD[i+1],A[i]);
        }

        int max=0;
        for(int i=0; i<A.length; i++){
            int g1, g2;
            if(i==0){
                g1=0;
            }
            else{
                g1=prefixGCD[i-1];
            }
            if(i==A.length-1){
                g2=0;
            }
            else{
                g2=suffixGCD[i+1];
            }
            int temp = gcd(g1,g2);
            max = Math.max(max, temp);
        }
        return max;

    }
    public static int gcd(int A, int B) {
        if(B==0){
            return A;
        }
        return gcd(B,A%B);
    }

}
