package ocp17.Ch9;

public class Generics {
    public static void main(String[] args) {
        Elephant elephant = new Elephant();
        Integer numPounds = 15_000;
        SizeLimitedCrate<Elephant, Integer> c1 = new SizeLimitedCrate<>(elephant, numPounds);
        new Object();
        Robot robot = new Robot();
        CrateRecord<Robot> record = new CrateRecord<>(robot);
    }
}

class Crate<T> {
    private T contents;

    public T lookInCrate() {
        return contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }
}

class SizeLimitedCrate<T, U> {
    private T contents;
    private U sizeLimit;

    public SizeLimitedCrate(T contents, U sizeLimit) {
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    }
}

class LongTailAnimal {
    protected void chew(List<Object> input) {
    }

    protected void chew(List<Double> input) {
    } // DOES NOT COMPILE invalid overloaded methodx
}

interface Shippable<T> {
    void ship(T t);
}

class ShippableRobotCrate implements Shippable<Robot> {
    public void ship(Robot t) {
    }
}

class ShippableAbstractCrate<U> implements Shippable<U> {
    public void ship(U t) {
    }
}

class ShippableCrate implements Shippable {
    public void ship(Object t) {
    }
}

class Handler {
    public static <T> void prepare(T t) {
        System.out.println("Preparing " + t);
    }

    public static <T> Crate<T> ship(T t) {
        System.out.println("Shipping " + t);
        return new Crate<T>();
    }
}

class More {
    public static <T> void sink(T t) {
    }

    public static <T> T identity(T t) {
        return t;
    }

    public static T noGood(T t) {
        return t;
    } // DOES NOT COMPILE omits the formal parameter type
}

record CrateRecord<T> (T contents) {
    @Override
    public T contents() {
        if (contents == null)
            throw new IllegalStateException("missing contents");
        return contents;
    }
}