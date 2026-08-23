package lecture_04_SOLID_Principle.liskov_substitution_principle.LSP_rules.singature_rules.return_type_rule;


/*
Return Type Rule:
Subtype overridden method return type should be either identical or narrower than the parent method's return type.
This is also called return type covariance.
Java supports this out of the box.
*/

class Animal {
    // some common Animal methods
}

class Dog  extends Animal {
    // Additional Dig methods specific to Dogs.
}

class Parent {
    public Animal getAnimal() {
        System.out.println("Parent: Returning Animal instance");
        return new Animal();
    }
}

class Child extends Parent {
    @Override
    public Animal getAnimal() {
        System.out.println("Child: Returning Dog instance");
        return new Dog();
    }
}


class Client {
    private final Parent parent;

    public Client(Parent parent) {
        this.parent = parent;
    }

    public void takeAnimal() {
        parent.getAnimal();
    }
}

public class ReturnTypeRule {
    static void main() {

        Parent parent = new Parent();
        Child child = new Child();

        // Client client = new Client(parent);
        Client client = new Client(child);
        client.takeAnimal();
    }
}
