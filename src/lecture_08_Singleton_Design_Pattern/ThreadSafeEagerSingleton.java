package lecture_08_Singleton_Design_Pattern;

public class ThreadSafeEagerSingleton {
    private static ThreadSafeEagerSingleton instance = new ThreadSafeEagerSingleton();

    private ThreadSafeEagerSingleton() {
        System.out.println("Singleton Constructor Called");
    }

    public static ThreadSafeEagerSingleton getInstance() {
        return instance;
    }

    static void main() {
        ThreadSafeEagerSingleton s1 = ThreadSafeEagerSingleton.getInstance();
        ThreadSafeEagerSingleton s2 = ThreadSafeEagerSingleton.getInstance();

        System.out.println("s1 == s2: " + s1.equals(s2));
    }
}
