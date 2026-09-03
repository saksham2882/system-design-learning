package lecture_08_Singleton_Design_Pattern;

public class ThreadSafeLockingSingleton {
    private static ThreadSafeLockingSingleton instance = null;

    public ThreadSafeLockingSingleton() {
        System.out.println("Singleton Constructor Called");
    }

    public static ThreadSafeLockingSingleton getInstance() {
        synchronized (ThreadSafeLockingSingleton.class) {          // Lock for thread safety
            if (instance == null) {
                instance = new ThreadSafeLockingSingleton();
            }
            return instance;
        }
    }

    static void main() {
        ThreadSafeLockingSingleton s1 = ThreadSafeLockingSingleton.getInstance();
        ThreadSafeLockingSingleton s2 = ThreadSafeLockingSingleton.getInstance();

        System.out.println("s1 == s2: " + s1.equals(s2));
    }
}
