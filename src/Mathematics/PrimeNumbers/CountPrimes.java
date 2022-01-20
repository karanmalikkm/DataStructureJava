/*
Q) Given an integer n, return the number of prime numbers that are strictly less than n.
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Input: n = 0
Output: 0

Input: n = 1
Output: 0

Constraints:
0 <= n <= 5 * 10^6

Ans:
Brute force way is to iterate every element before n and check if it has factors other than 1 and n
Better way is to use : Sieve_of_Eratosthenes
https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes

We start off with a table of n numbers. Let's look at the first number, 2. We know all multiples of 2 must not be
primes, so we mark them off as non-primes. Then we look at the next number, 3. Similarly, all multiples of 3 such
as 3 × 2 = 6, 3 × 3 = 9, ... must not be primes, so we mark them off as well. Now we look at the next number, 4,
which was already marked off.

4 is not a prime because it is divisible by 2, which means all multiples of 4 must also be divisible by 2 and were
already marked off. So we can skip 4 immediately and go to the next number, 5. Now, all multiples of 5 such as
5 × 2 = 10, 5 × 3 = 15, 5 × 4 = 20, 5 × 5 = 25, ... can be marked off. There is a slight optimization here,
we do not need to start from 5 × 2 = 10. Where should we start marking off?

In fact, we can mark off multiples of 5 starting at 5 × 5 = 25, because 5 × 2 = 10 was already marked off by
multiple of 2, similarly 5 × 3 = 15 was already marked off by multiple of 3. Therefore, if the current number is p,
we can always mark off multiples of p starting at p2, then in increments of p: p^2 + p, p^2 + 2p, ...

The Sieve of Eratosthenes uses an extra O(n) memory and its runtime complexity is O(n log log n).
 */
package Mathematics.PrimeNumbers;
import java.util.Scanner;
public class CountPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N:");
        int N = sc.nextInt();
        int count = countPrimesFunction(N);
        System.out.println("Number of prime numbers <"+N+" = "+count);
    }
    public static int countPrimesFunction(int N){
        //Create the boolean array and start by assuming all elements from 2 till n-1 are prime
        boolean[] isPrime = new boolean[N];
        for(int i=2; i<N; i++){
            isPrime[i] = true;
        }
        //Now we will individually mark numbers which are not prime and their multiples
        for(int i=2; i*i<N; i++){
            //Skip this loop if already marked false
            if(!isPrime[i]){
                continue;
            }
            //If it is not marked, lets mark staring from its square using increments of p: p^2 + p, p^2 + 2p, ...
            //We need to do this because any multiples of a number cannot be prime number
            for(int j=i*i;j<N;j+=i){
                isPrime[j]=false;
            }
        }
        //After this loop we have isPrime array with index belonging to number which has True if it is prime
        int count=0;
        for(int i=0; i<N; i++){
            if(isPrime[i]) count++;
        }
        return count;
    }
}
