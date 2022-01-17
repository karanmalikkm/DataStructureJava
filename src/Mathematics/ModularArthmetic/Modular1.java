/*
    Q) Given A & B, (A>B) find number of M values, such that A % M = B % M & M>1
    Sol:
    A % M = B % M
    A % M - B % M = 0
    (A % M - B % M) % M = 0 % M
    (A % M - B % M) % M = 0
    (A - B) % M = 0

    So we have to find all the factors of  (A - B) > 1
 */
package Mathematics.ModularArthmetic;
import java.util.Scanner;
public class Modular1 {
    public static void main(String[] args) {
        // write your code here
        int A, B;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter A: ");
        A = sc.nextInt();
        System.out.println("Enter B: ");
        B = sc.nextInt();
        int temp = A - B;
        int M = 0;
        //Next is the logic to find number of factors in optimized code
        for(int i=1; i<=(int)Math.sqrt(temp); i++){
            if(temp%i==0 && i*i!=temp){
                M += 2;
            }
            else{
                if(i*i==temp){
                    M++;
                }
            }
        }
        System.out.println("M = "+ (M-1)); //Removing 1 as the factor
    }
}
