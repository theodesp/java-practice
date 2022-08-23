package ocp17.Ch7;

public class SealedClasses {
    
}

sealed class Bear permits Kodiak, Panda {}

final class Kodiak extends Bear {}
non-sealed class Panda extends Bear {}

class sealed Frog permits GlassFrog {} // DOES NOT COMPILE
final class GlassFrog extends Frog {}

abstract sealed class Wolf permits Timber {}
final class Timber extends Wolf {}
final class MyWolf extends Wolf {} // DOES NOT COMPILE The type MyWolf extending a sealed class Wolf should be a permitted subtype of Wolf

sealed class Wolf permits Timber {}
non-sealed class Timber extends Wolf {}
class MyWolf extends Timber {} // indirect subclass of Wolf