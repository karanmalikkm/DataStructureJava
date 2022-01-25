/*
Problem Description
You are given a string which comprises all ASCII characters(which comprises of lower case alphabets (a-z), upper case alphabets (A-Z), numbers, (0-9) , special characters , etc).
You are supposed to find out which character occurs the maximum number of times and its occurrence count in the given string. If two characters occur equal number of times, you have to output the character with the lower ASCII value.

For example, if your string was: aaaaAAAA, your output would be: A 4, because A has lower ASCII value than a.

Input format
One line of input containing the string S.

Output format
You will have to output two space separated values:
The character which occurs the maximum number of times.
The number of its occurrence.

Sample Input 1
Statements are unique.

Sample Output 1
e 4

Constraints
1 <= |S| <= 100
 */
package Strings.BasicPrograms;
import java.util.*;
public class MostFrequentInString {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Object[] ans = mostFrequent(s);
        System.out.println(ans[0] + " " + ans[1]);
    }

    // Implement this method
    static Object[] mostFrequent(String s) {
        char[] letters = s.toCharArray();
        Object[] out = new Object[2];
        HashMap<Character,Integer> hm = new HashMap<>();
        for(Character c : letters){
            int value = hm.getOrDefault(c,0);
            hm.put(c,++value);
        }
        char ch = 0;
        int maxValue = 0;
        for(Character c : hm.keySet()){
            int tempVal = hm.get(c);
            if(tempVal > maxValue){
                maxValue = tempVal;
                ch = c;
            }
            else{
                if(tempVal == maxValue){
                    if(c <ch){
                        ch = c;
                    }
                }
            }
        }
        out[0] = ch;
        out[1] = maxValue;
        return out;
    }
}