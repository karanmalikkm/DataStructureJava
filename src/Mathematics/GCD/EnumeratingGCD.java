/*
Q) You are given a number A and a number B. Greatest Common Divisor (GCD) of all numbers between A and B inclusive
is taken (GCD(A, A+1, A+2 … B)).
As this problem looks a bit easy, it is given that numbers A and B can be in the range of 10^100.

You have to return the value of GCD found.

Greatest common divisor of 2 numbers A and B is the largest number D that divides both A and B perfectly.

Problem Constraints:
1 <= A <= B <= 10^100

Solution:
There can be following cases:
Case1: if A==B, GCD is the number itself
Case2: GCD of N natural numbers = 1

 */
package Mathematics.GCD;
import java.util.Scanner;
public class EnumeratingGCD {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter A: ");
        String A = sc.nextLine();
        System.out.println("Enter B: ");
        String B = sc.nextLine();
        if(A.equals(B)){
            System.out.println("GCD of all numbers between A and B is: "+ A);
        }
        else{
            System.out.println("GCD of all numbers between A and B is: 1");
        }
    }
}
