package ocp17.Ch4;

public class MethodChaining {
    public static void main(String[] args) {
        String result = "AniMaL ".trim().toLowerCase().replace('a', 'A'); 
        System.out.println(result);
    }
}
