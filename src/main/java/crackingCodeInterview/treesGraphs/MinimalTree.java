package crackingCodeInterview.treesGraphs;

/**
 * Given a sorted (increasing order) array with unique integer elements, 
 * write an algorithm to create a binary search tree with minimal height.
 */
public class MinimalTree {
    public static void main(String[] args) {
        var arr = new int[]{2,3,4,5,7,8,11,15,18,22};
        var res = buildMinimalTree(arr, 0, arr.length-1);
        System.out.println();
    }

    static TreeNode buildMinimalTree(int[] elements, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + ((end-start) / 2);
		TreeNode root = new TreeNode(elements[mid]);
		root.left = buildMinimalTree(elements, start, mid-1);
		root.right =buildMinimalTree(elements, mid+1, end);
		return root;
    }
}
