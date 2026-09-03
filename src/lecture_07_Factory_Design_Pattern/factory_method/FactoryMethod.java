package lecture_07_Factory_Design_Pattern.factory_method;

// Factory Method:
// Define an interface for creating objects but allows subclass to decide which class to instantiate.


interface Burger {
    public void prepare();
}

class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

class BasicWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger with bun, patty, and ketchup!");
    }
}

class StandardWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Wheat Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}


// ======= Factory Interface and Concrete Factories =========
interface BurgerFactory {
    public Burger createBurger(String type);
}

class SinghBurger implements BurgerFactory {
    @Override
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("Basic")){
            return new BasicBurger();
        }
        else if(type.equalsIgnoreCase("standard")){
            return new StandardBurger();
        }
        else if(type.equalsIgnoreCase("premium")){
            return new PremiumBurger();
        }
        else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}


class KingBurger implements BurgerFactory {
    @Override
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("Basic")){
            return new BasicWheatBurger();
        }
        else if(type.equalsIgnoreCase("standard")){
            return new StandardWheatBurger();
        }
        else if(type.equalsIgnoreCase("premium")){
            return new PremiumWheatBurger();
        }
        else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}


public class FactoryMethod {
    static void main() {

        String type = "basic";

        BurgerFactory burgerFactory = new SinghBurger();
        Burger burger = burgerFactory.createBurger(type);

        if(burger != null){
            burger.prepare();
        }
    }
}
