/*
Q) Pubg
There are N players each with strength A[i]. when player i attack player j, player j strength reduces to
max(0, A[j]-A[i]). When a player's strength reaches zero, it loses the game and the game continues in the same manner
among other players until only 1 survivor remains.

Can you tell the minimum health last surviving person can have?

Problem Constraints
1 <= N <= 100000
1 <= A[i] <= 1000000

Input: Single integer array A
Output: Return a single integer denoting minimum health of last person.

Sol: Lets take some examples:

A = [6, 4]
Out = 2
Explanation: Given strength array A = [6, 4]
 Second player attack first player, A =  [2, 4]
 First player attack second player twice. [2, 0]

A = [2, 3, 4]
Out = 1
Explanation: Given strength array A = [2, 3, 4]
 First player attack third player twice. [2, 3, 0]
 First player attack second player. [2, 1, 0]
 Second player attack first player twice. [0, 1, 0]

So we can see that it is nothing but GCD of all elements of the array
 */
package Mathematics.GCD;
import java.util.Scanner;
public class Pubg {
    public static void main(String[] args) {
        //Take input in form of String
        //String 1 is space separated integers with first integer as length of array followed by as many array integers
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] s = line1.split(" ");
        int N = Integer.parseInt(s[0]);
        int[] arr = new int[N];
        for(int i=0 ; i<N; i++){
            arr[i] = Integer.parseInt(s[i+1]);
        }

        int result = solve(arr);
        System.out.println("Minimum Health of Last Person is: "+result);

    }
    public static int solve(int[] A) {
        int res = 0;
        for (int j : A) {
            res = gcd(res, j);
        }
        return res;
    }
    public static int gcd(int A, int B) {
        if(B==0){
            return A;
        }
        return gcd(B,A%B);
    }

}
