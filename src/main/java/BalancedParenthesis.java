import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParenthesis {
    static Map<Character, Character> map = new HashMap<>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
    }};
    HashMap.of
    static Boolean isBalanced(String input) {
        Stack<Character> s = new Stack<>();
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
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
