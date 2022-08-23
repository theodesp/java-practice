package ocp17.Ch7;

public class SealedInterfaces {
    
}
sealed interface Swims permits Duck, Swan, Floats {}

final class Duck implements Swims {}
final class Swan implements Swims {}
non-sealed interface Floats extends Swims {}
final class Doubles implements Floats {}