package lecture_13_Command_Design_Pattern;

// Definition:
// Encapsulate a Request as an Object, thereby letting you parameterize clients with different request, queue or log request and support undoable operations.


// ======= command Interface ========
interface Command {
    void execute();
    void undo();
}

// ======= Receivers =========
class Light {
    public void on(){
        System.out.println("Light is ON");
    }
    public void off(){
        System.out.println("Light is OFF");
    }
}

class Fan {
    public void on(){
        System.out.println("Fan is ON");
    }
    public void off(){
        System.out.println("Fan is OFF");
    }
}


// ======== Concrete Command for Light =========
class LightCommand implements Command {
    private final Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

// ======== Concrete Command for Fan ========
class FanCommand implements Command {
    private final Fan fan;

    public FanCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.off();
    }

    @Override
    public void undo() {
        fan.off();
    }
}


// ====== Invoker: Remote Controller with static array of 4 buttons
class RemoteController {
    private static final int numButtons = 4;
    private Command[] buttons;
    private boolean[] buttonPressed;

    public RemoteController() {
        buttons = new Command[numButtons];
        buttonPressed = new boolean[numButtons];

        for (int i = 0; i < numButtons; i++) {
            buttons[i] = null;
            buttonPressed[i] = false;      // false = off, true = on
        }
    }

    public void setCommand(int index, Command command) {
        if(index >= 0 && index < numButtons) {
            buttons[index] = command;
            buttonPressed[index] = false;
        }
    }

    public void pressButton(int buttonIndex) {
        if(buttonIndex >= 0 && buttonIndex < numButtons && buttons[buttonIndex] != null) {
            if(!buttonPressed[buttonIndex]) {
                buttons[buttonIndex].execute();
            } else {
                buttons[buttonIndex].undo();
            }

            buttonPressed[buttonIndex] = !buttonPressed[buttonIndex];
        } else {
            System.out.println("No command assigned at button " + buttonIndex);
        }
    }
}


public class CommandDesignPattern {
    static void main() {

        Light light = new Light();
        Fan fan = new Fan();

        RemoteController remote = new RemoteController();

        remote.setCommand(0, new LightCommand(light));
        remote.setCommand(1, new FanCommand(fan));

        System.out.println("=========== Toggling Light Button 0 ============");
        remote.pressButton(0);     // ON
        remote.pressButton(0);     // OFF

        System.out.println("=========== Toggling Fan Button 1 ============");
        remote.pressButton(1);
        remote.pressButton(1);

        // Press unassigned button to show default message
        System.out.println("=========== Pressing Unassigned Button ============");
        remote.pressButton(8);
    }
}
