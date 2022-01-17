/*
    Q) Given N array elements, calculate number of pairs (i,j) such that (arr[i]+arr[j])%m=0
    Note:
    1. Input = arr[] and m
    2. i!=j and pair(i,j) is same as pair(j,i)
    3. i and j are 0 based indexes

    Sol:
    if we say (arr[i]+arr[j])%m = 0 this means combining arr[i] with arr[j] will be factor of m
    we can also write this as:
        (arr[i]+arr[j])%m = 0
     => (arr[i]%m + arr[j]%m)%m = 0
    So we can take modular of each element of array as well. We will see how this is useful
    by taking each array element with modular of m, we will restrict each element between 0 to m-1
    So we can maintain a hashmap of 0 to m-1 with count of each element in the map.
    eg:
    hashmap[6] =    0   1   2   3   4   5
    count in hm=    4   2   5   6   2   3
    So to make (arr[i]+arr[j])%m = 0,
    * we will have to combine remainder 1 with remainder 5 (1+5=6=m) => 2*3 = 6 pairs
    * we will have to combine remainder 2 with remainder 4 (2+4=6=m) => 5*2 = 10 pairs
    * we will have to combine remainder 3 with remainder 3 => taking 2 elements out of 6 elements with remainder 3
      This can be done using nC2 way = n(n-1)/2, In our case (6*5/2 = 15 pairs)
    * we will have to combine remainder 0 with remainder 0 => taking 2 elements out of 4 elements with remainder 0
      This can be done using nC2 way = n(n-1)/2, In our case (4*3/2 = 6 pairs)

    So total pairs for above hashmap example = 6 + 10 + 15 + 6
 */
package Mathematics.ModularArthmetic;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Scanner;
public class Modular2 {
    public static void main(String[] args) {
        //Take input in form of two Strings
        //String 1 is space separated integers with first integer as length of array followed by as many array integers
        //String 2 is value of m
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] s = line1.split(" ");
        int N = Integer.parseInt(s[0]);
        int[] arr = new int[N];
        for(int i=0 ; i<N; i++){
            arr[i] = Integer.parseInt(s[i+1]);
        }
        String line2 = sc.nextLine();
        s = line2.split(" ");
        int M = Integer.parseInt(s[0]);

        //Printing Input
        System.out.print("Array: ");
        for(int i=0;i<N;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("\n");
        System.out.println("M : "+M);

        int count = solve(arr,M);

        //Print Answer
        System.out.println("Final Output: " +count);

    }
    static int solve(@NotNull int arr[], int M){
        //Write your logic here

        //Step 1: Creating hashmap with frequency of remainder
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int j : arr) {
            int existing;
            if (hm.containsKey(j % M)) {
                existing = hm.get(j % M);
            } else {
                existing = 0;
            }
            hm.put(j % M, existing + 1);
        }

        //Step 2: iterate hashmap
        int end = M-1;
        int start = 1;
        int t0 = hm.getOrDefault(0,0);
        int ans = (t0*(t0-1))/2; //Initialize answer with nC2 of hashmap entry for 0 = no of pairs for 0
        //Calculate pairs for remaining
        while(start<end){

            ans += (hm.getOrDefault(start,0)*hm.getOrDefault(end,0));
            start++;
            end--;
        }
        //Calculate for M/2 if it is integer value with nC2 pairs
        if(start==end){
            int t1 = hm.get(start);
            ans += ((t1*(t1-1))/2);
        }
        return ans;
    }
}
