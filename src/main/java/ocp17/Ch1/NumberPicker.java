package ocp17.Ch1;

import java.util.Random; // import tells us where to find Random
import java.util.*; // imports java.util.Random among other things but child packages are not included
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

import java.lang.System; // Redundant as Java automatically includes them
import java.lang.*; // Redundant as Java automatically includes them

public class NumberPicker {
    public static void main(String[] args) {
        Random r = new Random(); // Does not compile if import is missing
        System.out.println(r.nextInt(10));
        Deque<Integer> d = new Deque<>(); // from star import
    }
}
