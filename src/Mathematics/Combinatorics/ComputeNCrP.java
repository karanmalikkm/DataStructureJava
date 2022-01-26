package Mathematics.Combinatorics;

import java.util.Scanner;

public class ComputeNCrP {
    public static void main(String[] args) {
        System.out.println("Enter N: ");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        System.out.println("Enter r: ");
        int B = sc.nextInt();
        System.out.println("Enter P:");
        int p = sc.nextInt();
        int answer = solve(A, B, p);
        System.out.println("Result = "+answer);
    }
    static int M;
    public static int solve(int A, int B, int C) {
        M = C;
        long t1, t2, t3, t4;
        t1 = factorial(A);
        t2 = factorial(A-B);
        t3 = factorial(B);
        t4 = (t1*pow(t2,C-2))%M;
        t4 = (t4*pow(t3,C-2))%M;
        return (int)t4;
    }
    static int factorial(int A){
        long result=1;
        for(int i=1; i<=A; i++){
            result = (result*i)%M;
        }
        return (int)result;
    }
    static int pow(long A, int B){
        if(A==0 && B>0){
            return 1;
        }
        if(A==0){
            return 0;
        }
        return (int)modPow(A,B);
    }
    static long modPow(long x, long y){
        if(y==0){
            return 1;
        }
        if(y==1){
            return x;
        }
        long result = 1;
        while(y>=1){
            if(y%2==1){
                result = (result*x)%M;
            }
            x = (x*x)%M;
            y /= 2;
        }
        return result;
    }

}
