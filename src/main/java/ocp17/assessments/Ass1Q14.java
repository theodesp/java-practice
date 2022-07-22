package ocp17.assessments;

import java.io.*;

public class Ass1Q14 {
    private String name;
    private transient Integer age;
    // Getters/setters omitted
    public static void main(String[] args) {
        try(var is = new ObjectInputStream(new BufferedInputStream(new FileInputStream("birds.dat")))) {
            Ass1Q14 b = is.readObject(); // Does not compile as readObject needs to cast to Ass1Q14
            System.out.println(b.age);
        }
    }
}
