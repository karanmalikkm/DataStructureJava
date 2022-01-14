/*
Q) Find the maximum submatrix sum from a given N*M matrix

Solution to this problem lies in reducing the time complexity using the Column prefix matrix and Kadane's Algo

 */
package AdvancedArrays.Matrix.Submatrix;
import java.util.Scanner;
public class MaxSubmatrixSum {
    public static void main(String[] args){
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

        //Step2: Calculate col wise prefix array
        int[][] prefixArr = new int[N][M];
        for(int j=0; j<M; j++){
            prefixArr[0][j]=arr[0][j];
        }
        for(int j=0 ; j<M; j++){
            for(int i=1; i<N; i++){
                prefixArr[i][j] = arr[i][j] + prefixArr[i-1][j];
            }
        }
        //Column Prefix matrix is now complete. We will print it.
        System.out.println("Below is the FINAL prefix matrix for input matrix:");
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(prefixArr[i][j]+"\t");
            }
            System.out.print("\n");
        }

        //Step 3: We will use above column prefix array for Kadane's Algorithm
        int maxAns = Integer.MIN_VALUE;
        for(int rowS=0; rowS<N; rowS++){
            for(int rowE=0; rowE<N; rowE++){
                int[] element = new int[M];
                for(int j=0; j<M; j++){
                    if(rowS==0){
                        element[j] = prefixArr[rowE][j];
                    }
                    else{
                        element[j] = prefixArr[rowE][j] - prefixArr[rowS-1][j];
                    }
                }
                //Now run Kadane's algo on this element array
                int sum = 0;
                int ans = 0;
                for(int i=0; i<M; i++){
                    sum = sum + element[i];
                    ans = Math.max(ans, sum);
                    if(sum<0){
                        sum = 0;
                    }
                }
                maxAns = Math.max(ans,maxAns);
            }
        }
        System.out.println(" The maximum submatrix sum is :"+maxAns);
    }
}
