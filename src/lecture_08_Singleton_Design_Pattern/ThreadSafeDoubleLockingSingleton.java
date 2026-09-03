package lecture_08_Singleton_Design_Pattern;

public class ThreadSafeDoubleLockingSingleton {

    private static ThreadSafeDoubleLockingSingleton instance;

    public ThreadSafeDoubleLockingSingleton() {
        System.out.println("Singleton Constructor Called");
    }

    // Double Check locking
    public static ThreadSafeDoubleLockingSingleton getInstance() {
        if (instance == null) {                                            // First check (no locking)
            synchronized (ThreadSafeDoubleLockingSingleton.class) {        // Lock only if needed
                if (instance == null) {                                    // Second check (after acquiring lock)
                    instance = new ThreadSafeDoubleLockingSingleton();
                }
            }
        }
        return instance;
    }

    static void main() {
        ThreadSafeDoubleLockingSingleton s1 = ThreadSafeDoubleLockingSingleton.getInstance();
        ThreadSafeDoubleLockingSingleton s2 = ThreadSafeDoubleLockingSingleton.getInstance();

        System.out.println("s1 == s2: " + s1.equals(s2));
    }
}
