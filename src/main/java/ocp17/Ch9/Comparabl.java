package ocp17.Ch9;

public class Comparabl {

}

class MissingDuck implements Comparable<MissingDuck> {
    private String name;

    public int compareTo(MissingDuck quack) {
        if (quack == null)
            throw new IllegalArgumentException("Poorly formed duck!");
        if (this.name == null && quack.name == null)
            return 0;
        else if (this.name == null)
            return -1;
        else if (quack.name == null)
            return 1;
        else
            return name.compareTo(quack.name);
    }
}

class Product implements Comparable<Product> {
    private int id;
    private String name;

    public int hashCode() {
        return id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Product))
            return false;
        var other = (Product) obj;
        return this.id == other.id;
    }

    public int compareTo(Product obj) {
        return this.name.compareTo(obj.name);
    }
}