package lecture_04_SOLID_Principle.liskov_substitution_principle.LSP_rules.method_rules.pre_conditions_rule;

// A Precondition must be satisfied before a method can be executed.
// Subclasses can weaken the precondition but cannot strengthen it.


class User {

    // Precondition: Password must be at least 8 characters long
    public void setPassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long!");
        }
        System.out.println("Password set successfully!");
    }
}

class AdminUser extends User {

    // Precondition: Password must be at least 6 characters
    @Override
    public void setPassword(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long!");
        }
        System.out.println("Password set successfully!");
    }
}


public class PreConditions {
    static void main() {

        User user = new User();
        User user1 = new AdminUser();

        user1.setPassword("Admin123");     // works fine: AdminUser allows shorter passwords
    }
}
