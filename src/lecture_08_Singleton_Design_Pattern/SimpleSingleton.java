package lecture_08_Singleton_Design_Pattern;

// Singleton Design:
// 1. create a private constructor.
// 2. create a static instance that returns the same instance every time.

public class SimpleSingleton {

    private static SimpleSingleton instance = null;

    public SimpleSingleton() {
        System.out.println("Singleton Constructor called");
    }

    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }

    static void main() {
        SimpleSingleton s1 = SimpleSingleton.getInstance();
        SimpleSingleton s2 = SimpleSingleton.getInstance();

        System.out.println("s1 == s2: " + s1.equals(s2));
    }
}
