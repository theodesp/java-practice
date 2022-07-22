package ocp17.assessments;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;

interface HasTail { 
    private int getTailLength();
} 

abstract class Puma implements HasTail {
    String getTailLength() { 
        return "4"; 
    } 
}
class Cougar implements HasTail { 
    public static void main(String[] args) {
        var puma = new Puma() {};
        System.out.println(puma.getTailLength());
    }
    public int getTailLength(int length) { return 2; }}

public class Ass1Q10 {
    public static void main(String[] args) {
        Path path1 = Paths.get("birds");
        try {
            System.out.println(Files.mismatch(path1,Paths.get("Howdy")));
        } catch  (Exception e) {
            System.out.println(e);
        }
    }
}
