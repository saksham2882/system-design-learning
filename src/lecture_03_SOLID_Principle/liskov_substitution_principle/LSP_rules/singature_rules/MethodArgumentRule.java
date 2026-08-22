package lecture_03_SOLID_Principle.liskov_substitution_principle.LSP_rules.singature_rules;


// Method Argument Rule:
// Subtype method arguments can be identical or wider than the supertype

public class MethodArgumentRule {

    class Parent {
        public void print(String msg) {
            System.out.println("Parent: " + msg);
        }
    }

    class Child extends Parent {
        @Override
        public void print(String msg) {
            System.out.println("Child: " + msg);
        }
    }

    // Client that pass string as msg as client expects.
    class Client {
        private final Parent parent;

        public Client(Parent parent) {
            this.parent = parent;
        }

        public void printMsg() {
            parent.print("Hello World!");
        }
    }

    void main() {

        Parent parent = new Parent();
        Child child = new Child();

        // Client client = new Client(parent);
        Client client = new Client(child);
        Client client1 = new Client(parent);

        client.printMsg();
        client1.printMsg();
    }
}
