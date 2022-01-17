/*
Q) Implement pow(x, n) % d.
In other words, given x, n and d,
find (x^n % d)
Note that remainders on division cannot be negative. In other words, make sure the answer you return is non negative.
 */
package Mathematics.ModularArthmetic;
import java.util.Scanner;
public class Power {
    public static void main(String[] args) {
        //Take input in form of String
        //String 1 is space separated integers with
        // first integer = x, secomd integer = n, third integer = d
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] s = line1.split(" ");
        int x = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);
        int ans = pow(x,n,d);
        System.out.println("Value of ("+x+" ^ "+n+") %"+d+" = "+ans);
    }
    static int M;
    public static int pow(int A, int B, int C){
        M = C;
        if(A==0 && B>0){
            return 1;
        }
        if(A==0){
            return 0;
        }
        return (int)modPow(A,B);
    }
    static long modPow(int x, int y){
        if(y==0){
            return 1;
        }
        if(y==1){
            return x;
        }
        long result = 1;
        while(y>=1){
            if(y%2==1){
                result = multiply(result,x);
            }
            x = (int)multiply(x,x);
            y /= 2;
        }
        return result;
    }
    static long multiply(long x, long y){
        return mod(mod(x) * mod(y));
    }
    static long mod(long x){
        return ((x%M)+M)%M;
    }
}
