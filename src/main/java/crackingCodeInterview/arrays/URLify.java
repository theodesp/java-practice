package crackingCodeInterview.arrays;

import org.checkerframework.checker.units.qual.C;

/**
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the utrue" length of the string. 
 */
public class URLify {
    public static void main(String[] args) {
        System.out.println(clean("Mr John Smith".toCharArray()));
        System.out.println(clean("Hello world".toCharArray()));
    }

    static char[] clean(char[] str) {
        // count spaces and find current length
        int space_count = 0, i = 0;
        for (i = 0; i < str.length; i++)
            if (str[i] == ' ')
                space_count++;
 
        // count spaces and find current length
        while (str[i - 1] == ' ')
        {
            space_count--;
            i--;
        }
 
        // Find new length.
        int new_length = i + space_count * 2;
 
        // New length must be smaller than length
        // of string provided.
        if (new_length > 1024)
            return str;
 
        // Start filling character from end
        int index = new_length - 1;
 
        char[] old_str = str;
        str = new char[new_length];
 
        // Fill rest of the string from end
        for (int j = i - 1; j >= 0; j--)
        {
 
            // inserts %20 in place of space
            if (old_str[j] == ' ')
            {
                str[index] = '0';
                str[index - 1] = '2';
                str[index - 2] = '%';
                index = index - 3;
            }
             
            else
            {
                str[index] = old_str[j];
                index--;
            }
        }
        return str;
        
    }
}
