/*
 Q) Create a prefix matrix of the input matrix
 Ans)
 Step 1: Take a matrix:
 a0  b0  c0
 a1  b1  c1
 a2  b2  c2

 Step2: Apply prefix sum on all rows
 a0   a0+b0   a0+b0+c0
 a1   a1+b1   a1+b1+c1
 a2   a2+b2   a2+b2+c2

 Step3: Apply prefix sum on all cols
 a0         a0+b0               a0+b0+c0
 a0+a1      a0+b0+a1+b1         a0+b0+c0+a1+b1+c1
 a0+a1+a2   a0+b0+a1+b1+a2+b2   a0+b0+c0+a1+b1+c1+a2+b2+c2

 Above is the 2D prefix sum matrix for input matrix
 */
package AdvancedArrays.Matrix.PrefixMatrix;
import java.util.*;
public class PrefixSumMatrix {
    public static void main(String[] args) {
        // write your code here

        //Step 1: Input Matrix
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
        System.out.print("\n");

        System.out.println("Input matrix:");
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.print("\n");
        }


        int[][] prefixArr = new int[N][M];

        //Step2: Calculate prefix array in rows
        prefixArr[0][0] = arr[0][0];
        //Step 2a) Prefill 0th col
        for(int i=1; i<N; i++){
            prefixArr[i][0] = arr[i][0];
        }
        //Step 2b) Compute remaining array
        for(int i=0; i<N; i++){
            for(int j=1; j<M; j++){
                prefixArr[i][j] = arr[i][j] + prefixArr[i][j-1];
            }
        }

        System.out.println("Below is the row wise matrix for input matrix:");
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(prefixArr[i][j]+"\t");
            }
            System.out.print("\n");
        }

        //Step 3: Calculate prefix array in cols
        //Note: We don't need to prefill 0th row as it is already filled in step 2,
        //      See it in example above
        for(int j=0 ; j<M; j++){
            for(int i=1; i<N; i++){
                prefixArr[i][j] = prefixArr[i][j] + prefixArr[i-1][j];
            }
        }

        //Prefix matrix is now complete. We will print it.
        System.out.println("Below is the FINAL prefix matrix for input matrix:");
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(prefixArr[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }
}
