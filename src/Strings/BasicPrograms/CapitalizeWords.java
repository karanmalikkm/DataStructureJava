/*
Problem Description
Given a paragraph of words, capitalise the first character of each word and return the updated paragraph.
Note : No inbuilt function such as split() to be used.

Input format
One line of input which contains a string, the paragraph.

Output format
Return the paragraph after capitalising each word.

Sample Input 1
the quick Brown fox jumps over The lazy dog.

Sample Output 1
The Quick Brown Fox Jumps Over The Lazy Dog.

Constraints
Length of paragraph < 100
The paragraph contains spaces, lowercase, uppercase characters and ‘.’.
 */
package Strings.BasicPrograms;
import java.util.*;
public class CapitalizeWords {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String captStr = capitalise(str);
        System.out.println(captStr);
    }

    // Implement this method
    static String capitalise(String str) {
        char[] charArray = str.toCharArray();
        for(int i=0; i<charArray.length; i++){
            if(charArray[i]>='a'&&charArray[i]<='z'){
                if(i==0){
                    charArray[i]=(char)((int)charArray[i]-(int)('a')+(int)'A');
                }
                else{
                    if(charArray[i-1]==' '){
                        charArray[i]=(char)((int)charArray[i]-(int)('a')+(int)'A');
                    }
                }
            }
        }
        return String.valueOf(charArray);
    }
}
