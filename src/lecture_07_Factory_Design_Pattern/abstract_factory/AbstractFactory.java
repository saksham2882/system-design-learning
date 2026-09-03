package lecture_07_Factory_Design_Pattern.abstract_factory;

// Abstract Factory Method:
// Provide an interface for creating families of related objects without specifying there concrete classes.


// ======= Product 1 -> Burger ========
interface Burger {
    public void prepare();
}

class  BasicBurger implements Burger {
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


// ====== Product 2 -> GarlicBread =======
interface GarlicBread {
    public void prepare();
}

class BasicGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Garlic Bread with butter and garlic!");
    }
}

class CheeseGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Garlic Bread with extra cheese and butter!");
    }
}

class BasicWheatGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Wheat Garlic Bread with butter and garlic!");
    }
}

class CheeseWheatGarlicBread implements GarlicBread {
    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Wheat Garlic Bread with extra cheese and butter!");
    }
}


// ====== Abstract Factory =======
interface MealFactory {
    public Burger createBurger(String type);
    public GarlicBread createGarlicBread(String type);
}

// ======= Concrete Factory 1 ========
class SinghBurger implements MealFactory {
    @Override
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurger();
        }
        else if (type.equalsIgnoreCase("Standard")) {
            return new StandardBurger();
        }
        else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        }
        else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }

    @Override
    public GarlicBread createGarlicBread(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicGarlicBread();
        }
        if (type.equalsIgnoreCase("cheese")) {
            return new CheeseGarlicBread();
        }
        else {
            System.out.println("Invalid garlic bread type!");
            return null;
        }
    }
}


// ======= Concrete Factory 2 ========
class KingBurger implements MealFactory {
    @Override
    public Burger createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatBurger();
        }
        else if (type.equalsIgnoreCase("Standard")) {
            return new StandardWheatBurger();
        }
        else if (type.equalsIgnoreCase("Premium")) {
            return new PremiumWheatBurger();
        }
        else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }

    @Override
    public GarlicBread createGarlicBread(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatGarlicBread();
        }
        if (type.equalsIgnoreCase("cheese")) {
            return new CheeseWheatGarlicBread();
        }
        else {
            System.out.println("Invalid garlic bread type!");
            return null;
        }
    }
}


public class AbstractFactory {
    static void main() {

        String burgerType = "basic";
        String garlicBreadType = "cheese";

        MealFactory mealFactory = new SinghBurger();

        Burger burger = mealFactory.createBurger(burgerType);
        GarlicBread garlicBread = mealFactory.createGarlicBread(garlicBreadType);

        if(burger != null){
            burger.prepare();
        }
        if(garlicBread != null){
            garlicBread.prepare();
        }
    }
}
