/*
Given 2 non negative integers A and B, find gcd(A, B)

GCD of 2 integers A and B is defined as the greatest integer g such that g is a divisor of both A and B.
Both A and B fit in a 32 bit signed integer.

We will use modular recursion logic
 */
package Mathematics.GCD;
import java.util.Scanner;
public class GcdFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter A:");
        int A = sc.nextInt();
        System.out.println("Enter B:");
        int B = sc.nextInt();
        int result = gcd(A,B);
        System.out.println("GCD is: "+result);
    }
    public static int gcd(int A, int B){
        if(B==0){
            return A;
        }
        return (gcd(B,A%B));
    }
}
