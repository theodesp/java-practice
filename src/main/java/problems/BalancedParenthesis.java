import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Given an expression string exp, write a program to examine whether the pairs 
 * and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
 */
public class BalancedParenthesis {
    static Map<Character, Character> map = new HashMap<>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
    }};
    static Boolean isBalanced(String input) {
        var s = new Stack<Character>();
        for (char c: input.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                s.push(c);
            } else {
                char top = s.peek();
                if (s.empty()) {
                    return false;
                }
                if (map.get(top) == c) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        return s.empty();
    }

    public static void main(String[] args)
    {
        String expr = "([{}])";

        // Function call
        if (isBalanced(expr))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}
