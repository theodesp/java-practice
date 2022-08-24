package ocp17.Ch7;

public class NestedClasses {

}

class Home {
    private String greeting = "Hi"; // Outer class instance variable

    protected class Room {
        public int repeat = 3;

        public void enter() {
            for (int i = 0; i < repeat; i++)
                greet(greeting);
        }

        private static void greet(String message) {
            System.out.println(message);
        }
    }

    public void enterRoom() {
        var room = new Room();
        room.enter();
        // Instance method in outer class // Create the inner class instance
    }

    public static void main(String[] args) {
        var home = new Home(); // Create the outer class instance
        Room room = home.new Room(); // Create the inner class instance
        room.enter();
        home.enterRoom();

        new Home().new Room().enter(); // Sorry, it looks ugly to us too!
    }
}

class A {
    private int x = 10;

    class B {
        private int x = 20;

        class C {
            private int x = 30;

            public void allTheX() {
                System.out.println(x);
                System.out.println(this.x);
                System.out.println(B.this.x);
                System.out.println(A.this.x);
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.allTheX();
    }
}

class Fox {
    private class Den {
    }

    public void goHome() {
        new Den();
    }

    public static void visitFriend() {
        //new Den(); // DOES NOT COMPILE needs an instance of Fox
        new Fox().new Den(); // Compiles
    }
}