package lecture_08_Singleton_Design_Pattern;

public class NoSingleton {
    public NoSingleton() {
        System.out.println("Singleton Constructor called. New Object created.");
    }

    static void main() {
        NoSingleton s1 = new NoSingleton();
        NoSingleton s2 = new NoSingleton();

        System.out.println("s1 == s2: " + s1.equals(s2));
    }
}
