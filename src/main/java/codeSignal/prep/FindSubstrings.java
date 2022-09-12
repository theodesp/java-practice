package codeSignal.prep;

import java.util.*;

/**
 * You have two arrays of strings, words and parts. Return an array that contains the strings from words, 
 * modified so that any occurrences of the substrings from parts are surrounded by square brackets [], 
 * following these guidelines:

If several parts substrings occur in one string in words, choose the longest one. 
If there is still more than one such part, then choose the one that appears first in the string.

For words = ["Apple", "Melon", "Orange", "Watermelon"] and parts = ["a", "mel", "lon", "el", "An"], the output should be
solution(words, parts) = ["Apple", "Me[lon]", "Or[a]nge", "Water[mel]on"].

While "Watermelon" contains three substrings from the parts array, "a", "mel", and "lon", "mel" is the longest substring that appears first in the string.
 */
public class FindSubstrings {
    public static void main(String[] args) {
        var words = new String[]{"Apple", "Melon", "Orange", "Watermelon"};
        var parts = new String[]{"a", "mel", "lon", "el", "An"};
        //System.out.println(Arrays.toString(solution(words, parts)));
        System.out.println(Arrays.toString(solution2(words, parts)));
    }

    // Brute force method
    // For each word use indexOf to find if the part exists and capture position
    // If more than one part exists return the longest one
    // If there are parts with the same length return the smallest index one
    static String[] solution(String[] words, String[] parts) {
        var result = new ArrayList<String>();
        for (var word: words) {
            var currPartLen = 0;
            var currPartIndex = -1;
            String partMatching = null;
            for (var part: parts) {
                var index = word.indexOf(part);
                if (index >= 0) {
                    if (partMatching == null) {
                        currPartIndex = index;
                        currPartLen = part.length();
                        partMatching = part;
                    } else {
                        if (part.length() == currPartLen && index < currPartIndex) {
                            currPartIndex = index;
                            currPartLen = part.length();
                            partMatching = part;
                        } else if (part.length() > currPartLen) {
                            currPartIndex = index;
                            currPartLen = part.length();
                            partMatching = part;
                        }
                    }
                }
            }
            if (currPartIndex >= 0) {
                var temp = word.substring(0, currPartIndex) + "[" + partMatching + "]" + word.substring(currPartIndex+currPartLen);
                result.add(temp);
            } else {
                result.add(word);
            }
        }
        var temp = new String[result.size()];
        return result.toArray(temp);
    }
    
    /*
     * Initialize our lenLongSubstr to 0.
    Go through word one character at a time, using that character as a starting point for matching substrings in parts.
    For each character, use the trie to find the longest substring from parts starting from this character. If it is longer than the longest one we've seen so far, record the current position in the string and the current length.
    Use the length of the longestSeenSubstring and its starting position to put the square brackets in the right place.
     */
    static String[] solution2(String[] words, String[] parts) {
        var result = new ArrayList<String>();
        var trie = new Trie();
        for (var part: parts) {
            trie.insert(part);
        }
        
        for (int i = 0; i < words.length; i++) {
            var found = trie.findSubstringInWord(words[i]);
            result.add(found);
        }
        var temp = new String[result.size()];
        return result.toArray(temp);
    }

}

class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode current = root;

        for (char l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    boolean delete(String word) {
        return delete(root, word, 0);
    }

    boolean containsNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    String findSubstringInWord(String word) {
        TrieNode current = root;
        
        int lenLongSubstr = 0, longestPos = 0;
        for (int startPos = 0; startPos < word.length(); startPos++) {
            for (int i = startPos; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.getChildren().get(ch);
                if (node == null) {
                    continue;
                }
                var length = i - startPos + 1;
                current = node;
                if (current.isEndOfWord() && length > lenLongSubstr) {
                    lenLongSubstr = length;
                    longestPos   = startPos;
                }
            }
        }
        if (lenLongSubstr == 0) {
            return word;
        } else {
            var end = longestPos + lenLongSubstr;
            var temp = word.substring(0, longestPos) + "[" + word.substring(longestPos, end) + "]" + word.substring(end);
            return temp;
        }
    }

    boolean isEmpty() {
        return root == null;
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
}

class TrieNode {
    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean endOfWord;

    Map<Character, TrieNode> getChildren() {
        return children;
    }

    boolean isEndOfWord() {
        return endOfWord;
    }

    void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}