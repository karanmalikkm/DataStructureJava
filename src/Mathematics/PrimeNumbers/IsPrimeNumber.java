/*
Q) Check if given number is Prime number
Ans:
Prime Number: a whole number greater than 1 that cannot be exactly divided by any whole number other than itself
and 1 (e.g. 2, 3, 5, 7, 11).

So to check this one way is to iterate from 2 till that number-1 and see if % remainder is 0. If divisible by any,
it is not prime.
To optimize, one way is to heck only till N/2
This can be further optimized to check till sqrt(N) - we will use this logic
Pseudo Code:
i=2; i<sqrt(N); i++)
if(N%i)==0 -> not prime and return
out of loop -> prime and return

Note: since squareroot is expensive operation, we can also check i*i<n => same as i<sqrt(n)
 */
package Mathematics.PrimeNumbers;

import java.util.Scanner;

public class IsPrimeNumber {
    public static void main(String[] args) {
        System.out.println("Enter N: ");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean check = isPrime(N);
        System.out.println(!check ? "It is not a prime number" : "It is a prime number");
    }
    public static boolean isPrime(int N){
        boolean check=true;
        for(int i=2; i*i<N; i++){
            if(N%i==0){
                check = false;
                break;
            }
        }
        if(N==0 || N==1){
            check = false;
        }
        return check;
    }
}
