/*
Q) Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space
Note: Lets say N = size of the array. Then, following holds true :
* All elements in the array are in the range [0, N-1]
* N * N does not overflow for a signed integer

Sol:
We will use following logic:
let there be 2 numbers a and b both less than n
let's take a value val=a+b*n
so from above val, if we have to get a and b, operations will be:
 (a + b*n) / n = b
 (a + b*n) % n = a

So we know that new number should be ar[ar[i]] which should be b if ar[i]=a; But this has flaw that the value
will change for arr[i]. SO we will use %n to keep old value.
b=(ar[ar[i]]%n)

So we will add (ar[ar[i]]%n)*n with each value of ar[i], and then in second pass we will divide each element by n
to get ar[ar[i]]

 */
package Mathematics.ModularArthmetic;
import java.util.Scanner;
public class RearrangeArray {
    public static void main(String[] args) {
        //Take input in form of String
        //String is space separated integers with first integer as length of array followed by as many array integers
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] s = line1.split(" ");
        int N = Integer.parseInt(s[0]);
        int[] arr = new int[N];
        for(int i=0 ; i<N; i++){
            arr[i] = Integer.parseInt(s[i+1]);
        }
        //Printing Input
        System.out.print("Array: ");
        for(int i=0;i<N;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("\n");

        arr = rearrange(arr);
        //Printing Output
        System.out.print("Rearranged Array: ");
        for(int i=0;i<N;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("\n");

    }
    static int[] rearrange(int[] arr){
        int N = arr.length;
        for(int i=0; i<N; i++){
            arr[i] += (arr[arr[i]]%N)*N;
        }
        for(int i=0; i<N; i++){
            arr[i] /= N;
        }
        return arr;
    }
}
