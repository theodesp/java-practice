package codeSignal.prep;
/**
 * Given the inorder and preorder traversals of a binary tree t, 
 * but not t itself, restore t and return it.
 * 
 * 
 * In a Preorder sequence, the leftmost element is the root of the tree. 
 * So we know ‘A’ is the root for given sequences. 
 * By searching ‘A’ in the Inorder sequence, 
 * we can find out all elements on the left side of ‘A’ is in the left subtree 
 * and elements on right in the right subtree.
 */
public class RestoreBinaryTree {
    static int preIndex = 0;
    static class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }
    public static void main(String[] args) {
        print("", solution(new int[]{4, 2, 1, 5, 3, 6}, new int[]{1, 2, 4, 3, 5, 6}), false);
    }
    static Tree<Integer> solution(int[] inorder, int[] preorder) {
        if (inorder.length == 0) {
            return null;
        }

        var rootValue = preorder[0];
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                var root = new Tree<>(rootValue);
                root.left = solution(getArr(0, i - 1, inorder), getArr(1, i, preorder));
                root.right = solution(getArr(i + 1, inorder.length - 1, inorder), getArr(i + 1, preorder.length - 1, preorder));
                return root;
            }
        }

        return null;
    }

    static int[] getArr(int start, int end, int[] arr) {
        var len = end - start + 1;
        var result = new int[len];

        int index = 0;
        for (int i = start; i <= end; i++) {
            result[index] = arr[i];
            index++;
        }
        return result;
    }

    static void print(String prefix, Tree<Integer> n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.value);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }
}
