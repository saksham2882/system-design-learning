package lecture_06_Strategy_Design_Pattern;

// Strategy Design Pattern:
// Defines a family of Algorithm, put them into separate classes so that they can be changed at runtime.


// Strategy Interface for walk
interface WalkableRobot {
    public void walk();
}

// ========== Concrete Strategies for walk ==========
class NormalWalk implements WalkableRobot {
    public void walk() {
        System.out.println("Walking normally....");
    }
}

class NoWalk implements WalkableRobot {
    public void walk() {
        System.out.println("Cannot walk.");
    }
}


// Strategy Interface for talk
interface TalkableRobot {
    public void talk();
}

// ========= Concrete Strategies for Talk =========
class NormalTalk implements TalkableRobot {
    public void talk() {
        System.out.println("Talking normally....");
    }
}

class NoTalk implements TalkableRobot {
    public void talk() {
        System.out.println("Cannot talk.");
    }
}


// Strategy Interface for Fly
interface FlyableRobot {
    public void fly();
}

// ========= Concrete Strategies for fly ==========
class NormalFly implements FlyableRobot {
    public void fly() {
        System.out.println("Flying normally....");
    }
}

class NoFly implements FlyableRobot {
    public void fly() {
        System.out.println("Cannot fly.");
    }
}

class JetFly implements FlyableRobot {
    public void fly() {
        System.out.println("Jet flying normally....");
    }
}


// Robot Base Class
abstract class Robot {
    protected WalkableRobot walkBehavior;
    protected TalkableRobot talkBehavior;
    protected FlyableRobot flyBehavior;

    public Robot(WalkableRobot walkBehavior, TalkableRobot talkBehavior, FlyableRobot flyBehavior) {
        this.walkBehavior = walkBehavior;
        this.talkBehavior = talkBehavior;
        this.flyBehavior = flyBehavior;
    }

    public void walk() {
        walkBehavior.walk();
    }

    public void talk() {
        talkBehavior.talk();
    }

    public void fly() {
        flyBehavior.fly();
    }

    // abstract method for subclasses
    public abstract void projection();
}


// ========= Concrete Robot Types =========
class CompanionRobot extends Robot {
    public CompanionRobot(WalkableRobot walkBehavior, TalkableRobot talkBehavior, FlyableRobot flyBehavior) {
        super(walkBehavior, talkBehavior, flyBehavior);
    }

    public void projection() {
        System.out.println("Displaying friendly companion features...");
    }
}


class WorkerRobot extends Robot {
    public WorkerRobot(WalkableRobot walkBehavior, TalkableRobot talkBehavior, FlyableRobot flyBehavior) {
        super(walkBehavior, talkBehavior, flyBehavior);
    }

    public void projection() {
        System.out.println("Displaying worker features...");
    }
}


public class StrategyDesignPattern {
    static void main() {

        Robot robot1 = new CompanionRobot(new NormalWalk(), new NormalTalk(), new NormalFly());
        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.projection();

        System.out.println("=========================");

        Robot robot2 = new WorkerRobot(new NoWalk(), new NormalTalk(), new NormalFly());
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();

        Robot robot3 = new WorkerRobot(new NoWalk(), new NoTalk(), new JetFly());
        robot3.walk();
        robot3.talk();
        robot3.fly();
        robot3.projection();
    }
}


// Conclusion:
// 1. Encapsulate what varies & keep it separate from what remains same.
// 2. Solution to inheritance is not more inheritance.
// 3. Composition should be favored over inheritance.
// 4. Do Not Repeat Yourself (DRY).