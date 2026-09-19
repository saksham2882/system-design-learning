package lecture_20_Chain_of_Responsibility_Pattern;

// Definition:
// Allow an object to pass a request along a chain of potential handlers.
// Each handler in the chain decides either to process the request ot pass it to the next handler.

abstract class MoneyHandler {
    protected MoneyHandler nextHandler;

    public MoneyHandler(){
        this.nextHandler = null;
    }

    public void setNextHandler(MoneyHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public abstract void dispense(int amount);
}


class ThousandMoneyHandler extends MoneyHandler {
    private int numNotes;

    public ThousandMoneyHandler(int numNotes){
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 1000;

        if (notesNeeded > numNotes){
            notesNeeded = numNotes;
            numNotes = 0;
        } else {
            numNotes -=  notesNeeded;
        }

        if (notesNeeded > 0){
            System.out.println("Dispensing " + notesNeeded + " x Rs.1000 notes.");
        }

        int remainingAmount = amount - (notesNeeded * 1000);
        if (remainingAmount > 0) {
            if (nextHandler != null) {
                nextHandler.dispense(remainingAmount);
            } else {
                System.out.println("Remaining amount of " + remainingAmount + " cannot be fulfilled (Insufficient fund in ATM)");
            }
        }
    }
}

class FiveHundredHandler extends MoneyHandler {
    private int numNotes;

    public FiveHundredHandler(int numNotes) {
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 500;

        if (notesNeeded > numNotes) {
            notesNeeded = numNotes;
            numNotes = 0;
        } else {
            numNotes -= notesNeeded;
        }

        if (notesNeeded > 0) {
            System.out.println("Dispensing " + notesNeeded + " x Rs.500 notes.");
        }

        int remainingAmount = amount - (notesNeeded * 500);
        if (remainingAmount > 0) {
            if (nextHandler != null) {
                nextHandler.dispense(remainingAmount);
            } else {
                System.out.println("Remaining amount of " + remainingAmount + " cannot be fulfilled (Insufficinet fund in ATM)");
            }
        }
    }
}

class TwoHundredHandler extends MoneyHandler {
    private int numNotes;

    public TwoHundredHandler(int numNotes) {
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 200;

        if (notesNeeded > numNotes) {
            notesNeeded = numNotes;
            numNotes = 0;
        } else {
            numNotes -= notesNeeded;
        }

        if (notesNeeded > 0) {
            System.out.println("Dispensing " + notesNeeded + " x Rs.200 notes.");
        }

        int remainingAmount = amount - (notesNeeded * 200);
        if (remainingAmount > 0) {
            if (nextHandler != null) {
                nextHandler.dispense(remainingAmount);
            } else {
                System.out.println("Remaining amount of " + remainingAmount + " cannot be fulfilled (Insufficinet fund in ATM)");
            }
        }
    }
}

class HundredHandler extends MoneyHandler {
    private int numNotes;

    public HundredHandler(int numNotes) {
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 100;

        if (notesNeeded > numNotes) {
            notesNeeded = numNotes;
            numNotes = 0;
        } else {
            numNotes -= notesNeeded;
        }

        if (notesNeeded > 0) {
            System.out.println("Dispensing " + notesNeeded + " x Rs.100 notes.");
        }

        int remainingAmount = amount - (notesNeeded * 100);
        if (remainingAmount > 0) {
            if (nextHandler != null) {
                nextHandler.dispense(remainingAmount);
            } else {
                System.out.println("Remaining amount of " + remainingAmount + " cannot be fulfilled (Insufficinet fund in ATM)");
            }
        }
    }
}


public class CORPattern {
    static void main() {

        MoneyHandler thousandMoneyHandler = new ThousandMoneyHandler(3);
        MoneyHandler fiveHundredMoneyHandler = new FiveHundredHandler(5);
        MoneyHandler twoHundredMoneyHandler = new TwoHundredHandler(10);
        MoneyHandler hundredMoneyHandler = new HundredHandler(10);

        thousandMoneyHandler.setNextHandler(fiveHundredMoneyHandler);
        fiveHundredMoneyHandler.setNextHandler(twoHundredMoneyHandler);
        twoHundredMoneyHandler.setNextHandler(hundredMoneyHandler);

        int amountToWithdraw = 6000;

        System.out.println("\nDispensing amount: Rs." + amountToWithdraw);
        thousandMoneyHandler.dispense(amountToWithdraw);
    }
}
