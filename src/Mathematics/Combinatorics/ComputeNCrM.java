package Mathematics.Combinatorics;

import java.util.Scanner;

public class ComputeNCrM {
    public static void main(String[] args) {
        System.out.println("Enter N: ");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        System.out.println("Enter r: ");
        int B = sc.nextInt();
        System.out.println("Enter M:");
        int p = sc.nextInt();
        int answer = solve(A, B, p);
        System.out.println("Result nCr%M = " + answer);
    }
    static int M;
    static int solve(int A, int B, int C) {
        M=C;
        int[][] mat = new int[A+1][B+1];
        for(int i=0; i<=A; i++){
            mat[i][0] = 1;
        }
        for(int j=1; j<=B; j++){
            mat[0][j] = 0;
        }
        for(int i=1; i<=A; i++){
            for(int j=1; j<=B; j++){
                long temp;
                temp = mat[i-1][j]+mat[i-1][j-1];
                mat[i][j] = (int)mod(temp);
            }
        }
        return mat[A][B];
    }
    static long mod(long x){
        return ((x%M)+M)%M;
    }
}
