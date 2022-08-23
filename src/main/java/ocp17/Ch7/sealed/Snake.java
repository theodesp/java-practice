package ocp17.Ch7.sealed;

public sealed class Snake {} // Allowed within the same file
final class Cobra extends Snake {}


sealed class Metal {} // DOES NOT COMPILE
final class Iron {}

sealed class Color {
    final class Red extends Color {}
}

sealed class Snake2 permits Cobra2 { // DOES NOT COMPILE 
    final class Cobra2 extends Snake2 {}
}