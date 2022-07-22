/*
 * Print all the permutations of a string
 */
public class StringPerms {
    static void permute(String str, int l, int r)
    {   
        // If both pointers reached we print the final string
        if (l == r)
            System.out.println(str);
        else
        {
            // Othewise we try to perform backtracking by swapping the current char at l 
            // with the char at r, call permute with l+1 and restore the swap.
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }


    static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        permute("ARWFG", 0, 4);
    }
}
