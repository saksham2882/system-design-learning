package lecture_15_Facade_Design_Pattern;

// Definition:
// Facade pattern provides a simplified, unified interface to a set of complex subsystem.
// It hides the complexity of the system and exposes only what is necessary.

class PowerSupply {
    public void providePower() {
        System.out.println("Power Supply: Providing power...");
    }
}

class CoolingSystem {
    public void startFans() {
        System.out.println("Cooling System: Fans started...");
    }
}

class CPU {
    public void initialize() {
        System.out.println("CPU: Initialization started...");
    }
}

class Memory {
    public void selfTest() {
        System.out.println("Memory: Self-test passed...");
    }
}

class HardDrive {
    public void spinUp() {
        System.out.println("Hard Drive: Spinning up...");
    }
}

class BIOS {
    public void boot(CPU cpu, Memory memory) {
        System.out.println("BIOS: Booting CPU and Memory checks...");
        cpu.initialize();
        memory.selfTest();
    }
}

class OperatingSystem {
    public void load() {
        System.out.println("Operating System: Loading into memory...");
    }
}

// Facade
class ComputerFacade {
    private final PowerSupply powerSupply = new PowerSupply();
    private final CoolingSystem coolingSystem = new CoolingSystem();
    private final CPU cpu = new CPU();
    private final Memory memory = new Memory();
    private final HardDrive hardDrive = new HardDrive();
    private final BIOS bios = new BIOS();
    private final OperatingSystem os = new OperatingSystem();

    public void startComputer() {
        System.out.println("========= Starting Computer =========");
        powerSupply.providePower();
        coolingSystem.startFans();
        bios.boot(cpu, memory);
        hardDrive.spinUp();
        os.load();
        System.out.println("Computer Booted Successfully!");
    }
}


// Main Client (Follow Principle of Least Knowledge)
public class FacadeDesignPattern {
    static void main() {

        ComputerFacade computerFacade = new ComputerFacade();
        computerFacade.startComputer();
    }
}
