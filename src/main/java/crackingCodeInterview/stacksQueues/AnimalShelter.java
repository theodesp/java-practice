package crackingCodeInterview.stacksQueues;

/**
 * 
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates
 * on a strictly"first in,
 * first out" basis. People must adopt either the "oldest" (based on arrival
 * time) of all animals
 * at the shelter, or they can select whether they would prefer a dog or a cat
 * (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like.
 * Create the data structures to maintain this system and implement operations
 * such
 * as enqueue, dequeueAny, dequeueDog, and dequeueCat.You may use the built-in
 * Linkedlist data structure.
 */
sealed abstract class Animal permits Dog, Cat {
};

final class Dog extends Animal {
    public String toString() {
        return "Dog";
    }
};

final class Cat extends Animal {
    public String toString() {
        return "Cat";
    }
};

public class AnimalShelter<T extends Animal> {
    class Node {
        T key;
        Node next;

        // constructor to create a new linked list node
        public Node(T key) {
            this.key = key;
            this.next = null;
        }
    }

    private Node first;
    private Node last;

    public AnimalShelter() {
        this.first = this.last = null;
    }

    void enqueue(T key) {

        // Create a new LL node
        var temp = new Node(key);

        // If queue is empty, then new node is front and rear both
        if (this.last == null) {
            this.first = this.last = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.last.next = temp;
        this.last = temp;
    }

    // Method to remove a key from queue.
    T dequeue() {
        // If queue is empty, return NULL.
        if (this.first == null)
            return null;

        // Store previous front and move front one node ahead
        var data = first.key;
        this.first = this.first.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.first == null)
            this.last = null;

        return data;
    }

    // Method to remove a cat from queue.
    T dequeueCat() {
        // If queue is empty, return NULL.
        if (this.first == null)
            return null;
        T data = null;
        if (this.first.key instanceof Cat c) {
            data = first.key;
            this.first = this.first.next;
        } else if (this.first.key instanceof Dog d) {
            var curr = this.first;
            while (curr != null) {
                if (curr.key instanceof Cat c) {
                    data = curr.key;
                    var next = curr.next;
                    curr.key= next.key;
                    curr.next= next.next;
                    break;
                } else {
                    curr = curr.next;
                }
            }
        } else {
            throw new RuntimeException("Unknown instance of Animal");
        }

        // If front becomes NULL, then change rear also as NULL
        if (this.first == null)
            this.last = null;

        return data;
    }

    // Method to remove a dog from queue.
    T dequeueDog() {
        // If queue is empty, return NULL.
        if (this.first == null)
            return null;
        T data = null;
        if (this.first.key instanceof Dog d) {
            data = first.key;
            this.first = this.first.next;
        } else if (this.first.key instanceof Cat c) {
            var curr = this.first;
            while (curr != null) {
                if (curr.key instanceof Dog d) {
                    data = curr.key;
                    var next = curr.next;
                    curr.key= next.key;
                    curr.next= next.next;
                    break;
                } else {
                    curr = curr.next;
                }
            }
        } else {
            throw new RuntimeException("Unknown instance of Animal");
        }

        // If front becomes NULL, then change rear also as NULL
        if (this.first == null)
            this.last = null;

        return data;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public static void main(String[] args) {
        var s = new AnimalShelter<Animal>();
        s.enqueue(new Dog());
        s.enqueue(new Cat());
        s.enqueue(new Dog());
        s.enqueue(new Dog());
        s.enqueue(new Cat());
        s.enqueue(new Dog());
        System.out.println(s.dequeueCat());
        System.out.println(s.dequeueDog());
    }
}
