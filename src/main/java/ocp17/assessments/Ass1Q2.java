public class Ass1Q2 {
    public static void main(String[] args) {
        int moon = 9, star = 2 + 2 * 3; // moon = 9, star = 8
        float sun = star>10 ? 1 : 3; // sun = 3.0f
        double jupiter = (sun + moon) - 1.0f; // jupiter = 11.0
        int mars = --moon <= 8 ? 2 : 3; // mars = 2 
        System.out.println(sun+", "+jupiter+", "+mars); // 3.0, 11.0, 2
    }
}
