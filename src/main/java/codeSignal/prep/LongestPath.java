package codeSignal.prep;

import java.util.*;

/**
 * Suppose we represent our file system as a string. For example, the string "user\n\tpictures\n\tdocuments\n\t\tnotes.txt" represents:

user
    pictures
    documents
        notes.txt    
The directory user contains an empty sub-directory pictures and a sub-directory documents containing a file notes.txt.

The string "user\n\tpictures\n\t\tphoto.png\n\t\tcamera\n\tdocuments\n\t\tlectures\n\t\t\tnotes.txt" represents:

user
    pictures
        photo.png
        camera
    documents
        lectures
            notes.txt
The directory user contains two sub-directories pictures and documents. pictures contains a file photo.png and an empty second-level sub-directory camera. documents contains a second-level sub-directory lectures containing a file notes.txt.

We want to find the longest (as determined by the number of characters) absolute path to 
a file within our system. For example, in the second example above, the longest absolute 
path is "user/documents/lectures/notes.txt", and its length is 33 
(not including the double quotes).

Given a string representing the file system in this format, return the length of 
the longest absolute path to a file in the abstracted file system. 
If there is not a file in the file system, return 0.
*/
public class LongestPath {
    static class Tree<T> {
        Tree() {
        }
        Tree(T x) {
            value = x;
        }

        T value;
        List<Tree<T>> children;
    }
    public static void main(String[] args) {
        System.out.println(solution("user\f\tpictures\f\tdocuments\f\t\tnotes.txt"));
    }
    int solution(String fileSystem) {
        int maxlen = 0;
        Map<Integer, Integer> pathDict = new HashMap<>();
        pathDict.put(0, 0);
        for (String file : fileSystem.split("\f")) {
            int depth = count(file);
            int name = file.length() - depth;
            if (file.contains(".")) {
                maxlen = Math.max(maxlen, pathDict.get(depth) + name);
            } else {
                pathDict.put(depth + 1, pathDict.get(depth) + name + 1);
            }
        }


        return maxlen;
    }

    int count(String file) {
        Matcher matcher = Pattern.compile("\\t").matcher(file);
        int sum = 0;
        while (matcher.find()) {
            sum++;
        }
        return sum;
    }
    
}
