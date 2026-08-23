package lecture_04_SOLID_Principle.dependency_inversion_principle.dip_followed;

interface Database {
    public void save(String data);
}

// MySQL implementation (Low-level module)
class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving data to MySQL Database: " + data);
    }
}

// MongoDB implementation (Low-level module)
class MongoDBDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving data to MongoDB Database: " + data);
    }
}


// High-level module (Now loosely coupled via Dependency Injection)
class UserService {
    private final Database database;

    public UserService(Database database) {
        this.database = database;
    }

    public void storeUser(String user) {
        database.save(user);
    }
}


public class DIPFollowed {
    static void main() {

        Database mysql = new MySQLDatabase();
        Database mongoDB = new MongoDBDatabase();

        UserService userService1 = new UserService(mysql);
        userService1.storeUser("Saksham");

        UserService userService2 = new UserService(mongoDB);
        userService2.storeUser("Rohit");
    }
}
