package lecture_04_SOLID_Principle.dependency_inversion_principle.dip_violated;

// Low-level module
class MySQLDatabase {
    public void saveToSQL(String data) {
        System.out.println("Save data to sql database: " + data);
    }
}

// Low-level module
class MongoDBDatabase {
    public void saveToMongo(String data) {
        System.out.println("Save data to mongodb: " + data);
    }
}


// High-level module (Tightly coupled)
class UserService {
    private final MySQLDatabase sqlDB = new MySQLDatabase();             // Direct dependency on MySQL
    private final MongoDBDatabase mongoDB = new MongoDBDatabase();       // Direct dependency on MongoDB

    public void storeUserToSQL(String user) {
        // MySQL-specific code
        sqlDB.saveToSQL(user);
    }

    public void storeUserToMongo(String user) {
        // MongoDB-specific code
        mongoDB.saveToMongo(user);
    }
}


public class DIPViolated {
    static void main() {

        UserService service = new UserService();
        service.storeUserToSQL("Saksham");
        service.storeUserToMongo("Rohit");
    }
}
