package lecture_11_Decorator_Design_Pattern;

// Definition:
// Decorator pattern attaches additional responsibilities to an object dynamically.
// Decorator provides a flexible alternative to subclassing for extending functionality.


// Component Interface: defines a common interface for Mario and all power-up decorators.
interface ICharacter {
    public String getAbilities();
}

// Concrete Component: Basic Mario character with no power-ups.
class Mario implements ICharacter {
    @Override
    public String getAbilities() {
        return "Mario";
    }
}


// Abstract Decorator: CharacterDecorator "is-a" character and "has-a" character.
abstract class CharacterDecorator implements ICharacter {
    protected ICharacter character;                            // Wrapped component

    public CharacterDecorator(ICharacter character) {
        this.character = character;
    }
}

// Concrete Decorator: Height-Increasing Power-Up.
class HeightUp extends CharacterDecorator {
    public HeightUp(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with HeightUp";
    }
}

// Concrete Decorator: Gun Shooting Power-Up.
class GunPowerUp extends CharacterDecorator {
    public GunPowerUp(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with Gun";
    }
}

// Concrete Decorator: Star Power-Up (temporary ability).
class StarPowerUp extends CharacterDecorator {
    public StarPowerUp(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with Star Power";
    }
}

public class DecoratorPattern {
    static void main() {

        // Create a basic Mario Character
        ICharacter mario = new Mario();
        System.out.println("Basic Character: " + mario.getAbilities());

        // Decorate Mario with a HeightUp power-up.
        mario = new HeightUp(mario);
        System.out.println("After HeightUp: " + mario.getAbilities());

        // Decorate Mario further with a GunPowerUp.
        mario = new GunPowerUp(mario);
        System.out.println("After GunPowerUp: " + mario.getAbilities());

        // Finally, add a StarPowerUp decoration.
        mario = new StarPowerUp(mario);
        System.out.println("After StarPowerUp: " + mario.getAbilities());
    }
}
