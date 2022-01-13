//Q) - Given a matrix of size N*M, calculate sum of all submatrix sum
/*
Solution: We will work this in part using contribution technique
eg: Consider this below matrix (indexes shown)
|       0   1   2   3   4   5
|   0   v   v   v   -   -   -
|   1   v   v   v   -   -   -
|   2   v   v   vX  X   X   X
|   3   -   -   X   X   X   X
|   4   -   -   X   X   X   X
If we consider (2,2), we will calculate in how many submatrix will this come in.
Case 1- if (2,2) becomes submatrix bottom right, top left can be any one from 0,0 till 2,2 represented by v
        there are 9 such possibilities
Case 2- if (2,2) becomes submatrix top left, bottom right can be any one from (2,2) till (4,5) represented by X
        there are 12 such possibilities

So we can say that (2,2) will appear in 9*12 submatrices in total.
Generalizing this: (i,j) will appear in
Case 1: (i-0+1)*(j-0+1) times
Case 2: (N-1-i+1)*(M-1-j+1) times
Total for(i,j) -> (i+1)(j+1)(N-i)(M-j) times

Pseudo Code for Sum:
Sum = 0
i=0->N
j=0->M
sum = sum + A[i][j]*((i+1)(j+1)(N-i)(M-j))

 */
package AdvancedArrays.Matrix.Submatrix;
import java.util.*;

public class SubMatrixSum {

    public static void main(String[] args) {
	// write your code here
        //Step 1: Input the matrix
        int N, M;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows in matrix:");
        N = sc.nextInt();
        System.out.println("Enter the number of columns in matrix:");
        M = sc.nextInt();
        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++){
            System.out.println("Enter matrix values in row "+(i+1)+":");
            for(int j=0;j<M;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(" ");

        //Step 2: Calculate sum as per logic above
        int sum = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sum = sum + arr[i][j]*((i+1)*(j+1)*(N-i)*(M-j));
            }
        }
        System.out.println("Sum of all submatrix = "+sum);
    }
}
