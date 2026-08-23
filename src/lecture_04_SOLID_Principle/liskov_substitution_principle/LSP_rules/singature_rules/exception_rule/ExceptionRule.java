package lecture_04_SOLID_Principle.liskov_substitution_principle.LSP_rules.singature_rules.exception_rule;

/*
Exception Rule:
A subclass should throw fewer or narrower exceptions (but not additional or broader exceptions) than the parent.
Java enforces this only for checked Exceptions.

└── java.lang.Exception                            // Conditions your application might want to catch
    ├── java.io.IOException                        // Checked I/O failures
    │   ├── java.io.FileNotFoundException
    │   ├── java.io.EOFException
    │   └── java.net.MalformedURLException
    ├── java.lang.ClassNotFoundException           // Checked reflect/… failures
    ├── java.lang.InterruptedException             // Checked thread interruption
    ├── java.sql.SQLException                      // Checked SQL/database errors
    ├── java.text.ParseException                   // Checked parsing errors
    └── java.lang.RuntimeException                 // Unchecked; subclasses may be thrown anywhere
        ├── java.lang.ArithmeticException          // e.g. divide by zero
        ├── java.lang.NullPointerException
        ├── java.lang.ArrayIndexOutOfBoundsException
        ├── java.lang.StringIndexOutOfBoundsException
        ├── java.lang.IllegalArgumentException
        │    └── java.lang.NumberFormatException
        ├── java.lang.IllegalStateException
        ├── java.lang.UnsupportedOperationException
        └── java.lang.IndexOutOfBoundsException    // parent of the two “…OutOfBounds” above
*/

class Parent {
    public void getValue() throws RuntimeException{
        System.out.println("Parent error");
    }
}

// Subclass overrides getValue and throws the narrower ChildException
class Child extends Parent {
    @Override
    public void getValue() throws ArithmeticException {
        throw new ArithmeticException("Child error");
        // throw new Exception("Child error");                 // This is wrong & not allowed
    }
}


// Client that invokes getValue and catches the parent exception type
class Client {
    private final Parent parent;

    public Client(Parent parent) {
        this.parent = parent;
    }

    public void takeValue() {
        try {
            parent.getValue();
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occurred: " + e.getMessage());
        }
    }
}


public class ExceptionRule {
    static void main() {
        Parent parent = new Parent();
        Child child = new Child();

        // Client client = new Client(parent);
        Client client = new Client(child);

        client.takeValue();
    }
}
