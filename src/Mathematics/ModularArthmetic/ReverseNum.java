/*
Problem Description
Given a number, return the reverse of that number.

Input format
One line of input containing an integer N, the number to be reversed.

Output format
Return the reversed number. Note that the number must start with (1-9) digits only unless it is a single digit number.

Sample Input 1
15

Sample Output 1
51

Constraints
0 <= N <= 1000000

Explanation
Reverse of 15 is 51.
 */
package Mathematics.ModularArthmetic;
import java.util.*;
public class ReverseNum {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int reverse = reverseNum(num);

        System.out.println(reverse);

    }

    // Implement this method
    static int reverseNum(int num) {
        int reverseValue = 0;
        while(num!=0){
            int remainder = num%10;
            reverseValue = reverseValue*10+remainder;
            num = num/10;
        }
        return reverseValue;
    }
}
