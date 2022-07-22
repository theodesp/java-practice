public class Ass1Q1 {
    public static void main(String[] args) {
        final int score1 = 8, score2 = 3;
        char myScore = 7;
        var goal = switch (myScore) {
            default -> {if(10>score1) yield "unknown";}
            case score1 -> "great";
            case 2, 4, 6 -> "good";
            case score2, 0 -> {"bad";} // Compile time error. This is not a statement. It needs to remove braces
        };
        System.out.println(goal);
    }
}
