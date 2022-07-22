package problems;

import java.util.Random;
import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/*
 * You are given stream of numbers where you receive elements one by one. 
 * You are also given variable DISTANCE
 * Each time, when another number is added to the stream you need to provide output in a form of triplet (a, b, c) where distance between any pair of this triplet is less than or equal to DISTANCE. More formally, following should be true for triplet (a, b, c):

    abs(a - b) <= DISTANCE
    abs(a - c) <= DISTANCE
    abs(b - c) <= DISTANCE

    It is guaranteed there would be no duplicates in the stream
 */
public class TripletsWithinDistance {

    private final int distance;
    private final List<Integer> list;
    TripletsWithinDistance(int distance) {
        this.distance = distance;
        this.list = new ArrayList<Integer>();
    }

    public void print() {
        this.list.forEach((Integer value) -> System.out.println(value));
    }

    public void add(int i) {
        int pos = Collections.binarySearch(this.list, i);
        this.list.add(-(pos+1), i);
        if (this.list.size() < 3) {
            return;
        } else {
            if (pos == -1) {
                var p1 = -(pos+1);
                var p2 = -pos;
                var p3 = -(pos-1);
                if (checkDistance(this.list.get(p1), this.list.get(p2), this.list.get(p3), this.distance)) {
                    this.list.remove(p3);
                    this.list.remove(p2);
                    this.list.remove(p1);
                }
            } else if (pos == -this.list.size())  {
                var p1 = -pos-1;
                var p2 = -pos-2;
                var p3 = -pos-3;
                if (checkDistance(this.list.get(p1), this.list.get(p2), this.list.get(p3), this.distance)) {
                    this.list.remove(p1);
                    this.list.remove(p2);
                    this.list.remove(p3);
                }
            } else {
                var p1 = -(pos+2);
                var p2 = -(pos+1);
                var p3 = -(pos);
                if (checkDistance(this.list.get(p1), this.list.get(p2), this.list.get(p3), this.distance)) {
                    this.list.remove(p3);
                    this.list.remove(p2);
                    this.list.remove(p1);
                }
            }
        }
    }

    public static boolean checkDistance(int a, int b, int c, int distance) {
        return Math.abs(a - b) <= distance && Math.abs(a - c) <= distance && Math.abs(b - c) <= distance;
    }

    public static void main(String[] args) {
        var t = new TripletsWithinDistance(10);
        var arr = new Random().ints(0,350).limit(100).boxed().collect(Collectors.toSet());
        var stream = Arrays.stream(arr.stream().mapToInt(Integer::intValue).toArray());
        // var stream = Arrays.stream(new int[]{25, 46, 31, 23});
        stream.forEach(i -> t.add(i));
        t.print();
    }
}
