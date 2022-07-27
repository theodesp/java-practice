package ocp17.Ch1;

public class TextBlock {
    public static void main(String[] args) {
        String eyeTest = "\"Java Study Guide\"\n by Scott & Jeanne";
        String pyramid = """
             *
            * * 
           * * *"""; 
        // System.out.print(pyramid);
        //String block = """doe"""; // Does not compile. Text blocks require a line break after the opening """, making this one invalid
        String block2 = """
            doe \
            deer"""; // \ means omit new line on that line so the output is one line
        String block3 = """
            doe \n
            deer
            """; // 4 lines
        System.out.print(block3);
    }
}
