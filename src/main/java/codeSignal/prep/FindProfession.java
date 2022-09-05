package codeSignal.prep;
/**
 * Consider a special family of Engineers and Doctors. This family has the following rules:

Everybody has two children.
The first child of an Engineer is an Engineer and the second child is a Doctor.
The first child of a Doctor is a Doctor and the second child is an Engineer.
All generations of Doctors and Engineers start with an Engineer.
We can represent the situation using this diagram:
 */
public class FindProfession {
    static class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 3));
        System.out.println(solution(4, 2));
        System.out.println(solution(1, 1));
    }

    static String solution(int level, int pos) {
        // var t = new Tree<String>("Engineer", 1);
        // return findProfession(t, level, pos);
        if (level == 1) {
            return "Engineer";
        }
        if (pos % 2 == 1) {
            return solution(level - 1, (pos+1)/2);
        } else {
            if (solution(level - 1, pos/2) == "Doctor") {
                return "Engineer";
            }
            return "Doctor";
        }
    }
}
