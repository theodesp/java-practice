package hackerrank.weekprep1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Implement a simple text editor. The editor initially contains an empty string, S. 
 * Perform Q operations of the following 4 types:

1 append - Append string W to the end of S.
2 delete(k) - Delete the last k characters of S.
3 print(k) - Print the kth character of S.
4 undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.
 
example: S="abcde"
ops: ["1 fg"]
*/
public class SimpleTextEditor {
    // public static void main(String[] args) throws IOException {
    //     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    //     int n = Integer.parseInt(bufferedReader.readLine().trim());
    //     var ops = new ArrayList<String>();
    //     IntStream.range(0, n).forEach(i -> {
    //         try {
    //             ops.add(bufferedReader.readLine());
    //         } catch (IOException ex) {
    //             throw new RuntimeException(ex);
    //         }
    //     });
        
    //     String result = solution(s, k);
    //     System.out.println(result);

    //     bufferedReader.close();
    // }

    // public static void solution(List<String> ops) {
    //     var stack = new Stack<String>();
    //     for (var op: ops) {
    //         var inst = op.split(" ");
    //         var kind = inst[0];
    //     }
    // }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int ops=Integer.parseInt(br.readLine());
        Stack<StringBuilder> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ops;i++)
        {
            String z[]=br.readLine().split(" "); 
                      
            if(z[0].equals("1")){
                st.add(new StringBuilder(sb.toString()));
                sb.append(z[1]);
            }
            if(z[0].equals("2")){
                st.add(new StringBuilder(sb.toString()));
                sb.delete(sb.length()-Integer.parseInt(z[1]),sb.length());
            }
            if(z[0].equals("3")){
                System.out.println(sb.charAt(Integer.parseInt(z[1])-1));
            }
            if(z[0].equals("4")){
                sb=st.pop();
            }
        }
    }
}
